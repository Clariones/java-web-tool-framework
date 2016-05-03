package chinastock;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class TextTool {
	public static String getTextFromFile(String filePath) {
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new FileReader(filePath));
			String str;
			while ((str = in.readLine()) != null) {

				sb.append(str);
				sb.append("\r\n");
			}
			in.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return null;
		}
		return sb.toString();
	}

	public static String getTextFromURL(URL url) {

		StringBuilder sb = new StringBuilder();
		try {
			URLConnection conn = (URLConnection) url.openConnection();

			conn.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");
			conn.setRequestProperty("Accept-Charset", "GBK,utf-8;q=0.7,*;q=0.3");
			conn.setRequestProperty("Connection", "keep-alive");
			conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");

			conn.connect();
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String str;
			while ((str = in.readLine()) != null) {
				sb.append(str);
				sb.append("\r\n");
			}
			in.close();

		} catch (IOException e) {
			System.out.println(e.getMessage());
			return null;
		}
		return sb.toString();
	}
}
