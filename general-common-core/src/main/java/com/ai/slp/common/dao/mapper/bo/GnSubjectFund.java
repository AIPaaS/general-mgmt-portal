package com.ai.slp.common.dao.mapper.bo;

public class GnSubjectFund extends GnSubjectFundKey {
    private String fundType;

    private String isCash;

    private String useMode;

    private String canSettleAll;

    private String validType;

    private Long usePri;

    private Long refundRate;

    private String canTrans;

    private String canCleanFund;

    private String canDelBook;

    private String calScore;

    private String printMode;

    public String getFundType() {
        return fundType;
    }

    public void setFundType(String fundType) {
        this.fundType = fundType == null ? null : fundType.trim();
    }

    public String getIsCash() {
        return isCash;
    }

    public void setIsCash(String isCash) {
        this.isCash = isCash == null ? null : isCash.trim();
    }

    public String getUseMode() {
        return useMode;
    }

    public void setUseMode(String useMode) {
        this.useMode = useMode == null ? null : useMode.trim();
    }

    public String getCanSettleAll() {
        return canSettleAll;
    }

    public void setCanSettleAll(String canSettleAll) {
        this.canSettleAll = canSettleAll == null ? null : canSettleAll.trim();
    }

    public String getValidType() {
        return validType;
    }

    public void setValidType(String validType) {
        this.validType = validType == null ? null : validType.trim();
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
        this.canTrans = canTrans == null ? null : canTrans.trim();
    }

    public String getCanCleanFund() {
        return canCleanFund;
    }

    public void setCanCleanFund(String canCleanFund) {
        this.canCleanFund = canCleanFund == null ? null : canCleanFund.trim();
    }

    public String getCanDelBook() {
        return canDelBook;
    }

    public void setCanDelBook(String canDelBook) {
        this.canDelBook = canDelBook == null ? null : canDelBook.trim();
    }

    public String getCalScore() {
        return calScore;
    }

    public void setCalScore(String calScore) {
        this.calScore = calScore == null ? null : calScore.trim();
    }

    public String getPrintMode() {
        return printMode;
    }

    public void setPrintMode(String printMode) {
        this.printMode = printMode == null ? null : printMode.trim();
    }
}