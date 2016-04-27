package com.terapico.caf;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanFactory implements BeanFactory{
	AbstractApplicationContext context; 
	public SpringBeanFactory(){
		context = new ClassPathXmlApplicationContext("classpath*:/META-INF/spring.xml");		
	}

	
	public String[] getBeanNames() {
		// TODO Auto-generated method stub
		
		
		
		return context.getBeanDefinitionNames();
	}
	private static Map<String, Object> internalObjectMap = new ConcurrentHashMap<String, Object>();

	static {
		internalObjectMap.put("internaltest", new InternalTestBean());
		internalObjectMap.put("formbuilder", new FormBuilder());
	}
	public Object getBean(String beanName)
	{
		Object internalObject=internalObjectMap.get(beanName);
		if(internalObject!=null){
			return internalObject;
		}
		
		return getObject(beanName);
		
	}
	protected Object getObject(String objectPath) {
		return context.getBean(objectPath);
	}
}
