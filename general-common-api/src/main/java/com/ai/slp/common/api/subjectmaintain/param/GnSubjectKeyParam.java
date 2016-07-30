package com.ai.slp.common.api.subjectmaintain.param;

import com.ai.opt.base.vo.BaseInfo;

public class GnSubjectKeyParam extends BaseInfo {
    /**
     * 行业编码
     */
    private String industryCode;

    /**
     * 科目ID
     */
    private Long subjectId;

    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }
}
