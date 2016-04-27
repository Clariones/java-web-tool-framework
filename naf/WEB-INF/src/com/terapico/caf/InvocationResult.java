package com.terapico.caf;

public interface InvocationResult {

	public void setActualResult(Object actualResult);

	public void setInvocationContext(InvocationContext context);

	public Object getActualResult();
	
}
