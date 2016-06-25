
package com.terapico.b2b.shippinggroup;

import java.util.Date;
public interface ShippingGroupManager{

	public ShippingGroup createShippingGroup(String name, String bizOrderId, String addressId, double amount, String[] options) throws Exception;	
	public ShippingGroup updateShippingGroup(String shippingGroupId, String property, Object newValue)  throws Exception;
	
	public ShippingGroup transferToNewBizOrder(String shippingGroupId, String newBizOrderId)  throws Exception;
 	public ShippingGroup transferToNewAddress(String shippingGroupId, String newAddressId)  throws Exception;
 

	public void delete(String shippingGroupId, int version) throws Exception;
	public int deleteAll() throws Exception;



}


