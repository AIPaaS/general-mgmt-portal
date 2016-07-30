package com.ai.slp.common.dao.mapper.bo;

public class GnTenant {
    private String tenantId;

    private String tenantName;

    private String tenantPwd;

    private String state;

    private String industryCode;

    private String logo;

    private String framePageTemplate;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName == null ? null : tenantName.trim();
    }

    public String getTenantPwd() {
        return tenantPwd;
    }

    public void setTenantPwd(String tenantPwd) {
        this.tenantPwd = tenantPwd == null ? null : tenantPwd.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode == null ? null : industryCode.trim();
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    public String getFramePageTemplate() {
        return framePageTemplate;
    }

    public void setFramePageTemplate(String framePageTemplate) {
        this.framePageTemplate = framePageTemplate == null ? null : framePageTemplate.trim();
    }
}