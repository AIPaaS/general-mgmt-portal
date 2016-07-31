package com.ai.slp.common.service.business.sysuser.impl;

import com.ai.slp.common.constants.ResultCodeConstants;
import com.ai.slp.common.dao.mapper.bo.SysUser;
import com.ai.slp.common.service.atom.sysuser.ISysUserAtomSV;
import com.ai.slp.common.service.business.sysuser.ISysUserBusiSV;
import com.ai.slp.common.service.business.sysuser.SysUserQueryRequest;
import com.ai.slp.common.service.business.sysuser.SysUserQueryResponse;
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
		    responseHeader.setResultCode(ResultCodeConstants.ERROR_NULL_CODE);
		    response.setResponseHeader(responseHeader);
		}
		return response;
	}

	@Override
	public String queryUserTheme(String id) {
		return iSysUserAtomSV.queryUserTheme(id);
	}

}
