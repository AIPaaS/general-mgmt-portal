<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>菜单管理</title>
	<meta name="decorator" content="mgmt"/>
	<script type="text/javascript">
	function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
	    	return false;
	    }
    	function updateSort() {
			loading('正在提交，请稍等...');
	    	$("#listForm").attr("action", "${ctx}/sys/menu/updateSort");
	    	$("#listForm").submit();
    	}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/sys/menu/">菜单列表</a></li>
		<shiro:hasPermission name="sys:menu:edit"><li><a href="${ctx}/sys/menu/form">菜单添加</a></li></shiro:hasPermission>
	</ul>
	<sys:message content="${message}"/>
	
	 <!--框架标签结束-->
      <div class="row"><!--外围框架-->
     	<div class="col-lg-12"><!--删格化-->
             <div class="row"><!--内侧框架-->
	                 <div class="col-lg-12"><!--删格化-->
	                    <div class="main-box clearfix"><!--白色背景-->
	                    	<!--查询条件-->
	                    	<form:form id="searchForm" action="${ctx}/sys/menu/page/" method="post" class="breadcrumb form-search">
	                    	  <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
							  <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
	                    	  <div class="form-label form-group">
					           	<ul>
					                <li class="col-md-6">
					                    <p class="word">菜单名称</p>
					                    <p><input id="name" name="name" type="text" class="int-text int-medium" value="${menu.name}"></p>
					                </li>
					                <li class="width-xlag">
					                	<p class="word">&nbsp;</p>
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
	
	<!-- 查询结果开始 -->
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
                                    <table class="table table-hover table-border table-bordered">
                                        <thead><tr><th>名称</th><th>链接</th><th style="text-align:center;">排序</th><th>可见</th><th>权限标识</th><shiro:hasPermission name="sys:menu:edit"><th>操作</th></shiro:hasPermission></tr></thead>
                                     <tbody>
                                     	<c:forEach items="${page.list}" var="menu">
										<tr id="${menu.id}" pId="${menu.parent.id ne '1'?menu.parent.id:'0'}">
											<td nowrap><i class="icon-${not empty menu.icon?menu.icon:' hide'}"></i><a href="${ctx}/sys/menu/form?id=${menu.id}">${menu.name}</a></td>
											<td title="${menu.href}">${fns:abbr(menu.href,30)}</td>
											<td style="text-align:center;">
												<shiro:hasPermission name="sys:menu:edit">
													<input type="hidden" name="ids" value="${menu.id}"/>
													<input name="sorts" type="text" value="${menu.sort}" style="width:50px;margin:0;padding:0;text-align:center;">
												</shiro:hasPermission><shiro:lacksPermission name="sys:menu:edit">
													${menu.sort}
												</shiro:lacksPermission>
											</td>
											<td>${menu.isShow eq '1'?'显示':'隐藏'}</td>
											<td title="${menu.permission}">${fns:abbr(menu.permission,30)}</td>
											<shiro:hasPermission name="sys:menu:edit"><td nowrap>
												<a href="${ctx}/sys/menu/form?id=${menu.id}">修改</a>
												<a href="${ctx}/sys/menu/delete?id=${menu.id}" onclick="return confirmx('要删除该菜单及所有子菜单项吗？', this.href)">删除</a>
												<a href="${ctx}/sys/menu/form?parent.id=${menu.id}">添加下级菜单</a> 
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