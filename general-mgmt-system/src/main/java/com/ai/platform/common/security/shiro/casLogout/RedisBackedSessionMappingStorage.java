package com.ai.platform.common.security.shiro.casLogout;

import java.io.Serializable;

import org.apache.shiro.session.Session;

import com.ai.opt.sdk.components.mcs.MCSClientFactory;
import com.ai.opt.uni.session.impl.SessionClient;
import com.ai.paas.ipaas.mcs.interfaces.ICacheClient;

/**
 * 存储ticket到sessionID的映射
 */
public final class RedisBackedSessionMappingStorage {
	private final static ICacheClient jedis = MCSClientFactory.getCacheClient(SessionClient.getSessionPassNameSpace());
	private String MAPPINGID_KEY_SESSION = "mappingid_key_session";
    /**
     * Maps the ID from the CAS server to the Session ID.
     */

	public synchronized void addSessionById(String mappingId, Session session) {
		jedis.hset(MAPPINGID_KEY_SESSION, mappingId, session.getId().toString());

	}                               

	public synchronized Serializable getSessionIDByMappingId(String mappingId) {
        return jedis.hget(MAPPINGID_KEY_SESSION,mappingId);
	}
}
