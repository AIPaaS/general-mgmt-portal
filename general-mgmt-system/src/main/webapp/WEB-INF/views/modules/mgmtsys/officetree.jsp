<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/WEB-INF/views/include/taglib.jsp"%>
    <%@include file="/WEB-INF/views/include/treeview.jsp" %>

</head>
<body>
<ul id="treeDemo" class="ztree"></ul>
<input type="hidden" id="selectOfficeId" value=""/>
<input type="hidden" id="selectOfficeCode" value=""/>
<input type="hidden" id="selectOfficeName" value=""/>
<input type="hidden" id="selectOfficePid" value=""/>
<script>
    
    var setting = {data:{simpleData:{enable:true,idKey:"id",pIdKey:"pId",rootPId:'0'}},
    		callback: {
                onClick: function (event, treeId, treeNode) {
                    $("#selectOfficeId").val(treeNode.id);
                    $("#selectOfficeCode").val(treeNode.code);
                    $("#selectOfficeName").val(treeNode.name);
                    $("#selectOfficePid").val(treeNode.pId);
                }
            },
    };
	$.getJSON("${ctx}/sys/office/treeData",function(data){
		$.fn.zTree.init($("#treeDemo"), setting, data).expandAll(true);
	});

</script>
</body>
</html>