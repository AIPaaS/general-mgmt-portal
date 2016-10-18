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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ai.platform.common.config.Global;
import com.ai.platform.common.persistence.Page;
import com.ai.platform.common.web.BaseController;
import com.ai.platform.common.utils.StringUtils;
import com.ai.platform.modules.sys.entity.GnTenant;
import com.ai.platform.modules.sys.service.GnTenantService;

/**
 * 租户（业务平台）Controller
 * @author mengbo
 * @version 2016-10-18
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/gnTenant")
public class GnTenantController extends BaseController {

	@Autowired
	private GnTenantService gnTenantService;
	
	@ModelAttribute
	public GnTenant get(@RequestParam(required=false) String id) {
		GnTenant entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = gnTenantService.get(id);
		}
		if (entity == null){
			entity = new GnTenant();
		}
		return entity;
	}
	
	@RequiresPermissions("sys:gnTenant:view")
	@RequestMapping(value = {"list", ""})
	public String list(GnTenant gnTenant, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<GnTenant> page = gnTenantService.findPage(new Page<GnTenant>(request, response), gnTenant); 
		model.addAttribute("page", page);
		return "modules/sys/gnTenantList";
	}

	@RequiresPermissions("sys:gnTenant:view")
	@RequestMapping(value = "form")
	public String form(GnTenant gnTenant, Model model) {
		model.addAttribute("gnTenant", gnTenant);
		return "modules/sys/gnTenantForm";
	}

	@RequiresPermissions("sys:gnTenant:edit")
	@RequestMapping(value = "save")
	public String save(GnTenant gnTenant, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, gnTenant)){
			return form(gnTenant, model);
		}
		gnTenantService.save(gnTenant);
		addMessage(redirectAttributes, "保存业务平台成功");
		return "redirect:"+Global.getAdminPath()+"/sys/gnTenant/?repage";
	}
	
	@RequiresPermissions("sys:gnTenant:edit")
	@RequestMapping(value = "delete")
	public String delete(GnTenant gnTenant, RedirectAttributes redirectAttributes) {
		gnTenantService.delete(gnTenant);
		addMessage(redirectAttributes, "删除业务平台成功");
		return "redirect:"+Global.getAdminPath()+"/sys/gnTenant/?repage";
	}

}