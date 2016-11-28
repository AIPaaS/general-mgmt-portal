package com.ai.platform.modules.sys.web;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ai.opt.sso.client.filter.SSOClientUtil;
import com.ai.platform.modules.sys.service.GnTabSystemService;
import com.ai.platform.modules.sys.task.NotifySystemLogOutThread;

@Controller
public class LogoutController {
	private static final Logger LOG = LoggerFactory.getLogger(LogoutController.class);
	@Autowired
	private GnTabSystemService gnTabSystemService;

		
	@RequestMapping("${adminPath}/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String logOutServerUrl = SSOClientUtil.getLogOutServerUrlRuntime(request);
		String logOutBackUrl = SSOClientUtil.getLogOutBackUrlRuntime(request);
		try {
			if (session != null)
				session.invalidate();
			Subject subject = SecurityUtils.getSubject();
			if (subject != null)
				subject.logout();
			Cookie[] cookies = request.getCookies();
			for (Cookie cookie : cookies) {
				cookie.setMaxAge(0);
				cookie.setValue("");
				cookie.setPath("/");
				response.addCookie(cookie);
			}
			Thread thread = new NotifySystemLogOutThread(gnTabSystemService);
			thread.start();
		} catch (Exception e) {
			LOG.error("用户登出清除session失败", e);
		} finally {
			try {
				response.sendRedirect(logOutServerUrl + "?service=" + logOutBackUrl+SSOClientUtil.getProperty("serverContextPath"));
			} catch (IOException e) {
				LOG.error("用户登出失败", e);
			}
		}

	}

}
