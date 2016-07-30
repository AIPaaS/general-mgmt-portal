package com.ai.slp.common.dao.mapper.bo;

import java.util.ArrayList;
import java.util.List;

public class GnIpAddrCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public GnIpAddrCriteria() {
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

        public Criteria andStartIpIsNull() {
            addCriterion("START_IP is null");
            return (Criteria) this;
        }

        public Criteria andStartIpIsNotNull() {
            addCriterion("START_IP is not null");
            return (Criteria) this;
        }

        public Criteria andStartIpEqualTo(String value) {
            addCriterion("START_IP =", value, "startIp");
            return (Criteria) this;
        }

        public Criteria andStartIpNotEqualTo(String value) {
            addCriterion("START_IP <>", value, "startIp");
            return (Criteria) this;
        }

        public Criteria andStartIpGreaterThan(String value) {
            addCriterion("START_IP >", value, "startIp");
            return (Criteria) this;
        }

        public Criteria andStartIpGreaterThanOrEqualTo(String value) {
            addCriterion("START_IP >=", value, "startIp");
            return (Criteria) this;
        }

        public Criteria andStartIpLessThan(String value) {
            addCriterion("START_IP <", value, "startIp");
            return (Criteria) this;
        }

        public Criteria andStartIpLessThanOrEqualTo(String value) {
            addCriterion("START_IP <=", value, "startIp");
            return (Criteria) this;
        }

        public Criteria andStartIpLike(String value) {
            addCriterion("START_IP like", value, "startIp");
            return (Criteria) this;
        }

        public Criteria andStartIpNotLike(String value) {
            addCriterion("START_IP not like", value, "startIp");
            return (Criteria) this;
        }

        public Criteria andStartIpIn(List<String> values) {
            addCriterion("START_IP in", values, "startIp");
            return (Criteria) this;
        }

        public Criteria andStartIpNotIn(List<String> values) {
            addCriterion("START_IP not in", values, "startIp");
            return (Criteria) this;
        }

        public Criteria andStartIpBetween(String value1, String value2) {
            addCriterion("START_IP between", value1, value2, "startIp");
            return (Criteria) this;
        }

        public Criteria andStartIpNotBetween(String value1, String value2) {
            addCriterion("START_IP not between", value1, value2, "startIp");
            return (Criteria) this;
        }

        public Criteria andEndIpIsNull() {
            addCriterion("END_IP is null");
            return (Criteria) this;
        }

        public Criteria andEndIpIsNotNull() {
            addCriterion("END_IP is not null");
            return (Criteria) this;
        }

        public Criteria andEndIpEqualTo(String value) {
            addCriterion("END_IP =", value, "endIp");
            return (Criteria) this;
        }

        public Criteria andEndIpNotEqualTo(String value) {
            addCriterion("END_IP <>", value, "endIp");
            return (Criteria) this;
        }

        public Criteria andEndIpGreaterThan(String value) {
            addCriterion("END_IP >", value, "endIp");
            return (Criteria) this;
        }

        public Criteria andEndIpGreaterThanOrEqualTo(String value) {
            addCriterion("END_IP >=", value, "endIp");
            return (Criteria) this;
        }

        public Criteria andEndIpLessThan(String value) {
            addCriterion("END_IP <", value, "endIp");
            return (Criteria) this;
        }

        public Criteria andEndIpLessThanOrEqualTo(String value) {
            addCriterion("END_IP <=", value, "endIp");
            return (Criteria) this;
        }

        public Criteria andEndIpLike(String value) {
            addCriterion("END_IP like", value, "endIp");
            return (Criteria) this;
        }

        public Criteria andEndIpNotLike(String value) {
            addCriterion("END_IP not like", value, "endIp");
            return (Criteria) this;
        }

        public Criteria andEndIpIn(List<String> values) {
            addCriterion("END_IP in", values, "endIp");
            return (Criteria) this;
        }

        public Criteria andEndIpNotIn(List<String> values) {
            addCriterion("END_IP not in", values, "endIp");
            return (Criteria) this;
        }

        public Criteria andEndIpBetween(String value1, String value2) {
            addCriterion("END_IP between", value1, value2, "endIp");
            return (Criteria) this;
        }

        public Criteria andEndIpNotBetween(String value1, String value2) {
            addCriterion("END_IP not between", value1, value2, "endIp");
            return (Criteria) this;
        }

        public Criteria andStartNumIsNull() {
            addCriterion("START_NUM is null");
            return (Criteria) this;
        }

