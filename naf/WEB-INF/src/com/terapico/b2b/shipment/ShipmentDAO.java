
package com.terapico.b2b.shipment;

import java.util.List;
import java.util.Set;
import java.util.Map;
public interface ShipmentDAO{

	
	public Shipment load(String shipmentId,Map<String,Object> options) throws Exception;
	public Shipment clone(String shipmentId,Map<String,Object> options) throws Exception;
	
	public Shipment save(Shipment shipment,Map<String,Object> options);
	public List<Shipment> saveList(List<Shipment> shipmentList,Map<String,Object> options);
	
	public void delete(String shipmentId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


