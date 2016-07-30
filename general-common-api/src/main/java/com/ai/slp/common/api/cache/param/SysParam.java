package com.ai.slp.common.api.cache.param;

import java.io.Serializable;

/**
 * 字典数据对象.<br>
 * Date: 2015年7月16日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author gucl
 */
public class SysParam implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 参数类型-字典类型编码
     */
    private String typeCode;

    /**
     * 参数编码-字典参数编码
     */
    private String paramCode;

    /**
     * 参数取值
     */
    private String columnValue;

    /**
     * 参数取值描述
     */
    private String columnDesc;

    /**
     * 排序号
     */
    private int dispord;
    /**
     * 流水主键
     */
    private String guidkey;
    /**
     * 参详说明
     */
    private String descb;
    /**
     * 状态
     */
    private String state;
    /**
     * 参数子类
     */
    private String subParamCode;
    

    public SysParam() {
		super();
	}

	public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getParamCode() {
        return paramCode;
    }

    public void setParamCode(String paramCode) {
        this.paramCode = paramCode;
    }

    public String getColumnValue() {
        return columnValue;
    }

    public void setColumnValue(String columnValue) {
        this.columnValue = columnValue;
    }

    public String getColumnDesc() {
        return columnDesc;
    }

    public void setColumnDesc(String columnDesc) {
        this.columnDesc = columnDesc;
    }

    public int getDispord() {
        return dispord;
    }

    public void setDispord(int dispord) {
        this.dispord = dispord;
    }

    public String getGuidkey() {
        return guidkey;
    }

    public void setGuidkey(String guidkey) {
        this.guidkey = guidkey;
    }

    public String getDescb() {
        return descb;
    }

    public void setDescb(String descb) {
        this.descb = descb;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSubParamCode() {
        return subParamCode;
    }

    public void setSubParamCode(String subParamCode) {
        this.subParamCode = subParamCode;
    }

}
