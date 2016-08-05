<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/WEB-INF/views/include/taglib.jsp"%>
    <%@include file="/WEB-INF/views/include/treeview.jsp" %>
</head>
<body>
<ul id="treeDemo" class="ztree"></ul>
<input type="hidden" id="selectAreaId" value=""/>
<input type="hidden" id="selectAreaName" value=""/>
<script>
    
    var setting = {data:{simpleData:{enable:true,idKey:"id",pIdKey:"pId",rootPId:'0'}},
    		callback: {
                onClick: function (event, treeId, treeNode) {
                    $("#selectAreaId").val(treeNode.id);
                    $("#selectAreaName").val(treeNode.name);
                }
            },
    };
	$.getJSON("${ctx}/sys/area/treeData",function(data){
		$.fn.zTree.init($("#treeDemo"), setting, data).expandAll(true);
	});

</script>
</body>
</html>