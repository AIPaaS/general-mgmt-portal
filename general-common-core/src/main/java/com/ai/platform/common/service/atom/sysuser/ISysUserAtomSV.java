package com.ai.platform.common.service.atom.sysuser;

import java.util.List;

import com.ai.platform.common.dao.mapper.bo.SysUser;

public interface ISysUserAtomSV {
	SysUser queryUser(String tenantId,String phone,String no,String loginName,String email);

	String queryUserTheme(String id,String tenantId);
	
	List<SysUser> selectSysUserByOfficeId( String tenantId,String officeId);
}
