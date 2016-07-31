package com.ai.slp.common.service.atom.office.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.slp.common.dao.mapper.bo.SysOffice;
import com.ai.slp.common.dao.mapper.bo.SysOfficeCriteria;
import com.ai.slp.common.dao.mapper.bo.SysOfficeCriteria.Criteria;
import com.ai.slp.common.dao.mapper.factory.MapperFactory;
import com.ai.slp.common.service.atom.office.ISysOfficeAtomService;

@Component
public class SysOfficeAtomService implements ISysOfficeAtomService{

	@Override
	public SysOffice selectSysOfficeInfo(String id) {
		return MapperFactory.getSysOfficeMapper().selectByPrimaryKey(id);
	}

	@Override
	public List<SysOffice> selectSysOfficeList(List<String> idList) {
		SysOfficeCriteria example = new SysOfficeCriteria();
		Criteria officeCriteria = example.createCriteria();
		officeCriteria.andIdIn(idList);
		return MapperFactory.getSysOfficeMapper().selectByExample(example );
	}

}
