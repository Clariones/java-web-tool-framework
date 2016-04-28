package com.terapico.caf;

import java.lang.reflect.Method;
import java.util.List;

import com.terapico.naf.baseelement.MenuItem;

public class NavigationService extends ReflectionTool{
	BeanFactory beanFactory;
	
	protected BeanFactory getBeanFactory(){
		if(beanFactory==null){
			beanFactory = InternalBeanFactory.getDefaultBeanFactory();
		}
		return beanFactory;
	}
	
	public Navigator index(String selectedBean){
		
		Navigator navigator=createNavigator();		
		String []beanNames=getBeanFactory().getBeanNames();
		
		navigator.addToBeanList(beanNames);
		navigator.setSelectBean(selectedBean);
		
		//for(String beanName:beanNames){
			createItems(navigator,selectedBean);			
		//}

		return navigator;
		
	}
	protected void createItems(Navigator navigator, String beanName){
		
		Object targetObject=getBeanFactory().getBean(beanName);
		
		List<Method>safeMethods=this.getSafeMethods(targetObject);
		
		for(Method method:safeMethods){
			
			navigator.addItem(beanName, method.getName());
			
		}
		
	}
	protected Navigator createNavigator()
	{
		return new Navigator();
		
	}
	
	
}
