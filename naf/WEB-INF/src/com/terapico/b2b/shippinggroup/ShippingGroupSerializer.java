
package com.terapico.b2b.shippinggroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.terapico.b2b.shippinggroup.ShippingGroup;

import com.terapico.b2b.order.Order;
import com.terapico.b2b.shippingaddress.ShippingAddress;


public class ShippingGroupSerializer extends JsonSerializer<ShippingGroup>{



	@Override
	public void serialize(ShippingGroup shippingGroup, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		jgen.writeStartObject();
		
		jgen.writeStringField("id",shippingGroup.getId());
		jgen.writeStringField("name",shippingGroup.getName());
		writeBizOrder("bizOrder",shippingGroup,jgen,provider);
		writeAddress("address",shippingGroup,jgen,provider);
		jgen.writeNumberField("amount",shippingGroup.getAmount());
		jgen.writeNumberField("version",shippingGroup.getVersion());
		
		jgen.writeEndObject();
	}
	
	protected void writeBizOrder(String fieldName, ShippingGroup shippingGroup, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		Order bizOrder = shippingGroup.getBizOrder();
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
	
	protected void writeAddress(String fieldName, ShippingGroup shippingGroup, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		ShippingAddress address = shippingGroup.getAddress();
		if(address == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField("id",address.getId()); 
		jgen.writeStringField("line1",address.getLine1()); 
		jgen.writeStringField("line2",address.getLine2()); 
		jgen.writeStringField("city",address.getCity()); 
		jgen.writeStringField("state",address.getState()); 
		jgen.writeStringField("country",address.getCountry()); 
		jgen.writeNumberField("version",address.getVersion());
		jgen.writeEndObject();
		
	}
	
	
}


