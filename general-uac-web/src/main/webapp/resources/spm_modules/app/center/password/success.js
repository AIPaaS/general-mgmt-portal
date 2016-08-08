define('app/center/password/success', function (require, exports, module) {
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
    var SuccessPager = Widget.extend({
    	//属性，使用时由类的构造函数传入
    	attrs: {
    	},
    	//事件代理
    	events: {
    		//key的格式: 事件+空格+对象选择器;value:事件方法
    		"click [id='gotoLogin']":"_gotoLogin"
        },
    	//重写父类
    	setup: function () {
    		SuccessPager.superclass.setup.call(this);
    		this._autoGotoLogin();
    		this._initShowView();
    	},
    	_initShowView:function(){
			 //左侧菜单显示样式
	   		$("#updatePassword").addClass("current");
	   		//标题显示
	   		$("#set_title_id").html("修改密码");
		},
    	_autoGotoLogin:function(){
    		var _this = this;
    		var step = 4;
    		$('#message').text('恭喜您，密码修改成功！5秒后跳转到登录页面  ');
    		var _res = setInterval(function(){
                $('#message').text('恭喜您，密码修改成功！'+step+'秒后跳转到登录页面 ');
                step-=1;
                if(step == 0){
                	_this._gotoLogin();
                	clearInterval(_res);//清除setInterval
                }
            },1000);
    	},
    	_gotoLogin: function(){
    		window.location.href = _base+"/ssologout";
		}		
    });
    
    module.exports = SuccessPager
});
