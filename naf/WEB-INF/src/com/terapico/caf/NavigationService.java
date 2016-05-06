package com.terapico.caf;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.TypedStringValue;

import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.terapico.caf.baseelement.MenuItem;
import com.terapico.caf.baseelement.PlainText;

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
	
	public NavigationService()
	{
		
		
	}
	protected BeanFactory getBeanFactory() {
		if (beanFactory == null) {
			beanFactory = InternalBeanFactory.getDefaultBeanFactory();
		}
		return beanFactory;
	}

	private Map<String, List<MenuItem>> definitionCache ;

	protected void init() {
		
		if(definitionCache!=null){
			return;
		}
		
		definitionCache = new ConcurrentHashMap<String, List<MenuItem>>();
		
		SpringBeanFactory springBeanFactory = (SpringBeanFactory) getBeanFactory();
		ConfigurableListableBeanFactory internalFactory = springBeanFactory.springFactory();
		String[] beanNames = getBeanFactory().getBeanNames();
		for (String beanName : beanNames) {

			try {
				definitionCache.put(beanName, createItemsForClass(beanName, internalFactory));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				this.logInfo("Bean: "+beanName+" fail to load the class "+e.getMessage());
			}
		}

	}

	private void logInfo(String string) {
		// TODO Auto-generated method stub
		System.out.println(this.getClass().getName()+" "+string);
	}

	protected MenuItem createItem(String beanName, String methodName) {
		MenuItem item = createEmtryItem();
		item.setBeanName(beanName);
		item.setLink(methodName);
		return item;

	}

	protected MenuItem createEmtryItem() {
		MenuItem item = new MenuItem();
		return item;

	}

	protected List<MenuItem> createItemsForClass(String beanName, ConfigurableListableBeanFactory internalFactory) throws ClassNotFoundException {
		// TODO Auto-generated method stub

		BeanDefinition beanDefinition = internalFactory.getBeanDefinition(beanName);

		Class<?> clazz = Class.forName(beanDefinition.getBeanClassName());

		List<Method> safeMethods = this.getSafeMethodsFromClass(clazz);
		List<MenuItem> itemList = new ArrayList<MenuItem>();

		for (Method method : safeMethods) {
			MenuItem item = createItem(beanName, method.getName());
			itemList.add(item);
		}

		return itemList;

	}

	
	public PlainText desc(){
		init();
		String[] beanNames = getBeanFactory().getBeanNames();
		SpringBeanFactory springBeanFactory = (SpringBeanFactory) getBeanFactory();
		ConfigurableListableBeanFactory internalFactory = springBeanFactory.springFactory();
		PlainText result=new PlainText();
		for (String beanName : beanNames) {
			
			result.append(beanName+"\r\n--------------------------------------------------\r\n");
			try {
				definitionCache.put(beanName, createItemsForClass(beanName, internalFactory));
				
				BeanDefinition beanDefinition = internalFactory.getBeanDefinition(beanName);
				
				MutablePropertyValues values = beanDefinition.getPropertyValues();
				
				PropertyValue[] valueArray= values.getPropertyValues();
				
				for(PropertyValue value: valueArray ){
					result.append(value.getName());
					result.append("=");
					result.append(toStringExpr(value));
					result.append("\r\n");
				}
				
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				this.logInfo("Bean: "+beanName+" fail to load the class "+e.getMessage());
			}
			result.append("\r\n\r\n");
		}
		return result;
	}
	protected String toStringExpr(PropertyValue value) {
		Object valueObject=value.getValue();
		if(valueObject instanceof TypedStringValue){
			TypedStringValue tsv=(TypedStringValue)valueObject;
			return tsv.getValue();
		}
		return value.getValue().toString();
	}
	
	public Navigator index(String selectedBean) {
		init();
		
		Navigator navigator = createNavigator();
		String[] beanNames = getBeanFactory().getBeanNames();

		navigator.addToBeanList(beanNames);
		navigator.setSelectBean(selectedBean);

		List<MenuItem> items=getMenuItemForBean(selectedBean);
		
		navigator.setMenuItems(items);
		
		
		//navigator.setBeanExpr(beanExpr);
		// for(String beanName:beanNames){
		//createItems(navigator, selectedBean);
		// }
		
		return navigator;

	}

	public Navigator select(String selectedBean) {
		init();
		
		Navigator navigator = createNavigator();
		String[] beanNames = getBeanFactory().getBeanNames();

		navigator.addToBeanList(beanNames);
		navigator.setSelectBean(selectedBean);

		List<MenuItem> items=getMenuItemForBean(selectedBean);
		
		navigator.setMenuItems(items);
		
		
		//navigator.setBeanExpr(beanExpr);
		// for(String beanName:beanNames){
		//createItems(navigator, selectedBean);
		// }
		
		return navigator;

	}

	protected List<MenuItem> getMenuItemForBean(String selectedBean) {
		// TODO Auto-generated method stub
		
		List<MenuItem> items=definitionCache.get(selectedBean);
		
		if(items==null){
			return new ArrayList<MenuItem>();
		}

		return items;
	}
	protected String getObjectExpr(Object target) {

		try {
			Gson serializer = new GsonBuilder().setPrettyPrinting().create();
			return "class: '" + target.getClass().getName() + "'\r\n" + serializer.toJson(target);
		} catch (Throwable e) {
			return e.getMessage();
		}
	}

	

	protected Navigator createNavigator() {
		return new Navigator();

	}



}
