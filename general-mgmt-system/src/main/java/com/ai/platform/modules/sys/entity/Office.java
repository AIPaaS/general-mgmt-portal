/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ai.platform.modules.sys.entity;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.ai.platform.common.persistence.TreeEntity;

/**
 * 机构Entity
 * 
 * @author ThinkGem
 * @version 2013-05-15
 */
public class Office extends TreeEntity<Office> {

	private static final long serialVersionUID = 1L;
	private GnArea gnArea; // 归属区域
	private String oldName; // 原名称
	private String oldCode; // 原编码
	private String code; // 机构编码
	private String name; // 机构名称
	private String type; // 机构类型（1：公司；2：部门；3：小组）
	private String grade; // 机构等级（1：一级；2：二级；3：三级；4：四级）
	private String address; // 联系地址
	private String zipCode; // 邮政编码
	private String master; // 负责人
	private String phone; // 电话
	private String fax; // 传真
	private String email; // 邮箱
	private String useable;// 是否可用
	private User primaryPerson;// 主负责人
	private User deputyPerson;// 副负责人
	private List<String> childDeptList;// 快速添加子部门

	public Office() {
		super();
		// this.sort = 30;
		this.type = "2";
	}
	/*
	 * public String getParentId() { return parentId; }
	 * 
	 * public void setParentId(String parentId) { this.parentId = parentId; }
	 */

	public String getOldName() {
		return oldName;
	}

	public void setOldName(String oldName) {
		this.oldName = oldName;
	}

	public String getOldCode() {
		return oldCode;
	}

	public void setOldCode(String oldCode) {
		this.oldCode = oldCode;
	}

	public Office(String id) {
		super(id);
	}

	public List<String> getChildDeptList() {
		return childDeptList;
	}

	public void setChildDeptList(List<String> childDeptList) {
		this.childDeptList = childDeptList;
	}

	public String getUseable() {
		return useable;
	}

	public void setUseable(String useable) {
		this.useable = useable;
	}

	public User getPrimaryPerson() {
		return primaryPerson;
	}

	public void setPrimaryPerson(User primaryPerson) {
		this.primaryPerson = primaryPerson;
	}

	public User getDeputyPerson() {
		return deputyPerson;
	}

	public void setDeputyPerson(User deputyPerson) {
		this.deputyPerson = deputyPerson;
	}

	// @JsonBackReference
	// @NotNull
	public Office getParent() {
		return parent;
	}

	public void setParent(Office parent) {
		this.parent = parent;
	}
	//
	// @Length(min=1, max=2000)
	// public String getParentIds() {
	// return parentIds;
	// }
	//
	// public void setParentIds(String parentIds) {
	// this.parentIds = parentIds;
	// }

	
	@Pattern(regexp = "^[\u0391-\uFFE5\\w]+$", message = "部门名称不合法")
	@Length(min = 1, max = 15, message = "部门名称不能为空")
	public String getName() {
		return name;
	}

	//
	public void setName(String name) {
		this.name = name;
	}
	//
	// public Integer getSort() {
	// return sort;
	// }
	//
	// public void setSort(Integer sort) {
	// this.sort = sort;
	// }
	@NotNull(message="归属区域不能为空")
	public GnArea getGnArea() {
		return gnArea;
	}

	public void setGnArea(GnArea gnArea) {
		this.gnArea = gnArea;
	}

	@Length(min = 0, max = 1)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Length(min = 0, max = 1)
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Length(min = 0, max = 255)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Length(min = 0, max = 50)
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Length(min = 0, max = 50,message="负责人长度在0到50之间")
	public String getMaster() {
		return master;
	}

	public void setMaster(String master) {
		this.master = master;
	}

	@Length(min = 0, max = 200)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Length(min = 0, max = 200)
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Length(min = 0, max = 200)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Pattern(regexp = "^[a-zA-Z0-9][a-zA-Z0-9_]{2,19}$", message = "部门编码格式不正确")
	@Length(min = 1, max = 20)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	// public String getParentId() {
	// return parent != null && parent.getId() != null ? parent.getId() : "0";
	// }

	@Override
	public String toString() {
		return name;
	}
}