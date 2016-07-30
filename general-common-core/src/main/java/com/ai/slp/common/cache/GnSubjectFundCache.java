package com.ai.slp.common.cache;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.sdk.cache.base.AbstractCache;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.paas.ipaas.mcs.interfaces.ICacheClient;
import com.ai.slp.common.constants.CacheNSMapper;
import com.ai.slp.common.dao.mapper.bo.GnSubjectFund;
import com.ai.slp.common.service.business.subject.IGnSubjectBusiSV;
import com.ai.slp.common.util.CacheFactoryUtil;
import com.ai.slp.common.util.GnSubjectUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 资金科目定义表FUN_SUBJECT_FUND <br>
 * 缓存key为subjectId 缓存对象FUN_SUBJECT_FUND <br>
 * Date: 2015年8月19日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
@Component
public class GnSubjectFundCache extends AbstractCache {

    private static final Logger logger = LogManager.getLogger(GnSubjectFundCache.class);

    @Autowired
    private IGnSubjectBusiSV funSubjectBusiSV;

    @Override
    public void write() throws Exception {
        List<GnSubjectFund> funSubjectFundList = funSubjectBusiSV.queryGnSubjectFund();
        if (CollectionUtil.isEmpty(funSubjectFundList)) {
            return;
        }
        ICacheClient cacheClient = CacheFactoryUtil
                .getCacheClient(CacheNSMapper.CACHE_GN_SUBJECT_FUND);
        for (GnSubjectFund funSubjectFund : funSubjectFundList) {
            logger.info("缓存GnSubjectFund资金科目定义:行业{},租户ID{},科目ID{}",
                    funSubjectFund.getIndustryCode(), funSubjectFund.getTenantId(),
                    funSubjectFund.getSubjectId());
            String key = GnSubjectUtil.generateKey(funSubjectFund.getIndustryCode(),
                    funSubjectFund.getTenantId(), funSubjectFund.getSubjectId());
            JSONObject subjectJson = JSON.parseObject(JSON.toJSONString(funSubjectFund));
            cacheClient.hset(CacheNSMapper.CACHE_GN_SUBJECT_FUND, key, subjectJson.toJSONString());
        }
    }

}
