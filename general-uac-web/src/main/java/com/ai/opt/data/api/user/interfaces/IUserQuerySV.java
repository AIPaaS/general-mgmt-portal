package com.ai.opt.data.api.user.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.data.api.user.param.UserQueryRequest;
import com.ai.opt.data.api.user.param.UserQueryResponse;

/**
 * 用户查询服务
 *
 * Date: 2016年7月5日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gucl
 */
@Path("/userquery")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IUserQuerySV {
	
	/**
	 * 查询账户信息
	 * @param userQueryRequest
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author gucl
     * @ApiDocMethod
     * @ApiCode CITIC_UAC_0002
     * @RestRelativeURL userquery/queryBaseInfo
	 */
	@POST
	@Path("/queryBaseInfo")
	UserQueryResponse queryBaseInfo(UserQueryRequest userQueryRequest) throws BusinessException,SystemException;
	
	
}
