package com.ai.slp.common.service.atom.subject;

import java.util.List;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.slp.common.dao.mapper.bo.GnSubject;
import com.ai.slp.common.dao.mapper.bo.GnSubjectKey;

/**
 * 科目编码 原子服务 Date: 2015年8月19日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public interface IGnSubjectAtomSV {
    /**
     * 根据subjectId查询科目编码
     * 
     * @param subjectId
     * @return
     * @author lilg
     * @ApiDocMethod
     */
    public GnSubject queryGnSubject(String tenantId, String industryCode, long subjectId);

    /**
     * 科目分页条件查询
     * @param tenantId
     * @param industryCode
     * @param subjectId
     * @param subjectType
     * @param subjectName
     * @param pageNo
     * @param pageSize
     * @return
     * @author lilg
     */
    public PageInfo<GnSubject> queryGnSubject(String tenantId, String industryCode, Long subjectId,
            String subjectType, String subjectName, Integer pageNo, Integer pageSize);

    /**
     * 查询所有科目编码
     * 
     * @return
     * @author lilg
     * @ApiDocMethod
     */
    public List<GnSubject> queryGnSubject();

    /**
     * 新增科目
     * 
     * @param vo
     * @throws BusinessException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode
     */
    public void addSubject(GnSubject vo) throws BusinessException;

    /**
     * 删除科目
     * 
     * @param key
     * @throws BusinessException
     * @author lilg
     */
    public void delSubject(GnSubjectKey key) throws BusinessException;

    /**
     * 修改科目
     * 
     * @param vo
     * @param key
     * @throws BusinessException
     * @author lilg
     */
    public void modSubject(GnSubject vo, GnSubjectKey key) throws BusinessException;

}
