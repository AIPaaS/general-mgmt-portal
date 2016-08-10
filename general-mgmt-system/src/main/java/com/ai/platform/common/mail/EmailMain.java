package com.ai.platform.common.mail;

import java.io.File;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.ai.platform.common.utils.SpringContextHolder;

public class EmailMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello");
		for(int a = 0 ;a<10;a++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					for(int a=0;a<10;a++){
						// TODO Auto-generated method stub
						System.out.println("第一个线程 , 第"+a+"次发送");
						sendTextMessage("第一个线程"+a); 
						 try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}).start();
			
		}
		
		for(int b = 0 ;b<10;b++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					for(int a=0;a<10;a++){
						// TODO Auto-generated method stub
						System.out.println("第二组线程 , 第"+a+"次发送");
						sendTextMessage("第二组线程"+a); 
						 try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}).start();
			
		}
		
	
		
	}
	
	//发送文本邮件
	public static void sendTextMessage(String args){
		    MailMessageFactory mms = SpringContextHolder.getBean(MailMessageFactory.class);  
		    mms.setSubject(args+"使用spring email 测试发送文本消息")  
		    .setText("正文消息了。。。。")  
		    .send(); 
	}
	

	//发送Html格式消息 
	public static void sendHtmlMessage(){
		MailMessageFactory mms = new MailMessageFactory(SendMailType.HTML);  
        mms.setSubject("使用spring email 测试发送Html中文邮件")  
        .setText("<html><head><meta http-equiv='content-type' content='text/html; charset=GBK'>" +  
                "</head><body><h1>这里是咫尺天涯发送的邮件</h1></body></html>").send(); 
	}
	
	//发送含有图片的邮件
	public static void sendImageMessage(){
		MailMessageFactory mms = new MailMessageFactory(SendMailType.HTML);               
        String text = "<html><body>欢迎访问咫尺天涯博客<br>"  
               + "<a href='http://liuzidong.iteye.com/' target='_blank'>"  
               + "<img src='cid:belle'></a><br><img src='cid:belle2'></body></html>";    
        //附件要嵌入到HTML中显示，则在IMG标签中用"cid:XXX"标记。                 
       mms.setSubject("使用spring email 测试邮件中嵌套图片");   
       mms.setText(text);  
       File file = new File("c:\\5.jpg");            
       mms.setImgFile("belle", file);        
       File file2 = new File("c:\\4.jpg");  
       mms.setImgFile("belle2", file2);      
       mms.send(); 
	}
	
	
	//发送含有附件的消息
	public static void sendAttachmentMessage(){
		MailMessageFactory mms = new MailMessageFactory(SendMailType.HTML);  
        mms.setSubject("使用spring email 测试发送附件");  
        File file = new File("c:\\1.zip");  
        mms.setAttachmentFile("jquery学习记录", file).send(); 
	}
	
	//综合发送(文本,html,img,file)消息 
	public static void sendMultipleMessage(){
		MailMessageFactory mms = new MailMessageFactory(SendMailType.HTML);  
        mms.setSubject("使用spring email 测试发送邮件<包含html,img,file>等格式");        
        mms.setText("这是我的文本格式");  
        mms.setText("<html><head><h1>这里是咫尺天涯发送的邮件</h1></head><body>" +  
                "<h1><a href='http://liuzidong.iteye.com/' target='_blank'></h1><br>" +  
                "<img src='cid:belle'></a><br><img src='cid:belle2'>"+  
                "</body></html>");  
         //附件要嵌入到HTML中显示，则在IMG标签中用"cid:XXX"标记。   
        File file = new File("c:\\5.jpg");  
        mms.setImgFile("belle", file);        
        File file2 = new File("c:\\4.jpg");  
        mms.setImgFile("belle2", file2);          
        File file3 = new File("c:\\1.zip");  
        mms.setAttachmentFile("附件1", file3);          
        File file4 = new File("c:\\jquery学习记录.txt");  
        mms.setAttachmentFile("jquery学习记录", file4);       
        mms.send(); 
	}
	
	
}
