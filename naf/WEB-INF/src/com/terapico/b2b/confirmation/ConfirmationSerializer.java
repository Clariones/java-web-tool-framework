
package com.terapico.b2b.confirmation;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.terapico.b2b.confirmation.Confirmation;

import com.terapico.b2b.order.Order;


public class ConfirmationSerializer extends JsonSerializer<Confirmation>{



	@Override
	public void serialize(Confirmation confirmation, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		jgen.writeStartObject();
		
		jgen.writeStringField("id",confirmation.getId());
		jgen.writeStringField("who",confirmation.getWho());
		jgen.writeObjectField("confirmTime",confirmation.getConfirmTime());
		jgen.writeNumberField("version",confirmation.getVersion());
		writeOrderList("orderList",confirmation,jgen,provider);
		
		jgen.writeEndObject();
	}
	
	protected void writeOrderList(String fieldName, Confirmation confirmation, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<Order> orderList = confirmation.getOrderList();
		
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


