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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ai.platform.common.config.Global;
import com.ai.platform.common.persistence.Page;
import com.ai.platform.common.utils.Encodes;
import com.ai.platform.common.utils.StringUtils;
import com.ai.platform.common.web.BaseController;
import com.ai.platform.modules.sys.entity.GnTabSystem;
import com.ai.platform.modules.sys.service.GnTabSystemService;

/**
 * 应用配置Controller
 * @author mengbo
 * @version 2016-08-11
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/gnTabSystem")
public class GnTabSystemController extends BaseController {

	@Autowired
	private GnTabSystemService gnTabSystemService;
	
	@ModelAttribute
	public GnTabSystem get(@RequestParam(required=false) String id) {
		GnTabSystem entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = gnTabSystemService.get(id);
		}
		if (entity == null){
			entity = new GnTabSystem();
		}
		return entity;
	}
	
	@RequiresPermissions("sys:gnTabSystem:view")
	@RequestMapping(value = {"list", ""})
	public String list(GnTabSystem gnTabSystem, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<GnTabSystem> page = gnTabSystemService.findPage(new Page<GnTabSystem>(request, response), gnTabSystem); 
		model.addAttribute("page", page);
		return "modules/sys/gnTabSystemList";
	}

	@RequiresPermissions("sys:gnTabSystem:view")
	@RequestMapping(value = "form")
	public String form(GnTabSystem gnTabSystem, Model model) {
		model.addAttribute("gnTabSystem", gnTabSystem);
		return "modules/sys/gnTabSystemForm";
	}

	@RequiresPermissions("sys:gnTabSystem:edit")
	@RequestMapping(value = "save")
	public String save(GnTabSystem gnTabSystem, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, gnTabSystem)){
			return form(gnTabSystem, model);
		}
		
		if (!"true".equals(checkSystemId(gnTabSystem.getSystemId(),gnTabSystem.getOldSystemId()))) {
			addMessage(model, "保存应用配置'" + gnTabSystem.getSystemId() + "'失败，应用编号已存在");
			return form(gnTabSystem, model);
		}
		if (!"true".equals(checkSystemName(gnTabSystem.getSystemName(),gnTabSystem.getOldSystemName()))) {
			addMessage(model, "保存应用配置'" + gnTabSystem.getSystemName() + "'失败，应用名称已存在");
			return form(gnTabSystem, model);
		}
		
		
		gnTabSystemService.save(gnTabSystem);
		addMessage(redirectAttributes, "保存应用配置成功");
		return "redirect:"+Global.getAdminPath()+"/sys/gnTabSystem/?repage";
	}
	
	@RequiresPermissions("sys:gnTabSystem:edit")
	@RequestMapping(value = "delete")
	public String delete(GnTabSystem gnTabSystem, RedirectAttributes redirectAttributes) {
		gnTabSystemService.delete(gnTabSystem);
		addMessage(redirectAttributes, "删除应用配置成功");
		return "redirect:"+Global.getAdminPath()+"/sys/gnTabSystem/?repage";
	}
	
	
	/**
	 * 验证应用编码是否存在
	 * 
	 * @param loginName

	 * @return
	 */
	@ResponseBody
	@RequiresPermissions("user")
	@RequestMapping(value = "checkSystemId")
	public String checkSystemId(String systemId,String oldSystemId) {
		if(systemId!=null) {
			if (oldSystemId != null && systemId.equals(oldSystemId)) {
				return "true";
			}
		}
		GnTabSystem gnTabSystem = new GnTabSystem();
		gnTabSystem.setSystemId(Encodes.urlDecode(systemId));
		if (systemId != null &&  gnTabSystemService.findvalidateList(gnTabSystem).isEmpty()) {
			return "true";
		} 
		
		return "false";
	}
	/**
	 * 验证应用名称是否存在
	 * 
	 * @param systemName
	 * @param 
	 * @return
	 */
	@ResponseBody
	@RequiresPermissions("user")
	@RequestMapping(value = "checkSystemName" )
	public String checkSystemName(String systemName,String oldSystemName) {
		if(systemName!=null) {
			if (oldSystemName != null &&systemName systemName.equals(oldSystemName)) {
				return "true";
			}
		}
		GnTabSystem gnTabSystem = new GnTabSystem();
		gnTabSystem.setSystemName(systemName);
		if (systemName != null && gnTabSystemService.findvalidateList(gnTabSystem).isEmpty()) {
			return "true";
		} 

		return "false";
	}

}