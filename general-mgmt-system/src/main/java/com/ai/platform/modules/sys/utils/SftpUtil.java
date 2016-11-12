package com.ai.platform.modules.sys.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import com.ai.opt.sdk.util.DateUtil;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public final class SftpUtil {
	private static final Logger LOG = Logger.getLogger(SftpUtil.class);

	/**
	 * 连接sftp服务器
	 * 
	 * @param host
	 *            主机
	 * @param port
	 *            端口
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return
	 */
	public static final ChannelSftp connect(String host, int port, String username, String password) {
		ChannelSftp sftp = null;
		Session session = null;
		Channel channel = null;
		try {
			JSch jsch = new JSch();
			jsch.getSession(username, host, port);
			session = jsch.getSession(username, host, port);
			session.setPassword(password);
			Properties sshConfig = new Properties();
			sshConfig.put("StrictHostKeyChecking", "no");
			session.setConfig(sshConfig);
			session.connect();
			channel = session.openChannel("sftp");
			channel.connect();
			sftp = (ChannelSftp) channel;
			System.out.println("Connected to " + host + " success");
		} catch (Exception e) {
			System.out.println("Connected to " + host + " failure");
			if (channel != null && channel.isConnected()) {
				channel.disconnect();
			}
			if (session != null && session.isConnected()) {
				session.disconnect();
			}
		}
		return sftp;
	}

	/**
	 * 上传文件
	 * 
	 * @param directory
	 *            上传的目录
	 * @param uploadFile
	 *            要上传的文件
	 * @param sftp
	 * @throws Exception
	 */
	public static final String upload(String directory, MultipartFile uploadFile, ChannelSftp sftp) throws Exception {
		String fileName = uploadFile.getOriginalFilename();
		try {
			sftp.cd(directory);
		} catch (SftpException sException) {
			if (ChannelSftp.SSH_FX_NO_SUCH_FILE == sException.id) {
				makeDir(directory, sftp);
				sftp.cd(directory);
			}
		}
		try {
			System.out.println(sftp.pwd());
			String dateString = DateUtil.getDateString(DateUtil.yyyyMMddHHmmssSSS);
			int indexOf = fileName.lastIndexOf(".");
			fileName = fileName.substring(0, indexOf) + "_" + dateString + fileName.substring(indexOf);
			sftp.put(uploadFile.getInputStream(), fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileName;
	}

	private static final void makeDir(String directory, ChannelSftp sftp) throws Exception {
		System.out.println(directory);
		System.out.println(sftp.pwd());
		String parentPath = new File(directory).getParentFile().getPath().replace("\\", "/");
		if (parentPath.equals("/")) {
			sftp.mkdir(directory.substring(1));
		} else {
			try {
				sftp.cd(parentPath);
			} catch (SftpException sException) {
				if (ChannelSftp.SSH_FX_NO_SUCH_FILE == sException.id) {
					makeDir(parentPath, sftp);
				}
			}
			sftp.mkdir(directory);
		}
	}

	/*
	 * 关闭连接
	 */
	public static void disconnect(ChannelSftp sftp) {
		if (sftp == null) {
			return;
		}
		try {
			if (sftp.getSession() != null && sftp.getSession().isConnected()) {
				sftp.getSession().disconnect();
			}
			if (sftp.isConnected()) {
				sftp.disconnect();
			}
		} catch (JSchException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 下载文件
	 * 
	 * @param directory
	 *            下载目录
	 * @param downloadFile
	 *            下载的文件
	 * @param saveFile
	 *            存在本地的路径
	 * @param sftp
	 */

	public static final InputStream download(String directory, String downloadFile, String saveFilePath,
			ChannelSftp sftp) {
		LOG.error("开始读取文件：" + downloadFile);
		try {
			sftp.cd(directory);
			File dir = new File(saveFilePath);
			if (!dir.exists()) {
				dir.mkdir();
			}
			File file = new File(saveFilePath + "/" + downloadFile);
			if (!file.exists()) {
				file.createNewFile();
			}
			sftp.get(downloadFile, new FileOutputStream(file));
			InputStream inputStream = new FileInputStream(file);
			return inputStream;
		} catch (Exception e) {
			LOG.error("读取文件失败" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 下载文件到输出流
	 * 
	 * @param directory
	 * @param fileName
	 * @param response
	 * @param sftp
	 * @throws IOException
	 * @throws SftpException
	 */
	public static final void download(String directory, String fileName, HttpServletResponse response, ChannelSftp sftp)
			throws IOException, SftpException {
		OutputStream os = response.getOutputStream();// 取得输出流
		response.reset();// 清空输出流
		response.setContentType("application/msexcel");// 定义输出类型
		response.setHeader("Content-disposition",
				"attachment; filename=" + new String(fileName.getBytes("UTF-8"), "UTF-8"));// 设定输出文件头
		sftp.cd(directory);
		// 获取文件
		sftp.get(fileName, os);
		os.flush();
		os.close();
	}
	/**
	 * 获取sftp文件列表
	 * @param directory
	 * @param sftp
	 * @return
	 * @throws SftpException
	 * @author zhouxh
	 */
	public  static final List<String> listFiles(String directory, ChannelSftp sftp)
			throws SftpException {
		Pattern pattern = Pattern.compile("[^/\\\\]+$");  
		List<String> ftpFileNameList = new ArrayList<String>();
		Vector<LsEntry> sftpFile = sftp.ls(directory);
		LsEntry isEntity = null;
		String fileName = null;
		Iterator<LsEntry> sftpFileNames = sftpFile.iterator();
		while (sftpFileNames.hasNext()) {
			isEntity = (LsEntry) sftpFileNames.next();
			fileName = isEntity.getFilename();
			Matcher matcher = pattern.matcher(fileName);  
			if (matcher.find()) {
				ftpFileNameList.add(fileName);
			} 
		}
		return ftpFileNameList;
	}

	/**
	 * 删除sftp上的文件
	 * 
	 * @param directory
	 * @param deleteFile
	 * @param sftp
	 * @throws Exception
	 * @author zhouxh
	 * @ApiDocMethod
	 * @ApiCode
	 * @RestRelativeURL
	 */
	public static final void delete(String directory, String deleteFile, ChannelSftp sftp) throws Exception {
		sftp.cd(directory);
		sftp.rm(deleteFile);
	}

	public static void main(String[] args) {
		String ip = "10.19.13.13"; // 服务器IP地址
		String userName = "tstusr01"; // 用户名
		String userPwd = "chupiot@Ch8899"; // 密码
		int port = 22022; // 端口号
		ChannelSftp sftp = SftpUtil.connect(ip, port, userName, userPwd);
		try {
			SftpUtil.download("/aifs01/tstusers/tstusr01", "office.txt", "/Users/meteor/Downloads/test/", sftp);

			SftpUtil.listFiles("/aifs01/tstusers/tstusr01", sftp);
			File file = new File("/Users/meteor/Downloads/test/office.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(new FileInputStream(file));// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					System.out.println(lineTxt);
				}
				read.close();
			}
//			SftpUtil.delete("/aifs01/tstusers/tstusr01", "test.txt", sftp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
