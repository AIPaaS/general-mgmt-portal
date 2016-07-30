package com.ai.slp.common.dao.mapper.interfaces;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.ai.slp.common.dao.mapper.bo.GnArea;
import com.ai.slp.common.dao.mapper.bo.GnAreaCriteria;

public interface GnAreaMapper {
    int countByExample(GnAreaCriteria example);

    int deleteByExample(GnAreaCriteria example);

    int deleteByPrimaryKey(String areaCode);

    int insert(GnArea record);

    int insertSelective(GnArea record);

    List<GnArea> selectByExample(GnAreaCriteria example);

    GnArea selectByPrimaryKey(String areaCode);

    int updateByExampleSelective(@Param("record") GnArea record, @Param("example") GnAreaCriteria example);

    int updateByExample(@Param("record") GnArea record, @Param("example") GnAreaCriteria example);

    int updateByPrimaryKeySelective(GnArea record);

    int updateByPrimaryKey(GnArea record);
}