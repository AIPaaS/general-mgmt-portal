package com.ai.slp.common.service.atom.office;

import java.util.List;

import com.ai.slp.common.dao.mapper.bo.SysOffice;

public interface ISysOfficeAtomService {
	
	SysOffice selectSysOfficeInfo(String id);
	
	/**
	 * 查询当前租户所有机构数据
	 * @param tenantId
	 * @return
	 */
	List<SysOffice> selectSysOfficeAll(String tenantId);
	
	/**
	 * 获取当前id及所有上级节点
	 * @param ids
	 * @return
	 */
	List<SysOffice> selectSysOfficeList(List<String> ids);
	
	/**
	 * 查询当前id及所有子集几点对象集合
	 * @param id
	 * @return
	 */
	List<SysOffice> selectChildrenOfficeList(String id, String tenantId);
	
}
