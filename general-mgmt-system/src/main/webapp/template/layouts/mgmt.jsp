<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<c:set var="iotStatic" value="${pageContext.request.contextPath}/template/mgmtstatic/default"/>
<c:set var="ctxStatic" value="${pageContext.request.contextPath}/static"/>
<!DOCTYPE html>
<html style="overflow-x:hidden;overflow-y:hidden;">
<head>
	<title>运营管理平台<sitemesh:title/></title>
	<%@include file="/template/mgmt/head.jsp" %>		

	<sitemesh:head/>
</head>
<body>
<sitemesh:body/>

 
 <script src="${iotStatic}/scripts/modular/p-skin-changer.js"></script>  
<script src="${iotStatic}/scripts/plugin/jquery.nanoscroller.min.js"></script>
<script src="${iotStatic}/scripts/modular/skin.js"></script>  
<script src="${iotStatic}/scripts/modular/frame.js"></script>  
<script src="${iotStatic}/scripts/modular/eject.js"></script>  
<script src="${iotStatic}/scripts/modular/scripts.js"></script>



<!--日期-->
<script src="${iotStatic}/scripts/date/WdatePicker.js"></script>
<!--ztree-->
<script src="${iotStatic}/scripts/ztree/jquery-1.4.4.min.js"></script>  
<script src="${iotStatic}/scripts/ztree/jquery.ztree.core-3.2.min.js"></script>  
<script src="${iotStatic}/scripts/ztree/jquery.ztree.excheck-3.2.min.js"></script>  
<link href="${ctxStatic}/jquery-jbox/2.3/Skins/Bootstrap/jbox.min.css" rel="stylesheet" />
<script src="${ctxStatic}/jquery-jbox/2.3/jquery.jBox-2.3.min.js" type="text/javascript"></script>



</body>
</html>