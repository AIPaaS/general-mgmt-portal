package com.ai.platform.common.mail;
public enum MailType {    
    /** 
     * 图片类型 
     * */  
    IMG,  
    /** 
     * 文件类型 
     * */  
    FILE;  

    @Override  
    public String toString() {  
        String message = null;  
        switch (this) {       
        case IMG :  
            message = ",包含图片";  
        default:  
            message = ",包含附件";  
            break;  
        }  
        return message;  
    }  
}  