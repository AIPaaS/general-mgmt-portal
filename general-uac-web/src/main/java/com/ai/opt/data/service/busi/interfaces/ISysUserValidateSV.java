package com.ai.opt.data.service.busi.interfaces;

import com.ai.opt.base.exception.BusinessException;

public interface ISysUserValidateSV {

	void checkUserId(String accountId) throws BusinessException;

	void checkUserName(String userName) throws BusinessException;

}
