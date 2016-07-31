package com.ai.slp.common.service.business.office;

import com.ai.opt.base.vo.BaseInfo;
import com.ai.slp.common.api.office.param.OfficeAllQueryResponse;
import com.ai.slp.common.api.office.param.OfficeDetailQueryRequest;
import com.ai.slp.common.api.office.param.OfficeDetailQueryResponse;
import com.ai.slp.common.api.office.param.OfficeListOfUserQueryRequest;
import com.ai.slp.common.api.office.param.OfficeListOfUserQueryResponse;

public interface ISysofficeBusinessService {
	
	OfficeDetailQueryResponse queryOfficeDetail(OfficeDetailQueryRequest queryRequest);
	
	OfficeListOfUserQueryResponse queryOfficeListOfUser(OfficeListOfUserQueryRequest queryRequest);

	OfficeAllQueryResponse queryOfficeAll(BaseInfo queryRequest);


}
