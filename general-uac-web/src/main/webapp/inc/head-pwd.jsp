<%@page import="java.util.Date"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <div class="header">
  <div class="head-auto">
    <img id="img_logincheck" style="display:none;" src="${baas_pt_index_url }/logincheck?req=<%=new Date().getTime() %>">
   	<div class="logo"><a href="${baas_pt_index_url }"><img src="${_baasBase }/images/about.png"></a></div>
   	<div class="breadcrumb">
   		<ul>
			<li><span id="set_title_id">找回密码</span></li>
		</ul>
	</div>
	  <div class="pass-right"><a href="${baas_pt_index_url }">返回首页</a><a href="/uac/reg/toRegister">注册</a> | <a href="/uac/login">登录</a></div>
  </div>
 </div>