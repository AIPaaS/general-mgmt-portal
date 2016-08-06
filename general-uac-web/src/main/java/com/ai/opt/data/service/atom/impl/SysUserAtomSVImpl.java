package com.ai.opt.data.service.atom.impl;

import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.SystemException;
import com.ai.opt.data.dao.mapper.bo.SysUser;
import com.ai.opt.data.dao.mapper.factory.MapperFactory;
import com.ai.opt.data.dao.mapper.interfaces.SysUserMapper;
import com.ai.opt.data.service.atom.interfaces.ISysUserAtomSV;
@Component
public class SysUserAtomSVImpl implements ISysUserAtomSV {
	//@Autowired
	//private SysUserMapper sysUserMapper;

	@Override
	public SysUser queryByUserId(String userId) throws SystemException {
		SysUserMapper sysUserMapper = MapperFactory.getSysUserMapper();
		return sysUserMapper.selectByPrimaryKey(userId);
	}

}
