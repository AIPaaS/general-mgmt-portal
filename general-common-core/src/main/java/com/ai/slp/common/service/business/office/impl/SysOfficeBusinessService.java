package com.ai.slp.common.service.business.office.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ai.opt.base.vo.BaseInfo;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.slp.common.api.office.param.OfficeAllQueryResponse;
import com.ai.slp.common.api.office.param.OfficeDetailQueryRequest;
import com.ai.slp.common.api.office.param.OfficeDetailQueryResponse;
import com.ai.slp.common.api.office.param.OfficeListOfUserQueryRequest;
import com.ai.slp.common.api.office.param.OfficeListOfUserQueryResponse;
import com.ai.slp.common.api.office.param.OfficeVO;
import com.ai.slp.common.constants.ResultCodeConstants;
import com.ai.slp.common.dao.mapper.bo.SysOffice;
import com.ai.slp.common.service.atom.office.ISysOfficeAtomService;
import com.ai.slp.common.service.business.office.ISysofficeBusinessService;

public class SysOfficeBusinessService implements ISysofficeBusinessService{

	@Autowired
	private ISysOfficeAtomService ISysOfficeAtomService;
	
	@Override
	public OfficeDetailQueryResponse queryOfficeDetail(OfficeDetailQueryRequest queryRequest) {
		SysOffice sysOfficeInfo = ISysOfficeAtomService.selectSysOfficeInfo(queryRequest.getId());
		OfficeDetailQueryResponse queryResponse = new OfficeDetailQueryResponse();
		if(sysOfficeInfo != null){
			OfficeVO officeVo = new OfficeVO();
			BeanUtils.copyProperties(sysOfficeInfo, officeVo);
			queryResponse.setOfficeVo(officeVo );
			ResponseHeader responseHeader=new ResponseHeader(true, ResultCodeConstants.SUCCESS_CODE, "查询成功");
			queryResponse.setResponseHeader(responseHeader);
		}else{
			ResponseHeader responseHeader=new ResponseHeader(true, ResultCodeConstants.SUCCESS_CODE, "查询成功");
			queryResponse.setResponseHeader(responseHeader);
		}
		
		return queryResponse;
	}

	@Override
	public OfficeListOfUserQueryResponse queryOfficeListOfUser(OfficeListOfUserQueryRequest queryRequest) {
		SysOffice sysOfficeInfo = ISysOfficeAtomService.selectSysOfficeInfo(queryRequest.getId());
		if(sysOfficeInfo != null){
			
		}
		return null;
	}

	@Override
	public OfficeAllQueryResponse queryOfficeAll(BaseInfo queryRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
