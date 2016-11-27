package com.ai.platform.modules.sys.task;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ai.opt.sdk.components.lock.AbstractMutexLock;
import com.ai.opt.sdk.components.lock.RedisMutexLockFactory;
import com.ai.platform.common.utils.DateUtils;
import com.ai.platform.modules.sys.service.GnAreaService;
import com.ai.platform.modules.sys.service.OfficeService;
import com.ai.platform.modules.sys.service.SystemService;
import com.ai.platform.modules.sys.utils.OfficeUtils;

@Service
@Lazy(false)
public class HrTaskJob {
	private static final Logger LOG = Logger.getLogger(HrTaskJob.class);
	@Autowired
	OfficeService officeService;
	@Autowired
	SystemService systemService;
	@Autowired
	GnAreaService areaService;

	public static BlockingQueue<String[]> userQueue;
	public static BlockingQueue<String[]> officeQueue;
	public static BlockingQueue<String[]> officeRepeatQueue;
	

	public static ExecutorService handlePool;
	private final String REDISKEY="redislock.importhrinfo";

//	@Scheduled(cron = "${jobs.scheduled}")
	public void hrImportJob() {
		AbstractMutexLock lock=null;
        boolean lockflag=false;
        try{
        	lock=RedisMutexLockFactory.getRedisMutexLock(REDISKEY);
        	//lock.acquire();//争锁，无限等待
        	lockflag=lock.acquire(10, TimeUnit.SECONDS);//争锁，超时时间10秒。
        	if(lockflag){
        		LOG.info("SUCESS线程【"+Thread.currentThread().getName()+"】获取到分布式锁，执行任务");
        		run();
        	}else{
        		LOG.info("FAILURE线程【"+Thread.currentThread().getName()+"】未获取到分布式锁，不执行任务");
        	}
        } catch (Exception e) {
        	LOG.error("获取分布式锁出错："+e.getMessage(),e);
		} finally {
    		try {
				lock.release();
				LOG.info("释放分布式锁OK");
			} catch (Exception e) {
				LOG.error("释放分布式锁出错："+e.getMessage(),e);
			}
        }
	}

	public void run() {
		LOG.info("任务开始执行，当前时间戳："+DateUtils.getDateTime());
		boolean isSynchronize =false;
		try {
			handlePool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
			userQueue = new LinkedBlockingQueue<String[]>(1000);
			officeQueue = new LinkedBlockingQueue<String[]>();
			officeRepeatQueue = new LinkedBlockingQueue<String[]>();

			handlePool.execute(new SftpReadFileThred(userQueue, officeQueue,officeRepeatQueue));
			while (true) {
				LOG.info("部门信息开始导入，当前时间戳："+DateUtils.getDateTime());
				String[] office = officeQueue.poll(30, TimeUnit.SECONDS);
				if (null == office) {
					break;
				}
				LOG.info("部门名称:"+office[1]);
				handlePool.execute(new OfficeThread(office, officeService, areaService));
				isSynchronize =true;
			}
			while (true) {
				LOG.info("部门信息开始更新，当前时间戳："+DateUtils.getDateTime());
				String[] office = officeRepeatQueue.poll(30, TimeUnit.SECONDS);
				if (null == office) {
					break;
				}
				LOG.info("部门名称:"+office[1]);
				handlePool.execute(new OfficeThread(office, officeService, areaService));
			}
			while (true) {
				LOG.info("员工信息开始导入，当前时间戳："+DateUtils.getDateTime());
				String[] user = userQueue.poll(30, TimeUnit.SECONDS);
				if (null == user) {
					break;
				}
				LOG.info("员工姓名:"+user[2]);
				handlePool.execute(new UserThead(user, officeService, systemService));
			}
		} catch (Exception e) {
			LOG.error("任务执行出错："+e.getMessage(),e);
		} finally {
			handlePool.shutdown();
			if(isSynchronize)
				OfficeUtils.removeOfficeCache();
			LOG.info("任务结束，当前时间戳："+DateUtils.getDateTime());
		}
	}

}
