/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ai.platform.modules.sys.entity;

import org.hibernate.validator.constraints.Length;

import com.ai.platform.common.persistence.DataEntity;

/**
 * 租户（业务平台）Entity
 * @author mengbo
 * @version 2016-10-18
 */
public class GnTenant extends DataEntity<GnTenant> {
	
	private static final long serialVersionUID = 1L;
	private String tenantId;		// 业务平台编号
	private String oldTenantId;
	private String tenantName;		// 业务平台名称
	private String oldTenantName;
	private String tenantPwd;		// 业务平台密码
	private String state;		// 状态
	private String industryCode;		// industry_code
	private String logo;		// logo
	private String framePageTemplate;		// frame_page_template
	
	public GnTenant() {
		super();
	}

	public GnTenant(String id){
		super(id);
	}

	@Length(min=1, max=32, message="业务平台编号长度必须介于 1 和 32 之间")
	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	
	@Length(min=1, max=128, message="业务平台名称长度必须介于 1 和 128 之间")
	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}
	
	@Length(min=0, max=128, message="业务平台密码长度必须介于 0 和 128 之间")
	public String getTenantPwd() {
		return tenantPwd;
	}

	public void setTenantPwd(String tenantPwd) {
		this.tenantPwd = tenantPwd;
	}
	
	@Length(min=1, max=2, message="状态长度必须介于 1 和 2 之间")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	@Length(min=0, max=2, message="industry_code长度必须介于 0 和 2 之间")
	public String getIndustryCode() {
		return industryCode;
	}

	public void setIndustryCode(String industryCode) {
		this.industryCode = industryCode;
	}
	
	@Length(min=0, max=500, message="logo长度必须介于 0 和 500 之间")
	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	@Length(min=0, max=500, message="frame_page_template长度必须介于 0 和 500 之间")
	public String getFramePageTemplate() {
		return framePageTemplate;
	}

	public void setFramePageTemplate(String framePageTemplate) {
		this.framePageTemplate = framePageTemplate;
	}

	public String getOldTenantId() {
		return oldTenantId;
	}

	public void setOldTenantId(String oldTenantId) {
		this.oldTenantId = oldTenantId;
	}

	public String getOldTenantName() {
		return oldTenantName;
	}

	public void setOldTenantName(String oldTenantName) {
		this.oldTenantName = oldTenantName;
	}
	
	
}