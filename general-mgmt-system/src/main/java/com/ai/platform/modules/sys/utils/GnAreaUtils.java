package com.ai.platform.modules.sys.utils;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.opt.sdk.components.mcs.MCSClientFactory;
import com.ai.paas.ipaas.mcs.interfaces.ICacheClient;
import com.ai.paas.ipaas.util.SerializeUtil;
import com.ai.platform.common.utils.SpringContextHolder;
import com.ai.platform.modules.sys.dao.GnAreaDao;
import com.ai.platform.modules.sys.entity.GnArea;
import com.google.common.collect.Lists;

public class GnAreaUtils {
	@Autowired
	private final static GnAreaDao gnAreaDao = SpringContextHolder.getBean(GnAreaDao.class);
	
	private final static ICacheClient jedis = MCSClientFactory.getCacheClient("com.ai.platform.common.cache.gnarea");
	
	private static List<GnArea> listAll = Lists.newArrayList();
	private GnAreaUtils(){
		
	}
	/**
	 * 获取当前用户授权的新区域
	 * 
	 * @return
	 */
	public static List<GnArea> getGnAreaList() {
		
		byte[] in = jedis.get("areaTreeALL".getBytes());  
		listAll = (List<GnArea>)SerializeUtil.deserialize(in); 
		if(listAll==null || listAll.isEmpty()){
			listAll= Lists.newArrayList();
			listAll = GnAreaUtils.gnAreaDao.findList(new GnArea());
			jedis.set("areaTreeALL".getBytes(),SerializeUtil.serialize(listAll));
		}
		
		return listAll;
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
	
	
	public static List<GnArea> getParentCodeList(String code){
		List<GnArea> mapper = Lists.newArrayList();
		if (StringUtils.isNotBlank(code) && StringUtils.isNotBlank(code)){
			for (GnArea gnArea : GnAreaUtils.getGnAreaList()){
				if((code).equals(gnArea.getParentAreaCode())){
					mapper.add(gnArea);
				}
			}
		}
		return mapper;
	}
	
	public static void cleanAreaCache(){
		jedis.del("areaTreeALL".getBytes());
	}

}
