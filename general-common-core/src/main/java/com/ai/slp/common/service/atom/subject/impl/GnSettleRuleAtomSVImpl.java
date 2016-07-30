package com.ai.slp.common.service.atom.subject.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.slp.common.dao.mapper.bo.GnSettleRuleCriteria;
import com.ai.slp.common.dao.mapper.bo.GnSettleRuleKey;
import com.ai.slp.common.dao.mapper.factory.MapperFactory;
import com.ai.slp.common.service.atom.subject.IGnSettleRuleAtomSV;

@Component
public class GnSettleRuleAtomSVImpl implements IGnSettleRuleAtomSV {

    @Override
    public List<GnSettleRuleKey> queryGnSettleRule(String tenantId, String industryCode,
            long subjectId) throws BusinessException {
        GnSettleRuleCriteria example = new GnSettleRuleCriteria();
        example.createCriteria().andTenantIdEqualTo(tenantId).andIndustryCodeEqualTo(industryCode)
                .andSubjectIdEqualTo(subjectId);
        return MapperFactory.getGnSettleRuleMapper().selectByExample(example);
    }

    @Override
    public List<GnSettleRuleKey> queryGnSettleRule() throws BusinessException {
        return MapperFactory.getGnSettleRuleMapper().selectByExample(new GnSettleRuleCriteria());
    }

    @Override
    public void addSubjectRule(GnSettleRuleKey vo) throws BusinessException {
        MapperFactory.getGnSettleRuleMapper().insertSelective(vo);
    }

    @Override
    public void delSubjectRule(GnSettleRuleKey key) throws BusinessException {
        MapperFactory.getGnSettleRuleMapper().deleteByPrimaryKey(key);
    }

    @Override
    public void modSubjectRule(GnSettleRuleKey vo, GnSettleRuleKey key) throws BusinessException {
        GnSettleRuleCriteria example = new GnSettleRuleCriteria();
        example.createCriteria().andTenantIdEqualTo(key.getTenantId())
                .andIndustryCodeEqualTo(key.getIndustryCode())
                .andSubjectIdEqualTo(key.getSubjectId())
                .andFeeSubjectIdEqualTo(key.getFeeSubjectId());

        int result = MapperFactory.getGnSettleRuleMapper().updateByExampleSelective(vo, example);

        if (result != 1) {
            throw new BusinessException(ExceptCodeConstants.Special.SYSTEM_ERROR, "修改销账规则异常:原纪录不存在");
        }
    }
}
