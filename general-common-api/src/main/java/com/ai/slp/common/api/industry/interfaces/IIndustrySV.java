package com.ai.slp.common.api.industry.interfaces;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.common.api.industry.param.IndustryQueryResponse;

@Path("/industryservice")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IIndustrySV {
    /**
     * 查询所有行业类型
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhanglh
     * @ApiCode UAC_0012
     * @RestRelativeURL industryservice/queryIndustryList
	 */
	@POST
	@Path("/queryIndustryList")
    List<IndustryQueryResponse> queryIndustryList() throws BusinessException,SystemException;
    /**
     * 根据行业编码查询单个行业类型
     * @return 
     * @throws BusinessException
     * @throws SystemException
     * @author zhanglh
     * @ApiCode UAC_0013
     * @RestRelativeURL industryservice/queryByIndustryCode
	 */
	@POST
	@Path("/queryByIndustryCode")
    IndustryQueryResponse queryByIndustryCode(String industryCode)throws BusinessException,SystemException;
}
