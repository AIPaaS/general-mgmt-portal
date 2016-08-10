package com.ai.platform.common.mail;

import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.ai.platform.common.config.Global;

public class JavaMailFactory {  
      
    /*** 
     * 此处也可修改为 
     * private JavaMailSenderImpl javaMailSenderImpl; 
     * ... 省略set,get,方便使用spring注入 
     * */  
      
    private static JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();  
      
    static{  
        senderImpl.setHost(Global.EMAIL_HOST);  
        senderImpl.setUsername(Global.EMAIL_USERNAME);   
        senderImpl.setPassword(Global.EMAIL_PASSWORD);           
        senderImpl.setJavaMailProperties(Global.safetyProperties);  
    }  
      
    public static JavaMailSenderImpl getJavaMail(){   
        return senderImpl;  
    }  
}