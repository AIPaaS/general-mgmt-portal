package com.ai.opt.uac.web.constants;

public final class Constants {
	private Constants(){}
	
	public static final String SYSTEM_ID = "opt-uac";
	
	public static final class ResultCode{
		private ResultCode(){}
    	
    	public static final String SUCCESS_CODE = "000000";
    	public static final String ERROR_CODE = "999999";
    	public static final String PARAM_NULL_ERROR = "10001";
        public static final String PARAM_VALUE_ERROR = "10002";
        public static final String PHONE_NOTONE_ERROR = "10003";
        public static final String EMAIL_NOTONE_ERROR = "10004";
	}
	
	public static final class UUID{
		private UUID(){}
		/*** 失效时间*/
		public static final int OVERTIME = 300;
		/*** 失效时间*/
		public static final String KEY_NAME = "k";
	}
	
	public static final class LoginConstant{
		private LoginConstant(){}
		/** 缓存命名空间*/
		public static final String CACHE_NAMESPACE = "com.ai.opt.uac.login.cache";
	}
	
	/**
	 * 配置中心中的key 具体url存放在配置中心
	 */
	public static final class URLConstant{
		private URLConstant(){}
		
		/** 登录成功后的默认首页 */
		public static final String DEFAULT_INDEX_URL_KEY = "/default_index_url";
		
		/**中信首页*/
		//public static final String CITIC_INDEX_URL_KEY = "/citic_index_url";
		/**中信云店*/
		//public static final String CITIC_YUN_MALL_INDEX_URL_KEY = "/citic_yun_mall_index_url";
		/**中信帮助*/
		//public static final String CITIC_HELP_INDEX_URL_KEY = "/citic_help_index_url";
	}
	
	public static final class RetakePassword{
		private RetakePassword(){}
		
		public static final String USER_SESSION_KEY = "retake_user_session_id";
		
		/**手机验证方式*/
		public static final String CHECK_TYPE_PHONE = "1";
		/**邮件验证方式*/
		public static final String CHECK_TYPE_EMAIL = "2";
		
		/**邮箱模板路径*/
		public static final String TEMPLATE_EMAIL_URL = "email/template/uac-retakepassword-mail.xml";
		
		/**邮件主题*/
		public static final String EMAIL_SUBJECT="找回密码";
		
		/** 缓存命名空间*/
		public static final String CACHE_NAMESPACE = "com.ai.opt.uac.retakepassword.cache";
		
		/** 邮箱验证码缓存key*/
		public static final String CACHE_KEY_VERIFY_EMAIL = "retake-password-verify-email";
		/** 手机验证码缓存key*/
		public static final String CACHE_KEY_VERIFY_PHONE = "retake-password-verify-phone";
		/** 图片验证码缓存key*/
		public static final String CACHE_KEY_VERIFY_PICTURE = "retake-password-verify-picture";
		/** 图片验证码缓存key(填写用户页)*/
		public static final String CACHE_KEY_VERIFY_PICTURE_USER = "retake-password-verify-picture-user";
		/** 找回密码发送邮箱次数key*/
        public static final String CACHE_KEY_SEND_EMAIL_NUM = "retake-password-send-email-num";
        /** 找回密码发送手机次数key*/
        public static final String CACHE_KEY_SEND_PHONE_NUM = "retake-password-send-phone-num";
        /** IP发送手机次数key*/
        public static final String CACHE_KEY_IP_SEND_PHONE_NUM = "retake-password-ip-send-phone-num";
        /** IP发送邮件次数key*/
        public static final String CACHE_KEY_IP_SEND_EMAIL_NUM = "retake-password-ip-send-email-num";
		
		public static final String FAIL_CODE = "0";
		
		public static final String SUCCESS_CODE = "1";
	}
    
    public static final class Register {
        private Register() {
        }

