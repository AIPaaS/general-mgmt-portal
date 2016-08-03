<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>角色管理</title>
	<meta name="decorator" content="mgmt"/>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/sys/role/">角色列表</a></li>
		<shiro:hasPermission name="sys:role:edit"><li><a href="${ctx}/sys/role/form">角色添加</a></li></shiro:hasPermission>
	</ul>
	<sys:message content="${message}"/>
     <form:form id="searchForm" action="${ctx}/sys/role/mgmtlist" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<div class="row"><!--外围框架-->
     	<div class="col-lg-12"><!--删格化-->
             <div class="row"><!--内侧框架-->
	                 <div class="col-lg-12"><!--删格化-->
	                    <div class="main-box clearfix"><!--白色背景-->
	                    	<!--查询条件-->
	                    		 <div class="form-label form-group">
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
                            <div class="main-box-body clearfix">
                            	<!--table表格-->
                                <div class="table-responsive clearfix">
                                    <table id="contentTable" class="table table-hover table-border table-bordered">
                                        <thead>
                                            <tr>
                                                <th>角色名称</th>
                                                <th>英文名称</th>
                                                <th>归属机构</th>
                                                <th>数据范围</th>
                                                <shiro:hasPermission name="sys:role:edit"><th>操作</th></shiro:hasPermission>
                                            </tr>
                                        </thead>
                                    <tbody>
                                       <c:forEach items="${page.list}" var="role">
											<tr>
												<td><a href="form?id=${role.id}">${role.name}</a></td>
												<td><a href="form?id=${role.id}">${role.enname}</a></td>
												<td>${role.office.name}</td>
												<td>${fns:getDictLabel(role.dataScope, 'sys_data_scope', '无')}</td>
												<shiro:hasPermission name="sys:role:edit"><td>
													<a href="${ctx}/sys/role/assign?id=${role.id}">分配</a>
													<c:if test="${(role.sysData eq fns:getDictValue('是', 'yes_no', '1') && fns:getUser().admin)||!(role.sysData eq fns:getDictValue('是', 'yes_no', '1'))}">
														<a href="${ctx}/sys/role/form?id=${role.id}">修改</a>
													</c:if>
													<a href="${ctx}/sys/role/delete?id=${role.id}" onclick="return confirmx('确认要删除该角色吗？', this.href)">删除</a>
												</td></shiro:hasPermission>	
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