
package com.terapico.b2b.shippinggroup;

import java.util.List;
import java.util.Set;
public interface ShippingGroupDAO{

	
	public ShippingGroup load(String shippingGroupId,Set<String> options) throws Exception;
	public ShippingGroup clone(String shippingGroupId,Set<String> options) throws Exception;
	
	public ShippingGroup save(ShippingGroup shippingGroup,Set<String> options);
	public List<ShippingGroup> saveList(List<ShippingGroup> shippingGroupList,Set<String> options);
	
	public void delete(String shippingGroupId, int version) throws Exception;
	public int deleteAll() throws Exception;
 	public List<ShippingGroup> findShippingGroupByBizOrder(String orderId);
  	public List<ShippingGroup> findShippingGroupByAddress(String shippingAddressId);
 }


