package com.ai.slp.common.dao.mapper.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.slp.common.dao.mapper.bo.GnIndustry;
import com.ai.slp.common.dao.mapper.bo.GnIndustryCriteria;

public interface GnIndustryMapper {
    int countByExample(GnIndustryCriteria example);

    int deleteByExample(GnIndustryCriteria example);

    int deleteByPrimaryKey(String industryCode);

    int insert(GnIndustry record);

    int insertSelective(GnIndustry record);

    List<GnIndustry> selectByExample(GnIndustryCriteria example);

    GnIndustry selectByPrimaryKey(String industryCode);

    int updateByExampleSelective(@Param("record") GnIndustry record, @Param("example") GnIndustryCriteria example);

    int updateByExample(@Param("record") GnIndustry record, @Param("example") GnIndustryCriteria example);

    int updateByPrimaryKeySelective(GnIndustry record);

    int updateByPrimaryKey(GnIndustry record);
}