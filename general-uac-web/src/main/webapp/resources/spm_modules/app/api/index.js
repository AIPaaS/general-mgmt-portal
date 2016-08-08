define('app/api/index', function (require, exports, module) {
    'use strict';
    var $=require('jquery'),
    Widget = require('arale-widget/1.2.0/widget'),
    Dialog = require("artDialog/src/dialog"),
    Uploader = require('arale-upload/1.2.0/index'),
    AjaxController=require('opt-ajax/1.0.0/index');
    
    require("jsviews/jsrender.min");
    require("jsviews/jsviews.min");
    
    
    //实例化AJAX控制处理对象
    var ajaxController = new AjaxController();
    
    //定义页面组件类
    var IndexPager = Widget.extend({
    	//属性，使用时由类的构造函数传入
    	attrs: {
    	},
    	//事件代理
    	events: {
    		//key的格式: 事件+空格+对象选择器;value:事件方法
          // "click #BTN_UPLOAD": "_sumbit"
        },
    	//重写父类
    	setup: function () {
    		IndexPager.superclass.setup.call(this);
    		//初始化组件：上传服务数据模块
    		this._initComponents();
    		this._loadAllAPIs();
    	},
    	
    	_initComponents: function(){
    		var _this = this;
    		
    		var processingDialog = Dialog({
    	        content: "<div class='loading'>正在处理中，请稍候..</div>"
    	    });
    	    
    	    var uploader = new Uploader({
    	        trigger: '#BTN_UPLOAD',
    	        name: 'dataFile',
    	        action: '../api/indexdata/upload',
    	        progress: function(e, position, total, percent, files) {
    	        	processingDialog.content("<div class='loading'>正在处理中，已经完成"+ percent + "%..</div>");
    	        }
    	    }).change(function(files) {
    	    	processingDialog.showModal();
    	    	this.submit();
    	    }).success(function(response) {
    	    	processingDialog.close();
    	    	//加载所有API数据
    	    	_this._loadAllAPIs();
    	    }).error(function(file) {
    	    	alert("上传服务数据失败");
    	    	processingDialog.close();
    	    });
    	},
    	
    	_loadAllAPIs: function(){
    		ajaxController.ajax({
    			type: "post",
    			processing: true,
    			message: "正在加载服务模块数据，请等待...",
    			url: "../api/apiownertypes",
    			success: function(d){
    				var ownerStatTemplate = $.templates("#ownerStatTemplate");
                    var html = ownerStatTemplate.render(d);
                    $("#OwnerStatDIV").html(html);
    			}
    		})
    	}
    });
    
    module.exports = IndexPager
});

