define('app/retakepassword/userInfo', function (require, exports, module) {
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
    var UsetInfoPager = Widget.extend({
    	//属性，使用时由类的构造函数传入
    	attrs: {
    	},
    	//事件代理
    	events: {
    		//key的格式: 事件+空格+对象选择器;value:事件方法
    		"click [id='submitBtn']":"_checkUserInfo",
    		"click [id='random_img']":"_getImageRandomCode",
    		"click [id='changeImage']":"_getImageRandomCode",
    		"blur [id='userName']":"_checkUserName",
    		"blur [id='pictureVerifyCode']":"_checkVerifyCode"
        },
        init: function(){
        	_getImageRandomCode();
        	_hideErrorInfo();
        },
    	//重写父类
    	setup: function () {
    		UsetInfoPager.superclass.setup.call(this);
    		this._hideErrorInfo();
    	},
    	_getImageRandomCode:function(){
    		//隐藏错误提示
    		$("#verifyCodeMsg").attr("style","display:none");
			var timestamp = (new Date()).valueOf();
			$("#pictureVerifyCode").val("");
			$("#random_img").attr("src",_base+"/retakePassword/getUserImageVerifyCode?timestamp="+timestamp);
		},
		//隐藏错误信息
		_hideErrorInfo: function(){
   		 $("#userNameMsg").attr("style","display:none");
   		 $("#verifyCodeMsg").attr("style","display:none");
		},
		//检查用户名格式
		_checkUserName: function(){
			var userName = jQuery.trim($("#userName").val());
			if(userName == "" || userName == null || userName == undefined){
	    		this._controlMsgText("userNameMsg","请输入用户名");
				this._controlMsgAttr("userNameMsg",2);
				return false;
			}else{
				this._controlMsgText("userNameMsg","");
				this._controlMsgAttr("userNameMsg",1);
				return true;
			}
		},
		//检查验证码
		_checkVerifyCode: function(){
			var verifyCode = jQuery.trim($("#pictureVerifyCode").val());
			if(verifyCode == "" || verifyCode == null || verifyCode == undefined){
				this._controlMsgText("verifyCodeMsg","请输入图形验证码");
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
		//检查账户信息
    	_checkUserInfo: function(){
    		var _this = this;
    		var checkusername = this._checkUserName();
    		var checkverifycode = this._checkVerifyCode();
    		if(!(checkverifycode&&checkusername)){
    			return false;
    		}
			ajaxController.ajax({
				type : "POST",
				data : {
					"username":function(){
						return jQuery.trim($("#userName").val());
					},
					"pictureVerifyCode":function(){
						return jQuery.trim($("#pictureVerifyCode").val());
					}
				},
				dataType: 'json',
				url :_base+"/retakePassword/checkUserInfo",
				processing: true,
				message : "正在处理中，请稍候...",
				success : function(data) {
					var status = data.responseHeader.resultCode;
					if(status == "000000"){
						var url = data.data;
						window.location.href = _base+url;
					}else{
						var msg = data.statusInfo;
						//用户名
						if(status == "100004"){
							_this._controlMsgText("userNameMsg",msg);
							_this._controlMsgAttr("userNameMsg",2);
						}else{
							_this._controlMsgText("userNameMsg","");
							_this._controlMsgAttr("userNameMsg",1);
						}
						//图片验证码
						if(status == "100001"){
							_this._controlMsgText("verifyCodeMsg",msg);
							_this._controlMsgAttr("verifyCodeMsg",2);
						}else{
							_this._controlMsgText("verifyCodeMsg","");
							_this._controlMsgAttr("verifyCodeMsg",1);
						}
					}
				},
				error: function() {
					alert("连接服务器超时")
				}
			});
		}		
    });
    
    module.exports = UsetInfoPager
});
