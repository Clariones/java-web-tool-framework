
package com.terapico.b2b.action;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import com.terapico.b2b.order.Order;

import com.terapico.b2b.order.OrderDAO;




public class ActionManagerImpl implements ActionManager {

	private  ActionDAO  actionDAO;
 	public void setActionDAO(ActionDAO  actionDAO){
 	
 		if(actionDAO == null){
 			throw new IllegalStateException("Do not try to set actionDAO to null.");
 		}
	 	this.actionDAO = actionDAO;
 	}
 	public ActionDAO getActionDAO(){
 		if(this.actionDAO == null){
 			throw new IllegalStateException("The ActionDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.actionDAO;
 	}
 	
 	public Action saveAction(Action action, Map<String,Object>options) throws Exception{	
 		return getActionDAO().save(action, options);
 	}
 	public Action loadAction(String actionId, Map<String,Object>options) throws Exception{	
 		return getActionDAO().load(actionId, options);
 	}
 	 
 	
 	private  OrderDAO  orderDAO;
 	public void setOrderDAO(OrderDAO orderDAO){
	 	this.orderDAO = orderDAO;
 	}
 	public OrderDAO getOrderDAO(){
	 	return this.orderDAO;
 	}

 	
 	
	public Action createAction(String name, String internalName, String boId, String[] optionsExpr) throws Exception
	{
		
		
		Action action=createNewAction(optionsExpr);	

		action.setName(name);
		action.setInternalName(internalName);
		Order bo = loadBo(boId,emptyOptions());
		action.setBo(bo);
		//save for later setOrderValues(action);
		Map<String, Object> options = new HashMap<String, Object>();
		
		//return actionDAO.save(action, options);
		return saveAction(action, options);
		

		
	}
	protected Action createNewAction(String[] optionsExpr) throws Exception
	{
		
		return new Action();
		
	}
	public Action updateAction(String actionId, String property, Object newValue) throws Exception 
	{
		return new Action();
	}
	protected Map<String,Object> emptyOptions(){
		return new HashMap<String,Object>();
	}
	
	protected ActionTokens tokens(){
		return ActionTokens.start();
	}
	protected Map<String,Object> allTokens(){
		return ActionTokens.all();
	}
	
	public Action transferToNewBo(String actionId, String newBoId) throws Exception
 	{
 		Action action = loadAction(actionId, allTokens());	
		Order bo = loadBo(newBoId, emptyOptions());		
		action.setBo(bo);		
		return saveAction(action, emptyOptions());
 	}
 	
 	protected Order loadBo(String newBoId, Map<String,Object> options) throws Exception
 	{
 		return getOrderDAO().load(newBoId, options);
 	}
 	
 

	public void delete(String actionId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}


}






