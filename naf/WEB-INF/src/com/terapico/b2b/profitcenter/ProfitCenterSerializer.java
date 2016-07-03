
package com.terapico.b2b.profitcenter;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.terapico.b2b.profitcenter.ProfitCenter;

import com.terapico.b2b.order.Order;
import com.terapico.b2b.sellercompany.SellerCompany;


public class ProfitCenterSerializer extends JsonSerializer<ProfitCenter>{



	@Override
	public void serialize(ProfitCenter profitCenter, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		jgen.writeStartObject();
		
		jgen.writeStringField("id",profitCenter.getId());
		jgen.writeStringField("name",profitCenter.getName());
		writeBelongsTo("belongsTo",profitCenter,jgen,provider);
		jgen.writeNumberField("version",profitCenter.getVersion());
		writeOrderList("orderList",profitCenter,jgen,provider);
		
		jgen.writeEndObject();
	}
	
	protected void writeBelongsTo(String fieldName, ProfitCenter profitCenter, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		SellerCompany belongsTo = profitCenter.getBelongsTo();
		if(belongsTo == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField("id",belongsTo.getId()); 
		jgen.writeStringField("name",belongsTo.getName()); 
		jgen.writeStringField("owner",belongsTo.getOwner()); 
		jgen.writeStringField("logo",belongsTo.getLogo()); 
		jgen.writeStringField("contractText",belongsTo.getContractText()); 
		jgen.writeNumberField("version",belongsTo.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeOrderList(String fieldName, ProfitCenter profitCenter, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<Order> orderList = profitCenter.getOrderList();
		
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


