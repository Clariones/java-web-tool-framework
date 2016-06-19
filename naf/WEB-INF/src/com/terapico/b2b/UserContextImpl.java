package com.terapico.b2b;

public class UserContextImpl implements UserContext{
	public void logInfo(Object message){
		System.out.println(message);
	}
}
