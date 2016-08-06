define('app/center/phone/setPhone', function (require, exports, module) {
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
    var UpdatePhonePager = Widget.extend({
    	//属性，使用时由类的构造函数传入
    	attrs: {
    	},
    	//事件代理
    	events: {
    		//key的格式: 事件+空格+对象选择器;value:事件方法
    		"click [id='sendPhoneBtn']":"_sendPhone",
    		"click [id='submitBtn']":"_updatePhone",
    		"blur [id='phone']":"_checkPhone",
    		"blur [id='verifyCode']":"_checkVerifyCode"
        },
    	//重写父类
    	setup: function () {
    		UpdatePhonePager.superclass.setup.call(this);
    		this._initShowView();
    	},
    	_checkPhone: function(){
    		var isOk = this._checkPhoneFormat();
    		if(isOk){
    			isOk = this._checkPhoneValue();
    		}
    		return isOk;
    	},
    	//检查手机格式
    	_checkPhoneFormat:function(){
    		var phone=jQuery.trim($("#phone").val());
    		var msg = "";
    		if(phone==""|| phone == null || phone == undefined){
    			msg ="请输入手机号码 ";
    		}else if(!/^1\d{10}$/.test(phone)){
    			msg = "手机号码格式错误";
    		}
    		if(msg == ""){
				this._controlMsgText("phoneMsg","");
				this._controlMsgAttr("phoneMsg",1);
				return true;
			}else{
				this._controlMsgText("phoneMsg",msg);
				this._controlMsgAttr("phoneMsg",2);
				return false;
			}
    	},
    	//初始化展示页面
		_initShowView:function(){
			 //左侧菜单显示样式
	   		$("#updatePhone").addClass("current");
	   		//标题显示
	   		$("#set_title_id").html("修改手机号");
		},
    	//检查新邮箱与原邮箱不同 不重复
    	_checkPhoneValue: function(){
			var _this = this;
			var isOk = false;
			ajaxController.ajax({
				type : "POST",
				data : {
					"phone": function(){
						return $("#phone").val()
					}
				},
				dataType: 'json',
				url :_base+"/center/phone/checkPhoneValue?k="+uuid,
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
						if(resultCode=="100005"){
				        	_this._controlMsgText("phoneMsg",data.statusInfo);
							_this._controlMsgAttr("phoneMsg",2);
							isOk = false;
				        }else{
				        	_this._controlMsgText("phoneMsg","");
				        	_this._controlMsgAttr("phoneMsg",1);
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
    	_sendPhone:function(){
    		var isOk = this._checkPhone();
    		if(!isOk){
    			return false;
    		}
    		$("#sendPhoneBtn").attr("disabled", true);
			var _this = this;
			ajaxController.ajax({
				type : "POST",
				data : {
					"phone": function(){
						return $("#phone").val()
					}
				},
				dataType: 'json',
				url :_base+"/center/phone/sendPhoneVerify?k="+uuid,
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
				            $("#sendPhoneBtn").attr("disabled", true);
				            var _res = setInterval(function(){
				                $("#sendPhoneBtn").attr("disabled", true);//设置disabled属性
				                $('#sendPhoneBtn').val('重新发送'+step);
				                step-=1;
				                if(step <= 0){
				                $("#sendPhoneBtn").removeAttr("disabled"); //移除disabled属性
				                $('#sendPhoneBtn').val('获取验证码');
				                clearInterval(_res);//清除setInterval
				                }
				            },1000);
						}else{
							$("#sendPhoneBtn").removeAttr("disabled");
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
					$("#sendPhoneBtn").removeAttr("disabled"); //移除disabled属性
				},
				error : function(){
					alert("网络连接超时!");
				}
			});
		},
		//更新手机
		_updatePhone:function(){
			var _this = this;
			var checkPhone = this._checkPhone();
			var checkVerify = this._checkVerifyCode();
			if(!(checkPhone&&checkVerify)){
				return false;
			}
			ajaxController.ajax({
				type : "POST",
				data : _this._getSafetyConfirmData(),
				dataType: 'json',
				url :_base+"/center/phone/setNewPhone?k="+uuid,
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
						if(statusCode == "100005"){
							_this._controlMsgText("phoneMsg",msg);
							_this._controlMsgAttr("phoneMsg",2);
						}else{
							_this._controlMsgText("phoneMsg","");
							_this._controlMsgAttr("phoneMsg",1);
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
				"phone":function () {
			        return jQuery.trim($("#phone").val())
			    },
				"verifyCode":function () {
			        return jQuery.trim($("#verifyCode").val())
			    }
			}
		}
		
    });
    
    
    module.exports = UpdatePhonePager
});
