package com.ai.slp.common.test.waitjobs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.paas.ipaas.util.JSonUtil;
import com.ai.slp.common.api.waitjobs.interfaces.ISysWaitjobsMangeSV;
import com.ai.slp.common.api.waitjobs.param.WaitjobsCompleteRequset;
import com.ai.slp.common.api.waitjobs.param.WaitjobsInsertRequest;
import com.ai.slp.common.api.waitjobs.param.WaitjobsInsertResponse;
import com.ai.slp.common.api.waitjobs.param.WaitjobsVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class WaitjobsMangeTest {

	@Autowired
	ISysWaitjobsMangeSV iSysWaitjobsMangeSV;
	
	@Test
	public void testInsertWaitjobs(){
		WaitjobsInsertRequest insertRequest = new WaitjobsInsertRequest();
		WaitjobsVO waijobsVo=new WaitjobsVO();
		waijobsVo.setLastUser("001");
		waijobsVo.setPresentActiviti("草稿");
		waijobsVo.setSystemId("002");
		waijobsVo.setTitle("测试");
		waijobsVo.setUserId("003");
		waijobsVo.setTenantId("SLP");
		insertRequest.setWaijobsVo(waijobsVo);
		WaitjobsInsertResponse insertWaitjobs = iSysWaitjobsMangeSV.insertWaitjobs(insertRequest);
		System.out.println(JSonUtil.toJSon(insertWaitjobs));
	}
	
	@Test
	public void testCompleteWaitjobs(){
		WaitjobsCompleteRequset completeRequest = new WaitjobsCompleteRequset();
		completeRequest.setId("0");
		completeRequest.setTenantId("SLP");
		BaseResponse completeWaitjobs = iSysWaitjobsMangeSV.completeWaitjobs(completeRequest );
		System.out.println(JSonUtil.toJSon(completeWaitjobs));
	}
}
