
package com.terapico.b2b.costcenter;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.terapico.b2b.costcenter.CostCenter;

import com.terapico.b2b.order.Order;
import com.terapico.b2b.buyercompany.BuyerCompany;


public class CostCenterSerializer extends JsonSerializer<CostCenter>{



	@Override
	public void serialize(CostCenter costCenter, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		jgen.writeStartObject();
		
		jgen.writeStringField("id",costCenter.getId());
		jgen.writeStringField("name",costCenter.getName());
		writeBelongsTo("belongsTo",costCenter,jgen,provider);
		jgen.writeNumberField("version",costCenter.getVersion());
		writeOrderList("orderList",costCenter,jgen,provider);
		
		jgen.writeEndObject();
	}
	
	protected void writeBelongsTo(String fieldName, CostCenter costCenter, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		BuyerCompany belongsTo = costCenter.getBelongsTo();
		if(belongsTo == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField("id",belongsTo.getId()); 
		jgen.writeStringField("name",belongsTo.getName()); 
		jgen.writeStringField("priceList",belongsTo.getPriceList()); 
		jgen.writeNumberField("rating",belongsTo.getRating()); 
		jgen.writeStringField("logo",belongsTo.getLogo()); 
		jgen.writeStringField("owner",belongsTo.getOwner()); 
		jgen.writeNumberField("version",belongsTo.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeOrderList(String fieldName, CostCenter costCenter, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<Order> orderList = costCenter.getOrderList();
		
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


