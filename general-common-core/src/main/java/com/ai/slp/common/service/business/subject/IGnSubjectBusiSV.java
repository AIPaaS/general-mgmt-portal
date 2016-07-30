package com.ai.slp.common.service.business.subject;

import java.util.List;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.slp.common.api.subjectmaintain.param.GnSubjectCondition;
import com.ai.slp.common.api.subjectmaintain.param.GnSubjectFundVo;
import com.ai.slp.common.api.subjectmaintain.param.GnSubjectKeyParam;
import com.ai.slp.common.api.subjectmaintain.param.GnSubjectVo;
import com.ai.slp.common.dao.mapper.bo.GnSettleRuleKey;
import com.ai.slp.common.dao.mapper.bo.GnSubject;
import com.ai.slp.common.dao.mapper.bo.GnSubjectFund;

/**
 * 
 * 科目编码和科目定义业务服务<br>
 * 1.该类供缓存加载调用<br>
 * 2.提供配置界面化查询 <br>
 * Date: 2015年8月19日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public interface IGnSubjectBusiSV {

    /**
     * 查询：根据subjectId查询科目编码
     * 
     * @param subjectId
     * @return
     * @throws BusinessException
     * @author lilg
     */
    public GnSubject queryGnSubject(String tenantId, String industryCode, long subjectId)
            throws BusinessException;

    /**
     * 查询：根据subjectId查询资金科目定义
     * 
     * @param subjectId
     * @return
     * @throws BusinessException
     * @author lilg
     */
    public GnSubjectFund queryGnSubjectFund(String tenantId, String industryCode, long subjectId)
            throws BusinessException;

    /**
     * 查询：查询所有科目编码
     * 
     * @return
     * @throws BusinessException
     * @author lilg
     */
    public List<GnSubject> queryGnSubject() throws BusinessException;

    /**
     * 查询：所有资金科目定义
     * 
     * @return
     * @throws BusinessException
     * @author lilg
     */
    public List<GnSubjectFund> queryGnSubjectFund() throws BusinessException;

    /**
     * 根据科目id查询销账规则
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
     * 查询：所有销账规则
     * 
     * @return
     * @throws BusinessException
     * @author lilg
     */
    public List<GnSettleRuleKey> queryGnSettleRule() throws BusinessException;

    /**
     * 新增：科目 <br>
     * 增加非资金科目时subjectFund可为空
     * 
     * @param subject
     * @param subjectFund
     * @author lilg
     */
    public void addSubject(GnSubjectVo vo) throws BusinessException;

    /**
     * 新增：资金科目详细
     * 
     * @param subjectFund
     * @throws BusinessException
     * @author lilg
     */
    public void addSubjectFund(GnSubjectFundVo vo) throws BusinessException;

    /**
     * 删除：科目，资金科目详细，销账规则
     * 
     * @param key
     * @throws BusinessException
     * @author lilg
     */
    public void delSubject(GnSubjectKeyParam param) throws BusinessException;

    /**
     * 删除：资金科目详细
     * 
     * @param key
     * @throws BusinessException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode
     */
    public void delSubjectFund(GnSubjectKeyParam param) throws BusinessException;

    /**
     * 修改：科目 <br>
     * 
     * @param subject
     * @param subjectFund
     * @throws BusinessException
     * @author lilg
     */
    public void modSubject(GnSubjectVo vo) throws BusinessException;

    /**
     * 修改：资金科目详细
     * 
     * @param subjectFund
     * @param key
     * @throws BusinessException
     * @author lilg
     */
    public void modSubjectFund(GnSubjectFundVo vo)
            throws BusinessException;

    /**
     * 科目分页查询
     * 
     * @param cond
     * @return
     * @throws BusinessException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode
     */
    public PageInfo<GnSubjectVo> queryGnSubject(GnSubjectCondition cond) throws BusinessException;
}
