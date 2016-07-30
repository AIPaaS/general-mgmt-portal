package com.ai.slp.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.paas.ipaas.mcs.interfaces.ICacheClient;
import com.ai.slp.common.api.servicenum.param.ServiceNum;
import com.ai.slp.common.constants.CacheNSMapper;
import com.ai.slp.common.dao.mapper.bo.GnServiceNum;
import com.alibaba.fastjson.JSON;

/**
 * Area
 *
 * Date: 2015年11月11日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * @author gucl
 */
public final class ServiceNumCacheUtil {

    private ServiceNumCacheUtil() {
    }

    private static final Logger logger = LoggerFactory.getLogger(ServiceNumCacheUtil.class);
    
    public static ServiceNum getServiceNum(String serviceNumCode) {
    	try {
    		
    		if (StringUtils.isEmpty(serviceNumCode)) {
    			return null;
    		}
    		if(serviceNumCode.length()>7){
    			serviceNumCode=serviceNumCode.substring(0, 7);
    		}
    		String key=serviceNumCode.toUpperCase();
    		ICacheClient cacheClient = CacheFactoryUtil.getCacheClient(CacheNSMapper.CACHE_GN_SERVICE_NUM);
    		String data=cacheClient.hget(CacheNSMapper.CACHE_GN_SERVICE_NUM, key);
            return  JSON.parseObject(data, ServiceNum.class);
    	} catch (Exception e) {
    		logger.error("获取手机号码端数据[{}]失败.失败原因:{}", serviceNumCode, e.getMessage(),e);
    	    return null;
    	}
    }

    public static void updateGnServiceNumCacheData(GnServiceNum gnServiceNum) {
        try {
        	ServiceNum serviceNum=new ServiceNum();
        	if(gnServiceNum!=null){
        		BeanUtils.copyProperties(serviceNum, gnServiceNum);
        		updateServiceNumCacheData(serviceNum);
        		
        	}
        } catch (Exception e) {
            logger.error("更新手机号码端数据缓存失败，失败原因:{}", e);
        }
    }
    public static void updateServiceNumCacheData(ServiceNum serviceNum) {
    	try {
    		ICacheClient cacheClient = CacheFactoryUtil.getCacheClient(CacheNSMapper.CACHE_GN_SERVICE_NUM);
    		String key=serviceNum.getServiceNumCode().toUpperCase();
    		cacheClient.hset(CacheNSMapper.CACHE_GN_SERVICE_NUM, key, JSON.toJSONString(serviceNum));
    	} catch (Exception e) {
    		logger.error("更新手机号码端数据缓存失败，失败原因:{}", e);
    	}
    }
}
