
package com.terapico.b2b.shippingaddress;

import java.util.List;
import java.util.Set;
public interface ShippingAddressDAO{

	
	public ShippingAddress load(String shippingAddressId,Set<String> options) throws Exception;
	public ShippingAddress clone(String shippingAddressId,Set<String> options) throws Exception;
	
	public ShippingAddress save(ShippingAddress shippingAddress,Set<String> options);
	public List<ShippingAddress> saveList(List<ShippingAddress> shippingAddressList,Set<String> options);
	
	public void delete(String shippingAddressId, int version) throws Exception;
}


