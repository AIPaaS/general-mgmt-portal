package com.ai.slp.common.api.subjectmaintain.param;

import java.io.Serializable;

public class GnSubjectCondition implements Serializable{
    
    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 行业
     */
    private String industryCode;

    /**
     * 科目ID
     */
    private Long subjectId;

    /**
     * 科目类型
     */
    private String subjectType;

    /**
     * 科目名称
     */
    private String subjectName;

    /**
     * 分页：当前页
     */
    private Integer pageNo;

    /**
     * 分页：每页数量
     */
    private Integer pageSize;

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

}
