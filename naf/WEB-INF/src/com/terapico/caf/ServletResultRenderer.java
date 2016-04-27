package com.terapico.caf;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class ServletResultRenderer{
	
	public void render(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response, InvocationResult result) throws ServletException, IOException {
		if (isRequestForJson(request)) {
			renderJson(result, request, response);
			return;
		}

		renderHTMLPage(servlet,result, request, response);
	}
	
	protected boolean isRequestForJson(HttpServletRequest request) {
		String accept = request.getHeader("Accept");
		if (accept == null) {
			return false;
		}
		if (accept.isEmpty()) {
			return false;
		}
		if (accept.contains("json")) {
			return true;
		}
		return false;

	}
	
	protected void renderJson(InvocationResult result, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if ((result.getActualResult() instanceof Exception)) {
			return;
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("applicaton/json; encoding=UTF-8");
		Gson gson = new Gson();
		// Type t=new TypeToken<weather.WeatherResponse>().getType();
		response.getWriter().println(gson.toJson(result.getActualResult()));
		return;

	}

	protected void renderHTMLPage(HttpServlet servlet, InvocationResult result, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; encoding=UTF-8");
		response.addHeader("Cache-Control", "no-cache, must-revalidate");
		request.setAttribute("result", result.getActualResult());
		this.dispatchView(servlet,request, response, result);

	}

	protected void dispatchView(HttpServlet servlet,HttpServletRequest request, HttpServletResponse response, InvocationResult result)
			throws ServletException, IOException {
		RequestDispatcher view = getRenderView(servlet,request, result);
		view.include(request, response);

	}

	protected void logInfo(String message) {
		//log.log(Level.INFO, message);

	}

	protected RequestDispatcher getRenderView(HttpServlet servlet,HttpServletRequest request, InvocationResult result)
			throws MalformedURLException {
		
		return getSimpleRenderView(servlet,request, result.getActualResult());
		
		/*
		Not support for generic parameters now.
		if (!result.isGenericResult()) {
			return getSimpleRenderView(request, result.getActualResult());
		}

		return request.getRequestDispatcher("/" + result.getRenderKey() + ".jsp");
		*/

	}
	
	private Map<Class,String>viewCache=new ConcurrentHashMap<Class,String>();
	
	protected RequestDispatcher getSimpleRenderView(HttpServlet servlet,HttpServletRequest request, Object object)
			throws MalformedURLException {

		
		
		Class temp = object.getClass();
		String cachedPage=viewCache.get(temp);
		if(cachedPage!=null){
			return request.getRequestDispatcher(cachedPage);
		}
		
		
		while (temp != null) {
			String jsp = "/" + temp.getName() + ".jsp";
			logInfo("trying to find: " + jsp);
			URL url = servlet.getServletContext().getResource(jsp);
			if (url != null) {				
				viewCache.put(temp, jsp);
				return request.getRequestDispatcher(jsp);
			}
			temp = temp.getSuperclass();
		}
		return request.getRequestDispatcher("/java.lang.Object.jsp");// should
																		// not
																		// go
																		// here

	}

	
}
