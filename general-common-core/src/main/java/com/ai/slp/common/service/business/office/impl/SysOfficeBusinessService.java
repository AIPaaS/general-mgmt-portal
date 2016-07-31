package com.ai.slp.common.service.business.office.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.vo.BaseInfo;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.paas.ipaas.util.JSonUtil;
import com.ai.slp.common.api.office.param.OfficeAllQueryResponse;
import com.ai.slp.common.api.office.param.OfficeChildrenListQueryRequest;
import com.ai.slp.common.api.office.param.OfficeChildrenListQueryResponse;
import com.ai.slp.common.api.office.param.OfficeDetailQueryRequest;
import com.ai.slp.common.api.office.param.OfficeDetailQueryResponse;
import com.ai.slp.common.api.office.param.OfficeParentListQueryRequest;
import com.ai.slp.common.api.office.param.OfficeParentListQueryResponse;
import com.ai.slp.common.api.office.param.OfficeVO;
import com.ai.slp.common.constants.ResultCodeConstants;
import com.ai.slp.common.dao.mapper.bo.SysOffice;
import com.ai.slp.common.service.atom.office.ISysOfficeAtomService;
import com.ai.slp.common.service.business.office.ISysOfficeBusinessService;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service
@Transactional
public class SysOfficeBusinessService implements ISysOfficeBusinessService{

	@Autowired
	private ISysOfficeAtomService ISysOfficeAtomService;
	
	@Override
	public OfficeDetailQueryResponse queryOfficeDetail(OfficeDetailQueryRequest queryRequest) {
		SysOffice sysOfficeInfo = ISysOfficeAtomService.selectSysOfficeInfo(queryRequest.getId());
		OfficeDetailQueryResponse queryResponse = new OfficeDetailQueryResponse();
		if(sysOfficeInfo != null){
			OfficeVO officeVo = new OfficeVO();
			BeanUtils.copyProperties(officeVo,sysOfficeInfo);
			queryResponse.setOfficeVo(officeVo );
			ResponseHeader responseHeader=new ResponseHeader(true, ResultCodeConstants.SUCCESS_CODE, "查询成功");
			queryResponse.setResponseHeader(responseHeader);
		}else{
			ResponseHeader responseHeader=new ResponseHeader(true, ResultCodeConstants.NULL_CODE, "无数据");
			queryResponse.setResponseHeader(responseHeader);
		}
		return queryResponse;
	}

	@Override
	public OfficeParentListQueryResponse queryParentOfficeList(OfficeParentListQueryRequest queryRequest) {
		SysOffice sysOfficeInfo = ISysOfficeAtomService.selectSysOfficeInfo(queryRequest.getId());
		OfficeParentListQueryResponse queryResponse = new OfficeParentListQueryResponse();
		if(sysOfficeInfo != null){
			List<OfficeVO> officeList = new LinkedList<OfficeVO>();
			String parentIds = sysOfficeInfo.getParentIds();
			//转换返回类型
			OfficeVO officeVoSelf = new OfficeVO();
			BeanUtils.copyProperties(officeVoSelf,sysOfficeInfo);
			//添加父组织列表
			if(!StringUtils.isBlank(parentIds)){
				String[] officeIdArray = parentIds.split(",");
				List<String> officeIdList = new ArrayList<String>();
				for(String officeId : officeIdArray){
					officeIdList.add(officeId);
				}
				List<SysOffice> selectSysOfficeList = ISysOfficeAtomService.selectSysOfficeList(officeIdList);
				if(selectSysOfficeList != null){
					String officeListJson = JSonUtil.toJSon(selectSysOfficeList);
					Gson gson = new Gson();
					List<OfficeVO> parentOffices = gson.fromJson(officeListJson, new TypeToken<List<OfficeVO>>(){}.getType());
					officeList.addAll(parentOffices);
				}
			}
			//添加自身组织
			officeList.add(officeVoSelf);
			queryResponse.setOfficeList(officeList);
			ResponseHeader responseHeader=new ResponseHeader(true, ResultCodeConstants.SUCCESS_CODE, "查询成功");
			queryResponse.setResponseHeader(responseHeader);
		}else{
			ResponseHeader responseHeader=new ResponseHeader(true, ResultCodeConstants.NULL_CODE, "无数据");
			queryResponse.setResponseHeader(responseHeader);
		}
		return queryResponse;
	}

	@Override
	public OfficeChildrenListQueryResponse queryChildrenOfficeList(
			OfficeChildrenListQueryRequest queryRequest) {
		List<SysOffice> sysOfficeList = ISysOfficeAtomService.selectChildrenOfficeList(queryRequest.getId(),queryRequest.getTenantId());
		OfficeChildrenListQueryResponse queryResponse = new OfficeChildrenListQueryResponse();
		if(sysOfficeList != null){
			String officeListJson = JSonUtil.toJSon(sysOfficeList);
			Gson gson = new Gson();
			List<OfficeVO> childrenOffices = gson.fromJson(officeListJson, new TypeToken<List<OfficeVO>>(){}.getType());
			queryResponse.setOfficeList(childrenOffices);
			ResponseHeader responseHeader = new ResponseHeader(true,
					ResultCodeConstants.SUCCESS_CODE, "查询成功");
			queryResponse.setResponseHeader(responseHeader);
		} else {
			ResponseHeader responseHeader = new ResponseHeader(true,
					ResultCodeConstants.NULL_CODE, "无数据");
			queryResponse.setResponseHeader(responseHeader);
		}
		return queryResponse;
	}

	@Override
	public OfficeAllQueryResponse queryOfficeAll(BaseInfo queryRequest) {
		OfficeAllQueryResponse officeAllQueryResponse = new OfficeAllQueryResponse();
		// 获取叶子节点
		List<SysOffice> allOfficeList = ISysOfficeAtomService
				.selectSysOfficeAll(queryRequest.getTenantId());
		if (allOfficeList != null) {
			String allOfficeListJson = JSonUtil.toJSon(allOfficeList);
			Gson gson = new Gson();
			List<OfficeVO> allOffice = gson.fromJson(allOfficeListJson,
					new TypeToken<List<OfficeVO>>() {
					}.getType());
			officeAllQueryResponse.setAllOffice(allOffice);
			ResponseHeader responseHeader = new ResponseHeader(true,
					ResultCodeConstants.SUCCESS_CODE, "查询成功");
			;
			officeAllQueryResponse.setResponseHeader(responseHeader);
		} else {
			ResponseHeader responseHeader = new ResponseHeader(true,
					ResultCodeConstants.NULL_CODE, "无数据");
			officeAllQueryResponse.setResponseHeader(responseHeader);
		}
		return officeAllQueryResponse;
	}
}
