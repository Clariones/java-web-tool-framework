package com.terapico.naf;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class ObjectFriendlyURI extends FriendlyURI {
	private String beanName;

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
	
	public  FriendlyURI parse(String requestURI,int start) throws UnsupportedEncodingException
	{
		if(start<0){
			throw new IllegalArgumentException(" parse(String requestURI,int start): start<0, not expected");
		}
		if(requestURI==null){
			throw new IllegalArgumentException("parse(String requestURI,int start):  requestURI is null, not expected");
		}
		String array[]=requestURI.split("/");
		if(array.length<start+2){
			throw new IllegalArgumentException("object requestURI need to contains bean name and service(method) as least: '"+requestURI+"' not full defined");
		}
		//FriendlyURI furi=new FriendlyURI();
		this.setBeanName(URLDecoder.decode(array[start],"UTF-8"));
		this.setServiceName(URLDecoder.decode(array[start+1],"UTF-8"));
		for(int i=start+2;i<array.length;i++){
			String val=URLDecoder.decode(array[i],"UTF-8").trim();
			this.addParameter(val);
		}
		//System.out.println(URLDecoder.decode(schema[2],"UTF-8"));
		return this;

		
	}
	
	public String toString()  {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer(100);
		sb.append(this.getBeanName());
		sb.append('.');
		sb.append(this.getServiceName());
		sb.append('(');
		sb.append(joinParameter(","));
		sb.append(");");
		return sb.toString();
	}
	
	
}
