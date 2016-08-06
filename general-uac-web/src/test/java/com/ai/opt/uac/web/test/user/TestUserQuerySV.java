package com.ai.opt.uac.web.test.user;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.opt.base.exception.RPCSystemException;
import com.ai.opt.data.api.user.interfaces.IUserQuerySV;
import com.ai.opt.data.api.user.param.UserQueryRequest;
import com.ai.opt.data.api.user.param.UserQueryResponse;

import net.sf.json.JSONObject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:context/core-context.xml")
public class TestUserQuerySV {

	@Autowired
	IUserQuerySV iUserQuerySV;
	@Ignore
	@Test
	public void testQueryBaseInfo() throws RPCSystemException{
		System.out.println("<<<<<<<<<<<<<<Begin testQueryBaseInfo>>>>>>>>>>>>>>");
		UserQueryRequest accountQueryRequest=new UserQueryRequest();
		accountQueryRequest.setUserId("1");
		UserQueryResponse queryBaseInfo = iUserQuerySV.queryBaseInfo(accountQueryRequest);
		JSONObject fromObject = JSONObject.fromObject(queryBaseInfo);
		System.out.println(fromObject);
		System.out.println("<<<<<<<<<<<<<<End testQueryBaseInfo>>>>>>>>>>>>>>");
	}
	
	public String randomNum(int length){
		String str = "";
		str += (int)(Math.random()*10);
		for(int i = 0; i < length-1; i++){
			str += (int)(Math.random()*10);
		}
		return str;
	}
	
	public static final String randomString(int length) {
		char[] charArry = new char[length];
		int i = 0;
		while (i < length) {
			int f = (int) (Math.random() * 3);
			if (f == 0)
				charArry[i] = (char) ('A' + Math.random() * 26);
			else if (f == 1)
				charArry[i] = (char) ('a' + Math.random() * 26);
			else
				charArry[i] = (char) ('0' + Math.random() * 10);
			i++;
		}
		return new String(charArry);
	}
	
	
	
}
