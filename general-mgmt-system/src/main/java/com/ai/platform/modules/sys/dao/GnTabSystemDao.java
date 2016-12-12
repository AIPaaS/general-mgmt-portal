/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ai.platform.modules.sys.dao;

import com.ai.platform.common.persistence.CrudDao;
import com.ai.platform.common.persistence.annotation.MyBatisDao;
import com.ai.platform.modules.sys.entity.GnTabSystem;

/**
 * 应用配置DAO接口
 * @author mengbo
 * @version 2016-08-11
 */
@MyBatisDao
public interface GnTabSystemDao extends CrudDao<GnTabSystem> {
	public GnTabSystem getHomeContextUrl();
	
}