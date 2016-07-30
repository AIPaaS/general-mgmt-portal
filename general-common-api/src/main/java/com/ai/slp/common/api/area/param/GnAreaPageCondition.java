package com.ai.slp.common.api.area.param;

import com.ai.opt.base.vo.BaseInfo;

/**
 * 小区（街道下的小区）分页查询条件<br>
 * Date: 2016年5月30日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 *
 * @author gucl
 */
public class GnAreaPageCondition extends BaseInfo {
    private static final long serialVersionUID = 1L;

    /**
     * 归属省份
     */
    private String provinceCode;
    /**
     * 归属地市
     */
    private String cityCode;
    /**
     * 归属区县
     */
    private String countyCode;
    /**
     * 归属街道
     */
    private String streetCode;
    /**
     * 父级区域
     */
    private String parentAreaCode;
    
    /**
     * 小区编码
     */
    private String areaCode;
    /**小区名称     
     */
    private String areaName;

    
    /**
     * 当前第几页,必填
     */
    private Integer pageNo;

    /**
     * 每页数据条数,必填
     */
    private Integer pageSize;

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCountyCode() {
		return countyCode;
	}

	public void setCountyCode(String countyCode) {
		this.countyCode = countyCode;
	}

	public String getStreetCode() {
		return streetCode;
	}

	public void setStreetCode(String streetCode) {
		this.streetCode = streetCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getParentAreaCode() {
		return parentAreaCode;
	}

	public void setParentAreaCode(String parentAreaCode) {
		this.parentAreaCode = parentAreaCode;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
	

}
