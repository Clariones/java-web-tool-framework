package com.terapico.naf;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.terapico.naf.baseelement.Action;
import com.terapico.naf.baseelement.Field;
import com.terapico.naf.baseelement.Form;
import com.terapico.naf.baseelement.MethodIndex;
public class InvokeHelper {
	
	
	
	public  InvokeHelper() 
	{
		
		
	}
	
	protected  static MethodIndex getIndex(Class clazz){
		
		Method[] methods =MethodIndex.getAllInternalMethods(clazz);		
		MethodIndex index=new MethodIndex();
		index.getList(methods);		
		return index;	
		
	}

	
	public static SimpleMethod[] getAllAccessiableMethods(Class clazz)
	{
		
		MethodIndex index=new MethodIndex();	
		int length=index.getList(clazz).size();
		return index.getList(clazz).toArray((SimpleMethod[])Array.newInstance(SimpleMethod.class,length));
		
	}
	
	protected FriendlyURI parseParameters(String uri) throws UnsupportedEncodingException
	{
		return new FriendlyURI().parse(uri, 2);
		
	}
	public BaseInvokeResult getResult(Object test, HttpServletRequest request, HttpServletResponse response) {

		
		try {
			FriendlyURI furi = parseParameters(request.getRequestURI());	
			logln(request.getRequestURI());
			if (furi.getServiceName().equals("index")) {
				return InvokeResult.createInstance(getIndex(test.getClass()),null,null);
			}
			
			Method method=findMethod(test,furi.getServiceName());
			if(method==null){				
				return InvokeResult.createInstance(
						new Exception(test.getClass().getName()+"."+furi.getServiceName()+"(): 该方法没有实现!"),null,null);
			}
			Type[] methodParameterTypes=method.getGenericParameterTypes();
			List<String> nameList=ExpressionBeanTool.getParameterNames(method);
			if(method.getGenericParameterTypes().length>furi.getParameterLength()){								
				return buildForm(method, methodParameterTypes, nameList);
			}
			Object []parameters=ExpressionBeanTool.getParameters(method.getGenericParameterTypes(), furi.getParameter());
			
			Object actualResult=method.invoke(test, parameters);
			
			this.saveParameters(methodParameterTypes, nameList, parameters);
			
			return  InvokeResult.createInstance(actualResult,method,parameters);

		} catch (InvocationTargetException exception) {
			return  InvokeResult.createInstance(exception.getCause(),null,null);
		}catch (Throwable throwable) {
			return  InvokeResult.createInstance(throwable,null,null);
		}

	
	}

	protected BaseInvokeResult buildForm(Method method, Type[] methodParameterTypes, List<String> nameList) {
		Form form=new Form();	
		
		for(int i=0;i<methodParameterTypes.length;i++){
			Field field=new Field();
			String name=nameList.get(i);
			field.setLabel(name);
			field.setName(name);
			field.setType(methodParameterTypes[i]);
			form.addField(field);
		}

		form.addAction(new Action(method.getName()));
		return InvokeResult.createInstance(form,null,null);
	}
	protected void saveParameters(Type[] methodParameterTypes,List<String> nameList,Object []parameters)
	{
		//logln("do noting to save parameters");		
	}
	protected Method findMethod(Object object, String serviceName) {
		// TODO Auto-generated method stub
		return MethodIndex.findMethod(object, serviceName);
	}

	protected void logln(String requestURI) {
		// TODO Auto-generated method stub
		//System.out.println(this.getClass().getName()+":"+requestURI);
	}
	
	
}
