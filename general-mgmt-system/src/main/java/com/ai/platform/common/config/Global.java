/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ai.platform.common.config;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.springframework.core.io.DefaultResourceLoader;

import com.ai.platform.common.utils.PropertiesLoader;
import com.ai.platform.common.utils.StringUtils;
import com.ckfinder.connector.ServletContextFactory;
import com.google.common.collect.Maps;

/**
 * 全局配置类
 * @author ThinkGem
 * @version 2014-06-25
 */
public class Global {

	/**
	 * 当前对象实例
	 */
	private static Global global = new Global();
	
	/**
	 * 保存全局属性值
	 */
	private static Map<String, String> map = Maps.newHashMap();
	
	/**
	 * 属性文件加载对象
	 */
	private static PropertiesLoader loader = new PropertiesLoader("mgmt.properties");

	/**
	 * 显示/隐藏
	 */
	public static final String SHOW = "1";
	public static final String HIDE = "0";

	/**
	 * 是/否
	 */
	public static final String YES = "1";
	public static final String NO = "0";
	
	/**
	 * 对/错
	 */
	public static final String TRUE = "true";
	public static final String FALSE = "false";
	
	/**
	 * 上传文件基础虚拟路径
	 */
	public static final String USERFILES_BASE_URL = "/userfiles/";
	
	   /**邮件服务器*/  
    private static final String EMAIL_HOST_KEY = "mail.host";  
    public static final String EMAIL_HOST = loader.getProperty(EMAIL_HOST_KEY);  
      
    /**用户名*/  
    private static final String EMAIL_USERNAME_KEY = "mail.username";  
    public static final String EMAIL_USERNAME = loader.getProperty(EMAIL_USERNAME_KEY);  
      
    /**用户密码*/  
    private static final String EMAIL_PASSWORD_KEY = "mail.password";  
    public static final String EMAIL_PASSWORD = loader.getProperty(EMAIL_PASSWORD_KEY);     
      
    /**接收人*/  
    private static final String EMAIL_TO_KEY = "mail.to";  
    public static final String EMAIL_TO = loader.getProperty(EMAIL_TO_KEY);  
      
    /**发送人*/  
    private static final String EMAIL_FROM_KEY = "mail.from";  
    public static final String EMAIL_FROM = loader.getProperty(EMAIL_FROM_KEY);     
      
    /**服务器进行认证,认证用户名和密码是否正确*/  
    private static final String EMAIL_SMTP_AUTH_KEY = "mail.smtp.auth";  
    public static final String EMAIL_SMTP_AUTH = loader.getProperty(EMAIL_SMTP_AUTH_KEY);  
      
    /**超时时间设定*/  
    private static final String EMAIL_SMTP_TIMEOUT_KEY = "mail.smtp.timeout";  
    public static final String EMAIL_SMTP_TIMEOUT = loader.getProperty(EMAIL_SMTP_TIMEOUT_KEY);  
      
      
    /**编码设置*/  
    private static final String EMAIL_ENCODING_KEY = "mail.encoding";  
    public static final String EMAIL_ENCODING = loader.getProperty(EMAIL_ENCODING_KEY);  
      
    private static final String EMAIL_SMTP_STARTTLS_KEY = "mail.smtp.starttls.enable";  
    public static final String EMAIL_SMTP_STARTTLS = loader.getProperty(EMAIL_SMTP_STARTTLS_KEY);  
      
    //private static final String EMAIL_SMTP_SOCKETFACTORY_CLASS_KEY = "mail.smtp.socketFactory.class";  
    //public static final String EMAIL_SMTP_SOCKETFACTORY_CLASS = ReadConfigEmail.getPropertyByKey(EMAIL_SMTP_SOCKETFACTORY_CLASS_KEY);  
      
      
    /**安全认证设置*/  
    public static Properties safetyProperties = new Properties();  
      
