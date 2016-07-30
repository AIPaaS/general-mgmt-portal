package com.ai.slp.common.api.subject.param;

import com.ai.opt.base.vo.BaseInfo;

/**
 * 科目查询请求参数<br>
 *
 * Date: 2015年9月9日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public class SubjectTypeParam extends BaseInfo {

    /**
     * 科目类型<br>
     * 1：资源科目<br>
     * 2：消费科目（原计费的科目）<br>
     * 21:消费科目中非通信类科目<br>
     * 4：虚科目（暂无）<br>
     * 9：资金科目（原余额中心的的科目）<br>
     * 10:订单科目 （原营业的科目）<br>
     * 11：商品中心科目
     */
    private String subjectType;

    public SubjectTypeParam() {

    }

    public SubjectTypeParam(String tenantId, String subjectType) {
        this.setTenantId(tenantId);
        this.subjectType = subjectType;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

}
