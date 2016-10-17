<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<c:set var="iotStatic" value="${pageContext.request.contextPath}/template/mgmtstatic/default"/>
<html>
<head>
	<title>${fns:getConfig('productName')}</title>

	<meta name="decorator" content="mgmt"/>
  </head>

<body>

<div id="${fns:getThemeIndex()}" class="${fns:getThemeIndex()}">
    <header class="navbar" id="header-navbar">
        <div class="container">
            <a href="index.html" id="logo" class="navbar-brand"><img  src="${iotStatic}/img/logo.png" alt="" class="normal-logo logo-white"/></a>
        <div class="clearfix">
        <!--操作菜单-->
            <button class="navbar-toggle" data-target=".navbar-ex1-collapse" data-toggle="collapse" type="button">
            <span class="sr-only"></span>
            <span class="fa fa-bars"></span>
            </button>
         <!--隐藏菜单icon-->
            <div class="nav-no-collapse navbar-left pull-left hidden-sm hidden-xs">
                <ul class="nav navbar-nav pull-left">
               	 <li><a class="btn" id="make-small-nav"><i class="fa fa-bars"></i></a></li>
                </ul>   
            </div>
        <!--/隐藏菜单icon结束-->
 
        <!--右侧导航-->
            <div class="nav-no-collapse pull-right" id="header-nav">
            <ul class="nav navbar-nav pull-right">
<!--         搜索
            <li class="mobile-search">
            	<a class="btn"><i class="fa fa-search"></i></a>
            <div class="drowdown-search">
                <form role="search">
                    <div class="form-group"><input type="text" class="form-control" placeholder="搜索"><i class="fa fa-search nav-search-icon"></i></div>
                </form>
            </div>
            </li>
         /搜索结束 -->
         <!--待办事项-->
            <%-- <li class="dropdown hidden-xs">
              
                <a class="btn dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bell"></i>
                	<c:if test="${waitjobsCount gt 0}"> 
                	<span class="count">${waitjobsCount}</span>
                	</c:if>
                </a>
                      <!--待办事项隐藏区--> 
         		<c:if test="${waitjobsCount gt 0}">  
	                <ul class="dropdown-menu notifications-list">
	                    <li class="pointer">
	                        <div class="pointer-inner">
	                        <div class="arrow"></div>
	                        </div>
	                    </li>
	                    <li class="item-header">待办提醒</li>
	                    <c:forEach items="${waitjobsList}" var="waitjobs">
	                    	
	                    	<li class="item"><a href="${empty waitjobs.url?'_':waitjobs.url}" target="mainFrame"><i class="fa fa-circle"></i><span class="content">${waitjobs.title}</span></a></li>
	                	</c:forEach>
	                	<c:if test="${waitjobsCount gt 4}">
	                		
	                		<li class="item"><a href="${ctx}/sys/waitjobs/list" target="mainFrame"><span class="content">更多</span></a></li>
	                	</c:if>
	                </ul>
                </c:if>
            </li> --%>
         <!--/待办事项-->
         <!--颜色设置-->     
      	 <li class="dropdown hidden-xs notifications-list">
                 <a class="btn dropdown-toggle" data-toggle="dropdown"><i class="fa fa-cog"></i></a>
 <ul class="dropdown-menu color-pifu" id="skin-colors" >
               	 	<li>
		            
		            <a class="skin-changer" data-skin="theme-whbl" data-toggle="tooltip" title="蓝色" style="background-color: #3498db;height:20px;width:10px;padding:0 10px;float:left" onclick="location='${pageContext.request.contextPath}/theme/cerulean?url='+location.href">
		            </a>
		            </li>
		            <li>
		            <a class="skin-changer" data-skin="theme-white" data-toggle="tooltip" title="绿色" style="background-color: #2ecc71;height:20px;width:10px;padding:0 10px;float:left" onclick="location='${pageContext.request.contextPath}/theme/green?url='+location.href">
		            </a>
		            </li>
		         <!--     <li>
		            <a class="skin-changer" data-skin="theme-amethyst" data-toggle="tooltip" title="紫色" style="background-color: #9b59b6;height:20px;width:10px;padding:0 10px;float:left">
		            </a>
		            </li> -->
		            <!--
		             <li>
		            <a class="skin-changer" data-skin="" data-toggle="tooltip" title="black" style="background-color: #34495e;height:20px;width:10px;padding:0 10px;float:left">
		            </a>
		            </li>
		            <li>
		            <a class="skin-changer blue-gradient" data-skin="theme-blue-gradient" data-toggle="tooltip" title="Gradient"  style="background:#3498db;height:20px;width:10px;padding:0 10px;float:left">
		            </a>
		            </li>
		            <li>
		            <a class="skin-changer" data-skin="theme-turquoise" data-toggle="tooltip" title="Green Sea" style="background-color: #1abc9c;height:20px;width:10px;padding:0 10px;float:left">
		            </a>
		            </li>
		           
		            <li>
		            <a class="skin-changer" data-skin="theme-blue" data-toggle="tooltip" title="Blue" style="background-color: #2980b9;height:20px;width:10px;padding:0 10px;float:left">
		            </a>
		            </li>
		            <li>
		            <a class="skin-changer" data-skin="theme-red" data-toggle="tooltip" title="Red" style="background-color: #e74c3c;height:20px;width:10px;padding:0 10px;float:left">
		            </a>
		            </li>
		            -->
                </ul>
      	 </li>
         <!--/颜色设置结束-->      

           <li class="dropdown hidden-xs"><a class="btn dropdown-toggle" data-toggle="dropdown"><i class="fa fa-info-circle"></i></a></li>
         <!--用户信息-->
            <li class="dropdown profile-dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                
                <img src="${fns:getUser().photo}" alt=""/>
                <span class="hidden-xs">您好, ${fns:getUser().name}</span> <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="${ctx}/sys/user/info" target="mainFrame"><i class="fa fa-user"></i>个人中心</a></li>
                    <li><a href="${ctx}/sys/user/modifyPwd" target="mainFrame"><i class="fa fa-key"></i>修改密码</a></li>
                    <!-- <li><a href="#"><i class="fa fa-cog"></i>系统设置</a></li> -->
                </ul>
            </li>
         <!--/用户信息结束-->
         <!--退出icon-->    
            <li class="hidden-xxs"><a class="btn" href="${ctx}/logout"
						title="退出登录"><i class="fa fa-power-off"></i></a></li>
         <!--/退出icon-->       
            </ul>
            </div>
            </div>
        </div>
    </header>
