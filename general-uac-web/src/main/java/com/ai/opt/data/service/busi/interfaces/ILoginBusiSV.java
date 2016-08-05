package com.ai.opt.data.service.busi.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.data.dao.mapper.bo.SysUser;

public interface ILoginBusiSV {
    SysUser queryByUserName(SysUser user) throws BusinessException;
    
}
