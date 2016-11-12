<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>业务平台配置管理</title>
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
		<li class="active"><a href="${ctx}/sys/gnTenant/">平台配置列表</a></li>
		<shiro:hasPermission name="sys:gnTenant:edit"><li><a href="${ctx}/sys/gnTenant/form">平台配置添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="gnTenant" action="${ctx}/sys/gnTenant/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>平台名称：</label>
				<form:input path="tenantName" htmlEscape="false" maxlength="128" class="input-medium"/>
			</li>
			<li><label>状态：</label>
				<form:select path="state" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>平台名称</th>
				<th>平台编码</th>
				<th>状态</th>
				<shiro:hasPermission name="sys:gnTenant:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="gnTenant">
			<tr>
				<td><a href="${ctx}/sys/gnTenant/form?id=${gnTenant.id}">
					${gnTenant.tenantName}
				</a></td>
				
				<td>
					${gnTenant.tenantId}
				</td>
				<td>
					${fns:getDictLabel(gnTenant.state, 'yes_no', '')}
				</td>
				<shiro:hasPermission name="sys:gnTenant:edit"><td>
    				<a href="${ctx}/sys/gnTenant/form?id=${gnTenant.tenantId}">修改</a>
					<a href="${ctx}/sys/gnTenant/delete?id=${gnTenant.tenantId}" onclick="return confirmx('确认要删除该业务平台配置吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>