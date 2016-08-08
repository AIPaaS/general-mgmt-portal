<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html >
<head>
<%@ include file="/inc/inc.jsp"%>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width; initial-scale=0.8;  user-scalable=0;" />
    <title>绑定邮箱-设置新邮箱</title>
    
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
  <div class="current"><!--圆圈蓝色 current-->
    <div class="wrap">
      <div class="round"><i class="icon-pencil"></i></div>
      <div class="bar"></div>
    </div>
    <label>2.绑定邮箱</label>
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
          <p class="word">邮箱地址</p>
          <p><input class="int-medium" id="email">
          	<span id="emailMsg" class="regsiter-note" style="display:none"></span>
          	<%-- <span class="regsiter-note" id="emailMsgDiv" style="display:none">
			     <i class="icon-caret-left"></i><img src="${_base}/theme/baas/images/error.png">
			     <span id="emailMsg"></span>
		     </span> --%>
          </p>
          </li>
          
          <li class="user">
          <p class="word">邮箱校验码</p>
          <p>
          	<input class="int-medium" id="verifyCode">
          	<span id="verifyCodeMsg" class="regsiter-note" style="display:none"></span>
          </p>
          <p class="huoqu">
          	<input id="sendEmailBtn"  type="button" class="send-button" value="获取校验码" >
          	<%-- <span class="regsiter-note" id="verifyCodeMsgDiv" style="display:none">
			     <i class="icon-caret-left"></i><img src="${_base}/theme/baas/images/error.png">
			     <span id="verifyCodeMsg"></span>
		     </span> --%>
          </p>
          </li>
       
         
         <li><input id="submitBtn" type="button" class="Submit-btn" value="提  交"></li>
          </ul>
        </div>
    
    </div>
   </div>
  </div>
  <%@ include file="/inc/foot.jsp"%>
  <script type="text/javascript">
   		var uuid = "${uuid}";
		(function() {
			seajs.use([ 'app/center/bandemail/setEmail' ], function(BandEmailPager) {
				var pager = new BandEmailPager({
					element : document.body
				});
				pager.render();
			});
		})(); 
  </script>
</body>
</html>
