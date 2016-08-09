<%@ page contentType="text/html;charset=UTF-8" %>
<html>
 <head>
  <meta charset="UTF-8">
  <meta name="decorator" content="mgmt">
  <title>Document</title>
 </head>
 <body>
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
					                    <p class="word">部门称</p>
					                    <p><input name="control_date" class="int-text int-medium " type="text"/>
					                    </p>
					                </li>
					                <li  class="col-md-6">
					                    <p class="word">上级部门</p>
					                    <p><input type="text" class="int-text int-medium"></p>
					                </li>  
					            </ul> 
					           <ul>
					                <li class="col-md-6">
					                    <p class="word">开始时间</p>
					                    <p><input name="control_date" class="int-text int-medium " type="text"  onClick="WdatePicker()"/>
					                   <span class="time"> <i class="fa  fa-calendar" ></i></span>
					                    </p>
					                </li>
					                <li class="col-md-6">
					                    <p class="word">结束时间</p>
					                    <p><input name="control_date" class="int-text int-medium " type="text"  onClick="WdatePicker()"/>
					                    <i class="fa  fa-calendar" ></i>
					                    </p>
					                </li>  
					            </ul> 
								<ul>
					                <li class="width-xlag">
					                <p class="word">&nbsp;</p>
					                <p><input type="button" class="biu-btn  btn-primary btn-blue btn-medium ml-10" value="查  询"></p>
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
                        <div class="row"><!--删格化-->
                         <p class="right pr-30">
                         	<input type="button" class="biu-btn  btn-primary btn-blue btn-auto  ml-5" value="新  增">
                         	<input type="button" class="biu-btn  btn-primary btn-blue btn-auto  ml-5" value="删  除">
                         </p>
                        </div>
                            <div class="main-box-body clearfix">
                            	<!--table表格-->
                                <div class="table-responsive clearfix">
                                    <table class="table table-hover table-border table-bordered">
                                        <thead>
                                            <tr>
                                            		<th>选择</th>
                                                <th>部门名称</th>
                                                <th>部门类型</th>
                                                <th>部门级别</th>
                                                <th>上级部门</th>
                                                <th>归属省份</th>
                                                <th>归属地市</th>
                                                <th>联系人</th>
                                                <th>操作</th>
                                            </tr>
                                        </thead>
                                    <tbody>
                                        <tr>
                                        		<td><input type="checkbox"></td>
                                            <td>biu</td>
                                            <td>分公司</td>
                                            <td>全国</td>
                                            <td>总部</td>
                                            <td>北京</td>
                                            <td>北京</td>
                                            <td></td>
                                            <td  id="operation"><a href="#">修改</a></td>
                                        </tr>
                                         <tr>
                                        		<td><input type="checkbox"></td>
                                            <td>biu</td>
                                            <td>分公司</td>
                                            <td>全国</td>
                                            <td>总部</td>
                                            <td>北京</td>
                                            <td>北京</td>
                                            <td></td>
                                            <td><a href="#">修改</a></td>
                                        </tr>
                                         <tr>
                                        		<td><input type="checkbox"></td>
                                            <td>biu</td>
                                            <td>分公司</td>
                                            <td>全国</td>
                                            <td>总部</td>
                                            <td>北京</td>
                                            <td>北京</td>
                                            <td></td>
                                            <td><a href="#">修改</a></td>
                                        </tr>
                                         <tr>
                                        		<td><input type="checkbox"></td>
                                            <td>biu</td>
                                            <td>分公司</td>
                                            <td>全国</td>
                                            <td>总部</td>
                                            <td>北京</td>
                                            <td>北京</td>
                                            <td></td>
                                            <td><a href="#">修改</a></td>
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
