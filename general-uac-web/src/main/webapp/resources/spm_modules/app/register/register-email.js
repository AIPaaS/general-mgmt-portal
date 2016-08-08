define('app/register/register-email', function (require, exports, module) {
    'use strict';
    var $=require('jquery'),
    Widget = require('arale-widget/1.2.0/widget'),
    Dialog = require("artDialog/src/dialog"),
    AjaxController=require('opt-ajax/1.0.0/index');
   
  
    
    //实例化AJAX控制处理对象
    var ajaxController = new AjaxController();
    
    //定义页面组件类
    var RegisterEmaillPager = Widget.extend({
    	//属性，使用时由类的构造函数传入
    	attrs: {
    	},
    	//重写父类
    	setup: function () {
    		RegisterEmaillPager.superclass.setup.call(this);
    		//初始化组件：上传服务数据模块
    		this._hideErroText();
    		this._bindHandle();
    	},
    	 init: function(){
    		 _hideErroText();
         },
    	_bindHandle: function(){
    		$("#email").on("blur",this._validServiceEmail);
    		$("#getIdentify").on("click",this._validServiceEmail);
    		$("#getIdentify").on("click",this._getIdentify);
    		$("#BTN_PASS").on("click",this._passEmail);
    		$("#BTN_SUBMIT").on("click",this._validServiceEmail);
    		$("#BTN_SUBMIT").on("click",this._checkIsVify);
    		$("#BTN_SUBMIT").on("click",this._bindEmail);
    	},
    	_hideErroText: function(){
    		var _this = this;
			//初始化展示业务类型
			_this._hideInfo();
    	},
    	_hideInfo: function(){
    		 $("#errorEmIdentifyMsg").attr("style","display:none");
    		 $("#errorEMsg").attr("style","display:none");
    	},
    	_validServiceEmail: function(){
    		$("#errorEmIdentifyMsg").attr("style","display:none");
    		var emailCode = $('#email').val();
    		if(emailCode!=""){
    			if(/^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/.test(emailCode)){
    				
    				var	param={
        					email:	$("#email").val()
        				   };
            		ajaxController.ajax({
        		        type: "post",
        		        processing: false,
        		        url: _base+"/reg/checkEmail",
        		        dataType: "json",
        		        data: param,
        		        message: "正在加载数据..",
        		        success: function (data) {
        		        	if(data.responseHeader.resultCode=="10004"){
        		        		$("#showErroeEMsg").html("邮箱已被其他账户绑定 ");
    		    				$("#errorEMsg").attr("style","display:");
    		    				$("#emailFlag").val("0");
    		    				return false;
    			        	}else if(data.responseHeader.resultCode=="000000"){
    			        		$("#errorEMsg").attr("style","display:none");
    		    				$("#emailFlag").val("1");
        		        	}
        		        },
        		        error: function(XMLHttpRequest, textStatus, errorThrown) {
        					 alert(XMLHttpRequest.status);
        					 alert(XMLHttpRequest.readyState);
        					 alert(textStatus);
        					   }
        		    }); 
    			}else{
    				$("#showErroeEMsg").text("邮箱地址格式错误 ");
    				$("#errorEMsg").attr("style","display:");
    				$("#emailFlag").val("0");
    				return false;
    			}
    		}else{
    			$("#showErroeEMsg").text("请输入邮箱地址 ");
				$("#errorEMsg").attr("style","display:");
				$("#emailFlag").val("0");
				return false;
    			
    		}
    	},
    	_checkIsVify: function(){
    		var emailIdenty = $('#identifyCode').val();
			if(emailIdenty==""){
				$("#showErroeEmIdentify").text("请输入邮箱验证码 ");
				$("#errorEmIdentifyMsg").attr("style","display:");
				$("#identifyFlag").val("0");
				return false;
			}else{
				$("#errorEmIdentifyMsg").attr("style","display:none");
				$("#identifyFlag").val("1");
			}
    	},
    	_getIdentify: function(){
    		var emailCode = $('#email').val();
    		if(emailCode==""){
    			$("#showErroeEMsg").text("请输入邮箱地址 ");
				$("#errorEMsg").attr("style","display:");
				$("#flag").val("0");
				return false;
    		}
    		var flag = $("#emailFlag").val();
    		if(flag!="0"){
    			var step = 59;
                $('#getIdentify').val('重新发送60');
                $("#getIdentify").attr("disabled", true);
                var _res = setInterval(function(){
                    $("#getIdentify").attr("disabled", true);//设置disabled属性
                    $('#getIdentify').val(step+'s后重新发送');
                    step-=1;
                    if(step <= 0){
                    $("#getIdentify").removeAttr("disabled"); //移除disabled属性
                    $('#getIdentify').val('获取验证码');
                    clearInterval(_res);//清除setInterval
                    }
                },1000);
    			var	param={
    					email:	$("#email").val(),
    					accountIdKey:$("#accountIdKey").val()
    				   };
        		ajaxController.ajax({
    		        type: "post",
    		        processing: false,
    		        url: _base+"/reg/toSendEmail",
    		        dataType: "json",
    		        data: param,
    		        message: "正在加载数据..",
    		        success: function (data) {
    		        	if(data.responseHeader.resultCode=="9999"){
			        		$('#showErroeEmIdentify').text("1分钟后可重复发送 ");
			    			$("#errorEmIdentifyMsg").attr("style","display:block");
			    			$("#identifyCode").val("");
							return false;
			        	}else if(data.responseHeader.resultCode=="100002"){
			        		var msg = data.statusInfo;
			        		$('#showErroeEmIdentify').text(msg);
			    			$("#errorEmIdentifyMsg").attr("style","display:block");
			    			$("#identifyCode").val("");
							return false;
			        	}else if(data.responseHeader.resultCode=="1100"){
    		        		window.location.href=_base+"/reg/toRegister";
    		        	}
    		        },
    		        error: function(XMLHttpRequest, textStatus, errorThrown) {
    					 alert(XMLHttpRequest.status);
    					 alert(XMLHttpRequest.readyState);
    					 alert(textStatus);
    					   }
    		    }); 
    		}
    		
    	},
    	_passEmail: function(){
    		var key = $("#accountIdKey").val()
    		window.location.href=_base+"/reg/toRegisterSuccess?key="+key;
    	},
    	
    	_bindEmail: function(){
    		var flag = $("#emailFlag").val();
    		var identiFlag = $("#identifyFlag").val();
    		if(flag!="0"&& identiFlag!="0"){
    			var	param={
    					email:	$("#email").val(),
    					accountIdKey:$("#accountIdKey").val(),
    					identifyCode:$("#identifyCode").val()
    				   };
        		ajaxController.ajax({
    			        type: "post",
    			        processing: false,
    			        url: _base+"/reg/bindEmail",
    			        dataType: "json",
    			        data: param,
    			        message: "正在加载数据..",
    			        success: function (data) {
    			        	if(data.responseHeader.resultCode=="000008"){
    			        		$("#showErroeEmIdentify").text("请重新获取验证码 ");
    		    				$("#errorEmIdentifyMsg").attr("style","display:block");
    		    				$('#identifyCode').val("");
    		    				return false;
    			        	}else if(data.responseHeader.resultCode=="000005"){
    			        		$("#showErroeEmIdentify").text("邮箱验证码已失效 ");
    		    				$("#errorEmIdentifyMsg").attr("style","display:block");
    		    				return false;
    			        	}else if(data.responseHeader.resultCode=="000006"){
    			        		$("#showErroeEmIdentify").html("验证码错误 ");
    		    				$("#errorEmIdentifyMsg").attr("style","display:block");
    		    				return false;
    			        	}else if(data.responseHeader.resultCode=="10004"){
    			        		$("#showErroeEmIdentify").html("邮箱已被其他账户绑定 ");
    		    				$("#errorEmIdentifyMsg").attr("style","display:block");
    		    				$('#identifyCode').val("");
    		    				return false;
    			        	}else if(data.responseHeader.resultCode=="1100"){
    			        		window.location.href=_base+"/reg/toRegister";
    			        	}else if(data.responseHeader.resultCode=="000000"){
    			        		$("#errorEmIdentifyMsg").attr("style","display:none");
    			        		var key = $("#accountIdKey").val()
    			        		window.location.href=_base+"/reg/toRegisterSuccess?key="+key;
    			        	}
    			        },
    			        error: function(XMLHttpRequest, textStatus, errorThrown) {
    						 alert(XMLHttpRequest.status);
    						 alert(XMLHttpRequest.readyState);
    						 alert(textStatus);
    						   }
    			    }); 
    		}
    		
    	}
    	
    });   
    module.exports = RegisterEmaillPager
});

