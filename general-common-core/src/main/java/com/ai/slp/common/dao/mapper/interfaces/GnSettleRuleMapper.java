package com.ai.slp.common.dao.mapper.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.slp.common.dao.mapper.bo.GnSettleRuleCriteria;
import com.ai.slp.common.dao.mapper.bo.GnSettleRuleKey;

public interface GnSettleRuleMapper {
    int countByExample(GnSettleRuleCriteria example);

    int deleteByExample(GnSettleRuleCriteria example);

    int deleteByPrimaryKey(GnSettleRuleKey key);

    int insert(GnSettleRuleKey record);

    int insertSelective(GnSettleRuleKey record);

    List<GnSettleRuleKey> selectByExample(GnSettleRuleCriteria example);

    int updateByExampleSelective(@Param("record") GnSettleRuleKey record, @Param("example") GnSettleRuleCriteria example);

    int updateByExample(@Param("record") GnSettleRuleKey record, @Param("example") GnSettleRuleCriteria example);
}