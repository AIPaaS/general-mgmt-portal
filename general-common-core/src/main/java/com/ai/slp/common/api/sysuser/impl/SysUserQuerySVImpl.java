package com.ai.slp.common.api.sysuser.impl;

import org.omg.CORBA.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.slp.common.api.sysuser.interfaces.ISysUserQuerySV;
import com.ai.slp.common.api.sysuser.param.SysUserQueryRequest;
import com.ai.slp.common.api.sysuser.param.SysUserQueryResponse;
import com.ai.slp.common.service.business.sysuser.ISysUserBusiSV;
import com.ai.slp.common.util.SystemValidateUtil;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class SysUserQuerySVImpl implements ISysUserQuerySV{
	 @Autowired
	private ISysUserBusiSV iSysUserBusiSV;
	 /**
	  * 查詢用戶信息
	  */
	public SysUserQueryResponse queryUserInfo(SysUserQueryRequest request)throws BusinessException,SystemException{
		//参数校验
		SystemValidateUtil.validateQueryUserInfo(request);
		return iSysUserBusiSV.queryUser(request);
	}
	/**
	 * 查詢用戶主題
	 */
	
	public String queryUserTheme(String userId)throws BusinessException,SystemException{
		//參數校驗
		if (StringUtils.isEmpty(userId)) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "用戶ID不能为空");
		}
		return iSysUserBusiSV.queryUserTheme(userId);
	}
}
