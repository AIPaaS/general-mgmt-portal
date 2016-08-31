/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ai.platform.modules.sys.entity;

import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import com.ai.platform.common.persistence.DataEntity;

/**
 * Common工程统一区域代码Entity
 * @author MengBo
 * @version 2016-08-17
 */
public class GnArea extends DataEntity<GnArea> {


	private static final long serialVersionUID = 1L;
	private String areaCode;		// 区域编码
	private String areaName;		// 区域名称
	private String provinceCode;		// 所属省
	private String cityCode;		// 所属市
	private String areaLevel;		// 行政级别
	private String parentAreaCode;		// 所属区域
	private Integer sortId;		// 排序
	private String state;		// state
	private String remark;		// 备注
	
	public GnArea() {
		super();
	}

	public GnArea(String id){
		super(id);
	}
	public GnArea(String id,String areaCode){
		this();
		this.areaCode = areaCode;
	}
	@Max(32)
	@NotNull
	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	
	@Length(min=1, max=16, message="区域名称长度必须介于 1 和 16之间")
	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
	@JsonBackReference
	@Length(min=1, max=32, message="所属省编码长度必须介于 1 和 32 之间")
	
	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	
	@JsonBackReference
	@Length(min=1, max=32, message="所属市编码长度必须介于 1 和 32 之间")
	
	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	
	@Length(min=1, max=2, message="行政级别长度必须介于 1 和 2 之间")
	public String getAreaLevel() {
		return areaLevel;
	}

	public void setAreaLevel(String areaLevel) {
		this.areaLevel = areaLevel;
	}
	
	@JsonBackReference
	@Length(min=1, max=32, message="所属区域编码长度必须介于 1 和 32 之间")
	@NotNull(message="所属区域不能为空")
	public String getParentAreaCode() {
		return parentAreaCode;
	}

	public void setParentAreaCode(String parentAreaCode) {
		this.parentAreaCode = parentAreaCode;
	}
	
	@Max(10)
	public Integer getSortId() {
		return sortId;
	}

	public void setSortId(Integer sortId) {
		this.sortId = sortId;
	}
	
	@Length(min=1, max=4, message="state长度必须介于 1 和 4 之间")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	@Length(min=0, max=1024, message="备注长度必须介于 0 和 1024 之间")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}