package com.terapico.caf;

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
		return actualResult;
	}
	
	public Object getResultExpr() {
		return getObjectExpr(actualResult);
	}
	
	protected String getObjectExpr(Object target)
	{
		
		 Gson serializer = createGsonBuilder().create();  
		return "class: '"+target.getClass().getName()+"'\r\n"+serializer.toJson(target);
	}
	protected GsonBuilder createGsonBuilder()
	{
		
		  return new GsonBuilder().setPrettyPrinting().
				     setExclusionStrategies(new PropertiesExclusionStrategy());
		
	}
	
	

}
