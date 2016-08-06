<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@ include file="/inc/inc.jsp"%>
<!--Support IE Text -->
<meta http-equiv="X-UA-Compatible" content="IE=Edge" /> 
<title>注册-成功</title>
 <script type="text/javascript">
(function () {
	seajs.use('app/register/register-success', function (RegisterSucessPager) {
		var pager = new RegisterSucessPager();
		pager.render();
	});
})();
</script>
</head>

<body>
<%@ include file="/inc/head-register-success.jsp"%>
  
     <div class="regsiter-wrapper-bg">
        <div class="regsiter-success-cnt">
         
         <p><img src="${_base}/theme/baas/images/logins.gif"><input type="hidden" name="accountIdKey" id="accountIdKey" value="${requestScope.accountIdKey}"/></p>
         <p>注册成功！<span id="jumpTo">5</span>秒后我将载着你回到  <a href="#">首页>></a></p>
        
        </div>
       
    </div>
   <%@ include file="/inc/foot.jsp"%>
</body>
</html>
