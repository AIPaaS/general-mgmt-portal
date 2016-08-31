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

import com.ai.platform.common.config.Global;
import com.ai.platform.common.persistence.Page;
import com.ai.platform.common.utils.CacheUtils;
import com.ai.platform.common.utils.EhCacheUtils;
import com.ai.platform.common.utils.StringUtils;
import com.ai.platform.common.web.BaseController;
import com.ai.platform.modules.sys.entity.GnArea;
import com.ai.platform.modules.sys.service.GnAreaService;
import com.ai.platform.modules.sys.utils.GnAreaUtils;
import com.ai.platform.modules.sys.utils.UserUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * Common工程统一区域代码Controller
 * @author MengBo
 * @version 2016-08-17
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/gnArea")
public class GnAreaController extends BaseController {

	@Autowired
	private GnAreaService gnAreaService;
	
	@ModelAttribute
	public GnArea get(@RequestParam(required=false) String id,@RequestParam(required=false) String areaCode) {
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
		Page<GnArea> page = gnAreaService.findPage(new Page<GnArea>(request, response), gnArea); 
		model.addAttribute("page", page);
		return "modules/sys/gnAreaList";
	}

	@RequiresPermissions("sys:gnArea:view")
	@RequestMapping(value = "form")
	public String form(GnArea gnArea, Model model) {
		if (gnArea.getParentAreaCode()!=null && StringUtils.isNotBlank(gnArea.getParentAreaCode())){
			gnArea.setParentAreaCode(gnArea.getParentAreaCode());
			// 获取排序号，最末节点排序号+30
			if (StringUtils.isBlank(gnArea.getAreaCode())){
				GnArea gnAreaChild = new GnArea();
				gnAreaChild.setParentAreaCode(gnArea.getParentAreaCode());
				List<GnArea> list = gnAreaService.findList(gnArea); 
				if (list.size() > 0){
					gnArea.setSortId(list.get(list.size()-1).getSortId());
					if (gnArea.getSortId() != null){
						gnArea.setSortId(gnArea.getSortId() + 30);
					}
				}
			}
			if (gnArea.getSortId() == null){
				gnArea.setSortId(30);
			}

		}

		//所属省
		if(gnArea.getProvinceCode()!=null && StringUtils.isNotBlank(gnArea.getProvinceCode())){
			gnArea.setProvinceCode(gnArea.getProvinceCode());
		}
		
		//所属市
		if(gnArea.getCityCode()!=null && StringUtils.isNotBlank(gnArea.getCityCode())){
			gnArea.setCityCode(gnArea.getCityCode());
		}		
		model.addAttribute("gnArea", gnArea);
		return "modules/sys/gnAreaForm";
	}

	@RequiresPermissions("sys:gnArea:edit")
	@RequestMapping(value = "save")
	public String save(GnArea gnArea, Model model, RedirectAttributes redirectAttributes) {

		//如果是省级 则将所属市编码插入为 000 所属省为当前区域的编码
		if("1".equals(gnArea.getAreaLevel())){
			
			gnArea.setCityCode("000");
			gnArea.setProvinceCode(gnArea.getAreaCode());
		}
		//如果是国家级 则将所属市编码插入为 000 所属省为当前区域的编码
		if("0".equals(gnArea.getAreaLevel()) ){
			gnArea.setCityCode("000");
			gnArea.setProvinceCode("00");
			
		}
		//如果是地市级所属市为当前区域的编码
		if("2".equals(gnArea.getAreaLevel()) ){
			gnArea.setCityCode(gnArea.getAreaCode());
		}
//		if (!beanValidator(model, gnArea)){
//			return form(gnArea, model);
//		}
		gnAreaService.save(gnArea);
		GnAreaUtils.clearCache();
		addMessage(redirectAttributes, "保存地区信息成功");
		return "redirect:"+Global.getAdminPath()+"/sys/gnArea/?repage";
	}
	
	@RequiresPermissions("sys:gnArea:edit")
	@RequestMapping(value = "delete")
	public String delete(GnArea gnArea, RedirectAttributes redirectAttributes) {
		gnArea.setState("0");
		
		gnAreaService.delete(gnArea);
		GnAreaUtils.clearCache();
		addMessage(redirectAttributes, "删除地区信息成功");
		return "redirect:"+Global.getAdminPath()+"/sys/gnArea/?repage";
	}

	@RequiresPermissions("user")
	@ResponseBody
	@RequestMapping(value = "treeData")
	public List<Map<String, Object>> treeData(@RequestParam(required=false) String extId, HttpServletResponse response) {
		List<Map<String, Object>>  mapList = Lists.newArrayList();
		List<GnArea> list = GnAreaUtils.getGnAreaList();
		for (int i=0; i<list.size(); i++){
			GnArea e = list.get(i);
			if (StringUtils.isBlank(extId) || (extId!=null && !extId.equals(e.getId()) )){
				Map<String, Object> map = Maps.newHashMap();
				map.put("id", e.getId());
				map.put("pId", (e.getParentAreaCode()==null ) ? "":e.getParentAreaCode());
				map.put("name", e.getAreaName());
				mapList.add(map);
			}
		}
		return mapList;
	}
}