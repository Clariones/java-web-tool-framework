
package com.terapico.b2b.delivery;

import java.util.Date;
public interface DeliveryManager{

	public Delivery createDelivery(String who, Date deliveryTime, String[] options) throws Exception;	
	public Delivery updateDelivery(String deliveryId, String property, Object newValue)  throws Exception;
	


	public void delete(String deliveryId, int version) throws Exception;
	public int deleteAll() throws Exception;
	public  Delivery addOrder(String deliveryId, String buyerId, String sellerId, String title, double totalAmount, String type, boolean markAsDelete)  throws Exception;
	public  Delivery removeOrder(String deliveryId, String orderId)  throws Exception;
	public  Delivery updateOrder(String deliveryId, String orderId, String property, Object newValue)  throws Exception;




}


