
package com.terapico.b2b.shipment;

import java.util.Date;
public class ShipmentManagerMock implements ShipmentManager {

	public Shipment createShipment(String who, Date shipTime, String[] options) throws Exception
	{
		return new Shipment();
	}
	public Shipment updateShipment(String shipmentId, String property, Object newValue) throws Exception 
	{
		return new Shipment();
	}
	


	public void delete(String shipmentId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}
	public  Shipment addOrder(String shipmentId, String buyerId, String sellerId, String title, String costCenterId, String profitCenterId, double totalAmount, String type, boolean markAsDelete, String recurringInfoId, String status)
	{
		return new Shipment();
	}
	public  Shipment removeOrder(String shipmentId, String orderId){
		return new Shipment();
	}
	public  Shipment updateOrder(String shipmentId, String orderId, String property, Object newValue){
		return new Shipment();
	}




}


