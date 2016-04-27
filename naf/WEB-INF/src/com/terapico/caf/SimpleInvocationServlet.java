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
		
		InvocationContext context;
		try {
			context = createInvocationContext(request);
			if(context==null){
				throw new ServletException("The context should be prepared for call.");
			}
			
			InvocationResult result=invoke(context);
			
			if(result==null){
				throw new ServletException("The result should not to be null.");
			}
			
			render(request,response,result);
		} catch (InvocationException e) {
			
			throw new ServletException(e);
		}
		
		

	}
	protected void render(HttpServletRequest request, HttpServletResponse response, InvocationResult result) throws ServletException, IOException {
		
		ServletResultRenderer renderer=getResultRenderer();

		renderer.render(this, request, response, result);
	}
	
	
	
	protected InvocationResult invoke(InvocationContext context) throws ServletException
	{
		InvocationTool tool=getInvocationTool();
		if(tool==null){
			throw new ServletException("invocation tool must be configured");
		}
		try {
			return tool.invoke(context);//TODO: build the form
		} catch (InvocationException e) {
			throw new ServletException(e);
		}
		
	}
	
	
	
	
	protected InvocationContext createInvocationContext(HttpServletRequest request) throws InvocationException
	{
		
		ServletInvocationContextFactory factory=new SpringInvocationContextFactory();
		SimpleInvocationContext context=new SimpleInvocationContext();
		//   the form of call like  /naf/beanName/methodName/p1/p2/p3/p4/, all parameter need to be decode
		
		//Object target=lookupObject(request);
		//context.setTargetObject(target);

		
		return factory.create(request);		
	}
	protected InvocationTool getInvocationTool()
	{
		return new SimpleInvocationTool();
		
	}
	protected ServletResultRenderer getResultRenderer()
	{
		
		return new ServletResultRenderer();
	}
	
	
}
