/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ai.platform.modules.sys.dao;

import com.ai.platform.common.persistence.CrudDao;
import com.ai.platform.common.persistence.annotation.MyBatisDao;
import com.ai.platform.modules.sys.entity.Role;
import com.ai.platform.modules.sys.entity.RoleMenu;

/**
 * 角色DAO接口
 * @author ThinkGem
 * @version 2013-12-05
 */
@MyBatisDao
public interface RoleMenuDao extends CrudDao<Role> {

	/**
	 * 维护角色与菜单权限关系
	 * @param role
	 * @return
	 */
	public int deleteRoleMenu(RoleMenu roleMenu);

	public int insertRoleMenu(RoleMenu roleMenu);
	
}
