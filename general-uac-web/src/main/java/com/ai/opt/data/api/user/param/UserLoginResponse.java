package com.ai.opt.data.api.user.param;

import java.sql.Timestamp;

import com.ai.opt.base.vo.BaseResponse;

/**
 * 登录返回参数 <br>
 * Date: 2016年3月16日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhanglh
 */
public class UserLoginResponse extends BaseResponse {


	private static final long serialVersionUID = 1L;

    /**
	 * 账号ID 对应中信sys_user表的主键id
	 */
	private String userId;


    /**
     * 登录名
     */
    private String loginName;

    /**
     * 密码（数据库中的密文）
     */
    private String loginPassword;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;
    
    
    //add by zhouxh
    private String loginFlag;//是否允许登录
    private String delFlag;//是否已标记删除
    private Timestamp effectiveDate;//生效时间
    private Timestamp expiryDate;//失效时间
    

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}


	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLoginFlag() {
		return loginFlag;
	}

	public void setLoginFlag(String loginFlag) {
		this.loginFlag = loginFlag;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public Timestamp getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Timestamp effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Timestamp getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Timestamp expiryDate) {
		this.expiryDate = expiryDate;
	}


}
