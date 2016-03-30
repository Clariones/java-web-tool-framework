package com.terapico.naf;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import test.MathmaticalTool;
import test.ServiceBeanTest;

public class InvokeServlet extends HttpServlet {

	InvokeHelper helper;

	@Override
	public void init() throws ServletException {
		try {
			helper = new InvokeHelper();
		} catch (UnknownHostException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
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

	/*
	 * suddy100 suddy106
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.
	 * HttpServletRequest , javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Object test = new ServiceBeanTest();
		BaseInvokeResult result = helper.getResult(test, request, response);

		String accept = request.getHeader("Accept");

		if (isNeedJson(accept)) {

			if (!(result.getActualResult() instanceof Exception)) {

				response.setCharacterEncoding("UTF-8");
				response.setContentType("applicaton/json; encoding=UTF-8");

				Gson gson = new Gson();
				// Type t=new TypeToken<weather.WeatherResponse>().getType();
				response.getWriter().println(gson.toJson(result.getActualResult()));
				return;
			}

		}

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
		log.log(Level.INFO, message);

	}

	protected RequestDispatcher getRenderView(HttpServletRequest request, BaseInvokeResult result)
			throws MalformedURLException {
		if (!result.isGenericResult()) {
			return getSimpleRenderView(request, result.getActualResult());
		}

		return request.getRequestDispatcher("/" + result.getRenderKey() + ".jsp");

	}

	protected RequestDispatcher getSimpleRenderView(HttpServletRequest request, Object object)
			throws MalformedURLException {

		Class temp = object.getClass();
		while (temp != null) {
			String jsp = "/" + temp.getName() + ".jsp";
			logInfo("trying to find: " + jsp);
			URL url = getServletContext().getResource(jsp);
			if (url != null) {
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
