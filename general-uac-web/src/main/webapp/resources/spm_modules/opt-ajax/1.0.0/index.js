define('opt-ajax/1.0.0/index', function (require, exports, module) {
    'use strict';
    var $=require('jquery'),
    Dialog = require("artDialog/src/dialog"),
    Base = require('arale-base/1.2.0/base');
    
    require('jquery-form/3.51.0/jquery.form');
    
    var processingDialog = Dialog({
        content: "<div class='loading'>正在处理中，请稍候..</div>"
    });
    
    
    var AjaxController = Base.extend({
    	attrs:{
    	},
        Statics: {
			AJAX_SUBMIT_CONTAINER: "_X_AJAX_SUBMIT_CONTAINER_DIV",
			SELECTOR_AJAX_SUBMIT_CONTAINER: "#_X_AJAX_SUBMIT_CONTAINER_DIV",
			AJAX_STATUS_SUCCESS: "1",
			AJAX_STATUS_FAILURE: "0",
			STATUS_CODE: "statusCode",
			STATUS_INFO: "statusInfo"
        },
        ajax: function(options){
        	var _this = this;
        	var callbacks = {};
			if(typeof options.before == 'function'){
				callbacks["before"] = options.before;
				delete options.before;
			}
			if(typeof options.success=='function'){
				callbacks["success"] = options.success;
				delete options.success;
			}
			if(typeof options.failure=='function'){
				callbacks["failure"] = options.failure;
				delete options.failure;
			}
			if(typeof options.error=='function'){
				callbacks["error"] = options.error;
				delete options.error;
			}
        	var processing = options && options.processing==true?true:false;
        	var message =options.message;
			var postmode = options.postmode?options.postmode:"request";
        	var settings = {}; $.extend(settings,options); 
        	settings["success"] = function(transport){ 
				if(processing)processingDialog.close();
				var status = transport[AjaxController.STATUS_CODE];
				var statusInfo = transport[AjaxController.STATUS_INFO];
				if(status && status == AjaxController.AJAX_STATUS_FAILURE){
					var failureDialog = Dialog({
					    title: '交易失败',
					    content: statusInfo,
					    cancel: false,
					    ok: function () {
					    	callbacks["failure"] && callbacks["failure"].call(_this,transport); 
					    }
					});
					failureDialog.showModal();
				}else{
					if(postmode=="update")$(target).html(transport);
					callbacks["success"] && callbacks["success"].call(_this,transport);
				} 
			}; 
			settings["beforeSubmit"] = function(){ 
				return callbacks["before"] && callbacks["before"].call(_this);  
			};
			settings["error"] = function(transport){  
				if(processing)processingDialog.close();
				var failureDialog = Dialog({
				    title: '请求失败',
				    content: "网络请求错误,错误码:"+transport.status+",请重试。",
				    cancel: false,
				    ok: function () {
				    	callbacks["error"] && callbacks["error"].call(_this,transport); 
				    }
				});
				failureDialog.showModal();
			};
			settings.data=options.data?options.data:{};
			settings.type=options.type?options.type:"post";
			var q="ajax_req_random="+new Date().getTime();
			settings.url += (settings.url.indexOf('?') >= 0 ? '&' : '?') + q;  
			if(processing)processingDialog.content("<div class='loading'>"+message+"</div>").showModal();
			if(options.postselectors && options.postselectors.length==1){ 
				settings.semantic=true; 
				var postContainerSelector=options.postselectors[0]; 
				if($(postContainerSelector).length){
					$(postContainerSelector).ajaxSubmit(settings);
				}
				else{
					this._processCombineParamContainer(options.postselectors);
					$(AjaxController.SELECTOR_AJAX_SUBMIT_CONTAINER).ajaxSubmit(settings);
				}
			}else{
				settings.semantic=true;
				this._processCombineParamContainer(options.postselectors);
				$(AjaxController.SELECTOR_AJAX_SUBMIT_CONTAINER).ajaxSubmit(settings);
			}  
		},
		_processCombineParamContainer: function(/**Array*/postContainerSelectors){
			this._createSubmitContainer();
			var submitContainer = $(AjaxController.SELECTOR_AJAX_SUBMIT_CONTAINER);
			if(postContainerSelectors && $.isArray(postContainerSelectors)){
				$(postContainerSelectors).each(function(index,selector){
					if($(selector).length){
						$(selector).clone().prependTo(submitContainer);
					} 
				}); 
			}  
		},
		_createSubmitContainer: function(){ 
			var xSubmitContainer = $(AjaxController.SELECTOR_AJAX_SUBMIT_CONTAINER);
			if(!xSubmitContainer.length){
				$(document.body).append("<div id='"+ AjaxController.AJAX_SUBMIT_CONTAINER +"' style='display:none'></div>");
			}else{
				xSubmitContainer.html("");
			}
		}
    });
    module.exports = AjaxController;
});

