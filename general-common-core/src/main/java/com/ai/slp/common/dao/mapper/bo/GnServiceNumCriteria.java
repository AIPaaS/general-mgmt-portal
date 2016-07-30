package com.ai.slp.common.dao.mapper.bo;

import java.util.ArrayList;
import java.util.List;

public class GnServiceNumCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public GnServiceNumCriteria() {
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

        public Criteria andOrderNoIsNull() {
            addCriterion("ORDER_NO is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("ORDER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("ORDER_NO =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("ORDER_NO <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("ORDER_NO >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_NO >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("ORDER_NO <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("ORDER_NO <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("ORDER_NO like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("ORDER_NO not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("ORDER_NO in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("ORDER_NO not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("ORDER_NO between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("ORDER_NO not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIsNull() {
            addCriterion("PROVINCE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIsNotNull() {
            addCriterion("PROVINCE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeEqualTo(String value) {
            addCriterion("PROVINCE_CODE =", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotEqualTo(String value) {
            addCriterion("PROVINCE_CODE <>", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeGreaterThan(String value) {
            addCriterion("PROVINCE_CODE >", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PROVINCE_CODE >=", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLessThan(String value) {
            addCriterion("PROVINCE_CODE <", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLessThanOrEqualTo(String value) {
            addCriterion("PROVINCE_CODE <=", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLike(String value) {
            addCriterion("PROVINCE_CODE like", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotLike(String value) {
            addCriterion("PROVINCE_CODE not like", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIn(List<String> values) {
            addCriterion("PROVINCE_CODE in", values, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotIn(List<String> values) {
            addCriterion("PROVINCE_CODE not in", values, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeBetween(String value1, String value2) {
            addCriterion("PROVINCE_CODE between", value1, value2, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotBetween(String value1, String value2) {
            addCriterion("PROVINCE_CODE not between", value1, value2, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceNameIsNull() {
            addCriterion("PROVINCE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andProvinceNameIsNotNull() {
            addCriterion("PROVINCE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceNameEqualTo(String value) {
            addCriterion("PROVINCE_NAME =", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameNotEqualTo(String value) {
            addCriterion("PROVINCE_NAME <>", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameGreaterThan(String value) {
            addCriterion("PROVINCE_NAME >", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameGreaterThanOrEqualTo(String value) {
            addCriterion("PROVINCE_NAME >=", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameLessThan(String value) {
            addCriterion("PROVINCE_NAME <", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameLessThanOrEqualTo(String value) {
            addCriterion("PROVINCE_NAME <=", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameLike(String value) {
            addCriterion("PROVINCE_NAME like", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameNotLike(String value) {
            addCriterion("PROVINCE_NAME not like", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameIn(List<String> values) {
            addCriterion("PROVINCE_NAME in", values, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameNotIn(List<String> values) {
            addCriterion("PROVINCE_NAME not in", values, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameBetween(String value1, String value2) {
            addCriterion("PROVINCE_NAME between", value1, value2, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameNotBetween(String value1, String value2) {
            addCriterion("PROVINCE_NAME not between", value1, value2, "provinceName");
            return (Criteria) this;
        }

        public Criteria andCityCodeIsNull() {
            addCriterion("CITY_CODE is null");
            return (Criteria) this;
        }

        public Criteria andCityCodeIsNotNull() {
            addCriterion("CITY_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCityCodeEqualTo(String value) {
            addCriterion("CITY_CODE =", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotEqualTo(String value) {
            addCriterion("CITY_CODE <>", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeGreaterThan(String value) {
            addCriterion("CITY_CODE >", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CITY_CODE >=", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLessThan(String value) {
            addCriterion("CITY_CODE <", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLessThanOrEqualTo(String value) {
            addCriterion("CITY_CODE <=", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLike(String value) {
            addCriterion("CITY_CODE like", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotLike(String value) {
            addCriterion("CITY_CODE not like", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeIn(List<String> values) {
            addCriterion("CITY_CODE in", values, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotIn(List<String> values) {
            addCriterion("CITY_CODE not in", values, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeBetween(String value1, String value2) {
            addCriterion("CITY_CODE between", value1, value2, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotBetween(String value1, String value2) {
            addCriterion("CITY_CODE not between", value1, value2, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityNameIsNull() {
            addCriterion("CITY_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCityNameIsNotNull() {
            addCriterion("CITY_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCityNameEqualTo(String value) {
            addCriterion("CITY_NAME =", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotEqualTo(String value) {
            addCriterion("CITY_NAME <>", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameGreaterThan(String value) {
            addCriterion("CITY_NAME >", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameGreaterThanOrEqualTo(String value) {
            addCriterion("CITY_NAME >=", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLessThan(String value) {
            addCriterion("CITY_NAME <", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLessThanOrEqualTo(String value) {
            addCriterion("CITY_NAME <=", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLike(String value) {
            addCriterion("CITY_NAME like", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotLike(String value) {
            addCriterion("CITY_NAME not like", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameIn(List<String> values) {
            addCriterion("CITY_NAME in", values, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotIn(List<String> values) {
            addCriterion("CITY_NAME not in", values, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameBetween(String value1, String value2) {
            addCriterion("CITY_NAME between", value1, value2, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotBetween(String value1, String value2) {
            addCriterion("CITY_NAME not between", value1, value2, "cityName");
            return (Criteria) this;
        }

        public Criteria andBasicOrgCodeIsNull() {
            addCriterion("BASIC_ORG_CODE is null");
            return (Criteria) this;
        }

        public Criteria andBasicOrgCodeIsNotNull() {
            addCriterion("BASIC_ORG_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andBasicOrgCodeEqualTo(String value) {
            addCriterion("BASIC_ORG_CODE =", value, "basicOrgCode");
            return (Criteria) this;
        }

        public Criteria andBasicOrgCodeNotEqualTo(String value) {
            addCriterion("BASIC_ORG_CODE <>", value, "basicOrgCode");
            return (Criteria) this;
        }

        public Criteria andBasicOrgCodeGreaterThan(String value) {
            addCriterion("BASIC_ORG_CODE >", value, "basicOrgCode");
            return (Criteria) this;
        }

        public Criteria andBasicOrgCodeGreaterThanOrEqualTo(String value) {
            addCriterion("BASIC_ORG_CODE >=", value, "basicOrgCode");
            return (Criteria) this;
        }

        public Criteria andBasicOrgCodeLessThan(String value) {
            addCriterion("BASIC_ORG_CODE <", value, "basicOrgCode");
            return (Criteria) this;
        }

        public Criteria andBasicOrgCodeLessThanOrEqualTo(String value) {
            addCriterion("BASIC_ORG_CODE <=", value, "basicOrgCode");
            return (Criteria) this;
        }

        public Criteria andBasicOrgCodeLike(String value) {
            addCriterion("BASIC_ORG_CODE like", value, "basicOrgCode");
            return (Criteria) this;
        }

        public Criteria andBasicOrgCodeNotLike(String value) {
            addCriterion("BASIC_ORG_CODE not like", value, "basicOrgCode");
            return (Criteria) this;
        }

        public Criteria andBasicOrgCodeIn(List<String> values) {
            addCriterion("BASIC_ORG_CODE in", values, "basicOrgCode");
            return (Criteria) this;
        }

        public Criteria andBasicOrgCodeNotIn(List<String> values) {
            addCriterion("BASIC_ORG_CODE not in", values, "basicOrgCode");
            return (Criteria) this;
        }

        public Criteria andBasicOrgCodeBetween(String value1, String value2) {
            addCriterion("BASIC_ORG_CODE between", value1, value2, "basicOrgCode");
            return (Criteria) this;
        }

        public Criteria andBasicOrgCodeNotBetween(String value1, String value2) {
            addCriterion("BASIC_ORG_CODE not between", value1, value2, "basicOrgCode");
            return (Criteria) this;
        }

        public Criteria andBasicOrgNameIsNull() {
            addCriterion("BASIC_ORG_NAME is null");
            return (Criteria) this;
        }

        public Criteria andBasicOrgNameIsNotNull() {
            addCriterion("BASIC_ORG_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andBasicOrgNameEqualTo(String value) {
            addCriterion("BASIC_ORG_NAME =", value, "basicOrgName");
            return (Criteria) this;
        }

        public Criteria andBasicOrgNameNotEqualTo(String value) {
            addCriterion("BASIC_ORG_NAME <>", value, "basicOrgName");
            return (Criteria) this;
        }

        public Criteria andBasicOrgNameGreaterThan(String value) {
            addCriterion("BASIC_ORG_NAME >", value, "basicOrgName");
            return (Criteria) this;
        }

        public Criteria andBasicOrgNameGreaterThanOrEqualTo(String value) {
            addCriterion("BASIC_ORG_NAME >=", value, "basicOrgName");
            return (Criteria) this;
        }

        public Criteria andBasicOrgNameLessThan(String value) {
            addCriterion("BASIC_ORG_NAME <", value, "basicOrgName");
            return (Criteria) this;
        }

        public Criteria andBasicOrgNameLessThanOrEqualTo(String value) {
            addCriterion("BASIC_ORG_NAME <=", value, "basicOrgName");
            return (Criteria) this;
        }

        public Criteria andBasicOrgNameLike(String value) {
            addCriterion("BASIC_ORG_NAME like", value, "basicOrgName");
            return (Criteria) this;
        }

        public Criteria andBasicOrgNameNotLike(String value) {
            addCriterion("BASIC_ORG_NAME not like", value, "basicOrgName");
            return (Criteria) this;
        }

        public Criteria andBasicOrgNameIn(List<String> values) {
            addCriterion("BASIC_ORG_NAME in", values, "basicOrgName");
            return (Criteria) this;
        }

        public Criteria andBasicOrgNameNotIn(List<String> values) {
            addCriterion("BASIC_ORG_NAME not in", values, "basicOrgName");
            return (Criteria) this;
        }

        public Criteria andBasicOrgNameBetween(String value1, String value2) {
            addCriterion("BASIC_ORG_NAME between", value1, value2, "basicOrgName");
            return (Criteria) this;
        }

        public Criteria andBasicOrgNameNotBetween(String value1, String value2) {
            addCriterion("BASIC_ORG_NAME not between", value1, value2, "basicOrgName");
            return (Criteria) this;
        }

        public Criteria andServiceHeadCodeIsNull() {
            addCriterion("SERVICE_HEAD_CODE is null");
            return (Criteria) this;
        }

        public Criteria andServiceHeadCodeIsNotNull() {
            addCriterion("SERVICE_HEAD_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andServiceHeadCodeEqualTo(String value) {
            addCriterion("SERVICE_HEAD_CODE =", value, "serviceHeadCode");
            return (Criteria) this;
        }

        public Criteria andServiceHeadCodeNotEqualTo(String value) {
            addCriterion("SERVICE_HEAD_CODE <>", value, "serviceHeadCode");
            return (Criteria) this;
        }

        public Criteria andServiceHeadCodeGreaterThan(String value) {
            addCriterion("SERVICE_HEAD_CODE >", value, "serviceHeadCode");
            return (Criteria) this;
        }

        public Criteria andServiceHeadCodeGreaterThanOrEqualTo(String value) {
            addCriterion("SERVICE_HEAD_CODE >=", value, "serviceHeadCode");
            return (Criteria) this;
        }

        public Criteria andServiceHeadCodeLessThan(String value) {
            addCriterion("SERVICE_HEAD_CODE <", value, "serviceHeadCode");
            return (Criteria) this;
        }

        public Criteria andServiceHeadCodeLessThanOrEqualTo(String value) {
            addCriterion("SERVICE_HEAD_CODE <=", value, "serviceHeadCode");
            return (Criteria) this;
        }

        public Criteria andServiceHeadCodeLike(String value) {
            addCriterion("SERVICE_HEAD_CODE like", value, "serviceHeadCode");
            return (Criteria) this;
        }

        public Criteria andServiceHeadCodeNotLike(String value) {
            addCriterion("SERVICE_HEAD_CODE not like", value, "serviceHeadCode");
            return (Criteria) this;
        }

        public Criteria andServiceHeadCodeIn(List<String> values) {
            addCriterion("SERVICE_HEAD_CODE in", values, "serviceHeadCode");
            return (Criteria) this;
        }

        public Criteria andServiceHeadCodeNotIn(List<String> values) {
            addCriterion("SERVICE_HEAD_CODE not in", values, "serviceHeadCode");
            return (Criteria) this;
        }

        public Criteria andServiceHeadCodeBetween(String value1, String value2) {
            addCriterion("SERVICE_HEAD_CODE between", value1, value2, "serviceHeadCode");
            return (Criteria) this;
        }

        public Criteria andServiceHeadCodeNotBetween(String value1, String value2) {
            addCriterion("SERVICE_HEAD_CODE not between", value1, value2, "serviceHeadCode");
            return (Criteria) this;
        }

        public Criteria andServiceNumCodeIsNull() {
            addCriterion("SERVICE_NUM_CODE is null");
            return (Criteria) this;
        }

        public Criteria andServiceNumCodeIsNotNull() {
            addCriterion("SERVICE_NUM_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andServiceNumCodeEqualTo(String value) {
            addCriterion("SERVICE_NUM_CODE =", value, "serviceNumCode");
            return (Criteria) this;
        }

        public Criteria andServiceNumCodeNotEqualTo(String value) {
            addCriterion("SERVICE_NUM_CODE <>", value, "serviceNumCode");
            return (Criteria) this;
        }

        public Criteria andServiceNumCodeGreaterThan(String value) {
            addCriterion("SERVICE_NUM_CODE >", value, "serviceNumCode");
            return (Criteria) this;
        }

        public Criteria andServiceNumCodeGreaterThanOrEqualTo(String value) {
            addCriterion("SERVICE_NUM_CODE >=", value, "serviceNumCode");
            return (Criteria) this;
        }

        public Criteria andServiceNumCodeLessThan(String value) {
            addCriterion("SERVICE_NUM_CODE <", value, "serviceNumCode");
            return (Criteria) this;
        }

        public Criteria andServiceNumCodeLessThanOrEqualTo(String value) {
            addCriterion("SERVICE_NUM_CODE <=", value, "serviceNumCode");
            return (Criteria) this;
        }

        public Criteria andServiceNumCodeLike(String value) {
            addCriterion("SERVICE_NUM_CODE like", value, "serviceNumCode");
            return (Criteria) this;
        }

        public Criteria andServiceNumCodeNotLike(String value) {
            addCriterion("SERVICE_NUM_CODE not like", value, "serviceNumCode");
            return (Criteria) this;
        }

        public Criteria andServiceNumCodeIn(List<String> values) {
            addCriterion("SERVICE_NUM_CODE in", values, "serviceNumCode");
            return (Criteria) this;
        }

        public Criteria andServiceNumCodeNotIn(List<String> values) {
            addCriterion("SERVICE_NUM_CODE not in", values, "serviceNumCode");
            return (Criteria) this;
        }

        public Criteria andServiceNumCodeBetween(String value1, String value2) {
            addCriterion("SERVICE_NUM_CODE between", value1, value2, "serviceNumCode");
            return (Criteria) this;
        }

        public Criteria andServiceNumCodeNotBetween(String value1, String value2) {
            addCriterion("SERVICE_NUM_CODE not between", value1, value2, "serviceNumCode");
            return (Criteria) this;
        }

        public Criteria andBusiCodeIsNull() {
            addCriterion("BUSI_CODE is null");
            return (Criteria) this;
        }

        public Criteria andBusiCodeIsNotNull() {
            addCriterion("BUSI_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andBusiCodeEqualTo(String value) {
            addCriterion("BUSI_CODE =", value, "busiCode");
            return (Criteria) this;
        }

        public Criteria andBusiCodeNotEqualTo(String value) {
            addCriterion("BUSI_CODE <>", value, "busiCode");
            return (Criteria) this;
        }

        public Criteria andBusiCodeGreaterThan(String value) {
            addCriterion("BUSI_CODE >", value, "busiCode");
            return (Criteria) this;
        }

        public Criteria andBusiCodeGreaterThanOrEqualTo(String value) {
            addCriterion("BUSI_CODE >=", value, "busiCode");
            return (Criteria) this;
        }

        public Criteria andBusiCodeLessThan(String value) {
            addCriterion("BUSI_CODE <", value, "busiCode");
            return (Criteria) this;
        }

        public Criteria andBusiCodeLessThanOrEqualTo(String value) {
            addCriterion("BUSI_CODE <=", value, "busiCode");
            return (Criteria) this;
        }

        public Criteria andBusiCodeLike(String value) {
            addCriterion("BUSI_CODE like", value, "busiCode");
            return (Criteria) this;
        }

        public Criteria andBusiCodeNotLike(String value) {
            addCriterion("BUSI_CODE not like", value, "busiCode");
            return (Criteria) this;
        }

        public Criteria andBusiCodeIn(List<String> values) {
            addCriterion("BUSI_CODE in", values, "busiCode");
            return (Criteria) this;
        }

        public Criteria andBusiCodeNotIn(List<String> values) {
            addCriterion("BUSI_CODE not in", values, "busiCode");
            return (Criteria) this;
        }

        public Criteria andBusiCodeBetween(String value1, String value2) {
            addCriterion("BUSI_CODE between", value1, value2, "busiCode");
            return (Criteria) this;
        }

        public Criteria andBusiCodeNotBetween(String value1, String value2) {
            addCriterion("BUSI_CODE not between", value1, value2, "busiCode");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
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