package com.ai.slp.common.api.subjectmaintain.param;

import com.ai.opt.base.vo.BaseInfo;

public class GnSubjectFundVo extends BaseInfo {
    /**
     * 行业编码
     */
    private String industryCode;

    /**
     * 科目ID
     */
    private Long subjectId;

    /**
     * 资金类型
     */
    private String fundType;

    /**
     * 是否现金
     */
    private String isCash;

    /**
     * 使用模式
     */
    private String useMode;

    /**
     * 是否专用
     */
    private String canSettleAll;

    /**
     * 账本叠加方式
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

    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
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
}
