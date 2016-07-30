package com.ai.slp.common.service.atom.subject.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.paas.ipaas.util.StringUtil;
import com.ai.slp.common.dao.mapper.bo.GnSubject;
import com.ai.slp.common.dao.mapper.bo.GnSubjectCriteria;
import com.ai.slp.common.dao.mapper.bo.GnSubjectKey;
import com.ai.slp.common.dao.mapper.factory.MapperFactory;
import com.ai.slp.common.dao.mapper.interfaces.GnSubjectMapper;
import com.ai.slp.common.service.atom.subject.IGnSubjectAtomSV;

@Component
public class GnSubjectAtomSVImpl implements IGnSubjectAtomSV {

    @Override
    public GnSubject queryGnSubject(String tenantId, String industryCode, long subjectId) {
        GnSubjectKey key = new GnSubjectKey();
        key.setIndustryCode(industryCode);
        key.setSubjectId(subjectId);
        key.setTenantId(tenantId);
        return MapperFactory.getGnSubjectMapper().selectByPrimaryKey(key);
    }

    @Override
    public List<GnSubject> queryGnSubject() {
        return MapperFactory.getGnSubjectMapper().selectByExample(new GnSubjectCriteria());
    }

    @Override
    public void addSubject(GnSubject vo) throws BusinessException {
        MapperFactory.getGnSubjectMapper().insertSelective(vo);
    }

    @Override
    public void delSubject(GnSubjectKey key) throws BusinessException {
        MapperFactory.getGnSubjectMapper().deleteByPrimaryKey(key);
    }

    @Override
    public void modSubject(GnSubject vo, GnSubjectKey key) throws BusinessException {
        GnSubjectCriteria example = new GnSubjectCriteria();
        example.createCriteria().andTenantIdEqualTo(key.getTenantId())
                .andIndustryCodeEqualTo(key.getIndustryCode())
                .andSubjectIdEqualTo(key.getSubjectId());
        int result = MapperFactory.getGnSubjectMapper().updateByExampleSelective(vo, example);
        if (result != 1) {
            throw new BusinessException(ExceptCodeConstants.Special.SYSTEM_ERROR, "修改科目异常:原纪录不存在");
        }
    }

    @Override
    public PageInfo<GnSubject> queryGnSubject(String tenantId, String industryCode, Long subjectId,
            String subjectType, String subjectName, Integer pageNo, Integer pageSize) {
        GnSubjectCriteria example = new GnSubjectCriteria();
        GnSubjectCriteria.Criteria criteria = example.createCriteria();
        if (!StringUtil.isBlank(tenantId)) {
            criteria.andTenantIdEqualTo(tenantId);
        }
        if (!StringUtil.isBlank(industryCode)) {
            criteria.andIndustryCodeEqualTo(industryCode);
        }
        if (subjectId != null) {
            criteria.andSubjectIdEqualTo(subjectId);
        }
        if (!StringUtil.isBlank(tenantId)) {
            criteria.andTenantIdEqualTo(tenantId);
        }
        if (!StringUtil.isBlank(subjectType)) {
            criteria.andSubjectTypeEqualTo(subjectType);
        }
        if (!StringUtil.isBlank(subjectName)) {
            criteria.andSubjectNameLike("%" + subjectName + "%");
        }
        if (pageNo != null && pageSize != null) {
            example.setLimitStart((pageNo - 1) * pageSize);
            example.setLimitEnd(pageSize);
        }
        PageInfo<GnSubject> pageInfo = new PageInfo<GnSubject>();
        GnSubjectMapper mapper = MapperFactory.getGnSubjectMapper();
        pageInfo.setResult(mapper.selectByExample(example));
        pageInfo.setCount(mapper.countByExample(example));
        pageInfo.setPageNo(pageNo);
        pageInfo.setPageSize(pageSize);
        ;
        return pageInfo;
    }

}
