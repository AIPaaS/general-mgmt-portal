package com.ai.slp.common.service.atom.office;

import java.util.List;

import com.ai.slp.common.dao.mapper.bo.SysOffice;

public interface ISysOfficeAtomService {
	
	SysOffice selectSysOfficeInfo(String id);
	
	List<SysOffice> selectSysOfficeList(List<String> idList);
	
}
