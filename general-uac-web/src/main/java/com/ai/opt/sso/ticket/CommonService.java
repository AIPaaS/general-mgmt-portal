package com.ai.opt.sso.ticket;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;

import com.ai.opt.sso.unicache.UniCache;
import com.ai.opt.sso.util.SerializeUtil;
import com.ai.paas.ipaas.mcs.interfaces.ICacheClient;

public final class CommonService {
	private static final Logger LOG = Logger.getLogger(CommonService.class);
	private static final String CHARSET = "UTF-8";
	private static CommonService instance;
	private CommonService(){}
	
	public static synchronized CommonService getInstance(){
		if(instance == null){
			instance = new CommonService();
		}
		return instance;
	}
	
	public ICacheClient getCache(){
		return UniCache.getCache();
		//return RedisClient.getInstance().getJedis();
	}
	
	public Object getValue(String key) {
		Object val = null;
		try {
			byte[] data = getCache().get(key.getBytes(CHARSET));
			val = SerializeUtil.unserialize(data);
		} catch (Exception e) {
			LOG.error("获取 obj 失败",e);
		}
		return val;
	}

	public void removeObj(String key) {
		try {
			getCache().del(key.getBytes(CHARSET));
		} catch (UnsupportedEncodingException e) {
			LOG.error("删除 obj 失败",e);
		}
	}

	public void saveObj(String key,
			Object obj, int maxInactiveInterval) {
		try {
			getCache().set(key.getBytes(CHARSET), SerializeUtil.serialize(obj));
			getCache().expire(key.getBytes(CHARSET), maxInactiveInterval);
		} catch (IOException e) {
			LOG.error("obj 保存至redis异常",e);
		}
	}

	public void saveObj(String key, String ticketId) {
		try {
			getCache().set(key.getBytes(CHARSET), SerializeUtil.serialize(ticketId));
		} catch (IOException e) {
			LOG.error("obj 保存至redis异常：",e);
		}
	}
}
