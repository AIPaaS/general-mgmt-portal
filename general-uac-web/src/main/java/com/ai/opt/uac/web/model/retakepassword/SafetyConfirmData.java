package com.ai.opt.uac.web.model.retakepassword;

import java.io.Serializable;

/**
 * 身份安全确认信息
 * @author jiaxs
 *
 */
public class SafetyConfirmData implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 账号ID
	 */
	private Long accountId;
	/**
	 * 验证方式
	 */
	private String confirmType;
	/**
	 * 图形验证码
	 */
	private String pictureVerifyCode;
	/**
	 * 验证码
	 */
	private String verifyCode;
	
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public String getConfirmType() {
		return confirmType;
	}
	public void setConfirmType(String confirmType) {
		this.confirmType = confirmType;
	}
	public String getPictureVerifyCode() {
		return pictureVerifyCode;
	}
	public void setPictureVerifyCode(String pictureVerifyCode) {
		this.pictureVerifyCode = pictureVerifyCode;
	}
	public String getVerifyCode() {
		return verifyCode;
	}
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
