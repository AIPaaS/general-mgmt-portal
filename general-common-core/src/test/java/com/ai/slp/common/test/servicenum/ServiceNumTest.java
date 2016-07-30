package com.ai.slp.common.test.servicenum;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.slp.common.api.cache.interfaces.ICacheSV;
import com.ai.slp.common.api.cache.param.PhoneCond;
import com.ai.slp.common.api.cache.param.ServiceNumCache;
import com.ai.slp.common.api.servicenum.interfaces.IServiceNumSV;
import com.ai.slp.common.api.servicenum.param.ServiceNum;
import com.ai.slp.common.api.servicenum.param.ServiceNumResponse;
import com.ai.slp.common.api.servicenum.param.ServicePhoneCond;
import com.ai.slp.common.dao.mapper.bo.GnServiceNum;
import com.ai.slp.common.service.atom.servicenum.IServiceNumAtomSV;
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class ServiceNumTest {
	@Autowired
	private IServiceNumSV sv;
	@Autowired
	private IServiceNumAtomSV svatom;
	@Autowired
	private ICacheSV cache;

	@Test
	public void testGetServiceNum(){
		String phone="1300000";
		ServiceNum result=sv.getServiceNumByPhone(phone);
		System.out.println("result="+JSON.toJSONString(result));
	}
	@Test
	public void testGetServiceNumCache(){
		String phone="1300000";
		PhoneCond cond=new PhoneCond();
		cond.setPhone(phone);
		ServiceNumCache result=cache.getServiceNum(cond);
		System.out.println("result="+JSON.toJSONString(result));
	}
	@Test
	public void testGetServiceNumObject(){
		String phone="1300000";
		ServicePhoneCond cond=new ServicePhoneCond();
		cond.setPhone(phone);
		ServiceNumResponse result=sv.getServiceNumByPhoneCond(cond);
		System.out.println("result="+JSON.toJSONString(result));
	}
	@Test
	public void testGetServiceNumCount(){
		int result=svatom.getServiceNumCount();
		System.out.println("result="+result);
	}
	@Test
	public void testGetServiceNumPage(){
		List<GnServiceNum> result=svatom.getServiceNumList(1, 10);
		System.out.println("result="+JSON.toJSONString(result));
	}
    
    
}