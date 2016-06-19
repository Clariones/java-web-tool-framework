
package com.terapico.b2b.shippinggroup;

import java.util.List;
import java.util.Set;
public interface ShippingGroupService{

	
	public ShippingGroup createShippingGroup(String shippingGroupId,String[] options) throws Exception;
	public ShippingGroup clone(String shippingGroupId, String[] options) throws Exception;
	
	public ShippingGroup save(ShippingGroup shippingGroup,String[] options);
	public List<ShippingGroup> saveList(List<ShippingGroup> shippingGroupList,String[] options);
	
	public void delete(String shippingGroupId, int version) throws Exception;
	public int deleteAll() throws Exception;
 	public List<ShippingGroup> findShippingGroupByBizOrder(String orderId);
  	public List<ShippingGroup> findShippingGroupByAddress(String shippingAddressId);
 }


