
package com.terapico.b2b.access;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.terapico.b2b.access.Access;

import com.terapico.b2b.role.Role;
import com.terapico.b2b.assignment.Assignment;


public class AccessSerializer extends JsonSerializer<Access>{



	@Override
	public void serialize(Access access, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		jgen.writeStartObject();
		
		jgen.writeStringField("id",access.getId());
		jgen.writeStringField("roleName",access.getRoleName());
		writeRole("role",access,jgen,provider);
		jgen.writeNumberField("version",access.getVersion());
		writeAssignmentList("assignmentList",access,jgen,provider);
		
		jgen.writeEndObject();
	}
	
	protected void writeRole(String fieldName, Access access, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		Role role = access.getRole();
		if(role == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField("id",role.getId()); 
		jgen.writeStringField("roleName",role.getRoleName()); 
		jgen.writeNumberField("version",role.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeAssignmentList(String fieldName, Access access, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<Assignment> assignmentList = access.getAssignmentList();
		
		if(assignmentList == null){
			return;//do nothing when null found for this field.
		}
		if(assignmentList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(Assignment assignment: assignmentList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField("id",assignment.getId());
			jgen.writeObjectField("assignedDate",assignment.getAssignedDate());
			jgen.writeNumberField("version",assignment.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


