package com.ai.platform.modules.oa.resolvers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class OaNotifyArgumentResolver implements HandlerMethodArgumentResolver {

    //@Override
    public boolean supportsParameter(MethodParameter parameter) {
        return false;
    }

    //@Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
    	HttpServletRequest httpServletRequest= webRequest.getNativeRequest(HttpServletRequest.class);
        return null;
    }
}