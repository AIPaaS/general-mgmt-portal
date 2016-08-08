<%@page import="java.util.Date"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<div class="header">
  <div class="head-auto">
    <img id="img_logincheck" style="display:none;" src="${baas_pt_index_url }/logincheck?req=<%=new Date().getTime() %>">
   	<div class="logo"><a href="${baas_pt_index_url }"><img src="${_baasBase }/images/about.png"></a></div>
   	
   	<div class="breadcrumb">
    <ul>
			<li><span id="set_title_id"></span></li>
		</ul>
		
	</div>
	<c:choose>
	    <c:when test="${sessionScope.user_session_key.shortNickName==''}">
	      <div class="pass-right"><a href="${baas_pt_index_url }">首页</a><a href="${baas_op_index_url }">管理平台</a>　|<a href="${_base}/center/baseInfo/getAccountInfo">你好，${sessionScope.user_session_key.nickName}</a><a href="${_base}/ssologout">退出</a></div>
	    </c:when>
	    <c:when test="${sessionScope.user_session_key.shortNickName==null}">
	      <div class="pass-right"><a href="${baas_pt_index_url }">首页</a><a href="${baas_op_index_url }">管理平台</a>　|<a href="${_base}/center/baseInfo/getAccountInfo">你好，${sessionScope.user_session_key.nickName}</a><a href="${_base}/ssologout">退出</a></div>
	    </c:when>
	    <c:otherwise>
	      <div class="pass-right"><a href="${baas_pt_index_url }">首页</a><a href="${baas_op_index_url }">管理平台</a>　|<a href="${_base}/center/baseInfo/getAccountInfo">你好，${sessionScope.user_session_key.nickName}</a><a href="${_base}/ssologout">退出</a></div>
	    </c:otherwise>
	 </c:choose>   
   
  </div>
  </div>

