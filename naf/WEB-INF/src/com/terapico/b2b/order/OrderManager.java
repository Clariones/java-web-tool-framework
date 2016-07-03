
package com.terapico.b2b.order;

import java.util.Date;
public interface OrderManager{

	public Order createOrder(String buyerId, String sellerId, String title, String costCenterId, String profitCenterId, double totalAmount, String type, boolean markAsDelete, String recurringInfoId, String status, String[] options) throws Exception;	
	public Order updateOrder(String orderId, String property, Object newValue)  throws Exception;
	
	public Order transferToNewBuyer(String orderId, String newBuyerId)  throws Exception;
 	public Order transferToNewSeller(String orderId, String newSellerId)  throws Exception;
 	public Order transferToNewCostCenter(String orderId, String newCostCenterId)  throws Exception;
 	public Order transferToNewProfitCenter(String orderId, String newProfitCenterId)  throws Exception;
 	public Order confirm(String orderId, String who, Date confirmTime)  throws Exception;
	public Order approve(String orderId, String who, Date approveTime)  throws Exception;
	public Order process(String orderId, String who, Date processTime)  throws Exception;
	public Order ship(String orderId, String who, Date shipTime)  throws Exception;
	public Order deliver(String orderId, String who, Date deliveryTime)  throws Exception;
	public Order transferToNewRecurringInfo(String orderId, String newRecurringInfoId)  throws Exception;
 

	public void delete(String orderId, int version) throws Exception;
	public int deleteAll() throws Exception;
	public  Order addLineItem(String orderId, String skuId, String skuName, double amount, int quantity, boolean active)  throws Exception;
	public  Order removeLineItem(String orderId, String lineItemId)  throws Exception;
	public  Order updateLineItem(String orderId, String lineItemId, String property, Object newValue)  throws Exception;

	public  Order addShippingGroup(String orderId, String name, String addressId, double amount)  throws Exception;
	public  Order removeShippingGroup(String orderId, String shippingGroupId)  throws Exception;
	public  Order updateShippingGroup(String orderId, String shippingGroupId, String property, Object newValue)  throws Exception;

	public  Order addPaymentGroup(String orderId, String name, String cardNumber, String billingAddressId)  throws Exception;
	public  Order removePaymentGroup(String orderId, String paymentGroupId)  throws Exception;
	public  Order updatePaymentGroup(String orderId, String paymentGroupId, String property, Object newValue)  throws Exception;

	public  Order addAction(String orderId, String name, String internalName)  throws Exception;
	public  Order removeAction(String orderId, String actionId)  throws Exception;
	public  Order updateAction(String orderId, String actionId, String property, Object newValue)  throws Exception;




}


