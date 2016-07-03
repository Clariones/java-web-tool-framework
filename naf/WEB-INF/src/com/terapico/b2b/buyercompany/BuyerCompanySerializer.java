
package com.terapico.b2b.buyercompany;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.terapico.b2b.buyercompany.BuyerCompany;

import com.terapico.b2b.order.Order;
import com.terapico.b2b.creditaccount.CreditAccount;
import com.terapico.b2b.billingaddress.BillingAddress;
import com.terapico.b2b.costcenter.CostCenter;
import com.terapico.b2b.employee.Employee;


public class BuyerCompanySerializer extends JsonSerializer<BuyerCompany>{



	@Override
	public void serialize(BuyerCompany buyerCompany, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		jgen.writeStartObject();
		
		jgen.writeStringField("id",buyerCompany.getId());
		jgen.writeStringField("name",buyerCompany.getName());
		jgen.writeStringField("priceList",buyerCompany.getPriceList());
		jgen.writeNumberField("rating",buyerCompany.getRating());
		jgen.writeStringField("logo",buyerCompany.getLogo());
		jgen.writeStringField("owner",buyerCompany.getOwner());
		jgen.writeNumberField("version",buyerCompany.getVersion());
		writeCostCenterList("costCenterList",buyerCompany,jgen,provider);
		writeCreditAccountList("creditAccountList",buyerCompany,jgen,provider);
		writeBillingAddressList("billingAddressList",buyerCompany,jgen,provider);
		writeEmployeeList("employeeList",buyerCompany,jgen,provider);
		writeOrderList("orderList",buyerCompany,jgen,provider);
		
		jgen.writeEndObject();
	}
	
	protected void writeCostCenterList(String fieldName, BuyerCompany buyerCompany, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<CostCenter> costCenterList = buyerCompany.getCostCenterList();
		
		if(costCenterList == null){
			return;//do nothing when null found for this field.
		}
		if(costCenterList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(CostCenter costCenter: costCenterList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField("id",costCenter.getId());
			jgen.writeStringField("name",costCenter.getName());
			jgen.writeNumberField("version",costCenter.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeCreditAccountList(String fieldName, BuyerCompany buyerCompany, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<CreditAccount> creditAccountList = buyerCompany.getCreditAccountList();
		
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
	protected void writeBillingAddressList(String fieldName, BuyerCompany buyerCompany, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<BillingAddress> billingAddressList = buyerCompany.getBillingAddressList();
		
		if(billingAddressList == null){
			return;//do nothing when null found for this field.
		}
		if(billingAddressList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(BillingAddress billingAddress: billingAddressList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField("id",billingAddress.getId());
			jgen.writeStringField("line1",billingAddress.getLine1());
			jgen.writeStringField("line2",billingAddress.getLine2());
			jgen.writeStringField("city",billingAddress.getCity());
			jgen.writeStringField("state",billingAddress.getState());
			jgen.writeStringField("country",billingAddress.getCountry());
			jgen.writeNumberField("version",billingAddress.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeEmployeeList(String fieldName, BuyerCompany buyerCompany, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<Employee> employeeList = buyerCompany.getEmployeeList();
		
		if(employeeList == null){
			return;//do nothing when null found for this field.
		}
		if(employeeList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(Employee employee: employeeList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField("id",employee.getId());
			jgen.writeStringField("name",employee.getName());
			jgen.writeStringField("email",employee.getEmail());
			jgen.writeStringField("passwd",employee.getPasswd());
			jgen.writeStringField("cellPhone",employee.getCellPhone());
			jgen.writeNumberField("version",employee.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeOrderList(String fieldName, BuyerCompany buyerCompany, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<Order> orderList = buyerCompany.getOrderList();
		
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
	
}


