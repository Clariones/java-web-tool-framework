
package com.terapico.b2b.order;

import java.util.List;
import java.util.Set;
public interface OrderDAO{

	
	public Order load(String orderId,Set<String> options) throws Exception;
	public Order clone(String orderId,Set<String> options) throws Exception;
	
	public Order save(Order order,Set<String> options);
	public List<Order> saveList(List<Order> orderList,Set<String> options);
	
	public void delete(String orderId, int version) throws Exception;
	public int deleteAll() throws Exception;
 	public List<Order> findOrderByBuyer(String buyerCompanyId);
  	public List<Order> findOrderBySeller(String sellerCompanyId);
 }


