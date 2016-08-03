<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<script src="${ctxStatic}/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script src="${ctxStatic}/bootstrap/2.3.1/js/bootstrap.min.js" type="text/javascript"></script>
<link href="${ctxStatic}/common/jeesite.css" type="text/css" rel="stylesheet" />	
	<title>日志管理</title>
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



  <!--框架标签结束-->
      <div class="row"><!--外围框架-->
     	<div class="col-lg-12"><!--删格化-->
             <div class="row"><!--内侧框架-->
	                 <div class="col-lg-12"><!--删格化-->
	                    <div class="main-box clearfix"><!--白色背景-->
	                    <form:form id="searchForm" action="${ctx}/sys/log/" method="post" class="breadcrumb form-search">
							<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
							<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
	                    	<!--查询条件-->
	                    		 <div class="form-label form-group">
					           	<ul>
					                <li class="col-md-6">
					                    <p class="word">操作菜单：</p>
					                    <p><input type="text" class="int-text int-medium" id="title" name="title" value="${log.title}"></p>
					                </li>
					                <li  class="col-md-6">
					                    <p class="word">用户ID：</p>
					                    <p><input type="text" class="int-text int-medium" id="createBy.id" name="createBy.id" value="${log.createBy.id}"></p>
					                </li>  
					            </ul> 
					            <ul>
					                <li class="col-md-6">
					                    <p class="word">URI：</p>
					                    <p><input type="text" id="requestUri" name="requestUri" class="int-text int-medium" value="${log.requestUri}"></p>
					                </li>
					                <li  class="col-md-6">
					                    <p class="word">开始日期：</p>
					                    <p><input type="text" class="int-text int-medium" id="beginDate" name="beginDate" readonly="readonly" 
											value="<fmt:formatDate value="${log.beginDate}" pattern="yyyy-MM-dd"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"
					                    >
					                </li>  
					            </ul> 
								<ul>
								 <li  class="col-md-6">
					                    <p class="word">结束日期：</p>
					                    <input id="endDate" name="endDate" type="text" readonly="readonly" class="int-text int-medium"
										value="<fmt:formatDate value="${log.endDate}" pattern="yyyy-MM-dd"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
					                    </p>
					              </li>  
					              <li class="width-xlag">
					                <p class="word">&nbsp;</p>
					                <p><input type="submit" id="btnSubmit" class="biu-btn  btn-primary btn-blue btn-large ml-15" value="查  询"></p>
					                </li>
					            </ul>
					         </div>
					   	<!--查询结束-->    
					   	</form:form>  
	         		 </div>
	                </div>
              </div>
         </div>
     </div>	

















	
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
                                       <thead><tr><th>操作菜单</th><th>操作用户</th><th>所在公司</th><th>所在部门</th><th>URI</th><th>提交方式</th><th>操作者IP</th><th>操作时间</th></thead>
                                    <tbody><%request.setAttribute("strEnter", "\n");request.setAttribute("strTab", "\t");%>
										<c:forEach items="${page.list}" var="log">
											<tr>
												<td>${log.title}</td>
												<td>${log.createBy.name}</td>
												<td>${log.createBy.company.name}</td>
												<td>${log.createBy.office.name}</td>
												<td><strong>${log.requestUri}</strong></td>
												<td>${log.method}</td>
												<td>${log.remoteAddr}</td>
												<td><fmt:formatDate value="${log.createDate}" type="both"/></td>
											</tr>
											<c:if test="${not empty log.exception}"><tr>
												<td colspan="8" style="word-wrap:break-word;word-break:break-all;">
													异常信息: <br/>
													${fn:replace(fn:replace(fns:escapeHtml(log.exception), strEnter, '<br/>'), strTab, '&nbsp; &nbsp; ')}</td>
											</tr></c:if>
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