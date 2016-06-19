
package com.terapico.b2b.shippingaddress;

import java.util.List;
import java.util.Set;
public interface ShippingAddressService{

	
	public ShippingAddress createShippingAddress(String shippingAddressId,String[] options) throws Exception;
	public ShippingAddress clone(String shippingAddressId, String[] options) throws Exception;
	
	public ShippingAddress save(ShippingAddress shippingAddress,String[] options);
	public List<ShippingAddress> saveList(List<ShippingAddress> shippingAddressList,String[] options);
	
	public void delete(String shippingAddressId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


