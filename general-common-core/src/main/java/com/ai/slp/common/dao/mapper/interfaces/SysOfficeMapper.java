package com.ai.slp.common.dao.mapper.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.slp.common.dao.mapper.bo.SysOffice;
import com.ai.slp.common.dao.mapper.bo.SysOfficeCriteria;

public interface SysOfficeMapper {
    int countByExample(SysOfficeCriteria example);

    int deleteByExample(SysOfficeCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(SysOffice record);

    int insertSelective(SysOffice record);

    List<SysOffice> selectByExample(SysOfficeCriteria example);
    
    List<String> selectParentIdList(SysOfficeCriteria example);

    SysOffice selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysOffice record, @Param("example") SysOfficeCriteria example);

    int updateByExample(@Param("record") SysOffice record, @Param("example") SysOfficeCriteria example);

    int updateByPrimaryKeySelective(SysOffice record);

    int updateByPrimaryKey(SysOffice record);
}