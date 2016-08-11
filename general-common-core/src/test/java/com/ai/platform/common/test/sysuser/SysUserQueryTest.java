package com.ai.platform.common.test.sysuser;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.paas.ipaas.util.JSonUtil;
import com.ai.platform.common.api.sysuser.interfaces.ISysUserQuerySV;
import com.ai.platform.common.api.sysuser.param.SysUserListQueryRequest;
import com.ai.platform.common.api.sysuser.param.SysUserListQueryResponse;
import com.ai.platform.common.api.sysuser.param.SysUserQueryRequest;
import com.ai.platform.common.api.sysuser.param.SysUserQueryResponse;
import com.ai.platform.common.api.sysuser.param.SysUserThemeRequest;
import com.ai.platform.common.api.sysuser.param.SysUserThemeResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class SysUserQueryTest {
	@Autowired
	private ISysUserQuerySV sv;
	@Test
	public void queryUserInfo(){
		SysUserQueryRequest queryRequest=new SysUserQueryRequest();
		queryRequest.setTenantId("   chan  ghong   ");
		queryRequest.setNo("   0010");
		//queryRequest.setPhone(" 456 ");
		queryRequest.setLoginName("jn_jsb");
		SysUserQueryResponse response = sv.queryUserInfo(queryRequest);
		System.out.println(JSonUtil.toJSon(response));
	}
	@Test
	public void queryUserTheme(){
		SysUserThemeRequest queryRequest=new SysUserThemeRequest();
		queryRequest.setTenantId("  changhong  ");
		queryRequest.setId("10   ");
		SysUserThemeResponse response = sv.queryUserTheme(queryRequest);
		System.out.println(JSonUtil.toJSon(response));
	}
	@Test
	public void queryUserList(){
		SysUserListQueryRequest queryRequest=new SysUserListQueryRequest();
		queryRequest.setTenantId("  changhong  ");
		queryRequest.setOfficeId("11");
		SysUserListQueryResponse response = sv.queryUserByOfficeId(queryRequest);
		System.out.println(JSonUtil.toJSon(response.getSysUserList().size()));
	}
}