    static{  
        //调试信息,可以取消  
        //System.setProperty( "javax.net.debug", "ssl");          
        /** 
         * #配置JavaMail的Properties时，不要指定“mail.smtp.socketFactory.class”， 
           #因为TLS使用的是普通的Socket。然后指定属性“mail.smtp.starttls.enable”为“true”。 
         * */         
        safetyProperties.put(EMAIL_SMTP_AUTH_KEY, EMAIL_SMTP_AUTH);   
        safetyProperties.put(EMAIL_SMTP_TIMEOUT_KEY, EMAIL_SMTP_TIMEOUT);   
        safetyProperties.put(EMAIL_SMTP_STARTTLS_KEY, EMAIL_SMTP_STARTTLS);   
        //safetyProperties.put(EMAIL_SMTP_SOCKETFACTORY_CLASS_KEY, EMAIL_SMTP_SOCKETFACTORY_CLASS);  
    }
	
	/**
	 * 获取当前对象实例
	 */
	public static Global getInstance() {
		return global;
	}
	
	/**
	 * 获取配置
	 * @see ${fns:getConfig('adminPath')}
	 */
	public static String getConfig(String key) {
		String value = map.get(key);
		if (value == null){
			value = loader.getProperty(key);
			map.put(key, value != null ? value : StringUtils.EMPTY);
		}
		return value;
	}
	
	/**
	 * 获取管理端根路径
	 */
	public static String getAdminPath() {
		return getConfig("adminPath");
	}
	
	/**
	 * 获取前端根路径
	 */
	public static String getFrontPath() {
		return getConfig("frontPath");
	}
	
	/**
	 * 获取URL后缀
	 */
	public static String getUrlSuffix() {
		return getConfig("urlSuffix");
	}

	
	/**
	 * 获取前端默认主题
	 */
	public static String getDefTheme() {
		return getConfig("web.default.theme");
	}
	
	/**
	 * 是否是演示模式，演示模式下不能修改用户、角色、密码、菜单、授权
	 */
	public static Boolean isDemoMode() {
		String dm = getConfig("demoMode");
		return "true".equals(dm) || "1".equals(dm);
	}
	
	/**
	 * 在修改系统用户和角色时是否同步到Activiti
	 */
	public static Boolean isSynActivitiIndetity() {
		String dm = getConfig("activiti.isSynActivitiIndetity");
		return "true".equals(dm) || "1".equals(dm);
	}
	
	/**

	* 获取当前租户信息

	*/

	public static String getTenantID() {

		return getConfig("web.tenant.id");

	}
    
	/**
	 * 页面获取常量
	 * @see ${fns:getConst('YES')}
	 */
	public static Object getConst(String field) {
		try {
			return Global.class.getField(field).get(null);
		} catch (Exception e) {
			// 异常代表无配置，这里什么也不做
		}
		return null;
	}

	/**
	 * 获取上传文件的根目录
	 * @return
	 */
	public static String getUserfilesBaseDir() {
		String dir = getConfig("userfiles.basedir");
		if (StringUtils.isBlank(dir)){
			try {
				dir = ServletContextFactory.getServletContext().getRealPath("/");
			} catch (Exception e) {
				return "";
			}
		}
		if(!dir.endsWith("/")) {
			dir += "/";
		}
//		System.out.println("userfiles.basedir: " + dir);
		return dir;
	}
	
    /**
     * 获取工程路径
     * @return
     */
    public static String getProjectPath(){
    	// 如果配置了工程路径，则直接返回，否则自动获取。
		String projectPath = Global.getConfig("projectPath");
		if (StringUtils.isNotBlank(projectPath)){
			return projectPath;
		}
		try {
			File file = new DefaultResourceLoader().getResource("").getFile();
			if (file != null){
				while(true){
					File f = new File(file.getPath() + File.separator + "src" + File.separator + "main");
					if (f == null || f.exists()){
						break;
					}
					if (file.getParentFile() != null){
						file = file.getParentFile();
					}else{
						break;
					}
				}
				projectPath = file.toString();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return projectPath;
    }
	
}