        /** 邮箱验证码缓存key */
        public static final String REGISTER_EMAIL_KEY = "register-bind-email";
        /** 注册时邮件发送次数key*/
        public static final String SEND_EMAIL_TIMES_KEY = "register-send-email-times";
        /** 邮件发送次数失败*/
        public static final String CACHE_EM_TIMES_ERROR_CODE = "9999";
        /** 短信验证码缓存key */
        public static final String REGISTER_PHONE_KEY = "register-verify-phone";
        /** 缓存命名空间 */
        public static final String CACHE_NAMESPACE = "com.ai.opt.uac.register.cache";
        /**IP发送短信次数缓存key*/
        public static final String CACHE_KEY_IP_SEND_PHONE_NUM = "register-ip-send-phone-maxnum";
        /**IP发送邮件次数缓存key*/
        public static final String CACHE_KEY_IP_SEND_EMAIL_NUM = "register-ip-send-email-maxnum";

        /** 邮箱模板路径 */
        public static final String TEMPLATE_EMAIL_URL = "email/template/uac-register-binemail.xml";

        /** 邮件称呼前缀 */
        public static final String REGISTER_EMAIL_NICK = "云计费";
        /** 图片验证码缓存key*/
        public static final String CACHE_KEY_VERIFY_PICTURE = "register-verify-picture";
        /** 注册成功ID */
        public static final String REGISTER_SUCCESS_ID = "000000";
        /** 图片验证码 错误ID*/
        public static final String REGISTER_PICTURE_ERROR = "000001";
        /** 图片验证码 失效ID*/
        public static final String REGISTER_PICTURE_OVERTIME_ERROR = "000002";
        /** 短信验证码错误ID */
        public static final String REGISTER_SSM_ERROR = "000003";
        /** 短信验证码失效ID */
        public static final String REGISTER_SSM_OVERTIME_ERROR = "000004";
        /** 发送短信手机号不一致错误 */
        public static final String REGISTER_SSM_DUMPHONE_ERROR = "000007";
        /** 发送邮箱不一致错误 */
        public static final String REGISTER_EMAIL_NOTSAME_ERROR = "000008";
        /** 邮箱验证码失效ID */
        public static final String REGISTER_EMAIL_OVERTIME_ERROR = "000005";
        /** 邮箱验证码错误ID */
        public static final String REGISTER_EMAIL_ERROR = "000006";
        /** 绑定邮箱成功ID */
        public static final String BAND_EMAIL_SUCCESS_ID = "000000";
        /** 手机已经注册ID */
        public static final String PHONE_NOTONE_ERROR = "10003";
        /** 邮箱已经注册ID */
        public static final String EMAIL_NOTONE_ERROR = "10004";
        /**uuid失效 */
        public static final String UUID_INVIAL_ERROR = "1100";
        /** 账号ID的key */
        public static final String CACHE_KEY_REGISTER_ACCOUNT_ID = "account-id";
        /** 账号ID的存储时间 */
        public static final int CACHE_REGISTER_ACCOUNT_ID_TIME = 300;
    }
    
    public static final class UpdatePassword{
		private UpdatePassword(){}
		
		/**手机验证方式*/
		public static final String CHECK_TYPE_PHONE = "1";
		/**邮件验证方式*/
		public static final String CHECK_TYPE_EMAIL = "2";
		
		/**邮箱模板路径*/
		public static final String TEMPLATE_EMAIL_URL = "email/template/uac-updatepassword-mail.xml";
		
		/**邮件主题*/
		public static final String EMAIL_SUBJECT="修改登录密码";
		
		/** 缓存命名空间*/
		public static final String CACHE_NAMESPACE = "com.ai.opt.uac.updatepassword.cache";
		
