<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>登录信息管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#no").focus();
			$("#btnSubmit").click(function(){
				var beginDate=$("#effectiveDate").val();  
				 var endDate=$("#expiryDate").val();  
				 var d1 = new Date(beginDate.replace(/\-/g, "\/"));  
				 var d2 = new Date(endDate.replace(/\-/g, "\/"));  
				 if(d1>=d2){
					 alert("失效时间要大于生效时间");
					 return false;
				 }
				 
				 var confirmNewPassword=$("#confirmNewPassword").val();  
				 var newPassword=$("#newPassword").val();  
				 if(newPassword.indexOf(" ") != -1 || newPassword.indexOf(" ")==''){
					 alert("密码不能包含空格");
					 return false;
				 }
				 if(confirmNewPassword.indexOf(" ") != -1 || confirmNewPassword.indexOf(" ") ==''){
					 alert("确认密码不能包含空格");
					 return false;
				 }
				 
				 
			});
			$("#inputForm").validate({
				rules: {
					loginName: {remote: "${ctx}/sys/user/checkLoginName?oldLoginName=" + encodeURIComponent('${user.loginName}')}
				},
				messages: {
					loginName: {remote: "用户登录名已存在"},
					confirmNewPassword: {equalTo: "输入与上面相同的密码"}
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
		<li><a href="${ctx}/sys/user/listno">账号列表</a></li>
		<li class="active"><a href="${ctx}/sys/user/formno?id=${user.id}">账号<shiro:hasPermission name="sys:user:edit">${not empty user.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="sys:user:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="user" action="${ctx}/sys/user/saveno" method="post" class="form-horizontal">
		
		<sys:message content="${message}"/>
<%-- 		<div class="control-group">
			<label class="control-label">头像:</label>
			<div class="controls">
				<form:hidden id="nameImage" path="photo" htmlEscape="false" maxlength="255" class="input-xlarge"/>
				<sys:ckfinder input="nameImage" type="images" uploadPath="/photo" selectMultiple="false" maxWidth="100" maxHeight="100"/>
			</div>
		</div> --%>
	<%-- 	<div class="control-group">
			<label class="control-label">归属公司:</label>
			<div class="controls">
			<form:hidden path="company.id" htmlEscape="false" readonly="true" maxlength="50" class="required"/>
               
			</div>
		</div> --%>
<%-- 		<div class="control-group">
			<label class="control-label">归属部门:</label>
			<div class="controls">
			<form:hidden path="office.id" htmlEscape="false" readonly="true" maxlength="50" class="required"/>
              
			</div>
		</div> --%>
	
<%-- 		<div class="control-group">
			<label class="control-label">工号:</label>
			<div class="controls">
				<form:input path="no" htmlEscape="false" readonly="true" maxlength="50" class="required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div> --%>
		<div class="control-group">
			<label class="control-label">选择员工:</label>
			<div class="controls">
				<form:select path="id" class="required input-xlarge">
					<form:option value="" label="${productName}"/>
					<form:options items="${userList}" itemLabel="name" itemValue="id" htmlEscape="false"/>
				</form:select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">登录名:</label>
			<div class="controls">
				<input id="oldLoginName" name="oldLoginName" type="hidden" value="${user.loginName}">
				<form:input path="loginName" htmlEscape="false" maxlength="20" class="required username"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">密码:</label>
			<div class="controls">
				<input id="newPassword" name="newPassword" type="password" onpaste="return false" value="" maxlength="50" minlength="3" class="${empty user.id?'required':''} "/>
				<c:if test="${empty user.id}"><span class="help-inline"><font color="red">*</font> </span></c:if>
				<c:if test="${not empty user.id}"><span class="help-inline">若不修改密码，请留空。</span></c:if>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">确认密码:</label>
			<div class="controls">
				<input id="confirmNewPassword" name="confirmNewPassword" onpaste="return false" type="password" value="" maxlength="50" minlength="3" equalTo="#newPassword" />
				<c:if test="${empty user.id}"><span class="help-inline"><font color="red">*</font> </span></c:if>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">邮箱:</label>
			<div class="controls">
				<form:input path="email" htmlEscape="false" maxlength="25" minlength="5" class="required email"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
<%-- 		<div class="control-group">
			<label class="control-label">电话:</label>
			<div class="controls">
				<form:input path="phone" htmlEscape="false" maxlength="100"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">手机:</label>
			<div class="controls">
				<form:input path="mobile" htmlEscape="false" maxlength="100"/>
			</div>
		</div> --%>
		<div class="control-group">
			<label class="control-label">是否允许登录:</label>
			<div class="controls">
				<form:select path="loginFlag">
					<form:options items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
				<span class="help-inline"><font color="red">*</font> “是”代表此账号允许登录，“否”则表示此账号不允许登录</span>
			</div>
		</div>
<%-- 		<div class="control-group">
			<label class="control-label">账号类型:</label>
			<div class="controls">
				<form:select path="userType" class="input-xlarge">
					<form:option value="" label="请选择"/>
					<form:options items="${fns:getDictList('sys_user_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div> --%>
		<div class="control-group">
			<label class="control-label">账号角色:</label>
			<div class="controls">
				<form:checkboxes path="roleIdList" items="${allRoles}" itemLabel="name" itemValue="id" htmlEscape="false" class="required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
<%-- 		<div class="control-group">
			<label class="control-label">备注:</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="3" maxlength="200" class="input-xlarge"/>
			</div>
		</div> --%>
			<div class="control-group">
				<label class="control-label">生效时间:</label>
				<div class="controls">
					<label class="lbl"><input id="effectiveDate" name="effectiveDate" type="text" readonly="readonly" maxlength="30" class="input Wdate" value="<fmt:formatDate value="${user.effectiveDate}" type="both"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/></label>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">失效时间:</label>
				<div class="controls">
					<label class="lbl"><input id="expiryDate" name="expiryDate"  type="text" readonly="readonly" maxlength="30" class="input Wdate" value="<fmt:formatDate value="${user.expiryDate}" type="both"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/></label>
				</div>
			</div>
		<c:if test="${not empty user.id}">
			
			<div class="control-group">
				<label class="control-label">最后登陆:</label>
				<div class="controls">
					<label class="lbl">IP: ${user.loginIp}&nbsp;&nbsp;&nbsp;&nbsp;时间：<fmt:formatDate value="${user.loginDate}" type="both" dateStyle="full"/></label>
				</div>
			</div>
		</c:if>
		<div class="form-actions">
			<shiro:hasPermission name="sys:user:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>