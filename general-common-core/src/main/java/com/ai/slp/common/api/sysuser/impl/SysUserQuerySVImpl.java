package com.ai.slp.common.api.sysuser.impl;

import org.omg.CORBA.SystemException;

import com.ai.slp.common.api.sysuser.interfaces.BusinessException;
import com.ai.slp.common.service.business.subject.IGnSubjectBusiSV;
import com.ai.slp.common.service.business.sysuser.ISysUserBusiSV;
import com.ai.slp.common.util.SystemValidateUtil;

@Service
@Component
public class SysUserQuerySVImpl implements ISysUserQuerySV{
	 @Autowired
	private ISysUserBusiSV iSysUserBusiSV;
	 /**
	  * 查詢用戶信息
	  */
	public SysUserQueryResponse queryUserInfo(SysUserQueryRequest request)throws BusinessException,SystemException{
		//参数校验
		SystemValidateUtil.validateQueryUserInfo(request);
		return iSysUserBusiSV.queryUser(request);
	}
	/**
	 * 查詢用戶主題
	 */
	
	public String queryUserTheme(String userId)throws BusinessException,SystemException{
		//參數校驗
		if (StringUtils.isEmpty(userId)) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "用戶ID不能为空");
		}
		return iSysUserBusiSV.queryUserTheme(userId);
	}
}
