package com.ai.slp.common.api.area.param;

import com.ai.opt.base.vo.BaseInfo;

/**
 * 区域查询条件<br>
 * Date: 2016年5月30日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 *
 * @author gucl
 */
public class GnAreaCondition extends BaseInfo {
    private static final long serialVersionUID = 1L;

    /**
     * 区域编码
     */
    private String areaCode;

    /**
     * 区域级别
     */
    private AreaLevel areaLevel;
   /**
    * 区域名称
    */
    private String areaName;

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public AreaLevel getAreaLevel() {
        return areaLevel;
    }

    public void setAreaLevel(AreaLevel areaLevel) {
        this.areaLevel = areaLevel;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
    
}
