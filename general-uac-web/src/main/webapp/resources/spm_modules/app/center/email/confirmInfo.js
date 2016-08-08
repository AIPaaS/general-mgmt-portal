define('app/center/email/confirmInfo', function (require, exports, module) {
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
    var ConfirmInfoPager = Widget.extend({
    	//属性，使用时由类的构造函数传入
    	attrs: {
    	},
    	//事件代理
    	events: {
    		//key的格式: 事件+空格+对象选择器;value:事件方法
    		"click [id='submitBtn']":"_confirmInfo",
    		"click [id='sendVerify']":"_sendVerify",
    		"click [id='random_img']":"_getImageRandomCode",
    		"click [id='changeImage']":"_getImageRandomCode",
    		"click [id='changeConfirmType']":"_changeShowViewByType",
    		"blur [id='pictureVerifyCode']":"_checkPictureVerifyCode",
    		"blur [id='verifyCode']":"_checkVerifyCode"
        },
        init: function(){
        	_initShowView();
        	_getImageRandomCode();
        	var _res;
        },
    	//重写父类
    	setup: function () {
    		ConfirmInfoPager.superclass.setup.call(this);
    		this._renderAccountInfo();
    	},
    
    	//加载账户数据
    	_renderAccountInfo: function(){
			var _this = this;
			//初始化展示页面
			_this._initShowView();
		},
		//初始化展示页面
		_initShowView:function(){
			 //左侧菜单显示样式
	   		$("#updateEmail").addClass("current");
	   		//标题显示
	   		$("#set_title_id").html("修改邮箱");
			$("#confirmType").val("1");
			$("#confirmTypeName").html("已验证手机");
			$("#verifyName").html("短信校验码");
			$("#email").attr("style","display:none");
			$("#phone").removeAttr("style");
			if(email != "" && email != null && email != undefined){
				$("#changeConfirmType").removeAttr("disabled");
				$("#changeConfirmType").html("通过已验证邮箱验证");
			}else{
				$("#changeConfirmType").attr("disabled", true);
				$("#changeConfirmType").html("");
			}
		},
		//身份认证方式改变触发事件
		_changeShowViewByType:function(){
			var _this = this;
			var confirmType=$('#confirmType').val();
			if(confirmType == "1"){
				$('#confirmType').val("2")
				$("#confirmTypeName").html("已验证邮箱");
				$("#changeConfirmType").html("通过已验证手机验证");
				$("#verifyName").html("邮箱校验码");
				$("#email").removeAttr("style");
				$("#phone").attr("style","display:none");
			}else if(confirmType == "2"){
				$("#confirmType").val("1");
				$("#confirmTypeName").html("已验证手机");
				$("#changeConfirmType").html("通过已验证邮箱验证");
				$("#verifyName").html("短信校验码");
				$("#email").attr("style","display:none");
				$("#phone").removeAttr("style");
			}
			//获取新的图片验证码
			this._getImageRandomCode();
			//清空验证码
			$("#verifyCode").val("");
			//移除发送验证码倒计时
			$("#sendVerify").removeAttr("disabled"); //移除disabled属性
            $('#sendVerify').val('获取验证码');
			clearInterval(_this._res);
			//清空错误提示
			this._controlMsgText("verifyCodeMsg","");
			this._controlMsgAttr("verifyCodeMsg",1);
		},
		_getImageRandomCode:function(){
			//隐藏错误提示
			this._controlMsgText("pictureVerifyMsg","");
			this._controlMsgAttr("pictureVerifyMsg",1);
			var timestamp = (new Date()).valueOf();
			$("#pictureVerifyCode").val("");
			$("#random_img").attr("src",_base+"/center/email/getImageVerifyCode?timestamp="+timestamp);
		},
		_sendVerify:function(){
			$("#sendVerify").attr("disabled", true);
			var _this = this;
			ajaxController.ajax({
				type : "POST",
				data : {
				},
				dataType: 'json',
				url :_base+"/center/email/sendVerify?confirmType="+$("#confirmType").val(),
				processing: true,
				message : "正在处理中，请稍候...",
				success : function(data) {
					var resultCode = data.responseHeader.resultCode;
					if(resultCode=="100000"){
						var url = data.data;
						window.location.href = _base+url;
					}else{
						if(resultCode=="000000"){
							var step = 59;
				            $('#sendVerify').val('60s后重新发送');
				            $("#sendVerify").attr("disabled", true);
				            _this._res = setInterval(function(){
				                $("#sendVerify").attr("disabled", true);//设置disabled属性
				                $('#sendVerify').val(step+'s后重新发送');
				                step-=1;
				                if(step <= 0){
				                $("#sendVerify").removeAttr("disabled"); //移除disabled属性
				                $('#sendVerify').val('获取验证码');
				                clearInterval(_this._res);//清除setInterval
				                }
				            },1000);
						}else{
							$("#sendVerify").removeAttr("disabled"); //移除disabled属性
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
					$("#sendVerify").removeAttr("disabled"); //移除disabled属性
				},
				error : function(){
					alert("网络连接超时!");
				}
			});
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
		//检查验证码
		_checkPictureVerifyCode: function(){
			var verifyCode = jQuery.trim($("#pictureVerifyCode").val());
			if(verifyCode == "" || verifyCode == null || verifyCode == undefined){
				this._controlMsgText("pictureVerifyMsg","请输入图形验证码");
				this._controlMsgAttr("pictureVerifyMsg",2);
				return false;
			}else{
				this._controlMsgText("pictureVerifyMsg","");
				this._controlMsgAttr("pictureVerifyMsg",1);
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
		//检查身份信息
		_confirmInfo:function(){
			var _this = this;
			var checkVerifyCode = this._checkVerifyCode();
			var checkPoctureVerifyCode = this._checkPictureVerifyCode();
			if(!(checkVerifyCode&&checkPoctureVerifyCode)){
    			return false;
    		}
			ajaxController.ajax({
				type : "POST",
				data : _this._getSafetyConfirmData(),
				dataType: 'json',
				url :_base+"/center/email/confirmInfo",
				processing: true,
				message : "正在处理中，请稍候...",
				success : function(data) {
					var status = data.responseHeader.resultCode;
					if(status == "000000"){
						var url = data.data;
						window.location.href = _base+url;
					}else{
						var msg = data.statusInfo;
						//验证码
						if(status == "100002"){
							_this._controlMsgText("verifyCodeMsg",msg);
							_this._controlMsgAttr("verifyCodeMsg",2);
						}else{
							_this._controlMsgText("verifyCodeMsg","");
							_this._controlMsgAttr("verifyCodeMsg",1);
						}
						//图片验证码
						if(status == "100001"){
							_this._controlMsgText("pictureVerifyMsg",msg);
							_this._controlMsgAttr("pictureVerifyMsg",2);
						}else{
							_this._controlMsgText("pictureVerifyMsg","");
							_this._controlMsgAttr("pictureVerifyMsg",1);
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
				"confirmType":function () {
			        return jQuery.trim($("#confirmType").val())
			    },
				"pictureVerifyCode":function () {
			        return jQuery.trim($("#pictureVerifyCode").val())
			    },
				"verifyCode":function () {
			        return jQuery.trim($("#verifyCode").val())
			    }
			}
		}
		
    });
    
    
    module.exports = ConfirmInfoPager
});
