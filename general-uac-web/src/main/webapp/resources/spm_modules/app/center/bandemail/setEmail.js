define('app/center/bandemail/setEmail', function (require, exports, module) {
    'use strict';
    var $=require('jquery'),
    Widget = require('arale-widget/1.2.0/widget'),
    Dialog = require("artDialog/src/dialog"),
    Uploader = require('arale-upload/1.2.0/index'),
    AjaxController=require('opt-ajax/1.0.0/index');
    
    require("jsviews/jsrender.min");
    require("jsviews/jsviews.min");
    require("treegrid/js/jquery.treegrid.min");
    require("treegrid/js/jquery.cookie");
    
    
    //实例化AJAX控制处理对象
    var ajaxController = new AjaxController();
    
    //定义页面组件类
    var BandEmailPager = Widget.extend({
    	//属性，使用时由类的构造函数传入
    	attrs: {
    	},
    	//事件代理
    	events: {
    		//key的格式: 事件+空格+对象选择器;value:事件方法
    		"click [id='sendEmailBtn']":"_sendEmail",
    		"click [id='submitBtn']":"_updateEmail",
    		"blur [id='email']":"_checkEmail",
    		"blur [id='verifyCode']":"_checkVerifyCode"
        },
        init: function(){
        	_showClass();
        	
        },
    	//重写父类
    	setup: function () {
    		BandEmailPager.superclass.setup.call(this);
    		this._renderClass();
    	},
    	//加载账户数据
    	_renderClass: function(){
			var _this = this;
			//初始化展示页面
			_this._showClass();
		},
    	_showClass: function(){
    		 //左侧菜单显示样式
	   		$("#setEmail").addClass("current");
	   		//标题显示
	   		$("#set_title_id").html("绑定邮箱");
	   		$("#updateEmail").addClass("current");
    	},
    	_checkEmail:function(){
    		var isOk = this._checkEmailFormat();
    		if(isOk){
    			isOk = this._checkEmailValue();
    		}
    		return isOk;
    	},
    	//检查新密码格式
		_checkEmailFormat: function(){
			var email = jQuery.trim($("#email").val());
			var msg = "";
			if(email == "" || email == null || email == undefined){
				msg = "请输入邮箱地址";
			}else if(!/^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/.test(email)){
				msg = "邮箱地址格式错误";
			}
			if(msg == ""){
				this._controlMsgText("emailMsg","");
				this._controlMsgAttr("emailMsg",1);
				return true;
			}else{
				this._controlMsgText("emailMsg",msg);
				this._controlMsgAttr("emailMsg",2);
				return false;
			}
		},
		//检查新邮箱是否唯一
		_checkEmailValue: function(){
			var _this = this;
			var isOk = false;
			ajaxController.ajax({
				type : "POST",
				data : {
					"email": function(){
						return $("#email").val()
					}
				},
				dataType: 'json',
				url :_base+"/center/bandEmail/checkEmailValue",
				async: false,
				processing: true,
				message : "正在处理中，请稍候...",
				success : function(data) {
					var resultCode = data.responseHeader.resultCode;
					if(resultCode == "100000"){
						isOk = false;
						var url = data.data;
						window.location.href = _base+url;
					}else{
						if(resultCode=="100006"){
				        	_this._controlMsgText("emailMsg",data.statusInfo);
							_this._controlMsgAttr("emailMsg",2);
							isOk = false;
				        }else{
				        	_this._controlMsgText("emailMsg","");
				        	_this._controlMsgAttr("emailMsg",1);
				        	isOk = true;
				        }
					}
				},
				error : function(){
					alert("网络连接超时!");
				}
			});
			return isOk;
		},
		//检查验证码
		_checkVerifyCode: function(){
			var verifyCode = jQuery.trim($("#verifyCode").val());
			if(verifyCode == "" || verifyCode == null || verifyCode == undefined){
				this._controlMsgText("verifyCodeMsg","请输入验证码");
				this._controlMsgAttr("verifyCodeMsg",2);
				return false;
			}else{
				this._controlMsgText("verifyCodeMsg","");
				this._controlMsgAttr("verifyCodeMsg",1);
				return true;
			}
		},
		//控制显示内容
		_controlMsgText: function(id,msg){
			var doc = document.getElementById(id+"");
			doc.innerText=msg;
		},
		//控制显隐属性 1:隐藏 2：显示
		_controlMsgAttr: function(id,flag){
			var doc = document.getElementById(id+"");
			if(flag == 1){
				doc.setAttribute("style","display:none");
			}else if(flag == 2){
				doc.setAttribute("style","display");
			}
		},
    	_sendEmail:function(){
			var _this = this;
			var isOk = this._checkEmail();
			if(!isOk){
				return false;
			}
			$("#sendEmailBtn").attr("disabled", true);
			ajaxController.ajax({
				type : "POST",
				data : {
					"email": function(){
						return $("#email").val()
					}
				},
				dataType: 'json',
				url :_base+"/center/bandEmail/sendEmailVerify?k="+uuid,
				processing: true,
				message : "正在处理中，请稍候...",
				success : function(data) {
					var resultCode = data.responseHeader.resultCode;
					if(resultCode == "100000"){
						var url = data.data;
						window.location.href = _base+url;
					}else{
						if(resultCode=="000000"){
							var step = 59;
				            $('#sendPhoneBtn').val('重新发送60');
				            $("#sendEmailBtn").attr("disabled", true);
				            var _res = setInterval(function(){
				                $("#sendEmailBtn").attr("disabled", true);//设置disabled属性
				                $('#sendEmailBtn').val('重新发送'+step);
				                step-=1;
				                if(step <= 0){
				                $("#sendEmailBtn").removeAttr("disabled"); //移除disabled属性
				                $('#sendEmailBtn').val('获取验证码');
				                clearInterval(_res);//清除setInterval
				                }
				            },1000);
						}else{
							$("#sendEmailBtn").removeAttr("disabled");
						}
						if(resultCode=="100002"){
							_this._controlMsgText("verifyCodeMsg",data.statusInfo);
							_this._controlMsgAttr("verifyCodeMsg",2);
			        	}else{
			        		_this._controlMsgText("verifyCodeMsg","");
			        		_this._controlMsgAttr("verifyCodeMsg",1);
			        	}
					}
				},
				failure : function(){
					$("#sendEmailBtn").removeAttr("disabled"); //移除disabled属性
				},
				error : function(){
					alert("网络连接超时!");
				}
			});
		},
		//更新邮箱
		_updateEmail:function(){
			var _this = this;
			var checkEmail = this._checkEmail();
			var checkVerify = this._checkVerifyCode();
			if(!(checkEmail&&checkVerify)){
				return false;
			}
			ajaxController.ajax({
				type : "POST",
				data : _this._getSafetyConfirmData(),
				dataType: 'json',
				url :_base+"/center/bandEmail/setNewEmail?k="+uuid,
				processing: true,
				message : "正在处理中，请稍候...",
				success : function(data) {
					var statusCode = data.responseHeader.resultCode;
					if(statusCode == "000000" || statusCode == "100000"){
						var url = data.data;
						window.location.href = _base+url;
					}else {
						var msg = data.statusInfo;
						if(statusCode == "100002"){
							_this._controlMsgText("verifyCodeMsg",msg);
							_this._controlMsgAttr("verifyCodeMsg",2);
						}else{
							_this._controlMsgText("verifyCodeMsg","");
							_this._controlMsgAttr("verifyCodeMsg",1);
						}
						if(statusCode == "100006"){
							_this._controlMsgText("emailMsg",msg);
							_this._controlMsgAttr("emailMsg",2);
						}else{
							_this._controlMsgText("emailMsg","");
							_this._controlMsgAttr("emailMsg",1);
						}
					}
				},
				error : function(){
					alert("网络连接超时，请重新修改登录密码");
				}
			});
		},
		//获取界面填写验证信息
		_getSafetyConfirmData:function(){
			return{
				"email":function () {
			        return jQuery.trim($("#email").val())
			    },
				"verifyCode":function () {
			        return jQuery.trim($("#verifyCode").val())
			    }
			}
		}
		
    });
    
    
    module.exports = BandEmailPager
});
