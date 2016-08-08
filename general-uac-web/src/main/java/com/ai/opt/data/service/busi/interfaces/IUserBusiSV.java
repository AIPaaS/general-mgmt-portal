package com.ai.opt.data.service.busi.interfaces;

import com.ai.opt.base.exception.SystemException;
import com.ai.opt.data.dao.mapper.bo.SysUser;

public interface IUserBusiSV {
	
	SysUser queryByUserId(String userId) throws SystemException;
	
}
