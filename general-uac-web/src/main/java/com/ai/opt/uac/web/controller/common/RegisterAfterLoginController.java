package com.ai.opt.uac.web.controller.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jasig.cas.CentralAuthenticationService;
import org.jasig.cas.ticket.TicketException;
import org.jasig.cas.web.support.CookieRetrievingCookieGenerator;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.ai.opt.sdk.util.Md5Encoder;
import com.ai.opt.sso.constants.SSOConstants;
import com.ai.opt.sso.principal.BssCredentials;
import com.ai.opt.uac.web.constants.Constants;
import com.ai.opt.uac.web.model.login.LoginUser;
import com.ai.opt.uac.web.util.CacheUtil;

/**
 * 注册后自动登录
 *
 * Date: 2016年3月23日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author gucl
 */
public class RegisterAfterLoginController extends AbstractController {

	private CentralAuthenticationService centralAuthenticationService;
	private CookieRetrievingCookieGenerator ticketGrantingTicketCookieGenerator;

	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView signinView = new ModelAndView();
		// 从cache处理
		String uuid = request.getParameter(Constants.UUID.KEY_NAME);
		LoginUser loginUser = (LoginUser)CacheUtil.getValue(uuid, Constants.LoginConstant.CACHE_NAMESPACE, LoginUser.class);
		// username 和password从cache里取
		if(loginUser != null){
			String username = loginUser.getUserName();
			String password = loginUser.getPassword();
			bindTicketGrantingTicket(username, password, request, response);
			CacheUtil.deletCache(uuid, Constants.LoginConstant.CACHE_NAMESPACE);
		}
		String viewName = getSignInView(request);
		signinView.setViewName(viewName);
		return signinView;
	}

	/**
	 * Invoke generate validate Tickets and add the TGT to cookie.
	 * 
	 * @param loginName
	 *            the user login name.
	 * @param loginPassword
	 *            the user login password.
	 * @param request
	 *            the HttpServletRequest object.
	 * @param response
	 *            the HttpServletResponse object.
	 */
	protected void bindTicketGrantingTicket(String loginName, String loginPassword, HttpServletRequest request, HttpServletResponse response) {
		try {
			BssCredentials credentials = new BssCredentials();
			credentials.setUsername(loginName);
			credentials.setPassword(loginPassword);
			String ticketGrantingTicket = centralAuthenticationService.createTicketGrantingTicket(credentials);
			ticketGrantingTicketCookieGenerator.addCookie(request, response, ticketGrantingTicket);
		} catch (TicketException te) {
			logger.error("Validate the login name " + loginName + " failure, can't bind the TGT!", te);
		} catch (Exception e) {
			logger.error("bindTicketGrantingTicket has exception.", e);
		}
	}

	/**
	 * Get the signIn view URL.
	 * 
	 * @param request
	 *            the HttpServletRequest object.
	 * @return redirect URL
	 */
	protected String getSignInView(HttpServletRequest request) {
		String service = ServletRequestUtils.getStringParameter(request, "service", "");
		return ("redirect:login" + (service.length() > 0 ? "?service=" + service : ""));
	}

	public CentralAuthenticationService getCentralAuthenticationService() {
		return centralAuthenticationService;
	}

	public void setCentralAuthenticationService(CentralAuthenticationService centralAuthenticationService) {
		this.centralAuthenticationService = centralAuthenticationService;
	}

	public CookieRetrievingCookieGenerator getTicketGrantingTicketCookieGenerator() {
		return ticketGrantingTicketCookieGenerator;
	}

	public void setTicketGrantingTicketCookieGenerator(CookieRetrievingCookieGenerator ticketGrantingTicketCookieGenerator) {
		this.ticketGrantingTicketCookieGenerator = ticketGrantingTicketCookieGenerator;
	}

}