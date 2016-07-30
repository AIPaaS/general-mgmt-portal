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
public class SubjectIdParam extends BaseInfo {

    /**
     * 科目ID
     */
    private long subjectId;

    public SubjectIdParam() {

    }

    public SubjectIdParam(String tenantId, long subjectId) {
        this.setTenantId(tenantId);
        this.subjectId = subjectId;
    }

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

}
