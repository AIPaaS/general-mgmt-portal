<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<c:set var="iotStatic" value="${pageContext.request.contextPath}/template/mgmtstatic/default"/>
<html>
<head>
	<meta name="decorator" content="mgmt"/>
<title>up运营管理平台</title>



</head>
<body >
		<div class="container">
			<div class="col-xs-12 work-nav">
				<div class="work-logo"><img src="${iotStatic}/images/worl-logo.png" ></div>
				<div class="work-right"><a href="#"><img  src="${fns:getUser().photo}" height="35" width="35"/></a>${fns:getUser().name}，您好 <a href="${ctx}/logout" class="blue"><i class=" icon-off"></i>退出</a></div>
			</div>
		</div>
		<div class="container  platform-bj">
			<div class="row">
				<div class="col-xs-12">
					<div class="workbench">
					<c:forEach items="${fns:getAppMenuList()}" var="menu" varStatus="idxStatus">
					<c:set var="systemId" value="${menu.gnTabSystem}"/>
					<c:if test="${menu.parent.id eq '1'&&menu.isShow eq '1'}">
						<ul class="col-xs-2">
							<li class="circular c-img1"><a href="${fns:getGnTabSystemUrl(systemId)}${menu.href}" target="_blank"></a></li>
							<li><a href="#">${menu.name}</a></li>
						</ul>
					</c:if>
					<c:set var="systemId" value=""/>
					</c:forEach>
					</div>
			
			</div>	
		</div>
		</div>

			<div class="col-xs-12 work-bottom">
				©2016 版权所有 亚信集团股份有限公司 京ICP备11005544号-15 京公网安备110108007119号
			</div>
			
</body>
</html>