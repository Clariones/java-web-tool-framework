package baiduservicecommon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
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
	protected String callBaiduAPI(URI uri, String apiKey) throws Exception {				
		
		
		int count=0;
		final int retryCount=100;
		while(true){
			URLConnection conn;
			try {
				conn = uri.toURL().openConnection();

				
				if(!(conn instanceof HttpURLConnection)){
					
					throw new IllegalArgumentException("The URI must be HTTP URI");
				}
				
				
				HttpURLConnection httpConn=(HttpURLConnection) conn;				

				httpConn.setRequestProperty("apikey", apiKey);

				BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String line;
				StringBuilder content=new StringBuilder(1000);
			    while ((line = reader.readLine()) != null) {
			    	content.append(line);
			    	content.append("\r\n");
			    }		
			    reader.close();
			    
				return content.toString();
			} catch (MalformedURLException e) {
				throw e;
			} catch (IOException e) {
				
				
				count++;
				
				sleepOrDie(count,retryCount,1000,e);
				
			}
			
		}
		//throw new IOException("重试次数超过"+count+"次，只好放弃了",lastException);

	}
	
	protected String callWebAPI(URI uri) throws Exception {				
		
		int count=0;
		final int retryCount=100;
		while(true){
			URLConnection conn;
			try {
				conn = uri.toURL().openConnection();

				
				if(!(conn instanceof HttpURLConnection)){
					
					throw new IllegalArgumentException("The URI must be HTTP URI");
				}
				
				BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String line;
				StringBuilder content=new StringBuilder(1000);
			    while ((line = reader.readLine()) != null) {
			    	content.append(line);
			    	content.append("\r\n");
			    }		
			    reader.close();
			    
				return content.toString();
			} catch (MalformedURLException e) {
				throw e;
			} catch (IOException e) {
				
				
				count++;
				
				sleepOrDie(count,retryCount,1000,e);
				
			}
			
		}
		//throw new IOException("重试次数超过"+count+"次，只好放弃了",lastException);

	}
	
	protected void sleepOrDie(int currentCount, int retryCount, int sleepMillis, Exception e) throws Exception
	{
		if(currentCount<retryCount) {
			log("重试第: "+(currentCount+1)+"次: "+ e.getMessage());
			Thread.sleep(sleepMillis);
			return;
		}
		throw e;
		
	}
	
	protected void log(String message)
	{
		System.out.println("BaiduInstantService: "+message);

	}
	

}
