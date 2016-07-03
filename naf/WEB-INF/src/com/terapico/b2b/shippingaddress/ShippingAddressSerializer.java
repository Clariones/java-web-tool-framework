
package com.terapico.b2b.shippingaddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.terapico.b2b.shippingaddress.ShippingAddress;

import com.terapico.b2b.shippinggroup.ShippingGroup;


public class ShippingAddressSerializer extends JsonSerializer<ShippingAddress>{



	@Override
	public void serialize(ShippingAddress shippingAddress, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		jgen.writeStartObject();
		
		jgen.writeStringField("id",shippingAddress.getId());
		jgen.writeStringField("line1",shippingAddress.getLine1());
		jgen.writeStringField("line2",shippingAddress.getLine2());
		jgen.writeStringField("city",shippingAddress.getCity());
		jgen.writeStringField("state",shippingAddress.getState());
		jgen.writeStringField("country",shippingAddress.getCountry());
		jgen.writeNumberField("version",shippingAddress.getVersion());
		writeShippingGroupList("shippingGroupList",shippingAddress,jgen,provider);
		
		jgen.writeEndObject();
	}
	
	protected void writeShippingGroupList(String fieldName, ShippingAddress shippingAddress, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<ShippingGroup> shippingGroupList = shippingAddress.getShippingGroupList();
		
		if(shippingGroupList == null){
			return;//do nothing when null found for this field.
		}
		if(shippingGroupList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(ShippingGroup shippingGroup: shippingGroupList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField("id",shippingGroup.getId());
			jgen.writeStringField("name",shippingGroup.getName());
			jgen.writeNumberField("amount",shippingGroup.getAmount());
			jgen.writeNumberField("version",shippingGroup.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


