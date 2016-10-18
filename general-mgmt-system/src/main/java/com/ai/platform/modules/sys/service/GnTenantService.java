/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ai.platform.modules.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.platform.common.persistence.Page;
import com.ai.platform.common.service.CrudService;
import com.ai.platform.modules.sys.entity.GnTenant;
import com.ai.platform.modules.sys.dao.GnTenantDao;

/**
 * 租户（业务平台）Service
 * @author mengbo
 * @version 2016-10-18
 */
@Service
@Transactional(readOnly = true)
public class GnTenantService extends CrudService<GnTenantDao, GnTenant> {

	public GnTenant get(String id) {
		return super.get(id);
	}
	
	public List<GnTenant> findList(GnTenant gnTenant) {
		return super.findList(gnTenant);
	}
	
	public Page<GnTenant> findPage(Page<GnTenant> page, GnTenant gnTenant) {
		return super.findPage(page, gnTenant);
	}
	
	@Transactional(readOnly = false)
	public void save(GnTenant gnTenant) {
		super.save(gnTenant);
	}
	
	@Transactional(readOnly = false)
	public void delete(GnTenant gnTenant) {
		super.delete(gnTenant);
	}
	
}