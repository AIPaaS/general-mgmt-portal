package com.ai.slp.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.ai.paas.ipaas.mcs.interfaces.ICacheClient;
import com.ai.slp.common.api.cache.param.Area;
import com.ai.slp.common.constants.CacheNSMapper;
import com.ai.slp.common.dao.mapper.bo.GnArea;
import com.alibaba.fastjson.JSON;

/**
 * Area
 *
 * Date: 2015年11月11日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * @author gucl
 */
public final class AreaCacheUtil {

    private AreaCacheUtil() {
    }

    private static final Logger logger = LoggerFactory.getLogger(AreaCacheUtil.class);

    public static String getAreaName(String areaCode) {
        try {
            if (StringUtils.isEmpty(areaCode)) {
                return null;
            }
            String key=areaCode.toUpperCase();
            ICacheClient cacheClient = CacheFactoryUtil.getCacheClient(CacheNSMapper.CACHE_GN_AREA);
            String data=cacheClient.hget(CacheNSMapper.CACHE_GN_AREA, key);
            GnArea result = JSON.parseObject(data, GnArea.class);
            return result.getAreaName();
        } catch (Exception e) {
            logger.error("翻译区域AreaCode[{}]失败.失败原因:{}", areaCode, e);
            return areaCode;
        }
    }
    public static Area getArea(String areaCode) {
    	try {
    		
    		if (StringUtils.isEmpty(areaCode)) {
    			return null;
    		}
    		String key=areaCode.toUpperCase();
    		ICacheClient cacheClient = CacheFactoryUtil.getCacheClient(CacheNSMapper.CACHE_GN_AREA);
    		String data=cacheClient.hget(CacheNSMapper.CACHE_GN_AREA, key);
            return  JSON.parseObject(data, Area.class);
    	} catch (Exception e) {
    		logger.error("获取区域Area[{}]失败.失败原因:{}", areaCode, e);
    	    return null;
    	}
    }

    public static void updateAreaCacheData(GnArea area) {
        try {
            ICacheClient cacheClient = CacheFactoryUtil.getCacheClient(CacheNSMapper.CACHE_GN_AREA);
            String key=area.getAreaCode().toUpperCase();
            cacheClient.hset(CacheNSMapper.CACHE_GN_AREA, key, JSON.toJSONString(area));
        } catch (Exception e) {
            logger.error("更新区域缓存失败，失败原因:{}", e);
        }
    }
}
