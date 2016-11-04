package com.ai.platform.modules.sys.task;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ai.platform.common.utils.DateUtils;
import com.ai.platform.modules.sys.service.GnAreaService;
import com.ai.platform.modules.sys.service.OfficeService;
import com.ai.platform.modules.sys.service.SystemService;

@Service
@Lazy(false)
@PropertySource("classpath:mgmt.properties")
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

	public static ExecutorService handlePool;

	@Scheduled(cron = "${jobs.scheduled}")
	public void hrImportJob() {
		run();
	}

	public void run() {
		LOG.error("任务开始执行，当前时间戳："+DateUtils.getDateTime());
		try {
			handlePool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
			userQueue = new LinkedBlockingQueue<String[]>(1000);
			officeQueue = new LinkedBlockingQueue<String[]>(1000);

			handlePool.execute(new ReadFileThred(userQueue, officeQueue));
			while (true) {
				String[] office = officeQueue.poll(200, TimeUnit.SECONDS);
				if (null == office) {
					break;
				}
				handlePool.execute(new OfficeThread(office, officeService, areaService));
			}
			while (true) {
				String[] user = userQueue.poll(200, TimeUnit.SECONDS);
				if (null == user) {
					break;
				}
				handlePool.execute(new UserThead(user, officeService, systemService));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			handlePool.shutdown();
			LOG.error("任务开始结束，当前时间戳："+DateUtils.getDateTime());
		}
	}

}
