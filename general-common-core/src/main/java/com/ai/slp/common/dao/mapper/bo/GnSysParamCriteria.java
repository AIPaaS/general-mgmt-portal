package com.ai.slp.common.dao.mapper.bo;

import java.util.ArrayList;
import java.util.List;

public class GnSysParamCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public GnSysParamCriteria() {
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

        public Criteria andGuidkeyIsNull() {
            addCriterion("GUIDKEY is null");
            return (Criteria) this;
        }

        public Criteria andGuidkeyIsNotNull() {
            addCriterion("GUIDKEY is not null");
            return (Criteria) this;
        }

        public Criteria andGuidkeyEqualTo(String value) {
            addCriterion("GUIDKEY =", value, "guidkey");
            return (Criteria) this;
        }

        public Criteria andGuidkeyNotEqualTo(String value) {
            addCriterion("GUIDKEY <>", value, "guidkey");
            return (Criteria) this;
        }

        public Criteria andGuidkeyGreaterThan(String value) {
            addCriterion("GUIDKEY >", value, "guidkey");
            return (Criteria) this;
        }

        public Criteria andGuidkeyGreaterThanOrEqualTo(String value) {
            addCriterion("GUIDKEY >=", value, "guidkey");
            return (Criteria) this;
        }

        public Criteria andGuidkeyLessThan(String value) {
            addCriterion("GUIDKEY <", value, "guidkey");
            return (Criteria) this;
        }

        public Criteria andGuidkeyLessThanOrEqualTo(String value) {
            addCriterion("GUIDKEY <=", value, "guidkey");
            return (Criteria) this;
        }

        public Criteria andGuidkeyLike(String value) {
            addCriterion("GUIDKEY like", value, "guidkey");
            return (Criteria) this;
        }

        public Criteria andGuidkeyNotLike(String value) {
            addCriterion("GUIDKEY not like", value, "guidkey");
            return (Criteria) this;
        }

        public Criteria andGuidkeyIn(List<String> values) {
            addCriterion("GUIDKEY in", values, "guidkey");
            return (Criteria) this;
        }

        public Criteria andGuidkeyNotIn(List<String> values) {
            addCriterion("GUIDKEY not in", values, "guidkey");
            return (Criteria) this;
        }

        public Criteria andGuidkeyBetween(String value1, String value2) {
            addCriterion("GUIDKEY between", value1, value2, "guidkey");
            return (Criteria) this;
        }

        public Criteria andGuidkeyNotBetween(String value1, String value2) {
            addCriterion("GUIDKEY not between", value1, value2, "guidkey");
            return (Criteria) this;
        }

