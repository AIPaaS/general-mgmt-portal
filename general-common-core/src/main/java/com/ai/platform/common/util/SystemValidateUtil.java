package com.ai.platform.common.util;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.vo.BaseInfo;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.opt.sdk.util.StringUtil;
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
		if (StringUtil.isBlank(condition.getTenantId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
		}
		if (StringUtil.isBlank(condition.getNo()) && StringUtil.isBlank(condition.getPhone())
				&& StringUtil.isBlank(condition.getLoginName()) && StringUtil.isBlank(condition.getEmail())&& StringUtil.isBlank(condition.getId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "id、手机号、邮箱、工号、登录名至少有一个不可以为空");
		}
	}
	public static void validateQueryUserByOfficeId(SysUserListQueryRequest condition) {
		if (condition == null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		if (StringUtil.isBlank(condition.getTenantId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
		}
		if (StringUtil.isBlank(condition.getOfficeId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "机构ID不能为空");
		}
	}
	//用户主题校验
	public static void validateQueryUserTheme(SysUserThemeRequest condition) {
		if (condition == null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		if (StringUtil.isBlank(condition.getTenantId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
		}
		if (StringUtil.isBlank(condition.getId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "用户ID不能为空");
		}
	}
	public static void validateQueryOfficeDetail(OfficeDetailQueryRequest queryRequest) {
		if (queryRequest == null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		if (StringUtil.isBlank(queryRequest.getTenantId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
		}
		if (StringUtil.isBlank(queryRequest.getId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "机构ID不能为空");
		}
	}
	
	public static void validateQueryParentOfficeList(OfficeParentListQueryRequest queryRequest) {
		if (queryRequest == null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		if (StringUtil.isBlank(queryRequest.getTenantId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
		}
		if (StringUtil.isBlank(queryRequest.getId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "机构ID不能为空");
		}
	}
	
	public static void validateQueryChildrenOfficeList(OfficeChildrenListQueryRequest queryRequest) {
		if (queryRequest == null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		if (StringUtil.isBlank(queryRequest.getTenantId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
		}
		if (StringUtil.isBlank(queryRequest.getId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "机构ID不能为空");
		}
	}
	
	public static void validateQueryOfficeAll(BaseInfo queryRequest) {
		if (queryRequest == null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		if (StringUtil.isBlank(queryRequest.getTenantId())) {
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
		String systemId = waijobsVo.getSystemId();
		if (StringUtil.isBlank(systemId)) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "systemId不能为空");
		}
		if (systemId.length()>32){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_TYPE_NOT_RIGHT, "systemId长度大于32");
		}
		String tenantId = waijobsVo.getTenantId();
		if (StringUtil.isBlank(tenantId)) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "tenantId不能为空");
		}
		if (tenantId.length()>64){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_TYPE_NOT_RIGHT, "tenantId长度大于64");
		}
		String title = waijobsVo.getTitle();
		if (StringUtil.isBlank(title)) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "title不能为空");
		}
		if (title.length()>128){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_TYPE_NOT_RIGHT, "title长度大于128");
		}
		String userId = waijobsVo.getUserId();
		if (StringUtil.isBlank(userId)) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "userId不能为空");
		}
		if (userId.length()>64){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_TYPE_NOT_RIGHT, "userId长度大于64");
		}
		String lastUser = waijobsVo.getLastUser();
		if (StringUtil.isBlank(lastUser)) {

			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "lastUser不能为空");
		}
		if (lastUser.length()>64){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_TYPE_NOT_RIGHT, "lastUser长度大于64");
		}
		String presentActiviti = waijobsVo.getPresentActiviti();
		if (presentActiviti != null && presentActiviti.length() > 64){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_TYPE_NOT_RIGHT, "presentActiviti长度大于64");
		}
		String url = waijobsVo.getUrl();
		if (url != null && url.length() > 128){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_TYPE_NOT_RIGHT, "url长度大于128");
		}
	}
	
	public static void validateCompleteWaitjobs(WaitjobsCompleteRequset completeRequest) {
		if (completeRequest == null) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "参数对象不能为空");
		}
		if (StringUtil.isBlank(completeRequest.getTenantId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "tenantId不能为空");
		}
		if (StringUtil.isBlank(completeRequest.getId())) {
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "id不能为空");
		}
	}
}
