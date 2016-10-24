package com.ai.platform.modules.sys.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.platform.common.utils.SpringContextHolder;
import com.ai.platform.modules.sys.dao.OfficeDao;
import com.ai.platform.modules.sys.entity.Office;
import com.google.common.collect.Lists;

public class OfficeUtils {
	@Autowired
	private final static OfficeDao officeDao = SpringContextHolder.getBean(OfficeDao.class);
	
	private OfficeUtils(){
		
	}
	/**
	 * 获取当前用户授权的新区域
	 * 
	 * @return
	 */
	public static List<Office>  cache_tree_data=new ArrayList<Office>();
	public static List<Office> getOfficeList() {
		
		if (cache_tree_data == null || cache_tree_data.isEmpty() ) {
			
			cache_tree_data.addAll(UserUtils.getOfficeAllList());
		}
		return cache_tree_data;
	}

	
	public static String getAreaName(String code){
		if (StringUtils.isNotBlank(code) && StringUtils.isNotBlank(code)){
			for (Office Office : OfficeUtils.getOfficeList()){
				if((code).equals(Office.getCode())){
					return Office.getName();
				}
			}
		}
		return null;
	}
	


	public static String getParentCode(String code){
		if (StringUtils.isNotBlank(code) && StringUtils.isNotBlank(code)){
			for (Office Office : OfficeUtils.getOfficeList()){
				if((code).equals(Office.getCode())){
					return Office.getParent().getName();
				}
			}
		}
		return null;
	}
	
	public static Office getParentId(String id){
		if (StringUtils.isNotBlank(id) && StringUtils.isNotBlank(id)){
			for (Office Office : OfficeUtils.getOfficeList()){
				if((id).equals(Office.getId())){
					return Office;
				}
			}
		}
		return null;
	}
	public static List<Office> getChildIdsList(String parentId){
		List<Office> mapper = Lists.newArrayList();
		if (StringUtils.isNotBlank(parentId) && StringUtils.isNotBlank(parentId)){
			for (Office Office : OfficeUtils.getOfficeList()){
				if((parentId).equals(Office.getParent().getId())){
					mapper.add(Office);
				}
			}
		}
		return mapper;
	}
	/**
	 * 清除数据缓存
	 */
	public static void clearCache(){
		cache_tree_data = new ArrayList<Office>();
	}

}
