package com.ai.slp.common.api.area.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.slp.common.api.area.interfaces.IGnAreaQuerySV;
import com.ai.slp.common.api.area.param.GnAreaCodeCondition;
import com.ai.slp.common.api.area.param.GnAreaCondition;
import com.ai.slp.common.api.area.param.GnAreaPageCondition;
import com.ai.slp.common.api.area.param.GnAreaPageFilterCondition;
import com.ai.slp.common.api.area.param.GnAreaVo;
import com.ai.slp.common.dao.mapper.bo.GnArea;
import com.ai.slp.common.service.business.area.IGnAreaBusinessService;
import com.ai.slp.common.util.VoValidateUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.google.gson.Gson;

@Service
@Component
public class GnAreaQuerySVImpl implements IGnAreaQuerySV {

    @Autowired
    private IGnAreaBusinessService iGnAreaBusinessService;

    @Override
    public GnAreaVo selectByID(GnAreaCondition condition) throws BusinessException,SystemException {
        if (StringUtils.isEmpty(condition.getAreaCode())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "区域编码不能为空");
        }
        Gson gson = new Gson();
        return gson.fromJson(
                gson.toJson(iGnAreaBusinessService.selectByID(condition.getAreaCode())),
                GnAreaVo.class);
    }

    @Override
    public GnAreaVo queryGnArea(String areaCode) throws BusinessException,SystemException {
        if (StringUtils.isEmpty(areaCode)) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "区域编码不能为空");
        }
        Gson gson = new Gson();
        return gson.fromJson(gson.toJson(iGnAreaBusinessService.selectByID(areaCode)),
                GnAreaVo.class);
    }

	@Override
	public List<GnAreaVo> getProvinceList() throws BusinessException,SystemException {
		List<GnArea> dbList=iGnAreaBusinessService.getProvinceList();
		List<GnAreaVo> resultList=null;
		if(!CollectionUtil.isEmpty(dbList)){
			resultList=new ArrayList<GnAreaVo>();
			for(GnArea area : dbList){
				GnAreaVo areavo=new GnAreaVo();
				BeanUtils.copyProperties(areavo, area);
				resultList.add(areavo);
			}
		}
		
		return resultList;
	}

	@Override
	public List<GnAreaVo> getParentAreaListByAreaCode(GnAreaCodeCondition condition)
			throws BusinessException,SystemException {
		VoValidateUtils.validateGetParentAreaListByAreaCode(condition);
		List<GnArea> dbList=iGnAreaBusinessService.getParentAreaListByAreaCode(condition);
		List<GnAreaVo> resultList=null;
		if(!CollectionUtil.isEmpty(dbList)){
			resultList=new ArrayList<GnAreaVo>();
			for(GnArea area : dbList){
				GnAreaVo areavo=new GnAreaVo();
				BeanUtils.copyProperties(areavo, area);
				resultList.add(areavo);
			}
		}
		return resultList;
	}

	
	@Override
	public List<GnAreaVo> getCityListByProviceCode(String provinceCode){
		VoValidateUtils.validateGetCityListByProviceCode(provinceCode);
		List<GnArea> dbList=iGnAreaBusinessService.getCityListByProviceCode(provinceCode);
		List<GnAreaVo> resultList=null;
		if(!CollectionUtil.isEmpty(dbList)){
			resultList=new ArrayList<GnAreaVo>();
			for(GnArea area : dbList){
				GnAreaVo areavo=new GnAreaVo();
				BeanUtils.copyProperties(areavo, area);
				resultList.add(areavo);
			}
		}
		
		return resultList;
	}

	@Override
	public List<GnAreaVo> getCountyListByCityCode(String cityCode)
			throws BusinessException,SystemException {
		VoValidateUtils.validateGetCountyListByCityCode(cityCode);
		List<GnArea> dbList=iGnAreaBusinessService.getCountyListByCityCode(cityCode);
		List<GnAreaVo> resultList=null;
		if(!CollectionUtil.isEmpty(dbList)){
			resultList=new ArrayList<GnAreaVo>();
			for(GnArea area : dbList){
				GnAreaVo areavo=new GnAreaVo();
				BeanUtils.copyProperties(areavo, area);
				resultList.add(areavo);
			}
		}
		
		return resultList;
	}

	@Override
	public List<GnAreaVo> getStreetListByCountyCode(String countyCode)
			throws BusinessException,SystemException {
		VoValidateUtils.validateGetStreetListByCountyCode(countyCode);
		List<GnArea> dbList=iGnAreaBusinessService.getStreetListByCountyCode(countyCode);
		List<GnAreaVo> resultList=null;
		if(!CollectionUtil.isEmpty(dbList)){
			resultList=new ArrayList<GnAreaVo>();
			for(GnArea area : dbList){
				GnAreaVo areavo=new GnAreaVo();
				BeanUtils.copyProperties(areavo, area);
				resultList.add(areavo);
			}
		}
		
		return resultList;
	}

	@Override
	public PageInfo<GnAreaVo> getAreaListByPage(GnAreaPageCondition areaPage)
			throws BusinessException,SystemException {
		VoValidateUtils.validateGetAreaListByPage(areaPage);
		return iGnAreaBusinessService.getAreaListByPage(areaPage);
	}

	@Override
	public List<GnAreaVo> getNationList() throws BusinessException,SystemException {
		List<GnArea> dbList=iGnAreaBusinessService.getNationList();
		List<GnAreaVo> resultList=null;
		if(!CollectionUtil.isEmpty(dbList)){
			resultList=new ArrayList<GnAreaVo>();
			for(GnArea area : dbList){
				GnAreaVo areavo=new GnAreaVo();
				BeanUtils.copyProperties(areavo, area);
				resultList.add(areavo);
			}
		}
		
		return resultList;
	}

	@Override
	public PageInfo<GnAreaVo> getFilterAreaListByPage(GnAreaPageFilterCondition areaPage) throws BusinessException,SystemException {
		VoValidateUtils.validateGetFilterAreaListByPage(areaPage);
		return iGnAreaBusinessService.getFilterAreaListByPage(areaPage);
	}

    @Override
    public List<GnAreaVo> getAreaByName(GnAreaCondition condition)
            throws BusinessException, SystemException {
        List<GnArea> dbList = iGnAreaBusinessService.selectByName(condition);
        List<GnAreaVo> resultList=null;
        if(!CollectionUtil.isEmpty(dbList)){
            resultList=new ArrayList<GnAreaVo>();
            for(GnArea area : dbList){
                GnAreaVo areavo=new GnAreaVo();
                BeanUtils.copyProperties(areavo, area);
                resultList.add(areavo);
            }
        }
        return resultList;
    }
}
