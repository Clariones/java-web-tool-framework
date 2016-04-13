package com.terapico.naf;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Hashtable;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import test.ServiceBeanTest;


public class InvokeServlet extends HttpServlet {

	
	private Object target;
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		
		initHelper(config); 
		
		initObject(config);

		
	}

	protected void initHelper(ServletConfig config) {
		String helperClass=config.getInitParameter("invokehelperclass");
		if(helperClass==null){
			this.logInfo("helper class is NOT configured, using default helper class");
			return;
		}
		
		
		try {
			Class clazz=Class.forName(helperClass);
			helper=(InvokeHelper)clazz.newInstance();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			this.logInfo("helper class is configured as '"+helperClass+"', ensure it exists, and a sub class of InvokeHelper");			
		}
	}
	
	private void initObject(ServletConfig config) {
		String targetclass=config.getInitParameter("targetclass");
		if(targetclass==null){
			this.logInfo("targetclass is NOT configured!");
			return;
		}
		
		
		try {
			Class clazz=Class.forName(targetclass);
			target=clazz.newInstance();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			this.logInfo("helper class is configured as '"+targetclass+"', ensure it exists, and a sub class of InvokeHelper");			
		}
	}

	protected boolean isNeedJson(String accept) {

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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private transient Logger log = Logger.getLogger(InvokeServlet.class.getName());

	protected InvokeHelper helper;
	protected InvokeHelper getInvokeHelper() throws UnknownHostException {
		if(helper==null){
			helper = new InvokeHelper();
		}
		return helper;

	}
	
	protected Object getTarget(HttpServletRequest request, HttpServletResponse response)
	{
		if(target==null){
			target = new ServiceBeanTest();
		}
		return target;
		
	}

	/*
	 * suddy100 suddy106
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.
	 * HttpServletRequest , javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Object test = new PrivilegeService();
		Object test = getTarget(request,response);

		BaseInvokeResult result = getInvokeHelper().getResult(test, request, response);

		String accept = request.getHeader("Accept");

		if (isNeedJson(accept)) {
			renderJson(result, request, response);
			return;
		}

		renderHTMLPage(result, request, response);

	}

	protected void renderJson(BaseInvokeResult result, HttpServletRequest request, HttpServletResponse response)
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

	protected void renderHTMLPage(BaseInvokeResult result, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; encoding=UTF-8");
		response.addHeader("Cache-Control", "no-cache, must-revalidate");
		request.setAttribute("result", result.getActualResult());
		this.dispatchView(request, response, result);

	}

	protected void dispatchView(HttpServletRequest request, HttpServletResponse response, BaseInvokeResult result)
			throws ServletException, IOException {
		RequestDispatcher view = getRenderView(request, result);
		view.include(request, response);

	}

	protected void logInfo(String message) {
		//log.log(Level.INFO, message);

	}

	protected RequestDispatcher getRenderView(HttpServletRequest request, BaseInvokeResult result)
			throws MalformedURLException {
		if (!result.isGenericResult()) {
			return getSimpleRenderView(request, result.getActualResult());
		}

		return request.getRequestDispatcher("/" + result.getRenderKey() + ".jsp");

	}
	
	private Map<Class,String>viewCache=new Hashtable();
	
	protected RequestDispatcher getSimpleRenderView(HttpServletRequest request, Object object)
			throws MalformedURLException {

		
		
		Class temp = object.getClass();
		String cachedPage=viewCache.get(temp);
		if(cachedPage!=null){
			return request.getRequestDispatcher(cachedPage);
		}
		
		
		while (temp != null) {
			String jsp = "/" + temp.getName() + ".jsp";
			logInfo("trying to find: " + jsp);
			URL url = getServletContext().getResource(jsp);
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
