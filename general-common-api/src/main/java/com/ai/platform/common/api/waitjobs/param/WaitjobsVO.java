package com.ai.platform.common.api.waitjobs.param;

import java.io.Serializable;

public class WaitjobsVO implements Serializable{
	private static final long serialVersionUID = 1L;

    private String systemId;

    private String title;

    private String userId;

    private String presentActiviti;

    private String lastUser;
    
    private String tenantId;

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

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
}
