<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>角色管理</title>
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
	<form:form id="searchForm" modelAttribute="role" action="${ctx}/sys/rolemenu/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>角色名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>英文名称：</label>
				<form:input path="enname" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<tr><th>角色名称</th><th>英文名称</th><!-- <th>归属机构</th> --><!-- <th>数据范围</th> --><shiro:hasPermission name="sys:rolemenu:edit"><th>操作</th></shiro:hasPermission></tr>
		<c:forEach items="${page.list}" var="role">
			<tr>
				<td><a href="form?id=${role.id}">${role.name}</a></td>
				<td>${role.enname}</td>
				<%-- <td>${role.office.name}</td> --%>
				<%-- <td>${fns:getDictLabel(role.dataScope, 'sys_data_scope', '无')}</td> --%>
				<shiro:hasPermission name="sys:rolemenu:edit"><td>
					<c:if test="${(role.sysData eq fns:getDictValue('是', 'yes_no', '1') && fns:getUser().admin)||!(role.sysData eq fns:getDictValue('是', 'yes_no', '1'))}">
						<a href="${ctx}/sys/rolemenu/form?id=${role.id}">赋菜单权限</a>
					</c:if>
				</td></shiro:hasPermission>	
			</tr>
		</c:forEach>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>