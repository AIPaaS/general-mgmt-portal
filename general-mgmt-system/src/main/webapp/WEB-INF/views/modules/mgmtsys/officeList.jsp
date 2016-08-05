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
		function page(n,s){
				$("#pageNo").val(n);
				$("#pageSize").val(s);
				$("#searchForm").submit();
		    	return false;
		    }
		$(document).ready(function(){
			var a = $("#searchName").val();//取出值
			 $("#officetName").val(a);
		});
	</script>
</head>
<body>
	<sys:message content="${message}"/>
	<!-- ceshi -->
	<input type="hidden" name="searchName" id="searchName" value="${requestScope.searchName}"/>
		  <!--框架标签结束-->
      <div class="row"><!--外围框架-->
     	<div class="col-lg-12"><!--删格化-->
             <div class="row"><!--内侧框架-->
	                 <div class="col-lg-12"><!--删格化-->
	                    <div class="main-box clearfix"><!--白色背景-->
	                    	<!--查询条件-->
	                    	<form:form id="searchForm" action="${ctx}/sys/office/page/" method="post" class="breadcrumb form-search">
							<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
							<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
	                    		 <div class="form-label form-group">
					            <ul>
					                 <li class="col-md-6">
					                    <p class="word">机构名称</p>
					                  <p>
					                  <input type="text" id="officetName" class="int-text int-medium" readonly onclick="showTree()"></p>
					                  <input type="hidden" id="id" name="id"/>
					                </li>
					                 <li class="width-xlag">
					                <p><input id="btnSubmit" type="submit" class="biu-btn  btn-primary btn-blue btn-large ml-15" value="查  询"></p>
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
	<!--  -->
	
	<!--  -->
	  <!--框架标签结束-->
  		  <div class="row"><!--外围框架-->
            <div class="col-lg-12"><!--删格化-->
                <div class="row"><!--内侧框架-->
                    <div class="col-lg-12"><!--删格化-->
                        <div class="main-box clearfix"><!--白色背景-->
                      <!--标题-->
                            <header class="main-box-header clearfix">
                            <h2 class="pull-left">查询结果</h2>
                            </header>
                        <!--标题结束-->
                          	<div class="row"><!--删格化-->
		                         <p class="right pr-30">
		                         <shiro:hasPermission name="sys:office:edit">
			                         <a href="${ctx}/sys/office/add?parent.id=${office.id}">
			                         	<input type="button" class="biu-btn  btn-primary btn-blue btn-auto  ml-5" value="新  增">
			                         </a>
		                         </shiro:hasPermission>
		                         </p>
                        	</div>  
                            <div class="main-box-body clearfix">
                            	<!--table表格-->
                                <div class="table-responsive clearfix">
                                    <table id="contentTable" class="table table-hover table-border table-bordered">
                                        <thead>
                                            <tr>
                                                <th>机构名称</th>
                                                <th>归属地区</th>
                                                <th>机构编码</th>
                                                <th>机构类型</th>
                                                <th>备注</th>
                                                <th>操作</th>
                                            </tr>
                                        </thead>
                                  <c:forEach items="${page.list}" var="office">
									<tr>
										<td><a href="${ctx}/sys/office/add?id={{office.id}}">${office.name}</a></td>
										<td>${office.area.name}</td>
										<td>${office.code}</td>
										<td>${office.type}</td>
										<td>${office.remarks}</td>
										<shiro:hasPermission name="sys:office:edit"><td>
											<a href="${ctx}/sys/office/form?id=${office.id}">修改</a>
											<a href="${ctx}/sys/office/delete?id=${office.id}" onclick="return confirmx('要删除该机构及所有子机构项吗？', this.href)">删除</a>
											<a href="${ctx}/sys/office/form?parent.id=${office.id}">添加下级机构</a> 
										</td></shiro:hasPermission>
									</tr>
	   							</c:forEach>
                             </table>
                                </div>
                             <!--/table表格结束-->
                                	 <!--分页-->
								<div class="paging">${page}</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
    	</div>
	<script>
	
	/* function showTree(){
		var setting = {data:{simpleData:{enable:true,idKey:"id",pIdKey:"pId",rootPId:'0'}},
		};
		$.getJSON("${ctx}/sys/office/treeData",function(data){
			$.fn.zTree.init($("#ztree"), setting, data).expandAll(true);
		});
	} */
	function showTree() {
        $.get('${ctx}/sys/office/treePage', function (data) {
            var options={
            		title : "机构",
    				message : data,
    				callback:function () {
    					 var officeName = $("#selectOfficeName").val();
	                     $("#officetName").val(officeName);
	                     var officeId = $("#selectOfficeId").val();
	                     $("#id").val(officeId);
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