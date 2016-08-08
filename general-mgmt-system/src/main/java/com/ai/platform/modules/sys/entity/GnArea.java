/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ai.platform.modules.sys.entity;

import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.validation.constraints.NotNull;

import com.ai.platform.common.persistence.TreeEntity;

/**
 * Common工程统一区域代码Entity
 * @author MengBo
 * @version 2016-08-06
 */
public class GnArea extends TreeEntity<GnArea> {
	
	private static final long serialVersionUID = 1L;
	private String areaCode;		// 区域编码
	private String areaName;		// 区域名称
	private GnArea provinceCode;		// 所属省
	private GnArea cityCode;		// 所属市
	private String areaLevel;		// 行政级别
	
	private String sortId;		// 排序
	private String state;		// state
	private String remark;		// 备注
	
	public GnArea() {
		super();
	}

	public GnArea(String id){
		super(id);
	}

	@Length(min=1, max=32, message="区域编码长度必须介于 1 和 32 之间")
	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	
	@Length(min=1, max=500, message="区域名称长度必须介于 1 和 500 之间")
	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
	@JsonBackReference
	@NotNull(message="所属省不能为空")
	public GnArea getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(GnArea provinceCode) {
		this.provinceCode = provinceCode;
	}
	
	@JsonBackReference
	@NotNull(message="所属市不能为空")
	public GnArea getCityCode() {
		return cityCode;
	}

	public void setCityCode(GnArea cityCode) {
		this.cityCode = cityCode;
	}
	
	@Length(min=1, max=2, message="行政级别长度必须介于 1 和 2 之间")
	public String getAreaLevel() {
		return areaLevel;
	}

	public void setAreaLevel(String areaLevel) {
		this.areaLevel = areaLevel;
	}
	
	@Length(min=0, max=32, message="所属区域长度必须介于 0 和 32 之间")
	public GnArea getParent() {
		return parent;
	}

	public void setParent(GnArea parent) {
		this.parent = parent;
	}
	
	@Length(min=1, max=10, message="排序长度必须介于 1 和 10 之间")
	public String getSortId() {
		return sortId;
	}

	public void setSortId(String sortId) {
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