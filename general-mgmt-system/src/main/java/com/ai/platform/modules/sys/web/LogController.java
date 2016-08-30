/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ai.platform.modules.sys.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ai.platform.common.persistence.Page;
import com.ai.platform.common.web.BaseController;
import com.ai.platform.modules.sys.entity.Log;
import com.ai.platform.modules.sys.entity.User;
import com.ai.platform.modules.sys.service.LogService;
import com.ai.platform.modules.sys.service.SystemService;

/**
 * 日志Controller
 * @author ThinkGem
 * @version 2013-6-2
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/log")
public class LogController extends BaseController {

	@Autowired
	private LogService logService;
	
	@RequiresPermissions("sys:log:view")
	@RequestMapping(value = {"list",""})
	public String list(Log log, HttpServletRequest request, HttpServletResponse response, Model model) {
		log.setTitle("系统登录");
//		if(log !=null && log.getCreateBy() !=null && log.getCreateBy().getName() !=null){
//			User user = systemService.getUserByName(log.getCreateBy().getName());
//			log.setCreateBy(user);
//		}
		Page<Log> page = logService.findPage(new Page<Log>(request, response), log); 
        model.addAttribute("page", page);
		return "modules/sys/logList";
	}
	
	
	@RequiresPermissions("sys:log:view")
	@RequestMapping(value = {"page"})
	public String page(Log log, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<Log> page = logService.findPage(new Page<Log>(request, response,5), log); 
        model.addAttribute("page", page);
		return "modules/mgmtsys/logList";
	}

}
