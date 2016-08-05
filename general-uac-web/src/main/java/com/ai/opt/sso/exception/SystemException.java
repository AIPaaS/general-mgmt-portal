package com.ai.opt.sso.exception;

import java.io.Serializable;

public class SystemException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 3787730660315875183L;

	public SystemException(String code, String message, Exception e) {
		super(message);
		this.message = message;
		this.code = code;
		this.exception = e;
	}

	public SystemException(String code, String title, String message,
			Exception e) {
		super(message);
		this.message = message;
		this.code = code;
		this.exception = e;
		this.title = title;
	}

	public SystemException(String message, Exception e) {
		super(message);
		this.code = ErrorCode.UNKNOW_ERROR;
		this.exception = e;
	}

	public SystemException(String msg) {
		super(msg);
		this.message=msg;
	}

	private Exception exception;
	private String message;
	private String code;// 异常编码，4位标识，默认0000;
	private String title = "系统出错了！";

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

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
}
