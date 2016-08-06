<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html >
<head>
<!--Support IE Text -->
<meta http-equiv="X-UA-Compatible" content="IE=Edge" /> 
<%@ include file="/inc/inc.jsp"%>
    <title>基本信息</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
(function () {
	seajs.use('app/center/baseinfo/initBaseInfo', function (BaseInfoPager) {
		var pager = new BaseInfoPager();
		pager.render();
	});
})(); 
function jsmethod(){
    document.getElementById("nickName").focus();
}
</script>
</head>

<body>

  <%@ include file="/inc/head-user.jsp"%>
  <div class="box">
  <%@ include file="/inc/left-menu.jsp"%>
  <div class="wrapper">
      
      <div class="Basic-information">
      <div class="information-wrap">
      
           <div class="information-left"><!--基本信息左边-->
          
          <div class="information-left-account">
          <ul>
          <li ><img src="${_base}/theme/baas/images/account.png" class="account-img"></li>
          <li class="word">账户信息</li>
          </ul>
          </div>
          
          <div class="information-cnt">
          <ul>
          <li class="user">
          <p class="word">用户名</p>
          <p>
          	${accountInfo.phone}
          	<input type="hidden" id="accountId" value="${accountInfo.accountId}">
          	<input type="hidden" id="tenantId" value="${accountInfo.tenantId}">
          	<input type="hidden" id="state" value="${accountInfo.state}">
          	<input type="hidden" id="industryCode" value="${accountInfo.industryCode}">
          	<input type="hidden" id="industryCodeValue" value="${accountInfo.industryCodeValue}">
          	<input type="hidden" id="flag">
          </p>
          </li>
          
          <li class="user">
          <p class="word">昵称</p>
          <p class="ctn-a" id="initNickName">
         <span id="showNick">${accountInfo.nickName}</span> 
          <input type="hidden" value="${accountInfo.nickName}" id="nk">
          <a href="javascript:void(0);"><i class="icon-edit"></i></a>
          </p>
          <p class="ctn-b" style=" display:none;" id="setnick" >
          	<input type="text" id="nickName" value="${accountInfo.nickName}" class="int-medium"  onmouseout="jsmethod()">
          </p>
          <span id="showNickNameMsg" class="regsiter-note" style="display:none"></span>
          <%-- <span  id="errorNickNameMsg">
		     <i class="icon-caret-left"></i>
		     <img src="${_base}/theme/baas/images/error.png"><span id="showNickNameMsg"></span>
		  </span> --%>
          </li>
          
           <li class="user">
          <p class="word">手机号码</p>
          <p>${accountInfo.phone}</p>
          <p><a href="${_base}/center/phone/confirminfo">去修改</a></p>
          </li>
          
           <li class="user">
           <div id="bandEmail">
	           	<p class="word">邮箱</p>
	          	<p>
	          		<a href="${_base}/center/bandEmail/confirminfo"><i class="icon-link"></i>绑定邮箱</a>
	          		<input type="hidden" id="email" value="${accountInfo.email}">
	          	</p>
           </div>
          <div id="haveEmail">
	          <p class="word">邮箱</p>
	          <p id="email">${accountInfo.email}</p>
	          <p><a href="${_base}/center/email/confirminfo">去修改</a></p>
          </div>
          </li>

          </ul>
 
        </div>
       </div>  
       
       
            <div class="information-left information-right"><!--基本信息右边-->
          
          <div class="information-left-account">
          <ul>
          <li ><img src="${_base}/theme/baas/images/account-qiy.png" class="account-img"></li>
          <li class="word">企业信息</li>
          </ul>
          </div>
          
          <div class="information-cnt">
          <ul>
	          <div id="allInfo">
		          <li class="user">
		          <p class="word">企业名称</p>
		          <p>
		          	<input type="text" class="int-medium" placeholder="" id="tenantName" value="${accountInfo.tenantName}">
		          	<span id="showTenMsg" class="regsiter-note" style="display:none"></span>
		          </p>
		          <%-- <span  id="errorTenMsg">
		         		<i class="icon-caret-left"></i>
		         		<img src="${_base}/theme/baas/images/error.png"><span id="showTenMsg"></span>
		         	</span> --%>
		          </li>
		          
		          <li class="user">
		          <p class="word">企业类型</p>
		          <p>
		          	<select class="select-medium" id="indutry">
		          	</select>
		          	<span id="showTypeMsg" class="regsiter-note" style="display:none"></span>
		          </p>
		         <%--  <span  id="errorTypeMsg">
		         		<i class="icon-caret-left"></i>
		         		<img src="${_base}/theme/baas/images/error.png"><span id="showTypeMsg"></span>
		         	</span> --%>
		          </li>
	   			</div>
	   			<div id="oneInfo">
	   				<ul>
			          <li class="user">
			          <p class="word">企业名称</p>
			          <p >
			          	${accountInfo.tenantName}
			          	<input type="hidden" id="tenant" value="${accountInfo.tenantName}">
			          </p>
			          </li>
			          <li class="user">
			          <p class="word">企业类型</p>
			          <p>${accountInfo.industryCode}</p>
			          </li>
          			</ul>
	   			</div>

          </ul>
 
        </div>
          
        
        
        </div>
        
        </div>
      
        <div class="btn_wrap" >
        	<input type="button" class="information-btn" value="提  交" id="submitBtn" >
        	
        </div>
        
    
  	</div>
   </div>
  </div>
  <%@ include file="/inc/foot.jsp"%>
</body>
</html>
