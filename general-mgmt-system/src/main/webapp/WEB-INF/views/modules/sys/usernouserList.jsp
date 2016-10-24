<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>登录信息管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#ids").val("");
			$("#ids").val("");
		});
		function page(n,s){
			if(n) $("#pageNo").val(n);
			if(s) $("#pageSize").val(s);
			$("#searchForm").attr("action","${ctx}/sys/user/listno");
			$("#searchForm").submit();
	    	return false;
	    }
		
		function checkradio(v){
			$("#ids").val("");
			$("#ids").val("");
			$("#ids").val(v.value);
			$("#idsVal").val($(v).parent().parent().children('td').eq(4).html());
			 
		}
	</script>
</head>
<body>

	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/sys/user/listno">未创建账号列表</a></li>

	</ul>
	<form:form id="searchForm" modelAttribute="user" action="${ctx}/sys/user/listno" method="post" class="breadcrumb form-search ">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<sys:tableSort id="orderBy" name="orderBy" value="${page.orderBy}" callback="page();"/>
		<ul class="ul-form">

			<li><label>登录名：</label><form:input path="loginName" htmlEscape="false" maxlength="50" class="input-medium"/></li>
			
			<li><label>姓&nbsp;&nbsp;&nbsp;名：</label><form:input path="name" htmlEscape="false" maxlength="50" class="input-medium"/></li>
			
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询" onclick="return page();"/>

			<li class="clearfix"></li>
			
		</ul>
	</form:form>
	<input type="hidden" id="ids"/>
	<input type="hidden" id="idsVal"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>选择</th><th>归属公司</th><th>归属部门</th><th >登录名</th><th >姓名</th></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="user">
			<tr>
				<td><input type="radio" value = "${user.id}" onclick="javascript:checkradio(this);"/></td>
				<td>${user.company.name}</td>
				<td>${user.office.name}</td>
				<td>${user.loginName}</td>
				<td>${user.name}</td>
				
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>