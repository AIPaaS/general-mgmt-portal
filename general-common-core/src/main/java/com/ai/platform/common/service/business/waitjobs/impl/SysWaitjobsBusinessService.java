package com.ai.platform.common.service.business.waitjobs.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.platform.common.api.waitjobs.param.WaitjobsCompleteRequset;
import com.ai.platform.common.api.waitjobs.param.WaitjobsInsertRequest;
import com.ai.platform.common.api.waitjobs.param.WaitjobsInsertResponse;
import com.ai.platform.common.api.waitjobs.param.WaitjobsVO;
import com.ai.platform.common.constants.ResultCodeConstants;
import com.ai.platform.common.dao.mapper.bo.SysWaitjobs;
import com.ai.platform.common.service.atom.waitjobs.ISysWaitjobsAtomService;
import com.ai.platform.common.service.business.waitjobs.ISysWaitjobsBusinessService;

@Service
@Transactional
public class SysWaitjobsBusinessService implements ISysWaitjobsBusinessService{

	@Autowired
	ISysWaitjobsAtomService iSysWaitjobsAtomService;
	
	@Override
	public WaitjobsInsertResponse insertWaitjobs(WaitjobsInsertRequest insertRequest) {
		WaitjobsInsertResponse insertResponse = new WaitjobsInsertResponse();
		SysWaitjobs waitjobs=new SysWaitjobs();
		WaitjobsVO waijobsVo = insertRequest.getWaijobsVo();
		BeanUtils.copyProperties(waitjobs, waijobsVo);
		String id = iSysWaitjobsAtomService.insertWaitjobs(waitjobs);
		if(StringUtils.isEmpty(id)){
			ResponseHeader responseHeader=new ResponseHeader(false,ResultCodeConstants.ERROR_CODE,"插入失败");
			insertResponse.setResponseHeader(responseHeader);
		}else{
			insertResponse.setId(id);
			ResponseHeader responseHeader=new ResponseHeader(true,ResultCodeConstants.SUCCESS_CODE,"插入成功");
			insertResponse.setResponseHeader(responseHeader);
		}
		return insertResponse;
	}

	@Override
	public BaseResponse completeWaitjobs(WaitjobsCompleteRequset completeRequest) {
		BaseResponse response = new BaseResponse();
		int updateCount = iSysWaitjobsAtomService.completeWaitjobs(completeRequest.getId());
		if(updateCount>0){
			ResponseHeader responseHeader=new ResponseHeader(true,ResultCodeConstants.SUCCESS_CODE,"更改成功");
			response.setResponseHeader(responseHeader);
		}else{
			ResponseHeader responseHeader=new ResponseHeader(false,ResultCodeConstants.ERROR_CODE,"更改失败");
			response.setResponseHeader(responseHeader);
		}
		return response;
	}

}
