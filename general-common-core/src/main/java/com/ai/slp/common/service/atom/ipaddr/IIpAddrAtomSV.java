package com.ai.slp.common.service.atom.ipaddr;

import com.ai.slp.common.dao.mapper.bo.GnIpAddr;

public interface IIpAddrAtomSV {
	GnIpAddr getIpAddrByIp(String ip);
}
