<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>部门管理</title>
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
			
			var b = $("#id").val();//取出值
			$("#parentId").val(b);
			
			$("#btnExport").click(function(){
				top.$.jBox.confirm("确认要导出部门数据吗？","系统提示",function(v,h,f){
					if(v=="ok"){
						$("#searchForm").attr("action","${ctx}/sys/user/export");
						$("#searchForm").submit();
					}
				},{buttonsFocus:1});
				top.$('.jbox-body .jbox-icon').css('top','55px');
			});
			$("#btnImport").click(function(){
				$.jBox($("#importBox").html(), {title:"导入数据", buttons:{"关闭":true}, 
					bottomText:"导入文件不能超过5M，仅允许导入“txt”格式文件！"});
			});
			
		});
		
	</script>
</head>
<body>
	<div id="importBox" class="hide">
		<form id="importForm" action="${ctx}/sys/office/import" method="post" enctype="multipart/form-data"
			class="form-search" style="padding-left:20px;text-align:center;" onsubmit="loading('正在导入，请稍等...');"><br/>
			<input id="uploadFile" name="file" accept=".txt"  type="file" style="width:330px"/><br/><br/>　　
			<input id="btnImportSubmit" class="btn btn-primary" type="submit" value="   导    入   "/>
			<%-- <a href="${ctx}/sys/user/import/template">下载模板</a> --%>
		</form>
	</div>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/sys/office/page">部门列表</a></li>
		<shiro:hasPermission name="sys:office:edit"><li><a href="${ctx}/sys/office/form?parent.id=${office.id}">部门添加</a></li></shiro:hasPermission>
	</ul>
	<sys:message content="${message}"/>
	<!-- ceshi -->
	<input type="hidden" name="upName" id="upName" value="${requestScope.upName}"/>
	<input type="hidden" name="id" id="id" value="${requestScope.id}"/>
		  <!--框架标签结束-->
        <!--查询条件-->
    <form:form id="searchForm" modelAttribute="office" action="${ctx}/sys/office/page/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
         <ul class="ul-form">
			<li><label>上级部门：</label>
			<sys:treeselect id="parent" name="parent.id" value="${parent.id}" labelName="parent.name" labelValue="${parent.name}" 
				title="部门" url="/sys/office/treeData" cssClass="input-small" allowClear="false"/>
			</li>
			<li><label>名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li class="btns">
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
				<input id="btnImport" class="btn btn-primary" type="button" value="导入"/>
			</li>
			<li class="clearfix"></li>
		</ul>
     </form:form>
  	<!--查询结束-->      
      <table id="contentTable" class="table table-striped table-bordered table-condensed">
          <thead>
              <tr>
                  <th>部门名称</th>
                  <th>归属地区</th>
                  <th>部门编码</th>
                  <th>部门类型</th>
                   <th>部门级别</th>
                  <th>操作</th>
              </tr>
          </thead>
	    <c:forEach items="${page.list}" var="office">
			<tr>
				<td><a href="${ctx}/sys/office/form?id=${office.id}">${office.name}</a></td>
				<td>${office.gnArea.areaName}</td>
				<td>${office.code}</td>
				<td>${office.type}</td>
				<td>${office.grade}</td>
				<shiro:hasPermission name="sys:office:edit"><td>
					<a href="${ctx}/sys/office/form?id=${office.id}">修改</a>
					<a href="${ctx}/sys/office/delete?id=${office.id}" onclick="return confirmx('要删除该部门及所有子部门项吗？', this.href)">删除</a>
					<a href="${ctx}/sys/office/form?parent.id=${office.id}">添加下级部门</a> 
				</td></shiro:hasPermission>
			</tr>
	    </c:forEach>
       </table>
     <!--分页-->
	<div class="pagination">${page}</div>
</body>
</html>