		/** 邮箱验证码缓存key*/
		public static final String CACHE_KEY_VERIFY_EMAIL = "update-password-verify-email";
		/** 手机验证码缓存key*/
		public static final String CACHE_KEY_VERIFY_PHONE = "update-password-verify-phone";
		/** 图片验证码缓存key*/
		public static final String CACHE_KEY_VERIFY_PICTURE = "update-password-verify-picture";
		/** 身份认证发送邮箱次数key*/
        public static final String CACHE_KEY_SEND_EMAIL_NUM = "update-password-send-email-num";
        /** 身份认证发送手机次数key*/
        public static final String CACHE_KEY_SEND_PHONE_NUM = "update-password-send-phone-num";
        /** IP发送手机次数key*/
        public static final String CACHE_KEY_IP_SEND_PHONE_NUM = "update-password-ip-send-phone-num";
        /** IP发送邮件次数key*/
        public static final String CACHE_KEY_IP_SEND_EMAIL_NUM = "update-password-ip-send-email-num";
	}
    
    public static final class UpdatePhone{
		private UpdatePhone(){}
		
		/**手机验证方式*/
		public static final String CHECK_TYPE_PHONE = "1";
		/**邮件验证方式*/
		public static final String CHECK_TYPE_EMAIL = "2";
		
		/**邮箱模板路径*/
		public static final String TEMPLATE_EMAIL_URL = "email/template/uac-updatephone-mail.xml";
		
		/**邮件主题*/
		public static final String EMAIL_SUBJECT="修改手机号码";
		
		/** 缓存命名空间*/
		public static final String CACHE_NAMESPACE = "com.ai.opt.uac.updatephone.cache";
		
		/** 邮箱验证码缓存key*/
		public static final String CACHE_KEY_VERIFY_EMAIL = "update-phone-verify-email";
		/** 手机验证码缓存key*/
		public static final String CACHE_KEY_VERIFY_PHONE = "update-phone-verify-phone";
		/** 设置新手机验证码缓存key*/
		public static final String CACHE_KEY_VERIFY_SETPHONE = "update-phone-verify-setphone";
		/** 图片验证码缓存key*/
		public static final String CACHE_KEY_VERIFY_PICTURE = "update-phone-verify-picture";
		/** 身份认证发送邮箱次数key*/
        public static final String CACHE_KEY_CONFIRM_SEND_EMAIL_NUM = "update-phone-confirm-send-email-num";
        /** 身份认证发送手机次数key*/
        public static final String CACHE_KEY_CONFIRM_SEND_PHONE_NUM = "update-phone-confirm-send-phone-num";
        /** 修改手机发送手机次数key*/
        public static final String CACHE_KEY_UPDATE_SEND_PHONE_NUM = "update-phone-update-send-phone-num";
        /** IP发送手机次数key*/
        public static final String CACHE_KEY_IP_SEND_PHONE_NUM = "update-phone-ip-send-phone-num";
        /** IP发送邮件次数key*/
        public static final String CACHE_KEY_IP_SEND_EMAIL_NUM = "update-phone-ip-send-email-num";
    }
    
    public static final class UpdateEmail{
		private UpdateEmail(){}
		
		/**手机验证方式*/
		public static final String CHECK_TYPE_PHONE = "1";
		/**邮件验证方式*/
		public static final String CHECK_TYPE_EMAIL = "2";
		
		/**邮箱模板路径*/
		public static final String TEMPLATE_EMAIL_URL = "email/template/uac-updateemail-mail.xml";
		
		/**邮箱模板路径*/
		public static final String TEMPLATE_SETEMAIL_URL = "email/template/uac-setemail-mail.xml";
		
		/**邮件主题*/
		public static final String EMAIL_SUBJECT="修改邮箱地址";
		
		/** 缓存命名空间*/
		public static final String CACHE_NAMESPACE = "com.ai.opt.uac.updateemail.cache";
		
