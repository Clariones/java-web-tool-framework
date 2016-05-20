
package com.terapico.b2b;

import java.util.List;

public interface OrderDAO{

	
	public Order load(String orderId) throws OrderNotFoundException;
	public Order save(Order order);
	public void delete(String orderId) throws OrderNotFoundException;
 	public List<Order> findOrderByBuyer(String buyerCompanyId);
  	public List<Order> findOrderBySeller(String sellerCompanyId);
 }


