package com.ai.opt.data.service.atom.interfaces;

import com.ai.opt.base.exception.SystemException;
import com.ai.opt.data.dao.mapper.bo.SysUser;

public interface ILoginAtomSV {
    SysUser queryByUserName(SysUser user) throws SystemException;
}
