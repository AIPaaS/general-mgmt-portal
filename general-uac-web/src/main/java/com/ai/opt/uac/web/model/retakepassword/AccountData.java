package com.ai.opt.uac.web.model.retakepassword;

import java.io.Serializable;

import com.ai.opt.sdk.util.StringUtil;

/**
 * 账户信息
 * @author jiaxs
 *
 */
public class AccountData implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String phone;
	private String email;
	
	public AccountData(){}
	
	public AccountData(String phone,String email){
		this.setPhone(phone);
		this.setEmail(email);
	}
	
	public String getPhone() {
		return phone;
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
			if(index == 1){
				end = email.substring(index);
			}
			sslEmail =  start+"****"+end;
		}
		this.email = sslEmail;
	}

}
