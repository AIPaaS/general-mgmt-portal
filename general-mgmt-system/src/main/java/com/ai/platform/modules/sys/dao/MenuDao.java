/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ai.platform.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.platform.common.persistence.CrudDao;
import com.ai.platform.common.persistence.annotation.MyBatisDao;
import com.ai.platform.modules.sys.entity.Menu;

/**
 * 菜单DAO接口
 * @author ThinkGem
 * @version 2014-05-16
 */
@MyBatisDao
public interface MenuDao extends CrudDao<Menu> {

	public List<Menu> findByParentIdsLike(Menu menu);

	public List<Menu> findByUserId(Menu menu);
	
	public int updateParentIds(Menu menu);
	
	public int updateSort(Menu menu);

	public List<Menu> findMenuChilds(Menu menu);
	
}
