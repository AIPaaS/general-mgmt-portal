package com.ai.platform.modules.sys.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.log4j.Logger;

import com.ai.platform.common.config.Global;
import com.ai.platform.common.utils.DateUtils;

/**
 * ftp工具类
 *
 * Date: 2016年10月9日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhouxh
 */
public class FtpUtils {
	private static final Logger LOG = Logger.getLogger(FtpUtils.class);
	private FTPClient ftpClient;
	/**
	 * init ftp servere
	 */
	public FtpUtils() {
		LOG.error("开始读取ftp配置信息，当前时间戳："+DateUtils.getDateTime());
		String ip = Global.getConfig("ftp.ip"); // 服务器IP地址
		String userName = Global.getConfig("ftp.userName"); // 用户名
		String userPwd = Global.getConfig("ftp.userPwd"); // 密码
		int port =Integer.parseInt(Global.getConfig("ftp.port")); // 端口号
	    String path = Global.getConfig("ftp.path"); // 读取文件的存放目录
	    LOG.error("FTP信息|ip:"+ip+"|userName:"+userName+"|userPwd:"+userPwd+"|port:"+port+"|path:"+path);
	    this.connectServer(ip, port, userName, userPwd, path);
	}

	/**
	 * @param ip
	 * @param port
	 * @param userName
	 * @param userPwd
	 * @param path
	 * @throws SocketException
	 * @throws IOException
	 *             function:连接到服务器
	 */
	public void connectServer(String ip, int port, String userName, String userPwd, String path) {
		LOG.error("开始连接ftp，当前时间戳："+DateUtils.getDateTime());
		ftpClient = new FTPClient();
		try {
			// 连接
			ftpClient.connect(ip, port);
			// 登录
			ftpClient.login(userName, userPwd);
			if (path != null && path.length() > 0) {
				// 跳转到指定目录
				ftpClient.changeWorkingDirectory(path);
			}
		} catch (SocketException e) {
			LOG.error("连接ftp失败，当前时间戳："+DateUtils.getDateTime());
			e.printStackTrace();
		} catch (IOException e) {
			LOG.error("连接ftp失败，当前时间戳："+DateUtils.getDateTime());
			e.printStackTrace();
		}
		LOG.error("连接ftp成功，当前时间戳："+DateUtils.getDateTime());
	}

	/**
	 * @throws IOException
	 *             function:关闭连接
	 */
	public void closeServer() {
		if (ftpClient.isConnected()) {
			try {
				ftpClient.logout();
				ftpClient.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param path
	 * @return function:读取指定目录下的文件名
	 * @throws IOException
	 */
	public List<String> getFileList() {
		LOG.error("开始读取ftp文件，当前时间戳："+DateUtils.getDateTime());
		List<String> fileLists = new ArrayList<String>();
		// 获得指定目录下所有文件名
		FTPFile[] ftpFiles = null;
		try {
			ftpFiles = ftpClient.listFiles(Global.getConfig("ftp.path"));
			LOG.error("ftpFiles："+ftpFiles.length+"，当前时间戳："+DateUtils.getDateTime());
		} catch (IOException e) {
			e.printStackTrace();
			LOG.error("读取ftp文件异常,当前时间戳："+DateUtils.getDateTime());
			LOG.error(e.getMessage());
		}
		for (int i = 0; ftpFiles != null && i < ftpFiles.length; i++) {
			FTPFile file = ftpFiles[i];
			if (file.isFile()) {
				fileLists.add(file.getName());
				LOG.error("ftp文件名称："+file.getName()+"，当前时间戳："+DateUtils.getDateTime());
			}
		}
		return fileLists;
	}
	
	public InputStream readFile(String fileName) throws ParseException {
		InputStream ins=null;
		try {
			// 从服务器上读取指定的文件
		    ins = ftpClient.retrieveFileStream(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ins;
	}

	public void completePendingCommand(){
		try {
			ftpClient.completePendingCommand();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param fileName
	 *            function:删除文件
	 */
	public void deleteFile(String fileName) {
		try {
			ftpClient.deleteFile(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String ip = "111.9.116.182"; // 服务器IP地址
		String userName = "test"; // 用户名
		String userPwd = "123456"; // 密码
		int port =21; // 端口号
	    String path = "/home/test"; // 读取文件的存放目录
	    FTPClient  ftpClient = new FTPClient();
		try {
			// 连接
			ftpClient.connect(ip, port);
			// 登录
			ftpClient.login(userName, userPwd);
			if (path != null && path.length() > 0) {
				// 跳转到指定目录
				ftpClient.changeWorkingDirectory(path);
			}
			List<String> fileLists = new ArrayList<String>();
			// 获得指定目录下所有文件名
			FTPFile[] ftpFiles = null;
			try {
				ftpFiles = ftpClient.listFiles(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
			for (int i = 0; ftpFiles != null && i < ftpFiles.length; i++) {
				FTPFile file = ftpFiles[i];
				if (file.isFile()) {
					fileLists.add(file.getName());
				}
			}
			for(String file: fileLists){
				InputStream ins = ftpClient.retrieveFileStream(file);
				ins.close();
				ftpClient.completePendingCommand();
				System.out.println(ins);
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
