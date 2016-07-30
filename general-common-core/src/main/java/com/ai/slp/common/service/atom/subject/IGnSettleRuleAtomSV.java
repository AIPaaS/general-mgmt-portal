package com.ai.slp.common.service.atom.subject;

import java.util.List;

import com.ai.opt.base.exception.BusinessException;
import com.ai.slp.common.dao.mapper.bo.GnSettleRuleKey;

public interface IGnSettleRuleAtomSV {

    /**
     * 按照科目查询销账规则
     * 
     * @param tenantId
     * @param industryCode
     * @param subjectId
     * @return
     * @throws BusinessException
     * @author lilg
     */
    public List<GnSettleRuleKey> queryGnSettleRule(String tenantId, String industryCode,
            long subjectId) throws BusinessException;

    /**
     * 查询所有销账规则
     * 
     * @return
     * @throws BusinessException
     * @author lilg
     */
    public List<GnSettleRuleKey> queryGnSettleRule() throws BusinessException;

    /**
     * 增加销账规则
     * 
     * @param vo
     * @throws BusinessException
     * @author lilg
     */
    public void addSubjectRule(GnSettleRuleKey vo) throws BusinessException;

    /**
     * 删除销账规则
     * 
     * @param key
     * @throws BusinessException
     * @author lilg
     */
    public void delSubjectRule(GnSettleRuleKey key) throws BusinessException;

    /**
     * 修改销账规则计费科目ID
     * 
     * @param vo
     * @param key
     * @throws BusinessException
     * @author lilg
     */
    public void modSubjectRule(GnSettleRuleKey vo, GnSettleRuleKey key) throws BusinessException;
}
