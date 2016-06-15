
package com.terapico.b2b.shippingaddress;

import java.util.List;
import java.util.Set;
import java.util.Map;
public interface ShippingAddressDAO{

	
	public ShippingAddress load(String shippingAddressId,Map<String,Object> options) throws Exception;
	public ShippingAddress clone(String shippingAddressId,Map<String,Object> options) throws Exception;
	
	public ShippingAddress save(ShippingAddress shippingAddress,Map<String,Object> options);
	public List<ShippingAddress> saveList(List<ShippingAddress> shippingAddressList,Map<String,Object> options);
	
	public void delete(String shippingAddressId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


