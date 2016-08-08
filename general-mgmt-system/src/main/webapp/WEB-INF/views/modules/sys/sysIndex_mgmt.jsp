<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>${fns:getConfig('productName')}</title>

	<meta name="decorator" content="mgmt"/>
    <%-- <c:if test="${tabmode eq '1'}"><link rel="Stylesheet" href="${ctxStatic}/jerichotab/css/jquery.jerichotab.css" />
    <script type="text/javascript" src="${ctxStatic}/jerichotab/js/jquery.jerichotab.js"></script></c:if>
	<style type="text/css">
		#main {padding:0;margin:0;} #main .container-fluid{padding:0 4px 0 6px;}
		#header {margin:0 0 8px;position:static;} #header li {font-size:14px;_font-size:12px;}
		#header .brand {font-family:Helvetica, Georgia, Arial, sans-serif, 黑体;font-size:26px;padding-left:33px;}
		#footer {margin:8px 0 0 0;padding:3px 0 0 0;font-size:11px;text-align:center;border-top:2px solid #0663A2;}
		#footer, #footer a {color:#999;} #left{overflow-x:hidden;overflow-y:auto;} #left .collapse{position:static;}
		#userControl>li>a{/*color:#fff;*/text-shadow:none;} #userControl>li>a:hover, #user #userControl>li.open>a{background:transparent;}
	</style> --%>
	<!-- <script type="text/javascript">
		$(document).ready(function() {
			// <c:if test="${tabmode eq '1'}"> 初始化页签
			$.fn.initJerichoTab({
                renderTo: '#right', uniqueId: 'jerichotab',
                contentCss: { 'height': $('#right').height() - tabTitleHeight },
                tabs: [], loadOnce: true, tabWidth: 110, titleHeight: tabTitleHeight
            });//</c:if>
			// 绑定菜单单击事件
			$("#menu a.menu").click(function(){
				// 一级菜单焦点
				$("#menu li.menu").removeClass("active");
				$(this).parent().addClass("active");
				// 左侧区域隐藏
				if ($(this).attr("target") == "mainFrame"){
					$("#left,#openClose").hide();
					wSizeWidth();
					// <c:if test="${tabmode eq '1'}"> 隐藏页签
					$(".jericho_tab").hide();
					$("#mainFrame").show();//</c:if>
					return true;
				}
				// 左侧区域显示
				$("#left,#openClose").show();
				if(!$("#openClose").hasClass("close")){
					$("#openClose").click();
				}
				// 显示二级菜单
				var menuId = "#menu-" + $(this).attr("data-id");
				if ($(menuId).length > 0){
					$("#left .accordion").hide();
					$(menuId).show();
					// 初始化点击第一个二级菜单
					if (!$(menuId + " .accordion-body:first").hasClass('in')){
						$(menuId + " .accordion-heading:first a").click();
					}
					if (!$(menuId + " .accordion-body li:first ul:first").is(":visible")){
						$(menuId + " .accordion-body a:first i").click();
					}
					// 初始化点击第一个三级菜单
					$(menuId + " .accordion-body li:first li:first a:first i").click();
				}else{
					// 获取二级菜单数据
					$.get($(this).attr("data-href"), function(data){
						if (data.indexOf("id=\"loginForm\"") != -1){
							alert('未登录或登录超时。请重新登录，谢谢！');
							top.location = "${ctx}";
							return false;
						}
						$("#left .accordion").hide();
						$("#left").append(data);
						// 链接去掉虚框
						$(menuId + " a").bind("focus",function() {
							if(this.blur) {this.blur()};
						});
						// 二级标题
						$(menuId + " .accordion-heading a").click(function(){
							$(menuId + " .accordion-toggle i").removeClass('icon-chevron-down').addClass('icon-chevron-right');
							if(!$($(this).attr('data-href')).hasClass('in')){
								$(this).children("i").removeClass('icon-chevron-right').addClass('icon-chevron-down');
							}
						});
						// 二级内容
						$(menuId + " .accordion-body a").click(function(){
							$(menuId + " li").removeClass("active");
							$(menuId + " li i").removeClass("icon-white");
							$(this).parent().addClass("active");
							$(this).children("i").addClass("icon-white");
						});
						// 展现三级
						$(menuId + " .accordion-inner a").click(function(){
							var href = $(this).attr("data-href");
							if($(href).length > 0){
								$(href).toggle().parent().toggle();
								return false;
							}
							// <c:if test="${tabmode eq '1'}"> 打开显示页签
							return addTab($(this)); // </c:if>
						});
						// 默认选中第一个菜单
						$(menuId + " .accordion-body a:first i").click();
						$(menuId + " .accordion-body li:first li:first a:first i").click();
					});
				}
				// 大小宽度调整
				wSizeWidth();
				return false;
			});
			// 初始化点击第一个一级菜单
			$("#menu a.menu:first span").click();
			// <c:if test="${tabmode eq '1'}"> 下拉菜单以选项卡方式打开
			$("#userInfo .dropdown-menu a").mouseup(function(){
				return addTab($(this), true);
			});// </c:if>
			// 鼠标移动到边界自动弹出左侧菜单
			$("#openClose").mouseover(function(){
				if($(this).hasClass("open")){
					$(this).click();
				}
			});
			// 获取通知数目  <c:set var="oaNotifyRemindInterval" value="${fns:getConfig('oa.notify.remind.interval')}"/>
			function getNotifyNum(){
				$.get("${ctx}/oa/oaNotify/self/count?updateSession=0&t="+new Date().getTime(),function(data){
					var num = parseFloat(data);
					if (num > 0){
						$("#notifyNum,#notifyNum2").show().html("("+num+")");
					}else{
						$("#notifyNum,#notifyNum2").hide()
					}
				});
			}
			getNotifyNum(); //<c:if test="${oaNotifyRemindInterval ne '' && oaNotifyRemindInterval ne '0'}">
			setInterval(getNotifyNum, ${oaNotifyRemindInterval}); //</c:if>
		});
		// <c:if test="${tabmode eq '1'}"> 添加一个页签
		function addTab($this, refresh){
			$(".jericho_tab").show();
			$("#mainFrame").hide();
			$.fn.jerichoTab.addTab({
                tabFirer: $this,
                title: $this.text(),
                closeable: true,
                data: {
                    dataType: 'iframe',
                    dataLink: $this.attr('href')
                }
            }).loadData(refresh);
			return false;
		}// </c:if>
	</script> -->
