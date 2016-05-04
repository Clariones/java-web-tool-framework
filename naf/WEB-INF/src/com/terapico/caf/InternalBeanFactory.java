package com.terapico.caf;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class InternalBeanFactory implements BeanFactory {

	public static final String DEFAULT_FACTORY_BEAN_NAME="beanfactory";
	private static final String DEFAULT_INVOCATION_TOOL = "invocationtool";
	private static final String DEFAULT_INVOCATION_CONTEXT_FACTORY = "contextfactory";
	private static final String DEFAULT_SERVLET_RESULT_RENDER = "resultrender";
	
	
	
	
	private static Map<String, Object> internalObjectMap;

	

	
	private static void init()
	{
		
		if(internalObjectMap!=null){
			return;
		}
		
		
		internalObjectMap = new ConcurrentHashMap<String, Object>();
		
		
		internalObjectMap.put("internaltest", new InternalTestBean());
		internalObjectMap.put("formbuilder", new FormBuilder());
		
		//SimpleInvocationTool
		internalObjectMap.put(DEFAULT_INVOCATION_TOOL, new SimpleInvocationTool());
		internalObjectMap.put(DEFAULT_INVOCATION_CONTEXT_FACTORY, new ServletInvocationContextFactory());
		//ServletResultRenderer
		internalObjectMap.put(DEFAULT_SERVLET_RESULT_RENDER, new ServletResultRenderer());
		internalObjectMap.put(DEFAULT_FACTORY_BEAN_NAME, new SpringBeanFactory());
		
		
	}
	
	public String[] getBeanNames() {
		init();		
		Set<String> keySet=internalObjectMap.keySet();	
		return keySet.toArray(new String[keySet.size()]);
	}
	
	
	
	public Object getBean(String beanName) {
		// TODO Auto-generated method stub
		return getInternalBean(beanName);
	}
	
	protected static Object ensureInternalBean(String beanName){
		
		init();
		Object internalObject=internalObjectMap.get(beanName);
		if(internalObject!=null){
			return internalObject;
		}
		throw new IllegalStateException("Bean: '"+beanName+"' is expected as internal bean, but it can not be found in the context");
	}
	
	protected static void addInternalBean(String beanName,Object bean){
		init();
		internalObjectMap.put(beanName,bean);
	}
	
	protected static Object getInternalBean(String beanName){
		init();
		return internalObjectMap.get(beanName);
	}
	
	public static BeanFactory getDefaultBeanFactory()
	{
		return (BeanFactory)ensureInternalBean(DEFAULT_FACTORY_BEAN_NAME);
		
	}
	
	public static SimpleInvocationTool getDefaultInvocationTool()
	{
		return (SimpleInvocationTool)ensureInternalBean(DEFAULT_INVOCATION_TOOL);
		
	}
	
	public static ServletInvocationContextFactory getDefaultInvocationContextFactory()
	{
		return (ServletInvocationContextFactory)ensureInternalBean(DEFAULT_INVOCATION_CONTEXT_FACTORY);
		
	}
	//DEFAULT_SERVLET_RESULT_RENDER
	
	public static ServletResultRenderer getDefaultRenderer()
	{
		return (ServletResultRenderer)ensureInternalBean(DEFAULT_SERVLET_RESULT_RENDER);
		
	}
	

}
