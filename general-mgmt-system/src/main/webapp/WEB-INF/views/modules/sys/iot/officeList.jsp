<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>部门管理管理</title>
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
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/sys/iot/office/">部门管理列表</a></li>
		<shiro:hasPermission name="sys:iot:office:edit"><li><a href="${ctx}/sys/iot/office/form">部门管理添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="office" action="${ctx}/sys/iot/office/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>父级编号：</label>
			</li>
			<li><label>名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>名称</th>
				<th>归属区域</th>
				<th>机构编码</th>
				<shiro:hasPermission name="sys:iot:office:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="office">
			<tr>
				<td><a href="${ctx}/sys/iot/office/form?id=${office.id}">
					${office.name}
				</a></td>
				<td>
					${office.area.name}
				</td>
				<td>
					${office.code}
				</td>
				<shiro:hasPermission name="sys:iot:office:edit"><td>
    				<a href="${ctx}/sys/iot/office/form?id=${office.id}">修改</a>
					<a href="${ctx}/sys/iot/office/delete?id=${office.id}" onclick="return confirmx('确认要删除该部门管理吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>