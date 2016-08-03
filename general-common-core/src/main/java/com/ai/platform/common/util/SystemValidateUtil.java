package com.ai.platform.common.util;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.vo.BaseInfo;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.platform.common.api.office.param.OfficeChildrenListQueryRequest;
import com.ai.platform.common.api.office.param.OfficeDetailQueryRequest;
import com.ai.platform.common.api.office.param.OfficeParentListQueryRequest;
import com.ai.platform.common.api.sysuser.param.SysUserQueryRequest;
import com.ai.platform.common.api.waitjobs.param.WaitjobsCompleteRequset;
import com.ai.platform.common.api.waitjobs.param.WaitjobsInsertRequest;
import com.ai.platform.common.api.waitjobs.param.WaitjobsVO;
import com.alibaba.dubbo.common.utils.StringUtils;

public class SystemValidateUtil {
	private SystemValidateUtil() {
	}

	public static void validateQueryUserInfo(SysUserQueryRequest condition) {
		if (condition == null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		if (StringUtils.isEmpty(condition.getTenantId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
		}
		if (StringUtils.isEmpty(condition.getNo()) && StringUtils.isEmpty(condition.getPhone())
				&& StringUtils.isEmpty(condition.getLoginName()) && StringUtils.isEmpty(condition.getEmail())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "手机号、邮箱、工号、登录名至少有一个不可以为空");
		}
	}
	
	public static void validateQueryOfficeDetail(OfficeDetailQueryRequest queryRequest) {
		if (queryRequest == null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		if (StringUtils.isEmpty(queryRequest.getTenantId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
		}
		if (StringUtils.isEmpty(queryRequest.getId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "机构ID不能为空");
		}
	}
	
	public static void validateQueryParentOfficeList(OfficeParentListQueryRequest queryRequest) {
		if (queryRequest == null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		if (StringUtils.isEmpty(queryRequest.getTenantId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
		}
		if (StringUtils.isEmpty(queryRequest.getId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "机构ID不能为空");
		}
	}
	
	public static void validateQueryChildrenOfficeList(OfficeChildrenListQueryRequest queryRequest) {
		if (queryRequest == null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		if (StringUtils.isEmpty(queryRequest.getTenantId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
		}
		if (StringUtils.isEmpty(queryRequest.getId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "机构ID不能为空");
		}
	}
	
	public static void validateQueryOfficeAll(BaseInfo queryRequest) {
		if (queryRequest == null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		if (StringUtils.isEmpty(queryRequest.getTenantId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
		}
	}
	
	public static void validateInsertWaitjobs(WaitjobsInsertRequest insertRequest) {
		if (insertRequest == null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		WaitjobsVO waijobsVo = insertRequest.getWaijobsVo();
		if (waijobsVo==null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "插入对象不能为空");
		}
		if (StringUtils.isEmpty(waijobsVo.getSystemId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "systemId不能为空");
		}
		if (StringUtils.isEmpty(waijobsVo.getTenantId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "tenantId不能为空");
		}
		if (StringUtils.isEmpty(waijobsVo.getTitle())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "title不能为空");
		}
		if (StringUtils.isEmpty(waijobsVo.getUserId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "userId不能为空");
		}
		if (StringUtils.isEmpty(waijobsVo.getLastUser())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "lastUser不能为空");
		}
	}
	
	public static void validateCompleteWaitjobs(WaitjobsCompleteRequset completeRequest) {
		if (completeRequest == null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		if (StringUtils.isEmpty(completeRequest.getTenantId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "tenantId不能为空");
		}
		if (StringUtils.isEmpty(completeRequest.getId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "id不能为空");
		}
	}
}
