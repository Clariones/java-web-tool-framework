
package com.terapico.b2b.assignment;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.terapico.b2b.assignment.Assignment;

import com.terapico.b2b.access.Access;
import com.terapico.b2b.employee.Employee;


public class AssignmentSerializer extends JsonSerializer<Assignment>{



	@Override
	public void serialize(Assignment assignment, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		jgen.writeStartObject();
		
		jgen.writeStringField("id",assignment.getId());
		writeUser("user",assignment,jgen,provider);
		writeAccess("access",assignment,jgen,provider);
		jgen.writeObjectField("assignedDate",assignment.getAssignedDate());
		jgen.writeNumberField("version",assignment.getVersion());
		
		jgen.writeEndObject();
	}
	
	protected void writeUser(String fieldName, Assignment assignment, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		Employee user = assignment.getUser();
		if(user == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField("id",user.getId()); 
		jgen.writeStringField("name",user.getName()); 
		jgen.writeStringField("email",user.getEmail()); 
		jgen.writeStringField("passwd",user.getPasswd()); 
		jgen.writeStringField("cellPhone",user.getCellPhone()); 
		jgen.writeNumberField("version",user.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeAccess(String fieldName, Assignment assignment, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		Access access = assignment.getAccess();
		if(access == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField("id",access.getId()); 
		jgen.writeStringField("roleName",access.getRoleName()); 
		jgen.writeNumberField("version",access.getVersion());
		jgen.writeEndObject();
		
	}
	
	
}


