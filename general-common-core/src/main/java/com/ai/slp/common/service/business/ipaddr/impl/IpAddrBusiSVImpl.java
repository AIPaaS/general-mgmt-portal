package com.ai.slp.common.service.business.ipaddr.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.sdk.util.BeanUtils;
import com.ai.slp.common.api.ipaddr.param.IpAddr;
import com.ai.slp.common.dao.mapper.bo.GnIpAddr;
import com.ai.slp.common.service.atom.ipaddr.IIpAddrAtomSV;
import com.ai.slp.common.service.business.ipaddr.IIpAddrBusiSV;

@Component
@Transactional
public class IpAddrBusiSVImpl implements IIpAddrBusiSV {

	@Autowired
	private IIpAddrAtomSV ipAddrAtomSV;
	@Override
	public IpAddr getIpAddrByIp(String ip) {
		IpAddr ipAddr=null;
		GnIpAddr gnIpAddr=ipAddrAtomSV.getIpAddrByIp(ip);
		if(gnIpAddr!=null){
			ipAddr=new IpAddr();
			BeanUtils.copyProperties(ipAddr, gnIpAddr);
		}
		
		return ipAddr;
	}

}
