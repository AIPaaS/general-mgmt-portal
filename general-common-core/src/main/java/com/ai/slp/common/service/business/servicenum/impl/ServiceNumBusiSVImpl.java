package com.ai.slp.common.service.business.servicenum.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.sdk.util.BeanUtils;
import com.ai.slp.common.api.servicenum.param.ServiceNum;
import com.ai.slp.common.dao.mapper.bo.GnServiceNum;
import com.ai.slp.common.service.atom.servicenum.IServiceNumAtomSV;
import com.ai.slp.common.service.business.servicenum.IServiceNumBusiSV;
@Component
@Transactional
public class ServiceNumBusiSVImpl implements IServiceNumBusiSV {

	@Autowired
	private IServiceNumAtomSV serviceNumAtomSV ;
	
	@Override
	public ServiceNum getServiceNumByPhone(String phone) {
		ServiceNum serviceNum=null;
		GnServiceNum gnServiceNum=serviceNumAtomSV.getServiceNumByPhone(phone);
		if(gnServiceNum!=null){
			serviceNum=new ServiceNum();
			BeanUtils.copyProperties(serviceNum, gnServiceNum);
		}
		return serviceNum;
	}

}
