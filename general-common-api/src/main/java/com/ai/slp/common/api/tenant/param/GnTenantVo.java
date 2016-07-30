package com.ai.slp.common.api.tenant.param;

import java.io.Serializable;

/**
 * 租户信息<br>
 * Date: 2015年10月29日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 *
 * @author zhanglh
 */
public class GnTenantVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 租户id
     */
    private String tenantId;

    /**
     * 租户名称
     */
    private String tenantName;

    /**
     * 行业code
     */
    private String industryCode;

    /**
     * 租户LOGO地址
     */
    private String logo;

    /**
     * 租户企业门户对应的框架页面模板
     */
    private String framePageTemplate;

    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getFramePageTemplate() {
        return framePageTemplate;
    }

    public void setFramePageTemplate(String framePageTemplate) {
        this.framePageTemplate = framePageTemplate;
    }
    
    

}
