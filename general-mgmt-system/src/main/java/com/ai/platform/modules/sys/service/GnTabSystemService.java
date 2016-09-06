/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ai.platform.modules.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.platform.common.persistence.Page;
import com.ai.platform.common.service.CrudService;
import com.ai.platform.modules.sys.entity.GnTabSystem;
import com.ai.platform.modules.sys.utils.GnTabSystemUtils;
import com.ai.platform.modules.sys.dao.GnTabSystemDao;

/**
 * 应用配置Service
 * @author mengbo
 * @version 2016-08-11
 */
@Service
@Transactional(readOnly = true)
public class GnTabSystemService extends CrudService<GnTabSystemDao, GnTabSystem> {
	
	@Autowired
	private GnTabSystemDao gnTabSystemDao;
	
	public GnTabSystem get(String id) {
		return super.get(id);
	}
	
	public List<GnTabSystem> findList(GnTabSystem gnTabSystem) {
		return super.findList(gnTabSystem);
	}
	
	public Page<GnTabSystem> findPage(Page<GnTabSystem> page, GnTabSystem gnTabSystem) {
		return super.findPage(page, gnTabSystem);
	}
	
	@Transactional(readOnly = false)
	public void save(GnTabSystem gnTabSystem) {
		super.save(gnTabSystem);
		GnTabSystemUtils.clearCache();
	}
	
	@Transactional(readOnly = false)
	public void delete(GnTabSystem gnTabSystem) {
		super.delete(gnTabSystem);
		GnTabSystemUtils.clearCache();
	}

	public List<GnTabSystem> findAll() {
		// TODO Auto-generated method stub
		return gnTabSystemDao.findAllList(new GnTabSystem());
	}
	
}