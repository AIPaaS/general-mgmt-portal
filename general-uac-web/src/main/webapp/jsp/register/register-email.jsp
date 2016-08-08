<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@ include file="/inc/inc.jsp"%>
<!--Support IE Text -->
<meta http-equiv="X-UA-Compatible" content="IE=Edge" /> 
<title>注册－邮箱绑定</title>
<script type="text/javascript">
(function () {
	seajs.use('app/register/register-email', function (RegisterEmaillPager) {
		var pager = new RegisterEmaillPager();
		pager.render();
	});
})();

</script>
</head>

<body>

  <%@ include file="/inc/head-register-email.jsp"%>
   <div class="regsiter-wrapper">
   	<div class="regsiter-box">
        <div class="regsiter-email-cnt">
          <ul>
          <li class="user">
          <p class="word">邮箱地址</p>
          	<input type="text" class="int-medium" placeholder="" id="email" name="email">
          	<input type="hidden" id="emailFlag">
          	<input type="hidden" id="identifyFlag">
          	<input type="hidden" name="accountIdKey" id="accountIdKey" value="${requestScope.accountIdKey}"/>
          <span class="yzm">
			     <input id="getIdentify"  type="button"  class="button" value="获取验证码" >
          </span>
          <label>
          	<span class="regsiter-note" id="errorEMsg">
         		<span  id="showErroeEMsg"></span>
		    </span>
           </label>
           
         </li>
          <li class="user">
	          <p class="word">邮箱验证码</p>
	          <p><input type="text" class="int-medium" placeholder="" id="identifyCode"></p>
	        <label>
	        	<span class="regsiter-note" id="errorEmIdentifyMsg">
	         		<span  id="showErroeEmIdentify"></span>
			   </span>
	        </label>
	         	
	       
         </li>
         <li class="reminder">
         <p><i class="icon-lightbulb"></i>温馨提示</p>
         <p class="reminder-word">
         <span>1 . 邮箱也可以作为登录账号</span>
         <span>2 . 邮箱可以帮助您找回账户密码</span>
         <span>3 . 接收产品开通、到期、故障等通知服务</span>
         </p>
         </li>
         
         <li class="regsiter-email-btn">
         	<input type="button" value="下次再说" class="next-btn" id="BTN_PASS" name="BTN_PASS">
         	<input type="button" value="提交" class="next-btn next-btn-hover" id="BTN_SUBMIT" name="BTN_SUBMIT">
         </li>
          </ul>
         </div>
       </div>
    </div>

    <%@ include file="/inc/foot.jsp"%>
   
</body>
</html>
