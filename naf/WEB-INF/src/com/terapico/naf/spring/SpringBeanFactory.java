package com.terapico.naf.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.terapico.naf.beans.BeanFactory;
import com.terapico.naf.beans.BeanLocation;

public class SpringBeanFactory implements BeanFactory{
	AbstractApplicationContext context; 
	public SpringBeanFactory(){
		context = new ClassPathXmlApplicationContext("classpath*:/META-INF/spring.xml");		
	}
	public Object getBean(BeanLocation beanLocation) {
		// TODO Auto-generated method stub
		return context.getBean(beanLocation.getName());
	}

	public String[] getBeanNames() {
		// TODO Auto-generated method stub
		return context.getBeanDefinitionNames();
	}
	
}
