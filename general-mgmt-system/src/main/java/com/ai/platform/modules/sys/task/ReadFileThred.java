package com.ai.platform.modules.sys.task;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.List;
import java.util.concurrent.BlockingQueue;

import com.ai.platform.modules.sys.utils.FtpUtils;

public class ReadFileThred extends Thread {
	public BlockingQueue<String[]> userQueue;
	public BlockingQueue<String[]> officeQueue;

	public ReadFileThred(BlockingQueue<String[]> userQueue, BlockingQueue<String[]> officeQueue) {
		this.userQueue = userQueue;
		this.officeQueue = officeQueue;
	}

	public void run() {
		FtpUtils ftp = new FtpUtils();
		List<String> fileList = ftp.getFileList("/");
		for (String file : fileList) {
			try {
				readFile(file, ftp);
				ftp.deleteFile(file);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		ftp.closeServer();
	}

	public void readFile(String fileName, FtpUtils ftp) throws ParseException {
		InputStream ins = null;
		try {
			// 从服务器上读取指定的文件
			ins = ftp.readFile(fileName);
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
					if (fileName.contains("office")) {
						if (hrInfo.length != 4)
							continue;
						officeQueue.put(hrInfo);
					} else if (fileName.contains("user")) {
						if (hrInfo.length != 7)
							continue;
						userQueue.put(hrInfo);

					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			reader.close();
			if (ins != null) {
				ins.close();
				ftp.completePendingCommand();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
