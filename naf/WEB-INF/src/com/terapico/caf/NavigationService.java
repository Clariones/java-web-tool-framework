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

	public String getObjectExpr(Object target) {
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



}
