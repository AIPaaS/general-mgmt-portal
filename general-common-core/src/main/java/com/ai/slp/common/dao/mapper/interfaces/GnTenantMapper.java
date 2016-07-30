package com.ai.slp.common.dao.mapper.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.slp.common.dao.mapper.bo.GnTenant;
import com.ai.slp.common.dao.mapper.bo.GnTenantCriteria;

public interface GnTenantMapper {
    int countByExample(GnTenantCriteria example);

    int deleteByExample(GnTenantCriteria example);

    int deleteByPrimaryKey(String tenantId);

    int insert(GnTenant record);

    int insertSelective(GnTenant record);

    List<GnTenant> selectByExample(GnTenantCriteria example);

    GnTenant selectByPrimaryKey(String tenantId);

    int updateByExampleSelective(@Param("record") GnTenant record, @Param("example") GnTenantCriteria example);

    int updateByExample(@Param("record") GnTenant record, @Param("example") GnTenantCriteria example);

    int updateByPrimaryKeySelective(GnTenant record);

    int updateByPrimaryKey(GnTenant record);
}