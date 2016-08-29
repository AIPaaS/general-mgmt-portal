package com.ai.platform.modules.sys.utils;

import java.util.ArrayList;
import java.util.List;

import com.ai.platform.common.utils.SpringContextHolder;
import com.ai.platform.modules.sys.dao.GnAreaDao;
import com.ai.platform.modules.sys.entity.GnArea;

public class GnAreaUtils {
	private static GnAreaDao gnAreaDao = SpringContextHolder.getBean(GnAreaDao.class);
	
	
	/**
	 * 获取当前用户授权的新区域
	 * 
	 * @return
	 */
	private static List<GnArea>  cache_tree_data=new ArrayList<GnArea>();
	public static List<GnArea> getGnAreaList() {
		if (cache_tree_data == null || cache_tree_data.isEmpty() ) {
			cache_tree_data.addAll(gnAreaDao.findList(new GnArea()));
		}
		return cache_tree_data;
	}
	/**
	 * 清除数据缓存
	 */
	public static void clearCache(){
		cache_tree_data.clear();
		cache_tree_data=null;
	}

}
