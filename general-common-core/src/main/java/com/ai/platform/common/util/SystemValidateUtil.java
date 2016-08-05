package com.ai.platform.common.util;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.vo.BaseInfo;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.platform.common.api.office.param.OfficeChildrenListQueryRequest;
import com.ai.platform.common.api.office.param.OfficeDetailQueryRequest;
import com.ai.platform.common.api.office.param.OfficeParentListQueryRequest;
import com.ai.platform.common.api.sysuser.param.SysUserListQueryRequest;
import com.ai.platform.common.api.sysuser.param.SysUserQueryRequest;
import com.ai.platform.common.api.sysuser.param.SysUserThemeRequest;
import com.ai.platform.common.api.waitjobs.param.WaitjobsCompleteRequset;
import com.ai.platform.common.api.waitjobs.param.WaitjobsInsertRequest;
import com.ai.platform.common.api.waitjobs.param.WaitjobsVO;

public class SystemValidateUtil {
	private SystemValidateUtil() {
	}

	public static void validateQueryUserInfo(SysUserQueryRequest condition) {
		if (condition == null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		if (StringBlank(condition.getTenantId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
		}
		if (StringBlank(condition.getNo()) && StringBlank(condition.getPhone())
				&& StringBlank(condition.getLoginName()) && StringBlank(condition.getEmail())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "手机号、邮箱、工号、登录名至少有一个不可以为空");
		}
	}
	public static void validateQueryUserByOfficeId(SysUserListQueryRequest condition) {
		if (condition == null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		if (StringBlank(condition.getTenantId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
		}
		if (StringBlank(condition.getOfficeId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "机构ID不能为空");
		}
	}
	//用户主题校验
	public static void validateQueryUserTheme(SysUserThemeRequest condition) {
		if (condition == null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		if (StringBlank(condition.getTenantId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
		}
		if (StringBlank(condition.getId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "用户ID不能为空");
		}
	}
	public static void validateQueryOfficeDetail(OfficeDetailQueryRequest queryRequest) {
		if (queryRequest == null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		if (StringBlank(queryRequest.getTenantId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
		}
		if (StringBlank(queryRequest.getId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "机构ID不能为空");
		}
	}
	
	public static void validateQueryParentOfficeList(OfficeParentListQueryRequest queryRequest) {
		if (queryRequest == null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		if (StringBlank(queryRequest.getTenantId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
		}
		if (StringBlank(queryRequest.getId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "机构ID不能为空");
		}
	}
	
	public static void validateQueryChildrenOfficeList(OfficeChildrenListQueryRequest queryRequest) {
		if (queryRequest == null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		if (StringBlank(queryRequest.getTenantId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
		}
		if (StringBlank(queryRequest.getId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "机构ID不能为空");
		}
	}
	
	public static void validateQueryOfficeAll(BaseInfo queryRequest) {
		if (queryRequest == null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		if (StringBlank(queryRequest.getTenantId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
		}
	}
	
	public static void validateInsertWaitjobs(WaitjobsInsertRequest insertRequest) {
		if (insertRequest == null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		WaitjobsVO waijobsVo = insertRequest.getWaitjobsVo();
		if (waijobsVo==null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "插入对象不能为空");
		}
		if (StringBlank(waijobsVo.getSystemId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "systemId不能为空");
		}
		if (StringBlank(waijobsVo.getTenantId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "tenantId不能为空");
		}
		if (StringBlank(waijobsVo.getTitle())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "title不能为空");
		}
		if (StringBlank(waijobsVo.getUserId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "userId不能为空");
		}
		if (StringBlank(waijobsVo.getLastUser())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "lastUser不能为空");
		}
	}
	
	public static void validateCompleteWaitjobs(WaitjobsCompleteRequset completeRequest) {
		if (completeRequest == null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		if (StringBlank(completeRequest.getTenantId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "tenantId不能为空");
		}
		if (StringBlank(completeRequest.getId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "id不能为空");
		}
	}
	//字符串非空校验
		public static boolean StringBlank(String str) {
			if (null == str) {
				return true;
			}
			if ("".equals(str.trim())) {
				return true;
			}
			return false;
		}
}
