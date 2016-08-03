package com.ai.platform.common.dao.mapper.bo;

import java.sql.Timestamp;

public class SysWaitjobs {
    private String id;

    private String systemId;

    private String title;

    private String userId;

    private String presentActiviti;

    private Timestamp arriveData;

    private String lastUser;

    private String status;

    private String tenantId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId == null ? null : systemId.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getPresentActiviti() {
        return presentActiviti;
    }

    public void setPresentActiviti(String presentActiviti) {
        this.presentActiviti = presentActiviti == null ? null : presentActiviti.trim();
    }

    public Timestamp getArriveData() {
        return arriveData;
    }

    public void setArriveData(Timestamp arriveData) {
        this.arriveData = arriveData;
    }

    public String getLastUser() {
        return lastUser;
    }

    public void setLastUser(String lastUser) {
        this.lastUser = lastUser == null ? null : lastUser.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }
}