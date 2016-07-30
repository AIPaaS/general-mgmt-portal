package com.ai.slp.common.service.business.servicenum;

import com.ai.slp.common.api.servicenum.param.ServiceNum;

public interface IServiceNumBusiSV {
	ServiceNum getServiceNumByPhone(String phone);
}
