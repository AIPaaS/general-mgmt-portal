package com.ai.slp.common.api.sysuser.interfaces;

import org.omg.CORBA.SystemException;

import com.ai.slp.common.api.sysuser.param.SysUserQueryRequest;
import com.ai.slp.common.api.sysuser.param.SysUserQueryResponse;

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
	String queryUserTheme(String userId)throws BusinessException,SystemException;
}
