<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>机构管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		function page(n,s){
				$("#pageNo").val(n);
				$("#pageSize").val(s);
				$("#searchForm").submit();
		    	return false;
		    }
		$(document).ready(function(){
			var a = $("#upName").val();//取出值
			$("#parentName").val(a);
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/sys/office/page">部门列表</a></li>
		<shiro:hasPermission name="sys:office:edit"><li><a href="${ctx}/sys/office/form?parent.id=${office.id}">部门添加</a></li></shiro:hasPermission>
	</ul>
	<sys:message content="${message}"/>
	<!-- ceshi -->
	<input type="hidden" name="upName" id="upName" value="${requestScope.upName}"/>
		  <!--框架标签结束-->
        <!--查询条件-->
    <form:form id="searchForm" modelAttribute="office" action="${ctx}/sys/office/page/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
         <ul class="ul-form">
			<li><label>上级部门：</label>
			<sys:treeselect id="parent" name="parent.id" value="${parent.id}" labelName="parent.name" labelValue="${parent.name}" 
				title="部门" url="/sys/office/treeData?type=1" cssClass="input-small" allowClear="true"/>
			</li>
			<li><label>名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
     </form:form>
  	<!--查询结束-->      
      <table id="contentTable" class="table table-hover table-border table-bordered">
          <thead>
              <tr>
                  <th>部门名称</th>
                  <th>归属地区</th>
                  <th>部门编码</th>
                  <th>部门类型</th>
                  <th>备注</th>
                  <th>操作</th>
              </tr>
          </thead>
	    <c:forEach items="${page.list}" var="office">
			<tr>
				<td><a href="${ctx}/sys/office/form?id=${office.id}">${office.name}</a></td>
				<td>${office.area.name}</td>
				<td>${office.code}</td>
				<td>${office.type}</td>
				<td>${office.remarks}</td>
				<shiro:hasPermission name="sys:office:edit"><td>
					<a href="${ctx}/sys/office/form?id=${office.id}">修改</a>
					<a href="${ctx}/sys/office/delete?id=${office.id}" onclick="return confirmx('要删除该机构及所有子机构项吗？', this.href)">删除</a>
					<a href="${ctx}/sys/office/form?parent.id=${office.id}">添加下级机构</a> 
				</td></shiro:hasPermission>
			</tr>
	    </c:forEach>
       </table>
     <!--分页-->
	<div class="pagination">${page}</div>
</body>
</html>