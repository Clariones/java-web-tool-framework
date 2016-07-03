
package com.terapico.b2b.delivery;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.terapico.b2b.delivery.Delivery;

import com.terapico.b2b.order.Order;


public class DeliverySerializer extends JsonSerializer<Delivery>{



	@Override
	public void serialize(Delivery delivery, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		jgen.writeStartObject();
		
		jgen.writeStringField("id",delivery.getId());
		jgen.writeStringField("who",delivery.getWho());
		jgen.writeObjectField("deliveryTime",delivery.getDeliveryTime());
		jgen.writeNumberField("version",delivery.getVersion());
		writeOrderList("orderList",delivery,jgen,provider);
		
		jgen.writeEndObject();
	}
	
	protected void writeOrderList(String fieldName, Delivery delivery, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<Order> orderList = delivery.getOrderList();
		
		if(orderList == null){
			return;//do nothing when null found for this field.
		}
		if(orderList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(Order order: orderList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField("id",order.getId());
			jgen.writeStringField("title",order.getTitle());
			jgen.writeNumberField("totalAmount",order.getTotalAmount());
			jgen.writeStringField("type",order.getType());
			jgen.writeBooleanField("markAsDelete",order.getMarkAsDelete());
			jgen.writeStringField("status",order.getStatus());
			jgen.writeNumberField("version",order.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


