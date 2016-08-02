<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>角色管理</title>
	<meta name="decorator" content="default"/>
</head>
<body>
	<div class="row"><!--外围框架-->
     	<div class="col-lg-12"><!--删格化-->
             <div class="row"><!--内侧框架-->
	                 <div class="col-lg-12"><!--删格化-->
	                    <div class="main-box clearfix"><!--白色背景-->
	                    	<!--查询条件-->
	                    		 <div class="form-label form-group">
					           	<ul>
					                <li class="col-md-6">
					                    <p class="word">路由名称</p>
					                    <p><input type="text" class="int-text int-medium"></p>
					                </li>
					                <li  class="col-md-6">
					                    <p class="word">路由类型</p>
					                    <p><select class="select select-medium"><option>自动根据合同匹配行业</option></select></p>
					                </li>  
					            </ul> 
					            <ul>
					                <li class="col-md-6">
					                    <p class="word">路由名称</p>
					                    <p><input type="text" class="int-text int-medium"></p>
					                </li>
					                <li  class="col-md-6">
					                    <p class="word">路由类型</p>
					                    <p><select class="select select-medium"><option>自动根据合同匹配行业</option></select></p>
					                </li>  
					            </ul> 
								<ul>
					                <li class="width-xlag">
					                <p class="word">&nbsp;</p>
					                <p><input type="button" class="biu-btn  btn-primary btn-blue btn-large ml-15" value="查  询"></p>
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
                                        <thead>
                                            <tr>
                                                <th>序号</th>
                                                <th>用户ID</th>
                                                <th>手机号</th>
                                                <th>公司名称</th>
                                                <th>联系人姓名</th>
                                                <th>状态</th>
                                                <th>保证金(元)</th>
                                                <th>授信额度(元)</th>
                                                <th>已使用额度(元)</th>
                                                <th>操作</th>
                                            </tr>
                                        </thead>
                                    <tbody>
                                        <tr>
                                            <td>1</td>
                                            <td>5312312</td>
                                            <td>13098981102</td>
                                            <td>亚信</td>
                                            <td>熊二</td>
                                            <td>正常</td>
                                            <td>10万</td>
                                            <td>10万</td>
                                            <td>－1万</td>
                                            <td><a href="#">设置授信</a></td>
                                        </tr>
                                        <tr>
                                            <td>1</td>
                                            <td>5312312</td>
                                            <td>13098981102</td>
                                            <td>亚信</td>
                                            <td>熊二</td>
                                            <td>正常</td>
                                            <td>10万</td>
                                            <td>10万</td>
                                            <td>－1万</td>
                                            <td><a href="#">设置授信</a></td>
                                        </tr>
                                        <tr>
                                            <td>1</td>
                                            <td>5312312</td>
                                            <td>13098981102</td>
                                            <td>亚信</td>
                                            <td>熊二</td>
                                            <td>正常</td>
                                            <td>10万</td>
                                            <td>10万</td>
                                            <td>－1万</td>
                                            <td><a href="#">设置授信</a></td>
                                        </tr>
                                        <tr>
                                            <td>1</td>
                                            <td>5312312</td>
                                            <td>13098981102</td>
                                            <td>亚信</td>
                                            <td>熊二</td>
                                            <td>正常</td>
                                            <td>10万</td>
                                            <td>10万</td>
                                            <td>－1万</td>
                                            <td><a href="#">设置授信</a></td>
                                        </tr>
                                    </tbody>
                                    </table>
                                </div>
                                	<!--/table表格结束-->
                                <!--分页-->
                                <div class="paging">
                            		<ul class="pagination">
									<li class="disabled"><a href="#"><i class="fa fa-chevron-left"></i></a></li>
									<li class="active"><a href="#">1</a></li>
									<li><a href="#">2</a></li>
									<li><a href="#">3</a></li>
									<li><a href="#">4</a></li>
									<li><a href="#">5</a></li>
									<li><a href="#"><i class="fa fa-chevron-right"></i></a></li>
								</ul>
								</div>
								<!--分页结束-->
                            </div>
                        </div>
                    </div>
                </div>
            
            </div>
    </div>
</body>
</html>