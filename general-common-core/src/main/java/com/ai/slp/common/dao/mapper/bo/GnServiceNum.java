package com.ai.slp.common.dao.mapper.bo;

public class GnServiceNum {
    private String orderNo;

    private String provinceCode;

    private String provinceName;

    private String cityCode;

    private String cityName;

    private String basicOrgCode;

    private String basicOrgName;

    private String serviceHeadCode;

    private String serviceNumCode;

    private String busiCode;

    private String remark;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName == null ? null : provinceName.trim();
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public String getBasicOrgCode() {
        return basicOrgCode;
    }

    public void setBasicOrgCode(String basicOrgCode) {
        this.basicOrgCode = basicOrgCode == null ? null : basicOrgCode.trim();
    }

    public String getBasicOrgName() {
        return basicOrgName;
    }

    public void setBasicOrgName(String basicOrgName) {
        this.basicOrgName = basicOrgName == null ? null : basicOrgName.trim();
    }

    public String getServiceHeadCode() {
        return serviceHeadCode;
    }

    public void setServiceHeadCode(String serviceHeadCode) {
        this.serviceHeadCode = serviceHeadCode == null ? null : serviceHeadCode.trim();
    }

    public String getServiceNumCode() {
        return serviceNumCode;
    }

    public void setServiceNumCode(String serviceNumCode) {
        this.serviceNumCode = serviceNumCode == null ? null : serviceNumCode.trim();
    }

    public String getBusiCode() {
        return busiCode;
    }

    public void setBusiCode(String busiCode) {
        this.busiCode = busiCode == null ? null : busiCode.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}