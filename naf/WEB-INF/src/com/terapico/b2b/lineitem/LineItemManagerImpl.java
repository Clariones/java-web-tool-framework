
package com.terapico.b2b.lineitem;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import com.terapico.b2b.order.Order;

import com.terapico.b2b.order.OrderDAO;




public class LineItemManagerImpl implements LineItemManager {

	private  LineItemDAO  lineItemDAO;
 	public void setLineItemDAO(LineItemDAO  lineItemDAO){
 	
 		if(lineItemDAO == null){
 			throw new IllegalStateException("Do not try to set lineItemDAO to null.");
 		}
	 	this.lineItemDAO = lineItemDAO;
 	}
 	public LineItemDAO getLineItemDAO(){
 		if(this.lineItemDAO == null){
 			throw new IllegalStateException("The LineItemDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.lineItemDAO;
 	}
 	
 	public LineItem saveLineItem(LineItem lineItem, Map<String,Object>options) throws Exception{	
 		return getLineItemDAO().save(lineItem, options);
 	}
 	public LineItem loadLineItem(String lineItemId, Map<String,Object>options) throws Exception{	
 		return getLineItemDAO().load(lineItemId, options);
 	}
 	 
 	
 	private  OrderDAO  orderDAO;
 	public void setOrderDAO(OrderDAO orderDAO){
	 	this.orderDAO = orderDAO;
 	}
 	public OrderDAO getOrderDAO(){
	 	return this.orderDAO;
 	}

 	
 	
	public LineItem createLineItem(String bizOrderId, String skuId, String skuName, double amount, int quantity, boolean active, String[] optionsExpr) throws Exception
	{
		
		
		LineItem lineItem=createNewLineItem(optionsExpr);	

		Order bizOrder = loadBizOrder(bizOrderId,emptyOptions());
		lineItem.setBizOrder(bizOrder);
		lineItem.setSkuId(skuId);
		lineItem.setSkuName(skuName);
		lineItem.setAmount(amount);
		lineItem.setQuantity(quantity);
		lineItem.setActive(active);

		return saveLineItem(lineItem, emptyOptions());
		

		
	}
	protected LineItem createNewLineItem(String[] optionsExpr) throws Exception
	{
		
		return new LineItem();
		
	}
	public LineItem updateLineItem(String lineItemId, String property, Object newValue) throws Exception 
	{
		return new LineItem();
	}
	protected Map<String,Object> emptyOptions(){
		return new HashMap<String,Object>();
	}
	
	protected LineItemTokens tokens(){
		return LineItemTokens.start();
	}
	protected Map<String,Object> allTokens(){
		return LineItemTokens.all();
	}
	
	public LineItem transferToNewBizOrder(String lineItemId, String newBizOrderId) throws Exception
 	{
 
		LineItem lineItem = loadLineItem(lineItemId, allTokens());	
		synchronized(lineItem){
			//will be good when the lineItem loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			Order bizOrder = loadBizOrder(newBizOrderId, emptyOptions());		
			lineItem.setBizOrder(bizOrder);		
			return saveLineItem(lineItem, emptyOptions());
		}
 	}
 	
 	protected Order loadBizOrder(String newBizOrderId, Map<String,Object> options) throws Exception
 	{
 		return getOrderDAO().load(newBizOrderId, options);
 	}
 	
 

	public void delete(String lineItemId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}


}


