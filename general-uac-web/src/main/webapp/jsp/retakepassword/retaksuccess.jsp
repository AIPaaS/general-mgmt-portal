<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-cn">
<head>
    <%@ include file="/inc/inc.jsp"%>
    <meta charset="utf-8">
    <!--Support IE Text -->
	<meta http-equiv="X-UA-Compatible" content="IE=Edge" /> 
    <title>找回密码-成功</title>
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
  		<div class="finished"><!--圆圈蓝色 current-->
		    <div class="wrap">
		      <div class="round"><i class="icon-key"></i></div>
		      <div class="bar"></div>
		    </div>
		    <label>2.身份验证</label>
	  	</div>
	  	<div class="finished"><!--圆圈蓝色 current-->
		    <div class="wrap">
		      <div class="round"><i class="icon-pencil"></i></div>
		      <div class="bar"></div>
		    </div>
		    <label>3.重置密码</label>
	  	</div>
  		<div class="finished"><!--圆圈灰色 todo-->
		    <div class="wrap">
		      <div class="round"><i class=" icon-ok"></i></div>
		      
		    </div>
		    <label>4.完成</label>
  		</div>
	  </div>
 	</div>
 	<!--步骤结束-->
         
      <div class="password-success"><b id="message">恭喜您，密码重设成功！</b><a id="gotoLogin">立即登录</a></div>
    
    </div>
    </div>
  </div>
  <%@ include file="/inc/foot.jsp"%>
  <script type="text/javascript">
  		var uuid="${uuid}";
		(function() {
			seajs.use([ 'app/retakepassword/success' ], function(SuccessPager) {
				var pager = new SuccessPager({
					element : document.body
				});
				pager.render();
			});
		})(); 
  </script>
</body>
</html>
