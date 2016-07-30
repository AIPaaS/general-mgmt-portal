package com.ai.slp.common.api.subject.param;

import java.sql.Timestamp;

import com.ai.opt.base.vo.BaseInfo;

/**
 * 科目定义查询结果<br>
 *
 * Date: 2015年9月18日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public class Subject extends BaseInfo {

    /**
     * 科目ID
     */
    private Long subjectId;

    /**
     * 行业<br>
     */
    private String industryCode;

    /**
     * 科目名称
     */
    private String subjectName;

    /**
     * 科目描述
     */
    private String subjectDesc;

    /**
     * 科目类型<br>
     * 1：资源科目<br>
     * 2：消费科目（原计费的科目）<br>
     * 21:消费科目中非通信类科目<br>
     * 4：虚科目（暂无）<br>
     * 9：资金科目（原余额中心的的科目）<br>
     * 10:订单科目 （原营业的科目）<br>
     * 11：商品中心科目
     */
    private String subjectType;

    /**
     * 单位显示名称
     */
    private String unitName;

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 操作人
     */
    private String createOperId;

    /**
     * 业务点
     */
    private String chnlId;

    /**
     * 税率类型<br>
     * 1、基础;<br>
     * 2、增值;<br>
     * 3、混合比例<br>
     * 4、终端 <br>
     * 如果为空，则不打印发票<br>
     */
    private Integer taxType;

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectDesc() {
        return subjectDesc;
    }

    public void setSubjectDesc(String subjectDesc) {
        this.subjectDesc = subjectDesc;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Timestamp getCreateTime() {
        return createTime == null ? null : new Timestamp(createTime.getTime());
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime == null ? null : new Timestamp(createTime.getTime());
    }

    public String getCreateOperId() {
        return createOperId;
    }

    public void setCreateOperId(String createOperId) {
        this.createOperId = createOperId;
    }

    public String getChnlId() {
        return chnlId;
    }

    public void setChnlId(String chnlId) {
        this.chnlId = chnlId;
    }

    public Integer getTaxType() {
        return taxType;
    }

    public void setTaxType(Integer taxType) {
        this.taxType = taxType;
    }

    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }
}
