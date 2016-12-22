package com.ai.platform.modules.sys.task;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.concurrent.BlockingQueue;

import org.apache.log4j.Logger;

import com.ai.platform.common.config.Global;
import com.ai.platform.common.utils.DateUtils;
import com.ai.platform.modules.sys.utils.SftpUtil;
import com.jcraft.jsch.ChannelSftp;

public class SftpReadFileThred extends Thread {
	private static final Logger LOG = Logger.getLogger(SftpReadFileThred.class);
	public BlockingQueue<String[]> userQueue;
	public BlockingQueue<String[]> officeQueue;
	public BlockingQueue<String[]> officeRepeatQueue;

	String ip = Global.getConfig("ftp.ip"); // 服务器IP地址
	String userName = Global.getConfig("ftp.userName"); // 用户名
	String userPwd = Global.getConfig("ftp.userPwd"); // 密码
	int port = Integer.parseInt(Global.getConfig("ftp.port")); // 端口号
	String path = Global.getConfig("ftp.path"); // 读取文件的存放目录
	String localpath = Global.getConfig("ftp.localpath");// 本地存在的文件路径

	public SftpReadFileThred(BlockingQueue<String[]> userQueue, BlockingQueue<String[]> officeQueue,
			BlockingQueue<String[]> officeRepeatQueue) {
		this.userQueue = userQueue;
		this.officeQueue = officeQueue;
		this.officeRepeatQueue = officeRepeatQueue;
	}

	public void run() {
		LOG.error("开始获取ftp文件：" + DateUtils.getDateTime());

		ChannelSftp sftp = SftpUtil.connect(ip, port, userName, userPwd);
		String[] fileList = new String[] { "office.txt", "user.txt" };
		for (String file : fileList) {
			LOG.error("ftp文件名：" + file);
			try {
				if (file.equals("office.txt") || file.equals("user.txt")) {
					readFile(file, sftp);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		LOG.error("获取ftp文件结束：" + DateUtils.getDateTime());
		SftpUtil.disconnect(sftp);
	}

	public void readFile(String fileName, ChannelSftp sftp) throws ParseException {
		InputStream ins = null;
		try {
			// 从服务器上读取指定的文件
			LOG.info("开始读取文件：" + fileName);
			ins = SftpUtil.download(path, fileName, localpath, sftp);
			if (ins != null) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(ins, "UTF-8"));
				String line;
				int lintNum = 0;
				while ((line = reader.readLine()) != null) {
					if (lintNum == 0) {
						lintNum++;
						continue;
					}
					try {
						String[] hrInfo = line.split("\\t");
						if (fileName.equals("office.txt")) {
							if (hrInfo.length != 4)
								continue;
							officeQueue.put(hrInfo);
							officeRepeatQueue.put(hrInfo);
							LOG.info("部门信息：" + hrInfo[1]);
						} else if (fileName.equals("user.txt")) {
							if (hrInfo.length == 8 && "0".equals(hrInfo[7])) {
								userQueue.put(hrInfo);
								LOG.info("员工名称：" + hrInfo[2]);
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
						LOG.error("读取文件失败：" + e.getMessage());
					}

				}
				reader.close();
				if (ins != null) {
					safeClose(ins);
				}
				SftpUtil.delete(path, fileName, sftp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			deleteFile(localpath + fileName);
		}
	}

	public void deleteFile(String sPath) {
		File file = new File(sPath);
		// 路径为文件且不为空则进行删除
		if (file.isFile() && file.exists()) {
			file.delete();
		}
	}

	public static void safeClose(InputStream fis) {
		if (fis != null) {
			try {
				fis.close();
			} catch (IOException e) {
				LOG.error(e.getMessage());
			}
		}
	}

}
