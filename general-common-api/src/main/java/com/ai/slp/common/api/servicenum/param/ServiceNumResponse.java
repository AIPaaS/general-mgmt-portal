package com.ai.slp.common.api.servicenum.param;

import com.ai.opt.base.vo.BaseResponse;

public class ServiceNumResponse extends BaseResponse {
	private static final long serialVersionUID = -8372575761255974855L;
	private ServiceNum serviceNum;

	public ServiceNum getServiceNum() {
		return serviceNum;
	}

	public void setServiceNum(ServiceNum serviceNum) {
		this.serviceNum = serviceNum;
	}
	
}
