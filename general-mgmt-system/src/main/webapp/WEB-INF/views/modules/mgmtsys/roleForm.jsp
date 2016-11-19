<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>角色管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#name").focus();
			$("#inputForm").validate({
				rules: {
					name: {
						maxlength: 15,
						remote:{
							type:"POST",	
							url:"${ctx}/sys/role/checkName",
							data:{
								oldName:function(){return '${role.name}';}
							}
						}
					},
						
					enname: {
						maxlength: 20,
						remote:{
							type:"POST",	
							url:"${ctx}/sys/role/checkEnname",
							data:{
								oldEnname:function(){return '${role.enname}';}
							}
						}
					},
					remarks:{maxlength: 150}
				},
				messages: {
					name: {
						required: "请输入角色名称", 
						maxlength: "角色名称不能超过15个字符",
						remote: "角色名已存在"},
					enname: {
						required: "请输入英文名称", 
						maxlength: "英文名称不能超过20个字符",
						remote: "英文名已存在"},
					remarks: {maxlength: "备注不能超过150个字符"}
				},
				submitHandler: function(form){
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
		<li><a href="${ctx}/sys/role/">角色列表</a></li>
		<li class="active"><a href="${ctx}/sys/role/form?id=${role.id}">角色<shiro:hasPermission name="sys:role:edit">${not empty role.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="sys:role:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="role" action="${ctx}/sys/role/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">角色名称:</label>
			<div class="controls">
				<input id="oldName" name="oldName" type="hidden" value="${role.name}">
				<form:input path="name" htmlEscape="false" maxlength="16" class="required userName"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">英文名称:</label>
			<div class="controls">
				<input id="oldEnname" name="oldEnname" type="hidden" value="${role.enname}">
				<form:input path="enname" htmlEscape="false" maxlength="21" class="required username"/>
				<span class="help-inline"><font color="red">*</font></span>
			</div>
		</div>
		<input id="useable" name="useable" type="hidden" value="1">
		<div class="control-group">
			<label class="control-label">备注:</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="3" maxlength="151" class="input-xlarge"/>
			</div>
		</div>
		<div class="form-actions">
			<c:if test="${(role.sysData eq fns:getDictValue('是', 'yes_no', '1') && fns:getUser().admin)||!(role.sysData eq fns:getDictValue('是', 'yes_no', '1'))}">
				<shiro:hasPermission name="sys:role:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			</c:if>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="javaScript:window.location.href='${ctx}/sys/role/'"/>
		</div>
	</form:form>
</body>
</html>