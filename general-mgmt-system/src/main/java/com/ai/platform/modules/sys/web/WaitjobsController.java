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

import com.ai.platform.common.web.BaseController;
import com.ai.platform.modules.sys.entity.Waitjobs;
import com.ai.platform.modules.sys.service.SystemService;
import com.ai.platform.modules.sys.utils.UserUtils;

/**
 * 代办事物controller
 *
 * Date: 2016年8月8日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author jiaxs
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/waitjobs")
public class WaitjobsController extends BaseController {

	@Autowired
	private SystemService systemService;
	
	@RequiresPermissions("sys:waitjobs:view")
	@RequestMapping(value = {"list"})
	public String pagelist(HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = UserUtils.getUser().getId();
		List<Waitjobs> waitjobsList = systemService.getWaitjobs(userId);
		model.addAttribute("list", waitjobsList);
		return "modules/mgmtsys/waitjobsList";
	}
}
