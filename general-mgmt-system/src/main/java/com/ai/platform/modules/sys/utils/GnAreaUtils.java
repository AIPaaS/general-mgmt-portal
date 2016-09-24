package com.ai.platform.modules.sys.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.platform.common.utils.SpringContextHolder;
import com.ai.platform.modules.sys.dao.GnAreaDao;
import com.ai.platform.modules.sys.entity.Dict;
import com.ai.platform.modules.sys.entity.GnArea;

public class GnAreaUtils {
	@Autowired
	private final static GnAreaDao gnAreaDao = SpringContextHolder.getBean(GnAreaDao.class);
	
	private GnAreaUtils(){
		
	}
	/**
	 * 获取当前用户授权的新区域
	 * 
	 * @return
	 */
	public static List<GnArea>  cache_tree_data=new ArrayList<GnArea>();
	public static List<GnArea> getGnAreaList() {
		
		if (cache_tree_data == null || cache_tree_data.isEmpty() ) {
			
			cache_tree_data.addAll(GnAreaUtils.gnAreaDao.findList(new GnArea()));
		}
		return cache_tree_data;
	}

	
	public static String getAreaName(String code){
		if (StringUtils.isNotBlank(code) && StringUtils.isNotBlank(code)){
			for (GnArea gnArea : GnAreaUtils.getGnAreaList()){
				if((code).equals(gnArea.getAreaCode())){
					return gnArea.getAreaName();
				}
			}
		}
		return null;
	}
	
	public static GnArea getGnAreaByCode(String code){
		if (StringUtils.isNotBlank(code) && StringUtils.isNotBlank(code)){
			for (GnArea gnArea : GnAreaUtils.getGnAreaList()){
				if((code).equals(gnArea.getAreaCode())){
					return gnArea;
				}
			}
		}
		return null;
	}

	public static String getParentCode(String code){
		if (StringUtils.isNotBlank(code) && StringUtils.isNotBlank(code)){
			for (GnArea gnArea : GnAreaUtils.getGnAreaList()){
				if((code).equals(gnArea.getAreaCode())){
					return gnArea.getParentAreaCode();
				}
			}
		}
		return null;
	}
	
	/**
	 * 清除数据缓存
	 */
	public static void clearCache(){
		cache_tree_data = new ArrayList<GnArea>();
	}

}
