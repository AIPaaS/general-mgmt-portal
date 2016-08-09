package com.ai.opt.data.api.user.param;

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


}
