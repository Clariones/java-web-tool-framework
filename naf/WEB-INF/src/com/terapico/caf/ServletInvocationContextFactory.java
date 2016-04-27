package com.terapico.caf;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.terapico.naf.DateTime;
@SuppressWarnings("rawtypes")
public class ServletInvocationContextFactory  implements InvocationContextFactory {
	private int start = 2;
	private String formBuilderBeanName="formbuilder";
	private String formBuilderMethodName="buildForm";
	
	private BeanFactory beanFactory=null;
	
	
	public BeanFactory getBeaFactory() {
		
		if(beanFactory==null){
			beanFactory=new SpringBeanFactory();
		}
		return beanFactory;
	}
	public void setBeaFactory(BeanFactory beaFactory) {
		this.beanFactory = beaFactory;
	}
	public InvocationContext create(Object input) throws InvocationException {
		// TODO Auto-generated method stub

		if (input == null) {
			throw new IllegalArgumentException("Could not create the call, the input parameter is null");
		}

		if (!(input instanceof HttpServletRequest)) {
			throw new IllegalArgumentException("Could not create the call context since the type is: "
					+ input.getClass().getName() + ", Expected class: HttpServletRequest");
		}

		HttpServletRequest request = (HttpServletRequest) input;

		List<String> urlElements = parse(request.getRequestURI());

		if (urlElements.size() < start + 1) {
			throw new InvocationException("No sufficient parameter to call");
		}

		Object targetObject = getBean(request, urlElements);

		if (targetObject == null) {
			throw new InvocationException("Not able to find the target object to call: "+request.getRequestURI());
		}

		Method targetMethod = this.getMethod(request, targetObject, urlElements);

		if (targetMethod == null) {
			throw new InvocationException("Not able to find the target method to call： " +request.getRequestURI());
		}
		
		if(!hasSuffientParameters(urlElements,targetMethod)){
			return buildFormContext(targetMethod);
		}
	
		Object[] parameters = this.getParameters(request, targetObject, urlElements, targetMethod);

		SimpleInvocationContext context = new SimpleInvocationContext();
		context.setTargetObject(targetObject);
		context.setTargetMethod(targetMethod);
		context.setParameters(parameters);
		return context;

	}
	protected InvocationContext buildFormContext(Method targetMethod) throws InvocationException {
		// TODO Auto-generated method stub
		
		SimpleInvocationContext context = new SimpleInvocationContext();
		Object formBuilder =getBean(formBuilderBeanName);
		if(formBuilder==null){
			throw new InvocationException("Form Builder can not be found with the name: "+ formBuilderBeanName);
		}
		context.setTargetObject(formBuilder);
		Method method=findSingleMethod(formBuilder,formBuilderMethodName);
		if(method==null){
			throw new InvocationException("Form Builder method can not be found with the name: "+ formBuilderBeanName+"."+formBuilderMethodName);
		}
		context.setTargetMethod(method);
		context.setParameters(new Object[]{targetMethod});
		return context;
	}
	protected boolean hasSuffientParameters(List<String> urlElements,Method targetMethod)
	{
		int size=urlElements.size();
		Type [] parameterTypes=targetMethod.getGenericParameterTypes();
		
		return (size-start-2)==parameterTypes.length;
		
	}
	

	protected Object getBean(HttpServletRequest request, List<String> urlElements) {

		String beanName = urlElements.get(start);
		return getBean(beanName);
	}

	protected Object getBean(String beanName) {
		return this.getBeaFactory().getBean(beanName);
	}
	
	protected Object[] getParameters(HttpServletRequest request, Object targetObject, List<String> urlElements,
			Method method) {

		Type []parameterTypes=method.getGenericParameterTypes();
		if(parameterTypes.length==0){
			return new Object[]{};
		}
		// Object [] parameters=new String[urlElements.size()-start-2];
		Object elements[] = urlElements.toArray();
		Object[] parameters = Arrays.copyOfRange(elements, start+2, urlElements.size());
		
		if(parameterTypes.length != parameters.length){
			throw new IllegalArgumentException("The parameter length expect be:"+parameterTypes.length+" but the actual length is:"+parameters.length);
		}
		
		return getParameters(parameterTypes, parameters);

	}

	protected Object[] getParameters(Type[] types, Object[] parameters) {

		int length = parameters.length;
		if (length == 0) {
			return new Object[] {};
		}
		Object[] ret = new Object[length];

		for (int i = 0; i < length; i++) {
			ret[i] = converExprToObject(types[i], parameters[i]);
			// System.out.println(ret[i].getClass() + "" + ret[i]);
		}
		return ret;
	}

	protected boolean isArrayType(Type type) {
		
		Class typeClazz = (Class) type;
		if (typeClazz.isArray()) {
			return true;
		}
		return false;
	}

	protected boolean isArrayOfPrimaryType(Type type) {
		Class typeClazz = (Class) type;
		if (!typeClazz.isArray()) {
			return false;
		}
		Class clazz = typeClazz.getComponentType();
		if (isPrimaryType(clazz)) {
			return true;
		}
		return false;
	}

	protected Constructor getOneStringConstructor(Class clazz) {
		Constructor constructors[] = clazz.getDeclaredConstructors();

		for (int i = 0; i < constructors.length; i++) {
			Constructor constructor = constructors[i];
			Type[] types = constructor.getGenericParameterTypes();
			if (types.length != 1) {
				continue;
			}
			if (types[0] == java.lang.String.class) {
				return constructor;
			}
		}

		return null;

	}

