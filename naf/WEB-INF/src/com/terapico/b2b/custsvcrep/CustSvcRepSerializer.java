
package com.terapico.b2b.custsvcrep;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.terapico.b2b.custsvcrep.CustSvcRep;

import com.terapico.b2b.role.Role;
import com.terapico.b2b.sellercompany.SellerCompany;


public class CustSvcRepSerializer extends JsonSerializer<CustSvcRep>{



	@Override
	public void serialize(CustSvcRep custSvcRep, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		jgen.writeStartObject();
		
		jgen.writeStringField("id",custSvcRep.getId());
		jgen.writeStringField("email",custSvcRep.getEmail());
		jgen.writeStringField("passwd",custSvcRep.getPasswd());
		writeRole("role",custSvcRep,jgen,provider);
		writeCompany("company",custSvcRep,jgen,provider);
		jgen.writeNumberField("version",custSvcRep.getVersion());
		
		jgen.writeEndObject();
	}
	
	protected void writeRole(String fieldName, CustSvcRep custSvcRep, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		Role role = custSvcRep.getRole();
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
	
	protected void writeCompany(String fieldName, CustSvcRep custSvcRep, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		SellerCompany company = custSvcRep.getCompany();
		if(company == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField("id",company.getId()); 
		jgen.writeStringField("name",company.getName()); 
		jgen.writeStringField("owner",company.getOwner()); 
		jgen.writeStringField("logo",company.getLogo()); 
		jgen.writeStringField("contractText",company.getContractText()); 
		jgen.writeNumberField("version",company.getVersion());
		jgen.writeEndObject();
		
	}
	
	
}


