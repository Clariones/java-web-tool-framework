
package com.terapico.b2b.order;

import java.util.List;
import java.util.Set;
import java.util.Map;
public interface OrderDAO{

	
	public Order load(String orderId,Map<String,Object> options) throws Exception;
	public Order clone(String orderId,Map<String,Object> options) throws Exception;
	
	public Order save(Order order,Map<String,Object> options);
	public List<Order> saveList(List<Order> orderList,Map<String,Object> options);
	
	public void delete(String orderId, int version) throws Exception;
	public int deleteAll() throws Exception;
 	public List<Order> findOrderByBuyer(String buyerCompanyId);
  	public List<Order> findOrderBySeller(String sellerCompanyId);
  	public List<Order> findOrderByCostCenter(String costCenterId);
  	public List<Order> findOrderByProfitCenter(String profitCenterId);
  	public List<Order> findOrderByConfirmation(String confirmationId);
  	public List<Order> findOrderByApproval(String approvalId);
  	public List<Order> findOrderByProcessing(String processingId);
  	public List<Order> findOrderByShipment(String shipmentId);
  	public List<Order> findOrderByDelivery(String deliveryId);
  	public List<Order> findOrderByRecurringInfo(String recurringInfoId);
 }


