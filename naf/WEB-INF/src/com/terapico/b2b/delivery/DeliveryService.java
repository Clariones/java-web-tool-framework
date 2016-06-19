
package com.terapico.b2b.delivery;

import java.util.List;
import java.util.Set;
public interface DeliveryService{

	
	public Delivery createDelivery(String deliveryId,String[] options) throws Exception;
	public Delivery clone(String deliveryId, String[] options) throws Exception;
	
	public Delivery save(Delivery delivery,String[] options);
	public List<Delivery> saveList(List<Delivery> deliveryList,String[] options);
	
	public void delete(String deliveryId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


