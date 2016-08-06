package com.ai.opt.data.api.user.param;

import java.io.Serializable;

public class UserQueryRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 账号ID(必填)
	 */
	private String userId;
	/**
	 * 手机号码
	 */
	private String mobile;
	/**
	 * 邮件
	 */
	private String email;


    public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

}
