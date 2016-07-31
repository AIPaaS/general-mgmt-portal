package com.ai.slp.common.api.office.impl;

import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseInfo;
import com.ai.slp.common.api.office.interfaces.ISysOfficeQuerySV;
import com.ai.slp.common.api.office.param.OfficeAllQueryResponse;
import com.ai.slp.common.api.office.param.OfficeDetailQueryRequest;
import com.ai.slp.common.api.office.param.OfficeDetailQueryResponse;
import com.ai.slp.common.api.office.param.OfficeListOfUserQueryRequest;
import com.ai.slp.common.api.office.param.OfficeListOfUserQueryResponse;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class SysOfficeQueryImpl implements ISysOfficeQuerySV {

	@Override
	public OfficeDetailQueryResponse queryOfficeDetail(
			OfficeDetailQueryRequest queryRequest) throws BusinessException,
			SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OfficeListOfUserQueryResponse queryOfficeListOfUser(
			OfficeListOfUserQueryRequest queryRequest)
			throws BusinessException, SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OfficeAllQueryResponse queryOfficeAll(BaseInfo queryRequest)
			throws BusinessException, SystemException {
		// TODO Auto-generated method stub
		return null;
	}

}
