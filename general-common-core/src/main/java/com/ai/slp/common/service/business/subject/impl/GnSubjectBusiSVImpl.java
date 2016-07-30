package com.ai.slp.common.service.business.subject.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.paas.ipaas.mcs.interfaces.ICacheClient;
import com.ai.slp.common.api.subjectmaintain.param.GnSubjectCondition;
import com.ai.slp.common.api.subjectmaintain.param.GnSubjectFundVo;
import com.ai.slp.common.api.subjectmaintain.param.GnSubjectKeyParam;
import com.ai.slp.common.api.subjectmaintain.param.GnSubjectVo;
import com.ai.slp.common.constants.CacheNSMapper;
import com.ai.slp.common.constants.Constants;
import com.ai.slp.common.dao.mapper.bo.GnSettleRuleKey;
import com.ai.slp.common.dao.mapper.bo.GnSubject;
import com.ai.slp.common.dao.mapper.bo.GnSubjectFund;
import com.ai.slp.common.dao.mapper.bo.GnSubjectFundKey;
import com.ai.slp.common.dao.mapper.bo.GnSubjectKey;
import com.ai.slp.common.service.atom.subject.IGnSettleRuleAtomSV;
import com.ai.slp.common.service.atom.subject.IGnSubjectAtomSV;
import com.ai.slp.common.service.atom.subject.IGnSubjectFundAtomSV;
import com.ai.slp.common.service.business.subject.IGnSubjectBusiSV;
import com.ai.slp.common.util.CacheFactoryUtil;
import com.ai.slp.common.util.GnSubjectUtil;
import com.alibaba.fastjson.JSON;

@Service
@Transactional
public class GnSubjectBusiSVImpl implements IGnSubjectBusiSV {

    @Autowired
    private IGnSubjectAtomSV gnSubjectSV;

    @Autowired
    private IGnSubjectFundAtomSV gnSubjectFundSV;

    @Autowired
    private IGnSettleRuleAtomSV gnSettleRuleAtomSV;

    @Override
    public GnSubject queryGnSubject(String tenantId, String industryCode, long subjectId)
            throws BusinessException {
        return gnSubjectSV.queryGnSubject(tenantId, industryCode, subjectId);
    }

    @Override
    public List<GnSubject> queryGnSubject() throws BusinessException {
        return gnSubjectSV.queryGnSubject();
    }

    @Override
    public GnSubjectFund queryGnSubjectFund(String tenantId, String industryCode, long subjectId)
            throws BusinessException {
        return gnSubjectFundSV.queryGnSubjectFund(tenantId, industryCode, subjectId);
    }

    @Override
    public List<GnSubjectFund> queryGnSubjectFund() throws BusinessException {
        return gnSubjectFundSV.queryGnSubjectFund();
    }

    @Override
    public List<GnSettleRuleKey> queryGnSettleRule(String tenantId, String industryCode,
            long subjectId) throws BusinessException {
        return gnSettleRuleAtomSV.queryGnSettleRule(tenantId, industryCode, subjectId);
    }

    @Override
    public List<GnSettleRuleKey> queryGnSettleRule() throws BusinessException {
        return gnSettleRuleAtomSV.queryGnSettleRule();
    }

    @Override
    public void addSubject(GnSubjectVo vo) throws BusinessException {
        // 1.校验ID是否存在
        GnSubject exist = gnSubjectSV.queryGnSubject(vo.getTenantId(), vo.getIndustryCode(),
                vo.getSubjectId());
        if (exist != null) {
            throw new BusinessException(ExceptCodeConstants.Special.SYSTEM_ERROR, "科目ID已经存在");
        }
        // 2.转换参数
        GnSubject subject = new GnSubject();
        BeanUtils.copyProperties(subject, vo);
        subject.setCreateOperId(vo.getOperId());
        subject.setCreateTime(DateUtil.getSysDate());
        // 3.插入科目
        gnSubjectSV.addSubject(subject);
        // TODO 刷新缓存
        this.refreshCache(subject.getTenantId(), subject.getIndustryCode(), subject.getSubjectId());
    }

