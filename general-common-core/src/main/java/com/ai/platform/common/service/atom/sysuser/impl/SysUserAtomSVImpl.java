package com.ai.platform.common.service.atom.sysuser.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.platform.common.constants.VOConstants.DeleteFlagConstant;
import com.ai.platform.common.dao.mapper.bo.SysUser;
import com.ai.platform.common.dao.mapper.bo.SysUserCriteria;
import com.ai.platform.common.dao.mapper.factory.MapperFactory;
import com.ai.platform.common.dao.mapper.interfaces.SysUserMapper;
import com.ai.platform.common.service.atom.sysuser.ISysUserAtomSV;

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
		criteria.andDelFlagEqualTo(DeleteFlagConstant.NO);
		 Date crruntDate = DateUtil.getDate();
	     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	     String dateStr = sdf.format(crruntDate);
	     Timestamp crurentTs = Timestamp.valueOf(dateStr);  
	     //添加有效时间限制
	      criteria.andEffectiveDateLessThanOrEqualTo(crurentTs);
	      criteria.andExpiryDateGreaterThanOrEqualTo(crurentTs);

		SysUserMapper mapper = MapperFactory.getSysUserMapper();
		List<SysUser> userList = mapper.selectByExample(example);
		if (!CollectionUtil.isEmpty(userList)) {
			return userList.get(0);
		}
		return null;
	}

	@Override
	public String queryUserTheme(String id,String tenantId) {
		SysUserCriteria example = new SysUserCriteria();
		SysUserCriteria.Criteria criteria = example.createCriteria();
		if (!StringUtil.isBlank(tenantId)) {
			criteria.andTenantIdEqualTo(tenantId);
		}
		if (!StringUtil.isBlank(id)) {
			criteria.andIdEqualTo(id);
		}
		criteria.andDelFlagEqualTo(DeleteFlagConstant.NO);
		Date crruntDate = DateUtil.getDate();
	     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	     String dateStr = sdf.format(crruntDate);
	     Timestamp crurentTs = Timestamp.valueOf(dateStr);  
	     //添加有效时间限制
	      criteria.andEffectiveDateLessThanOrEqualTo(crurentTs);
	      criteria.andExpiryDateGreaterThanOrEqualTo(crurentTs);
		SysUserMapper mapper = MapperFactory.getSysUserMapper();
		List<SysUser> userList = mapper.selectByExample(example);
		if (!CollectionUtil.isEmpty(userList)) {
			SysUser user =userList.get(0);
			return user.getTheme();
		}else{
			  return null;
		  }
	}

	@Override
	public List<SysUser> selectSysUserByOfficeId(String tenantId, String officeId) {
		SysUserCriteria example = new SysUserCriteria();
		SysUserCriteria.Criteria criteria = example.createCriteria();
		if (!StringUtil.isBlank(tenantId)) {
			criteria.andTenantIdEqualTo(tenantId);
		}
		if (!StringUtil.isBlank(officeId)) {
			criteria.andOfficeIdEqualTo(officeId);
		}
		criteria.andDelFlagEqualTo(DeleteFlagConstant.NO);
		 Date crruntDate = DateUtil.getDate();
	     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	     String dateStr = sdf.format(crruntDate);
	     Timestamp crurentTs = Timestamp.valueOf(dateStr);  
	     //添加有效时间限制
	      criteria.andEffectiveDateLessThanOrEqualTo(crurentTs);
	      criteria.andExpiryDateGreaterThanOrEqualTo(crurentTs);

		SysUserMapper mapper = MapperFactory.getSysUserMapper();
		List<SysUser> userList = mapper.selectByExample(example);
		if (!CollectionUtil.isEmpty(userList)) {
			return userList;
		}else{
			  return null;
		  }
	}

}
