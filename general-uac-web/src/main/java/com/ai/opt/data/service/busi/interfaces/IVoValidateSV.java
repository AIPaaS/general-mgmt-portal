package com.ai.opt.data.service.busi.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.data.api.user.param.UserQueryRequest;

public interface IVoValidateSV {

    /**
     * 登录参数检查
     */
    void validateLogin(String username) throws BusinessException;


    /**
     * 账户详情查询参数检查
     */
    void validateQueryAccountBaseInfo(UserQueryRequest accountQueryRequest)
            throws BusinessException;

}
