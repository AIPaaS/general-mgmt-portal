<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>机构管理</title>
	<meta name="decorator" content="mgmt"/>
	<script src="${ctxStatic}/jquery/jquery-1.8.3.min.js" type="text/javascript"></script>
   <script src="${ctxStatic}/bootstrap/2.3.1/js/bootstrap.min.js" type="text/javascript"></script>
   <link href="${ctxStatic}/common/jeesite.css" type="text/css" rel="stylesheet" />
	<script src="${mgmtStatic}/bootbox/bootbox.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#name").focus();
			$("#inputForm").validate({
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




  <!--框架标签结束-->
      <div class="row"><!--外围框架-->
     	<div class="col-lg-12"><!--删格化-->
             <div class="row"><!--内侧框架-->
	                 <div class="col-lg-12"><!--删格化-->
	                    <div class="main-box clearfix"><!--白色背景-->
	                    	<!--查询条件-->
	                    <form:form id="inputForm" modelAttribute="office" action="${ctx}/sys/office/save" method="post" class="form-horizontal">
	                    	<div class="form-label big-form-label">
					           	<ul>
					                <li  class="col-md-6">
					                    <p class="word"><span>*</span>上级机构</p>
					                    <p>
					                    	<input type="text" class="int-text int-medium" id="parentName" readonly onclick="showParentTree()" value="${office.parentId}">
					                     	<input type="hidden" id="parentId" name="parentId"/>
					                    </p>
					                </li>  
					                <li class="col-md-6">
					                    <p class="word"><span>*</span>归属地区</p>
					                    <p>
					                    	<input type="text" class="int-text int-medium" id="areaName" readonly onclick="showAreaTree()" value="${office.area.name}"></p>
					                     	<input type="hidden" id="area.id" name="area.id"/>
					                     	<input type="hidden" id="area.code" name="area.code"/>
					                    </p>
					                </li>
					            </ul> 
					            <ul>
					                <li class="col-md-6">
					                    <p class="word"><span>*</span>机构名称</p>
					                    <p><input type="text" class="int-text int-medium" id="name" name="name" value="${office.name}"></p>
					                </li>
					                <li class="col-md-6">
					                    <p class="word"><span>*</span>机构编码</p>
					                    <p><input type="text" class="int-text int-medium" id="code" name="code" value="${office.code}"></p>
					                </li>
					            </ul> 
					            <ul>
					                <li class="col-md-6">
					                    <p class="word"><span>*</span>机构类型:</p>
					                    <p>
					                    	<form:select path="type" class="int-text int-medium">
												<form:options items="${fns:getDictList('sys_office_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
											</form:select>
					                    </p>
					                </li>
					                <li  class="col-md-6">
					                    <p class="word"><span>*</span>机构级别：</p>
					                    <p>
						                    <form:select path="grade" class="int-text int-medium">
												<form:options items="${fns:getDictList('sys_office_grade')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
											</form:select>
					                    </p>
					                </li>  
					            </ul> 
					            <ul>
					                <li class="col-md-6">
					                    <p class="word">是否可用</p>
					                    <p>
						                    <form:select path="useable" class="int-text int-medium">
												<form:options items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
											</form:select>
					                    </p>
					                </li>
					                 <li  class="col-md-6">
					                    <p class="word">联系地址</p>
					                    <p><input type="text" class="int-text int-large" id="address" name="address" value="${office.address}"></p>
					                </li>  
					            </ul> 
					            <ul>
					                <li class="col-md-6">
					                    <p class="word">邮政编码</p>
					                    <p><input type="text" class="int-text int-medium"></p>
					                </li>
					                <li  class="col-md-6">
					                    <p class="word">负责人</p>
					                    <p><input type="text" class="int-text int-large"></p>
					                </li>  
					            </ul> 
					            <ul>
					                <li class="col-md-6">
					                    <p class="word">联系电话</p>
					                    <p><input type="text" class="int-text int-medium"></p>
					                </li>
					                <li  class="col-md-6">
					                    <p class="word">联系地址</p>
					                    <p><input type="text" class="int-text int-large"></p>
					                </li>  
					            </ul>
					            <ul>
					                <li class="col-md-6">
					                    <p class="word">邮箱</p>
					                    <p>
					                    	<form:input path="email" class="int-text int-medium" htmlEscape="false" maxlength="50"/>
					                   </p>
					                </li>
					                <li  class="col-md-6">
					                    <p class="word">备注</p>
					                    <p><input type="text" class="int-text int-large"></p>
					                </li>  
					            </ul>  
								<ul>
					                <li class="width-xlag">
					                <p class="word">&nbsp;</p>
					                <p>
					                	<shiro:hasPermission name="sys:office:edit"><input id="btnSubmit" class="biu-btn  btn-primary btn-blue btn-small ml-15 radius" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
					                <p>
					                	<input id="btnCancel" class="biu-btn  btn-primary btn-blue btn-small ml-15 radius" type="button" value="返 回" onclick="history.go(-1)"/>
					                </p>
					                </li>
					            </ul>
					         </div>
					       </form:form>
					   	<!--查询结束-->      
	         			</div>
	                </div>
              </div>
         </div>
     </div>	
     <script>
     function showParentTree() {
        $.get('${ctx}/sys/office/treePage', function (data) {
            var options={
            		title : "机构",
    				message : data,
    				callback:function () {
    					 var parentName = $("#selectOfficeName").val();
	                     $("#parentName").val(parentName);
	                     var officePId = $("#selectOfficePid").val();
	                     $("#parentId").val(officePId);
                    },
                    buttons:{
                    	ok:{
                    		label:'确定'
                    	}
                    }
            };
            bootbox.alert(options);
            
        });
    }
     function showAreaTree() {
         $.get('${ctx}/sys/area/areaTree', function (data) {
             var options={
             		title : "机构",
     				message : data,
     				callback:function () {
     					 var areaName = $("#selectAreaName").val();
 	                     $("#areaName").val(areaName);
 	                     var areaId = $("#selectAreaId").val();
 	                     $("#area.id").val(areaId);
                     },
                     buttons:{
                     	ok:{
                     		label:'确定'
                     	}
                     }
             };
             bootbox.alert(options);
             
         });
     }
	</script>
</body>
</html>