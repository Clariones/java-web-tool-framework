
package com.terapico.b2b.employee;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.terapico.b2b.employee.Employee;

import com.terapico.b2b.buyercompany.BuyerCompany;
import com.terapico.b2b.assignment.Assignment;


public class EmployeeSerializer extends JsonSerializer<Employee>{



	@Override
	public void serialize(Employee employee, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		jgen.writeStartObject();
		
		jgen.writeStringField("id",employee.getId());
		jgen.writeStringField("name",employee.getName());
		writeCompany("company",employee,jgen,provider);
		jgen.writeStringField("email",employee.getEmail());
		jgen.writeStringField("passwd",employee.getPasswd());
		jgen.writeStringField("cellPhone",employee.getCellPhone());
		jgen.writeNumberField("version",employee.getVersion());
		writeAssignmentList("assignmentList",employee,jgen,provider);
		
		jgen.writeEndObject();
	}
	
	protected void writeCompany(String fieldName, Employee employee, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		BuyerCompany company = employee.getCompany();
		if(company == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField("id",company.getId()); 
		jgen.writeStringField("name",company.getName()); 
		jgen.writeStringField("priceList",company.getPriceList()); 
		jgen.writeNumberField("rating",company.getRating()); 
		jgen.writeStringField("logo",company.getLogo()); 
		jgen.writeStringField("owner",company.getOwner()); 
		jgen.writeNumberField("version",company.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeAssignmentList(String fieldName, Employee employee, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<Assignment> assignmentList = employee.getAssignmentList();
		
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


