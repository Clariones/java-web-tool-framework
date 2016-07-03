
package com.terapico.b2b.delivery;

import java.util.Date;
public class DeliveryManagerMock implements DeliveryManager {

	public Delivery createDelivery(String who, Date deliveryTime, String[] options) throws Exception
	{
		return new Delivery();
	}
	public Delivery updateDelivery(String deliveryId, String property, Object newValue) throws Exception 
	{
		return new Delivery();
	}
	


	public void delete(String deliveryId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}
	public  Delivery addOrder(String deliveryId, String buyerId, String sellerId, String title, String costCenterId, String profitCenterId, double totalAmount, String type, boolean markAsDelete, String recurringInfoId, String status)
	{
		return new Delivery();
	}
	public  Delivery removeOrder(String deliveryId, String orderId){
		return new Delivery();
	}
	public  Delivery updateOrder(String deliveryId, String orderId, String property, Object newValue){
		return new Delivery();
	}




}


