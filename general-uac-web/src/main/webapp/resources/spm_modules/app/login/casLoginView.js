$(function(){
	var errors=$("#errorMsg").html();
	if(isNull(errors)){
		resetErrMsg();
	}
	else{
		showErrMsg(errors);
	}
	
	
	$("#username").bind("blur",function(){
		resetErrMsg();
	});
	$("#password").bind("blur",function(){
		resetErrMsg();
	});
	
});


function showErrMsg(msg){
	$("#errorMsg").html(msg);
	//$("div.loginErr").show();
}
function resetErrMsg(){
	$("#errorMsg").html("");
	//$("div.loginErr").hide();
}

  function encryptPwd(event){
  	if (event.keyCode == 13){//IE Chrome 回车键
  		dologin(); 
  	}
  	else {
  		if (event.which == 13){//Firefox 回车键
  			dologin(); 
  		}
  	}
  }//end of encryPwd
  
  function dologin() {
  	if(validate()){ 
		var inputPassword = document.getElementById("password").value;
		/*var onceCode = "AIOPT_SALT_KEY";
		var passwordMd5 = hex_md5(onceCode
				+ hex_md5(inputPassword));*/
		document.getElementById("password").value = inputPassword;
		document.getElementById("username").value = $.trim(document
				.getElementById("username").value);
		//提交表单
		document.getElementById('fm1').submit();
		return true;
  	 }
  	else{
  		return false;
  	} 
	
}//end of dologin
 
function validate() {
	var username=document.getElementById("username").value;
	var password=document.getElementById("password").value;
	var captcha=document.getElementById("captchaCode").value;
	try {
		if (isNull(username)) {
			showErrMsg("请输入手机号码或邮箱地址");
			return false;
		}else{
			resetErrMsg();
		}
		if (isNull(password)) {
			showErrMsg("请输入密码");
			return false;
		}else{
			resetErrMsg();
		}
		if (isNull(captcha)) {
			showErrMsg("请输入验证码");
			return false;
		}else{
			resetErrMsg();
		}
		
		return true;
	} catch (ex) {
		return false;
	} 			
}//end of validate

// 刷新验证码
function reloadImage(url) {
	document.getElementById('pictureVitenfy').src = url+"?id=" + Math.random();
}

function encryptCaptcha(event) {
	if (event.keyCode == 13) {// IE Chrome 回车键
	dologin();
} else {
	if (event.which == 13) {// Firefox 回车键
			dologin();
		}
	}
}// end of encryPwd
  		
  		
  		
  		
  		
  		
  		
  		
  		
  		
  		
  		
  		
  		$(document).ready(function(){
  			$("#errclose").click(function(){
  				$('.loginErr').hide();
  				
  			})
  		})
  		$("#username").focus(function(){
  			$("#username").css({"background-color":"#D6D6FF","border":"1PX #ddd solid"});
  	  });
  		$("#username").blur(function(){
  	    	$("#username").css({"background-color":"#fff","border":"1PX #ddd solid"});
  	    	if($("#username").val()==''){
  	    		$('.NameEmpty').css("display","block");
  	    	};
  	  });
  		$("#password").focus(function(){
  			$("#password").css({"background-color":"#D6D6FF","border":"1PX #ddd solid"});
  	  });
  		$("#password").blur(function(){
  	    	$("#password").css({"background-color":"#fff","border":"1PX #ddd solid"});
  	    	if($("#username").val()==''){
  	    		$('.PassEmpty').css("display","block");
  	    	};
  	  });