/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ai.platform.modules.sys.entity;

import java.util.Date;

import com.ai.platform.common.persistence.DataEntity;

/**
 * 角色Entity
 * @author ThinkGem
 * @version 2013-12-05
 */
public class Waitjobs extends DataEntity<Waitjobs> {
	
	private static final long serialVersionUID = 1L;

	private String systemId;

    private String title;

    private String url;

    private String userId;

    private String presentActiviti;

    private String lastUser;
    
    private Date arriveData;
    
    private String status;
    
    private User user;
    
    public Waitjobs() {
		super();
	}
	
	public Waitjobs(String id){
		super(id);
	}

    public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPresentActiviti() {
		return presentActiviti;
	}

	public void setPresentActiviti(String presentActiviti) {
		this.presentActiviti = presentActiviti;
	}

	public String getLastUser() {
		return lastUser;
	}

	public void setLastUser(String lastUser) {
		this.lastUser = lastUser;
	}

	public Date getArriveData() {
		return arriveData;
	}

	public void setArriveData(Date arriveData) {
		this.arriveData = arriveData;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
