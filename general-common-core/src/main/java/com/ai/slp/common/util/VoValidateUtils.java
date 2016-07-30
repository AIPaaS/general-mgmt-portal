package com.ai.slp.common.util;

import java.util.List;

import org.springframework.util.StringUtils;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.slp.common.api.area.param.AreaLevel;
import com.ai.slp.common.api.area.param.GnAreaCodeCondition;
import com.ai.slp.common.api.area.param.GnAreaCondition;
import com.ai.slp.common.api.area.param.GnAreaPageCondition;
import com.ai.slp.common.api.area.param.GnAreaPageFilterCondition;
import com.ai.slp.common.api.area.param.GnAreaVo;
import com.ai.slp.common.api.servicenum.param.ServicePhoneCond;


public final class VoValidateUtils {

    private VoValidateUtils() {
    }
   

	public static void validateGetParentAreaListByAreaCode(
			GnAreaCodeCondition condition) {
		if (condition==null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		if (StringUtils.isEmpty(condition.getTenantId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
		}
		if (StringUtils.isEmpty(condition.getAreaCode())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "区域编码不能为空");
        }
	}

	public static void validateGetCityListByProviceCode(String provinceCode) {
		if (StringUtils.isEmpty(provinceCode)) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "省份code不能为空");
		}
	}
	public static void validateGetCountyListByCityCode(String cityCode) {
		if (StringUtils.isEmpty(cityCode)) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "地市code不能为空");
		}
	}
	public static void validateGetStreetListByCountyCode(String countyCode) {
		if (StringUtils.isEmpty(countyCode)) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "区县code不能为空");
		}
	}

	public static void validateGetAreaListByStreetCode(String tenantId,
			String streetCode) {
		if (StringUtils.isEmpty(tenantId)) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
		}
		if (StringUtils.isEmpty(streetCode)) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "街道code不能为空");
		}
		
	}
	public static void validateAddArea(GnAreaVo area){
		if(area==null){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		if (StringUtils.isEmpty(area.getTenantId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
		}
		if (StringUtils.isEmpty(area.getAreaName())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "小区名称不能为空");
		}
		if (StringUtils.isEmpty(area.getProvinceCode())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "省份编码不能为空");
		}
		if (StringUtils.isEmpty(area.getCityCode())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "地市编码不能为空");
		}
		if (StringUtils.isEmpty(area.getAreaLevel())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "区域级别不能为空");
		}
		if (!AreaLevel.AREA_LEVEL.getLevelValue().equals(area.getAreaLevel())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "小区级别必须为5");
		}
		
	}
	public static void validateModifyArea(GnAreaVo area){
		if(area==null){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		if (StringUtils.isEmpty(area.getTenantId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
		}
		if (StringUtils.isEmpty(area.getAreaCode())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "小区编码不能为空");
		}
		if (StringUtils.isEmpty(area.getAreaName())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "小区名称不能为空");
		}
		if (StringUtils.isEmpty(area.getProvinceCode())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "省份编码不能为空");
		}
		if (StringUtils.isEmpty(area.getCityCode())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "地市编码不能为空");
		}
		if (StringUtils.isEmpty(area.getAreaLevel())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "区域级别不能为空");
		}
		if (!AreaLevel.AREA_LEVEL.getLevelValue().equals(area.getAreaLevel())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "小区级别必须为5");
		}
		
	}
	public static void validateDeleteArea(GnAreaCondition area){
		if(area==null){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		if (StringUtils.isEmpty(area.getTenantId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
		}
		if (StringUtils.isEmpty(area.getAreaCode())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "小区编码不能为空");
		}		
		if (StringUtils.isEmpty(area.getAreaLevel())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "区域级别不能为空");
		}
		if (!AreaLevel.AREA_LEVEL.getLevelValue().equals(area.getAreaLevel().getLevelValue())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "小区级别必须为5");
		}
		
	}
	public static void validateDeleteAreas(List<GnAreaCondition> areaList){
		if(areaList==null){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		if(!CollectionUtil.isEmpty(areaList)){
			for(GnAreaCondition area:areaList){
				if (StringUtils.isEmpty(area.getTenantId())) {
					throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
				}
				if (StringUtils.isEmpty(area.getAreaCode())) {
					throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "小区编码不能为空");
				}		
				if (StringUtils.isEmpty(area.getAreaLevel())) {
					throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "区域级别不能为空");
				}
				if (!AreaLevel.AREA_LEVEL.getLevelValue().equals(area.getAreaLevel().getLevelValue())) {
					throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "小区级别必须为5");
				}				
			}
		}
		
	}
	
	public static void validateGetAreaListByPage(GnAreaPageCondition areaPage) {
		if(areaPage==null){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		if (StringUtils.isEmpty(areaPage.getTenantId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
		}
		if (areaPage.getPageNo()<1) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_TYPE_NOT_RIGHT, "查询页面pageNo必须大于0");
		}
		if (areaPage.getPageSize()<1) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_TYPE_NOT_RIGHT, "查询页面pageSize必须大于0");
		}
		
	}

	public static void validateGetFilterAreaListByPage(GnAreaPageFilterCondition areaPage) {
		if(areaPage==null){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		if (StringUtils.isEmpty(areaPage.getTenantId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
		}
		if (areaPage.getPageNo()<1) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_TYPE_NOT_RIGHT, "查询页面pageNo必须大于0");
		}
		if (areaPage.getPageSize()<1) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_TYPE_NOT_RIGHT, "查询页面pageSize必须大于0");
		}
	}


	public static void validateGetServiceNumByIpPhone(String phone) {
		if (StringUtils.isEmpty(phone)) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "手机号码不能为空");
		}
	}


	public static void validateGetIpAddrByIp(String ip) {
		if (StringUtils.isEmpty(ip)) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "IP不能为空");
		}
		
	}


	public static void validateGetServiceNum(ServicePhoneCond cond) {
		
		if (null==cond) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		if (StringUtils.isEmpty(cond.getPhone())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "手机号码不能为空");
		}
	}


}
