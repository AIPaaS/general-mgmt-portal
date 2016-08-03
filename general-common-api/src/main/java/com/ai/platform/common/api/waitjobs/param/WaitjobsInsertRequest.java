package com.ai.platform.common.api.waitjobs.param;

import com.ai.opt.base.vo.BaseInfo;

public class WaitjobsInsertRequest extends BaseInfo{

	private static final long serialVersionUID = 1L;
	
	private WaitjobsVO waijobsVo;

	public WaitjobsVO getWaijobsVo() {
		return waijobsVo;
	}

	public void setWaijobsVo(WaitjobsVO waijobsVo) {
		this.waijobsVo = waijobsVo;
	}

}
