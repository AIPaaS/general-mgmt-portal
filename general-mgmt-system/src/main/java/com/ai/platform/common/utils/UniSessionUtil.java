package com.ai.platform.common.utils;

import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UniSessionUtil {
	private static final Log LOG = LogFactory.getLog(UniSessionUtil.class);
	private static String SESSION_PAAS_NAMESPACE  ;
    private static final String PROPERTIES_FILE_NAME = "unisession";
    private static final String PROPERTIES_KEY = "SESSION_PAAS_NAMESPACE";
    
    public static String getSessionPassNameSpace() {
    	LOG.debug("【-_-】SessionClient.getSessionPassNameSpace() begin...");
    	if(SESSION_PAAS_NAMESPACE == null) {
    		try {
    			ResourceBundle bundle = ResourceBundle.getBundle(PROPERTIES_FILE_NAME);
    			SESSION_PAAS_NAMESPACE = bundle.getString(PROPERTIES_KEY).trim();
    			LOG.debug("【-_-】统一缓存命名空间为配置值:"+SESSION_PAAS_NAMESPACE+"【-_-】");
    		}
    		catch(Exception ex) {
    			LOG.error( "Can't Load unisession.properties...",ex);
    		}
    	}
    	LOG.debug("【-_-】SessionClient.getSessionPassNameSpace() 统一缓存命名空间为配置值："+SESSION_PAAS_NAMESPACE);
    	return SESSION_PAAS_NAMESPACE;
    }
}
