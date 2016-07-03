
package com.terapico.b2b.order;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.terapico.b2b.order.Order;

import com.terapico.b2b.approval.Approval;
import com.terapico.b2b.confirmation.Confirmation;
import com.terapico.b2b.recurringinfo.RecurringInfo;
import com.terapico.b2b.shipment.Shipment;
import com.terapico.b2b.buyercompany.BuyerCompany;
import com.terapico.b2b.processing.Processing;
import com.terapico.b2b.lineitem.LineItem;
import com.terapico.b2b.paymentgroup.PaymentGroup;
import com.terapico.b2b.costcenter.CostCenter;
import com.terapico.b2b.profitcenter.ProfitCenter;
import com.terapico.b2b.action.Action;
import com.terapico.b2b.delivery.Delivery;
import com.terapico.b2b.sellercompany.SellerCompany;
import com.terapico.b2b.shippinggroup.ShippingGroup;


public class OrderSerializer extends JsonSerializer<Order>{



	@Override
	public void serialize(Order order, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		jgen.writeStartObject();
		
		jgen.writeStringField("id",order.getId());
		writeBuyer("buyer",order,jgen,provider);
		writeSeller("seller",order,jgen,provider);
		jgen.writeStringField("title",order.getTitle());
		writeCostCenter("costCenter",order,jgen,provider);
		writeProfitCenter("profitCenter",order,jgen,provider);
		jgen.writeNumberField("totalAmount",order.getTotalAmount());
		jgen.writeStringField("type",order.getType());
		jgen.writeBooleanField("markAsDelete",order.getMarkAsDelete());
		writeConfirmation("confirmation",order,jgen,provider);
		writeApproval("approval",order,jgen,provider);
		writeProcessing("processing",order,jgen,provider);
		writeShipment("shipment",order,jgen,provider);
		writeDelivery("delivery",order,jgen,provider);
		writeRecurringInfo("recurringInfo",order,jgen,provider);
		jgen.writeStringField("status",order.getStatus());
		jgen.writeNumberField("version",order.getVersion());
		writeLineItemList("lineItemList",order,jgen,provider);
		writeShippingGroupList("shippingGroupList",order,jgen,provider);
		writePaymentGroupList("paymentGroupList",order,jgen,provider);
		writeActionList("actionList",order,jgen,provider);
		
		jgen.writeEndObject();
	}
	
	protected void writeBuyer(String fieldName, Order order, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		BuyerCompany buyer = order.getBuyer();
		if(buyer == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField("id",buyer.getId()); 
		jgen.writeStringField("name",buyer.getName()); 
		jgen.writeStringField("priceList",buyer.getPriceList()); 
		jgen.writeNumberField("rating",buyer.getRating()); 
		jgen.writeStringField("logo",buyer.getLogo()); 
		jgen.writeStringField("owner",buyer.getOwner()); 
		jgen.writeNumberField("version",buyer.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeSeller(String fieldName, Order order, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		SellerCompany seller = order.getSeller();
		if(seller == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField("id",seller.getId()); 
		jgen.writeStringField("name",seller.getName()); 
		jgen.writeStringField("owner",seller.getOwner()); 
		jgen.writeStringField("logo",seller.getLogo()); 
		jgen.writeStringField("contractText",seller.getContractText()); 
		jgen.writeNumberField("version",seller.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeCostCenter(String fieldName, Order order, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		CostCenter costCenter = order.getCostCenter();
		if(costCenter == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField("id",costCenter.getId()); 
		jgen.writeStringField("name",costCenter.getName()); 
		jgen.writeNumberField("version",costCenter.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeProfitCenter(String fieldName, Order order, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		ProfitCenter profitCenter = order.getProfitCenter();
		if(profitCenter == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField("id",profitCenter.getId()); 
		jgen.writeStringField("name",profitCenter.getName()); 
		jgen.writeNumberField("version",profitCenter.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeConfirmation(String fieldName, Order order, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		Confirmation confirmation = order.getConfirmation();
		if(confirmation == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField("id",confirmation.getId()); 
		jgen.writeStringField("who",confirmation.getWho()); 
		jgen.writeObjectField("confirmTime",confirmation.getConfirmTime()); 
		jgen.writeNumberField("version",confirmation.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeApproval(String fieldName, Order order, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		Approval approval = order.getApproval();
		if(approval == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField("id",approval.getId()); 
		jgen.writeStringField("who",approval.getWho()); 
		jgen.writeObjectField("approveTime",approval.getApproveTime()); 
		jgen.writeNumberField("version",approval.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeProcessing(String fieldName, Order order, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		Processing processing = order.getProcessing();
		if(processing == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField("id",processing.getId()); 
		jgen.writeStringField("who",processing.getWho()); 
		jgen.writeObjectField("processTime",processing.getProcessTime()); 
		jgen.writeNumberField("version",processing.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeShipment(String fieldName, Order order, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		Shipment shipment = order.getShipment();
		if(shipment == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField("id",shipment.getId()); 
		jgen.writeStringField("who",shipment.getWho()); 
		jgen.writeObjectField("shipTime",shipment.getShipTime()); 
		jgen.writeNumberField("version",shipment.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeDelivery(String fieldName, Order order, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		Delivery delivery = order.getDelivery();
		if(delivery == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField("id",delivery.getId()); 
		jgen.writeStringField("who",delivery.getWho()); 
		jgen.writeObjectField("deliveryTime",delivery.getDeliveryTime()); 
		jgen.writeNumberField("version",delivery.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeRecurringInfo(String fieldName, Order order, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RecurringInfo recurringInfo = order.getRecurringInfo();
		if(recurringInfo == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField("id",recurringInfo.getId()); 
		jgen.writeStringField("name",recurringInfo.getName()); 
		jgen.writeObjectField("nextTime",recurringInfo.getNextTime()); 
		jgen.writeStringField("cronExpr",recurringInfo.getCronExpr()); 
		jgen.writeNumberField("version",recurringInfo.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeLineItemList(String fieldName, Order order, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<LineItem> lineItemList = order.getLineItemList();
		
		if(lineItemList == null){
			return;//do nothing when null found for this field.
		}
		if(lineItemList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(LineItem lineItem: lineItemList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField("id",lineItem.getId());
			jgen.writeStringField("skuId",lineItem.getSkuId());
			jgen.writeStringField("skuName",lineItem.getSkuName());
			jgen.writeNumberField("amount",lineItem.getAmount());
			jgen.writeNumberField("quantity",lineItem.getQuantity());
			jgen.writeBooleanField("active",lineItem.getActive());
			jgen.writeNumberField("version",lineItem.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeShippingGroupList(String fieldName, Order order, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<ShippingGroup> shippingGroupList = order.getShippingGroupList();
		
		if(shippingGroupList == null){
			return;//do nothing when null found for this field.
		}
		if(shippingGroupList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(ShippingGroup shippingGroup: shippingGroupList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField("id",shippingGroup.getId());
			jgen.writeStringField("name",shippingGroup.getName());
			jgen.writeNumberField("amount",shippingGroup.getAmount());
			jgen.writeNumberField("version",shippingGroup.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writePaymentGroupList(String fieldName, Order order, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<PaymentGroup> paymentGroupList = order.getPaymentGroupList();
		
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
	protected void writeActionList(String fieldName, Order order, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<Action> actionList = order.getActionList();
		
		if(actionList == null){
			return;//do nothing when null found for this field.
		}
		if(actionList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(Action action: actionList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField("id",action.getId());
			jgen.writeStringField("name",action.getName());
			jgen.writeStringField("internalName",action.getInternalName());
			jgen.writeNumberField("version",action.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


