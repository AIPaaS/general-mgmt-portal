<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>应用配置管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
	
			$("#inputForm").validate({
				rules: {
					systemId:{
						required:true,
						maxlength: 20,
						remote:{
							type:"POST",	
							url:"${ctx}/sys/gnTabSystem/checkSystemId",
							data:{
								oldSystemId:function(){return $("#gnTabSystem.systemId").val();}
							}
						}
					},
					systemName:{ 
					 	required:true,
					 	maxlength: 50,
					 	remote:{
							type:"POST",	
							url:"${ctx}/sys/gnTabSystem/checkSystemName",
							data:{
								oldSystemName:function(){return $("#gnTabSystem.systemName").val();}
							}
						}
					},
					remarks:{
						maxlength: 200
					},
					systemUrlContext:{
						maxlength: 400
					}
				},
				messages: {
					systemId: {
						required: "请输入应用编码", 
						maxlength: "应用编码不能超过20个字符", 
						remote: "应用编码已存在"
					},
					systemName: {
						required: "请输入应用名称", 
						maxlength: "应用名称不能超过50个字符", 
						remote: "应用名称已存在"
					},
					remarks:{
						maxlength: "备注字段不能超过200个字符"
					},
					systemUrlContext:{
						maxlength: "应用上下文不能超过400个字符"
					}
				},
				submitHandler: function(form){
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
		<li><a href="${ctx}/sys/gnTabSystem/">应用配置列表</a></li>
		<li class="active"><a href="${ctx}/sys/gnTabSystem/form?id=${gnTabSystem.id}">应用配置<shiro:hasPermission name="sys:gnTabSystem:edit">${not empty gnTabSystem.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="sys:gnTabSystem:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="gnTabSystem" action="${ctx}/sys/gnTabSystem/save" method="post" class="form-horizontal">
		<form:hidden path="id" value="${gnTabSystem.id}"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">应用编码：</label>
			<div class="controls">
				<form:input path="systemId" htmlEscape="false" maxlength="21" class="username"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">应用名称：</label>
			<div class="controls">
				<form:input path="systemName" htmlEscape="false" maxlength="51" class="userName"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="201" class="input-xlarge"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">应用上下文：</label>
			<div class="controls">
				<form:input path="systemUrlContext" htmlEscape="false" maxlength="401" class="input-xlarge"/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="sys:gnTabSystem:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>