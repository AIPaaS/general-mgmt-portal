/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ai.platform.modules.sys.web;

import java.util.List;
import java.util.Map;

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

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.ai.platform.common.config.Global;
import com.ai.platform.common.web.BaseController;
import com.ai.platform.common.utils.StringUtils;
import com.ai.platform.modules.sys.entity.GnArea;
import com.ai.platform.modules.sys.service.GnAreaService;

/**
 * Common工程统一区域代码Controller
 * @author MengBo
 * @version 2016-08-06
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/gnArea")
public class GnAreaController extends BaseController {

	@Autowired
	private GnAreaService gnAreaService;
	
	@ModelAttribute
	public GnArea get(@RequestParam(required=false) String id) {
		GnArea entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = gnAreaService.get(id);
		}
		if (entity == null){
			entity = new GnArea();
		}
		return entity;
	}
	
	@RequiresPermissions("sys:gnArea:view")
	@RequestMapping(value = {"list", ""})
	public String list(GnArea gnArea, HttpServletRequest request, HttpServletResponse response, Model model) {
		List<GnArea> list = gnAreaService.findList(gnArea); 
		model.addAttribute("list", list);
		return "modules/sys/gnAreaList";
	}

	@RequiresPermissions("sys:gnArea:view")
	@RequestMapping(value = "form")
	public String form(GnArea gnArea, Model model) {
		if (gnArea.getParent()!=null && StringUtils.isNotBlank(gnArea.getParent().getId())){
			gnArea.setParent(gnAreaService.get(gnArea.getParent().getId()));
			// 获取排序号，最末节点排序号+30
			if (StringUtils.isBlank(gnArea.getId())){
				GnArea gnAreaChild = new GnArea();
				gnAreaChild.setParent(new GnArea(gnArea.getParent().getId()));
				List<GnArea> list = gnAreaService.findList(gnArea); 
				if (list.size() > 0){
					gnArea.setSort(list.get(list.size()-1).getSort());
					if (gnArea.getSort() != null){
						gnArea.setSort(gnArea.getSort() + 30);
					}
				}
			}
		}
		if (gnArea.getSort() == null){
			gnArea.setSort(30);
		}
		model.addAttribute("gnArea", gnArea);
		return "modules/sys/gnAreaForm";
	}

	@RequiresPermissions("sys:gnArea:edit")
	@RequestMapping(value = "save")
	public String save(GnArea gnArea, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, gnArea)){
			return form(gnArea, model);
		}
		gnAreaService.save(gnArea);
		addMessage(redirectAttributes, "保存地区信息成功");
		return "redirect:"+Global.getAdminPath()+"/sys/gnArea/?repage";
	}
	
	@RequiresPermissions("sys:gnArea:edit")
	@RequestMapping(value = "delete")
	public String delete(GnArea gnArea, RedirectAttributes redirectAttributes) {
		gnAreaService.delete(gnArea);
		addMessage(redirectAttributes, "删除地区信息成功");
		return "redirect:"+Global.getAdminPath()+"/sys/gnArea/?repage";
	}

	@RequiresPermissions("user")
	@ResponseBody
	@RequestMapping(value = "treeData")
	public List<Map<String, Object>> treeData(@RequestParam(required=false) String extId, HttpServletResponse response) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<GnArea> list = gnAreaService.findList(new GnArea());
		for (int i=0; i<list.size(); i++){
			GnArea e = list.get(i);
			if (StringUtils.isBlank(extId) || (extId!=null && !extId.equals(e.getId()) && e.getParentIds().indexOf(","+extId+",")==-1)){
				Map<String, Object> map = Maps.newHashMap();
				map.put("id", e.getId());
				map.put("pId", e.getParentId());
				map.put("name", e.getName());
				mapList.add(map);
			}
		}
		return mapList;
	}
	
}