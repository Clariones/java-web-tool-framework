package com.terapico.caf;

import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SimpleInvocationResult implements InvocationResult {

	private InvocationContext invocationContext;
	private Object actualResult;
	public void setActualResult(Object actualResult) {
		// TODO Auto-generated method stub
		this.actualResult=actualResult;
	}
	public void setInvocationContext(InvocationContext context) {
		// TODO Auto-generated method stub
		this.invocationContext=context;
	}
	public InvocationContext getInvocationContext() {
		return invocationContext;
	}
	public Object getActualResult() {
		
		if(actualResult==null){
			return Boolean.TRUE;
		}
		
		return actualResult;
	}
	
	public Object getResultExpr() {
		return getObjectExpr(actualResult);
	}
	class PropertiesExclusionStrategy implements com.google.gson.ExclusionStrategy {

		public boolean shouldSkipField(FieldAttributes fa) {

			if (fa.getName().startsWith("parent")) {
				return true;
			}
			return false;
		}

		public boolean shouldSkipClass(Class<?> clazz) {

			return false;
		}

	}
	protected String getObjectExpr(Object target) {
		try {
			Gson serializer = new GsonBuilder().setExclusionStrategies(new PropertiesExclusionStrategy()).setPrettyPrinting().create();
			return "class: '" + target.getClass().getName() + "'\r\n" + serializer.toJson(target);
		} catch (Throwable e) {
			return e.getMessage();
		}
	}
	protected GsonBuilder createGsonBuilder()
	{
		
		  return new GsonBuilder().setPrettyPrinting().
				     setExclusionStrategies(new PropertiesExclusionStrategy());
		
	}
	
	

}
