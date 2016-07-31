package com.ai.slp.common.api.sysuser.impl;

import com.ai.slp.common.service.business.subject.IGnSubjectBusiSV;
import com.ai.slp.common.service.business.sysuser.ISysUserBusiSV;
import com.ai.slp.common.util.SystemValidateUtil;

@Service
@Component
public class SysUserQuerySVImpl implements ISysUserQuerySV{
	 @Autowired
	private ISysUserBusiSV iSysUserBusiSV;
	public SysUserQueryResponse queryUserInfo(SysUserQueryRequest request){
		//参数校验
		SystemValidateUtil.validateQueryUserInfo(request);
		return iSysUserBusiSV.queryUser(request);
	}
}
