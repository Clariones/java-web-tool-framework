package com.terapico.caf;

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
	

}
