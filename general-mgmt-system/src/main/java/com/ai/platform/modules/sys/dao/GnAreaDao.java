/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ai.platform.modules.sys.dao;

import java.util.List;

import com.ai.platform.common.persistence.CrudDao;
import com.ai.platform.common.persistence.annotation.MyBatisDao;
import com.ai.platform.modules.sys.entity.GnArea;

/**
 * Common工程统一区域代码DAO接口
 * @author MengBo
 * @version 2016-08-17
 */
@MyBatisDao
public interface GnAreaDao extends CrudDao<GnArea> {
	public List<GnArea> findListByParentAreaCode(String parentAreaCode);
	
}