package com.terapico.caf;

import java.util.HashSet;
import java.util.Set;

import com.terapico.naf.baseelement.LoginForm;

public class AuthencationService {
	
	public static boolean matchInternalToken(String inputToken)
	{
		return INTERNAL_TOKEN.equals(inputToken);
	}
	public static final String INTERNAL_TOKEN="__login__";
	private static final String PASSWORD_PARAMETER_NAME = "__email";
	private static final String USERNAME_PARAMETER_NAME = "__password";
	public static String getInternalToken()
	{
		return INTERNAL_TOKEN;
	}
	
	public static String getUsernameParameterName()
	{
		return USERNAME_PARAMETER_NAME;
	}
	public static String getPasswordParameterName()
	{
		return PASSWORD_PARAMETER_NAME;
	}
	
	public boolean login(String userName, String password,String sessionId){
		if(userName.contains("good")){
			addToAuthencated(sessionId);
			return true;
		}
		return false;
	}
	public LoginForm loginForm(){
		//just the stub form, no info set
		LoginForm loginForm=new LoginForm();
		loginForm.setInternalToken(INTERNAL_TOKEN);
		loginForm.setUsernameParmeter(USERNAME_PARAMETER_NAME);
		loginForm.setPasswordParmeter(PASSWORD_PARAMETER_NAME);
		
		return loginForm;
	}
	Set<String>authenticatedSessions;
	protected boolean authencated(String sessionId){
		ensureStore();
		return authenticatedSessions.contains(sessionId);
	}
	protected void ensureStore(){
		if(authenticatedSessions==null){
			authenticatedSessions=new HashSet<String>();
		}
		
	}
	
	protected boolean addToAuthencated(String sessionId){
		ensureStore();
		return authenticatedSessions.add(sessionId);
	}
	
	
}
