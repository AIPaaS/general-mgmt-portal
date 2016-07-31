package com.ai.slp.common.util;

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
}
