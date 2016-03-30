package baiduservicecommon;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class URLBuilder {
	
	String finalURL;
	private String baseURL;
	private StringBuffer stringBuffer;
	private String encoding="UTF-8";
	
	public URLBuilder(String base)
	{
		this.baseURL=base;
		
		
	}
	public URLBuilder(String base,String encoding)
	{
		this.baseURL=base;
		this.encoding=encoding;
		
		
	}
	public URLBuilder parameter(String name, String value) throws UnsupportedEncodingException
	{
		if(this.stringBuffer==null){
			stringBuffer=new StringBuffer(this.baseURL);
			stringBuffer.append("?");
			stringBuffer.append(URLEncoder.encode(name, this.encoding));
			stringBuffer.append("=");
			stringBuffer.append(URLEncoder.encode(value, this.encoding));
			
			return this;
			
		}
		stringBuffer.append("&");
		stringBuffer.append(URLEncoder.encode(name, this.encoding));
		stringBuffer.append("=");
		stringBuffer.append(URLEncoder.encode(value, this.encoding));
		
		
		return this;
		
	}
	public String done() throws UnsupportedEncodingException
	{
		if(this.stringBuffer==null){			
			stringBuffer=new StringBuffer(this.baseURL);
		}
		return this.stringBuffer.toString();
		
	}
	
}
