
package com.terapico.b2b.delivery;

import java.util.List;
import java.util.Set;
import java.util.Map;
public interface DeliveryDAO{

	
	public Delivery load(String deliveryId,Map<String,Object> options) throws Exception;
	public Delivery clone(String deliveryId,Map<String,Object> options) throws Exception;
	
	public Delivery save(Delivery delivery,Map<String,Object> options);
	public List<Delivery> saveList(List<Delivery> deliveryList,Map<String,Object> options);
	
	public void delete(String deliveryId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


