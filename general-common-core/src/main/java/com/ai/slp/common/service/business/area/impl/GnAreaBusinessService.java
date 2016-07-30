package com.ai.slp.common.service.business.area.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.slp.common.api.area.param.GnAreaCodeCondition;
import com.ai.slp.common.api.area.param.GnAreaCondition;
import com.ai.slp.common.api.area.param.GnAreaPageCondition;
import com.ai.slp.common.api.area.param.GnAreaPageFilterCondition;
import com.ai.slp.common.api.area.param.GnAreaVo;
import com.ai.slp.common.constants.Constants;
import com.ai.slp.common.dao.mapper.bo.GnArea;
import com.ai.slp.common.service.atom.area.impl.GnAreaAtomServiceImpl;
import com.ai.slp.common.service.business.area.IGnAreaBusinessService;
import com.ai.slp.common.util.AreaCacheUtil;
import com.ai.slp.common.util.CommonSeqUtil;

@Component
@Transactional
public class GnAreaBusinessService implements IGnAreaBusinessService {

    @Autowired
    private GnAreaAtomServiceImpl gnAreaAtomService;

    @Override
    public List<GnArea> select(GnAreaCondition condition) {
        return gnAreaAtomService.select(condition);
    }

    @Override
    public GnArea selectByID(String areaCode) {
        return gnAreaAtomService.selectByID(areaCode);
    }

	@Override
	public List<GnArea> getProvinceList() throws BusinessException,SystemException {
		return gnAreaAtomService.getProvinceList();
	}

	@Override
	public List<GnArea> getParentAreaListByAreaCode(GnAreaCodeCondition condition)
			throws BusinessException,SystemException {
		return gnAreaAtomService.getParentAreaListByAreaCode(condition);
	}

	@Override
	public List<GnArea> getCityListByProviceCode(String provinceCode) {
		return gnAreaAtomService.getCityListByProviceCode(provinceCode);
	}

	@Override
	public List<GnArea> getCountyListByCityCode(String cityCode) {
		return gnAreaAtomService.getCountyListByCityCode(cityCode);
	}

	@Override
	public List<GnArea> getStreetListByCountyCode(String countyCode) {
		return gnAreaAtomService.getStreetListByCountyCode(countyCode);
	}

	@Override
	public List<GnArea> getAreaListByStreetCode(String streetCode) {
		return gnAreaAtomService.getAreaListByStreetCode(streetCode);
	}

	@Override
	public String addArea(GnAreaVo area) {
		GnArea bo=new GnArea();
		BeanUtils.copyProperties(bo, area);
		bo.setAreaCode(CommonSeqUtil.getAreaCode());
		bo.setState(Constants.AreaState.ACTIVITY);
		String areaCode=gnAreaAtomService.addArea(bo);
		AreaCacheUtil.updateAreaCacheData(bo);
		return areaCode;
	}

	@Override
	public void modifyArea(GnAreaVo area) {
		GnArea bo=new GnArea();
		BeanUtils.copyProperties(bo, area);
		gnAreaAtomService.modifyArea(bo);
		GnArea newbo=gnAreaAtomService.selectByID(area.getAreaCode());
		AreaCacheUtil.updateAreaCacheData(newbo);
	}

	@Override
	public void deleteArea(GnAreaCondition gnAreaCondition) {
		gnAreaAtomService.deleteArea(gnAreaCondition);
	}

	@Override
	public void deleteAreas(List<GnAreaCondition> gnAreaCondition) {
		gnAreaAtomService.deleteAreas(gnAreaCondition);
	}

	@Override
	public PageInfo<GnAreaVo> getAreaListByPage(GnAreaPageCondition areaPage) {
		PageInfo<GnAreaVo> pageResult=new PageInfo<GnAreaVo>();
		PageInfo<GnArea> pageInfo=gnAreaAtomService.getAreaListByPage(areaPage);
		pageResult.setCount(pageInfo.getCount());
		pageResult.setPageSize(pageInfo.getPageSize());
		pageResult.setPageNo(pageInfo.getPageNo());
		List<GnAreaVo> areaVoList=new ArrayList<GnAreaVo>();
		if(pageInfo.getResult()!=null&&!CollectionUtil.isEmpty(pageInfo.getResult())){
			for(GnArea area:pageInfo.getResult()){
				GnAreaVo areaVo=new GnAreaVo();
				BeanUtils.copyProperties(areaVo, area);
				areaVoList.add(areaVo);
			}
			pageResult.setResult(areaVoList);
		}
		return pageResult;
	}

	@Override
	public List<GnArea> getNationList() {
		return gnAreaAtomService.getNationList();
	}

	@Override
	public PageInfo<GnAreaVo> getFilterAreaListByPage(GnAreaPageFilterCondition areaPage) {
		PageInfo<GnAreaVo> pageResult=new PageInfo<GnAreaVo>();
		PageInfo<GnArea> pageInfo=gnAreaAtomService.getFilterAreaListByPage(areaPage);
		pageResult.setCount(pageInfo.getCount());
		pageResult.setPageSize(pageInfo.getPageSize());
		pageResult.setPageNo(pageInfo.getPageNo());
		List<GnAreaVo> areaVoList=new ArrayList<GnAreaVo>();
		if(pageInfo.getResult()!=null&&!CollectionUtil.isEmpty(pageInfo.getResult())){
			for(GnArea area:pageInfo.getResult()){
				GnAreaVo areaVo=new GnAreaVo();
				BeanUtils.copyProperties(areaVo, area);
				areaVoList.add(areaVo);
			}
			pageResult.setResult(areaVoList);
		}
		return pageResult;
	}

    @Override
    public List<GnArea> selectByName(GnAreaCondition condition) {
        return gnAreaAtomService.selectByName(condition);
    }
    
    
}
