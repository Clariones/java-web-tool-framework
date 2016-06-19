
package com.terapico.b2b.shipment;

import java.util.List;
import java.util.Set;
public interface ShipmentService{

	
	public Shipment createShipment(String shipmentId,String[] options) throws Exception;
	public Shipment clone(String shipmentId, String[] options) throws Exception;
	
	public Shipment save(Shipment shipment,String[] options);
	public List<Shipment> saveList(List<Shipment> shipmentList,String[] options);
	
	public void delete(String shipmentId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


