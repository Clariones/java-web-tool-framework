
package com.terapico.b2b.role;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.terapico.b2b.role.Role;

import com.terapico.b2b.access.Access;
import com.terapico.b2b.custsvcrep.CustSvcRep;


public class RoleSerializer extends JsonSerializer<Role>{



	@Override
	public void serialize(Role role, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		jgen.writeStartObject();
		
		jgen.writeStringField("id",role.getId());
		jgen.writeStringField("roleName",role.getRoleName());
		jgen.writeNumberField("version",role.getVersion());
		writeAccessList("accessList",role,jgen,provider);
		writeCustSvcRepList("custSvcRepList",role,jgen,provider);
		
		jgen.writeEndObject();
	}
	
	protected void writeAccessList(String fieldName, Role role, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<Access> accessList = role.getAccessList();
		
		if(accessList == null){
			return;//do nothing when null found for this field.
		}
		if(accessList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(Access access: accessList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField("id",access.getId());
			jgen.writeStringField("roleName",access.getRoleName());
			jgen.writeNumberField("version",access.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeCustSvcRepList(String fieldName, Role role, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<CustSvcRep> custSvcRepList = role.getCustSvcRepList();
		
		if(custSvcRepList == null){
			return;//do nothing when null found for this field.
		}
		if(custSvcRepList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(CustSvcRep custSvcRep: custSvcRepList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField("id",custSvcRep.getId());
			jgen.writeStringField("email",custSvcRep.getEmail());
			jgen.writeStringField("passwd",custSvcRep.getPasswd());
			jgen.writeNumberField("version",custSvcRep.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