    @Override
    public void addSubjectFund(GnSubjectFundVo vo) throws BusinessException {
        // 1.校验科目是否存在
        GnSubject subject = gnSubjectSV.queryGnSubject(vo.getTenantId(), vo.getIndustryCode(),
                vo.getSubjectId());
        if (subject == null) {
            throw new BusinessException(ExceptCodeConstants.Special.SYSTEM_ERROR, "科目不存在");
        }
        // 1.校验ID是否存在
        GnSubjectFund exist = gnSubjectFundSV.queryGnSubjectFund(vo.getTenantId(),
                vo.getIndustryCode(), vo.getSubjectId());
        if (exist != null) {
            throw new BusinessException(ExceptCodeConstants.Special.SYSTEM_ERROR, "相同资金属性已经存在");
        }
        // 3.转换参数
        GnSubjectFund subjectFund = new GnSubjectFund();
        BeanUtils.copyProperties(subjectFund, vo);
        // 2.插入资金科目详细
        gnSubjectFundSV.addSubjectFund(subjectFund);
        // TODO 刷新缓存
    }

    @Override
    public void delSubject(GnSubjectKeyParam param) throws BusinessException {
        // 1.校验ID是否存在
        GnSubject exist = gnSubjectSV.queryGnSubject(param.getTenantId(), param.getIndustryCode(),
                param.getSubjectId());
        if (exist == null) {
            throw new BusinessException(ExceptCodeConstants.Special.SYSTEM_ERROR, "科目不存在");
        }
        // 2.删除科目
        GnSubjectKey key = new GnSubjectKey();
        BeanUtils.copyProperties(key, param);
        gnSubjectSV.delSubject(key);
        // 3.删除资金定义
        GnSubjectFundKey fundKey = JSON.parseObject(JSON.toJSONString(key), GnSubjectFundKey.class);
        gnSubjectFundSV.delSubjectFund(fundKey);
        // TODO 刷新缓存
        this.refreshCache(key.getTenantId(), key.getIndustryCode(), key.getSubjectId());
    }

    @Override
    public void delSubjectFund(GnSubjectKeyParam param) throws BusinessException {
        // 1.校验ID是否存在
        GnSubjectFund exist = gnSubjectFundSV.queryGnSubjectFund(param.getTenantId(),
                param.getIndustryCode(), param.getSubjectId());
        if (exist == null) {
            throw new BusinessException(ExceptCodeConstants.Special.SYSTEM_ERROR, "资金科目属性不存在");
        }
        // 2.删除资金科目定义
        GnSubjectFundKey key = new GnSubjectFundKey();
        BeanUtils.copyProperties(key, param);
        gnSubjectFundSV.delSubjectFund(key);
        // TODO 刷新缓存
    }

    @Override
    public void modSubject(GnSubjectVo vo) throws BusinessException {
        // 1.校验ID是否存在
        GnSubject exist = gnSubjectSV.queryGnSubject(vo.getTenantId(), vo.getIndustryCode(),
                vo.getSubjectId());
        if (exist == null) {
            throw new BusinessException(ExceptCodeConstants.Special.SYSTEM_ERROR, "科目不存在");
        }
        // 2.修改科目
        GnSubject subject = new GnSubject();
        BeanUtils.copyProperties(subject, vo);
        GnSubjectKey key = new GnSubjectKey();
        BeanUtils.copyProperties(key, vo);
        gnSubjectSV.modSubject(subject, key);
        // TODO 刷新缓存
        // 删除缓存
        this.refreshCache(key.getTenantId(), key.getIndustryCode(), key.getSubjectId());
        // 加载缓存
        this.refreshCache(subject.getTenantId(), subject.getIndustryCode(), subject.getSubjectId());
    }

