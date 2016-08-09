/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ai.platform.modules.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.platform.common.service.TreeService;
import com.ai.platform.common.utils.StringUtils;
import com.ai.platform.modules.sys.entity.GnArea;
import com.ai.platform.modules.sys.dao.GnAreaDao;

/**
 * Common工程统一区域代码Service
 * @author MengBo
 * @version 2016-08-06
 */
@Service
@Transactional(readOnly = true)
public class GnAreaService extends TreeService<GnAreaDao, GnArea> {

	public GnArea get(String id) {
		return super.get(id);
	}
	
	public List<GnArea> findList(GnArea gnArea) {
		if (StringUtils.isNotBlank(gnArea.getParentIds())){
			gnArea.setParentIds(","+gnArea.getParentIds()+",");
		}
		return super.findList(gnArea);
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