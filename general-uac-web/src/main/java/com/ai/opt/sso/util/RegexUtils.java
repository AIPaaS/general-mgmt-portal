package com.ai.opt.sso.util;

import java.util.regex.Pattern;

public final class RegexUtils {
	private static final String phoneRegex = "^1\\d{10}$";
	private static final String emailRegex = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
	
	private RegexUtils(){}
	
	public static boolean checkIsPhone(String str){
		return Pattern.matches(phoneRegex, str);
	}
	
	public static boolean checkIsEmail(String str){
		return Pattern.matches(emailRegex, str);
	}
	
}
