package com.ai.slp.common.api.subject.param;

import java.sql.Timestamp;

import com.ai.opt.base.vo.BaseInfo;

/**
 * 资金科目查询结果
 *
 * Date: 2015年9月9日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public class SubjectFund extends BaseInfo {

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

    /**
     * 资金类型<br>
     * 1:现金<br>
     * 2:通讯现金<br>
     * 3:赠款<br>
     * 4:红包<br>
     * 5:优惠券<br>
     * 6:预存转兑<br>
     * 7:月费返还<br>
     * 8:押金<br>
     */
    private String fundType;

    /**
     * 是否现金<br>
     * 1：现金流 <br>
     * 0：非现金流<br>
     */
    private String isCash;

    /**
     * 使用模式<br>
     * 0：冻结资金，不可用<br>
     * 1：可用<br>
     */
    private String useMode;

    /**
     * 是否专用
     */
    private String canSettleAll;

    /**
     * 账本叠加方式<br>
     * 0：新增时叠加在同账本上，账本不受有效期限制<br>
     * 1：新增时叠加在同账本上，有效期按照规则顺延 <br>
     * 2：新增（不叠加）<br>
     */
    private String validType;

    /**
     * 使用优先级
     */
    private Long usePri;

    /**
     * 退费属性
     */
    private Long refundRate;

    /**
     * 转账属性
     */
    private String canTrans;

    /**
     * 清理属性
     */
    private String canCleanFund;

    /**
     * 账本删除属性
     */
    private String canDelBook;

    /**
     * 是否计算积分
     */
    private String calScore;

    /**
     * 打印模式
     */
    private String printMode;

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

    public String getFundType() {
        return fundType;
    }

    public void setFundType(String fundType) {
        this.fundType = fundType;
    }

    public String getIsCash() {
        return isCash;
    }

    public void setIsCash(String isCash) {
        this.isCash = isCash;
    }

    public String getUseMode() {
        return useMode;
    }

    public void setUseMode(String useMode) {
        this.useMode = useMode;
    }

    public String getCanSettleAll() {
        return canSettleAll;
    }

    public void setCanSettleAll(String canSettleAll) {
        this.canSettleAll = canSettleAll;
    }

    public String getValidType() {
        return validType;
    }

    public void setValidType(String validType) {
        this.validType = validType;
    }

    public Long getUsePri() {
        return usePri;
    }

    public void setUsePri(Long usePri) {
        this.usePri = usePri;
    }

    public Long getRefundRate() {
        return refundRate;
    }

    public void setRefundRate(Long refundRate) {
        this.refundRate = refundRate;
    }

    public String getCanTrans() {
        return canTrans;
    }

    public void setCanTrans(String canTrans) {
        this.canTrans = canTrans;
    }

    public String getCanCleanFund() {
        return canCleanFund;
    }

    public void setCanCleanFund(String canCleanFund) {
        this.canCleanFund = canCleanFund;
    }

    public String getCanDelBook() {
        return canDelBook;
    }

    public void setCanDelBook(String canDelBook) {
        this.canDelBook = canDelBook;
    }

    public String getCalScore() {
        return calScore;
    }

    public void setCalScore(String calScore) {
        this.calScore = calScore;
    }

    public String getPrintMode() {
        return printMode;
    }

    public void setPrintMode(String printMode) {
        this.printMode = printMode;
    }

    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }

}
