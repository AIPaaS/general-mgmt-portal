<!DOCTYPE html>
<%@page import="com.ai.opt.uac.web.constants.Constants"%>
<%@page import="com.ai.opt.sdk.components.mcs.MCSClientFactory"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.util.Date"%>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="zh-cn">
<head>
<%@ include file="/inc/inc.jsp"%>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="shortcut icon" href="${_baasBase }/images/citic.ico">
    <meta name="viewport" content="width=device-width; initial-scale=0.8;  user-scalable=0;" />
    <title>长虹UP物联网单点登录</title>
	<script type="text/javascript" src="${_baasBase }/js/datacheck.js" ></script>
	<script language="javascript" src="${pageContext.request.contextPath}/resources/spm_modules/app/login/casLoginView.js"></script>  
	
</head>

<body>
<%@include file="/inc/head.jsp" %>
	
<div class="container login-bj">
	<form:form method="post" id="fm1" name="fm1" commandName="${commandName}" htmlEscape="true">
		<div class="row">
				<div class="col-xs-12">
					<div id="login-box">
						<div class="row">
							<div class="col-xs-12">
								<div class="login-frame">
								         <ul>
								         <div class="login-note" id="errorMsg"><form:errors path="*" id="msg" cssClass="errors" element="div" htmlEscape="false" /></div>
								         <li class="login-title">账户登录</li>
								         <li class="user"><i class="fa fa-user"></i><form:input cssClass="int-text int-large int-height" cssErrorClass="error" id="username" tabindex="1" accesskey="${userNameAccessKey}" path="username" autocomplete="off" htmlEscape="true" placeholder="登录名/公司邮箱/手机号"/></li>
								         <li class="password"><i class="fa fa-lock"></i><form:password  cssClass="int-text int-large int-height" cssErrorClass="error" id="password" size="25" tabindex="2" path="password"  accesskey="${passwordAccessKey}" htmlEscape="true" autocomplete="off"  placeholder="密码" onkeydown="encryptPwd(event)"/></li>
								         <li>
								         	<p class="yzm">
								         		<input type="text" class="int-text int-medium int-height" id="captchaCode" 	
													tabindex="3" name="captchaCode" path="captchaCode" onkeydown="encryptCaptcha(event)"
													placeholder="验证码"> 
								         	</p>
								         	<p class="yzn-t">
								         		<img title="点击重新获取验证码" style="vertical-align: middle;"	src="${_base}/captcha/getImageVerifyCode" id="pictureVitenfy" onclick="reloadImage('${_base}/captcha/getImageVerifyCode');">
								         	</p>
								         </li>
								         <li style="display:none;">
											<input id="rememberMe" name="rememberMe" type="checkbox" >
										 </li>
								         <li><input type="button" class="login-btn" value="登 录" accesskey="l" tabindex="4" onclick="javascript:dologin();"> </li> 
								        <!--  <li class="Forget-password"><a href="#">忘记密码？</a><a href="#" class="right">立即注册</a></li> -->
								         </ul>
		
							</div>
					</div>
				</div>
				</div>	
			</div>	
		</div>
		<input type="hidden" name="lt" value="${loginTicket}" />
		<input type="hidden" name="execution" value="${flowExecutionKey}" />
		<input type="hidden" name="_eventId" value="submit" />
		<input type="hidden" name="sessionId" value="<%=request.getSession().getId()%>"/>
	</form:form>
	
	 <%@include file="/inc/foot.jsp" %>
</div>
  
</body>
</html>
