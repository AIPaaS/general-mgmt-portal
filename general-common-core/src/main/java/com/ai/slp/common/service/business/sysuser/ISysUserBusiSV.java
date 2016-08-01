package com.ai.slp.common.service.business.sysuser;

import com.ai.slp.common.api.sysuser.param.SysUserQueryRequest;
import com.ai.slp.common.api.sysuser.param.SysUserQueryResponse;
import com.ai.slp.common.api.sysuser.param.SysUserThemeRequest;
import com.ai.slp.common.api.sysuser.param.SysUserThemeResponse;


public interface ISysUserBusiSV {
	
	SysUserQueryResponse queryUser(SysUserQueryRequest request);
	
	
	SysUserThemeResponse queryUserTheme(SysUserThemeRequest requst);
}