	protected boolean isPrimaryType(Class clazz) {

		if (clazz.isPrimitive()) {
			return true;
		}
		if (clazz == String.class) {
			return true;
		}
		if (clazz == Number.class) {
			return true;
		}
		if (clazz == Byte.class) {
			return true;
		}
		// java.lang.Byte (implements java.lang.Comparable<T>)
		// java.lang.Double (implements java.lang.Comparable<T>)
		// java.lang.Float (implements java.lang.Comparable<T>)
		// java.lang.Integer (implements java.lang.Comparable<T>)
		// java.lang.Long (implements java.lang.Comparable<T>)
		// java.lang.Short (implements java.lang.Comparable<T>)
		if (clazz == Double.class) {
			return true;
		}
		if (clazz == Float.class) {
			return true;
		}
		if (clazz == Integer.class) {
			return true;
		}
		if (clazz == Long.class) {
			return true;
		}
		if (clazz == Short.class) {
			return true;
		}
		if (clazz == Boolean.class) {
			return true;
		}
		if (clazz == java.util.Date.class) {
			return true;
		}
		if (clazz == java.sql.Date.class) {
			return true;
		}
		if (clazz == DateTime.class) {
			return true;
		}
		return false;

	}

	@SuppressWarnings("unchecked")
	protected Object converExprToObject(Type type, Object parameter) {

		if (type == String.class) {
			return parameter;
		}
		if (!(parameter instanceof String)) {
			return parameter;
			// this allow external service to initiate the object directly like
			// File in the context of Web Container

		}
		String stringParameter = parameter.toString();
		if (type == int.class || type == Integer.class) {
			return Integer.parseInt(stringParameter);
		}
		if (type == long.class || type == Long.class) {
			return Long.parseLong(stringParameter);
		}
		if (type == float.class || type == Float.class) {
			return Float.parseFloat(stringParameter);
		}
		if (type == double.class || type == Double.class) {
			return Double.parseDouble(stringParameter);
		}

		if (type == byte.class || type == Byte.class) {
			return Byte.parseByte(stringParameter);
		}

		// if the class has a default constructor and the only parameter is
		// String like URL
		Constructor constructor = getOneStringConstructor((Class) type);
		if (constructor != null) {
			try {
				return constructor.newInstance(new Object[] { stringParameter });
			} catch (Exception exception) {

			}
		}

		if (DateTime.class.isAssignableFrom((Class) type)) {
			String defaultFormat = System.getProperty("system.types.datetime.format");
			if (defaultFormat == null) {
				defaultFormat = "yyyy-MM-DD HH:mm:ss";
			}
			DateFormat formatter = new SimpleDateFormat(defaultFormat);
			try {
				DateTime dateTime = new DateTime();
				java.util.Date date = formatter.parse(stringParameter);
				dateTime.setTime(date.getTime());
				return dateTime;
			} catch (ParseException e) {
				return null;
			}
		}
		if (java.util.Date.class.isAssignableFrom((Class) type)) {
			String defaultFormat = System.getProperty("system.types.date.format");
			if (defaultFormat == null) {
				defaultFormat = "yyyy-MM-DD";
			}
			DateFormat formatter = new SimpleDateFormat(defaultFormat);
			try {
				return formatter.parse(stringParameter);
			} catch (ParseException e) {
				return null;
			}
		}

		if (!isArrayType(type)) {
			// other component type
			// parse it as json
			Gson gson = new Gson();
			return gson.fromJson(stringParameter, (Class) type);
		}

		if (isArrayOfPrimaryType(type)) {
			String subParameters[] = stringParameter.split(";");
			int length = subParameters.length;
			Class typeClazz = (Class) type;
			Class componentClazz = typeClazz.getComponentType();
			Object object = Array.newInstance(componentClazz, length);
			for (int index = 0; index < length; index++) {
				Array.set(object, index, converExprToObject(typeClazz.getComponentType(), subParameters[index]));
			}
			return object;
		}
		// any other should presents as json string, include objects, list of
		// objects.
		// List<Video> videos = gson.fromJson(json, new
		// TypeToken<List<Video>>(){}.getType());
		Gson gson = new Gson();
		return gson.fromJson(stringParameter, (Class) type);
	}

	protected Method getMethod(HttpServletRequest request, Object targetObject, List<String> urlElements)
			throws InvocationException {

		String methodName = urlElements.get(start + 1);

		return findSingleMethod(targetObject,methodName);

	}
	
	protected Method findSingleMethod( Object targetObject, String methodName)
			throws InvocationException {

		

		if (isIgnoreMethod(methodName)) {
			throw new InvocationException("The method '" + methodName + "' is not allowed to be called");
		}
		Class clazz = targetObject.getClass();
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				return method;
			}
			// parameter count here is not compared, assume different
		}
		throw new InvocationException("The method '" + methodName + "' is not found in class: " + clazz.getName());

	}
	

	final static String[] IGNORE_METHOS = { "equals", "getClass", "hashCode", "notify", "notifyAll", "toString",
			"wait" };

	protected static boolean isIgnoreMethod(String methodName) {

		int index = Arrays.binarySearch(IGNORE_METHOS, methodName);
		if (index < 0) {
			return false;
		}
		return true;

	}

	protected List<String> parse(String requestURI) throws InvocationException  {

		List<String> parameters = new ArrayList<String>(10);

		String array[] = requestURI.split("/");
		for (int i = 0; i < array.length; i++) {
			
			try {
				String val = URLDecoder.decode(array[i], "UTF-8").trim();
				parameters.add(val);
			} catch (UnsupportedEncodingException e) {
				throw new InvocationException("Encoding UTF-8 is not supported");
			}
			
		}
		// System.out.println(URLDecoder.decode(schema[2],"UTF-8"));
		return parameters;

	}

}
