<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>菜单管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#name").focus();
			$("#inputForm").validate({
				rules: {
					name:{
						 required:true,
						 maxlength: 16
					},
					href:{
						 maxlength: 200
					},
					sort:{
						 required:true,
						 maxlength: 9
					},
					remarks:{
						 maxlength: 200
					},
					resourceType:{
						 required:true,
					},
					gnTabSystem:{
						 required:true,
					}
					
				},
				messages:{
					name:{
						 required:"请输入名称",
						 maxlength: "名称字段不能超过16个字符"
					},
					href:{
						 maxlength: "链接字段不能超过200个字符"
					},
					sort:{
						 required:"请输入排序编号",
						 maxlength: "排序字段不能超过9个字符"
					},
					remarks:{
						 maxlength: "备注字段不能超过200个字符"
					},
					resourceType:{
						required:"请选择资源类型"
					},
					gnTabSystem:{
						required:"请选择所属应用"
					}
				},
				submitHandler: function(form){
					$('#btnSubmit').attr('disabled', true);
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
		<li><a href="${ctx}/sys/menu/page">菜单列表</a></li>
		<li class="active"><a href="${ctx}/sys/menu/form?id=${menu.id}&parent.id=${menu.parent.id}">菜单<shiro:hasPermission name="sys:menu:edit">${not empty menu.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="sys:menu:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="menu" action="${ctx}/sys/menu/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">上级菜单:</label>
			<div class="controls">
                <sys:treeselect id="menu" name="parent.id" value="${menu.parent.id}" labelName="parent.name" labelValue="${menu.parent.name}"
					title="菜单" url="/sys/menu/treeData" notAllowSelectfourmenu="true" cssClass="required" dataMsgRequired="请选择上级菜单"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">名称:</label>
			<div class="controls">
				<form:input path="name" htmlEscape="false" maxlength="17" class="menuName"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">所属应用:</label>
			<div class="controls">
				<form:select path="gnTabSystem" class="input-xlarge">
				
					<form:option value="" label=""/>
					<form:options items="${tableList}" itemLabel="systemName" itemValue="id" htmlEscape="false"/>
				</form:select>
				<span class="help-inline"><font color="red">*</font> </span>
				<span class="help-inline">生成的数据表，一对多情况下请选择主表。</span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">资源类型:</label>
			<div class="controls">
				<form:radiobuttons path="resourceType" items="${fns:getDictList('resource_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				<span class="help-inline"><font color="red">*</font> </span>
				<span class="help-inline">该资源属于菜单资源或是集成入口资源</span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">链接:</label>
			<div class="controls">
				<form:input path="href" htmlEscape="false" maxlength="201"  class="input-xxlarge"/>
				<span class="help-inline">点击菜单跳转的页面</span>
			</div>
		</div>
		<!-- <div class="control-group">
			<label class="control-label">目标:</label>
			<div class="controls">
				<form:input path="target" htmlEscape="false" maxlength="10" class="input-small"/>
				<span class="help-inline">链接地址打开的目标窗口，默认：mainFrame</span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">图标:</label>
			<div class="controls">
				<sys:iconselect id="icon" name="icon" value="${menu.icon}"/>
			</div>
		</div>-->
		<div class="control-group">
			<label class="control-label">排序:</label>
			<div class="controls">
				<form:input path="sort" htmlEscape="false" maxlength="10" class="required digits input-small"/>
				<span class="help-inline"><font color="red">*</font> 排列顺序，升序,默认值30。</span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">可见:</label>
			<div class="controls">
				<form:radiobuttons path="isShow" items="${fns:getDictList('show_hide')}" itemLabel="label" itemValue="value" htmlEscape="false" class="required"/>
				<span class="help-inline">该菜单或操作是否显示</span>
			</div>
		</div> 
<%-- 		 <div class="control-group">
			<label class="control-label">权限标识:</label>
			<div class="controls">
				<form:input path="permission" htmlEscape="false" maxlength="100" class="input-xxlarge"/>
				<span class="help-inline">控制器中定义的权限标识，如：@RequiresPermissions("权限标识")</span>
			</div>
		</div> --%>
		<div class="control-group">
			<label class="control-label">备注:</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="3" maxlength="201" class="input-xlarge remarks"/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="sys:menu:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="javascript:window.location.href='${ctx}/sys/menu/page/'"/>
		</div>
	</form:form>
</body>
</html>