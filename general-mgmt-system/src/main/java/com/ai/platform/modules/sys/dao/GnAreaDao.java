/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ai.platform.modules.sys.dao;

import com.ai.platform.common.persistence.TreeDao;
import com.ai.platform.common.persistence.annotation.MyBatisDao;
import com.ai.platform.modules.sys.entity.GnArea;

/**
 * Common工程统一区域代码DAO接口
 * @author MengBo
 * @version 2016-08-06
 */
@MyBatisDao
public interface GnAreaDao extends TreeDao<GnArea> {
	
}