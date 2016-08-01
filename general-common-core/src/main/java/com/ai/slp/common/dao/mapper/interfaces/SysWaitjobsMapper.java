package com.ai.slp.common.dao.mapper.interfaces;

import com.ai.slp.common.dao.mapper.bo.SysWaitjobs;
import com.ai.slp.common.dao.mapper.bo.SysWaitjobsCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysWaitjobsMapper {
    int countByExample(SysWaitjobsCriteria example);

    int deleteByExample(SysWaitjobsCriteria example);

    int insert(SysWaitjobs record);

    int insertSelective(SysWaitjobs record);

    List<SysWaitjobs> selectByExample(SysWaitjobsCriteria example);

    int updateByExampleSelective(@Param("record") SysWaitjobs record, @Param("example") SysWaitjobsCriteria example);

    int updateByExample(@Param("record") SysWaitjobs record, @Param("example") SysWaitjobsCriteria example);
}