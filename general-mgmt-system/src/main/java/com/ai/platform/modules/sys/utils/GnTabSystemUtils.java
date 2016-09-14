package com.ai.platform.modules.sys.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.platform.common.utils.SpringContextHolder;
import com.ai.platform.modules.sys.dao.GnTabSystemDao;

import com.ai.platform.modules.sys.entity.GnTabSystem;

public class GnTabSystemUtils {
	@Autowired
	private final static GnTabSystemDao gnTabSystemDao = SpringContextHolder.getBean(GnTabSystemDao.class);
	
	private GnTabSystemUtils(){
		
	}
	/**
	 * 获取当前用户授权的新区域
	 * 
	 * @return
	 */
	public static List<GnTabSystem>  cache_tabsystem_data=new ArrayList<GnTabSystem>();
	public static List<GnTabSystem> getGnTabSystemList() {
		
		if (cache_tabsystem_data == null || cache_tabsystem_data.isEmpty() ) {
			cache_tabsystem_data = new ArrayList<GnTabSystem>();
			
			cache_tabsystem_data.addAll(gnTabSystemDao.findList(new GnTabSystem()));
		}
		return cache_tabsystem_data;
	}

	

	public static GnTabSystem getGnTabSystem(String id){
		if (StringUtils.isNotBlank(id) && StringUtils.isNotBlank(id)){
			for (GnTabSystem gnTabSystem : getGnTabSystemList()){
				if((id).equals(gnTabSystem.getId())){
					return gnTabSystem;
				}
			}
		}
		return null;
	}

	public static String getGnTabSystemUrl(String id){
		if (StringUtils.isNotBlank(id) && StringUtils.isNotBlank(id)){
			for (GnTabSystem gnTabSystem : getGnTabSystemList()){
				if((id).equals(gnTabSystem.getId())){
					return gnTabSystem.getSystemUrlContext();
				}
			}
		}
		return null;
	}

	
	/**
	 * 清除数据缓存
	 */
	public static void clearCache(){
		cache_tabsystem_data = new ArrayList<GnTabSystem>();
				
	}

}
