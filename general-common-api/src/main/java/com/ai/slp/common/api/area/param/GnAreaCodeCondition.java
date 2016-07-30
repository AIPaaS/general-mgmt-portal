package com.ai.slp.common.api.area.param;

import com.ai.opt.base.vo.BaseInfo;

/**
 * 区域查询条件<br>
 * Date: 2016年5月30 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 *
 * @author gucl
 */
public class GnAreaCodeCondition extends BaseInfo {
    private static final long serialVersionUID = 1L;

    /**
     * 区域编码
     */
    private String areaCode;

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

}
