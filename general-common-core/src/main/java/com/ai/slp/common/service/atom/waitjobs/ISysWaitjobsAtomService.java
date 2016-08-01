package com.ai.slp.common.service.atom.waitjobs;

import com.ai.slp.common.dao.mapper.bo.SysWaitjobs;

public interface ISysWaitjobsAtomService {
	
	public String insertWaitjobs(SysWaitjobs waitjobs);
	
	public int completeWaitjobs(String id);
}
