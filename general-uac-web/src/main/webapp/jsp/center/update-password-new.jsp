<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-cn">
<head>
<%@ include file="/inc/inc.jsp"%>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width; initial-scale=0.8;  user-scalable=0;" />
    <title>修改密码-重置密码</title>
</head>

<body>
  <%@ include file="/inc/head-user.jsp"%>
  <div class="box">
  <%@ include file="/inc/left-menu.jsp"%>
  
  <div class="wrapper">
   <div class="Retrieve-password">
    
         <div class="Retrieve-steps newsteps">
         <div class="Retrieve-steps-round">
  <div class="finished"><!--蓝色圆圈带蓝线 finished-->
    <div class="wrap">
      <div class="round"><i class="icon-user"></i></div>
      <div class="bar"></div>
    </div>
    <label>1.身份验证</label>
  </div>
  <div class="finished"><!--圆圈蓝色 current-->
    <div class="wrap">
      <div class="round"><i class="icon-pencil"></i></div>
      <div class="bar"></div>
    </div>
    <label>2.设置新密码</label>
  </div>
  <div class="todo"><!--圆圈灰色 todo-->
    <div class="wrap">
      <div class="round"><i class=" icon-ok"></i></div>
      
    </div>
    <label>3.完成</label>
  </div>

</div>
 </div><!--步骤结束-->
         
     <!--表单验证-->
    <div class="Retrieve-cnt">
          <ul>
         <li class="user">
          <p class="word">新密码</p>
          <p>
          	<input type="password"class="int-medium" placeholder="" id="password">
          	<span id="newPwdMsg" class="regsiter-note" style="display:none"></span>
             <%-- <span class="regsiter-note" id="newPwdMsgDiv" style="display:none">
			     <i class="icon-caret-left"></i><img src="${_base}/theme/baas/images/error.png">
			     <span id="newPwdMsg"></span>
		     </span> --%>
		  </p>
		  <!-- <div class="Set-password" style="display:none">
				          <p class="low" id="strength_L">
					          <span class="f00"></span>
					          <span>低</span>
				          </p>
				           <p class="in" id="strength_M">
					          <span class="eb6100"></span>
					          <span>中</span>
				          </p>
				          <p class="gao" id="strength_H">
					          <span class="green"></span>
					          <span>高</span>
				          </p>
	          			</div>	 -->
          </li>
          
          <li class="user">
          <p class="word">确认密码</p>
          <p>
          	<input type="password" class="int-medium" placeholder="" id="confirmPassword">
          	<span id="confirmPwdMsg" class="regsiter-note" style="display:none"></span>
          	  <%-- <span class="regsiter-note" id="confirmPwdMsgDiv" style="display:none">
			     <i class="icon-caret-left"></i><img src="${_base}/theme/baas/images/error.png">
			     <span id="confirmPwdMsg"></span>
			  </span> --%>
          </p>
          </li>
       
         
         <li><input id="submitBtn" type="button" class="Submit-btn" value="提  交" ></li>
       
          </ul>
        
        
        </div>
    
    
    </div>
    </div>
  </div>
  <%@ include file="/inc/foot.jsp"%>
  <script type="text/javascript">
  		var uuid = "${uuid}";
		(function() {
			seajs.use([ 'app/center/password/setPassword' ], function(UpdatePasswordPager) {
				var pager = new UpdatePasswordPager({
					element : document.body
				});
				pager.render();
			});
		})(); 
  </script>
</body>
</html>
