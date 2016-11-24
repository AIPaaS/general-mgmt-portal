/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ai.platform.modules.sys.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.platform.common.service.TreeService;
import com.ai.platform.modules.sys.dao.AreaDao;
import com.ai.platform.modules.sys.entity.Area;
import com.ai.platform.modules.sys.utils.UserUtils;

/**
 * 区域Service
 * @author ThinkGem
 * @version 2014-05-16
 */
@Service
@Transactional(readOnly = true)
public class AreaService extends TreeService<AreaDao, Area> {


	@Transactional(readOnly = false)
	public void save(Area area) {
		super.save(area);
	}
	
	@Transactional(readOnly = false)
	public void delete(Area area) {
		super.delete(area);
	}
	
}
