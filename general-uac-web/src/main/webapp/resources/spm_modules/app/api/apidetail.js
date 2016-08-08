define('app/api/apidetail', function (require, exports, module) {
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
    var APIDetailPager = Widget.extend({
    	//属性，使用时由类的构造函数传入
    	attrs: {
    	},
    	Statics: {
    		DEFAULT_PAGE_SIZE: 10
    	},
    	//事件代理
    	events: {
    		//key的格式: 事件+空格+对象选择器;value:事件方法
//    		 "click [name='TR_IN_EXPANDER_NAME']":"_testAction" , 
//    		  "click [name='TR_OUT_EXPANDER_NAME']":"_testAction1"  	
        },
    	//重写父类
    	setup: function () {
    		APIDetailPager.superclass.setup.call(this);
    		//加载数据
    		
    		this.expanderInActions = [];
			this.expanderOutActions = [];
    		this._renderAPIInParamTreeGrid();
			this._renderAPIOutParamTreeGrid();
    	},
    
    	
    	
    	_renderAPIInParamTreeGrid: function(){
			var _this = this;
			$('.tree-1').treegrid({
                expanderExpandedClass: 'glyphicon glyphicon-minus',
                expanderCollapsedClass: 'glyphicon glyphicon-plus',
                onChange: function() {
                    //alert("Changed: " + $(this).attr("class"));
                },
                onCollapse: function() {
                    //alert("Collapsed " + $(this).attr("pid"));
                },
                onExpand: function() {
                   // alert("Expanded: " + $(this).attr("class"));
                }
            });

			$("[name='TR_IN_EXPANDER_NAME']").unbind("click").bind("click", function() {
				var pIndexId=$(this).attr("indexId");
				var expand = _this._checkParamExpanderAction(_this.expanderInActions,pIndexId);
				if(!expand){
					_this._getAPIInParamSubClassFields(pIndexId);
				}
			}); 
		},
		
		_renderAPIOutParamTreeGrid: function(){
			var _this = this;
			$('.tree-2').treegrid({
                expanderExpandedClass: 'glyphicon glyphicon-minus',
                expanderCollapsedClass: 'glyphicon glyphicon-plus',
                onChange: function() {
                    //alert("Changed: " + $(this).attr("class"));
                },
                onCollapse: function() {
                    //alert("Collapsed " + $(this).attr("pid"));
                },
                onExpand: function() {
                   // alert("Expanded: " + $(this).attr("class"));
                }
            });
			$("[name='TR_OUT_EXPANDER_NAME']").unbind("click").bind("click", function() {
				var pIndexId=$(this).attr("indexId");
				var expand = _this._checkParamExpanderAction(_this.expanderOutActions,pIndexId);
				if(!expand){
					_this._getAPIOutParamSubClassFields(pIndexId);
				}
			});
		},
		
		
		_checkParamExpanderAction: function(data,pIndexId){
			var _this = this;
			var array = $.grep(data,function(d,i){
				return d.pIndexId==pIndexId;
			});
			if(!array || array.length==0)return false;
			var d = array[0];
			return d.action;
		},
    	_getAPIInParamSubClassFields: function(pIndexId){
			var _this = this;
			ajaxController.ajax({
				type : "POST",
				url :"../api/getSubClassFields",
				//dataType : "json",
				data: {
					pIndexId:  pIndexId
				},
				processing: true,
				message : "正在处理中，请稍候...",
				success : function(data) {
					var d = data.data;
					if(d && d.length!=0){
						var template = $.templates("#APIInParamSubClassFieldsImpl");
	                    var html = template.render(d?d:[]);
	                   	_this._appendRecord(pIndexId,html);
	                   	_this._renderAPIInParamTreeGrid();
					}
					_this.expanderInActions.push({pIndexId:pIndexId,action:true});
				}
			});
		},
		
		_getAPIOutParamSubClassFields: function(pIndexId){
			var _this = this;
			ajaxController.ajax({
				type : "POST",
				url : "../api/getSubClassFields",
				//dataType : "json",
				data: {
					pIndexId:  pIndexId
				},
				processing: true,
				message : "正在处理中，请稍候...",
				success : function(data) {
					var d = data.data;
					if(d && d.length!=0){
						var template = $.templates("#APIOutParamSubClassFieldsImpl");
	                    var html = template.render(d?d:[]);
	                   	_this._appendRecord(pIndexId,html);
	                   	_this._renderAPIOutParamTreeGrid();
					}
					_this.expanderOutActions.push({pIndexId:pIndexId,action:true});
				}
			});
		},
		
		_appendRecord: function(pIndexId,html){
			//alert(html);
			$("#treegrid-"+pIndexId).after(html);
		}
    	
    	
    	
    });
    
    module.exports = APIDetailPager
});
