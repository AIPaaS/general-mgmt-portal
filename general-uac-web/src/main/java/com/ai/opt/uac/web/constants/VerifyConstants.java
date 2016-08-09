package com.ai.opt.uac.web.constants;

public final class VerifyConstants {
	private VerifyConstants() {
	}

	public final class PhoneVerifyConstants {
		private PhoneVerifyConstants() {
		}

		/** 手机验证码长度 */
		public static final int VERIFY_SIZE = 6;

		// /**手机验证码超时时间*/
		// public static final int VERIFY_OVERTIME = 300;
		// /** 可重复发送时间*/
		// public static final int SEND_VERIFY_MAX_TIME = 60;
		/** 手机验证码超时时间 配置key */
		public static final String VERIFY_OVERTIME_KEY = "/phone_verifycode_overtime";
		/** 可重复发送时间 配置key */
		public static final String SEND_VERIFY_MAX_TIME_KEY = "/phone_verifycode_send_maxtime";
		/** ip可重复发送次数 配置key */
        public static final String SEND_VERIFY_IP_MAX_NO_KEY = "/phone_send_ip_maxno";
        /** ip可重复发送次数保存时间  配置key */
        public static final String IP_SEND_OVERTIME_KEY = "/phone_ip_send_overtime";

		/** 短信注册模板ID */
		public static final String TEMPLATE_REGISTER_ID = "1";
		/** 短信修改密码模板ID */
		public static final String TEMPLATE_UPDATE_PASSWORD_ID = "2";
		/** 短信修改手机模板ID */
		public static final String TEMPLATE_UPDATE_PHONE_ID = "3";
		/** 短信修改邮箱模板ID */
		public static final String TEMPLATE_UPDATE_EMAIL_ID = "4";
		/** 短信修改邮箱模板ID */
		public static final String TEMPLATE_SET_PASSWORD_ID = "5";
		/** 短信找回密码模板ID */
		public static final String TEMPLATE_RETAKE_PASSWORD_ID = "6";
		/** 短信设置新手机号模板ID */
		public static final String TEMPLATE_RETAKE_SETPHONE_ID = "7";

		public static final String SERVICE_TYPE = "1";

	}

	public final class EmailVerifyConstants {
		private EmailVerifyConstants() {
		}

		/** 邮箱主题 */
		public static final String EMAIL_SUBJECT = "亚信云计费";

		/** 邮箱验证码长度 */
		public static final int VERIFY_SIZE = 6;

		/** 邮箱模板路径 */
		public static final String TEMPLATE_URL = "email/template/uac-retakepassword-mail.xml";

		// /**邮件验证码超时时间*/
		// public static final int VERIFY_OVERTIME = 1800;
		// /** 邮箱可重复发送时间*/
		// public static final int SEND_VERIFY_MAX_TIME = 60;
		/** 邮件验证码超时时间 配置key */
		public static final String VERIFY_OVERTIME_KEY = "/email_verifycode_overtime";

		/** 邮箱可重复发送时间 配置key */
		public static final String SEND_VERIFY_MAX_TIME_KEY = "/email_verifycode_send_maxtime";
		
		/** ip可重复发送次数 配置key */
        public static final String SEND_VERIFY_IP_MAX_NO_KEY = "/email_send_ip_maxno";
        /** ip可重复发送次数保存时间  配置key */
        public static final String IP_SEND_OVERTIME_KEY = "/email_ip_send_overtime";
	}

	public final class PictureVerifyConstants {
		private PictureVerifyConstants() {
		}

		/** 图片验证码长度 */
		public static final int VERIFY_SIZE = 4;
		
		// /**图片验证码超时时间 */
		// public static final int VERIFY_OVERTIME = 600;
		/** 图片验证码超时时间 配置key */
		public static final String VERIFY_OVERTIME_KEY = "/picture_verifycode_overtime";
	}

	public final class ResultCodeConstants {
		private ResultCodeConstants() {
		}

		/*** 成功ID */
		public static final String SUCCESS_CODE = "000000";
		/*** 失败ID */
		public static final String ERROR_CODE = "111111";

		/*** 用户信息没有(失效) */
		public static final String USER_INFO_NULL = "100000";

		/** 图片验证码 错误ID */
		public static final String REGISTER_PICTURE_ERROR = "100001";
		/** 验证码错误ID */
		public static final String REGISTER_VERIFY_ERROR = "100002";
		/** 密码错误 */
		public static final String PASSWORD_ERROR = "100003";
		/** 用户名错误 */
		public static final String USERNAME_ERROR = "100004";
		/** 手机号错误 */
		public static final String PHONE_ERROR = "100005";
		/** 邮箱号错误 */
		public static final String EMAIL_ERROR = "100006";
	}
}
