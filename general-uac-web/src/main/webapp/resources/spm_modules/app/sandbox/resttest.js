define('app/sandbox/resttest', function (require, exports, module) {
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
        element: $("#rest-form")
    });
    validator.addItem({
        element: '[name=restURL]',
        required: true,
        errormessageRequired:'请输入测试的HTTP地址'
    }).addItem({
        element: '[name=restMethod]',
        required: true,
        errormessageRequired:'REST请求方式不能为空'
    });

    //定义页面组件类
    var APIResttest = Widget.extend({
        //属性，使用时由类的构造函数传入
        attrs: {
        },
        Statics: {
            DEFAULT_PAGE_SIZE: 10
        },
        //事件代理
        events: {
            //key的格式: 事件+空格+对象选择器;value:事件方法
            "click #BTN_TEST":"restTest"
        },
        //重写父类
        setup: function () {
            APIResttest.superclass.setup.call(this);
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
                }
                reqEditors.push(data);
            });
            this.reqEditors = reqEditors;

            //输出参数编辑器
            var container = document.getElementById("RESP_JSONEDITOR");
            this.respEditor = new JSONEditor(container, options, {});
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

        restTest: function(){
            var _this = this;
            var restURL = $("#restURL").val();
            var restMethod = $("#restMethod").val();
            //验证输入项
            validator.execute(function(error, results, element) {
                if(error){return;}
                var restParams = new Array();
                $("[name='DIV_REQ_PARAM_SETTING']").each(function(index,div){
                    var paramName = $(div).find("#paramName").val();
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
                        paramValue: jsonStr
                    }
                    restParams.push(data);
                });

                var data = {
                    restURL: restURL,
                    restMethod: restMethod,
                    restParams: restParams
                };

                ajaxController.ajax({
                    method : "POST",
                    url : "../sandbox/restTest?rnd="+ Math.random(),
                    dataType : "json",
                    data: {
                        data: JSON.stringify(data)
                    },
                    processing: true,
                    message : "正在执行服务测试...",
                    success : function(data) {
                        var testResult = data.data;
                        $("#DIV_TEST_RESULT").show();
                        if(testResult.actualCode=="failure"){
                            //如果测试失败，不允许保存用例
                            $("#RESP_JSONTEXT").val(testResult.actualResult?testResult.actualResult:"");
                            $("#DIV_SUCCESS_RESULT").hide();
                            $("#DIV_FAILURE_RESULT").show();
                        }else{
                            $("#DIV_SUCCESS_RESULT").show();
                            $("#DIV_FAILURE_RESULT").hide();
                            _this.respEditor.set(testResult.actualResult?JSON.parse(testResult.actualResult):{});
                        }
                    }
                });
            });


        }

    });

    module.exports = APIResttest;
});
