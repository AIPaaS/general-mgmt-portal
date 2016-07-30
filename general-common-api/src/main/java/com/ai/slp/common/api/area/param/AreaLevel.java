package com.ai.slp.common.api.area.param;

import java.io.Serializable;

/**
 * 区域级别枚举类<br>
 * Date: 2016年5月30日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 *
 * @author gucl
 */
public enum AreaLevel implements Serializable{
	 /**
     * 国家级
     */
    NATION_LEVEL("0"), 
	/**
     * 省级
     */
    PROVINCE_LEVEL("1"),
	/**
     * 市级
     */
    CITY_LEVEL("2"),
    /**
     * 区县级
     */
    COUNTY_LEVEL("3"),
    /**
     * 街道级
     */
    STREET_LEVEL("4"),
    /**
     * 小区级
     */
    AREA_LEVEL("5");

    private String levelValue;

    AreaLevel(String value) {
        this.levelValue = value;
    }

    public String getLevelValue() {
        return levelValue;
    }
}
