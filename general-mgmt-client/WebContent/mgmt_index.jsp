<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="iotStatic" value="${pageContext.request.contextPath}/template/static"/>
<!DOCTYPE html>
<html>
<head>
<meta name="decorator" content="mgmt"/>
<title>查询列表</title>
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
	<!--提示弹出框 操作-->	
	<div class="popup" id="popup">
		<div class="prompt-samll">
		<div class="prompt-samll-title">
			<p>删除操作确认</p>
			<p class="img" id="xclose"><i class="fa fa-times"></i></p>
		</div>
		<!--确认删除-->
		<div class="prompt-samll-confirm">
			<ul>
			<li class="word">确定要删除已选联系人吗？</li>
			<li>
				<input type="button"  class="biu-btn  btn-primary btn-blue btn-small ml-15 mt-20 radius" value="确认">
				<input type="button"  class="biu-btn  btn-primary btn-blue btn-small ml-15 mt-20 radius" id="closebtn" value="取消"></li>		
			</ul>
		</div>
		</div>	
	<div class="mask"></div>
	</div>
<!--/提示弹出框操作结束-->
<div id="theme-wrapper">
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
                <img src="${iotStatic}/img/robert-300.jpg" alt=""/>
                <span class="hidden-xs">熊熊熊二</span> <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="#"><i class="fa fa-user"></i>个人中心</a></li>
                    <li><a href="#"><i class="fa fa-key"></i>修改密码</a></li>
                    <li><a href="#"><i class="fa fa-cog"></i>系统设置</a></li>
                </ul>
            </li>
         <!--/用户信息结束-->
         <!--退出icon-->    
            <li class="hidden-xxs"><a class="btn"><i class="fa fa-power-off"></i></a></li>
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
                <ul class="nav nav-pills nav-stacked">
                	<li class="active"><a href="#"><i class="fa fa-home"></i><span>系统控制台</span><!--<span class="label label-info label-circle pull-right">28</span>--></a></li>
                    <li>
                        <a href="#" class="dropdown-toggle">
                        <i class="fa fa-sitemap"></i><span>服务器对接管理</span>
                        <i class="fa fa-chevron-circle-right drop-icon"></i>
                        </a>
                       <!--二级菜单-->
                        <ul class="submenu">
                            <li><a href="#">服务器对接管理</a>
                           
                            </li>
                            <li><a href="#">服务器对接管理</a></li>
                            <li><a href="#">服务器对接管理</a></li>
                        </ul>
                        <!--二级菜单结束-->
                    </li>
                <li>
                    <a href="#" class="dropdown-toggle">
                    <i class="fa fa-inbox"></i>
                    <span>智能路由</span>
                    <i class="fa fa-chevron-circle-right drop-icon"></i>
                    </a>
                    <!--二级菜单-->
                    <ul class="submenu">
                        <li><a href="#">新建路由</a></li>
                        <li><a href="#">添加路由规则</a></li>
                        <li><a href="#">新增预警接收人</a></li>
                    </ul>
                    <!--二级菜单结束-->
                </li>
                <li>
                    <a href="#" class="dropdown-toggle">
                    <i class="fa fa-paste"></i>
                    <span>合同中心</span>
                    <i class="fa fa-chevron-circle-right drop-icon"></i>
                    </a>
                <!--二级菜单-->    
                    <ul class="submenu">
                        <li><a href="#">合同分析统计</a></li>
                        <li><a href="#">客户信息管理</a></li>
                        <li><a href="#">合同信息管理</a></li>
                        <li><a href="#">网络协议签订列表</a></li>
                    </ul>
                <!--二级菜单结束-->
                </li>
                <li>
                <a href="#">
                <i class="fa fa-shopping-cart"></i>
                <span>商品类目管理</span>
                </a>
                </li>
                <li>
                    <a href="#" class="dropdown-toggle">
                    <i class="fa fa-tasks"></i>
                    <span>属性及属性值管理</span>
                    <i class="fa fa-chevron-circle-right drop-icon"></i>
                    </a>
                <!--二级菜单-->
                    <ul class="submenu">
                        <li><a href="#">查看类目属性</a></li>
                        <li><a href="#">关联类目属性</a></li>
                        <li><a href="#">选择类目属性</a></li>
                    </ul>
                <!--二级菜单结束-->
                </li>
                <li>
                    <a href="#" class="dropdown-toggle">
                    <i class="fa fa-usd"></i>
                    <span>结算管理</span><i class="fa fa-chevron-circle-right drop-icon"></i>
                    </a>
                <!--二级菜单-->    
                    <ul class="submenu">
                        <li><a href="#">路由添加成本价-编辑价格</a></li>
                        <li><a href="#">路由添加成本价</a></li>
                    </ul>
                <!--二级菜单结束-->
                </li>
                
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
						                <li><A href="#">公告位置！比如说系统维护，哪些功能在什么时间段可能不可用之类的，针对后台</A></li>
						                <li><A href="#">公告位置！比如说系统维护，哪些功能在什么时间段可能不可用之类的，针对后台</A></li>
						                <li><A href="#">公告位置！比如说系统维护，哪些功能在什么时间段可能不可用之类的，针对后台</A></li>
						                <li><A href="#">公告位置！比如说系统维护，哪些功能在什么时间段可能不可用之类的，针对后台</A></li>
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
     <!--框架标签结束--><iframe id="mainFrame" name="mainFrame" src="office/officeList.jsp" style="overflow:visible;"  frameborder="0"  scrolling="no" marginheight="0" width="100%" marginwidth="0" onLoad="iFrameHeight()"></iframe>
 
    
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