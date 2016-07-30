package com.ai.slp.common.api.servicenum.param;

import java.io.Serializable;

/**
 * ServiceNum
 *
 * Date: 2016年6月1日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gucl
 */
public class ServicePhoneCond implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
    /**
     * 手机号码
     */
    private String phone;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
  


   
}