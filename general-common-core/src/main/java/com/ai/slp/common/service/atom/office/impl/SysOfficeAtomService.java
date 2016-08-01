package com.ai.slp.common.service.atom.office.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.slp.common.constants.VOConstants.DeleteFlagConstant;
import com.ai.slp.common.constants.VOConstants.UseableFlagConstant;
import com.ai.slp.common.dao.mapper.bo.SysOffice;
import com.ai.slp.common.dao.mapper.bo.SysOfficeCriteria;
import com.ai.slp.common.dao.mapper.bo.SysOfficeCriteria.Criteria;
import com.ai.slp.common.dao.mapper.factory.MapperFactory;
import com.ai.slp.common.service.atom.office.ISysOfficeAtomService;

@Component
public class SysOfficeAtomService implements ISysOfficeAtomService{

	@Override
	public SysOffice selectSysOfficeInfo(String id) {
		//return MapperFactory.getSysOfficeMapper().selectByPrimaryKey(id);
		SysOfficeCriteria example = new SysOfficeCriteria();
		Criteria officeCriteria = example.createCriteria();
		officeCriteria.andIdEqualTo(id);
		officeCriteria.andUseableEqualTo(UseableFlagConstant.YES);
		officeCriteria.andDelFlagEqualTo(DeleteFlagConstant.NO);
		List<SysOffice> sysOfficeList = MapperFactory.getSysOfficeMapper().selectByExample(example);
		if(sysOfficeList != null){
			return sysOfficeList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public List<SysOffice> selectSysOfficeList(List<String> ids) {
		SysOfficeCriteria example = new SysOfficeCriteria();
		Criteria officeCriteria = example.createCriteria();
		officeCriteria.andIdIn(ids);
		officeCriteria.andUseableEqualTo(UseableFlagConstant.YES);
		officeCriteria.andDelFlagEqualTo(DeleteFlagConstant.NO);
		return MapperFactory.getSysOfficeMapper().selectByExample(example );
	}

	@Override
	public List<SysOffice> selectSysOfficeAll(String tenantId) {
		SysOfficeCriteria example = new SysOfficeCriteria();
		Criteria officeCriteria = example.createCriteria();
		officeCriteria.andTenantIdEqualTo(tenantId);
		officeCriteria.andUseableEqualTo(UseableFlagConstant.YES);
		officeCriteria.andDelFlagEqualTo(DeleteFlagConstant.NO);
		return MapperFactory.getSysOfficeMapper().selectByExample(example);
	}

	@Override
	public List<SysOffice> selectChildrenOfficeList(String id,String tenantId) {
		List<SysOffice> childrenOfficeList = new LinkedList<SysOffice>();
		getChildrenOffices(id, tenantId, childrenOfficeList);
		return childrenOfficeList;
	}
	
	private void getChildrenOffices(String id,String tenantId,List<SysOffice> OfficeList){
		SysOfficeCriteria example = new SysOfficeCriteria();
		Criteria officeCriteria = example.createCriteria();
		officeCriteria.andTenantIdEqualTo(tenantId);
		officeCriteria.andUseableEqualTo(UseableFlagConstant.YES);
		officeCriteria.andDelFlagEqualTo(DeleteFlagConstant.NO);
		officeCriteria.andParentIdEqualTo(id);
		List<SysOffice> selectByExample = MapperFactory.getSysOfficeMapper().selectByExample(example);
		if(selectByExample != null){
			OfficeList.addAll(selectByExample);
			for(SysOffice sysOffice : selectByExample){
				getChildrenOffices(sysOffice.getId(),tenantId,OfficeList);
			}
		}
	}

}
