package com.ai.platform.modules.sys.utils;

import java.util.List;

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
	public static List<GnTabSystem> getGnTabSystemList() {
		return gnTabSystemDao.findList(new GnTabSystem());
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
	public static String getGnTabSystemName(String id){
		if (StringUtils.isNotBlank(id) && StringUtils.isNotBlank(id)){
			for (GnTabSystem gnTabSystem : getGnTabSystemList()){
				if((id).equals(gnTabSystem.getId())){
					return gnTabSystem.getSystemName();
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

	

}
