package com.ai.slp.common.api.servicenum.param;

import java.io.Serializable;

/**
 * ServiceNum
 *
 * Date: 2016年6月1日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gucl
 */
public class ServiceNum implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/**
	 * 序号
	 */
    private String orderNo;

    /**
     * 省份编码
     */
    private String provinceCode;

    /**
     * 省份名称
     */
    private String provinceName;

    /**
     * 城市编码
     */
    private String cityCode;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 基础运营商编码
     */
    private String basicOrgCode;

    /**
     * 基础运营商名称
     */
    private String basicOrgName;

    /**
     * 号码头
     */
    private String serviceHeadCode;

    /**
     * 号码段
     */
    private String serviceNumCode;

    /**
     * 业务类型
     */
    private String busiCode;

    /**
     * 备注
     */
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