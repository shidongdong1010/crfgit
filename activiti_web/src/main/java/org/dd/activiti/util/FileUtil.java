package org.dd.activiti.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileUtil {

	/**
	 * 获取图片
	 * @param request
	 * @param response
	 */
	public void getImage(HttpServletRequest request, HttpServletResponse response) {
		try {
			URL url = new URL("http://csdnimg.cn/www/images/csdnindex_logo.gif");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(5 * 1000);
			InputStream inStream = conn.getInputStream();// 通过输入流获取图片数据
			byte data[] = readInputStream(inStream);
			inStream.read(data); // 读数据
			inStream.close();
			response.setContentType("image/jpg"); // 设置返回的文件类型
			OutputStream os = response.getOutputStream();
			os.write(data);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static byte[] readInputStream(InputStream inStream) throws Exception {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[2048];
		int len = 0;
		while ((len = inStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, len);
		}
		inStream.close();
		return outStream.toByteArray();
	}
}
