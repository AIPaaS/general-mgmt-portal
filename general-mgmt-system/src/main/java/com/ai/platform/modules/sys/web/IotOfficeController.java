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
import com.ai.platform.modules.sys.entity.IotOffice;
import com.ai.platform.modules.sys.service.IotOfficeService;

/**
 * 长虹物联网部门管理Controller
 * @author 张立华
 * @version 2016-08-11
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/iotOffice")
public class IotOfficeController extends BaseController {

	@Autowired
	private IotOfficeService iotOfficeService;
	
	@ModelAttribute
	public IotOffice get(@RequestParam(required=false) String id) {
		IotOffice entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = iotOfficeService.get(id);
		}
		if (entity == null){
			entity = new IotOffice();
		}
		return entity;
	}
	
	@RequiresPermissions("sys:iotOffice:view")
	@RequestMapping(value = {"list", ""})
	public String list(IotOffice iotOffice, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<IotOffice> page = iotOfficeService.findPage(new Page<IotOffice>(request, response), iotOffice); 
		model.addAttribute("page", page);
		return "modules/sys/iotOfficeList";
	}

	@RequiresPermissions("sys:iotOffice:view")
	@RequestMapping(value = "form")
	public String form(IotOffice iotOffice, Model model) {
		model.addAttribute("iotOffice", iotOffice);
		return "modules/sys/iotOfficeForm";
	}

	@RequiresPermissions("sys:iotOffice:edit")
	@RequestMapping(value = "save")
	public String save(IotOffice iotOffice, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, iotOffice)){
			return form(iotOffice, model);
		}
		iotOfficeService.save(iotOffice);
		addMessage(redirectAttributes, "保存部门管理成功");
		return "redirect:"+Global.getAdminPath()+"/sys/iotOffice/?repage";
	}
	
	@RequiresPermissions("sys:iotOffice:edit")
	@RequestMapping(value = "delete")
	public String delete(IotOffice iotOffice, RedirectAttributes redirectAttributes) {
		iotOfficeService.delete(iotOffice);
		addMessage(redirectAttributes, "删除部门管理成功");
		return "redirect:"+Global.getAdminPath()+"/sys/iotOffice/?repage";
	}

}