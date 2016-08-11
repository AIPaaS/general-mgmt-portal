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
		<li class="active"><a href="${ctx}/sys/iotOffice/">部门管理列表</a></li>
		<shiro:hasPermission name="sys:iotOffice:edit"><li><a href="${ctx}/sys/iotOffice/form">部门管理添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="iotOffice" action="${ctx}/sys/iotOffice/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>父级编号：</label><sys:treeselect id="parent" name="parent.id" value="${parent.id}" labelName="parent.name" labelValue="${parent.name}" 
				title="公司" url="/sys/office/treeData?type=1" cssClass="input-small" allowClear="true"/>
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
				<shiro:hasPermission name="sys:iotOffice:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="iotOffice">
			<tr>
				<td><a href="${ctx}/sys/iotOffice/form?id=${iotOffice.id}">
					${iotOffice.name}
				</a></td>
				<td>
					${iotOffice.area.name}
				</td>
				<td>
					${iotOffice.code}
				</td>
				<shiro:hasPermission name="sys:iotOffice:edit"><td>
    				<a href="${ctx}/sys/iotOffice/form?id=${iotOffice.id}">修改</a>
					<a href="${ctx}/sys/iotOffice/delete?id=${iotOffice.id}" onclick="return confirmx('确认要删除该部门管理吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>