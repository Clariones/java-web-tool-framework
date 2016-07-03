
package com.terapico.b2b.lineitem;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.terapico.b2b.lineitem.LineItem;

import com.terapico.b2b.order.Order;


public class LineItemSerializer extends JsonSerializer<LineItem>{



	@Override
	public void serialize(LineItem lineItem, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		jgen.writeStartObject();
		
		jgen.writeStringField("id",lineItem.getId());
		writeBizOrder("bizOrder",lineItem,jgen,provider);
		jgen.writeStringField("skuId",lineItem.getSkuId());
		jgen.writeStringField("skuName",lineItem.getSkuName());
		jgen.writeNumberField("amount",lineItem.getAmount());
		jgen.writeNumberField("quantity",lineItem.getQuantity());
		jgen.writeBooleanField("active",lineItem.getActive());
		jgen.writeNumberField("version",lineItem.getVersion());
		
		jgen.writeEndObject();
	}
	
	protected void writeBizOrder(String fieldName, LineItem lineItem, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		Order bizOrder = lineItem.getBizOrder();
		if(bizOrder == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField("id",bizOrder.getId()); 
		jgen.writeStringField("title",bizOrder.getTitle()); 
		jgen.writeNumberField("totalAmount",bizOrder.getTotalAmount()); 
		jgen.writeStringField("type",bizOrder.getType()); 
		jgen.writeBooleanField("markAsDelete",bizOrder.getMarkAsDelete()); 
		jgen.writeStringField("status",bizOrder.getStatus()); 
		jgen.writeNumberField("version",bizOrder.getVersion());
		jgen.writeEndObject();
		
	}
	
	
}


