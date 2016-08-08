<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>角色管理</title>
	<meta name="decorator" content="mgmt"/>
	<%@include file="/WEB-INF/views/include/treeview.jsp" %>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#name").focus();
			$("#inputForm").validate({
				rules: {
					name: {remote: "${ctx}/sys/role/checkName?oldName=" + encodeURIComponent("${role.name}")},
					enname: {remote: "${ctx}/sys/role/checkEnname?oldEnname=" + encodeURIComponent("${role.enname}")}
				},
				messages: {
					name: {remote: "角色名已存在"},
					enname: {remote: "英文名已存在"}
				},
				submitHandler: function(form){
					/* var ids = [], nodes = tree.getCheckedNodes(true);
					for(var i=0; i<nodes.length; i++) {
						ids.push(nodes[i].id);
					}
					$("#menuIds").val(ids); */
					var ids2 = [], nodes2 = tree2.getCheckedNodes(true);
					for(var i=0; i<nodes2.length; i++) {
						ids2.push(nodes2[i].id);
					}
					$("#officeIds").val(ids2);
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

			var setting = {check:{enable:true,nocheckInherit:true},view:{selectedMulti:false},
					data:{simpleData:{enable:true}},callback:{beforeClick:function(id, node){
						tree.checkNode(node, !node.checked, true, true);
						return false;
					}}};
			
			/* // 用户-菜单
			var zNodes=[
					<c:forEach items="${menuList}" var="menu">{id:"${menu.id}", pId:"${not empty menu.parent.id?menu.parent.id:0}", name:"${not empty menu.parent.id?menu.name:'权限列表'}"},
		            </c:forEach>];
			// 初始化树结构
			var tree = $.fn.zTree.init($("#menuTree"), setting, zNodes);
			// 不选择父节点
			tree.setting.check.chkboxType = { "Y" : "ps", "N" : "s" };
			// 默认选择节点
			var ids = "${role.menuIds}".split(",");
			for(var i=0; i<ids.length; i++) {
				var node = tree.getNodeByParam("id", ids[i]);
				try{tree.checkNode(node, true, false);}catch(e){}
			}
			// 默认展开全部节点
			tree.expandAll(true); */
			
			// 用户-机构
			var zNodes2=[
					<c:forEach items="${officeList}" var="office">{id:"${office.id}", pId:"${not empty office.parent?office.parent.id:0}", name:"${office.name}"},
		            </c:forEach>];
			// 初始化树结构
			var tree2 = $.fn.zTree.init($("#officeTree"), setting, zNodes2);
			// 不选择父节点
			tree2.setting.check.chkboxType = { "Y" : "ps", "N" : "s" };
			// 默认选择节点
			var ids2 = "${role.officeIds}".split(",");
			for(var i=0; i<ids2.length; i++) {
				var node = tree2.getNodeByParam("id", ids2[i]);
				try{tree2.checkNode(node, true, false);}catch(e){}
			}
			// 默认展开全部节点
			tree2.expandAll(true);
			// 刷新（显示/隐藏）机构
			refreshOfficeTree();
			$("#dataScope").change(function(){
				refreshOfficeTree();
			});
		});
		function refreshOfficeTree(){
			if($("#dataScope").val()==9){
				$("#officeTree").show();
			}else{
				$("#officeTree").hide();
			}
		}
	</script>
</head>
<body>
	<form:form id="inputForm" modelAttribute="role" action="${ctx}/sys/role/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>
		
		<!--框架标签结束-->
      <div class="row"><!--外围框架-->
     	<div class="col-lg-12"><!--删格化-->
             <div class="row"><!--内侧框架-->
	                 <div class="col-lg-12"><!--删格化-->
	                    <div class="main-box clearfix"><!--白色背景-->
	                    	<!--查询条件-->
	                    		<div class="form-label big-form-label">
					            <ul>
					            	<li class="col-md-6">
					                    <p class="word"><span>*</span>角色名称:</p>
					                    <p>
											<input id="name" name="name" type="text" class="int-text int-medium" value="${role.name}" htmlEscape="false" maxlength="50"/>
										</p>
					                </li>
					                <li class="col-md-6">
					                	<p class="word"><span>*</span>英文名称:</p>
					                	<p>
											<input id="enname" name="enname" type="text" class="int-text int-medium" value="${role.enname}" htmlEscape="false" maxlength="50"/>
										</p>
					                </li>
					            </ul>
					            <ul>
					            	<li class="col-md-6">
					                    <p class="word">归属机构:</p>
					                    <p><select id="office.id" name="office.id" value="${role.office.id}" class="select select-medium"></select></p>
					                </li>
					            	<li class="col-md-6">
					                    <p class="word">角色类型:</p>
										<p>
						                	<select id="roleType" name='roleType' value="${role.roleType}" class="select select-medium">
												<option value="assignment">任务分配</option>
												<option value="security-role">管理角色</option>
												<option value="user">普通角色</option>
											</select>
					                	</p>
					                </li>
					            </ul>
					            <ul>
					            	<li class="col-md-6">
					                	<p class="word">是否系统数据:</p>
					                	<p>
						                	<select id="sysData" name="sysData" value="${role.sysData}" class="select select-medium">
												<option value="1">是</option>
												<option value="0">否</option>
											</select>
					                	</p>
					                </li>
					            	<li class="col-md-6">
					                	<p class="word">是否可用:</p>
					                	<p>
						                	<select id="useable" name="useable" value="${role.useable}" class="select select-medium">
												<option value="1">是</option>
												<option value="0">否</option>
											</select>
										</p>
					                </li>
					            </ul>
					            <ul>
					            	<li class="col-md-6">
					                	<p class="word">数据范围:</p>
					                	<p>
						                	<select id="dataScope" name="dataScope" value="${role.dataScope }" class="select select-medium">
												<options items="${fns:getDictList('sys_data_scope')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
											</select>
										</p>
					                </li>
					            </ul>
					            <ul>
					            	<li class="col-md-6">
					                	<p class="word">备注:</p>
					                	<p>
						                	<textarea id="remarks" name="remarks" value="${role.remarks}" htmlEscape="false" rows="3" maxlength="200" class="input-xlarge"></textarea>				                	
										</p>
					                </li>
					            </ul>
								<ul>
					                <li class="width-xlag">
					                <p class="word">&nbsp;</p>
					                <c:if test="${(role.sysData eq fns:getDictValue('是', 'yes_no', '1') && fns:getUser().admin)||!(role.sysData eq fns:getDictValue('是', 'yes_no', '1'))}">
										<shiro:hasPermission name="sys:role:edit"><p><input id="btnSubmit" class="biu-btn  btn-primary btn-blue btn-small ml-15 radius" type="submit" value="保 存"/></p>&nbsp;</shiro:hasPermission>
									</c:if>
									<p><input id="btnCancel" class="biu-btn  btn-primary btn-blue btn-small ml-15 radius" type="button" value="返 回" onclick="history.go(-1)"/></p>
					                </li>
					            </ul>
					         </div>
					   	<!--查询结束-->      
	         			</div>
	                	</div>
              </div>
         </div>
     </div>	
     <!--框架标签结束-->
	</form:form>
</body>
</html>