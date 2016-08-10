package com.ai.platform.common.mail;


import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.ai.platform.common.config.Global;
import com.ai.platform.common.utils.SpringContextHolder;

/** 
 * Title: 消息发送类  
 * @author mengbo
 * @version 1.0 
 * @since 1.0 
 *  
 */  
public class MailMessageFactory {  
  
    private SimpleMailMessage simpleMailMessage;  
    private MimeMessageHelper mimeMessageHelper;  
    private JavaMailSenderImpl senderImpl;  
    private MimeMessage mimeMessage;  
    private SendMailType sendMailType;    
    private SendMessage sendMessage;      
    private static final String ENCODING = Global.EMAIL_ENCODING; 
    private TaskExecutor threadPool;

	//    /** 
//     * 默认为发送文本类型 
//     * */  
//    public MailMessageFactory(TaskExecutor threadPool) {  
//        this(SendMailType.TEXT, threadPool);  
//        this.threadPool = threadPool;
//    }  
    private MailMessageFactory(){}
    /** 
     * 请显示指明文件类型为：TEXT,HTML,默认为文本类型 
     *  
     * */  

    
    
    public MailMessageFactory(SendMailType sendMailType){  
          
        this.sendMailType = sendMailType;  
        this.senderImpl = JavaMailFactory.getJavaMail();  
        this.mimeMessage = senderImpl.createMimeMessage();                
        sendMessage = new SendMessage();      
       // this.threadPool = threadPool = SpringContextHolder.getBean(ThreadPoolTaskExecutor.class);  
        try {  
            switch (this.sendMailType) {  
            case TEXT:  
                simpleMailMessage = new SimpleMailMessage();  
                break;  
            case HTML:    
                mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, ENCODING);  
            }  
        } catch (Exception e) {  
            e.fillInStackTrace();  
        }  
  
    }  
      
    /** 
     * @param to 接收者人地址 
     * @return 
     */  
    public MailMessageFactory setTo(String ... to){       
        sendMessage.setTos(to);       
        return this;  
    }  
      
      
    /**发送标题*/  
    public MailMessageFactory setSubject(String subject){  
        sendMessage.setSubject(subject);  
        return this;  
    }  
      
    /**发送内容*/  
    public MailMessageFactory setText(String text){  
        sendMessage.addText(text);  
        return this;  
    }  
      
      
      
    /** 
     * 加入图片文件 
     * @param imageName  图片名称 
     * @param file   图片源 
     * @return 
     */  
    public MailMessageFactory setImgFile(String imageName,File file){     
        try {  
            sendMessage.addFile(MailType.IMG,MimeUtility.encodeWord(imageName), file);                    
        } catch (UnsupportedEncodingException e) {            
            e.printStackTrace();  
        }         
        return this;  
    }  
      
      
    /** 
     * 加入图片文件 
     * @param imageName  图片名称 
     * @param filePath   图片路径 
     * @return 
     */  
    public MailMessageFactory setImgFile(String imageName,String filePath){           
        setImgFile(imageName, new File(filePath));        
        return this;  
    }  
      
    /** 
     * 加入附件 
     * @param fileName  附件名称 
     * @param file      附件路径 
     * @return 
     */  
    public MailMessageFactory setAttachmentFile(String fileName,String filePath){     
        setAttachmentFile(fileName, new File(filePath));          
        return this;  
    }  
      
  
    /** 
     * 加入附件 
     * @param fileName  附件名称 
     * @param file      附件源  
     * @return 
     */  
    public MailMessageFactory setAttachmentFile(String fileName,File file){           
        try {  
            sendMessage.addFile(MailType.FILE,MimeUtility.encodeWord(fileName),file);                     
        } catch (UnsupportedEncodingException e) {            
            e.printStackTrace();  
        }     
        return this;  
    }  
      
      
      
    /**发送消息,你调用此方法进行Email消息的发送*/  
    public void send(){   
          
        //消息发送前,检查发送人地址,接收人地址是否为空,为空就设置为配置文件中的地址          
        sendMessage.setForm(Global.EMAIL_FROM);  
          
        //检查接收人地址是否为空  
        String [] tos = sendMessage.getTos();  
        if(null == tos || tos.length == 0){  
            tos = new String[]{Global.EMAIL_TO};  
            sendMessage.setTos(tos);  
        }                 
          
        long startTime = System.currentTimeMillis();  
        //发送普通文本  
        if(sendMailType == SendMailType.TEXT){  
            sendTextMessage();  
        }else{            
            sendHtmlImgFileMessage();  
        }         
        long endTime = System.currentTimeMillis();  
        System.out.println(sendMailType + "成功!,耗费时间: " + (endTime - startTime)+"毫秒! 发送人地址："+tos.toString());  
    }         
      
    public void sendByAsynchronous(){
    	send();
    }
    
    /** 
     * 发送html,图片,附件的消息 
     */  
    private void sendHtmlImgFileMessage() {  
          
        try {             
            mimeMessageHelper.setTo(sendMessage.getTos());  
            mimeMessageHelper.setFrom(sendMessage.getForm());  
            String subject = sendMessage.getSubject();  
            if(null != subject && !"".equals(subject)){  
                mimeMessageHelper.setSubject(subject);  
            }  
            String text = sendMessage.getSendTexts();  
            if(null != text && !"".equals(text)){  
                mimeMessageHelper.setText(text,true);  
            }             
          
            //检查图片或者文件集合是否为空  
            int imgSize = sendMessage.getImages().size();     
              
            if(imgSize > 0){  
              
                    List<SendMessage> lists = sendMessage.getImages();  
                    FileSystemResource fsr = null;  
                    String imgName = null;  
                    for(SendMessage entity : lists){  
                        fsr = new FileSystemResource(entity.getFile());  
                        imgName = entity.getImgName();  
                        //如果为图片类型就调用addInline,否则就调用:addAttachment方法^_^  
                        if(entity.getMailType() == MailType.IMG)  
                            mimeMessageHelper.addInline(imgName, fsr);  
                        else   
                            mimeMessageHelper.addAttachment(imgName, fsr);                                
                          
                    }  
                    fsr = null;               
                  
            }     
              
        } catch (MessagingException e) {                  
            e.printStackTrace();  
        }  
        senderImpl.send(mimeMessage);  
    }  
  
    /** 
     * 发送文本消息 
     */  
    private void sendTextMessage() {  
        simpleMailMessage.setTo(sendMessage.getTos());    
        simpleMailMessage.setFrom(sendMessage.getForm());  
        String subject = sendMessage.getSubject();  
        if(null != subject && !"".equals(subject)){  
            simpleMailMessage.setSubject(subject);  
        }         
        String text = sendMessage.getSendTexts();  
        if(null != text && !"".equals(text)){  
            simpleMailMessage.setText(text);  
        }     
        senderImpl.send(simpleMailMessage);  
    }  
      
      
    /**  
     * @param subject       发送标题  
     * @param text          发送内容         
     * @param to            接收人地址 
     */  
    public void send(String subject,String text,String ... to){       
        sendMessage(subject, text, to);               
    }  
      
      
  
    private void sendMessage(String subject, String text, String... to) {  
        setTo(to);  
        setSubject(subject);  
        setText(text);  
    }  
      
      
  
    public SendMessage getSendMessage() {  
        return sendMessage;  
    }  
  
    /*** 
     * 接收一个消息对象 
     * */  
    public MailMessageFactory setSendMessage(SendMessage sendMessage) {  
        this.sendMessage = sendMessage;       
        return this;  
    }  
    
    public TaskExecutor getThreadPool() {
		return threadPool;
	}
	public void setThreadPool(TaskExecutor threadPool) {
		this.threadPool = threadPool;
	}
}