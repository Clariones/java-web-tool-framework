package com.terapico.caf;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SimpleInvocationTool implements InvocationTool {

	public InvocationResult invoke(InvocationContext context) throws InvocationException {
		// TODO Auto-generated method stub
		Method method=context.getMethodToCall();
		Object targetObject=context.getTargetObject();
		Object parameters[]=context.getParameters();
		
		InvocationResult result=new SimpleInvocationResult();
		result.setInvocationContext(context);
		
		try {
			Object actualResult=method.invoke(targetObject, parameters);
			result.setActualResult(actualResult);
			
		} catch (InvocationTargetException exception) {
			//return  InvokeResult.createInstance(exception.getCause(),null,null);
			result.setActualResult(exception.getCause());
		}catch (Throwable e) {
			result.setActualResult(e);
		}
		return result;
	}
	
	

}
