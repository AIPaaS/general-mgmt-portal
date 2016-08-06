define('app/register/register-success', function (require, exports, module) {
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
    var RegisterSucessPager = Widget.extend({
    	//属性，使用时由类的构造函数传入
    	attrs: {
    	},
    	//事件代理
    	events: {
    		//key的格式: 事件+空格+对象选择器;value:事件方法
    		//"click [id='submitBtn']":"_confirmInfo",
    		
        },
        init: function(){
        	_addLogin();
        },
    	//重写父类
    	setup: function () {
    		RegisterSucessPager.superclass.setup.call(this);
    		//this._renderIndustryInfo();
    		////this._submit();
    		this._addLogin();
    	},
    	_addLogin: function(){
    		var _this = this;
			//初始化展示页面
			_this._login();
    	},
		_login: function(){
			var key = $("#accountIdKey").val();
			/*
			 var jumpTo = document.getElementById('jumpTo');
			 jumpTo.innerHTML=secs;  
			 if(--secs>0){     
			     setTimeout("_login("+secs+",'"+surl+"')",1000);     
			     }     
			 else{ */      
			     //location.href=_base+"/reg/login?accountIdKey="+key;     
			     ajaxController.ajax({
						url :_base+"/reg/login?accountIdKey="+key,
						processing: true,
						message : "正在处理中，请稍候...",
						success : function(data) {
							//var status = data.responseHeader.isSuccess;
							var status=data.responseHeader.resultCode;
							var url = data.data;
							window.location.href = _base+url;
						},
						error: function() {
							alert("连接服务器超时")
						}
					});
			  //} 
			
			
			
		}
    });
    
    
    module.exports = RegisterSucessPager
});
