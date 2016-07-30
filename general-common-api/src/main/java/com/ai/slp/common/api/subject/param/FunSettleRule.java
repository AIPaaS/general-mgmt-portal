package com.ai.slp.common.api.subject.param;

import java.io.Serializable;

public class FunSettleRule implements Serializable {
    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 账管科目ID
     */
    private long subjectId;

    /**
     * 消费费用科目ID
     */
    private long feeSubjectId;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public long getFeeSubjectId() {
        return feeSubjectId;
    }

    public void setFeeSubjectId(long feeSubjectId) {
        this.feeSubjectId = feeSubjectId;
    }
}
