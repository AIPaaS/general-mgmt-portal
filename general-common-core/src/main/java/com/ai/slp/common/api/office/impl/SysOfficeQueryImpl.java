package com.ai.slp.common.api.office.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseInfo;
import com.ai.slp.common.api.office.interfaces.ISysOfficeQuerySV;
import com.ai.slp.common.api.office.param.OfficeAllQueryResponse;
import com.ai.slp.common.api.office.param.OfficeChildrenListQueryRequest;
import com.ai.slp.common.api.office.param.OfficeChildrenListQueryResponse;
import com.ai.slp.common.api.office.param.OfficeDetailQueryRequest;
import com.ai.slp.common.api.office.param.OfficeDetailQueryResponse;
import com.ai.slp.common.api.office.param.OfficeParentListQueryRequest;
import com.ai.slp.common.api.office.param.OfficeParentListQueryResponse;
import com.ai.slp.common.service.business.office.ISysofficeBusinessService;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class SysOfficeQueryImpl implements ISysOfficeQuerySV {

	@Autowired
	ISysofficeBusinessService iSysofficeBusinessService;
	
	@Override
	public OfficeDetailQueryResponse queryOfficeDetail(OfficeDetailQueryRequest queryRequest) throws BusinessException,
			SystemException {
		return iSysofficeBusinessService.queryOfficeDetail(queryRequest);
	}

	@Override
	public OfficeParentListQueryResponse queryParentOfficeList(
			OfficeParentListQueryRequest queryRequest)
			throws BusinessException, SystemException {
		return iSysofficeBusinessService.queryParentOfficeList(queryRequest);
	}

	@Override
	public OfficeChildrenListQueryResponse queryChildrenOfficeList(
			OfficeChildrenListQueryRequest queryRequest)
			throws BusinessException, SystemException {
		return iSysofficeBusinessService.queryChildrenOfficeList(queryRequest);
	}

	@Override
	public OfficeAllQueryResponse queryOfficeAll(BaseInfo queryRequest)
			throws BusinessException, SystemException {
		return iSysofficeBusinessService.queryOfficeAll(queryRequest);
	}


}
