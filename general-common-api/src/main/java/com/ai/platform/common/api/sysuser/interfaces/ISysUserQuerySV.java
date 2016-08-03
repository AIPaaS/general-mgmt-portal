package com.ai.platform.common.api.sysuser.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.platform.common.api.sysuser.param.SysUserListQueryRequest;
import com.ai.platform.common.api.sysuser.param.SysUserListQueryResponse;
import com.ai.platform.common.api.sysuser.param.SysUserQueryRequest;
import com.ai.platform.common.api.sysuser.param.SysUserQueryResponse;
import com.ai.platform.common.api.sysuser.param.SysUserThemeRequest;
import com.ai.platform.common.api.sysuser.param.SysUserThemeResponse;

public interface ISysUserQuerySV {
	/**
	 * 查询用户信息
	 * @param request
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhanglh
	 * @ApiCode PLAT_001
	 */
	SysUserQueryResponse queryUserInfo(SysUserQueryRequest request)throws BusinessException,SystemException;
	/**
	 * 查询用户主题
	 * @param userId
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhanglh
	 * @ApiCode PLAT_002
	 */
	SysUserThemeResponse queryUserTheme(SysUserThemeRequest request)throws BusinessException,SystemException;
	
	/**
	 * 查询部门id下的用户
	 * @param request
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhanglh
	 * @ApiCode	PLAT_003
	 */
	SysUserListQueryResponse queryUserByOfficeId(SysUserListQueryRequest request)throws BusinessException,SystemException;
}
