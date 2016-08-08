define('app/inc/leftmenu', function (require, exports, module) {
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
    var LeftMenu = Widget.extend({
    	//属性，使用时由类的构造函数传入
    	attrs: {
    	},
        init: function(){
        	_getImageRandomCode();
        },
    	//重写父类
    	setup: function () {
    		LeftMenu.superclass.setup.call(this);
    		this._controlMenu();
    	},
		//检查账户信息
    	_controlMenu: function(){
    		var _this = this;
			ajaxController.ajax({
				type : "POST",
				async : false,
				url :_base+"/leftMenu/isHasEmail",
				processing: true,
				message : "正在处理中，请稍候...",
				success : function(data) {
					var status = data.statusCode;
					if(status == "1" ){
						var resultCode = data.data;
						if(resultCode == "1"){
							$("#updateEmail").html("<a href='"+_base+"/center/email/confirminfo' >修改邮箱</a>");
						}else if(resultCode == "0"){
							$("#updateEmail").html("<a href='"+_base+"/center/bandEmail/confirminfo' >绑定邮箱</a>");
						}
					}
				},
				error: function() {
					alert("连接服务器超时")
				}
			});
		}		
    });
    
    module.exports = LeftMenu
});
