<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>应用配置管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
		function formTabSystem(id){
			window.location.href='${ctx}/sys/gnTabSystem/form?id='+id;
	    }
		function deleteTabSystem(id){
			return confirmx('确认要删除该应用配置吗？','${ctx}/sys/gnTabSystem/delete?id='+id);
	    }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/sys/gnTabSystem/">应用配置列表</a></li>
		<shiro:hasPermission name="sys:gnTabSystem:edit"><li><a href="${ctx}/sys/gnTabSystem/form">应用配置添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="gnTabSystem" action="${ctx}/sys/gnTabSystem/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>应用编码：</label>
				<form:input path="systemId" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>应用名称：</label>
				<form:input path="systemName" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>应用编码</th>
				<th>应用名称</th>
				<th>应用上下文</th>
				<shiro:hasPermission name="sys:gnTabSystem:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="gnTabSystem">
			<tr>
				<td><a href="javascript:void(0)" onclick="formTabSystem('${gnTabSystem.id}')">
					${gnTabSystem.systemId}
				</a></td>
				<td>
					${gnTabSystem.systemName}
				</td>
				<td>
					${gnTabSystem.systemUrlContext}
				</td>
				<shiro:hasPermission name="sys:gnTabSystem:edit"><td>
					<a href="javascript:void(0)" onclick="formTabSystem('${gnTabSystem.id}')">修改</a>
					<a href="javascript:void(0)" onclick="deleteTabSystem('${gnTabSystem.id}')">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>