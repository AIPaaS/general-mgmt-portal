<!DOCTYPE html>
<%@page import="java.net.URLDecoder"%>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width; initial-scale=0.8;  user-scalable=0;" />
    <title>统一登录认证系统</title>
    <link href="styles/css/font-awesome.css" type="text/css" rel="stylesheet" />
	<link href="styles/css/css.css" type="text/css" rel="stylesheet" />
	<script type="application/javascript" src="styles/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="styles/js/jquery.flexslider-min.js"></script>
	<script type="application/javascript" src="styles/js/index.js"></script>
	<script type="application/javascript" src="styles/js/md5.js"></script>
	
	
	<script language="javascript" type="text/javascript"> 
            
            function encryptPwd(){
            	if (event.keyCode == 13){
            		dologin(); 
            	}
            }//end of encryPwd
            
            function dologin() {
    				var inputPassword = document.getElementById("password").value;
    				var onceCode = "MYXAPP_SALT_KEY";
    				var passwordMd5 = hex_md5(onceCode
    						+ hex_md5(inputPassword));
    				document.getElementById("password").value = passwordMd5;
    				document.getElementById("username").value = trim(document
    						.getElementById("username").value);
    			
    		}//end of dologin

    </script>
</head>
<script>
$(function(){
	<%
	String isframe = request.getParameter("isframe");
	if(isframe!=null&&isframe!=""){
	%>
	//只保留登录控件信息
	$("body").html($("#miniLoginDiv").html());
	<%}	%>
});
</script>
<body>
<div class="login">
<div class="login_nra">
<div class="login_tp"><img src="styles/images/login_tp.png"></div>
 <div id="miniLoginDiv" class="login_nr">
  <div class="login_title">
   <p>员工登录</p>
  </div>
  <form:form method="post" id="fm2" commandName="${commandName}" htmlEscape="true">
	  <div class="login_tr">
	   <ul>
	   	<span><form:errors path="*" id="msg" cssClass="errors" element="div" htmlEscape="false" /></span>
	   
	    <li><i class="icon-user"></i><form:input cssClass="required shuru" cssErrorClass="error" id="username" size="25" tabindex="2" accesskey="${userNameAccessKey}" path="username" autocomplete="off" htmlEscape="true" placeholder="请输入登录账号"/></li>
	    <span><spring:message code="screen.welcome.label.netid.accesskey" var="userNameAccessKey" /></span>
	    <li><i class="icon-lock"></i><form:password cssClass="required shuru" cssErrorClass="error" id="password" size="25" tabindex="3" path="password"  accesskey="${passwordAccessKey}" htmlEscape="true" autocomplete="off" onkeydown="encryptPwd()"/></li>
	    <span><spring:message code="screen.welcome.label.password.accesskey" var="passwordAccessKey" /></span>
	    <li ><input id="rememberMe" name="rememberMe" tabindex="4" class="cbox" type="checkbox">下次自动登录</li>
	    <li><input class="login_btn" name="submit" accesskey="l" value="登录" tabindex="5" type="submit"  onclick="javascript:dologin();"  /></li>
	   </ul>
    	<input type="hidden" name="lt" value="${loginTicket}" />
    	<input type="hidden" name="execution" value="${flowExecutionKey}" />
    	<input type="hidden" name="_eventId" value="submit" />
	  </div>
  </form:form>
 </div>
 </div>
</div>
</div>
</body>
</html>
