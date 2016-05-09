package com.terapico.caf;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleInvocationServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
			InvocationResult result=getResult(request,response);	
			render(request,response,result);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
			InvocationResult result=getResult(request,response);	
			render(request,response,result);
	}
	
	protected void render(HttpServletRequest request, HttpServletResponse response, InvocationResult result) throws ServletException, IOException {
		
		ServletResultRenderer renderer=getResultRenderer();
		renderer.render(this, request, response, result);
	}
	
	protected InvocationResult getResult(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		try {
			InvocationContext context = createInvocationContext(request);
			if(context==null){
				return wrapResult(new ServletException("The context should be prepared for call."));
			}
			
			InvocationResult result=invoke(context);
			
			if(result==null){
				return wrapResult( new ServletException("The result should not to be null."),context);
			}
			return result;
			
		} catch (Throwable e) {
			
			return wrapResult(e);
		}
	}
	
	protected InvocationResult wrapResult(Object actualResult, InvocationContext context){
		
		InvocationResult result=new SimpleInvocationResult();
		result.setInvocationContext(context);
		result.setActualResult(actualResult);
		return result;
	}
	
	protected InvocationResult wrapResult(Object actualResult){
		
		
		return wrapResult(actualResult,null);
	}
	
	
	
	
	
	protected InvocationResult invoke(InvocationContext context) throws ServletException
	{
		InvocationTool tool=getInvocationTool();
		if(tool==null){
			throw new ServletException("Invocation tool must be configured");
		}
		try {
			return tool.invoke(context);
		} catch (InvocationException e) {
			throw new ServletException(e);
		}
		
	}
	
	
	ServletInvocationContextFactory factory;
	
	protected InvocationContext createInvocationContext(HttpServletRequest request) throws InvocationException
	{
		
		if(factory==null){
			factory=InternalBeanFactory.getDefaultInvocationContextFactory();
			//cache the reference.
		}

		return factory.create(request);		
	}
	
	InvocationTool tool;
	
	protected InvocationTool getInvocationTool()
	{
		if(tool==null){
			tool=InternalBeanFactory.getDefaultInvocationTool();
			//cache the reference.
		}
		return tool;
		
	}
	ServletResultRenderer render;
	protected ServletResultRenderer getResultRenderer()
	{		
		if(render==null){
			render=InternalBeanFactory.getDefaultRenderer();
			//cache the reference.
		}
		return render;
	}
	

}
