package com.terapico.caf;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanFactory extends InternalBeanFactory implements BeanFactory{
	

	
	ClassPathXmlApplicationContext context; 
	public SpringBeanFactory(){
		context = new ClassPathXmlApplicationContext("classpath*:/META-INF/spring.xml");
		
	}
	private String []beanNamesCache;
	public String[] getBeanNames() {
		
		if(beanNamesCache==null){
			beanNamesCache=context.getBeanDefinitionNames();
		}
		
		return beanNamesCache;
	}
	
	
	public Object getBean(String beanName)
	{
		Object internalObject=getInternalBean(beanName);
		if(internalObject!=null){
			return internalObject;
		}
		
		return getObject(beanName);
	}
	
	
	protected Object getObject(String objectPath) {
		return context.getBean(objectPath);
	}
}