        public Criteria andTypeCodeIsNull() {
            addCriterion("TYPE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andTypeCodeIsNotNull() {
            addCriterion("TYPE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andTypeCodeEqualTo(String value) {
            addCriterion("TYPE_CODE =", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeNotEqualTo(String value) {
            addCriterion("TYPE_CODE <>", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeGreaterThan(String value) {
            addCriterion("TYPE_CODE >", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("TYPE_CODE >=", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeLessThan(String value) {
            addCriterion("TYPE_CODE <", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeLessThanOrEqualTo(String value) {
            addCriterion("TYPE_CODE <=", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeLike(String value) {
            addCriterion("TYPE_CODE like", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeNotLike(String value) {
            addCriterion("TYPE_CODE not like", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeIn(List<String> values) {
            addCriterion("TYPE_CODE in", values, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeNotIn(List<String> values) {
            addCriterion("TYPE_CODE not in", values, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeBetween(String value1, String value2) {
            addCriterion("TYPE_CODE between", value1, value2, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeNotBetween(String value1, String value2) {
            addCriterion("TYPE_CODE not between", value1, value2, "typeCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeIsNull() {
            addCriterion("PARAM_CODE is null");
            return (Criteria) this;
        }

        public Criteria andParamCodeIsNotNull() {
            addCriterion("PARAM_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andParamCodeEqualTo(String value) {
            addCriterion("PARAM_CODE =", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeNotEqualTo(String value) {
            addCriterion("PARAM_CODE <>", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeGreaterThan(String value) {
            addCriterion("PARAM_CODE >", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PARAM_CODE >=", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeLessThan(String value) {
            addCriterion("PARAM_CODE <", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeLessThanOrEqualTo(String value) {
            addCriterion("PARAM_CODE <=", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeLike(String value) {
            addCriterion("PARAM_CODE like", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeNotLike(String value) {
            addCriterion("PARAM_CODE not like", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeIn(List<String> values) {
            addCriterion("PARAM_CODE in", values, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeNotIn(List<String> values) {
            addCriterion("PARAM_CODE not in", values, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeBetween(String value1, String value2) {
            addCriterion("PARAM_CODE between", value1, value2, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeNotBetween(String value1, String value2) {
            addCriterion("PARAM_CODE not between", value1, value2, "paramCode");
            return (Criteria) this;
        }

        public Criteria andColumnValueIsNull() {
            addCriterion("COLUMN_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andColumnValueIsNotNull() {
            addCriterion("COLUMN_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andColumnValueEqualTo(String value) {
            addCriterion("COLUMN_VALUE =", value, "columnValue");
            return (Criteria) this;
        }

        public Criteria andColumnValueNotEqualTo(String value) {
            addCriterion("COLUMN_VALUE <>", value, "columnValue");
            return (Criteria) this;
        }

        public Criteria andColumnValueGreaterThan(String value) {
            addCriterion("COLUMN_VALUE >", value, "columnValue");
            return (Criteria) this;
        }

        public Criteria andColumnValueGreaterThanOrEqualTo(String value) {
            addCriterion("COLUMN_VALUE >=", value, "columnValue");
            return (Criteria) this;
        }

        public Criteria andColumnValueLessThan(String value) {
            addCriterion("COLUMN_VALUE <", value, "columnValue");
            return (Criteria) this;
        }

        public Criteria andColumnValueLessThanOrEqualTo(String value) {
            addCriterion("COLUMN_VALUE <=", value, "columnValue");
            return (Criteria) this;
        }

        public Criteria andColumnValueLike(String value) {
            addCriterion("COLUMN_VALUE like", value, "columnValue");
            return (Criteria) this;
        }

        public Criteria andColumnValueNotLike(String value) {
            addCriterion("COLUMN_VALUE not like", value, "columnValue");
            return (Criteria) this;
        }

        public Criteria andColumnValueIn(List<String> values) {
            addCriterion("COLUMN_VALUE in", values, "columnValue");
            return (Criteria) this;
        }

        public Criteria andColumnValueNotIn(List<String> values) {
            addCriterion("COLUMN_VALUE not in", values, "columnValue");
            return (Criteria) this;
        }

        public Criteria andColumnValueBetween(String value1, String value2) {
            addCriterion("COLUMN_VALUE between", value1, value2, "columnValue");
            return (Criteria) this;
        }

        public Criteria andColumnValueNotBetween(String value1, String value2) {
            addCriterion("COLUMN_VALUE not between", value1, value2, "columnValue");
            return (Criteria) this;
        }

        public Criteria andColumnDescIsNull() {
            addCriterion("COLUMN_DESC is null");
            return (Criteria) this;
        }

        public Criteria andColumnDescIsNotNull() {
            addCriterion("COLUMN_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andColumnDescEqualTo(String value) {
            addCriterion("COLUMN_DESC =", value, "columnDesc");
            return (Criteria) this;
        }

        public Criteria andColumnDescNotEqualTo(String value) {
            addCriterion("COLUMN_DESC <>", value, "columnDesc");
            return (Criteria) this;
        }

        public Criteria andColumnDescGreaterThan(String value) {
            addCriterion("COLUMN_DESC >", value, "columnDesc");
            return (Criteria) this;
        }

        public Criteria andColumnDescGreaterThanOrEqualTo(String value) {
            addCriterion("COLUMN_DESC >=", value, "columnDesc");
            return (Criteria) this;
        }

        public Criteria andColumnDescLessThan(String value) {
            addCriterion("COLUMN_DESC <", value, "columnDesc");
            return (Criteria) this;
        }

        public Criteria andColumnDescLessThanOrEqualTo(String value) {
            addCriterion("COLUMN_DESC <=", value, "columnDesc");
            return (Criteria) this;
        }

        public Criteria andColumnDescLike(String value) {
            addCriterion("COLUMN_DESC like", value, "columnDesc");
            return (Criteria) this;
        }

        public Criteria andColumnDescNotLike(String value) {
            addCriterion("COLUMN_DESC not like", value, "columnDesc");
            return (Criteria) this;
        }

        public Criteria andColumnDescIn(List<String> values) {
            addCriterion("COLUMN_DESC in", values, "columnDesc");
            return (Criteria) this;
        }

        public Criteria andColumnDescNotIn(List<String> values) {
            addCriterion("COLUMN_DESC not in", values, "columnDesc");
            return (Criteria) this;
        }

        public Criteria andColumnDescBetween(String value1, String value2) {
            addCriterion("COLUMN_DESC between", value1, value2, "columnDesc");
            return (Criteria) this;
        }

        public Criteria andColumnDescNotBetween(String value1, String value2) {
            addCriterion("COLUMN_DESC not between", value1, value2, "columnDesc");
            return (Criteria) this;
        }

        public Criteria andSubParamCodeIsNull() {
            addCriterion("SUB_PARAM_CODE is null");
            return (Criteria) this;
        }

        public Criteria andSubParamCodeIsNotNull() {
            addCriterion("SUB_PARAM_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andSubParamCodeEqualTo(String value) {
            addCriterion("SUB_PARAM_CODE =", value, "subParamCode");
            return (Criteria) this;
        }

        public Criteria andSubParamCodeNotEqualTo(String value) {
            addCriterion("SUB_PARAM_CODE <>", value, "subParamCode");
            return (Criteria) this;
        }

        public Criteria andSubParamCodeGreaterThan(String value) {
            addCriterion("SUB_PARAM_CODE >", value, "subParamCode");
            return (Criteria) this;
        }

        public Criteria andSubParamCodeGreaterThanOrEqualTo(String value) {
            addCriterion("SUB_PARAM_CODE >=", value, "subParamCode");
            return (Criteria) this;
        }

        public Criteria andSubParamCodeLessThan(String value) {
            addCriterion("SUB_PARAM_CODE <", value, "subParamCode");
            return (Criteria) this;
        }

        public Criteria andSubParamCodeLessThanOrEqualTo(String value) {
            addCriterion("SUB_PARAM_CODE <=", value, "subParamCode");
            return (Criteria) this;
        }

        public Criteria andSubParamCodeLike(String value) {
            addCriterion("SUB_PARAM_CODE like", value, "subParamCode");
            return (Criteria) this;
        }

        public Criteria andSubParamCodeNotLike(String value) {
            addCriterion("SUB_PARAM_CODE not like", value, "subParamCode");
            return (Criteria) this;
        }

        public Criteria andSubParamCodeIn(List<String> values) {
            addCriterion("SUB_PARAM_CODE in", values, "subParamCode");
            return (Criteria) this;
        }

        public Criteria andSubParamCodeNotIn(List<String> values) {
            addCriterion("SUB_PARAM_CODE not in", values, "subParamCode");
            return (Criteria) this;
        }

        public Criteria andSubParamCodeBetween(String value1, String value2) {
            addCriterion("SUB_PARAM_CODE between", value1, value2, "subParamCode");
            return (Criteria) this;
        }

        public Criteria andSubParamCodeNotBetween(String value1, String value2) {
            addCriterion("SUB_PARAM_CODE not between", value1, value2, "subParamCode");
            return (Criteria) this;
        }

        public Criteria andDispordIsNull() {
            addCriterion("DISPORD is null");
            return (Criteria) this;
        }

        public Criteria andDispordIsNotNull() {
            addCriterion("DISPORD is not null");
            return (Criteria) this;
        }

        public Criteria andDispordEqualTo(int value) {
            addCriterion("DISPORD =", value, "dispord");
            return (Criteria) this;
        }

        public Criteria andDispordNotEqualTo(int value) {
            addCriterion("DISPORD <>", value, "dispord");
            return (Criteria) this;
        }

        public Criteria andDispordGreaterThan(int value) {
            addCriterion("DISPORD >", value, "dispord");
            return (Criteria) this;
        }

        public Criteria andDispordGreaterThanOrEqualTo(int value) {
            addCriterion("DISPORD >=", value, "dispord");
            return (Criteria) this;
        }

        public Criteria andDispordLessThan(int value) {
            addCriterion("DISPORD <", value, "dispord");
            return (Criteria) this;
        }

        public Criteria andDispordLessThanOrEqualTo(int value) {
            addCriterion("DISPORD <=", value, "dispord");
            return (Criteria) this;
        }

        public Criteria andDispordIn(List<Integer> values) {
            addCriterion("DISPORD in", values, "dispord");
            return (Criteria) this;
        }

        public Criteria andDispordNotIn(List<Integer> values) {
            addCriterion("DISPORD not in", values, "dispord");
            return (Criteria) this;
        }

        public Criteria andDispordBetween(int value1, int value2) {
            addCriterion("DISPORD between", value1, value2, "dispord");
            return (Criteria) this;
        }

        public Criteria andDispordNotBetween(int value1, int value2) {
            addCriterion("DISPORD not between", value1, value2, "dispord");
            return (Criteria) this;
        }

        public Criteria andDescbIsNull() {
            addCriterion("DESCB is null");
            return (Criteria) this;
        }

        public Criteria andDescbIsNotNull() {
            addCriterion("DESCB is not null");
            return (Criteria) this;
        }

        public Criteria andDescbEqualTo(String value) {
            addCriterion("DESCB =", value, "descb");
            return (Criteria) this;
        }

        public Criteria andDescbNotEqualTo(String value) {
            addCriterion("DESCB <>", value, "descb");
            return (Criteria) this;
        }

        public Criteria andDescbGreaterThan(String value) {
            addCriterion("DESCB >", value, "descb");
            return (Criteria) this;
        }

        public Criteria andDescbGreaterThanOrEqualTo(String value) {
            addCriterion("DESCB >=", value, "descb");
            return (Criteria) this;
        }

        public Criteria andDescbLessThan(String value) {
            addCriterion("DESCB <", value, "descb");
            return (Criteria) this;
        }

        public Criteria andDescbLessThanOrEqualTo(String value) {
            addCriterion("DESCB <=", value, "descb");
            return (Criteria) this;
        }

        public Criteria andDescbLike(String value) {
            addCriterion("DESCB like", value, "descb");
            return (Criteria) this;
        }

        public Criteria andDescbNotLike(String value) {
            addCriterion("DESCB not like", value, "descb");
            return (Criteria) this;
        }

        public Criteria andDescbIn(List<String> values) {
            addCriterion("DESCB in", values, "descb");
            return (Criteria) this;
        }

        public Criteria andDescbNotIn(List<String> values) {
            addCriterion("DESCB not in", values, "descb");
            return (Criteria) this;
        }

        public Criteria andDescbBetween(String value1, String value2) {
            addCriterion("DESCB between", value1, value2, "descb");
            return (Criteria) this;
        }

        public Criteria andDescbNotBetween(String value1, String value2) {
            addCriterion("DESCB not between", value1, value2, "descb");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("STATE like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("STATE not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("STATE not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNull() {
            addCriterion("TENANT_ID is null");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNotNull() {
            addCriterion("TENANT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTenantIdEqualTo(String value) {
            addCriterion("TENANT_ID =", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotEqualTo(String value) {
            addCriterion("TENANT_ID <>", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThan(String value) {
            addCriterion("TENANT_ID >", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThanOrEqualTo(String value) {
            addCriterion("TENANT_ID >=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThan(String value) {
            addCriterion("TENANT_ID <", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThanOrEqualTo(String value) {
            addCriterion("TENANT_ID <=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLike(String value) {
            addCriterion("TENANT_ID like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotLike(String value) {
            addCriterion("TENANT_ID not like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdIn(List<String> values) {
            addCriterion("TENANT_ID in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotIn(List<String> values) {
            addCriterion("TENANT_ID not in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdBetween(String value1, String value2) {
            addCriterion("TENANT_ID between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotBetween(String value1, String value2) {
            addCriterion("TENANT_ID not between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andSystemIdIsNull() {
            addCriterion("SYSTEM_ID is null");
            return (Criteria) this;
        }

        public Criteria andSystemIdIsNotNull() {
            addCriterion("SYSTEM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSystemIdEqualTo(String value) {
            addCriterion("SYSTEM_ID =", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotEqualTo(String value) {
            addCriterion("SYSTEM_ID <>", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdGreaterThan(String value) {
            addCriterion("SYSTEM_ID >", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdGreaterThanOrEqualTo(String value) {
            addCriterion("SYSTEM_ID >=", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdLessThan(String value) {
            addCriterion("SYSTEM_ID <", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdLessThanOrEqualTo(String value) {
            addCriterion("SYSTEM_ID <=", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdLike(String value) {
            addCriterion("SYSTEM_ID like", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotLike(String value) {
            addCriterion("SYSTEM_ID not like", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdIn(List<String> values) {
            addCriterion("SYSTEM_ID in", values, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotIn(List<String> values) {
            addCriterion("SYSTEM_ID not in", values, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdBetween(String value1, String value2) {
            addCriterion("SYSTEM_ID between", value1, value2, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotBetween(String value1, String value2) {
            addCriterion("SYSTEM_ID not between", value1, value2, "systemId");
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