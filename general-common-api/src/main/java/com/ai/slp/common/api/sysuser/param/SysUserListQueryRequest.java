package com.ai.slp.common.api.sysuser.param;

import com.ai.opt.base.vo.BaseInfo;

public class SysUserListQueryRequest extends BaseInfo{
	private static final long serialVersionUID = 1L;
	/**
	 * 机构ID，必填
	 */
	private String officeId;

	public String getOfficeId() {
		return officeId;
	}

	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}
	

}
