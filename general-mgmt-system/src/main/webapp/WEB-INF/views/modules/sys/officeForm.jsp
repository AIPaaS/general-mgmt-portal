<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>部门管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#name").focus();
			//$("#code").focus();
			$("#inputForm").validate({
				rules: {
					name: {maxlength: 15},
					code: {
						maxlength: 20,
						remote: "${ctx}/sys/office/checkCode?oldCode=" + encodeURIComponent("${office.code}")},
					address:{maxlength: 50},
					zipCode:{maxlength: 50},
					master:{maxlength: 20},
					phone:{maxlength: 30},
					email:{maxlength: 50},
					remarks:{maxlength: 200}
				},
				messages: {
					name: {
						required: "请输入部门名称", 
						maxlength: "部门名称不能超过15个字符"},
					code: {
						required: "请输入部门编码", 
						maxlength: "部门编码不能超过20个字符",
						remote: "部门编码已存在"},
					address: {maxlength: "联系地址不能超过50个字符"},
					zipCode: {maxlength: "邮政编码不能超过50个字符"},
					master: {maxlength: "联系人不能超过20个字符"},
					phone: {maxlength: "电话号码不能超过30个字符"},
					email: {maxlength: "邮箱地址不能超过50个字符"},
					remarks: {maxlength: "备注不能超过200个字符"}
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
		<li><a href="${ctx}/sys/office/page">部门列表</a></li>
		<li class="active"><a href="${ctx}/sys/office/form?id=${office.id}&parent.id=${office.parent.id}">部门<shiro:hasPermission name="sys:office:edit">${not empty office.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="sys:office:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="office" action="${ctx}/sys/office/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">上级部门:</label>
			<div class="controls">
                <sys:treeselect id="office" name="parent.id" value="${office.parent.id}" labelName="parent.name" labelValue="${office.parent.name}"
					title="部门" url="/sys/office/treeData" extId="${office.id}" cssClass="" allowClear="${office.currentUser.admin}"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">归属区域:</label>
			<div class="controls">
                <sys:treeasync id="gnArea" name="gnArea.id" value="${office.gnArea.id}" labelName="gnArea.areaName" labelValue="${office.gnArea.areaName}"
					title="区域" url="/sys/gnArea/treeData?type=2" dataMsgRequired="请选择归属区域" cssClass="required"/>
					<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">部门名称:</label>
			<div class="controls">
			    <input id="oldName" name="oldName" type="hidden" value="${office.name}">
				<form:input path="name" htmlEscape="false" maxlength="16" class="required userName"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">部门编码:</label>
			<div class="controls">
			<input id="oldCode" name="oldCode" type="hidden" value="${office.code}">
				<form:input path="code" htmlEscape="false" maxlength="21" class="required username"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">部门类型:</label>
			<div class="controls">
				<form:select path="type" class="input-medium">
					<form:options items="${fns:getDictList('sys_office_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">部门级别:</label>
			<div class="controls">
				<form:select path="grade" class="input-medium">
					<form:options items="${fns:getDictList('sys_office_grade')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">联系地址:</label>
			<div class="controls">
				<form:input path="address" htmlEscape="false" maxlength="51"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">邮政编码:</label>
			<div class="controls">
				<form:input path="zipCode" htmlEscape="false" maxlength="51" class="zipCode"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">联系人:</label>
			<div class="controls">
				<form:input path="master" htmlEscape="false" maxlength="21"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">电话:</label>
			<div class="controls">
				<form:input path="phone" htmlEscape="false" maxlength="31" class="simplePhone"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">邮箱:</label>
			<div class="controls">
				<form:input path="email" htmlEscape="false" maxlength="51" type="email"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注:</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="3" maxlength="201" class="input-xlarge"/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="sys:office:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>