package com.ai.slp.common.service.atom.sysuser.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.common.dao.mapper.bo.SysUser;
import com.ai.slp.common.dao.mapper.bo.SysUserCriteria;
import com.ai.slp.common.dao.mapper.factory.MapperFactory;
import com.ai.slp.common.dao.mapper.interfaces.SysUserMapper;
import com.ai.slp.common.service.atom.sysuser.ISysUserAtomSV;

@Component
public class SysUserAtomSVImpl implements ISysUserAtomSV {

	@Override
	public SysUser queryUser(SysUser user) {
		SysUserCriteria example = new SysUserCriteria();
		SysUserCriteria.Criteria criteria = example.createCriteria();
		if (!StringUtil.isBlank(user.getTenantId())) {
			criteria.andTenantIdEqualTo(user.getTenantId());
		}
		if (!StringUtil.isBlank(user.getEmail())) {
			criteria.andEmailEqualTo(user.getEmail());
		}
		if (!StringUtil.isBlank(user.getPhone())) {
			criteria.andPhoneEqualTo(user.getPhone());
		}
		if (!StringUtil.isBlank(user.getNo())) {
			criteria.andNoEqualTo(user.getNo());
		}
		if (!StringUtil.isBlank(user.getLoginName())) {
			criteria.andNoEqualTo(user.getLoginName());
		}
		SysUserMapper mapper = MapperFactory.getSysUserMapper();
		List<SysUser> userList = mapper.selectByExample(example);
		if (!CollectionUtil.isEmpty(userList)) {
			return userList.get(0);
		}
		return null;
	}

	@Override
	public String queryUserTheme(String id) {
		  SysUser user = MapperFactory.getSysUserMapper().selectByPrimaryKey(id);
		  if(user!=null){
			  return user.getTheme();
		  }else{
			  return null;
		  }
	}

}
