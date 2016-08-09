package com.ai.opt.uac.web.controller.inc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ai.opt.sdk.util.StringUtil;
import com.ai.opt.sdk.web.model.ResponseData;
import com.ai.opt.sso.client.filter.SSOClientConstants;
import com.ai.opt.sso.client.filter.SSOClientUser;

@RequestMapping("/leftMenu")
@Controller
public class LeftMenuController {

	/**
	 * 当前用户是否含有邮箱信息
	 * @return
	 */
	@RequestMapping("/isHasEmail")
	@ResponseBody
	public ResponseData<String> isHasEmail(HttpServletRequest request) {
		SSOClientUser userClient = (SSOClientUser) request.getSession().getAttribute(SSOClientConstants.USER_SESSION_KEY);
		if (userClient != null) {
			String email = userClient.getEmail();
			if (StringUtil.isBlank(email)) {
				return new ResponseData<String>(ResponseData.AJAX_STATUS_SUCCESS, "没有邮箱信息", "0");
			} else {
				return new ResponseData<String>(ResponseData.AJAX_STATUS_SUCCESS, "含有邮箱信息", "1");
			}
		} else {
			return new ResponseData<String>(ResponseData.AJAX_STATUS_FAILURE, "请重新登录", null);
		}
	}
}
