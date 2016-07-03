
package com.terapico.b2b.action;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.terapico.b2b.action.Action;

import com.terapico.b2b.order.Order;


public class ActionSerializer extends JsonSerializer<Action>{



	@Override
	public void serialize(Action action, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		jgen.writeStartObject();
		
		jgen.writeStringField("id",action.getId());
		jgen.writeStringField("name",action.getName());
		jgen.writeStringField("internalName",action.getInternalName());
		writeBo("bo",action,jgen,provider);
		jgen.writeNumberField("version",action.getVersion());
		
		jgen.writeEndObject();
	}
	
	protected void writeBo(String fieldName, Action action, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		Order bo = action.getBo();
		if(bo == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField("id",bo.getId()); 
		jgen.writeStringField("title",bo.getTitle()); 
		jgen.writeNumberField("totalAmount",bo.getTotalAmount()); 
		jgen.writeStringField("type",bo.getType()); 
		jgen.writeBooleanField("markAsDelete",bo.getMarkAsDelete()); 
		jgen.writeStringField("status",bo.getStatus()); 
		jgen.writeNumberField("version",bo.getVersion());
		jgen.writeEndObject();
		
	}
	
	
}







