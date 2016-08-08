define('app/api/search', function (require, exports, module) {
    'use strict';
    var $=require('jquery'),
    Widget = require('arale-widget/1.2.0/widget'),
    Dialog = require("artDialog/src/dialog"),
    Uploader = require('arale-upload/1.2.0/index'),
    AjaxController=require('opt-ajax/1.0.0/index');
    
    
    require("jsviews/jsrender.min");
    require("jsviews/jsviews.min");
    require("bootstrap-paginator/bootstrap-paginator.min");
    
    
    //实例化AJAX控制处理对象
    var ajaxController = new AjaxController();
    
    //定义页面组件类
    var SearchPager = Widget.extend({
    	//属性，使用时由类的构造函数传入
    	attrs: {
    	},
    	Statics: {
    		DEFAULT_PAGE_SIZE: 20
    	},
    	//事件代理
    	events: {
    		//key的格式: 事件+空格+对象选择器;value:事件方法
            "click #BTN_SEARCH":"_searchBtnClick"         
        },
    	//重写父类
    	setup: function () {
    		SearchPager.superclass.setup.call(this);
    		this._bindEvents();
    		//初始化执行搜索
    		this._searchAPIDocs(1,SearchPager.DEFAULT_PAGE_SIZE);
    	},
    	//构造分页容器
    	_buildPaginationContainer: function(currentPage,totalPages){
			var _this = this;
			var options = {
				itemTexts: function (type, page, current) {
                    switch (type) {
	                    case "first":
	                        return "首页";
	                    case "prev":
	                        return "上一页";
	                    case "next":
	                        return "下一页";
	                    case "last":
	                        return "尾页";
	                    case "page":
	                        return page;
                    }
                },
    			alignment:"center",
				totalPages: totalPages,
			    currentPage: currentPage,
			    numberOfPages:8,
			    onPageClicked: function(e,originalEvent,type,page){
			    	e.stopImmediatePropagation();
			    	var currentTarget = $(e.currentTarget);
			    	var oldpages = currentTarget.bootstrapPaginator("getPages");
					_this._searchAPIDocs(page,SearchPager.DEFAULT_PAGE_SIZE);
			    }
			}
			$('#pagination-content').bootstrapPaginator(options);
		},
    	_bindEvents: function(){
    		var _this = this;
    		$('#API_KEY').bind('keypress',function(event){
				if(event.keyCode == "13"){
					_this._searchAPIDocs(1,SearchPager.DEFAULT_PAGE_SIZE);
				}
			});
    	},
    	_searchBtnClick: function(){
    		this._searchAPIDocs(1,SearchPager.DEFAULT_PAGE_SIZE);	
    	},
    	//搜索API
    	_searchAPIDocs: function(pageNo,pageSize){
    		var _this = this;
    		var apiKey=$("#API_KEY").val();
    		var owner=this.get("owner");
    		var ownerType=this.get("ownerType");
			var p = {
				keywords: $.trim(apiKey),
				owner: owner,
				ownerType: ownerType,
				pageInfo: {
					pageNo: pageNo,
					pageSize: pageSize
				}
			};
    		ajaxController.ajax({
    			type: "post",
    			processing: false,
    			message: "正在为您搜索结果，请稍候...",
    			url: "../api/search",
    			data: {
					queryCond: JSON.stringify(p)
				},
    			success: function(data){
    				var d=data.data;
    				if(d.result && d.result.length!=0){
    					_this._buildPaginationContainer(d.pageNo,d.pageCount);
    					var template = $.templates("#SearchResultImpl");
    					var htmlOutput = template.render(data.data.result);
    					$('#pagination-content').show().bootstrapPaginator("show",pageNo);
    					$("#search-results").html(htmlOutput);
    					$("#SEARCH_RESULT_TIPS").html("为您找到相关结果约<font color='red'>"+d.count+"</font>个").show();
    				}else{
    					$('#pagination-content').hide();
    					$("#search-results").html("没有搜索到相关信息");
	                    $("#SEARCH_RESULT_TIPS").hide();
    				}
    			}
    		})
    	}
    });
    
    module.exports = SearchPager
});
