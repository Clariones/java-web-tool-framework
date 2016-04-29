package com.terapico.caf;

import java.lang.reflect.Method;
import java.util.List;

import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

class PropertiesExclusionStrategy implements com.google.gson.ExclusionStrategy {

	public boolean shouldSkipField(FieldAttributes fa) {

		return false;
	}

	public boolean shouldSkipClass(Class<?> clazz) {

		return false;
	}

}

public class NavigationService extends ReflectionTool {
	BeanFactory beanFactory;

	protected BeanFactory getBeanFactory() {
		if (beanFactory == null) {
			beanFactory = InternalBeanFactory.getDefaultBeanFactory();
		}
		return beanFactory;
	}

	public Navigator index(String selectedBean) {

		Navigator navigator = createNavigator();
		String[] beanNames = getBeanFactory().getBeanNames();

		navigator.addToBeanList(beanNames);
		navigator.setSelectBean(selectedBean);

		// for(String beanName:beanNames){
		createItems(navigator, selectedBean);
		// }

		return navigator;

	}

	protected String getObjectExpr(Object target) {
		try {
			Gson serializer = new GsonBuilder().setPrettyPrinting().create();
			return "class: '" + target.getClass().getName() + "'\r\n" + serializer.toJson(target);
		} catch (Throwable e) {
			return e.getMessage();
		}
	}

	protected void createItems(Navigator navigator, String beanName) {

		Object targetObject = getBeanFactory().getBean(beanName);

		navigator.setBeanExpr(this.getObjectExpr(targetObject));

		List<Method> safeMethods = this.getSafeMethods(targetObject);

		for (Method method : safeMethods) {
			navigator.addItem(beanName, method.getName());
		}

	}

	protected Navigator createNavigator() {
		return new Navigator();

	}

	/*
	 * protected boolean isPrimaryType(Class clazz) {
	 * 
	 * if (clazz.isPrimitive()) { return true; } if (clazz == String.class) {
	 * return true; } if (clazz == Number.class) { return true; } if (clazz ==
	 * Byte.class) { return true; } // java.lang.Byte (implements
	 * java.lang.Comparable<T>) // java.lang.Double (implements
	 * java.lang.Comparable<T>) // java.lang.Float (implements
	 * java.lang.Comparable<T>) // java.lang.Integer (implements
	 * java.lang.Comparable<T>) // java.lang.Long (implements
	 * java.lang.Comparable<T>) // java.lang.Short (implements
	 * java.lang.Comparable<T>) if (clazz == Double.class) { return true; } if
	 * (clazz == Float.class) { return true; } if (clazz == Integer.class) {
	 * return true; } if (clazz == Long.class) { return true; } if (clazz ==
	 * Short.class) { return true; } if (clazz == Boolean.class) { return true;
	 * } if (clazz == java.util.Date.class) { return true; } if (clazz ==
	 * java.sql.Date.class) { return true; } if (clazz == DateTime.class) {
	 * return true; } return false;
	 * 
	 * }
	 * 
	 * 
	 * protected void peekObject(StringBuilder buffer, Object object) throws
	 * IllegalArgumentException, InvocationTargetException { if (object == null)
	 * { return; }
	 * 
	 * Class clazz = object.getClass(); Method[] methods = clazz.getMethods();
	 * for (Method method : methods) {
	 * 
	 * if (!isPrimaryType(method.getReturnType())) { continue; } if
	 * (method.getGenericParameterTypes().length != 0) { continue; } if
	 * (method.getName().startsWith("get")) { invokeAndPrint(buffer,object,
	 * method); } if (method.getName().startsWith("is")) {
	 * invokeAndPrint(buffer,object, method); } if
	 * (method.getName().startsWith("has")) { invokeAndPrint(buffer,object,
	 * method); } }
	 * 
	 * } protected void invokeAndPrint(StringBuilder buffer,Object object,
	 * Method method) throws IllegalArgumentException, InvocationTargetException
	 * {
	 * 
	 * Object ret; try { ret = method.invoke(object, new Class[] {});
	 * buffer.append(method.getName() + "=" + ret); } catch
	 * (IllegalAccessException e) { buffer.append(method.getName() +
	 * "=@error@"); } buffer.append("\r\n"); }
	 */

}
