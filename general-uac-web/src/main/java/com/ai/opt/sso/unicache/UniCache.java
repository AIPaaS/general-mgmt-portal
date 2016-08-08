package com.ai.opt.sso.unicache;

import com.ai.paas.ipaas.mcs.interfaces.ICacheClient;

/**
 * 统一缓存处理封装类
 * 
 * @author kanghc
 * 
 */
public final class UniCache {
	
	private UniCache(){}

	/**
	 * 根据配置的命名获取对应缓存实例
	 * 
	 * @return
	 */
	public static ICacheClient getCache() {
		return UniCacheFactory.getCacheClient(UniCacheConstants.CacheNamespaces.SSOCache);
	}

	/**
	 * 测试统一session
	 * 
	 * @param sessionId
	 * @return
	 */
	/*public static String getSessionCache(String sessionId) {
		return UniCacheFactory.getCacheClient(UniCacheConstants.CacheNamespaces.sessionCache).hget(UniCacheConstants._UniCache_PaaS_Session+sessionId, "");
	}*/

}