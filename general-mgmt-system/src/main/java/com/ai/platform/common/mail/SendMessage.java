package com.ai.platform.common.mail;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SendMessage {  
      
    private String [] tos;  
    private String subject;  
      
    private String imgName;  
    private File file;  
    private MailType mailType;   
      
    private String form;  
      
    private List<String> texts = new ArrayList<String>();  
      
    //图片集合  
    private List<SendMessage> images = new ArrayList<SendMessage>();  
      
    public MailType getMailType() {  
        return mailType;  
    }  


    public void setMailType(MailType mailType) {  
        this.mailType = mailType;  
    }  


    public void addFile(MailType mailType,String imgName,File file){  
        images.add(new SendMessage(mailType,imgName,file));  
    }  
      
    public void addText(String text){  
        texts.add(text);  
    }  
      
      
    public SendMessage(MailType mailType,String imgName, File file) {  
        super();  
        this.mailType =  mailType;  
        this.imgName = imgName;  
        this.file = file;  
    }  



    public List<SendMessage> getImages() {  
        return images;  
    }  
    public void setImages(List<SendMessage> images) {  
        this.images = images;  
    }  
    public String getForm() {  
        return form;  
    }  
    public void setForm(String form) {  
        this.form = form;  
    }  
    public String getImgName() {  
        return imgName;  
    }  
    public void setImgName(String imgName) {  
        this.imgName = imgName;  
    }  
      
    public String[] getTos() {  
        return tos;  
    }  
    public void setTos(String[] tos) {  
        this.tos = tos;  
    }  
    public String getSubject() {  
        return subject;  
    }  
    public void setSubject(String subject) {          
        this.subject = subject;  
    }  
      
    public SendMessage() {  
          
    }  
    public SendMessage(String[] tos, String subject, String text) {  
        super();  
        this.tos = tos;  
        this.subject = subject;  
        addText(text);  
    }  
      
    public String getSendTexts(){  
        StringBuilder sbr = new StringBuilder();  
        List<String> texts = getTexts();  
        for(String text : texts){  
            sbr.append(text);  
        }  
        return sbr.toString();  
    }  
      
    @Override  
    public String toString() {  
        StringBuilder sbrTos = new StringBuilder();  
        for(String to : tos){  
            sbrTos.append(to).append(",");  
        }  
        String sbrText = sbrTos.substring(0,sbrTos.length()-1);  
        return new StringBuilder()  
        .append("接收人地址: ").append(sbrText)  
        .append(",发送人地址: ").append(form)  
        .append(",发送标题: ").append(subject)  
        .append(",发送内容: ").append(getSendTexts())  
        .toString();  
    }  
    public File getFile() {  
        return file;  
    }  
    public void setFile(File file) {  
        this.file = file;  
    }  


    public List<String> getTexts() {  
        return texts;  
    }  


    public void setTexts(List<String> texts) {  
        this.texts = texts;  
    }  
      
}  