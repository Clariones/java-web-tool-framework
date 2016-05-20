
package com.terapico.b2b;

import java.util.List;

public interface ShippingGroupDAO{

	
	public ShippingGroup load(String shippingGroupId) throws ShippingGroupNotFoundException;
	public ShippingGroup save(ShippingGroup shippingGroup);
	public void delete(String shippingGroupId) throws ShippingGroupNotFoundException;
 	public List<ShippingGroup> findShippingGroupByBizOrder(String orderId);
  	public List<ShippingGroup> findShippingGroupByAddress(String shippingAddressId);
 }


