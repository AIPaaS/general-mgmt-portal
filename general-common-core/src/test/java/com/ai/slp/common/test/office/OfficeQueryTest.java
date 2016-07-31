package com.ai.slp.common.test.office;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.opt.base.vo.BaseInfo;
import com.ai.paas.ipaas.util.JSonUtil;
import com.ai.slp.common.api.office.interfaces.ISysOfficeQuerySV;
import com.ai.slp.common.api.office.param.OfficeAllQueryResponse;
import com.ai.slp.common.api.office.param.OfficeChildrenListQueryRequest;
import com.ai.slp.common.api.office.param.OfficeChildrenListQueryResponse;
import com.ai.slp.common.api.office.param.OfficeDetailQueryRequest;
import com.ai.slp.common.api.office.param.OfficeDetailQueryResponse;
import com.ai.slp.common.api.office.param.OfficeParentListQueryRequest;
import com.ai.slp.common.api.office.param.OfficeParentListQueryResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class OfficeQueryTest {
	@Autowired
	private ISysOfficeQuerySV sv;

	@Test
	public void queryOfficeDetail(){
		OfficeDetailQueryRequest queryRequest=new OfficeDetailQueryRequest();
		queryRequest.setId("25");
		queryRequest.setTenantId("SLP");
		OfficeDetailQueryResponse queryOfficeDetail = sv.queryOfficeDetail(queryRequest);
		System.out.println(JSonUtil.toJSon(queryOfficeDetail));
	}
	@Test
	public void queryChildrenOfficeList(){
		OfficeChildrenListQueryRequest queryRequest=new OfficeChildrenListQueryRequest();
		queryRequest.setId("25");
		queryRequest.setTenantId("SLP");
		OfficeChildrenListQueryResponse queryChildrenOfficeList = sv.queryChildrenOfficeList(queryRequest);
		System.out.println(JSonUtil.toJSon(queryChildrenOfficeList));
	}
	@Test
	public void queryParentOfficeList(){
		OfficeParentListQueryRequest queryRequest = new OfficeParentListQueryRequest();
		queryRequest.setId("25");
		queryRequest.setTenantId("SLP");
		OfficeParentListQueryResponse queryParentOfficeList = sv.queryParentOfficeList(queryRequest);
		System.out.println(JSonUtil.toJSon(queryParentOfficeList));
	}
	@Test
	public void testGetServiceNumCount(){
		BaseInfo queryRequest = new BaseInfo();
		queryRequest.setTenantId("SLP");
		OfficeAllQueryResponse queryOfficeAll = sv.queryOfficeAll(queryRequest );
		System.out.println(JSonUtil.toJSon(queryOfficeAll));
	}
    
    
}