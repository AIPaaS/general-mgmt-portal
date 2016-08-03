package com.ai.platform.common.service.business.sysuser.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.paas.ipaas.util.JSonUtil;
import com.ai.paas.ipaas.util.StringUtil;
import com.ai.platform.common.api.sysuser.param.SysUserListQueryRequest;
import com.ai.platform.common.api.sysuser.param.SysUserListQueryResponse;
import com.ai.platform.common.api.sysuser.param.SysUserQueryRequest;
import com.ai.platform.common.api.sysuser.param.SysUserQueryResponse;
import com.ai.platform.common.api.sysuser.param.SysUserThemeRequest;
import com.ai.platform.common.api.sysuser.param.SysUserThemeResponse;
import com.ai.platform.common.api.sysuser.param.SysUserVO;
import com.ai.platform.common.constants.ResultCodeConstants;
import com.ai.platform.common.dao.mapper.bo.SysUser;
import com.ai.platform.common.service.atom.sysuser.ISysUserAtomSV;
import com.ai.platform.common.service.business.sysuser.ISysUserBusiSV;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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
		    responseHeader.setResultMessage("无数据");
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
		    responseHeader.setResultMessage("无数据");
		    response.setResponseHeader(responseHeader);
		}
		return response;
	}

	@Override
	public SysUserListQueryResponse queryUserByOfficeId(SysUserListQueryRequest request) {
		SysUserListQueryResponse  response;
		List<SysUser> list = iSysUserAtomSV.selectSysUserByOfficeId(request.getTenantId(), request.getOfficeId());
		if(!CollectionUtil.isEmpty(list)){
			response = new SysUserListQueryResponse();
			String sysuserListJson = JSonUtil.toJSon(list);
			Gson gson = new Gson();
			List<SysUserVO> useres = gson.fromJson(sysuserListJson, new TypeToken<List<SysUserVO>>(){}.getType());
			response.setSysUserList(useres);
			ResponseHeader responseHeader = new ResponseHeader(true,
					ResultCodeConstants.SUCCESS_CODE, "查询成功");
			response.setResponseHeader(responseHeader);
		}else{
			response = new SysUserListQueryResponse();
			ResponseHeader responseHeader = new ResponseHeader(true,
					ResultCodeConstants.NULL_CODE, "无数据");
			response.setResponseHeader(responseHeader);
		}
		return response;
	}

}
