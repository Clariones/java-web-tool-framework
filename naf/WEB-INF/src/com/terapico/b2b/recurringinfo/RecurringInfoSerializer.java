
package com.terapico.b2b.recurringinfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.terapico.b2b.recurringinfo.RecurringInfo;

import com.terapico.b2b.order.Order;


public class RecurringInfoSerializer extends JsonSerializer<RecurringInfo>{



	@Override
	public void serialize(RecurringInfo recurringInfo, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		jgen.writeStartObject();
		
		jgen.writeStringField("id",recurringInfo.getId());
		jgen.writeStringField("name",recurringInfo.getName());
		jgen.writeObjectField("nextTime",recurringInfo.getNextTime());
		jgen.writeStringField("cronExpr",recurringInfo.getCronExpr());
		jgen.writeNumberField("version",recurringInfo.getVersion());
		writeOrderList("orderList",recurringInfo,jgen,provider);
		
		jgen.writeEndObject();
	}
	
	protected void writeOrderList(String fieldName, RecurringInfo recurringInfo, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<Order> orderList = recurringInfo.getOrderList();
		
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


