/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ai.platform.modules.sys.dao;

import java.util.List;

import com.ai.platform.common.persistence.CrudDao;
import com.ai.platform.common.persistence.annotation.MyBatisDao;
import com.ai.platform.modules.sys.entity.Role;

/**
 * 角色DAO接口
 * @author ThinkGem
 * @version 2013-12-05
 */
@MyBatisDao
public interface RoleDao extends CrudDao<Role> {

	public Role getByName(Role role);
	
	public Role getByEnname(Role role);

	/**
	 * 维护角色与菜单权限关系
	 * @param role
	 * @return
	 */
	public int deleteRoleMenu(Role role);

	public int insertRoleMenu(Role role);
	
	/**
	 * 维护角色与公司部门关系
	 * @param role
	 * @return
	 */
	public int deleteRoleOffice(Role role);

	public int insertRoleOffice(Role role);
	
	/**
	 * 过滤权限 根据条件查询所有
	 * @param role
	 * @return
	 * @author jiaxs
	 * @ApiDocMethod
	 * @ApiCode
	 * @RestRelativeURL
	 */
	public List<Role> findListByParams(Role role);
	
	/**
	 * 不过滤权限 根据条件查询所有
	 * @param role
	 * @return
	 * @author jiaxs
	 * @ApiDocMethod
	 * @ApiCode
	 * @RestRelativeURL
	 */
	public List<Role> findAllByParams(Role role);
	
}