<script type="text/javascript" language="javascript">   
function iFrameHeight() {   
var ifm= document.getElementById("mainFrame");   
var subWeb = document.frames ? document.frames["mainFrame"].document : ifm.contentDocument;   
if(ifm != null && subWeb != null) {
   ifm.height = subWeb.body.scrollHeight;
   ifm.width = subWeb.body.scrollWidth;
}   
}   
</script>	
	
</head>
<body>
<div id="theme-wrapper" class="xyindex">
    <header class="navbar" id="header-navbar">
        <div class="container">
            <a href="index.html" id="logo" class="navbar-brand"><img  src="${mgmtStatic}/img/logo.png" alt="" class="normal-logo logo-white"/></a>
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
        <!--搜索-->
            <li class="mobile-search">
            	<a class="btn"><i class="fa fa-search"></i></a>
            <div class="drowdown-search">
                <form role="search">
                    <div class="form-group"><input type="text" class="form-control" placeholder="搜索"><i class="fa fa-search nav-search-icon"></i></div>
                </form>
            </div>
            </li>
         <!--/搜索结束-->
         <!--待办事项-->
            <li class="dropdown hidden-xs">
                <a class="btn dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bell"></i><span class="count">8</span></a>
         <!--待办事项隐藏区-->   
                <ul class="dropdown-menu notifications-list">
                    <li class="pointer">
                        <div class="pointer-inner">
                        <div class="arrow"></div>
                        </div>
                    </li>
                    <li class="item-header">代办提醒</li>
                    <li class="item"><a href="#"><i class="fa fa-circle"></i><span class="content">待办提醒事务1</span></a></li>
                    <li class="item"><a href="#"><i class="fa fa-circle"></i><span class="content">待办提醒事务1</span></a></li>
                    <li class="item"><a href="#"><i class="fa fa-circle"></i><span class="content">待办提醒事务1</span></a></li>
                    <li class="item"><a href="#"><i class="fa fa-circle"></i><span class="content">待办提醒事务1</span></a></li>
                </ul>
            </li>
         <!--/待办事项-->
         <!--颜色设置-->     
      	 <li class="dropdown hidden-xs notifications-list">
                 <a class="btn dropdown-toggle" data-toggle="dropdown"><i class="fa fa-cog"></i></a>
 <ul class="dropdown-menu color-pifu" id="skin-colors" >
               	 	<li>
		            <a class="skin-changer" data-skin="theme-whbl" data-toggle="tooltip" title="蓝色" style="background-color: #3498db;height:20px;width:10px;padding:0 10px;float:left">
		            </a>
		            </li>
		            <li>
		            <a class="skin-changer" data-skin="theme-white" data-toggle="tooltip" title="绿色" style="background-color: #2ecc71;height:20px;width:10px;padding:0 10px;float:left">
		            </a>
		            </li>
		             <li>
		            <a class="skin-changer" data-skin="theme-amethyst" data-toggle="tooltip" title="紫色" style="background-color: #9b59b6;height:20px;width:10px;padding:0 10px;float:left">
		            </a>
		            </li>
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
                <img src="${mgmtStatic}/img/robert-300.jpg" alt=""/>
                <span class="hidden-xs">您好, ${fns:getUser().name}</span> <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="${ctx}/sys/user/info" target="mainFrame"><i class="fa fa-user"></i>个人中心</a></li>
                    <li><a href="${ctx}/sys/user/modifyPwd" target="mainFrame"><i class="fa fa-key"></i>修改密码</a></li>
                    <li><a href="#"><i class="fa fa-cog"></i>系统设置</a></li>
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
                <li class="active"><a href="#"><i class="fa fa-home"></i><span>系统控制台</span></a></li>
                	<c:set var="firstMenu" value="true"/>
                	<c:forEach items="${fns:getMenuList()}" var="menu" varStatus="idxStatus">
						<c:if test="${menu.parent.id eq '1'&&menu.isShow eq '1'}">
						
								<li >
									<c:if test="${empty menu.href}">
										<input type="hidden" id="menuId" value="${menu.id}"/>
										<a class="dropdown-toggle" href="javascript:void(0);" id="fisrtmenu"
										data-href="#" data-id="${menu.id}" target="mainFrame">										
										 <i class="fa fa-sitemap"></i><span>${menu.name}</span>
					                     <i class="fa fa-chevron-circle-right drop-icon"></i>
										</a>
										
										<ul class="submenu" id="secondmenu">
										<c:set var="rootMenuId" value="${menu.id}"/>
										<c:forEach items="${fns:getChildsMenu(rootMenuId)}" var="menuNode" varStatus="idxStatus">
										<li><a href="${fn:indexOf(menuNode.href, '://') eq -1 ? ctx : ''}${menuNode.href}" data-id="${menuNode.id}" target="mainFrame">${menuNode.name}</a></li>
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
	                    			<p class="gongg"><A href="#">［公告］:</A></p>
           						 <div  id="elem">
						            <ul id="elem1">
		            				<c:forEach items="${fns:getOaNotifyByUser()}" var="oaNotify" >
							            <c:set var="oaNotifytype" value="${oaNotify.type}"/>
							            
							            <li><A href="#">【${fns:getDictLabel(oaNotifytype, 'oa_notify_type', '')}】${oaNotify.title}</A>
							            <c:if test="${not empty oaNotify.unReadNum}">
							            <img src="${mgmtStatic}/images/news.gif">
							            </c:if>
							            </li>
							            
						            </c:forEach>
						            </ul>
						            <ul id="elem2">
						            </ul>
						            </div>
            						 <p class="dclose"><A href="#"><i class="icon-remove"></i></A></p>
	                    		</div>
	         			</div>
	                	</div>
              </div>
         </div>
     </div>	
     <!--框架标签结束--><iframe id="mainFrame" name="mainFrame" src="" style="overflow:visible;"  frameborder="0"  scrolling="no" marginheight="0" width="100%" marginwidth="0" onLoad="iFrameHeight()"></iframe>
	
	    <!--底部-->
    <footer id="footer-bar" class="row">
   		 <p id="footer-copyright" class="col-xs-12">亚信</p>
    </footer>
   <!--/底部结束-->
    </div>
    </div>
</div>
</div>


	
</body>
</html>