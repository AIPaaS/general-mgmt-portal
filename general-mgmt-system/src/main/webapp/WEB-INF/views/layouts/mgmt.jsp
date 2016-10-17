<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<!DOCTYPE html>
<html >
<head>
	<title>运营管理平台<sitemesh:title/></title>
	<%@include file="/WEB-INF/views/include/mgmt/head.jsp" %>		

	<sitemesh:head/>
</head>
<body>

<sitemesh:body/>

 
<script src="${mgmtStatic}/scripts/modular/demo-skin-changer.js"></script>  

<script src="${mgmtStatic}/scripts/modular/jquery.js"></script>
<script src="${ctxStatic}/jquery/jquery-1.8.3.min.js" type="text/javascript"></script>

<link href="${ctxStatic}/jquery-jbox/2.3/Skins/Bootstrap/jbox.min.css" rel="stylesheet" />
<script src="${ctxStatic}/jquery-jbox/2.3/jquery.jBox-2.3.min.js" type="text/javascript"></script>
<script src="${mgmtStatic}/scripts/modular/bootstrap.js"></script>
<script src="${mgmtStatic}/scripts/modular/jquery.nanoscroller.min.js"></script>
<script src="${mgmtStatic}/scripts/modular/demo.js"></script>  
<script src="${mgmtStatic}/scripts/modular/scripts.js"></script>


</body>
</html>