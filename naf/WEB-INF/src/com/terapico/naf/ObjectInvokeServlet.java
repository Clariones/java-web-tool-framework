package com.terapico.naf;

import java.io.IOException;
import java.net.UnknownHostException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.ServiceBeanTest;

public class ObjectInvokeServlet extends InvokeServlet {
	protected InvokeHelper getInvokeHelper() throws UnknownHostException {
		if(helper==null){
			helper = new ObjectInvokeHelper();
		}
		return helper;

	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Object test = new PrivilegeService();
		Object test = new ServiceBeanTest();

		BaseInvokeResult result = getInvokeHelper().getResult(test, request, response);

		String accept = request.getHeader("Accept");

		if (isNeedJson(accept)) {
			renderJson(result, request, response);
			return;
		}

		renderHTMLPage(result, request, response);

	}
}
