<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-cn">
<head>
    <%@ include file="/inc/inc.jsp"%>
    <meta charset="utf-8">
    <!--Support IE Text -->
	<meta http-equiv="X-UA-Compatible" content="IE=Edge" /> 
    <title>找回密码-用户信息</title>
</head>


<body>
  <%@ include file="/inc/head-pwd.jsp"%>
  <div class="box">
  <div class="wrappera">
   <!-- 步骤开始 -->
   <div class="Retrieve-password">
    <div class="Retrieve-steps">
      <div class="Retrieve-steps-round">
  		<div class="finished"><!--蓝色圆圈带蓝线 finished-->
		    <div class="wrap">
		      <div class="round"><i class="icon-user"></i></div>
		      <div class="bar"></div>
		    </div>
    		<label>1.填写用户名</label>
  		</div>
  		<div class="todo"><!--圆圈蓝色 current-->
		    <div class="wrap">
		      <div class="round"><i class="icon-key"></i></div>
		      <div class="bar"></div>
		    </div>
		    <label>2.身份验证</label>
	  	</div>
	  	<div class="todo"><!--圆圈蓝色 current-->
		    <div class="wrap">
		      <div class="round"><i class="icon-pencil"></i></div>
		      <div class="bar"></div>
		    </div>
		    <label>3.重置密码</label>
	  	</div>
  		<div class="todo"><!--圆圈灰色 todo-->
		    <div class="wrap">
		      <div class="round"><i class=" icon-ok"></i></div>
		      
		    </div>
		    <label>4.完成</label>
  		</div>
	  </div>
 	</div>
 	<!--步骤结束-->
         
     <!--表单验证-->
    <div class="Retrieve-cnt">
          <ul>
         <li class="user">
          <p class="word">用户名</p>
          <p>
          	<input type="text" class="int-medium" id="userName"/>
          	<span id="userNameMsg" class="regsiter-note" style="display:none"></span>
          <%-- <span class="regsiter-note" id="userNameMsgDiv" style="display:none">
		     <i class="icon-caret-left"></i>
		     <img src="${_base}/theme/baas/images/error.png">
		     <span id="userNameMsg"></span>
		  </span> --%>
		  </p>
         </li>
         <li class="user">
          <p class="word">图形验证码</p>
          <p>
          	<input type="text" class="int-medium" id="pictureVerifyCode"/>
          	<span id="verifyCodeMsg" class="regsiter-note" style="display:none"></span>
          </p>
          <p><img id="random_img" src="${_base}/retakePassword/getUserImageVerifyCode"/></p>
          <p><a id="changeImage">看不清?换一换</a>
          <%-- <span class="regsiter-note" id="verifyCodeMsgDiv" style="display:none">
		     <i class="icon-caret-left"></i><img src="${_base}/theme/baas/images/error.png">
		     <span id="verifyCodeMsg"></span>
		  </span> --%>
		  </p>
         </li>
         <li><input id="submitBtn" type="button" class="Submit-btn" value="提  交"/></li>
       
          </ul>
        
        </div>
    
    
    </div>
    </div>
  </div>
  <%@ include file="/inc/foot.jsp"%>
  <script type="text/javascript">
		(function() {
			seajs.use([ 'app/retakepassword/userInfo' ], function(UserInfoPager) {
				var pager = new UserInfoPager({
					element : document.body
				});
				pager.render();
			});
		})(); 
  </script>
</body>
</html>
