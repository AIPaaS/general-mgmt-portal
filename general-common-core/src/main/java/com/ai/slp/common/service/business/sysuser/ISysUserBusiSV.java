package com.ai.slp.common.service.business.sysuser;

import com.ai.slp.common.api.sysuser.param.SysUserQueryRequest;
import com.ai.slp.common.api.sysuser.param.SysUserQueryResponse;


public interface ISysUserBusiSV {
	
	SysUserQueryResponse queryUser(SysUserQueryRequest request);
	
	
    String queryUserTheme(String id);
}
