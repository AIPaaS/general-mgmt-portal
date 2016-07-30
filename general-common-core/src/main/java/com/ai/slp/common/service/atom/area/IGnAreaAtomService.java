package com.ai.slp.common.service.atom.area;

import java.util.List;

import com.ai.opt.base.vo.PageInfo;
import com.ai.slp.common.api.area.param.GnAreaCodeCondition;
import com.ai.slp.common.api.area.param.GnAreaCondition;
import com.ai.slp.common.api.area.param.GnAreaPageCondition;
import com.ai.slp.common.api.area.param.GnAreaPageFilterCondition;
import com.ai.slp.common.dao.mapper.bo.GnArea;

public interface IGnAreaAtomService {

    List<GnArea> select(GnAreaCondition condition);
    GnArea selectByID(String areaCode);
    
    List<GnArea> getProvinceList();
    List<GnArea> getParentAreaListByAreaCode(GnAreaCodeCondition condition);
    
    List<GnArea> getCityListByProviceCode(String provinceCode);
    List<GnArea> getCountyListByCityCode(String cityCode);
    List<GnArea> getStreetListByCountyCode(String countyCode);
    List<GnArea> getAreaListByStreetCode(String streetCode);
    List<GnArea> getNationList();
    PageInfo<GnArea> getAreaListByPage(GnAreaPageCondition areaPage);
    PageInfo<GnArea> getFilterAreaListByPage(GnAreaPageFilterCondition areaPage);
    String addArea(GnArea area);
    void modifyArea(GnArea area);
    void deleteArea(GnAreaCondition gnAreaCondition);
    void deleteAreas(List<GnAreaCondition> gnAreaCondition);
    Integer getAreaCount();
    List<GnArea> getAreaList(int start,int pageNO);
    
    
    List<GnArea> selectByName(GnAreaCondition condition);
}
