package com.ai.slp.common.api.industry.param;

import com.ai.opt.base.vo.BaseResponse;

public class IndustryQueryResponse extends BaseResponse{
    private static final long serialVersionUID = 1L;

    /**
     * 行业类型编码
     */
    private String industryCode;

    /**
     * 行业类型名称
     */
    private String industryName;

    /**
     * 行业描述
     */
    private String IndustryDesc;

   

    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public String getIndustryDesc() {
        return IndustryDesc;
    }

    public void setIndustryDesc(String industryDesc) {
        IndustryDesc = industryDesc;
    }

}
