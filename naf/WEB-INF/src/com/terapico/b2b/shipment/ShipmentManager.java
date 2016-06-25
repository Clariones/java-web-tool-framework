
package com.terapico.b2b.shipment;

import java.util.Date;
public interface ShipmentManager{

	public Shipment createShipment(String who, Date shipTime, String[] options) throws Exception;	
	public Shipment updateShipment(String shipmentId, String property, Object newValue)  throws Exception;
	


	public void delete(String shipmentId, int version) throws Exception;
	public int deleteAll() throws Exception;
	public  Shipment addOrder(String shipmentId, String buyerId, String sellerId, String title, double totalAmount, String type, boolean markAsDelete)  throws Exception;
	public  Shipment removeOrder(String shipmentId, String orderId)  throws Exception;
	public  Shipment updateOrder(String shipmentId, String orderId, String property, Object newValue)  throws Exception;




}


