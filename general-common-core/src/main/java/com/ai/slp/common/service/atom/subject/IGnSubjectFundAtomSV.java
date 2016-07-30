package com.ai.slp.common.service.atom.subject;

import java.util.List;

import com.ai.opt.base.exception.BusinessException;
import com.ai.slp.common.dao.mapper.bo.GnSubjectFund;
import com.ai.slp.common.dao.mapper.bo.GnSubjectFundKey;

/**
 * 查询资金科目详细
 *
 * Date: 2016年1月4日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author lilg
 */
public interface IGnSubjectFundAtomSV {

    /**
     * 根据subjectId查询资金科目定义
     * 
     * @param subjectId
     * @return
     * @author lilg
     * @ApiDocMethod
     */
    public GnSubjectFund queryGnSubjectFund(String tenantId,String industryCode,long subjectId);

    /**
     * 查询所有资金科目定义
     * 
     * @return
     * @author lilg
     * @ApiDocMethod
     */
    public List<GnSubjectFund> queryGnSubjectFund();

    /**
     * 增加资金科目详细
     * 
     * @param vo
     * @throws BusinessException
     * @author lilg
     */
    public void addSubjectFund(GnSubjectFund vo) throws BusinessException;

    /**
     * 删除资金科目详细
     * 
     * @param key
     * @throws BusinessException
     * @author lilg
     */
    public void delSubjectFund(GnSubjectFundKey key) throws BusinessException;

    /**
     * 修改资金科目详细
     * 
     * @param vo
     * @param key
     * @throws BusinessException
     * @author lilg
     */
    public void modSubjectFund(GnSubjectFund vo, GnSubjectFundKey key) throws BusinessException;

}
