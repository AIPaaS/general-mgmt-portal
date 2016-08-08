package com.ai.opt.data.constants;

import com.ai.opt.data.util.Md5Util;

/**
 * 账户体系常量类 Date: 2016年3月16日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhanglh
 */
public final class AccountConstants {

    private AccountConstants() {

    }
    
    public final static class ResultCode{
    	private ResultCode(){}
    	
    	public static final String SUCCESS_CODE = "000000";
    	
    	public static final String FAIL_CODE = "000001";
    }
    
    public final static class SEQ {
        private SEQ() {
        }

        public static final String ACCOUT_ID_SEQ = "GN_ACCOUNT$ACCOUNT_ID$SEQ";
        
        public static final String NICK_NAME = "GN_TENANT$TENANT_ID$SEQ";
        
        public static final String PHONE_MSG_SEQ = "GSM$PHONE$MSGSEQ";

    }

    public final static class Account {
        private Account() {
        }

        /** 账号类型 */
        public static final String ACCOUNT_TYPE = "1";

        /** 账号级别 */
        public static final String ACCOUNT_LEVEL = "1";

        /** 账号状态 */
        public static final String ACCOUNT_STATE = "1";

        /*** 失效时间 */
        public static final String INACTIVE_DATE = "2099-12-31 23:59:59";

        /** 初始租户ID值 */
        public static final String INIT_TENANT_ID = "0";
        
        /** 默认密码*/
        public static final String DEFAULT_PASSWORD = Md5Util.stringMD5("123456");
        
    }
    
    public final static class Tenant {
    	private Tenant(){}
    	
    	/** * 状态：未签约*/
    	public static final String STATE_NOTSIGNED = "0";
    	/** * 状态：已签约*/
    	public static final String STATE_SIGNED = "1";
    	/** * 状态：到期*/
    	public static final String STATE_EXPIRE = "2";
    	/** * 状态：中断*/
    	public static final String STATE_INTERRUPT = "3";
    }

}
