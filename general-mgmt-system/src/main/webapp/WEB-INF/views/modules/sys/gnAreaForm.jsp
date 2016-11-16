<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>区域信息管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
	

	
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				rules: {
					areaCode:{
						 required:true,
						 maxlength: 10
					},
					areaName:{
						required:true,
						maxlength: 16
					},
					sortId:{
						
						maxlength: 5
					},
					remark:{
						
						maxlength: 100
					}
				},
				messages:{
					areaCode:{
						 required:"请输入区域编码", 
						 maxlength: "区域编码长度不能超过10个字符"
					},
					areaName:{
						required: "请输入区域名称", 
						maxlength: "区域名称不能超过16个字符"
					},
					sortId:{
						required: "请输入排序", 
						maxlength: "排序长度不能超过5个字符" 
					},
					remark:{
						
						maxlength: "备注长度不能超过100个字符"
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
		<li><a href="${ctx}/sys/gnArea/">区域信息列表</a></li>
		<li class="active"><a href="${ctx}/sys/gnArea/form?id=${gnArea.id}">区域信息<shiro:hasPermission name="sys:gnArea:edit">${not empty gnArea.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="sys:gnArea:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="gnArea" action="${ctx}/sys/gnArea/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">区域编码：</label>
			<div class="controls">
				<form:input path="areaCode" htmlEscape="false" maxlength="11" class="input-xlarge required digits"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">区域名称：</label>
			<div class="controls">
				<form:input path="areaName" htmlEscape="false" maxlength="17" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="parentAreaCode">所属区域：</label>
			<div class="controls">
			
				<c:set var="parentAreaCode" value="${gnArea.parentAreaCode}"/>
			 <sys:treeasync id="parentAreaCode" name="parentAreaCode" value="${gnArea.parentAreaCode}" labelName="${fns:getAreaName(parentAreaCode)}" labelValue="${fns:getAreaName(parentAreaCode)}"
				title="区域" url="/sys/gnArea/treeData?type=2" selectgnArea="true" cssClass="required" dataMsgRequired="请选择所属区域"/>
			<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>		
		<div class="control-group">
			<label class="control-label">排序：</label>
			<div class="controls">
				<form:input path="sortId" htmlEscape="false" maxlength="6" class="input-xlarge required digits"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group" hidden="true">
			<label class="control-label">状态：</label>
			<div class="controls">
				<form:select path="state" class="input-medium">
					<form:options items="${fns:getDictList('gn_area_state')}" itemLabel="label" itemValue="value" htmlEscape="false" />
				</form:select>	
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注：</label>
			<div class="controls">
				<form:textarea path="remark" htmlEscape="false" rows="3" maxlength="101" class="input-xlarge"/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="sys:gnArea:edit">
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
			</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>