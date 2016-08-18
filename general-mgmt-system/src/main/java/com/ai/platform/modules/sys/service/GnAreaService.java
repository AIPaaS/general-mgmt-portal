/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ai.platform.modules.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.platform.common.persistence.Page;
import com.ai.platform.common.service.CrudService;
import com.ai.platform.modules.sys.entity.GnArea;
import com.ai.platform.modules.sys.utils.UserUtils;
import com.ai.platform.modules.sys.dao.GnAreaDao;

/**
 * Common工程统一区域代码Service
 * @author MengBo
 * @version 2016-08-17
 */
@Service
@Transactional(readOnly = true)
public class GnAreaService extends CrudService<GnAreaDao, GnArea> {

	public GnArea get(String id,String areaCode) {
		return super.get(new GnArea(id,areaCode));
	}
	

	
	public List<GnArea> findList(GnArea gnArea) {
		return UserUtils.getGnAreaList();
	}
	
	public Page<GnArea> findPage(Page<GnArea> page, GnArea gnArea) {
		return super.findPage(page, gnArea);
	}
	
	@Transactional(readOnly = false)
	public void save(GnArea gnArea) {
		super.save(gnArea);
	}
	
	@Transactional(readOnly = false)
	public void delete(GnArea gnArea) {
		super.delete(gnArea);
	}
	
}