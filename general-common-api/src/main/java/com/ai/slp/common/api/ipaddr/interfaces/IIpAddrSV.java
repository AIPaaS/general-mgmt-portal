package com.ai.slp.common.api.ipaddr.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.slp.common.api.ipaddr.param.IpAddr;
/**
 * 依据IP地址查询归属地服务
 *
 * Date: 2016年6月1日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gucl
 */
@Path("/ipaddrservice")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IIpAddrSV {
	/**
	 * 依据IP地址查询归属地服务
	 * @param ip
	 * @return
	 * @author gucl
	 * @ApiDocMethod
	 * @ApiCode GN_0401
	 * @RestRelativeURL ipaddrservice/getIpAddrByIp
	 */
	@POST
	@Path("/getIpAddrByIp")
	IpAddr getIpAddrByIp(String ip);
}
