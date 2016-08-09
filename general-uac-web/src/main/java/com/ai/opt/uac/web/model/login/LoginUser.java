package com.ai.opt.uac.web.model.login;

import java.io.Serializable;

public class LoginUser implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String userName;
	
	private String password;
	
	public LoginUser(){}
	
	public LoginUser(String userName,String password){
		setUserName(userName);
		setPassword(password);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