<!--头部-->
<div id="page-wrapper" class="container">
    <!---->
    <div class="row">
    <!--左侧菜单-->
    <div id="nav-col">
    <section id="col-left" class="col-left-nano">
        <div id="col-left-inner" class="col-left-nano-content">
            <div class="collapse navbar-collapse navbar-ex1-collapse" id="sidebar-nav">
                <ul id="menu" class="nav nav-pills nav-stacked">
                <li class="active"><a href="#"><i class="fa fa-home"></i><span><font>系统控制台</font></span></a></li>
                	<c:set var="firstMenu" value="true"/>
                	<c:forEach items="${fns:getMenuList()}" var="menu" varStatus="idxStatus">
               
						<c:if test="${menu.parent.id eq '1'&&menu.isShow eq '1' &&menu.resourceType eq '0'}">
						
								<li >
									<c:if test="${empty menu.href}">
										<input type="hidden" id="menuId" value="${menu.id}"/>
										<a class="dropdown-toggle" href="javascript:void(0);" id="fisrtmenu"
										data-href="#" data-id="${menu.id}" target="mainFrame">										
										 <i class="fa fa-inbox"></i><span><font>${menu.name}</font></span>
					                     <i class="fa fa-chevron-circle-right drop-icon"></i>
										</a>
										
										<ul class="submenu" id="secondmenu">
										<c:set var="rootMenuId" value="${menu.id}"/>
										<c:forEach items="${fns:getChildsMenu(rootMenuId)}" var="menuNode" varStatus="idxStatus">
										<c:set var="systemId" value="${menuNode.gnTabSystem}"/>
										<c:if test="${empty menuNode.href &&menuNode.isShow eq '1'}">
											<li><a href="#" data-id="${menuNode.id}" class="dropdown-toggle" target="mainFrame">${menuNode.name}<i class="fa fa-chevron-circle-right drop-icon"></i></a>
											<!--三级菜单-->
					                        <ul class="submenu three-list">
						                        <c:forEach items="${fns:getChildsMenu(menuNode.id)}" var="menuNodethree" varStatus="idxStatus">
						                        <!-- <li  class="three-list-active"><a href="#" >新建路由</a></li> -->
						                        <c:set var="systemId" value="${menuNodethree.gnTabSystem}"/>
						                        
						                        <li><a href="${fns:getGnTabSystemUrl(systemId)}${menuNodethree.href}?theme=${fns:getThemeIndex()}&mgmtPath=${mgmtPath}" data-id="${menuNodethree.id}"  target="mainFrame">${menuNodethree.name}</a></li>
						                         <c:set var="systemId" value=""/>
						                        </c:forEach>
					                 	   	</ul>
							     		</c:if>
							     		<c:if test="${not empty menuNode.href &&menuNode.isShow eq '1'}">
							     		
							     			<li><a href="${fns:getGnTabSystemUrl(systemId)}${menuNode.href}?theme=${fns:getThemeIndex()}&mgmtPath=${mgmtPath}" data-id="${menuNode.id}"  target="mainFrame">${menuNode.name}</a>
							     	
							     		</c:if>
										<c:set var="systemId" value=""/>
										</li>
										</c:forEach>
										</ul>
									</c:if>
										

										
									
								</li>
								<c:if test="${firstMenu}">
									<c:set var="firstMenuId" value="${menu.id}"/>
								</c:if>
								<c:set var="firstMenu" value="false"/>
							</c:if>
						</c:forEach>
                	
                  
                
                </ul>
            </div>
        </div>
    </section>
    </div>
    <!--/左侧菜单结束-->
    <div id="content-wrapper"><!--右侧灰色背景-->
    <!--右侧-->
     <div class="row"><!--外围框架-->
     	<div class="col-lg-12"><!--删格化-->
             <div class="row"><!--内侧框架-->
	                 <div class="col-lg-12"><!--删格化-->
	                    <div class="main-box clearfix"><!--白色背景-->
	                    		<div class="notice col-lg-12">
	                    			<p class="gongg"><A href="#">［站内信］:</A></p>
           						 <div  id="elem">
						            <ul id="elem1">
		            				<c:forEach items="${fns:getOaNotifyByUser()}" var="oaNotify" >
							            <c:set var="oaNotifytype" value="${oaNotify.type}"/>
							          
							            <li><A target="mainFrame" href="${ctx}/oa/oaNotify/view?id=${oaNotify.id}">【${fns:getDictLabel(oaNotifytype, 'oa_notify_type', '')}】${oaNotify.title}</A>
							            
							            <c:if test="${oaNotify.readFlag eq '0'}">
							            <img src="${iotStatic}/images/news.gif">
							            </c:if>
							            </li>
							            
						            </c:forEach>
						            </ul>
						            <ul id="elem2">
						            </ul>
						            </div>
            						 <!-- <p class="dclose"><A href="#"><i class="icon-remove"></i></A></p> -->
	                    		</div>
	         			</div>
	                	</div>
              </div>
         </div>
     </div>	
     <%-- ${ctx}/sys/portal --%>
     <!--框架标签结束--><iframe class="content-wrapper-iframe" id="mainFrame" name="mainFrame" src="" style="overflow-x:hidden;" scrolling="auto" frameborder="no" width="100%"  marginheight="50px" marginwidth="0"></iframe>
<!-- 	
	    底部
    <footer id="footer-bar" class="row">
   		 <p id="footer-copyright" class="col-xs-12">亚信</p>
    </footer> -->
   <!--/底部结束-->
    </div>
    </div>
</div>
</div>


	
</body>
	
</html>