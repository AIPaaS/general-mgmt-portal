<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>权限管理</title>
	<meta name="decorator" content="mgmt"/>
	<script type="text/javascript">
		function page(n,s){
				$("#pageNo").val(n);
				$("#pageSize").val(s);
				$("#searchForm").submit();
		    	return false;
		    }
	</script>
</head>
<body>
	<sys:message content="${message}"/>
     <form:form id="searchForm" action="${ctx}/sys/role/mgmtlist" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		
		<!--框架标签结束-->
      <div class="row"><!--外围框架-->
     	<div class="col-lg-12"><!--删格化-->
             <div class="row"><!--内侧框架-->
	                 <div class="col-lg-12"><!--删格化-->
	                    <div class="main-box clearfix"><!--白色背景-->
	                    	<!--查询条件-->
	                    		 <div class="form-label">
					           	<ul>
					                <li class="col-md-6">
					                    <p class="word">角色名称</p>
					                    <p><input id="name" name="name" type="text" class="int-text int-medium" value="${role.name}"></p>
					                </li>
					                <li  class="col-md-6">
					                    <p class="word">英文名称</p>
					                    <p><input id="enname" name="enname" type="text" class="int-text int-medium" value="${role.enname}"></p>
					                </li>  
					            </ul> 
					           
								<ul>
					                <li class="width-xlag">
					                <p class="word">&nbsp;</p>
					                <p><input id="btnSubmit" type="submit" class="biu-btn  btn-primary btn-blue btn-large ml-15" value="查  询"></p>
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
	<sys:message content="${message}"/>
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
                        <!-- 按钮 -->
                        <div class="row"><!--删格化-->
                         <p class="right pr-30">
                         	<input type="button" class="biu-btn  btn-primary btn-blue btn-auto  ml-5" value="赋菜单权限">
                         </p>
                        </div>
                        <!-- 按钮结束 -->  
                            <div class="main-box-body clearfix">
                            	<!--table表格-->
                                <div class="table-responsive clearfix">
                                    <table id="contentTable" class="table table-hover table-border table-bordered">
                                        <thead>
                                            <tr>
                                            	<th>选择</th>
                                                <th>角色名称</th>
                                                <th>英文名称</th>
                                                <th>归属机构</th>
                                                <th>数据范围</th>
                                            </tr>
                                        </thead>
                                    <tbody>
                                       <c:forEach items="${rolepage.list}" var="role">
											<tr>
												<td><input type="radio"></td>
												<td><a href="form?id=${role.id}">${role.name}</a></td>
												<td><a href="form?id=${role.id}">${role.enname}</a></td>
												<td>${role.office.name}</td>
												<td>${fns:getDictLabel(role.dataScope, 'sys_data_scope', '无')}</td>
											</tr>
										</c:forEach>
                                    </tbody>
                                    </table>
                                </div>
                                	<!--/table表格结束-->
                                <!--分页-->
                                <div class="paging">${page}</div>
								<!--分页结束-->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
    </div>
    
    
</body>
</html>