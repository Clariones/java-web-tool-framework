
package com.terapico.b2b.shippinggroup;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import com.terapico.b2b.order.Order;
import com.terapico.b2b.shippingaddress.ShippingAddress;

import com.terapico.b2b.shippingaddress.ShippingAddressDAO;
import com.terapico.b2b.order.OrderDAO;




public class ShippingGroupManagerImpl implements ShippingGroupManager {

	private  ShippingGroupDAO  shippingGroupDAO;
 	public void setShippingGroupDAO(ShippingGroupDAO  shippingGroupDAO){
 	
 		if(shippingGroupDAO == null){
 			throw new IllegalStateException("Do not try to set shippingGroupDAO to null.");
 		}
	 	this.shippingGroupDAO = shippingGroupDAO;
 	}
 	public ShippingGroupDAO getShippingGroupDAO(){
 		if(this.shippingGroupDAO == null){
 			throw new IllegalStateException("The ShippingGroupDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.shippingGroupDAO;
 	}
 	
 	public ShippingGroup saveShippingGroup(ShippingGroup shippingGroup, Map<String,Object>options) throws Exception{	
 		return getShippingGroupDAO().save(shippingGroup, options);
 	}
 	public ShippingGroup loadShippingGroup(String shippingGroupId, Map<String,Object>options) throws Exception{	
 		return getShippingGroupDAO().load(shippingGroupId, options);
 	}
 	 
 	
 	private  OrderDAO  orderDAO;
 	public void setOrderDAO(OrderDAO orderDAO){
	 	this.orderDAO = orderDAO;
 	}
 	public OrderDAO getOrderDAO(){
	 	return this.orderDAO;
 	}
 
 	
 	private  ShippingAddressDAO  shippingAddressDAO;
 	public void setShippingAddressDAO(ShippingAddressDAO shippingAddressDAO){
	 	this.shippingAddressDAO = shippingAddressDAO;
 	}
 	public ShippingAddressDAO getShippingAddressDAO(){
	 	return this.shippingAddressDAO;
 	}

 	
 	
	public ShippingGroup createShippingGroup(String name, String bizOrderId, String addressId, double amount, String[] optionsExpr) throws Exception
	{
		
		
		ShippingGroup shippingGroup=createNewShippingGroup(optionsExpr);	

		shippingGroup.setName(name);
		Order bizOrder = loadBizOrder(bizOrderId,emptyOptions());
		shippingGroup.setBizOrder(bizOrder);
		ShippingAddress address = loadAddress(addressId,emptyOptions());
		shippingGroup.setAddress(address);
		shippingGroup.setAmount(amount);

		return saveShippingGroup(shippingGroup, emptyOptions());
		

		
	}
	protected ShippingGroup createNewShippingGroup(String[] optionsExpr) throws Exception
	{
		
		return new ShippingGroup();
		
	}
	public ShippingGroup updateShippingGroup(String shippingGroupId, String property, Object newValue) throws Exception 
	{
		return new ShippingGroup();
	}
	protected Map<String,Object> emptyOptions(){
		return new HashMap<String,Object>();
	}
	
	protected ShippingGroupTokens tokens(){
		return ShippingGroupTokens.start();
	}
	protected Map<String,Object> allTokens(){
		return ShippingGroupTokens.all();
	}
	
	public ShippingGroup transferToNewBizOrder(String shippingGroupId, String newBizOrderId) throws Exception
 	{
 
		ShippingGroup shippingGroup = loadShippingGroup(shippingGroupId, allTokens());	
		synchronized(shippingGroup){
			//will be good when the shippingGroup loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			Order bizOrder = loadBizOrder(newBizOrderId, emptyOptions());		
			shippingGroup.setBizOrder(bizOrder);		
			return saveShippingGroup(shippingGroup, emptyOptions());
		}
 	}
 	
 	protected Order loadBizOrder(String newBizOrderId, Map<String,Object> options) throws Exception
 	{
 		return getOrderDAO().load(newBizOrderId, options);
 	}
 	
 	public ShippingGroup transferToNewAddress(String shippingGroupId, String newAddressId) throws Exception
 	{
 
		ShippingGroup shippingGroup = loadShippingGroup(shippingGroupId, allTokens());	
		synchronized(shippingGroup){
			//will be good when the shippingGroup loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			ShippingAddress address = loadAddress(newAddressId, emptyOptions());		
			shippingGroup.setAddress(address);		
			return saveShippingGroup(shippingGroup, emptyOptions());
		}
 	}
 	
 	protected ShippingAddress loadAddress(String newAddressId, Map<String,Object> options) throws Exception
 	{
 		return getShippingAddressDAO().load(newAddressId, options);
 	}
 	
 

	public void delete(String shippingGroupId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}


}


