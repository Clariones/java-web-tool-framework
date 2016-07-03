
package com.terapico.b2b.sellercompany;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.terapico.b2b.sellercompany.SellerCompany;

import com.terapico.b2b.order.Order;
import com.terapico.b2b.creditaccount.CreditAccount;
import com.terapico.b2b.custsvcrep.CustSvcRep;
import com.terapico.b2b.profitcenter.ProfitCenter;


public class SellerCompanySerializer extends JsonSerializer<SellerCompany>{



	@Override
	public void serialize(SellerCompany sellerCompany, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		jgen.writeStartObject();
		
		jgen.writeStringField("id",sellerCompany.getId());
		jgen.writeStringField("name",sellerCompany.getName());
		jgen.writeStringField("owner",sellerCompany.getOwner());
		jgen.writeStringField("logo",sellerCompany.getLogo());
		jgen.writeStringField("contractText",sellerCompany.getContractText());
		jgen.writeNumberField("version",sellerCompany.getVersion());
		writeProfitCenterList("profitCenterList",sellerCompany,jgen,provider);
		writeCreditAccountList("creditAccountList",sellerCompany,jgen,provider);
		writeOrderList("orderList",sellerCompany,jgen,provider);
		writeCustSvcRepList("custSvcRepList",sellerCompany,jgen,provider);
		
		jgen.writeEndObject();
	}
	
	protected void writeProfitCenterList(String fieldName, SellerCompany sellerCompany, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<ProfitCenter> profitCenterList = sellerCompany.getProfitCenterList();
		
		if(profitCenterList == null){
			return;//do nothing when null found for this field.
		}
		if(profitCenterList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(ProfitCenter profitCenter: profitCenterList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField("id",profitCenter.getId());
			jgen.writeStringField("name",profitCenter.getName());
			jgen.writeNumberField("version",profitCenter.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeCreditAccountList(String fieldName, SellerCompany sellerCompany, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<CreditAccount> creditAccountList = sellerCompany.getCreditAccountList();
		
		if(creditAccountList == null){
			return;//do nothing when null found for this field.
		}
		if(creditAccountList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(CreditAccount creditAccount: creditAccountList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField("id",creditAccount.getId());
			jgen.writeStringField("name",creditAccount.getName());
			jgen.writeNumberField("authorized",creditAccount.getAuthorized());
			jgen.writeNumberField("remain",creditAccount.getRemain());
			jgen.writeNumberField("version",creditAccount.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeOrderList(String fieldName, SellerCompany sellerCompany, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<Order> orderList = sellerCompany.getOrderList();
		
		if(orderList == null){
			return;//do nothing when null found for this field.
		}
		if(orderList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(Order order: orderList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField("id",order.getId());
			jgen.writeStringField("title",order.getTitle());
			jgen.writeNumberField("totalAmount",order.getTotalAmount());
			jgen.writeStringField("type",order.getType());
			jgen.writeBooleanField("markAsDelete",order.getMarkAsDelete());
			jgen.writeStringField("status",order.getStatus());
			jgen.writeNumberField("version",order.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeCustSvcRepList(String fieldName, SellerCompany sellerCompany, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<CustSvcRep> custSvcRepList = sellerCompany.getCustSvcRepList();
		
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