        public Criteria andStartNumIsNotNull() {
            addCriterion("START_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andStartNumEqualTo(Long value) {
            addCriterion("START_NUM =", value, "startNum");
            return (Criteria) this;
        }

        public Criteria andStartNumNotEqualTo(Long value) {
            addCriterion("START_NUM <>", value, "startNum");
            return (Criteria) this;
        }

        public Criteria andStartNumGreaterThan(Long value) {
            addCriterion("START_NUM >", value, "startNum");
            return (Criteria) this;
        }

        public Criteria andStartNumGreaterThanOrEqualTo(Long value) {
            addCriterion("START_NUM >=", value, "startNum");
            return (Criteria) this;
        }

        public Criteria andStartNumLessThan(Long value) {
            addCriterion("START_NUM <", value, "startNum");
            return (Criteria) this;
        }

        public Criteria andStartNumLessThanOrEqualTo(Long value) {
            addCriterion("START_NUM <=", value, "startNum");
            return (Criteria) this;
        }

        public Criteria andStartNumIn(List<Long> values) {
            addCriterion("START_NUM in", values, "startNum");
            return (Criteria) this;
        }

        public Criteria andStartNumNotIn(List<Long> values) {
            addCriterion("START_NUM not in", values, "startNum");
            return (Criteria) this;
        }

        public Criteria andStartNumBetween(Long value1, Long value2) {
            addCriterion("START_NUM between", value1, value2, "startNum");
            return (Criteria) this;
        }

        public Criteria andStartNumNotBetween(Long value1, Long value2) {
            addCriterion("START_NUM not between", value1, value2, "startNum");
            return (Criteria) this;
        }

        public Criteria andEndNumIsNull() {
            addCriterion("END_NUM is null");
            return (Criteria) this;
        }

        public Criteria andEndNumIsNotNull() {
            addCriterion("END_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andEndNumEqualTo(Long value) {
            addCriterion("END_NUM =", value, "endNum");
            return (Criteria) this;
        }

        public Criteria andEndNumNotEqualTo(Long value) {
            addCriterion("END_NUM <>", value, "endNum");
            return (Criteria) this;
        }

        public Criteria andEndNumGreaterThan(Long value) {
            addCriterion("END_NUM >", value, "endNum");
            return (Criteria) this;
        }

        public Criteria andEndNumGreaterThanOrEqualTo(Long value) {
            addCriterion("END_NUM >=", value, "endNum");
            return (Criteria) this;
        }

        public Criteria andEndNumLessThan(Long value) {
            addCriterion("END_NUM <", value, "endNum");
            return (Criteria) this;
        }

        public Criteria andEndNumLessThanOrEqualTo(Long value) {
            addCriterion("END_NUM <=", value, "endNum");
            return (Criteria) this;
        }

        public Criteria andEndNumIn(List<Long> values) {
            addCriterion("END_NUM in", values, "endNum");
            return (Criteria) this;
        }

        public Criteria andEndNumNotIn(List<Long> values) {
            addCriterion("END_NUM not in", values, "endNum");
            return (Criteria) this;
        }

        public Criteria andEndNumBetween(Long value1, Long value2) {
            addCriterion("END_NUM between", value1, value2, "endNum");
            return (Criteria) this;
        }

        public Criteria andEndNumNotBetween(Long value1, Long value2) {
            addCriterion("END_NUM not between", value1, value2, "endNum");
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

        public Criteria andDistrictCodeIsNull() {
            addCriterion("DISTRICT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeIsNotNull() {
            addCriterion("DISTRICT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeEqualTo(String value) {
            addCriterion("DISTRICT_CODE =", value, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeNotEqualTo(String value) {
            addCriterion("DISTRICT_CODE <>", value, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeGreaterThan(String value) {
            addCriterion("DISTRICT_CODE >", value, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeGreaterThanOrEqualTo(String value) {
            addCriterion("DISTRICT_CODE >=", value, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeLessThan(String value) {
            addCriterion("DISTRICT_CODE <", value, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeLessThanOrEqualTo(String value) {
            addCriterion("DISTRICT_CODE <=", value, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeLike(String value) {
            addCriterion("DISTRICT_CODE like", value, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeNotLike(String value) {
            addCriterion("DISTRICT_CODE not like", value, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeIn(List<String> values) {
            addCriterion("DISTRICT_CODE in", values, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeNotIn(List<String> values) {
            addCriterion("DISTRICT_CODE not in", values, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeBetween(String value1, String value2) {
            addCriterion("DISTRICT_CODE between", value1, value2, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeNotBetween(String value1, String value2) {
            addCriterion("DISTRICT_CODE not between", value1, value2, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictIsNull() {
            addCriterion("DISTRICT is null");
            return (Criteria) this;
        }

        public Criteria andDistrictIsNotNull() {
            addCriterion("DISTRICT is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictEqualTo(String value) {
            addCriterion("DISTRICT =", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotEqualTo(String value) {
            addCriterion("DISTRICT <>", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictGreaterThan(String value) {
            addCriterion("DISTRICT >", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictGreaterThanOrEqualTo(String value) {
            addCriterion("DISTRICT >=", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLessThan(String value) {
            addCriterion("DISTRICT <", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLessThanOrEqualTo(String value) {
            addCriterion("DISTRICT <=", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLike(String value) {
            addCriterion("DISTRICT like", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotLike(String value) {
            addCriterion("DISTRICT not like", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictIn(List<String> values) {
            addCriterion("DISTRICT in", values, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotIn(List<String> values) {
            addCriterion("DISTRICT not in", values, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictBetween(String value1, String value2) {
            addCriterion("DISTRICT between", value1, value2, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotBetween(String value1, String value2) {
            addCriterion("DISTRICT not between", value1, value2, "district");
            return (Criteria) this;
        }

        public Criteria andBasicOrgIdIsNull() {
            addCriterion("BASIC_ORG_ID is null");
            return (Criteria) this;
        }

        public Criteria andBasicOrgIdIsNotNull() {
            addCriterion("BASIC_ORG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBasicOrgIdEqualTo(String value) {
            addCriterion("BASIC_ORG_ID =", value, "basicOrgId");
            return (Criteria) this;
        }

        public Criteria andBasicOrgIdNotEqualTo(String value) {
            addCriterion("BASIC_ORG_ID <>", value, "basicOrgId");
            return (Criteria) this;
        }

        public Criteria andBasicOrgIdGreaterThan(String value) {
            addCriterion("BASIC_ORG_ID >", value, "basicOrgId");
            return (Criteria) this;
        }

        public Criteria andBasicOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("BASIC_ORG_ID >=", value, "basicOrgId");
            return (Criteria) this;
        }

        public Criteria andBasicOrgIdLessThan(String value) {
            addCriterion("BASIC_ORG_ID <", value, "basicOrgId");
            return (Criteria) this;
        }

        public Criteria andBasicOrgIdLessThanOrEqualTo(String value) {
            addCriterion("BASIC_ORG_ID <=", value, "basicOrgId");
            return (Criteria) this;
        }

        public Criteria andBasicOrgIdLike(String value) {
            addCriterion("BASIC_ORG_ID like", value, "basicOrgId");
            return (Criteria) this;
        }

        public Criteria andBasicOrgIdNotLike(String value) {
            addCriterion("BASIC_ORG_ID not like", value, "basicOrgId");
            return (Criteria) this;
        }

        public Criteria andBasicOrgIdIn(List<String> values) {
            addCriterion("BASIC_ORG_ID in", values, "basicOrgId");
            return (Criteria) this;
        }

        public Criteria andBasicOrgIdNotIn(List<String> values) {
            addCriterion("BASIC_ORG_ID not in", values, "basicOrgId");
            return (Criteria) this;
        }

        public Criteria andBasicOrgIdBetween(String value1, String value2) {
            addCriterion("BASIC_ORG_ID between", value1, value2, "basicOrgId");
            return (Criteria) this;
        }

        public Criteria andBasicOrgIdNotBetween(String value1, String value2) {
            addCriterion("BASIC_ORG_ID not between", value1, value2, "basicOrgId");
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

        public Criteria andLongitudeIsNull() {
            addCriterion("LONGITUDE is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("LONGITUDE is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(String value) {
            addCriterion("LONGITUDE =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(String value) {
            addCriterion("LONGITUDE <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(String value) {
            addCriterion("LONGITUDE >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("LONGITUDE >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(String value) {
            addCriterion("LONGITUDE <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(String value) {
            addCriterion("LONGITUDE <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLike(String value) {
            addCriterion("LONGITUDE like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotLike(String value) {
            addCriterion("LONGITUDE not like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<String> values) {
            addCriterion("LONGITUDE in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<String> values) {
            addCriterion("LONGITUDE not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(String value1, String value2) {
            addCriterion("LONGITUDE between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(String value1, String value2) {
            addCriterion("LONGITUDE not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("LATITUDE is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("LATITUDE is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(String value) {
            addCriterion("LATITUDE =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(String value) {
            addCriterion("LATITUDE <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(String value) {
            addCriterion("LATITUDE >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("LATITUDE >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(String value) {
            addCriterion("LATITUDE <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(String value) {
            addCriterion("LATITUDE <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLike(String value) {
            addCriterion("LATITUDE like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotLike(String value) {
            addCriterion("LATITUDE not like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<String> values) {
            addCriterion("LATITUDE in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<String> values) {
            addCriterion("LATITUDE not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(String value1, String value2) {
            addCriterion("LATITUDE between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(String value1, String value2) {
            addCriterion("LATITUDE not between", value1, value2, "latitude");
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