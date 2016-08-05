package com.ai.opt.uac.web.controller.common;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ai.opt.sdk.components.ccs.CCSClientFactory;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.opt.sso.client.filter.SSOClientUtil;
import com.ai.opt.uac.web.constants.Constants;
import com.ai.paas.ipaas.ccs.constants.ConfigException;

@RequestMapping("/home")
@Controller
public class LoginJumpPageController {
	private static final Logger LOG=LoggerFactory.getLogger(LoginJumpPageController.class);

	@RequestMapping("/index")
	public String JumpPageAfterLogin(HttpServletRequest request){
		//获取配置中心配置的登录页面
		String service_url="";
		try {
			service_url = CCSClientFactory.getDefaultConfigClient().get(Constants.URLConstant.CITIC_INDEX_URL_KEY);
		} catch (ConfigException e) {
			LOG.error("从配置中心获取默认跳转页面失败，将跳向单点登录服务器默认页面");
		}
		//若不存在 跳转默认页面
		if (StringUtil.isBlank(service_url)) {
			service_url = SSOClientUtil.getCasServerUrlPrefixRuntime(request);
		}
		return "redirect:"+service_url;
	}
}
