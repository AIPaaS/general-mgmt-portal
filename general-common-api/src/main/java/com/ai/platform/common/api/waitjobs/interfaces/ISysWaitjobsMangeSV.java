package com.ai.platform.common.api.waitjobs.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.platform.common.api.waitjobs.param.WaitjobsCompleteRequset;
import com.ai.platform.common.api.waitjobs.param.WaitjobsInsertRequest;
import com.ai.platform.common.api.waitjobs.param.WaitjobsInsertResponse;

public interface ISysWaitjobsMangeSV {
	
	/**
	 * 插入代办事物
	 * @param insertRequest 
	 * @return 组织机构信息
	 * @throws BusinessException,SystemException
	 * @author jiaxs
	 * @ApiCode PLAT_008
	 */
	WaitjobsInsertResponse insertWaitjobs(WaitjobsInsertRequest insertRequest) throws BusinessException,SystemException;

	/**
	 * 完结代办事物
	 * @param completeRequest
	 * @return
	 * @throws BusinessException,SystemException
	 * @author jiaxs
	 * @ApiCode PLAT_009
	 */
	BaseResponse completeWaitjobs(WaitjobsCompleteRequset completeRequest) throws BusinessException,SystemException;
}
