/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ai.platform.modules.sys.dao;

import com.ai.platform.common.persistence.CrudDao;
import com.ai.platform.common.persistence.annotation.MyBatisDao;
import com.ai.platform.modules.sys.entity.IotOffice;

/**
 * 长虹物联网部门管理DAO接口
 * @author 张立华
 * @version 2016-08-11
 */
@MyBatisDao
public interface IotOfficeDao extends CrudDao<IotOffice> {
	
}