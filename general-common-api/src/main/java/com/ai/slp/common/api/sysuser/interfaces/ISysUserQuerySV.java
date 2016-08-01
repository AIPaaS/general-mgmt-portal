package com.ai.slp.common.api.sysuser.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.common.api.sysuser.param.SysUserQueryRequest;
import com.ai.slp.common.api.sysuser.param.SysUserQueryResponse;
import com.ai.slp.common.api.sysuser.param.SysUserThemeRequest;
import com.ai.slp.common.api.sysuser.param.SysUserThemeResponse;

public interface ISysUserQuerySV {
	/**
	 * 查询用户信息
	 * @param request
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhanglh
	 * @ApiCode
	 */
	SysUserQueryResponse queryUserInfo(SysUserQueryRequest request)throws BusinessException,SystemException;
	/**
	 * 查询用户主题
	 * @param userId
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhanglh
	 * @ApiCode
	 */
	SysUserThemeResponse queryUserTheme(SysUserThemeRequest request)throws BusinessException,SystemException;
}
