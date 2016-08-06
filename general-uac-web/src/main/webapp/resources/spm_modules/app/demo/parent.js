define('app/demo/parent',function(require,exports,module){
	'use strict';
	var $=require('jquery'),
	Widget = require('arale-widget/1.2.0/widget'),
	Messenger = require('arale-messenger/2.1.0/index'),
	messenger;
	
	//定义页面组件类
	
	var ParentPaper = Widget.extend({
		//事件代理
    	events: {
    		"click #sendButtonParent":"sendMessage"
        },
        
        //重写父类
        setup: function () {
        	ParentPaper.superclass.setup.call(this);
            this.initParent();
        },
        initParent:function(){
        	if(typeof(messenger)=="undefined"){
	        	messenger = new Messenger('parent','demo22');
	        	messenger.addTarget($('iframe')[0].contentWindow,'iframe1');
	        	messenger.listen(function(msg){
	        		$('#messageDivIdParent').html($('#messageDivIdParent').html()+' '+msg);
	        	});
        	}
        },
        sendMessage:function(){
        	console.log('发出',$("#sendTextParent").val());
        	messenger.targets['iframe1'].send($('#sendTextParent').val());
        	$('#sendTextParent').val('');
        }
	});
        	
     module.exports = ParentPaper;
})