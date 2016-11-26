package com.ai.platform.modules.sys.utils;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.ai.opt.sdk.components.mcs.MCSClientFactory;
import com.ai.paas.ipaas.mcs.interfaces.ICacheClient;
import com.ai.paas.ipaas.util.SerializeUtil;
import com.ai.platform.modules.sys.entity.Office;
import com.google.common.collect.Lists;

public class OfficeUtils {
	
	private final static ICacheClient jedis = MCSClientFactory.getCacheClient("com.ai.platform.common.cache.gnarea");
	
	private OfficeUtils(){
		
	}
	/**
	 * 获取当前用户授权的新区域
	 * 
	 * @return
	 */
	public static List<Office> getOfficeList() {
		
		List<Office> officeAllList = (List<Office>) SerializeUtil.deserialize(jedis.get(("OfficeAllList").getBytes()));
		if(officeAllList==null || officeAllList.isEmpty()){
			officeAllList = UserUtils.getOfficeAllList();
			jedis.set(("OfficeAllList").getBytes(), SerializeUtil.serialize(officeAllList));
		}
		
		return officeAllList;
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
	

	public static void removeOfficeCache(){
		jedis.del(("OfficeAllList").getBytes());
	}
}
