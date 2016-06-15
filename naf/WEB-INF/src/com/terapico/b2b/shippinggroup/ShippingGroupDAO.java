
package com.terapico.b2b.shippinggroup;

import java.util.List;
import java.util.Set;
import java.util.Map;
public interface ShippingGroupDAO{

	
	public ShippingGroup load(String shippingGroupId,Map<String,Object> options) throws Exception;
	public ShippingGroup clone(String shippingGroupId,Map<String,Object> options) throws Exception;
	
	public ShippingGroup save(ShippingGroup shippingGroup,Map<String,Object> options);
	public List<ShippingGroup> saveList(List<ShippingGroup> shippingGroupList,Map<String,Object> options);
	
	public void delete(String shippingGroupId, int version) throws Exception;
	public int deleteAll() throws Exception;
 	public List<ShippingGroup> findShippingGroupByBizOrder(String orderId);
  	public List<ShippingGroup> findShippingGroupByAddress(String shippingAddressId);
 }


