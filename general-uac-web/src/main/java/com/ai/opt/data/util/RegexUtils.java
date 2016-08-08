
package com.ai.opt.data.util;

import java.util.regex.Pattern;

public final class RegexUtils {
	private static final String commonCharRegex = "[a-z]*[A-Z]*\\d*-*_*\\s*[\u4e00-\u9fa5]*\\(*\\)*";
	private static final String phoneRegex = "^1\\d{10}$";
    private static final String phoneNumberRegex = "^[0-9]*$";
    private static final String emailRegex = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.(\\w+([-.]\\w+)*){2,}$";
    private static final String passwordRegex = "^[A-Za-z0-9]+$";
    private static final String passwordLengthRegex = "^[A-Za-z0-9]{32}$";
    private static final String phoneLengthRegex = "^[\\d]{11}$";
	private RegexUtils(){}
	
	
	/**
	 * 是否含有特殊字符
	 * @param str
	 * @return
	 */
	public static boolean checkHasSpecialChar(String str){
		return str.replaceAll(commonCharRegex, "").length() != 0;
    }
    
    /**
     * 校验手机长度
     * 
     * @param str
     * @return
     * @author zhanglh
     * @ApiCode
     */

    public static boolean checkPhoneLength(String str) {
        return Pattern.matches(phoneLengthRegex, str);
    }

    /**
     * 校验手机号位数字
     * 
     * @param str
     * @return
     * @author zhanglh
     * @ApiCode
     */
    public static boolean checkNumberPhone(String str) {
        return Pattern.matches(phoneNumberRegex, str);
    }

    /**
     * 校验手机格式
     * 
     * @param str
     * @return
     * @author zhanglh
     * @ApiCode
     */
    public static boolean checkIsPhone(String str) {
        return Pattern.matches(phoneRegex, str);
    }

    /**
     * 校验Email
     * 
     * @param str
     * @return
     * @author zhanglh
     * @ApiCode
     */
    public static boolean checkIsEmail(String str) {
        return Pattern.matches(emailRegex, str);
    }

    /**
     * 校验密码由字母或者数字组成
     * 
     * @param str
     * @return
     * @author zhanglh
     * @ApiCode
     */
    public static boolean checkPassword(String str) {
        return Pattern.matches(passwordRegex, str);
    }

	/**
	 * 校验密码长度
	 *
	 * @param str
	 * @return
	 * @author zhanglh
	 * @ApiCode
	 */
	public static boolean checkPasswordLength(String str) {
		return Pattern.matches(passwordLengthRegex, str);
	}

}
