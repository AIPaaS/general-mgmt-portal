<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<c:set var="iotStatic" value="${pageContext.request.contextPath}/template/static"/>
<!DOCTYPE html>
<html style="overflow-x:auto;overflow-y:auto;">
<head>
	<title>运营管理平台<sitemesh:title/></title>
	<c:set var="iotStatic" value="${pageContext.request.contextPath}/template/static"/>
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
	<link rel="stylesheet" type="text/css" href="${iotStatic}/css/bootstrap/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="${iotStatic}/css/bootstrap/font-awesome.css"/>
	<link rel="stylesheet" type="text/css" href="${iotStatic}/css/modular/frame.css"/>
	<link rel="stylesheet" type="text/css" href="${iotStatic}/css/modular/global.css"/>
	<link rel="stylesheet" type="text/css" href="${iotStatic}/css/ztree/zTreeStyle.css"/>
	<script src="${iotStatic}/scripts/plugin/jquery-1.9.1.js"></script>
	<script src="${iotStatic}/scripts/plugin/bootstrap.js"></script>

	<sitemesh:head/>
</head>
<body>
<sitemesh:body/>
 
<script src="${iotStatic}/scripts/modular/p-skin-changer.js"></script>  
<script src="${iotStatic}/scripts/plugin/jquery.nanoscroller.min.js"></script>
<script src="${iotStatic}/scripts/modular/skin.js"></script>  
<script src="${iotStatic}/scripts/modular/frame.js"></script>  
<script src="${iotStatic}/scripts/modular/scripts.js"></script>


<!--日期-->
<%-- <script src="${iotStatic}/scripts/date/WdatePicker.js"></script> --%>
<!--ztree-->
<%-- <script src="${iotStatic}/scripts/ztree/jquery-1.4.4.min.js"></script>  
<script src="${iotStatic}/scripts/ztree/jquery.ztree.core-3.2.min.js"></script>  
<script src="${iotStatic}/scripts/ztree/jquery.ztree.excheck-3.2.min.js"></script>   --%>




</body>
</html>