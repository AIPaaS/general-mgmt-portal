/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ai.platform.modules.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.platform.common.persistence.Page;
import com.ai.platform.common.service.CrudService;
import com.ai.platform.modules.sys.entity.IotOffice;
import com.ai.platform.modules.sys.dao.IotOfficeDao;

/**
 * 长虹物联网部门管理Service
 * @author 张立华
 * @version 2016-08-11
 */
@Service
@Transactional(readOnly = true)
public class IotOfficeService extends CrudService<IotOfficeDao, IotOffice> {

	public IotOffice get(String id) {
		return super.get(id);
	}
	
	public List<IotOffice> findList(IotOffice iotOffice) {
		return super.findList(iotOffice);
	}
	
	public Page<IotOffice> findPage(Page<IotOffice> page, IotOffice iotOffice) {
		return super.findPage(page, iotOffice);
	}
	
	@Transactional(readOnly = false)
	public void save(IotOffice iotOffice) {
		super.save(iotOffice);
	}
	
	@Transactional(readOnly = false)
	public void delete(IotOffice iotOffice) {
		super.delete(iotOffice);
	}
	
}