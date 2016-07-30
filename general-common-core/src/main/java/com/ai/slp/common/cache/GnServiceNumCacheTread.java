package com.ai.slp.common.cache;

import java.util.List;

import com.ai.paas.ipaas.mcs.interfaces.ICacheClient;
import com.ai.slp.common.constants.CacheNSMapper;
import com.ai.slp.common.dao.mapper.bo.GnServiceNum;
import com.ai.slp.common.util.CacheFactoryUtil;
import com.alibaba.fastjson.JSON;

public class GnServiceNumCacheTread extends Thread{
    private List<GnServiceNum> resultList;
    ICacheClient cacheClient = CacheFactoryUtil.getCacheClient(CacheNSMapper.CACHE_GN_SERVICE_NUM);
    
    public GnServiceNumCacheTread(List<GnServiceNum> resultList){
        this.resultList=resultList;
    }
    @Override
    public void run() {
    	System.out.println("开始刷新缓存"+"【"+Thread.currentThread().getName()+"】");
        for (GnServiceNum svnum : resultList) {          
            String key=svnum.getServiceNumCode().toUpperCase();
            cacheClient.hset(CacheNSMapper.CACHE_GN_SERVICE_NUM, key, JSON.toJSONString(svnum));
        } 
        //System.out.println("【"+Thread.currentThread().getName()+"】");
        System.out.println("刷新缓存OK"+"【"+Thread.currentThread().getName()+"】");
    } 
}
