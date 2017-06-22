package com.ai.platform.common.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.UriUtils;

import com.ai.platform.common.config.Global;

/**
 * 查看CK上传的图片
 * @author ThinkGem
 * @version 2014-06-25
 */
public class UserfilesDownloadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(getClass());

	public void fileOutputStream(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String filepath = req.getRequestURI();
		int index = filepath.indexOf(Global.USERFILES_BASE_URL);
		if(index >= 0) {
			filepath = filepath.substring(index + Global.USERFILES_BASE_URL.length());
		}
		try {
			filepath = UriUtils.decode(filepath, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			logger.error(String.format("解释文件路径失败，URL地址为%s", filepath), e1);
		}
		File file = new File(Global.getUserfilesBaseDir() + Global.USERFILES_BASE_URL + filepath);
		ServletOutputStream sos = null;
        FileInputStream fis = null;
		try {
//			FileCopyUtils.copy(new FileInputStream(file), resp.getOutputStream());
//			resp.setContentType("application/x-msdownload");
//			resp.addHeader("Content-Disposition", "attachment;");
	        // 解决中文文件名乱码问题  
			String fileName =file.getName();  
			String fname = "";
	        if (req.getHeader("User-Agent").toLowerCase()  
	                .indexOf("firefox") > 0) {  
	                fname = new String(fileName.getBytes("UTF-8"), "ISO8859-1").replace("+","%20"); // firefox浏览器  
	        } else if (req.getHeader("User-Agent").toUpperCase()  
	                .indexOf("MSIE") > 0) {  
	            fname = URLEncoder.encode(fileName, "UTF-8").replace("+","%20");// IE浏览器  
	        }else if (req.getHeader("User-Agent").toUpperCase()  
	                .indexOf("CHROME") > 0) {  
	            fname = new String(fileName.getBytes("UTF-8"), "ISO8859-1").replace("+","%20");// 谷歌  
	        } 
			resp.setContentType("application/x-msdownload");
//			resp.setContentType("application/octet-stream");//设置文件类型
            // 添加下载文件的头信息。此信息在下载时会在下载面板上显示，比如：
            // 迅雷下载显示的文件名称，就是此处filiname
			resp.addHeader("Content-Disposition", "attachment;filename=\""+ fname +"\"");
            // 添加文件的大小信息
			resp.setContentLength((int) file.length());
            // 获得输出网络流
			sos = resp.getOutputStream();
            fis = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int i = 0;
            while ((i = fis.read(buffer)) != -1) {
                sos.write(buffer, 0, i);
                sos.flush();
            }
           /* sos.close();
            if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					logger.error(e.getMessage());
				}
			}*/
			return;
		} catch (FileNotFoundException e) {
//			req.setAttribute("exception", new FileNotFoundException("请求的文件不存在"));
//			req.getRequestDispatcher("/WEB-INF/views/error/404.jsp").forward(req, resp);
		}finally {
			if(sos!=null) {
				sos.close();
			}
            if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					logger.error(e.getMessage());
				}
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		fileOutputStream(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		fileOutputStream(req, resp);
	}
}
