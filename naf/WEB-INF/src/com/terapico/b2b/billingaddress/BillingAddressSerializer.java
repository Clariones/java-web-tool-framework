
package com.terapico.b2b.billingaddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.terapico.b2b.billingaddress.BillingAddress;

import com.terapico.b2b.buyercompany.BuyerCompany;
import com.terapico.b2b.paymentgroup.PaymentGroup;


public class BillingAddressSerializer extends JsonSerializer<BillingAddress>{



	@Override
	public void serialize(BillingAddress billingAddress, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		jgen.writeStartObject();
		
		jgen.writeStringField("id",billingAddress.getId());
		writeCompany("company",billingAddress,jgen,provider);
		jgen.writeStringField("line1",billingAddress.getLine1());
		jgen.writeStringField("line2",billingAddress.getLine2());
		jgen.writeStringField("city",billingAddress.getCity());
		jgen.writeStringField("state",billingAddress.getState());
		jgen.writeStringField("country",billingAddress.getCountry());
		jgen.writeNumberField("version",billingAddress.getVersion());
		writePaymentGroupList("paymentGroupList",billingAddress,jgen,provider);
		
		jgen.writeEndObject();
	}
	
	protected void writeCompany(String fieldName, BillingAddress billingAddress, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		BuyerCompany company = billingAddress.getCompany();
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
	
	protected void writePaymentGroupList(String fieldName, BillingAddress billingAddress, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<PaymentGroup> paymentGroupList = billingAddress.getPaymentGroupList();
		
		if(paymentGroupList == null){
			return;//do nothing when null found for this field.
		}
		if(paymentGroupList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(PaymentGroup paymentGroup: paymentGroupList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField("id",paymentGroup.getId());
			jgen.writeStringField("name",paymentGroup.getName());
			jgen.writeStringField("cardNumber",paymentGroup.getCardNumber());
			jgen.writeNumberField("version",paymentGroup.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