		/** 邮箱验证码缓存key*/
		public static final String CACHE_KEY_VERIFY_EMAIL = "update-email-verify-email";
		/** 设置新邮箱验证码缓存key*/
		public static final String CACHE_KEY_VERIFY_SETEMAIL = "update-setemail-verify-email";
		/** 手机验证码缓存key*/
		public static final String CACHE_KEY_VERIFY_PHONE = "update-email-verify-phone";
		/** 图片验证码缓存key*/
		public static final String CACHE_KEY_VERIFY_PICTURE = "update-email-verify-picture";
		/** 身份认证发送邮箱次数key*/
        public static final String CACHE_KEY_CONFIRM_SEND_EMAIL_NUM = "update-email-confirm-send-email-num";
        /** 身份认证发送手机次数key*/
        public static final String CACHE_KEY_CONFIRM_SEND_PHONE_NUM = "update-email-confirm-send-phone-num";
        /** 修改邮箱发送手机次数key*/
        public static final String CACHE_KEY_UPDATE_SEND_EMAIL_NUM = "update-email-update-send-phone-num";
        /** IP发送手机次数key*/
        public static final String CACHE_KEY_IP_SEND_PHONE_NUM = "update-email-ip-send-phone-num";
        /** IP发送邮件次数key*/
        public static final String CACHE_KEY_IP_SEND_EMAIL_NUM = "update-email-ip-send-email-num";
    }
    
    public static final class BandEmail{
		private BandEmail(){}
		
		/**手机验证方式*/
		public static final String CHECK_TYPE_PHONE = "1";
		/**邮件验证方式*/
		public static final String CHECK_TYPE_EMAIL = "2";
		/**邮件主题*/
		public static final String EMAIL_SUBJECT="绑定邮箱地址";
		/**邮箱模板路径*/
		public static final String TEMPLATE_EMAIL_URL = "email/template/uac-bandemail-mail.xml";
		
		/**邮箱模板路径*/
		public static final String TEMPLATE_SETEMAIL_URL = "email/template/uac-setemail-mail.xml";
		
		/** 缓存命名空间*/
		public static final String CACHE_NAMESPACE = "com.ai.opt.uac.bandemail.cache";
		
		/** 邮箱验证码缓存key*/
		public static final String CACHE_KEY_VERIFY_EMAIL = "band-email-verify-email";
		/** 设置新邮箱验证码缓存key*/
		public static final String CACHE_KEY_VERIFY_SETEMAIL = "band-setemail-verify-email";
		/** 手机验证码缓存key*/
		public static final String CACHE_KEY_VERIFY_PHONE = "band-email-verify-phone";
		/** 图片验证码缓存key*/
		public static final String CACHE_KEY_VERIFY_PICTURE = "band-email-verify-picture";
		/** 身份认证发送邮箱次数key*/
        public static final String CACHE_KEY_CONFIRM_SEND_EMAIL_NUM = "band-email-confirm-send-email-num";
        /** 身份认证发送手机次数key*/
        public static final String CACHE_KEY_CONFIRM_SEND_PHONE_NUM = "band-email-confirm-send-phone-num";
        /** 修改邮箱发送手机次数key*/
        public static final String CACHE_KEY_UPDATE_SEND_EMAIL_NUM = "band-email-update-send-phone-num";
        /** IP发送手机次数key*/
        public static final String CACHE_KEY_IP_SEND_PHONE_NUM = "band-email-ip-send-phone-num";
        /** IP发送邮件次数key*/
        public static final String CACHE_KEY_IP_SEND_EMAIL_NUM = "band-email-ip-send-email-num";
	}
    
    public static final class SMSUtil{
        private SMSUtil(){}
        /** 注册时手机发送次数key*/
        public static final String CACHE_KEY_SMS_REGISTER = "register-sms";
        /** 注册时手机发送IP地址次数key*/
        //public static final String CACHE_KEY_SMS_IP_REGISTER = "register-ip";
        /** 短信发送次数失败*/
        public static final String CACHE_SMS_ERROR_CODE = "9999";
        ///** ip短信发送次数失败*/
        //public static final String CACHE_SMS_IP_ERROR_CODE = "1111";
        ///** 短信重复发送时间*/
        //public static final int SMS_VERIFY_TIMES = 60;
        /** 短信发送成功*/
        public static final String CACHE_SMS_SUCCESS_CODE = "0000";
        
    }
    
   
}
