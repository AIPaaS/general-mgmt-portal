package com.ai.opt.uac.web.model.register;

public class UpdateEmailReq {
    private String accountId;

    private String email;

    private Long updateAccountId;

    private String identifyCode;

    private String accountIdKey;
    

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getUpdateAccountId() {
        return updateAccountId;
    }

    public void setUpdateAccountId(Long updateAccountId) {
        this.updateAccountId = updateAccountId;
    }

    public String getIdentifyCode() {
        return identifyCode;
    }

    public void setIdentifyCode(String identifyCode) {
        this.identifyCode = identifyCode;
    }

    public String getAccountIdKey() {
        return accountIdKey;
    }

    public void setAccountIdKey(String accountIdKey) {
        this.accountIdKey = accountIdKey;
    }

   

}
