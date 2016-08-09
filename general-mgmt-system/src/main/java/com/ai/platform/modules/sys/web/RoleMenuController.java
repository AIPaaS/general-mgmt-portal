/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ai.platform.modules.sys.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ai.platform.common.persistence.Page;
import com.ai.platform.common.web.BaseController;
import com.ai.platform.modules.sys.entity.Role;
import com.ai.platform.modules.sys.service.SystemService;

/**
 * 角色菜单权限controller
 *
 * Date: 2016年8月4日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author jiaxs
 */
@Controller
@RequestMapping(value = "${adminPath}/sysmgmt/rolemenu")
public class RoleMenuController extends BaseController {

	@Autowired
	private SystemService systemService;
	
	@RequiresPermissions("sys:role:view")
	@RequestMapping(value = {"mgmtlist"})
	public String pagelist(Role role, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Role> page = new Page<Role>(request, response, 5);
		role.setPage(page);
		List<Role> list = systemService.findRoleList(role);
		page.setList(list);
		model.addAttribute("rolepage", page);
		return "modules/mgmtsys/role_menuList";
	}
}
