package com.ai.platform.modules.sys.task;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ai.platform.modules.sys.service.GnAreaService;
import com.ai.platform.modules.sys.service.OfficeService;
import com.ai.platform.modules.sys.service.SystemService;

@Service
@Lazy(false)
@PropertySource("classpath:mgmt.properties")
public class HrTaskJob {
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
		try {
			handlePool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
			userQueue = new LinkedBlockingQueue<String[]>(1000);
			officeQueue = new LinkedBlockingQueue<String[]>(1000);

			handlePool.execute(new ReadFileThred(userQueue, officeQueue));
			while (true) {
				String[] office = officeQueue.poll(10, TimeUnit.SECONDS);
				if (null == office) {
					break;
				}
				handlePool.execute(new OfficeThread(office, officeService, areaService));
			}
			while (true) {
				String[] user = userQueue.poll(10, TimeUnit.SECONDS);
				if (null == user) {
					break;
				}
				handlePool.execute(new UserThead(user, officeService, systemService));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			handlePool.shutdown();
		}
	}

}
