package com.terapico.caf;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class SimpleInvocationContext implements InvocationContext {
	
	private Object targetObject;
	private Method targetMethod;
	private Object[] parameters;	

	
	public Method getTargetMethod() {
		return targetMethod;
	}

	public void setTargetMethod(Method targetMethod) {
		this.targetMethod = targetMethod;
	}

	public void setTargetObject(Object targetObject) {
		this.targetObject = targetObject;
	}

	public void setParameters(Object[] parameters) {
		this.parameters = parameters;
	}

	public Object getTargetObject() {
		
		return targetObject;
	}

	public Method getMethodToCall() {
		
		return targetMethod;
	}
	public boolean isVoidMethod() {
		Type returnType=getMethodToCall().getReturnType();
		return returnType.equals(Void.TYPE);
	}

	public Object[] getParameters() {
		
		return parameters;
	}
	
	

}
