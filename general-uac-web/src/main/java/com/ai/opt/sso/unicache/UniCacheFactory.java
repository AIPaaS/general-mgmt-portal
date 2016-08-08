package com.ai.opt.sso.unicache;

import org.springframework.stereotype.Component;

import com.ai.opt.sdk.components.mcs.MCSClientFactory;
import com.ai.paas.ipaas.mcs.interfaces.ICacheClient;


@Component
public class UniCacheFactory {

    public static ICacheClient getCacheClient(String namespace) {
    	return MCSClientFactory.getCacheClient(namespace);
    }
    
}
