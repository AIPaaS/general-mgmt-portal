define('app/sandbox/apireqparamset', function (require, exports, module) {
    'use strict';
    var $=require('jquery'),
    Widget = require('arale-widget/1.2.0/widget'),
    AjaxController=require('opt-ajax/1.0.0/index');

    require("jsviews/jsrender.min");
    require("jsviews/jsviews.min");
    require("treegrid/js/jquery.cookie");
	require("jsoneditor/5.1.5/jsoneditor.min.css");
	require("jsoneditor/5.1.5/jsoneditor.min");
    //实例化AJAX控制处理对象
    var ajaxController = new AjaxController();
    var reqEditors;
    
    //定义页面组件类
    var SearchAPIReqParams = Widget.extend({
    	//属性，使用时由类的构造函数传入
    	attrs: {
    	},
    	//事件代理
    	events: {
    		//key的格式: 事件+空格+对象选择器;value:事件方法
            "click #BTN_SUBMIT":"submit"          
        },
    	//重写父类
    	setup: function () {
    		SearchAPIReqParams.superclass.setup.call(this);
    		//加载数据
    		this.initJSONEditors();
    	},
    	
    	initJSONEditors: function(){
			var options = {
			    mode: 'code',
			    modes: ['code', 'form', 'text', 'tree', 'view'], 
			    error: function (err) {
			      alert(err.toString());
			    }
			 };
			//输入参数编辑器
			var reqEditors = new Array();
			$("[name='DIV_REQ_PARAM_SETTING']").each(function(index,div){
				var obj = $(div).find("#REQ_JSONEDITOR");
				if(!obj){
					return;
				}
				
				var jsoneditorId = obj.attr("id");
				if(jsoneditorId==undefined){
					return;
				}
				//数据库中保存的json字符串
				var paramjson=obj.attr("paramjson");
				var container = document.getElementById(jsoneditorId);
				var editor = new JSONEditor(container, options, {});
				editor.set(paramjson?JSON.parse(paramjson):{});
				reqEditors.push(editor);
			});
			
			//输出参数编辑器
			var respEditors = new Array();
			$("[name='DIV_RESP_PARAM_SETTING']").each(function(index,div){
				var obj = $(div).find("#RESP_JSONEDITOR");
				if(!obj){
					return;
				}
				
				var jsoneditorId = obj.attr("id");
				if(jsoneditorId==undefined){
					return;
				}
				//数据库中保存的json字符串
				var paramjson=obj.attr("paramjson");
				var container = document.getElementById(jsoneditorId);
				var editor = new JSONEditor(container, options, {});
				editor.set(paramjson?JSON.parse(paramjson):{});
				respEditors.push(editor);
			});
			this.reqEditors = reqEditors;
			this.respEditors = respEditors;
		},
    	
    	getReqJSONEditor: function(index){
			var editors = this.reqEditors;
			var editor = editors[index];
			return editor;
		},
		
		getRespJSONEditor: function(index){
			var editors = this.respEditors;
			var editor = editors[index];
			return editor;
		},
		
		submit: function(){
			var _this = this;
			var interfaceName = $("#interfaceName").val();
			var method = $("#method").val();
			if(interfaceName==""){
				alert("服务接口不能为空");
				return ;
			}
			if(method==""){
				alert("方法不能为空");
				return ;
			}
			
			var reqSettings = new Array();
			$("[name='DIV_REQ_PARAM_SETTING']").each(function(index,div){
				var paramName = $(div).find("#paramName").val();
				var sort = $(div).find("#sort").val();
				var jsonTEXT = $(div).find("#REQ_JSONTEXT");
				var jsonStr = "";
				if(jsonTEXT && jsonTEXT.length>0){
					jsonStr = jsonTEXT.val();
				}else{
					var editor = _this.getReqJSONEditor(index);
					jsonStr =JSON.stringify(editor.get());
				}

				var data = {
					paramName: paramName,
					sort: sort,
					json: jsonStr
				}
				reqSettings.push(data);
			});
			
			var returnJson = "";
			$("[name='DIV_RESP_PARAM_SETTING']").each(function(index,div){
				var jsonTEXT = $(div).find("#RESP_JSONTEXT");
				if(jsonTEXT && jsonTEXT.length>0){
					returnJson = jsonTEXT.val();
				}else{
					var editor = _this.getRespJSONEditor(index);
					returnJson =JSON.stringify(editor.get());
				}
			});
			
			var apiCallSetting = {
				settingId: $("#settingId").val(),
				apiCode: $("#apiCode").val(),
				owner: $("#owner").val(),
				interfaceName: $("#interfaceName").val(),
				method: $("#method").val(),
				returnJson: returnJson,
				reqSettings: reqSettings
			};
			
			ajaxController.ajax({
				type : "POST",
				processing: true,
				url : "../sandbox/saveAPICallSetting?rnd="+ Math.random(),
				dataType : "json",
				data: {
					data: JSON.stringify(apiCallSetting)
				},
				showWait : true,
				message : "正在提交设置...",
				success : function(data) {
					alert("提交成功");
					window.location.href= "../sandbox/apireqparamset.html?indexId="+apiSettingIndexId+"&activemenu=m_api"
				}
			});
		}
    });
    
    module.exports = SearchAPIReqParams
});
