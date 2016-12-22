<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>个人信息</title>
	<meta name="decorator" content="default"/>
	<script src="${ctxStatic}/fileinput/fileinput.min.js" type="text/javascript"></script>
	<script src="${ctxStatic}/fileinput/locales/zh.js" type="text/javascript"></script>
	<link href="${ctxStatic}/fileinput/fileinput.min.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript">
	$(document).ready(function() {
		$("#no").focus();
		$("#inputForm").validate({
			rules: {
				mobile: {
					maxlength: 30,
					remote:{
						type:"POST",	
						url:"${ctx}/sys/user/checkMobile",
						data:{
							oldMobile:function(){return  '${user.mobile}';}
						}
					}
				},
				email: {
					maxlength: 50,
					remote:{
						type:"POST",	
						url:"${ctx}/sys/user/checkEmail",
						data:{
							oldLoginName:function(){return  '${user.email}';}
						}
					}
				},
				name: {maxlength: 20},
				phone: {maxlength: 30},
				remarks: {maxlength: 200}
			},
			messages: {
				mobile: {
					maxlength: "手机号不能超过30个字符", 
					remote: "手机号已存在"},
				
				name: {
					required: "请输入姓名", 
					maxlength: "姓名不能超过20个字符"},
				phone: {maxlength: "电话不能超过30个字符"},
				email: {
					required: "请输入邮箱", 
					maxlength: "邮箱不能超过50个字符", 
					remote: "邮箱已存在"},
				remarks: {maxlength: "备注不能超过200个字符"}
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
		<li class="active"><a href="${ctx}/sys/user/info">个人信息</a></li>
		<%-- <li><a href="${ctx}/sys/user/modifyPwd">修改密码</a></li> --%>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="user" action="${ctx}/sys/user/info" method="post" class="form-horizontal"><%--
		<form:hidden path="email" htmlEscape="false" maxlength="255" class="input-xlarge"/>
		<sys:ckfinder input="email" type="files" uploadPath="/mytask" selectMultiple="false"/> --%>
		<sys:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">头像:</label>
			<div class="controls">
				<form:hidden id="nameImage" path="photo" htmlEscape="false" maxlength="255" class="input-xlarge"/>
				<sys:ckfinder input="nameImage" type="images" uploadPath="/photo" selectMultiple="false" maxWidth="100" maxHeight="100"/>
				<span class="help-inline">双击选择头像。</span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">归属公司:</label>
			<div class="controls">
				<label class="lbl">${user.company.name}</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">归属部门:</label>
			<div class="controls">
				<label class="lbl">${user.office.name}</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">姓名:</label>
			<div class="controls">
				<form:input path="name" htmlEscape="false" maxlength="20" class="required" readonly="true"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">邮箱:</label>
			<div class="controls">
				<form:input path="email" htmlEscape="false" maxlength="51" minlength="5" class="required email"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">电话:</label>
			<div class="controls">
				<form:input path="phone" htmlEscape="false" maxlength="31"  class="simplePhone"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">手机:</label>
			<div class="controls">
				<form:input path="mobile" htmlEscape="false" maxlength="31" class="mobile"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注:</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="3" maxlength="201" class="input-xlarge remarks"/>
			</div>
		</div>
		<%-- <div class="control-group">
			<label class="control-label">用户类型:</label>
			<div class="controls">
				<label class="lbl">${fns:getDictLabel(user.userType, 'sys_user_type', '无')}</label>
			</div>
		</div> --%>
		<div class="control-group">
			<label class="control-label">用户角色:</label>
			<div class="controls">
				<label class="lbl">${user.roleNames}</label>
			</div>
		</div>
		<div class="control-group">
			<%-- <label class="control-label">上次登录:</label>
			<div class="controls">
				<label class="lbl">IP: ${user.oldLoginIp}&nbsp;&nbsp;&nbsp;&nbsp;时间：<fmt:formatDate value="${user.oldLoginDate}" type="both" dateStyle="full"/></label>
			</div> --%>
		</div>
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>
		</div>
	</form:form>
</body>
</html>