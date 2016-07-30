package com.ai.slp.common.dao.mapper.bo;

import java.util.ArrayList;
import java.util.List;

public class GnSubjectFundCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public GnSubjectFundCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    public Integer getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    public Integer getLimitEnd() {
        return limitEnd;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andTenantIdIsNull() {
            addCriterion("tenant_id is null");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNotNull() {
            addCriterion("tenant_id is not null");
            return (Criteria) this;
        }

        public Criteria andTenantIdEqualTo(String value) {
            addCriterion("tenant_id =", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotEqualTo(String value) {
            addCriterion("tenant_id <>", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThan(String value) {
            addCriterion("tenant_id >", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThanOrEqualTo(String value) {
            addCriterion("tenant_id >=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThan(String value) {
            addCriterion("tenant_id <", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThanOrEqualTo(String value) {
            addCriterion("tenant_id <=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLike(String value) {
            addCriterion("tenant_id like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotLike(String value) {
            addCriterion("tenant_id not like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdIn(List<String> values) {
            addCriterion("tenant_id in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotIn(List<String> values) {
            addCriterion("tenant_id not in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdBetween(String value1, String value2) {
            addCriterion("tenant_id between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotBetween(String value1, String value2) {
            addCriterion("tenant_id not between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeIsNull() {
            addCriterion("industry_code is null");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeIsNotNull() {
            addCriterion("industry_code is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeEqualTo(String value) {
            addCriterion("industry_code =", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeNotEqualTo(String value) {
            addCriterion("industry_code <>", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeGreaterThan(String value) {
            addCriterion("industry_code >", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeGreaterThanOrEqualTo(String value) {
            addCriterion("industry_code >=", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeLessThan(String value) {
            addCriterion("industry_code <", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeLessThanOrEqualTo(String value) {
            addCriterion("industry_code <=", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeLike(String value) {
            addCriterion("industry_code like", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeNotLike(String value) {
            addCriterion("industry_code not like", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeIn(List<String> values) {
            addCriterion("industry_code in", values, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeNotIn(List<String> values) {
            addCriterion("industry_code not in", values, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeBetween(String value1, String value2) {
            addCriterion("industry_code between", value1, value2, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeNotBetween(String value1, String value2) {
            addCriterion("industry_code not between", value1, value2, "industryCode");
            return (Criteria) this;
        }

        public Criteria andSubjectIdIsNull() {
            addCriterion("subject_id is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIdIsNotNull() {
            addCriterion("subject_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectIdEqualTo(Long value) {
            addCriterion("subject_id =", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotEqualTo(Long value) {
            addCriterion("subject_id <>", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdGreaterThan(Long value) {
            addCriterion("subject_id >", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdGreaterThanOrEqualTo(Long value) {
            addCriterion("subject_id >=", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdLessThan(Long value) {
            addCriterion("subject_id <", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdLessThanOrEqualTo(Long value) {
            addCriterion("subject_id <=", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdIn(List<Long> values) {
            addCriterion("subject_id in", values, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotIn(List<Long> values) {
            addCriterion("subject_id not in", values, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdBetween(Long value1, Long value2) {
            addCriterion("subject_id between", value1, value2, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotBetween(Long value1, Long value2) {
            addCriterion("subject_id not between", value1, value2, "subjectId");
            return (Criteria) this;
        }

        public Criteria andFundTypeIsNull() {
            addCriterion("fund_type is null");
            return (Criteria) this;
        }

        public Criteria andFundTypeIsNotNull() {
            addCriterion("fund_type is not null");
            return (Criteria) this;
        }

        public Criteria andFundTypeEqualTo(String value) {
            addCriterion("fund_type =", value, "fundType");
            return (Criteria) this;
        }

        public Criteria andFundTypeNotEqualTo(String value) {
            addCriterion("fund_type <>", value, "fundType");
            return (Criteria) this;
        }

        public Criteria andFundTypeGreaterThan(String value) {
            addCriterion("fund_type >", value, "fundType");
            return (Criteria) this;
        }

        public Criteria andFundTypeGreaterThanOrEqualTo(String value) {
            addCriterion("fund_type >=", value, "fundType");
            return (Criteria) this;
        }

        public Criteria andFundTypeLessThan(String value) {
            addCriterion("fund_type <", value, "fundType");
            return (Criteria) this;
        }

        public Criteria andFundTypeLessThanOrEqualTo(String value) {
            addCriterion("fund_type <=", value, "fundType");
            return (Criteria) this;
        }

        public Criteria andFundTypeLike(String value) {
            addCriterion("fund_type like", value, "fundType");
            return (Criteria) this;
        }

        public Criteria andFundTypeNotLike(String value) {
            addCriterion("fund_type not like", value, "fundType");
            return (Criteria) this;
        }

        public Criteria andFundTypeIn(List<String> values) {
            addCriterion("fund_type in", values, "fundType");
            return (Criteria) this;
        }

        public Criteria andFundTypeNotIn(List<String> values) {
            addCriterion("fund_type not in", values, "fundType");
            return (Criteria) this;
        }

        public Criteria andFundTypeBetween(String value1, String value2) {
            addCriterion("fund_type between", value1, value2, "fundType");
            return (Criteria) this;
        }

        public Criteria andFundTypeNotBetween(String value1, String value2) {
            addCriterion("fund_type not between", value1, value2, "fundType");
            return (Criteria) this;
        }

        public Criteria andIsCashIsNull() {
            addCriterion("is_cash is null");
            return (Criteria) this;
        }

        public Criteria andIsCashIsNotNull() {
            addCriterion("is_cash is not null");
            return (Criteria) this;
        }

        public Criteria andIsCashEqualTo(String value) {
            addCriterion("is_cash =", value, "isCash");
            return (Criteria) this;
        }

        public Criteria andIsCashNotEqualTo(String value) {
            addCriterion("is_cash <>", value, "isCash");
            return (Criteria) this;
        }

        public Criteria andIsCashGreaterThan(String value) {
            addCriterion("is_cash >", value, "isCash");
            return (Criteria) this;
        }

        public Criteria andIsCashGreaterThanOrEqualTo(String value) {
            addCriterion("is_cash >=", value, "isCash");
            return (Criteria) this;
        }

        public Criteria andIsCashLessThan(String value) {
            addCriterion("is_cash <", value, "isCash");
            return (Criteria) this;
        }

        public Criteria andIsCashLessThanOrEqualTo(String value) {
            addCriterion("is_cash <=", value, "isCash");
            return (Criteria) this;
        }

        public Criteria andIsCashLike(String value) {
            addCriterion("is_cash like", value, "isCash");
            return (Criteria) this;
        }

        public Criteria andIsCashNotLike(String value) {
            addCriterion("is_cash not like", value, "isCash");
            return (Criteria) this;
        }

        public Criteria andIsCashIn(List<String> values) {
            addCriterion("is_cash in", values, "isCash");
            return (Criteria) this;
        }

        public Criteria andIsCashNotIn(List<String> values) {
            addCriterion("is_cash not in", values, "isCash");
            return (Criteria) this;
        }

        public Criteria andIsCashBetween(String value1, String value2) {
            addCriterion("is_cash between", value1, value2, "isCash");
            return (Criteria) this;
        }

        public Criteria andIsCashNotBetween(String value1, String value2) {
            addCriterion("is_cash not between", value1, value2, "isCash");
            return (Criteria) this;
        }

        public Criteria andUseModeIsNull() {
            addCriterion("use_mode is null");
            return (Criteria) this;
        }

        public Criteria andUseModeIsNotNull() {
            addCriterion("use_mode is not null");
            return (Criteria) this;
        }

        public Criteria andUseModeEqualTo(String value) {
            addCriterion("use_mode =", value, "useMode");
            return (Criteria) this;
        }

        public Criteria andUseModeNotEqualTo(String value) {
            addCriterion("use_mode <>", value, "useMode");
            return (Criteria) this;
        }

        public Criteria andUseModeGreaterThan(String value) {
            addCriterion("use_mode >", value, "useMode");
            return (Criteria) this;
        }

        public Criteria andUseModeGreaterThanOrEqualTo(String value) {
            addCriterion("use_mode >=", value, "useMode");
            return (Criteria) this;
        }

        public Criteria andUseModeLessThan(String value) {
            addCriterion("use_mode <", value, "useMode");
            return (Criteria) this;
        }

        public Criteria andUseModeLessThanOrEqualTo(String value) {
            addCriterion("use_mode <=", value, "useMode");
            return (Criteria) this;
        }

        public Criteria andUseModeLike(String value) {
            addCriterion("use_mode like", value, "useMode");
            return (Criteria) this;
        }

        public Criteria andUseModeNotLike(String value) {
            addCriterion("use_mode not like", value, "useMode");
            return (Criteria) this;
        }

        public Criteria andUseModeIn(List<String> values) {
            addCriterion("use_mode in", values, "useMode");
            return (Criteria) this;
        }

        public Criteria andUseModeNotIn(List<String> values) {
            addCriterion("use_mode not in", values, "useMode");
            return (Criteria) this;
        }

        public Criteria andUseModeBetween(String value1, String value2) {
            addCriterion("use_mode between", value1, value2, "useMode");
            return (Criteria) this;
        }

        public Criteria andUseModeNotBetween(String value1, String value2) {
            addCriterion("use_mode not between", value1, value2, "useMode");
            return (Criteria) this;
        }

        public Criteria andCanSettleAllIsNull() {
            addCriterion("can_settle_all is null");
            return (Criteria) this;
        }

        public Criteria andCanSettleAllIsNotNull() {
            addCriterion("can_settle_all is not null");
            return (Criteria) this;
        }

        public Criteria andCanSettleAllEqualTo(String value) {
            addCriterion("can_settle_all =", value, "canSettleAll");
            return (Criteria) this;
        }

        public Criteria andCanSettleAllNotEqualTo(String value) {
            addCriterion("can_settle_all <>", value, "canSettleAll");
            return (Criteria) this;
        }

        public Criteria andCanSettleAllGreaterThan(String value) {
            addCriterion("can_settle_all >", value, "canSettleAll");
            return (Criteria) this;
        }

        public Criteria andCanSettleAllGreaterThanOrEqualTo(String value) {
            addCriterion("can_settle_all >=", value, "canSettleAll");
            return (Criteria) this;
        }

        public Criteria andCanSettleAllLessThan(String value) {
            addCriterion("can_settle_all <", value, "canSettleAll");
            return (Criteria) this;
        }

        public Criteria andCanSettleAllLessThanOrEqualTo(String value) {
            addCriterion("can_settle_all <=", value, "canSettleAll");
            return (Criteria) this;
        }

        public Criteria andCanSettleAllLike(String value) {
            addCriterion("can_settle_all like", value, "canSettleAll");
            return (Criteria) this;
        }

        public Criteria andCanSettleAllNotLike(String value) {
            addCriterion("can_settle_all not like", value, "canSettleAll");
            return (Criteria) this;
        }

        public Criteria andCanSettleAllIn(List<String> values) {
            addCriterion("can_settle_all in", values, "canSettleAll");
            return (Criteria) this;
        }

        public Criteria andCanSettleAllNotIn(List<String> values) {
            addCriterion("can_settle_all not in", values, "canSettleAll");
            return (Criteria) this;
        }

        public Criteria andCanSettleAllBetween(String value1, String value2) {
            addCriterion("can_settle_all between", value1, value2, "canSettleAll");
            return (Criteria) this;
        }

        public Criteria andCanSettleAllNotBetween(String value1, String value2) {
            addCriterion("can_settle_all not between", value1, value2, "canSettleAll");
            return (Criteria) this;
        }

        public Criteria andValidTypeIsNull() {
            addCriterion("valid_type is null");
            return (Criteria) this;
        }

        public Criteria andValidTypeIsNotNull() {
            addCriterion("valid_type is not null");
            return (Criteria) this;
        }

        public Criteria andValidTypeEqualTo(String value) {
            addCriterion("valid_type =", value, "validType");
            return (Criteria) this;
        }

        public Criteria andValidTypeNotEqualTo(String value) {
            addCriterion("valid_type <>", value, "validType");
            return (Criteria) this;
        }

        public Criteria andValidTypeGreaterThan(String value) {
            addCriterion("valid_type >", value, "validType");
            return (Criteria) this;
        }

        public Criteria andValidTypeGreaterThanOrEqualTo(String value) {
            addCriterion("valid_type >=", value, "validType");
            return (Criteria) this;
        }

        public Criteria andValidTypeLessThan(String value) {
            addCriterion("valid_type <", value, "validType");
            return (Criteria) this;
        }

        public Criteria andValidTypeLessThanOrEqualTo(String value) {
            addCriterion("valid_type <=", value, "validType");
            return (Criteria) this;
        }

        public Criteria andValidTypeLike(String value) {
            addCriterion("valid_type like", value, "validType");
            return (Criteria) this;
        }

        public Criteria andValidTypeNotLike(String value) {
            addCriterion("valid_type not like", value, "validType");
            return (Criteria) this;
        }

        public Criteria andValidTypeIn(List<String> values) {
            addCriterion("valid_type in", values, "validType");
            return (Criteria) this;
        }

        public Criteria andValidTypeNotIn(List<String> values) {
            addCriterion("valid_type not in", values, "validType");
            return (Criteria) this;
        }

        public Criteria andValidTypeBetween(String value1, String value2) {
            addCriterion("valid_type between", value1, value2, "validType");
            return (Criteria) this;
        }

        public Criteria andValidTypeNotBetween(String value1, String value2) {
            addCriterion("valid_type not between", value1, value2, "validType");
            return (Criteria) this;
        }

        public Criteria andUsePriIsNull() {
            addCriterion("use_pri is null");
            return (Criteria) this;
        }

        public Criteria andUsePriIsNotNull() {
            addCriterion("use_pri is not null");
            return (Criteria) this;
        }

        public Criteria andUsePriEqualTo(Long value) {
            addCriterion("use_pri =", value, "usePri");
            return (Criteria) this;
        }

        public Criteria andUsePriNotEqualTo(Long value) {
            addCriterion("use_pri <>", value, "usePri");
            return (Criteria) this;
        }

        public Criteria andUsePriGreaterThan(Long value) {
            addCriterion("use_pri >", value, "usePri");
            return (Criteria) this;
        }

        public Criteria andUsePriGreaterThanOrEqualTo(Long value) {
            addCriterion("use_pri >=", value, "usePri");
            return (Criteria) this;
        }

        public Criteria andUsePriLessThan(Long value) {
            addCriterion("use_pri <", value, "usePri");
            return (Criteria) this;
        }

        public Criteria andUsePriLessThanOrEqualTo(Long value) {
            addCriterion("use_pri <=", value, "usePri");
            return (Criteria) this;
        }

        public Criteria andUsePriIn(List<Long> values) {
            addCriterion("use_pri in", values, "usePri");
            return (Criteria) this;
        }

        public Criteria andUsePriNotIn(List<Long> values) {
            addCriterion("use_pri not in", values, "usePri");
            return (Criteria) this;
        }

        public Criteria andUsePriBetween(Long value1, Long value2) {
            addCriterion("use_pri between", value1, value2, "usePri");
            return (Criteria) this;
        }

        public Criteria andUsePriNotBetween(Long value1, Long value2) {
            addCriterion("use_pri not between", value1, value2, "usePri");
            return (Criteria) this;
        }

        public Criteria andRefundRateIsNull() {
            addCriterion("refund_rate is null");
            return (Criteria) this;
        }

        public Criteria andRefundRateIsNotNull() {
            addCriterion("refund_rate is not null");
            return (Criteria) this;
        }

        public Criteria andRefundRateEqualTo(Long value) {
            addCriterion("refund_rate =", value, "refundRate");
            return (Criteria) this;
        }

        public Criteria andRefundRateNotEqualTo(Long value) {
            addCriterion("refund_rate <>", value, "refundRate");
            return (Criteria) this;
        }

        public Criteria andRefundRateGreaterThan(Long value) {
            addCriterion("refund_rate >", value, "refundRate");
            return (Criteria) this;
        }

        public Criteria andRefundRateGreaterThanOrEqualTo(Long value) {
            addCriterion("refund_rate >=", value, "refundRate");
            return (Criteria) this;
        }

        public Criteria andRefundRateLessThan(Long value) {
            addCriterion("refund_rate <", value, "refundRate");
            return (Criteria) this;
        }

        public Criteria andRefundRateLessThanOrEqualTo(Long value) {
            addCriterion("refund_rate <=", value, "refundRate");
            return (Criteria) this;
        }

        public Criteria andRefundRateIn(List<Long> values) {
            addCriterion("refund_rate in", values, "refundRate");
            return (Criteria) this;
        }

        public Criteria andRefundRateNotIn(List<Long> values) {
            addCriterion("refund_rate not in", values, "refundRate");
            return (Criteria) this;
        }

        public Criteria andRefundRateBetween(Long value1, Long value2) {
            addCriterion("refund_rate between", value1, value2, "refundRate");
            return (Criteria) this;
        }

        public Criteria andRefundRateNotBetween(Long value1, Long value2) {
            addCriterion("refund_rate not between", value1, value2, "refundRate");
            return (Criteria) this;
        }

        public Criteria andCanTransIsNull() {
            addCriterion("can_trans is null");
            return (Criteria) this;
        }

        public Criteria andCanTransIsNotNull() {
            addCriterion("can_trans is not null");
            return (Criteria) this;
        }

        public Criteria andCanTransEqualTo(String value) {
            addCriterion("can_trans =", value, "canTrans");
            return (Criteria) this;
        }

        public Criteria andCanTransNotEqualTo(String value) {
            addCriterion("can_trans <>", value, "canTrans");
            return (Criteria) this;
        }

        public Criteria andCanTransGreaterThan(String value) {
            addCriterion("can_trans >", value, "canTrans");
            return (Criteria) this;
        }

        public Criteria andCanTransGreaterThanOrEqualTo(String value) {
            addCriterion("can_trans >=", value, "canTrans");
            return (Criteria) this;
        }

        public Criteria andCanTransLessThan(String value) {
            addCriterion("can_trans <", value, "canTrans");
            return (Criteria) this;
        }

        public Criteria andCanTransLessThanOrEqualTo(String value) {
            addCriterion("can_trans <=", value, "canTrans");
            return (Criteria) this;
        }

        public Criteria andCanTransLike(String value) {
            addCriterion("can_trans like", value, "canTrans");
            return (Criteria) this;
        }

        public Criteria andCanTransNotLike(String value) {
            addCriterion("can_trans not like", value, "canTrans");
            return (Criteria) this;
        }

        public Criteria andCanTransIn(List<String> values) {
            addCriterion("can_trans in", values, "canTrans");
            return (Criteria) this;
        }

        public Criteria andCanTransNotIn(List<String> values) {
            addCriterion("can_trans not in", values, "canTrans");
            return (Criteria) this;
        }

        public Criteria andCanTransBetween(String value1, String value2) {
            addCriterion("can_trans between", value1, value2, "canTrans");
            return (Criteria) this;
        }

        public Criteria andCanTransNotBetween(String value1, String value2) {
            addCriterion("can_trans not between", value1, value2, "canTrans");
            return (Criteria) this;
        }

        public Criteria andCanCleanFundIsNull() {
            addCriterion("can_clean_fund is null");
            return (Criteria) this;
        }

        public Criteria andCanCleanFundIsNotNull() {
            addCriterion("can_clean_fund is not null");
            return (Criteria) this;
        }

        public Criteria andCanCleanFundEqualTo(String value) {
            addCriterion("can_clean_fund =", value, "canCleanFund");
            return (Criteria) this;
        }

        public Criteria andCanCleanFundNotEqualTo(String value) {
            addCriterion("can_clean_fund <>", value, "canCleanFund");
            return (Criteria) this;
        }

        public Criteria andCanCleanFundGreaterThan(String value) {
            addCriterion("can_clean_fund >", value, "canCleanFund");
            return (Criteria) this;
        }

        public Criteria andCanCleanFundGreaterThanOrEqualTo(String value) {
            addCriterion("can_clean_fund >=", value, "canCleanFund");
            return (Criteria) this;
        }

        public Criteria andCanCleanFundLessThan(String value) {
            addCriterion("can_clean_fund <", value, "canCleanFund");
            return (Criteria) this;
        }

        public Criteria andCanCleanFundLessThanOrEqualTo(String value) {
            addCriterion("can_clean_fund <=", value, "canCleanFund");
            return (Criteria) this;
        }

        public Criteria andCanCleanFundLike(String value) {
            addCriterion("can_clean_fund like", value, "canCleanFund");
            return (Criteria) this;
        }

        public Criteria andCanCleanFundNotLike(String value) {
            addCriterion("can_clean_fund not like", value, "canCleanFund");
            return (Criteria) this;
        }

        public Criteria andCanCleanFundIn(List<String> values) {
            addCriterion("can_clean_fund in", values, "canCleanFund");
            return (Criteria) this;
        }

        public Criteria andCanCleanFundNotIn(List<String> values) {
            addCriterion("can_clean_fund not in", values, "canCleanFund");
            return (Criteria) this;
        }

        public Criteria andCanCleanFundBetween(String value1, String value2) {
            addCriterion("can_clean_fund between", value1, value2, "canCleanFund");
            return (Criteria) this;
        }

        public Criteria andCanCleanFundNotBetween(String value1, String value2) {
            addCriterion("can_clean_fund not between", value1, value2, "canCleanFund");
            return (Criteria) this;
        }

        public Criteria andCanDelBookIsNull() {
            addCriterion("can_del_book is null");
            return (Criteria) this;
        }

        public Criteria andCanDelBookIsNotNull() {
            addCriterion("can_del_book is not null");
            return (Criteria) this;
        }

        public Criteria andCanDelBookEqualTo(String value) {
            addCriterion("can_del_book =", value, "canDelBook");
            return (Criteria) this;
        }

        public Criteria andCanDelBookNotEqualTo(String value) {
            addCriterion("can_del_book <>", value, "canDelBook");
            return (Criteria) this;
        }

        public Criteria andCanDelBookGreaterThan(String value) {
            addCriterion("can_del_book >", value, "canDelBook");
            return (Criteria) this;
        }

        public Criteria andCanDelBookGreaterThanOrEqualTo(String value) {
            addCriterion("can_del_book >=", value, "canDelBook");
            return (Criteria) this;
        }

        public Criteria andCanDelBookLessThan(String value) {
            addCriterion("can_del_book <", value, "canDelBook");
            return (Criteria) this;
        }

        public Criteria andCanDelBookLessThanOrEqualTo(String value) {
            addCriterion("can_del_book <=", value, "canDelBook");
            return (Criteria) this;
        }

        public Criteria andCanDelBookLike(String value) {
            addCriterion("can_del_book like", value, "canDelBook");
            return (Criteria) this;
        }

        public Criteria andCanDelBookNotLike(String value) {
            addCriterion("can_del_book not like", value, "canDelBook");
            return (Criteria) this;
        }

        public Criteria andCanDelBookIn(List<String> values) {
            addCriterion("can_del_book in", values, "canDelBook");
            return (Criteria) this;
        }

        public Criteria andCanDelBookNotIn(List<String> values) {
            addCriterion("can_del_book not in", values, "canDelBook");
            return (Criteria) this;
        }

        public Criteria andCanDelBookBetween(String value1, String value2) {
            addCriterion("can_del_book between", value1, value2, "canDelBook");
            return (Criteria) this;
        }

        public Criteria andCanDelBookNotBetween(String value1, String value2) {
            addCriterion("can_del_book not between", value1, value2, "canDelBook");
            return (Criteria) this;
        }

        public Criteria andCalScoreIsNull() {
            addCriterion("cal_score is null");
            return (Criteria) this;
        }

        public Criteria andCalScoreIsNotNull() {
            addCriterion("cal_score is not null");
            return (Criteria) this;
        }

        public Criteria andCalScoreEqualTo(String value) {
            addCriterion("cal_score =", value, "calScore");
            return (Criteria) this;
        }

        public Criteria andCalScoreNotEqualTo(String value) {
            addCriterion("cal_score <>", value, "calScore");
            return (Criteria) this;
        }

        public Criteria andCalScoreGreaterThan(String value) {
            addCriterion("cal_score >", value, "calScore");
            return (Criteria) this;
        }

        public Criteria andCalScoreGreaterThanOrEqualTo(String value) {
            addCriterion("cal_score >=", value, "calScore");
            return (Criteria) this;
        }

        public Criteria andCalScoreLessThan(String value) {
            addCriterion("cal_score <", value, "calScore");
            return (Criteria) this;
        }

        public Criteria andCalScoreLessThanOrEqualTo(String value) {
            addCriterion("cal_score <=", value, "calScore");
            return (Criteria) this;
        }

        public Criteria andCalScoreLike(String value) {
            addCriterion("cal_score like", value, "calScore");
            return (Criteria) this;
        }

        public Criteria andCalScoreNotLike(String value) {
            addCriterion("cal_score not like", value, "calScore");
            return (Criteria) this;
        }

        public Criteria andCalScoreIn(List<String> values) {
            addCriterion("cal_score in", values, "calScore");
            return (Criteria) this;
        }

        public Criteria andCalScoreNotIn(List<String> values) {
            addCriterion("cal_score not in", values, "calScore");
            return (Criteria) this;
        }

        public Criteria andCalScoreBetween(String value1, String value2) {
            addCriterion("cal_score between", value1, value2, "calScore");
            return (Criteria) this;
        }

        public Criteria andCalScoreNotBetween(String value1, String value2) {
            addCriterion("cal_score not between", value1, value2, "calScore");
            return (Criteria) this;
        }

        public Criteria andPrintModeIsNull() {
            addCriterion("print_mode is null");
            return (Criteria) this;
        }

        public Criteria andPrintModeIsNotNull() {
            addCriterion("print_mode is not null");
            return (Criteria) this;
        }

        public Criteria andPrintModeEqualTo(String value) {
            addCriterion("print_mode =", value, "printMode");
            return (Criteria) this;
        }

        public Criteria andPrintModeNotEqualTo(String value) {
            addCriterion("print_mode <>", value, "printMode");
            return (Criteria) this;
        }

        public Criteria andPrintModeGreaterThan(String value) {
            addCriterion("print_mode >", value, "printMode");
            return (Criteria) this;
        }

        public Criteria andPrintModeGreaterThanOrEqualTo(String value) {
            addCriterion("print_mode >=", value, "printMode");
            return (Criteria) this;
        }

        public Criteria andPrintModeLessThan(String value) {
            addCriterion("print_mode <", value, "printMode");
            return (Criteria) this;
        }

        public Criteria andPrintModeLessThanOrEqualTo(String value) {
            addCriterion("print_mode <=", value, "printMode");
            return (Criteria) this;
        }

        public Criteria andPrintModeLike(String value) {
            addCriterion("print_mode like", value, "printMode");
            return (Criteria) this;
        }

        public Criteria andPrintModeNotLike(String value) {
            addCriterion("print_mode not like", value, "printMode");
            return (Criteria) this;
        }

        public Criteria andPrintModeIn(List<String> values) {
            addCriterion("print_mode in", values, "printMode");
            return (Criteria) this;
        }

        public Criteria andPrintModeNotIn(List<String> values) {
            addCriterion("print_mode not in", values, "printMode");
            return (Criteria) this;
        }

        public Criteria andPrintModeBetween(String value1, String value2) {
            addCriterion("print_mode between", value1, value2, "printMode");
            return (Criteria) this;
        }

        public Criteria andPrintModeNotBetween(String value1, String value2) {
            addCriterion("print_mode not between", value1, value2, "printMode");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}