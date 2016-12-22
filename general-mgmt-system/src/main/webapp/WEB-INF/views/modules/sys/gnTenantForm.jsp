<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>业务平台配置管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				rules: {
					tenantName: {
						remote:{
							type:"POST",	
							url:"${ctx}/sys/gnTenant/checkTenantName",
							data:{
								oldTenantName:function(){return '${gnTenant.tenantName}';}
							}
						}
					},
					tenantId: {
						remote:{
							type:"POST",	
							url:"${ctx}/sys/gnTenant/checkTenantId",
							data:{
								oldTenantId:function(){return  '${gnTenant.tenantId}';}
							}
						}
					}
				},
				messages: {
					tenantName: {remote: "平台编码已存在"},
					tenantId: {remote: "平台编码已存在"}
				},
				submitHandler: function(form){
					btnSubmit.disabled=true;
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/sys/gnTenant/">平台配置列表</a></li>
		<li class="active"><a href="${ctx}/sys/gnTenant/form?id=${gnTenant.id}">平台配置<shiro:hasPermission name="sys:gnTenant:edit">${not empty gnTenant.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="sys:gnTenant:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="gnTenant" action="${ctx}/sys/gnTenant/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">平台名称：</label>
			<div class="controls">
				<input id="oldTenantId" name="oldTenantId" type="hidden" value="${gnTenant.tenantId}">
				<input id="oldTenantName" name="oldTenantName" type="hidden" value="${gnTenant.tenantName}">
				<form:input path="tenantName" htmlEscape="false"  maxlength="50"  class="input-xlarge required userName" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">平台编码：</label>
			<div class="controls">
				<form:input path="tenantId" htmlEscape="false" maxlength="20" class="input-xlarge required tenantId"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">状态：</label>
			<div class="controls">
				<form:select path="state" class="input-xlarge required">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="sys:gnTenant:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="javascript:window.location.href='${ctx}/sys/gnTenant/'"/>
		</div>
	</form:form>
</body>
</html>