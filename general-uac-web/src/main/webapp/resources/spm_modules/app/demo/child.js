define('app/demo/child',function(require,exports,module){
	'use strict';
	var $=require('jquery'),
	Widget = require('arale-widget/1.2.0/widget'),
	Messenger = require('arale-messenger/2.1.0/index');
	
	var messenger;
	
	
	
	//定义页面组件类
	
	var ChildPaper = Widget.extend({
		//事件代理
    	events: {
    		"click #sendButton":"sendMessage"
        },
        
        //重写父类
        setup: function () {
        	ChildPaper.superclass.setup.call(this);
            this.initChild();
        },
        initChild:function(){
        	if(typeof(messenger)=="undefined"){
        		messenger=new Messenger('iframe1','demo22');
            	messenger.addTarget(window.parent,'parent');
            	messenger.listen(function(msg){
            		console.log('收到',msg);
            		$('#messageDivId').html($('#messageDivId').html()+' '+msg);
            	});
        	}
        		
        },
        sendMessage:function(){
        	messenger.targets['parent'].send($('#sendText').val());
        	$('#sendText').val('');
        }
	});
        	
     module.exports = ChildPaper;
})