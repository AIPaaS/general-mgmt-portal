package com.ai.slp.common.service.business.sysuser;


public interface ISysUserBusiSV {
	
	SysUserQueryResponse queryUser(SysUserQueryRequest request);
	
	
    String queryUserTheme(String id);
}
