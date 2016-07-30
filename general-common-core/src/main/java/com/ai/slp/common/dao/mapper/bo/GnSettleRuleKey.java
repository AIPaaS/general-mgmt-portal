package com.ai.slp.common.dao.mapper.bo;

public class GnSettleRuleKey {
    private String tenantId;

    private String industryCode;

    private Long subjectId;

    private Long feeSubjectId;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode == null ? null : industryCode.trim();
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getFeeSubjectId() {
        return feeSubjectId;
    }

    public void setFeeSubjectId(Long feeSubjectId) {
        this.feeSubjectId = feeSubjectId;
    }
}