    @Override
    public void modSubjectFund(GnSubjectFundVo vo) throws BusinessException {
        // 1.校验ID是否存在
        GnSubjectFund exist = gnSubjectFundSV.queryGnSubjectFund(vo.getTenantId(),
                vo.getIndustryCode(), vo.getSubjectId());
        if (exist == null) {
            throw new BusinessException(ExceptCodeConstants.Special.SYSTEM_ERROR, "资金科目属性不存在");
        }
        // 2.修改资金科目详细
        GnSubjectFund subjectFund = new GnSubjectFund();
        BeanUtils.copyProperties(subjectFund, vo);
        GnSubjectFundKey key = new GnSubjectFundKey();
        BeanUtils.copyProperties(key, vo);
        gnSubjectFundSV.modSubjectFund(subjectFund, key);
        // TODO 刷新缓存
    }

    /**
     * 刷新科目缓存<br>
     * 1.传入已删除的科目可删除缓存 <br>
     * 2.传入已配置的科目可加载缓存 <br>
     * 在界面修改科目配置后调用，来及时刷新缓存
     */
    private void refreshCache(String tenantId, String industryCode, Long subjectId) {
        ICacheClient subjectClient = CacheFactoryUtil
                .getCacheClient(CacheNSMapper.CACHE_GN_SUBJECT);
        ICacheClient fundClient = CacheFactoryUtil
                .getCacheClient(CacheNSMapper.CACHE_GN_SUBJECT_FUND);
        ICacheClient ruleClient = CacheFactoryUtil
                .getCacheClient(CacheNSMapper.CACHE_GN_SETTLE_RULE);

        String key = GnSubjectUtil.generateKey(industryCode, tenantId, subjectId);
        // 1.删除
        subjectClient.hdel(CacheNSMapper.CACHE_GN_SUBJECT, new String[] { key });
        fundClient.hdel(CacheNSMapper.CACHE_GN_SUBJECT_FUND, new String[] { key });
        ruleClient.hdel(CacheNSMapper.CACHE_GN_SETTLE_RULE, new String[] { key });
        // 2.加载 //TODO 还需要重新加载按照科目类型放入的缓存
        GnSubject subject = this.queryGnSubject(tenantId, industryCode, subjectId);
        if (subject == null) {
            return;
        }
        subjectClient.hset(CacheNSMapper.CACHE_GN_SUBJECT, key, JSON.toJSONString(subject));
        if (Constants.GnSubject.SubjectType.FUND.equals(subject.getSubjectType())) {// 资金科目
            // 2.1.资金定义
            GnSubjectFund subjectFund = this.queryGnSubjectFund(tenantId, industryCode, subjectId);
            if (subjectFund != null) {
                fundClient.hset(CacheNSMapper.CACHE_GN_SUBJECT_FUND, key,
                        JSON.toJSONString(subjectFund));
            }
            // 2.2.销账规则
            List<GnSettleRuleKey> settleRule = gnSettleRuleAtomSV.queryGnSettleRule(tenantId,
                    industryCode, subjectId);
            if (CollectionUtil.isEmpty(settleRule)) {
                return;
            }
            ruleClient.hset(CacheNSMapper.CACHE_GN_SETTLE_RULE, key, JSON.toJSONString(settleRule));
        }

    }

    @Override
    public PageInfo<GnSubjectVo> queryGnSubject(GnSubjectCondition cond) throws BusinessException {
        PageInfo<GnSubject> page = gnSubjectSV.queryGnSubject(cond.getTenantId(),
                cond.getIndustryCode(), cond.getSubjectId(), cond.getSubjectType(),
                cond.getSubjectName(), cond.getPageNo(), cond.getPageSize());
        PageInfo<GnSubjectVo> resultPage = new PageInfo<GnSubjectVo>();
        resultPage.setCount(page.getCount());
        resultPage.setPageNo(page.getPageNo());
        resultPage.setPageSize(page.getPageSize());
        List<GnSubjectVo> voList = new ArrayList<GnSubjectVo>();
        for (GnSubject bo : page.getResult()) {
            GnSubjectVo vo = new GnSubjectVo();
            BeanUtils.copyProperties(vo, bo);
            voList.add(vo);
        }
        resultPage.setResult(voList);
        return resultPage;

    }
}
