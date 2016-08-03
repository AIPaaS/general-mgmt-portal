<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<!DOCTYPE html>
<html style="overflow-x:auto;overflow-y:auto;">
<head>
	<title>运营管理平台<sitemesh:title/></title>
	<%@include file="/WEB-INF/views/include/iot/head.jsp" %>		

	<sitemesh:head/>
</head>
<body>
<sitemesh:body/>

 
<script src="${iotStatic}/scripts/modular/demo-skin-changer.js"></script>  
<script src="${iotStatic}/scripts/modular/jquery.js"></script>
<script src="${iotStatic}/scripts/modular/bootstrap.js"></script>
<script src="${iotStatic}/scripts/modular/jquery.nanoscroller.min.js"></script>
<script src="${iotStatic}/scripts/modular/demo.js"></script>  
<script src="${iotStatic}/scripts/modular/scripts.js"></script>

</body>
</html>