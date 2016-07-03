
package com.terapico.b2b.shippingaddress;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import com.terapico.b2b.shippinggroup.ShippingGroup;


import com.terapico.b2b.order.Order;
import com.terapico.b2b.shippingaddress.ShippingAddress;



public class ShippingAddressManagerImpl implements ShippingAddressManager {

	private  ShippingAddressDAO  shippingAddressDAO;
 	public void setShippingAddressDAO(ShippingAddressDAO  shippingAddressDAO){
 	
 		if(shippingAddressDAO == null){
 			throw new IllegalStateException("Do not try to set shippingAddressDAO to null.");
 		}
	 	this.shippingAddressDAO = shippingAddressDAO;
 	}
 	public ShippingAddressDAO getShippingAddressDAO(){
 		if(this.shippingAddressDAO == null){
 			throw new IllegalStateException("The ShippingAddressDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.shippingAddressDAO;
 	}
 	
 	public ShippingAddress saveShippingAddress(ShippingAddress shippingAddress, Map<String,Object>options) throws Exception{	
 		return getShippingAddressDAO().save(shippingAddress, options);
 	}
 	public ShippingAddress loadShippingAddress(String shippingAddressId, Map<String,Object>options) throws Exception{	
 		return getShippingAddressDAO().load(shippingAddressId, options);
 	}
 	
 	
 	
	public ShippingAddress createShippingAddress(String line1, String line2, String city, String state, String country, String[] optionsExpr) throws Exception
	{
		
		
		ShippingAddress shippingAddress=createNewShippingAddress(optionsExpr);	

		shippingAddress.setLine1(line1);
		shippingAddress.setLine2(line2);
		shippingAddress.setCity(city);
		shippingAddress.setState(state);
		shippingAddress.setCountry(country);

		return saveShippingAddress(shippingAddress, emptyOptions());
		

		
	}
	protected ShippingAddress createNewShippingAddress(String[] optionsExpr) throws Exception
	{
		
		return new ShippingAddress();
		
	}
	public ShippingAddress updateShippingAddress(String shippingAddressId, String property, Object newValue) throws Exception 
	{
		return new ShippingAddress();
	}
	protected Map<String,Object> emptyOptions(){
		return new HashMap<String,Object>();
	}
	
	protected ShippingAddressTokens tokens(){
		return ShippingAddressTokens.start();
	}
	protected Map<String,Object> allTokens(){
		return ShippingAddressTokens.all();
	}
	


	public void delete(String shippingAddressId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}
	public  ShippingAddress addShippingGroup(String shippingAddressId, String name, String bizOrderId, double amount) throws Exception
	{		
		ShippingGroup shippingGroup = createShippingGroup(name, bizOrderId, amount);
		
		ShippingAddress shippingAddress = loadShippingAddress(shippingAddressId, allTokens());
		synchronized(shippingAddress){ 
			//will be good when the shippingAddress loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			shippingAddress.addShippingGroup( shippingGroup );		
			return saveShippingAddress(shippingAddress, tokens().withShippingGroupList().done());
		}
	}
	protected ShippingGroup createShippingGroup(String name, String bizOrderId, double amount){

		ShippingGroup shippingGroup = new ShippingGroup();
		
		
		shippingGroup.setName(name);		
		Order  bizOrder = new Order();
		bizOrder.setId(bizOrderId);		
		shippingGroup.setBizOrder(bizOrder);		
		shippingGroup.setAmount(amount);
	
		
		return shippingGroup;			
		
	}
	public  ShippingAddress removeShippingGroup(String shippingAddressId, String shippingGroupId){
		return new ShippingAddress();
	}
	public  ShippingAddress updateShippingGroup(String shippingAddressId, String shippingGroupId, String property, Object newValue){
		return new ShippingAddress();
	}



}


