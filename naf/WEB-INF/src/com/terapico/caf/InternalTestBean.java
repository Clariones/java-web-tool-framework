package com.terapico.caf;

public class InternalTestBean {
	public String hello(){
		return "when you see this, that means you need to inject some beans to playwith";
	}
	public String echo(String message){
		return message;
	}
}
