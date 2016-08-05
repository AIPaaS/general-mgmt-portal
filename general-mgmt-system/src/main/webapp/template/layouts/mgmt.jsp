<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<c:set var="mgmtStatic" value="${pageContext.request.contextPath}/template/mgmtstatic"/>
<!DOCTYPE html>
<html style="overflow-x:auto;overflow-y:auto;">
<head>
	<title>运营管理平台<sitemesh:title/></title>
	<%@include file="/template/mgmt/head.jsp" %>		

	<sitemesh:head/>
</head>
<body>
<sitemesh:body/>

 
<script src="${mgmtStatic}/scripts/modular/demo-skin-changer.js"></script>  
<script src="${mgmtStatic}/scripts/modular/jquery.js"></script>
<script src="${mgmtStatic}/scripts/modular/bootstrap.js"></script>
<script src="${mgmtStatic}/scripts/modular/jquery.nanoscroller.min.js"></script>
<script src="${mgmtStatic}/scripts/modular/demo.js"></script>  
<script src="${mgmtStatic}/scripts/modular/scripts.js"></script>

</body>
</html>