// Decompiled by Jad v1.5.7d. Copyright 2000 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/SiliconValley/Bridge/8617/jad.html
// Decompiler options: packimports(3)
// Source File Name:   BusinessException.java

package com.ai.opt.sso.exception;

// Referenced classes of package com.asiainfo.common:
//            BaseException

public class BusinessException extends Exception {

	private static final long serialVersionUID = 8109303352556055331L;

	public BusinessException(String code, String title, String message) {
		super(title);
		this.code = code;
		this.title = title;
		this.message = message;
	}

	public BusinessException(String message) {
		super(message);
		this.code = "0000";
		this.message = message;
		this.title = "系统出错了！";
	}

	public BusinessException(String title, String message) {
		super(message);
		this.code = "0000";
		this.message = message;
		this.title = title;
	}

	private String code;
	private String message;
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
