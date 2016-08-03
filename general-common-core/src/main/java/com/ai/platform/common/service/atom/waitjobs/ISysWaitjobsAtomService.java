package com.ai.platform.common.service.atom.waitjobs;

import com.ai.platform.common.dao.mapper.bo.SysWaitjobs;

public interface ISysWaitjobsAtomService {
	
	public String insertWaitjobs(SysWaitjobs waitjobs);
	
	public int completeWaitjobs(String id);
}
