/* This file is used to validate input-data */
	String.prototype.trim=function(){  
　　    return this.replace(/(^\s*)|(\s*$)/g, "");  
　　 }  

　　 String.prototype.ltrim=function(){  
　　    return this.replace(/(^\s*)/g,"");  
　　 }  
 
　　 String.prototype.rtrim=function(){  
　　    return this.replace(/(\s*$)/g,"");  
　     }
 	//检查非法字符
 	String.prototype.InputFilter=function(){
 		var pattern = new RegExp("[`~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？]") 
 		var rs = ""; 
 		for (var i = 0; i < this.length; i++) { 
 			rs += this.substr(i, 1).replace(pattern, ''); 
 		} 
 		return rs;
 	}
 	//针对备注检查非法字符
 	String.prototype.MemoInputFilter=function(){
 		var pattern = new RegExp("[`~@#$^&*<>￥]") 
 		var rs = ""; 
 		for (var i = 0; i < this.length; i++) { 
 			rs += this.substr(i, 1).replace(pattern, ''); 
 		} 
 		return rs;
 	}
	//检查是字符串否为空
	function isNull(str)
	{   var trim_str=str.replace(/(^\s*)|(\s*$)/g, ""); 
		if(trim_str.length>0)
		{
			return false;	
		}
		else
		{
			return true;
		}
		
	}

	// 检查是否数字(包括小数点)
    function isNumeric(s)
	{
    	 //var patrn=/^-?(([0-9]*)|([1-9]\d*\.\d*)|(0\.\d*[1-9]\d*)|(0?\.0+)|0)$/; 
    	 var patrn=/^[+-]?([0-9]*\.?[0-9]+|[0-9]+\.?[0-9]*)([eE][+-]?[0-9]+)?$/;
	      if (!patrn.test(s.trim())) {return false; }
	      else {return true;}
	       
    }
      
  //校验字符长度：获取字符长度 中文占两个字符长度、英文占一个字符长度
	function getTextLength(str) {
		var len = str.length;
		var reLen = 0;
		for ( var i = 0; i < len; i++) {
			if (str.charCodeAt(i) < 27 || str.charCodeAt(i) > 126) {
				// 全角   
				reLen += 2;
			} else {
				reLen++;
			}
		}
		return reLen;
	}
    
    //校验是否全由数字组成 
      function isDigit(s) 
      { 
	      var patrn=/^[0-9]*$/; 
	      if (!patrn.test(s.trim())) {return false; }
	      else {return true;}
      } 
      
      //校验是否为中文 
      function isChinese(s) 
      { 
	      var patrn=/^[\u4e00-\u9fa5]$/; 
	      if (!patrn.test(s))  {return false; }
	      else {return true;}
      } 
            
    // 判断手机号码    
      function isMobel(s)
	{
    	  var patrn=/^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[ ]){1,12})+$/; 
    	  if (!patrn.test(s))  {return false; }
	      else {return true;}

	}
      function isPhone(s)
  	{
      	  var patrn=/^0{0,1}(13[0-9]|15[3-9]|15[0-2]|18[0-9])[0-9]{8}$/; 
      	  if (!patrn.test(s))  {return false; }
  	      else {return true;}

  	}

      // 判断是否为传真
      function isFax(s)
      {
    	  if(/^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/g.test(s))
    	  {  
    		  return true;
    	  }else{
    		  return false;
    	  }
      }
	 

	//判断是否为邮政编码   
   function isPostCode(s)
    {   
       var valid=/^\d{6}$/; 
         
        if(!valid.test(s)) {return false; }
	      else {return true;}
      
    }   
   
 
   //判断是否为邮件    
   function isMail(s)
   { 
	   var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	   if(!myreg.test(s))
	   { return false;}
	   else
	   {return true;}
  }  
   
 //判断是否为IP地址
   function isIP(s)  
   { 
	   var patrn=/^[0-9.]{1,20}$/; 
	   if (!patrn.test(s))  {return false; }
	      else {return true;}
   } 
   
   
 //校验登录名：只能输入5-30个以字母开头、可带数字、“_”、“.”的字串 
   function isRegisterUserName(s) 
   { 
	   var patrn=/^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){4,29}$/; 
	   if (!patrn.test(s)) {return false; }
	      else {return true;}
   } 
   
   //校验SNGCC系统登录名：只能输入4-30个以z_(Z_)开头、可带字母数字、“_”、“.”的字串 
   function isSngccUserName(s) 
   { 
	   var patrn=/^[zZ]{1}[_]{1}([a-zA-Z0-9]|[._]){2,29}$/; 
	   if (!patrn.test(s)) {return false; }
	      else {return true;}
   }
   
   //校验组织架构编码：只能输入2-30个以字母或数字开头、可带“_”、“-”、“.”的字串 
   function isOrgcode(s) 
   { 
	   //var patrn=/^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){1,29}$/; 
	   var patrn=/^[a-zA-Z0-9]{1}([a-zA-Z0-9]|[._-]){1,29}$/; 
	   if (!patrn.test(s)) {return false; }
	      else {return true;}
   }

   //校验用户姓名：只能输入1-30个以字母开头的字串 
   function isTrueName(s) 
   { 
	   var patrn=/^[a-zA-Z]{1,30}$/; 
	   if (!patrn.test(s))  {return false; }
	      else {return true;}
   } 

   //校验密码：只能输入6-20个字母、数字、下划线 
   function isPasswd(s) 
   { 
	   var patrn=/^(\w){6,20}$/; 
	   if (!patrn.test(s))  {return false; }
	      else {return true;}
   } 



