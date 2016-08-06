package com.ai.opt.data.constants;

public final class AccountExceptCode {
    private AccountExceptCode() {

    }

    public final static class ErrorCode {
        private ErrorCode() {
        }

        public static final String PARAM_NULL_ERROR = "10001";
        public static final String PARAM_VALUE_ERROR = "10002";
        public static final String PHONE_NOTONE_ERROR = "10003";
        public static final String EMAIL_NOTONE_ERROR = "10004";
    }
    
}
