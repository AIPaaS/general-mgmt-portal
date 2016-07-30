package com.ai.slp.common.dao.mapper.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.slp.common.dao.mapper.bo.GnSubject;
import com.ai.slp.common.dao.mapper.bo.GnSubjectCriteria;
import com.ai.slp.common.dao.mapper.bo.GnSubjectKey;

public interface GnSubjectMapper {
    int countByExample(GnSubjectCriteria example);

    int deleteByExample(GnSubjectCriteria example);

    int deleteByPrimaryKey(GnSubjectKey key);

    int insert(GnSubject record);

    int insertSelective(GnSubject record);

    List<GnSubject> selectByExample(GnSubjectCriteria example);

    GnSubject selectByPrimaryKey(GnSubjectKey key);

    int updateByExampleSelective(@Param("record") GnSubject record, @Param("example") GnSubjectCriteria example);

    int updateByExample(@Param("record") GnSubject record, @Param("example") GnSubjectCriteria example);

    int updateByPrimaryKeySelective(GnSubject record);

    int updateByPrimaryKey(GnSubject record);
}