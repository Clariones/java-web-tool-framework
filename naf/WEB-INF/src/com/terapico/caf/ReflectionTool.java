package com.terapico.caf;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.terapico.naf.DateTime;

@SuppressWarnings("rawtypes")
public class ReflectionTool {
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
	
	protected List<Method> getSafeMethods( Object targetObject) {

		
		List<Method> methodList=new ArrayList<Method>();
		
		Class clazz = targetObject.getClass();
		Method[] methods = clazz.getMethods();
		
		for (Method method : methods) {

			if (isIgnoreMethod(method.getName())) {
				continue;
			}
			if (methodList.contains(method)) {
				continue;
			}
			methodList.add(method);
		}
		return methodList;

	}
	protected Method[] getInternalList(Class clazz) {

		Method[] methods = clazz.getMethods();

		return methods;
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
	
	
	
}
