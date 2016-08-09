/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ai.platform.modules.sys.dao;

import java.util.List;

import com.ai.platform.common.persistence.CrudDao;
import com.ai.platform.common.persistence.annotation.MyBatisDao;
import com.ai.platform.modules.sys.entity.Role;
import com.ai.platform.modules.sys.entity.Waitjobs;

/**
 * 代办事物DAO接口
 * @author ThinkGem
 * @version 2013-12-05
 */
@MyBatisDao
public interface WaitjobsDao extends CrudDao<Role> {

	public List<Waitjobs> selectWaitjobs(Waitjobs waitjobs);
	
}
