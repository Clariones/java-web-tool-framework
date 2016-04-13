package com.terapico.naf.baseelement;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.terapico.naf.SimpleMethod;

public class MethodIndex {

	private List<SimpleMethod> methodList;

	public List<SimpleMethod> getList(Method[] methods) {
		if (this.methodList == null) {
			this.methodList = new ArrayList<SimpleMethod>();
		}
		for (Method method : methods) {
			SimpleMethod simpleMethpd = new SimpleMethod();

			simpleMethpd.setName(method.getName());

			if (isIgnoreMethod(method.getName())) {
				continue;
			}
			if (this.methodList.contains(method)) {
				continue;
			}
			this.methodList.add(simpleMethpd);
		}
		Collections.sort(this.methodList, new Comparator<SimpleMethod>() {
			public int compare(SimpleMethod d1, SimpleMethod d2) {
				return d1.getName().compareTo(d2.getName());
			}
		});
		return methodList;
	}

	public List<SimpleMethod> getList(Class clazz) {

		Method[] methods = clazz.getMethods();

		return getList(methods);
	}

	public Method[] getInternalList(Class clazz) {

		Method[] methods = clazz.getMethods();

		return methods;
	}

	public static Method findMethod(Object object, String name) {

		if(isIgnoreMethod(name)){
			return null;
		}
		
		Class clazz = object.getClass();
		Method[] methods = getAllInternalMethods(clazz);
		for (Method method : methods) {
			
			
			
			if (!method.getName().equalsIgnoreCase(name)) {
				continue;
			}
			return method;
		}
		return null;
	}
	public static Method[] getAllInternalMethods(Class clazz)
	{
		
		MethodIndex index=new MethodIndex();	
		//int length=index.getList(clazz).size();
		return index.getInternalList(clazz);
		
	}

	final static String[] IGNORE_METHOS = { "equals", "getClass", "hashCode", "notify", "notifyAll", "toString",
			"wait", };

	protected static boolean isIgnoreMethod(String methodName) {

		int index = Arrays.binarySearch(IGNORE_METHOS, methodName);
		if (index < 0) {
			return false;
		}
		return true;

	}

	public List<SimpleMethod> getItems() {
		return methodList;
	}

}
