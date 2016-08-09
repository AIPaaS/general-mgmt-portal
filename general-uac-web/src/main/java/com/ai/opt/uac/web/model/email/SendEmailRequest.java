package com.ai.opt.uac.web.model.email;
/**
 * 发送邮件入参对象
 * tomails,data,templateRUL 必填
 * @author jiaxs
 */
public class SendEmailRequest {
	/** 收件箱(必填)*/
	private String[] tomails;
	/** 抄送邮箱*/
	private String[] ccmails;
	/** 主题*/
	private String subject;
	/** 邮件内容参数(必填)*/
	private String[] data;
	/** 模板路径(必填)*/
	private String templateRUL;
	
	public String[] getTomails() {
		return tomails;
	}
	public void setTomails(String[] tomails) {
		this.tomails = tomails;
	}
	public String[] getCcmails() {
		return ccmails;
	}
	public void setCcmails(String[] ccmails) {
		this.ccmails = ccmails;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String[] getData() {
		return data;
	}
	public void setData(String[] data) {
		this.data = data;
	}

	public String getTemplateRUL() {
		return templateRUL;
	}

	public void setTemplateRUL(String templateRUL) {
		this.templateRUL = templateRUL;
	}
}
