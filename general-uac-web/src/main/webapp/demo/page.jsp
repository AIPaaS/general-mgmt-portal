<%@page import="com.alibaba.fastjson.JSON"%>
<%@page import="com.ai.opt.uac.web.model.ssoclient.CiticSSOClientUser"%>
<%@page import="com.ai.opt.sso.client.filter.SSOClientConstants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>单点登录测试页面</title>
</head>
<body>
<%
CiticSSOClientUser user = (CiticSSOClientUser) session.getAttribute(SSOClientConstants.USER_SESSION_KEY);
String jsonUser=JSON.toJSONString(user);
request.setAttribute("jsonUser", jsonUser);

%>
登录信息：${jsonUser}

</body>
</html>