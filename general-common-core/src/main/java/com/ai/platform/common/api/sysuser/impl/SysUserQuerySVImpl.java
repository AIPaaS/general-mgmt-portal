package com.ai.platform.common.api.sysuser.impl;

import org.omg.CORBA.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.platform.common.api.sysuser.interfaces.ISysUserQuerySV;
import com.ai.platform.common.api.sysuser.param.SysUserListQueryRequest;
import com.ai.platform.common.api.sysuser.param.SysUserListQueryResponse;
import com.ai.platform.common.api.sysuser.param.SysUserQueryRequest;
import com.ai.platform.common.api.sysuser.param.SysUserQueryResponse;
import com.ai.platform.common.api.sysuser.param.SysUserThemeRequest;
import com.ai.platform.common.api.sysuser.param.SysUserThemeResponse;
import com.ai.platform.common.service.business.sysuser.ISysUserBusiSV;
import com.ai.platform.common.util.SystemValidateUtil;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class SysUserQuerySVImpl implements ISysUserQuerySV {
	@Autowired
	private ISysUserBusiSV iSysUserBusiSV;

	/**
	 * 查詢用戶信息
	 */
	public SysUserQueryResponse queryUserInfo(SysUserQueryRequest request)
			throws BusinessException, SystemException {
		// 参数校验
		SystemValidateUtil.validateQueryUserInfo(request);
		return iSysUserBusiSV.queryUser(request);
	}

	/**
	 * 查詢用戶主題
	 */

	@Override
	public SysUserThemeResponse queryUserTheme(SysUserThemeRequest request) {
		// 参数校验
		if (StringUtils.isEmpty(request.getTenantId())) {
			throw new BusinessException(
					ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
		}
		if (StringUtils.isEmpty(request.getId())) {
			throw new BusinessException(
					ExceptCodeConstants.Special.PARAM_IS_NULL, "用戶ID不能为空");
		}
		return iSysUserBusiSV.queryUserTheme(request);
	}

	@Override
	public SysUserListQueryResponse queryUserByOfficeId(SysUserListQueryRequest request)
			throws BusinessException, com.ai.opt.base.exception.SystemException {
		if (StringUtils.isEmpty(request.getTenantId())) {
			throw new BusinessException(
					ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
		}
		if (StringUtils.isEmpty(request.getOfficeId())) {
			throw new BusinessException(
					ExceptCodeConstants.Special.PARAM_IS_NULL, "机构ID不能为空");
		}
		return iSysUserBusiSV.queryUserByOfficeId(request);
	}
}
