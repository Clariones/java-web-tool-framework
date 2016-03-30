package baiduservicecommon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URLConnection;


public class BaiduInstantService {
	
	protected String callBaiduAPI(URI uri) throws Exception{
		
		return callBaiduAPI(uri,getAPIKey());
	}
	
	protected String getAPIKey()
	{
		return System.getenv("BAIDUAPIKEY");
	}
	protected String callBaiduAPI(URI uri, String apiKey) throws Exception{				
		
		
		
		URLConnection conn = uri.toURL().openConnection();
		
		
		if(!(conn instanceof HttpURLConnection)){
			
			throw new IllegalArgumentException("The URI must be HTTP URI");
		}
		
		
		HttpURLConnection httpConn=(HttpURLConnection) conn;
		

		httpConn.setRequestProperty("apikey", apiKey);
		
		conn.setRequestProperty("apikey", apiKey);
		BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line;
		StringBuilder content=new StringBuilder(1000);
	    while ((line = reader.readLine()) != null) {
	    	content.append(line);
	    	content.append("\r\n");
	    }		
		
		return content.toString();
		
	}
	

}
