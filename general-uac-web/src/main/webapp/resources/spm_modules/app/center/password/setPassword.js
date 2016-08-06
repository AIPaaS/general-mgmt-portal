define('app/center/password/setPassword', function (require, exports, module) {
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
    var UpdatePasswordPager = Widget.extend({
    	//属性，使用时由类的构造函数传入
    	attrs: {
    	},
    	//事件代理
    	events: {
    		//key的格式: 事件+空格+对象选择器;value:事件方法
    		"click [id='submitBtn']":"_updatePassword",
    		"blur [id='password']":"_checkNewPassword",
    		"blur [id='confirmPassword']":"_checkConfirmPassword",
    		//"keyup [id='password']":"_pwStrength"
        },
    	//重写父类
    	setup: function () {
    		UpdatePasswordPager.superclass.setup.call(this);
    		this._initShowView();
    	},
    	_initShowView:function(){
			 //左侧菜单显示样式
	   		$("#updatePassword").addClass("current");
	   		//标题显示
	   		$("#set_title_id").html("修改密码");
		},
    	//判断输入密码的类型  
		_CharMode: function(iN){  
			if (iN>=48 && iN <=57) //数字  
			return 1;  
			if (iN>=65 && iN <=90) //大写  
			return 2;  
			if (iN>=97 && iN <=122) //小写  
			return 4;  
			else  
			return 8;   
		},  
		//bitTotal函数  
		//计算密码模式  
		_bitTotal:function(num){  
			var modes=0;  
			for (var i=0;i<4;i++){  
				if (num & 1) modes++;  
				num>>>=1;  
			}  
			return modes;  
		},  
		//返回强度级别  
		_checkStrong:function(sPW){  
			if (sPW.length<=8)  
				return 0; //密码太短  
			var Modes=0;  
			for (var i=0;i<sPW.length;i++){  
				//密码模式  
				Modes|=this._CharMode(sPW.charCodeAt(i));  
			}  
			return this._bitTotal(Modes);  
		},  
		 
		//显示颜色  
		_pwStrength:function(){  
			var pwd = $("#password").val();
			var O_color="#eeeeee";  
			var L_color="#FF0000";  
			var M_color="#FF9900";  
			var H_color="#33CC00"; 
			var Lcolor,Mcolor,Hcolor;
			if (pwd==null||pwd==''){  
				Lcolor=Mcolor=Hcolor=O_color;  
			}else{  
				var S_level=this._checkStrong(pwd);  
				switch(S_level) {  
					case 0:  
					Lcolor=Mcolor=Hcolor=O_color;  
					case 1:  
					Lcolor=L_color;  
					Mcolor=Hcolor=O_color;  
					break;  
					case 2:  
					Lcolor=Mcolor=M_color;  
					Hcolor=O_color;  
					break;  
					default:  
					Lcolor=Mcolor=Hcolor=H_color;  
				}  
			}  
			document.getElementById("strength_L").style.background=Lcolor;  
			document.getElementById("strength_M").style.background=Mcolor;  
			document.getElementById("strength_H").style.background=Hcolor;  
			return;  
		},  
    	//检查新密码格式
		_checkNewPassword: function(){
			var newPassword = $("#password").val();
			var msg = "";
			if(newPassword == "" || newPassword == null || newPassword == undefined){
				msg = "请输入密码";
			}else{
				if(!/^[\x21-\x7E]{6,14}$/.test(newPassword)){
					msg = msg +"长度为6-14个字符 \n";
				}
				if(!/[\x01-\xFF]*/.test(newPassword)){
					msg = msg +"支持数字、字母、符号组合\n";
				}
				if(!/^\S*$/.test(newPassword)){
					msg = msg +"不允许有空格 \n";
				}
			}
			if(msg == ""){
				this._controlMsgText("newPwdMsg","");
				this._controlMsgAttr("newPwdMsg",1);
				return true;
			}else{
				this._controlMsgText("newPwdMsg",msg);
				this._controlMsgAttr("newPwdMsg",2);
				return false;
			}
		},
		//检查确认密码
		_checkConfirmPassword: function(){
			var isOk = this._checkNewPassword();
			if(!isOk){
				return false;
			}
			var confirmPassword = $("#confirmPassword").val();
			var newPassword = $("#password").val();
			if(confirmPassword == "" || confirmPassword == null || confirmPassword == undefined){
				this._controlMsgText("confirmPwdMsg","请输入确认密码");
				this._controlMsgAttr("confirmPwdMsg",2);
				return false;
			}else if(newPassword != confirmPassword){
				this._controlMsgText("confirmPwdMsg","两次输入的密码不匹配");
				this._controlMsgAttr("confirmPwdMsg",2);
				return false;
			}else{
				this._controlMsgText("confirmPwdMsg","");
				this._controlMsgAttr("confirmPwdMsg",1);
				return true;
			}
		},
		//控制显示内容
		_controlMsgText: function(id,msg){
			var doc = document.getElementById(id+"");
			doc.innerText=msg;
		},
		//控制显隐属性 1:隐藏 2：显示
		_controlMsgAttr: function(id,flag){
			var doc = document.getElementById(id+"");
			if(flag == 1){
				doc.setAttribute("style","display:none");
			}else if(flag == 2){
				doc.setAttribute("style","display");
			}
		},
		//更新密码
		_updatePassword:function(){
			var _this = this;
			var checkNewPwd = this._checkNewPassword();
    		var checkConfirmPwd = this._checkConfirmPassword();
    		var password = $("#password").val();
    		if(!(checkNewPwd&&checkConfirmPwd)){
    			return false;
    		}
			ajaxController.ajax({
					type : "POST",
					data : {"password":password},
					dataType: 'json',
					url :_base+"/center/password/setNewPassword?k="+uuid,
					processing: true,
					message : "正在处理中，请稍候...",
					success : function(data) {
						var status = data.responseHeader.resultCode;
						if(status == "000000" || status == "100000"){
							var url = data.data;
							window.location.href = _base+url;
						}else {
							/*var msg = data.statusInfo;
							if(status == "100003"){
								alert("kkkkl");
								_this._controlMsgText("newPwdMsg",msg);
								_this._controlMsgAttr("newPwdMsg",2);
							}else{*/
								_this._controlMsgText("newPwdMsg","");
								_this._controlMsgAttr("newPwdMsg",1);
							//}
						}
					},
					error : function(){
						alert("网络连接超时，请重新修改登录密码");
					}
			});
		}		
    });
    
    
    module.exports = UpdatePasswordPager
});
