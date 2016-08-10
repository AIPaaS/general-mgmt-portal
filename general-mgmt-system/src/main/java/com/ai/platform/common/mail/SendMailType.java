package com.ai.platform.common.mail;
/**    
 *Title:     邮件发送类型 
 *Description:      
 *Copyright: Copyright (c) 2011    
 *Company:http://liuzidong.iteye.com/     
 *Makedate:2011-7-4 上午09:59:08    
 * @author liuzidong    
 * @version 1.0    
 * @since 1.0     
 *    
 */  
public enum SendMailType {  
    /** 
     * 文本类型 
     * */  
    TEXT,  
    /** 
     * HTML类型,包含图片与附件内容 
     * **/  
    HTML;  
      
  
    @Override  
    public String toString() {  
        String message = null;  
        switch (this) {  
        case TEXT:  
            message = "发送文本消息";  
            break;  
        case HTML :  
            message = "发送html消息";     
            break;  
        }  
        return message;  
    }  
}  