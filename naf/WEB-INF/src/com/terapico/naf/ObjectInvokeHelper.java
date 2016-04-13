package com.terapico.naf;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ObjectInvokeHelper extends InvokeHelper {

	public ObjectInvokeHelper() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected Object getObject(String objectPath) {
		
		
		return new InternalTestBean();
	}

	public BaseInvokeResult getResult(HttpServletRequest request, HttpServletResponse response)  {

		logln(request.getRequestURI());

		try {
			ObjectFriendlyURI furi=(ObjectFriendlyURI)parseParameters(request.getRequestURI());
			furi = (ObjectFriendlyURI) new ObjectFriendlyURI().parse(request.getRequestURI(), 2);
			Object objectToCall = this.getObject(furi.getBeanName());
			if (objectToCall == null) {
				throw new IllegalStateException("trying to get bean with name:'" + furi.getBeanName() + "' failed!");
			}
			return super.getResult(objectToCall, request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return  InvokeResult.createInstance(e.getCause(),null,null);
		}

	}
	protected FriendlyURI parseParameters(String uri) throws UnsupportedEncodingException
	{
		return new ObjectFriendlyURI().parse(uri, 2);
		
	}

}
