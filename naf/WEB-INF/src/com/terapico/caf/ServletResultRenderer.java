package com.terapico.caf;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
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
@SuppressWarnings("rawtypes")
public class ServletResultRenderer {

	public void render(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response,
			InvocationResult result) throws ServletException, IOException {
		if (isRequestForJson(request)) {
			renderJson(result, request, response);
			return;
		}

		renderHTMLPage(servlet, result, request, response);
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

	protected void renderHTMLPage(HttpServlet servlet, InvocationResult result, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; encoding=UTF-8");
		response.addHeader("Cache-Control", "no-cache, must-revalidate");
		request.setAttribute("result", result.getActualResult());
		request.setAttribute("rootResult", result);
		
		this.dispatchView(servlet, request, response, result);

	}

	protected String joinParametersTypes(Type[] types, char connectChar) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < types.length; i++) {
			if (i > 0) {
				stringBuilder.append(connectChar);
			}

			Class clazz = (Class) types[i];
			stringBuilder.append(clazz.getSimpleName());
		}
		return stringBuilder.toString();
	}
	protected void handleArgumentExcepttion(String message)
	{
		throw new IllegalArgumentException(message);
	}
	protected String getRenderKey(InvocationResult result) {

		if(result==null){
			handleArgumentExcepttion("getRenderKey(InvocationResult result)： result should not be null.");
		}
		final InvocationContext context=result.getInvocationContext();
		if(context==null){
			handleArgumentExcepttion("getRenderKey(InvocationResult result)： result.getInvocationContext() should not be null.");			
		}
		Method method = context.getMethodToCall();
		
		if(method==null){
			handleArgumentExcepttion("getRenderKey(InvocationResult result)： result.getInvocationContext().getMethodToCall() should not be null.");			
		}
		
		if (!isGenericReturnType(method)) {
			handleArgumentExcepttion("Should not call  getRenderKey() when return type is not a parameterized type.");
		}

		Type type = method.getGenericReturnType();
		
		ParameterizedType parameterReutrnType = (ParameterizedType) type;
		Type[] types = parameterReutrnType.getActualTypeArguments();
		String parameterTypeExpr = joinParametersTypes(types, '_');
		String returnTypeExpr = method.getReturnType().getSimpleName();
		return parameterTypeExpr + "$" + returnTypeExpr;

		// System.out.println(method.getReturnType());

	}

	protected boolean isGenericResult(InvocationResult result) {
		if(result==null){
			return false;
		}
		if(result.getInvocationContext()==null){
			return false;
		}
		Method method = result.getInvocationContext().getMethodToCall();
		return isGenericReturnType(method);
	}
	
	protected boolean isGenericReturnType(Method method) {

		Type type = method.getGenericReturnType();
		if (type instanceof ParameterizedType) {
			return true;
		}

		return false;
	}
	

	protected void dispatchView(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response,
			InvocationResult result) throws ServletException, IOException {
		RequestDispatcher view = getRenderView(servlet, request, result);
		view.include(request, response);

	}

	protected void logInfo(String message) {
		// log.log(Level.INFO, message);
		// System.out.println("Render:" + message);
	}

	protected RequestDispatcher getRenderView(HttpServlet servlet, HttpServletRequest request, InvocationResult result)
			throws MalformedURLException {
		if(isGenericResult(result)){
			return request.getRequestDispatcher("/" + getRenderKey(result) + ".jsp");
		}
		return getSimpleRenderView(servlet, request, result.getActualResult());


	}

	private Map<Class, String> viewCache = new ConcurrentHashMap<Class, String>();

	protected RequestDispatcher getSimpleRenderView(HttpServlet servlet, HttpServletRequest request, Object object)
			throws MalformedURLException {

		Class temp = object.getClass();
		String cachedPage = viewCache.get(temp);
		if (cachedPage != null) {
			logInfo("found cache for " + cachedPage);
			return request.getRequestDispatcher(cachedPage);
		}
		//这个代码是根据类信息找到一个合适的渲染视图，如果找不到相应的视图，
		//就从尝试从父类中找到一个视图
		//通过一个循环实现了递归调用，节约了栈空间
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
