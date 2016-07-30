package com.ai.slp.common.api.tenant.interfaces;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.common.api.tenant.param.GnTenantConditon;
import com.ai.slp.common.api.tenant.param.GnTenantVo;

/**
 * 租户查询<br>
 * Date: 2015年10月29日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author zhanglh
 */
@Path("/tenantservice")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IGnTenantQuerySV {
	/**
	 * 获取单个租户信息
	 * @param gnTennatConditon 租户ID必填
	 * @return 租户信息
	 * @throws BusinessException,SystemException
	 * @author zhanglh
	 * @ApiCode GN_0335
	 * @RestRelativeURL tenantservice/getTenant
	 */
	@POST
	@Path("/getTenant")
	GnTenantVo getTenant(GnTenantConditon gnTennatConditon) throws BusinessException,SystemException;

	/**
	 * 查询所有租户信息
	 * @return 所有租户信息
	 * @throws BusinessException,SystemException
	 * @author zhanglh
	 * @ApiCode GN_0336
	 * @RestRelativeURL tenantservice/getTenants
	 */
	@POST
	@Path("/getTenants")
	List<GnTenantVo> getTenants() throws BusinessException,SystemException;

}
