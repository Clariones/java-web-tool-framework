
package com.terapico.b2b.order;

import java.util.Date;
public class OrderManagerMock implements OrderManager {

	public Order createOrder(String buyerId, String sellerId, String title, double totalAmount, String type, boolean markAsDelete, String[] options) throws Exception
	{
		return new Order();
	}
	public Order updateOrder(String orderId, String property, Object newValue) throws Exception 
	{
		return new Order();
	}
	
	public Order transferToNewBuyer(String orderId, String newBuyerId) throws Exception
 	{
 		return new Order();
 
 	}
 	public Order transferToNewSeller(String orderId, String newSellerId) throws Exception
 	{
 		return new Order();
 
 	}
 	public Order confirm(String orderId, String who, Date confirmTime) throws Exception
 	{
 		return new Order();
 	}
	public Order approve(String orderId, String who, Date approveTime) throws Exception
 	{
 		return new Order();
 	}
	public Order process(String orderId, String who, Date processTime) throws Exception
 	{
 		return new Order();
 	}
	public Order ship(String orderId, String who, Date shipTime) throws Exception
 	{
 		return new Order();
 	}
	public Order deliver(String orderId, String who, Date deliveryTime) throws Exception
 	{
 		return new Order();
 	}


	public void delete(String orderId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}
	public  Order addLineItem(String orderId, String skuId, String skuName, double amount, int quantity)
	{
		return new Order();
	}
	public  Order removeLineItem(String orderId, String lineItemId){
		return new Order();
	}
	public  Order updateLineItem(String orderId, String lineItemId, String property, Object newValue){
		return new Order();
	}

	public  Order addShippingGroup(String orderId, String name, String addressId, double amount)
	{
		return new Order();
	}
	public  Order removeShippingGroup(String orderId, String shippingGroupId){
		return new Order();
	}
	public  Order updateShippingGroup(String orderId, String shippingGroupId, String property, Object newValue){
		return new Order();
	}

	public  Order addPaymentGroup(String orderId, String name, String cardNumber, String billingAddressId)
	{
		return new Order();
	}
	public  Order removePaymentGroup(String orderId, String paymentGroupId){
		return new Order();
	}
	public  Order updatePaymentGroup(String orderId, String paymentGroupId, String property, Object newValue){
		return new Order();
	}

	public  Order addAction(String orderId, String name, String internalName)
	{
		return new Order();
	}
	public  Order removeAction(String orderId, String actionId){
		return new Order();
	}
	public  Order updateAction(String orderId, String actionId, String property, Object newValue){
		return new Order();
	}




}


