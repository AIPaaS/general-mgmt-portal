package com.ai.platform.modules.sys.task;

import java.util.List;

import org.apache.log4j.Logger;

import com.ai.opt.sdk.dubbo.util.HttpClientUtil;
import com.ai.platform.common.utils.DateUtils;
import com.ai.platform.modules.sys.entity.GnTabSystem;
import com.ai.platform.modules.sys.service.GnTabSystemService;

public class NotifySystemLogOutThread extends Thread {
	private static final Logger LOG = Logger.getLogger(NotifySystemLogOutThread.class);
	
	private GnTabSystemService gnTabSystemService;
	public NotifySystemLogOutThread(GnTabSystemService gnTabSystemService){
		this.gnTabSystemService =gnTabSystemService;
	}

	public void run() {
		try {
			LOG.info("通知各中心退出系统开始："+DateUtils.getDateTime());
			List<GnTabSystem> listSystem = gnTabSystemService.findAll(); 
			for(GnTabSystem system:listSystem){
				HttpClientUtil.sendPost(system.getSystemUrlContext()+"/logout","");
			}
			LOG.info("通知各中心退出系统结束："+DateUtils.getDateTime());
		} catch (Exception e) {
			LOG.info("通知各中心退出系统失败："+DateUtils.getDateTime());
		}
		
	}

}
