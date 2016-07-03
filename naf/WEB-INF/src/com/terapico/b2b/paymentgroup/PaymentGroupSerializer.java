
package com.terapico.b2b.paymentgroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.terapico.b2b.paymentgroup.PaymentGroup;

import com.terapico.b2b.order.Order;
import com.terapico.b2b.billingaddress.BillingAddress;


public class PaymentGroupSerializer extends JsonSerializer<PaymentGroup>{



	@Override
	public void serialize(PaymentGroup paymentGroup, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		jgen.writeStartObject();
		
		jgen.writeStringField("id",paymentGroup.getId());
		jgen.writeStringField("name",paymentGroup.getName());
		writeBizOrder("bizOrder",paymentGroup,jgen,provider);
		jgen.writeStringField("cardNumber",paymentGroup.getCardNumber());
		writeBillingAddress("billingAddress",paymentGroup,jgen,provider);
		jgen.writeNumberField("version",paymentGroup.getVersion());
		
		jgen.writeEndObject();
	}
	
	protected void writeBizOrder(String fieldName, PaymentGroup paymentGroup, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		Order bizOrder = paymentGroup.getBizOrder();
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
	
	protected void writeBillingAddress(String fieldName, PaymentGroup paymentGroup, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		BillingAddress billingAddress = paymentGroup.getBillingAddress();
		if(billingAddress == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField("id",billingAddress.getId()); 
		jgen.writeStringField("line1",billingAddress.getLine1()); 
		jgen.writeStringField("line2",billingAddress.getLine2()); 
		jgen.writeStringField("city",billingAddress.getCity()); 
		jgen.writeStringField("state",billingAddress.getState()); 
		jgen.writeStringField("country",billingAddress.getCountry()); 
		jgen.writeNumberField("version",billingAddress.getVersion());
		jgen.writeEndObject();
		
	}
	
	
}


