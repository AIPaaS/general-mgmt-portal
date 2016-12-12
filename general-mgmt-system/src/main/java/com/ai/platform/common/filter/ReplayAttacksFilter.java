package com.ai.platform.common.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ai.net.xss.util.CollectionUtil;
import com.ai.net.xss.util.StringUtil;
import com.ai.platform.modules.sys.utils.UserUtils;
import com.alibaba.fastjson.JSON;

public class ReplayAttacksFilter implements Filter {
	private static Logger log = LoggerFactory.getLogger(ReplayAttacksFilter.class);
	private List<String> ignorePathList;
	public static final String USER_TOKEN_KEY = "user_token_key";

	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("Replay Attacks fiter [ReplayAttacksFilter] init start ...");
		String ignorePaths = filterConfig.getInitParameter("ignorePath");
		if (!(StringUtil.isBlank(ignorePaths))) {
			String[] ignorePathArr = ignorePaths.split(",");
			this.ignorePathList = Arrays.asList(ignorePathArr);
		}
		log.info("ignorePathList=" + JSON.toJSONString(this.ignorePathList));
		log.info("Replay Attacks fiter [ReplayAttacksFilter] init end");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		log.info("Replay Attacks fiter [Replay AttacksFilter] starting");
		HttpServletRequest req = (HttpServletRequest) request;
		if("post".equalsIgnoreCase(req.getMethod())){
			chain.doFilter(request, response);
			return;
		}
		HttpServletResponse res = (HttpServletResponse) response;
		String uriPath = ((HttpServletRequest) request).getRequestURI();
		HttpSession session = req.getSession();
//		String contextPath = req.getContextPath() + "/";
		if (isIgnorePath(uriPath)) {
			log.info("ignore ReplayAttacksfilter,path[" + uriPath + "] pass through ReplayAttacksFilter, go ahead...");
			chain.doFilter(request, response);
			return;
		}
//		if (contextPath.equals(uriPath)) {
//			log.info(
//					"ignore ReplayAttacksfilter,path[" + uriPath + "] pass through ReplayAttacksFilter, go ahead...");
//			setToken(res, req);
//			chain.doFilter(request, response);
//			return;
//		}

		String clientToken = "";
		Cookie[] cookies = req.getCookies();
		if(cookies !=null){
			for(Cookie cookie : cookies){
				if (cookie.getName().equalsIgnoreCase(USER_TOKEN_KEY)) { // 获取键
					clientToken = cookie.getValue().toString(); // 获取值
				}
			}
		}
		String serverToken = (String) session.getAttribute(USER_TOKEN_KEY);
		log.info("path[" + uriPath + "] Start,clientToken:"+clientToken+"||serverToken:"+serverToken);
		if (serverToken != null && !clientToken.equals(serverToken)) {
		 	((HttpServletResponse)response).sendRedirect(req.getContextPath()+"/404.jsp");
		 	UserUtils.getSubject().logout();
		 	log.info("path[" + uriPath + "] error,clientToken:"+clientToken+"||serverToken:"+serverToken);
		}else{
			setToken(res, req);
			chain.doFilter(request, response);
		}
	}

	private void setToken(HttpServletResponse res, HttpServletRequest req) {
		String token = UUID.randomUUID().toString();
		Cookie[] cookies = req.getCookies();
		boolean hasTokenInCookie =false;
		if(cookies !=null){
			for(Cookie cookie : cookies){
				if (cookie.getName().equalsIgnoreCase(USER_TOKEN_KEY)) { // 获取键
					cookie.setValue(token);
					cookie.setPath(req.getContextPath());
//					cookie.setMaxAge(30 * 60);
					// 设回Response中生效
					res.addCookie(cookie);
					hasTokenInCookie =true;
					break;
				}
			}
		}
		if(!hasTokenInCookie){
			Cookie visitTimesCookie = new Cookie(USER_TOKEN_KEY, token);
			res.addCookie(visitTimesCookie);
		}
		HttpSession session = req.getSession();
		session.setAttribute(USER_TOKEN_KEY, token);
		log.info("set token:"+token);
	}

	public void destroy() {
		log.info("Replay Attacks fiter [ReplayAttacksFilter] destroy");
	}

	private boolean isIgnorePath(String servletPath) {
		if (StringUtil.isBlank(servletPath)) {
			return true;
		}
		if (CollectionUtil.isEmpty(this.ignorePathList)) {
			return false;
		}

		for (String ignorePath : this.ignorePathList) {
			if ((!(StringUtil.isBlank(ignorePath))) && (servletPath.contains(ignorePath.trim()))) {
				return true;
			}

		}

		return false;
	}
}