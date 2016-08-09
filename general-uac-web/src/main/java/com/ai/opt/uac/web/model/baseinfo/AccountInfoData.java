package com.ai.opt.uac.web.model.baseinfo;

import java.io.Serializable;

import com.ai.opt.sdk.util.StringUtil;

/**
 * 账户信息
 * @author jiaxs
 *
 */
public class AccountInfoData implements Serializable{
	
	private static final long serialVersionUID = 1L;

    /**
     * 公司名称
     */
    private String tenantName;
    
    /**
     * 公司类型
     */
    private String industryCode;
    /**
     * 公司类型
     */
    private String industryCodeValue;
   

    /**
     * 账号ID
     */
    private Long accountId;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 手机号码
     */
    private String phone;
    
    /**
     * 邮箱
     */
    private String email;
    /**
     * 租戶狀態
     */
    private String state;
    
	
	
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
		return phone;
	}
    public String getIndustryCodeValue() {
        return industryCodeValue;
    }

    public void setIndustryCodeValue(String industryCodeValue) {
        this.industryCodeValue = industryCodeValue;
    }
	public void setPhone(String phone) {
		String sslphone = phone;
		if(!StringUtil.isBlank(phone)){
			String start = phone.substring(0, 3);
			String end = phone.substring(7);
			sslphone =  start+"****"+end;
		}
		this.phone = sslphone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		String sslEmail = email;
		if(!StringUtil.isBlank(email)){
			String start = email.substring(0, 1);
			int index = email.indexOf("@");
			String end = email.substring(index-1);
			sslEmail =  start+"****"+end;
		}
		this.email = sslEmail;
	}

}
