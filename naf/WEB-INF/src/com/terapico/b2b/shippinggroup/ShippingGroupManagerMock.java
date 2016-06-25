
package com.terapico.b2b.shippinggroup;

import java.util.Date;
public class ShippingGroupManagerMock implements ShippingGroupManager {

	public ShippingGroup createShippingGroup(String name, String bizOrderId, String addressId, double amount, String[] options) throws Exception
	{
		return new ShippingGroup();
	}
	public ShippingGroup updateShippingGroup(String shippingGroupId, String property, Object newValue) throws Exception 
	{
		return new ShippingGroup();
	}
	
	public ShippingGroup transferToNewBizOrder(String shippingGroupId, String newBizOrderId) throws Exception
 	{
 		return new ShippingGroup();
 
 	}
 	public ShippingGroup transferToNewAddress(String shippingGroupId, String newAddressId) throws Exception
 	{
 		return new ShippingGroup();
 
 	}
 

	public void delete(String shippingGroupId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}



}


