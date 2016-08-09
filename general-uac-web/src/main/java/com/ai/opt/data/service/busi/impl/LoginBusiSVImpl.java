package com.ai.opt.data.service.busi.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.data.dao.mapper.bo.SysUser;
import com.ai.opt.data.service.atom.interfaces.ILoginAtomSV;
import com.ai.opt.data.service.busi.interfaces.ILoginBusiSV;

@Service
@Transactional
public class LoginBusiSVImpl implements ILoginBusiSV {
    @Autowired
    ILoginAtomSV iLoginAtomSV;

    @Override
    public SysUser queryByUserName(SysUser user) throws BusinessException {

        return iLoginAtomSV.queryByUserName(user);

    }

}
