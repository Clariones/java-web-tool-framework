
package com.terapico.b2b.shippingaddress;

import java.util.Date;
public class ShippingAddressManagerMock implements ShippingAddressManager {

	public ShippingAddress createShippingAddress(String line1, String line2, String city, String state, String country, String[] options) throws Exception
	{
		return new ShippingAddress();
	}
	public ShippingAddress updateShippingAddress(String shippingAddressId, String property, Object newValue) throws Exception 
	{
		return new ShippingAddress();
	}
	


	public void delete(String shippingAddressId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}
	public  ShippingAddress addShippingGroup(String shippingAddressId, String name, String bizOrderId, double amount)
	{
		return new ShippingAddress();
	}
	public  ShippingAddress removeShippingGroup(String shippingAddressId, String shippingGroupId){
		return new ShippingAddress();
	}
	public  ShippingAddress updateShippingGroup(String shippingAddressId, String shippingGroupId, String property, Object newValue){
		return new ShippingAddress();
	}




}


