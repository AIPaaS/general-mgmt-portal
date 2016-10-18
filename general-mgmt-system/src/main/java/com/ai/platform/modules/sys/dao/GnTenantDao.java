/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ai.platform.modules.sys.dao;

import com.ai.platform.common.persistence.CrudDao;
import com.ai.platform.common.persistence.annotation.MyBatisDao;
import com.ai.platform.modules.sys.entity.GnTenant;

/**
 * 租户（业务平台）DAO接口
 * @author mengbo
 * @version 2016-10-18
 */
@MyBatisDao
public interface GnTenantDao extends CrudDao<GnTenant> {
	
}