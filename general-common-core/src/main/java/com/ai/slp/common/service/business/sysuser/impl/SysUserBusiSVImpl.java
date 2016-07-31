package com.ai.slp.common.service.business.sysuser.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.paas.ipaas.util.StringUtil;
import com.ai.slp.common.api.sysuser.param.SysUserQueryRequest;
import com.ai.slp.common.api.sysuser.param.SysUserQueryResponse;
import com.ai.slp.common.api.sysuser.param.SysUserThemeRequest;
import com.ai.slp.common.api.sysuser.param.SysUserThemeResponse;
import com.ai.slp.common.constants.ResultCodeConstants;
import com.ai.slp.common.dao.mapper.bo.SysUser;
import com.ai.slp.common.service.atom.sysuser.ISysUserAtomSV;
import com.ai.slp.common.service.business.sysuser.ISysUserBusiSV;
@Service
@Transactional
public class SysUserBusiSVImpl implements ISysUserBusiSV {   
	@Autowired
	ISysUserAtomSV iSysUserAtomSV;
	@Override
	public SysUserQueryResponse queryUser(SysUserQueryRequest request) {
		SysUser userRequest = new SysUser();
		SysUserQueryResponse  response;
		BeanUtils.copyProperties(userRequest, request);
		SysUser user=iSysUserAtomSV.queryUser(userRequest);
		if(user!=null){
			response =new SysUserQueryResponse();
			BeanUtils.copyProperties(response, user);
			ResponseHeader responseHeader = new ResponseHeader();
		    responseHeader.setIsSuccess(true);
		    responseHeader.setResultCode(ResultCodeConstants.SUCCESS_CODE);
		    response.setResponseHeader(responseHeader);
		}else{
			response =new SysUserQueryResponse();
			ResponseHeader responseHeader = new ResponseHeader();
		    responseHeader.setIsSuccess(true);
		    responseHeader.setResultCode(ResultCodeConstants.NULL_CODE);
		    response.setResponseHeader(responseHeader);
		}
		return response;
	}

	@Override
	public SysUserThemeResponse queryUserTheme(SysUserThemeRequest request) {
		String theme = iSysUserAtomSV.queryUserTheme(request.getId(),request.getTenantId());
		SysUserThemeResponse response;
		if(!StringUtil.isBlank(theme)){
			response =new SysUserThemeResponse();
			response.setTheme(theme);
			ResponseHeader responseHeader = new ResponseHeader();
		    responseHeader.setIsSuccess(true);
		    responseHeader.setResultCode(ResultCodeConstants.SUCCESS_CODE);
		    response.setResponseHeader(responseHeader);
		}else{
			response =new SysUserThemeResponse();
			ResponseHeader responseHeader = new ResponseHeader();
		    responseHeader.setIsSuccess(true);
		    responseHeader.setResultCode(ResultCodeConstants.NULL_CODE);
		    response.setResponseHeader(responseHeader);
		}
		return response;
	}

}
