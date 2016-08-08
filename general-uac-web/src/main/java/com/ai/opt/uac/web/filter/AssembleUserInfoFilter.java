package com.ai.opt.uac.web.filter;

import java.io.IOException;
import java.lang.reflect.Field;
import java.security.Principal;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jasig.cas.client.authentication.AttributePrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ai.opt.sso.client.filter.SSOClientConstants;
import com.ai.opt.uac.web.model.ssoclient.GeneralSSOClientUser;
import com.alibaba.fastjson.JSON;


public class AssembleUserInfoFilter implements Filter {
    private String[] ignor_suffix = {};
    private static final Logger LOG = LoggerFactory.getLogger(AssembleUserInfoFilter.class);

    public void init(FilterConfig filterConfig) throws ServletException {
        String ignore_res = filterConfig.getInitParameter("ignore_suffix");
        if (!"".equals(ignore_res)) {
            this.ignor_suffix = filterConfig.getInitParameter("ignore_suffix").split(",");
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        if (!shouldFilter(req)) {
            chain.doFilter(req, response);
            return;
        }
        HttpSession session = req.getSession();
        GeneralSSOClientUser user = (GeneralSSOClientUser) session.getAttribute(SSOClientConstants.USER_SESSION_KEY);
        if (user == null) {
            user = assembleUser(req);
            if(user!=null){
            	session.setAttribute(SSOClientConstants.USER_SESSION_KEY, user);
            	LOG.info("已封装的用户信息为：" + JSON.toJSONString(user));
            }
            else{
            	LOG.info("未获取到用户信息");
            }
            chain.doFilter(req, response);

        } else {
            chain.doFilter(req, response);
        }
    }

    @Override
    public void destroy() {

    }

    /**
     * 封装用户信息
     *
     * @param request
     * @return
     */
    private GeneralSSOClientUser assembleUser(HttpServletRequest request) {
    	GeneralSSOClientUser user = null;
        try {
            Principal principal = request.getUserPrincipal();
            if (principal != null) {
                user = new GeneralSSOClientUser();
                AttributePrincipal attributePrincipal = (AttributePrincipal) principal;
                Map<String, Object> attributes = attributePrincipal.getAttributes();
                Field[] fields = GeneralSSOClientUser.class.getDeclaredFields();
                for (Field field : fields) {
                    String value = (String) attributes.get(field.getName());
                    if (value != null) {
                        field.setAccessible(true);
                        if ("long".equalsIgnoreCase(field.getType().toString())) {
                            field.set(user, Long.parseLong(value));
                        } else {
                            field.set(user, value);
                        }
                    }
                }
            }
        } catch (Exception e) {
            LOG.error("封装用户信息失败", e);
        }
        return user;
    }

    private boolean shouldFilter(HttpServletRequest req) {
        if (ignor_suffix != null && ignor_suffix.length > 0) {
            String uri = req.getRequestURI().toLowerCase();
            for (String suffix : ignor_suffix) {
                if (uri.endsWith(suffix)) {
                    return false;
                }
            }
        }
        return true;
    }
}
