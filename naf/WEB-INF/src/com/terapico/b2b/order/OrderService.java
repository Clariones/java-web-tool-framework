
package com.terapico.b2b.order;

import java.util.List;
import java.util.Set;
public interface OrderService{

	
	public Order createOrder(String orderId,String[] options) throws Exception;
	public Order clone(String orderId, String[] options) throws Exception;
	
	public Order save(Order order,String[] options);
	public List<Order> saveList(List<Order> orderList,String[] options);
	
	public void delete(String orderId, int version) throws Exception;
	public int deleteAll() throws Exception;
 	public List<Order> findOrderByBuyer(String buyerCompanyId);
  	public List<Order> findOrderBySeller(String sellerCompanyId);
  	public List<Order> findOrderByConfirmation(String confirmationId);
  	public List<Order> findOrderByApproval(String approvalId);
  	public List<Order> findOrderByProcessing(String processingId);
  	public List<Order> findOrderByShipment(String shipmentId);
  	public List<Order> findOrderByDelivery(String deliveryId);
 }


