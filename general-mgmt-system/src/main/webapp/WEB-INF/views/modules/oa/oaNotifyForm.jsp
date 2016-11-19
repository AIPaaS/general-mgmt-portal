<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>站内信</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				rules: {
					
					title:{
						required:true,
						maxlength: 20
					},
					content:{
						required:true,
						maxlength: 225
					},
					oaNotifyRecordName:{
						required:true
					}
				},
				messages:{
					
					title:{
						required: "请输入标题", 
						maxlength: "标题长度不能超过20个字符", 
					},
					content:{
						required: "请输入内容", 
						maxlength: "内容不能超过225个字符", 
					},
					status:{required:"请选择状态"},
					type:{required:"请选择类型"}
				},
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if(element.attr("name")=="oaNotifyRecordName"){
						$("#treeerro").find("label").remove(); 
						$("<label for='oaNotifyRecordName' class='error'>请选择接收人</label>").appendTo("#treeerro");
					}else if (element.is(":radio")){
						$("#treeerro").find("label").remove();
						error.appendTo(element.parent().parent());
					}else {
						$("#treeerro").find("label").remove();
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/oa/oaNotify/">站内信</a></li>
		<li class="active"><a href="${ctx}/oa/oaNotify/form?id=${oaNotify.id}">站内信<shiro:hasPermission name="oa:oaNotify:edit">${oaNotify.status eq '1' ? '查看' : not empty oaNotify.id ? '修改' : '添加'}</shiro:hasPermission><shiro:lacksPermission name="oa:oaNotify:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="oaNotify" action="${ctx}/oa/oaNotify/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>	
		<div class="control-group">
			<label class="control-label">类型：</label>
			<div class="controls">
			<c:if test="${not empty oaNotify.id && oaNotify.status eq '1'}">
				<c:set var="disabled" value="true"/>
			</c:if>
				<form:select path="type" class="input-xlarge required" disabled="${disabled}">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('oa_notify_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>	
		<div class="control-group">
			<label class="control-label">标题：</label>
			<div class="controls">
				<form:input path="title" htmlEscape="false" maxlength="21" disabled="${oaNotify.status eq '1' ? true : false}" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">内容：</label>
			<div class="controls">
				<form:textarea path="content" htmlEscape="false" maxlength="226" rows="6"  disabled="${oaNotify.status eq '1' ? true : false}" class="input-xxlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<c:if test="${oaNotify.status ne '1'}">
			<div class="control-group">
				<label class="control-label">附件：</label>
				<div class="controls">
					<form:hidden id="files" path="files" htmlEscape="false" maxlength="255" class="input-xlarge"/>
					<sys:ckfinder input="files" type="files" uploadPath="/oa/notify" selectMultiple="true"/>
					<span class="help-inline"> 最多不能超过三个附件,双击添加附件。</span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">状态：</label>
				<div class="controls">
					<form:radiobuttons path="status" items="${fns:getDictList('oa_notify_status')}" itemLabel="label" itemValue="value" htmlEscape="false" class="required"/>
					<span class="help-inline"><font color="red">*</font> 发布后不能进行操作。</span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">接受人：</label>
				<div class="controls">
	                <sys:usertree id="oaNotifyRecord" name="oaNotifyRecordIds" value="${oaNotify.oaNotifyRecordIds}" labelName="oaNotifyRecordName" labelValue="${oaNotify.oaNotifyRecordNames}"
						title="用户" url="/sys/user/treeAsnyData?type=2" cssClass="input-xxlarge" notAllowSelectParent="true" checked="true"/>
					<span id="treeerro" class="help-inline"><font color="red">*</font> </span>
				</div>
			</div>
		</c:if>
		<c:if test="${oaNotify.status eq '1'}">
			<div class="control-group">
				<label class="control-label">附件：</label>
				<div class="controls">
					<form:hidden id="files" path="files" htmlEscape="false" maxlength="255" class="input-xlarge"/>
					<sys:ckfinder input="files" type="files" uploadPath="/oa/notify" selectMultiple="true" readonly="true" />
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">接受人：</label>
				<div class="controls">
					<table id="contentTable" class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<th>接受人</th>
								<th>接受部门</th>
								<th>阅读状态</th>
								<th>阅读时间</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${oaNotify.oaNotifyRecordList}" var="oaNotifyRecord">
							<tr>
								<td>
									${oaNotifyRecord.user.name}
								</td>
								<td>
									${oaNotifyRecord.user.office.name}
								</td>
								<td>
									${fns:getDictLabel(oaNotifyRecord.readFlag, 'oa_notify_read', '')}
								</td>
								<td>
									<fmt:formatDate value="${oaNotifyRecord.readDate}" pattern="yyyy-MM-dd"/>
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
					已查阅：${oaNotify.readNum} &nbsp; 未查阅：${oaNotify.unReadNum} &nbsp; 总共：${oaNotify.readNum + oaNotify.unReadNum}
				</div>
			</div>
		</c:if>
		<div class="form-actions">
			<c:if test="${oaNotify.status ne '1'}">
				<shiro:hasPermission name="oa:oaNotify:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			</c:if>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>