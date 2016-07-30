package com.ai.slp.common.util;

import java.util.List;

import com.ai.paas.ipaas.mcs.interfaces.ICacheClient;
import com.ai.paas.ipaas.util.StringUtil;
import com.ai.slp.common.api.cache.param.SysParam;
import com.ai.slp.common.constants.CacheNSMapper;
import com.ai.slp.common.constants.Constants;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

public final class SysParamUtil {
    private SysParamUtil() {
    }

    public static List<SysParam> getSysParams(String tenantId, String typeCode, String paramCode) {
        ICacheClient cacheClient = CacheFactoryUtil
                .getCacheClient(CacheNSMapper.CACHE_GN_SYS_PARAM);
        String key = (typeCode + "." + paramCode + "." + tenantId).toUpperCase();
        String data = cacheClient.hget(CacheNSMapper.CACHE_GN_SYS_PARAM, key);
        if(StringUtil.isBlank(data)){//若查不到数据，则查询租户为ALL的缓存
        	key=(typeCode + "." + paramCode + "." + Constants.TenantId.ALL_TENANT).toUpperCase();
        	data = cacheClient.hget(CacheNSMapper.CACHE_GN_SYS_PARAM, key);
        }
        return JSONArray.parseArray(data, SysParam.class);
    }

    public static SysParam getSysParam(String tenantId, String typeCode, String paramCode,
            String columnValue) {
        ICacheClient cacheClient = CacheFactoryUtil
                .getCacheClient(CacheNSMapper.CACHE_GN_SYS_PARAM);
        String key = (typeCode + "." + paramCode + "." + tenantId + "." + columnValue)
                .toUpperCase();
        String data = cacheClient.hget(CacheNSMapper.CACHE_GN_SYS_PARAM, key);
        if(StringUtil.isBlank(data)){//若查不到数据，则查询租户为ALL的缓存
        	key=(typeCode + "." + paramCode + "." + Constants.TenantId.ALL_TENANT + "." + columnValue).toUpperCase();
        	data = cacheClient.hget(CacheNSMapper.CACHE_GN_SYS_PARAM, key);
        }
        return JSON.parseObject(data, SysParam.class);
    }

    public static String getSysParamDesc(String tenantId, String typeCode, String paramCode,
            String columnValue) {
        SysParam sysParam = getSysParam(tenantId, typeCode, paramCode, columnValue);
        return sysParam == null ? "" : sysParam.getColumnDesc();
    }

}
