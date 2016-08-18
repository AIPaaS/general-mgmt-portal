<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>地区信息管理</title>
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
		<li class="active"><a href="${ctx}/sys/gnArea/">地区信息列表</a></li>
		<shiro:hasPermission name="sys:gnArea:edit"><li><a href="${ctx}/sys/gnArea/form">地区信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="gnArea" action="${ctx}/sys/gnArea/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>区域编码：</label>
				<form:input path="areaCode" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>区域名称：</label>
				<form:input path="areaName" htmlEscape="false" maxlength="500" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>区域编码</th>
				<th>区域名称</th>
				<th>所属区域</th>
				<shiro:hasPermission name="sys:gnArea:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="gnArea">
			<tr>
				<td><a href="${ctx}/sys/gnArea/form?id=${gnArea.id}">
					${gnArea.areaCode}
				</a></td>
				<td>
					${gnArea.areaName}
				</td>
				<td>
					${gnArea.parentAreaCode.areaCode}
				</td>
				<shiro:hasPermission name="sys:gnArea:edit"><td>
				<c:if test="${gnArea.areaLevel ne '0'}">		
    				<a href="${ctx}/sys/gnArea/form?id=${gnArea.id}">修改</a>
    			
					<a href="${ctx}/sys/gnArea/delete?areaCode=${gnArea.areaCode}" onclick="return confirmx('确认要删除该地区信息吗？', this.href)">删除</a>
				</c:if>		
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>