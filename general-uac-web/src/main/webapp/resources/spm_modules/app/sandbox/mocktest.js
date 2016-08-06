define('app/sandbox/mocktest', function (require, exports, module) {
    'use strict';
    var $=require('jquery'),
        Widget = require('arale-widget/1.2.0/widget'),
        Validator=require('arale-validator/0.10.2/index'),
        Dialog = require("artDialog/src/dialog"),
        AjaxController = require('opt-ajax/1.0.0/index');

    require("arale-validator/0.10.2/alice.components.ui-button-orange-1.3-full.css");
    require("arale-validator/0.10.2/alice.components.ui-form-1.0-src.css");
    require("jsviews/jsrender.min");
    require("jsviews/jsviews.min");
    require("jsoneditor/5.1.5/jsoneditor.min.css"); 
    require("jsoneditor/5.1.5/jsoneditor.min");

    //实例化AJAX控制处理对象
    var ajaxController = new AjaxController();

    //表单校验对象
    var validator = new Validator({
        element: $("#reg-form")
    });
    validator.addItem({
        element: '[name=registryURL]',
        required: true,
        errormessageRequired:'请输入注册中心地址'
    }).addItem({
        element: '[name=interfaceName]',
        required: true,
        errormessageRequired:'服务接口不能为空'
    }).addItem({
        element: '[name=method]',
        required: true,
        errormessageRequired:'方法不能为空'
    });

    //定义页面组件类
    var APIMocktest = Widget.extend({
        //属性，使用时由类的构造函数传入
        attrs: {
        },
        Statics: {
            DEFAULT_PAGE_SIZE: 10
        },
        //事件代理
        events: {
            //key的格式: 事件+空格+对象选择器;value:事件方法
            "click #BTN_TEST":"mockTest" ,
            "click #HrefConnectTest":"testConnect"
        },
        //重写父类
        setup: function () {
            APIMocktest.superclass.setup.call(this);
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
                var paramName = $(div).find("#paramName").val();
                //数据库中保存的json字符串
                var paramjson=obj.attr("paramjson");
                var container = document.getElementById(jsoneditorId);
                var editor = new JSONEditor(container, options, {});
                editor.set(paramjson?JSON.parse(paramjson):{});

                var data = {
                    paramName: paramName,
                    editor: editor
                };
                reqEditors.push(data);
            });
            this.reqEditors = reqEditors;

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
                var container = document.getElementById(jsoneditorId);
                var editor = new JSONEditor(container, options, {});
                respEditors.push(editor);
            });
            this.respEditors = respEditors;
        },

        getReqJSONEditor: function(paramName){
            var editors = this.reqEditors;
            var array =$.grep(editors,function(d,index){
                return d.paramName==paramName;
            });
            if(!array || array.length==0){
                return ;
            }
            var editor = array[0].editor;
            return editor;
        },

        getRespJSONEditor: function(index){
            var editors = this.respEditors;
            var editor = editors[index];
            return editor;
        },

        mockTest: function(){
            var _this = this;
            validator.execute(function(error, results, element) {
                if(error){return;}
                _this._mockTestFun();
            });
        },

        _mockTestFun: function(){
            var _this = this;
            var registryURL = $("#registryURL").val();
            var interfaceName = $("#interfaceName").val();
            var method = $("#method").val();

            var reqParams = new Array();
            $("[name='DIV_REQ_PARAM_SETTING']").each(function(index,div){
                var paramName = $(div).find("#paramName").val();
                var sort = $(div).find("#sort").val();
                var jsonTEXT = $(div).find("#REQ_JSONTEXT");
                var jsonStr = "";
                if(jsonTEXT && jsonTEXT.length>0){
                    jsonStr = jsonTEXT.val();
                }else{
                    var editor = _this.getReqJSONEditor(paramName);
                    jsonStr =JSON.stringify(editor.get());
                }

                var data = {
                    paramName: paramName,
                    json: jsonStr
                };
                reqParams.push(data);
            });

            var apiCallCase = {
                owner : apiOwner,
                interfaceName: apiInterfaceName,
                method: apiMethod,
                reqParams: reqParams
            };

            ajaxController.ajax({
                method : "POST",
                url : "../sandbox/mockTest?rnd="+ Math.random(),
                dataType : "json",
                data: {
                    data: JSON.stringify(apiCallCase),
                    registryURL: registryURL
                },
                processing: true,
                message : "正在执行服务测试...",
                success : function(data) {
                    var testResult = data.data;
                    $("#DIV_TEST_RESULT").show();
                    if(testResult.actualCode=="failure"){
                        //如果测试失败，不允许保存用例
                        $("#RESP_FAILURETEXT").val(testResult.actualResult?testResult.actualResult:"");
                        $("#DIV_FAILURE_RESULT").show();
                        $("[name='DIV_RESP_PARAM_SETTING']").hide();
                    }else{
                        if (editType == 1){
                            _this.getRespJSONEditor(0).set(testResult.actualResult?JSON.parse(testResult.actualResult):{});
                        }
                        if (editType == 2){
                            $("#RESP_JSONTEXT").val(testResult.actualResult?testResult.actualResult:"");
                        }
                        $("#RESP_FAILURETEXT").val("");
                        $("#DIV_FAILURE_RESULT").hide();
                        $("[name='DIV_RESP_PARAM_SETTING']").show();
                    }
                }
            });
        },

        testConnect: function(){
            var _this = this;
            var registryURL = $("#registryURL").val();
            validator.execute(function(error, results, element) {
                if(error){return;}
                ajaxController.ajax({
                    method : "POST",
                    url : "../sandbox/checkRegistryAvailable?rnd="+ Math.random(),
                    dataType : "json",
                    data: {
                        registryURL: registryURL
                    },
                    processing: true,
                    message : "正在测试到注册中心的连通性...",
                    success : function(data) {
                        if(data.data=="1"){
                            alert("连接成功");
                        }else{
                            alert("连接失败");
                        }
                    }
                });
            });
        }

    });

    module.exports = APIMocktest;
});
