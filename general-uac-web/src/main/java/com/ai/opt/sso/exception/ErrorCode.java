// Decompiled by Jad v1.5.7d. Copyright 2000 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/SiliconValley/Bridge/8617/jad.html
// Decompiler options: packimports(3)
// Source File Name:   LogType.java

package com.ai.opt.sso.exception;

public final class ErrorCode {

	private ErrorCode() {
	}

	public final static String UNKNOW_ERROR = "0000";// 未知错误
	public final static String NODATA_ERROR = "0001";// 没有数据
	public final static String DB_ERROR = "0002";// 数据库错误
	public final static String NO_CFG_FILE = "0003";// 缺少配置文件
	public final static String NO_CFG_DATA = "0004";// 配置文件中缺少数据
	public final static String IO_ERROR = "0004";// 配置文件中缺少数据
	public final static String BUSI_ERROR = "0008";

}
