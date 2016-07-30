package com.ai.slp.common.api.servicenum.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.common.api.servicenum.interfaces.IServiceNumSV;
import com.ai.slp.common.api.servicenum.param.ServiceNum;
import com.ai.slp.common.api.servicenum.param.ServiceNumResponse;
import com.ai.slp.common.api.servicenum.param.ServicePhoneCond;
import com.ai.slp.common.service.business.servicenum.IServiceNumBusiSV;
import com.ai.slp.common.util.ServiceNumCacheUtil;
import com.ai.slp.common.util.VoValidateUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;

@Service
@Component
public class ServiceNumSVImpl implements IServiceNumSV {
	private static final Logger LOG=LoggerFactory.getLogger(ServiceNumSVImpl.class);
	@Autowired
	private IServiceNumBusiSV iServiceNumBusiSV;
	@Override
	public ServiceNum getServiceNumByPhone(String phone) {
		VoValidateUtils.validateGetServiceNumByIpPhone(phone);
		ServiceNum result = queryServiceNumByPhone(phone);
		return result;
	}
	@Override
	public ServiceNumResponse getServiceNumByPhoneCond(ServicePhoneCond cond) {
		ServiceNumResponse result=new ServiceNumResponse();
		ResponseHeader responseHeader = new ResponseHeader(true,
                ExceptCodeConstants.Special.SUCCESS, "成功");
		VoValidateUtils.validateGetServiceNum(cond);
		String phone=cond.getPhone();
		ServiceNum serviceNum = queryServiceNumByPhone(phone);
		result.setServiceNum(serviceNum);
		result.setResponseHeader(responseHeader);
		return result;
	}
	private ServiceNum queryServiceNumByPhone(String phone) {
		if(!StringUtil.isBlank(phone)&&phone.length()>7){
			phone=phone.substring(0, 7);
		}
		ServiceNum result=ServiceNumCacheUtil.getServiceNum(phone);
		if(result==null){
			LOG.info("cache中无法获取【"+phone+"】对应的ServiceNum数据，尝试从数据库中获取。。。");
			result=iServiceNumBusiSV.getServiceNumByPhone(phone);
			if(result==null){
				LOG.info("数据库中不存在【"+phone+"】对应的ServiceNum数据");
			}
			else{
				LOG.info("数据库中获取到【"+phone+"】对应的ServiceNum数据(同时更新到缓存)："+JSON.toJSONString(result));
				ServiceNumCacheUtil.updateServiceNumCacheData(result);
			}
		}
		else{
			LOG.info("cache中获取到【"+phone+"】对应的ServiceNum数据："+JSON.toJSONString(result));
		}
		return result;
	}

}
