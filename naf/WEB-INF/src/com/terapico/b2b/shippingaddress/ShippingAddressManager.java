
package com.terapico.b2b.shippingaddress;

import java.util.Date;
public interface ShippingAddressManager{

	public ShippingAddress createShippingAddress(String line1, String line2, String city, String state, String country, String[] options) throws Exception;	
	public ShippingAddress updateShippingAddress(String shippingAddressId, String property, Object newValue)  throws Exception;
	


	public void delete(String shippingAddressId, int version) throws Exception;
	public int deleteAll() throws Exception;
	public  ShippingAddress addShippingGroup(String shippingAddressId, String name, String bizOrderId, double amount)  throws Exception;
	public  ShippingAddress removeShippingGroup(String shippingAddressId, String shippingGroupId)  throws Exception;
	public  ShippingAddress updateShippingGroup(String shippingAddressId, String shippingGroupId, String property, Object newValue)  throws Exception;




}


