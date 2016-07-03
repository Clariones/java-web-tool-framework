package json;

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
import com.terapico.b2b.shipment.Shipment;
import com.terapico.b2b.buyercompany.BuyerCompany;
import com.terapico.b2b.processing.Processing;
import com.terapico.b2b.lineitem.LineItem;
import com.terapico.b2b.paymentgroup.PaymentGroup;
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
		writeBuyer(order,jgen,provider);
		writeSeller(order,jgen,provider);
		jgen.writeStringField("title",order.getTitle());
		jgen.writeNumberField("totalAmount",order.getTotalAmount());
		jgen.writeStringField("type",order.getType());
		jgen.writeBooleanField("markAsDelete",order.getMarkAsDelete());
		//jgen.write
		writeConfirmation(order,jgen,provider);
		writeApproval(order,jgen,provider);
		writeProcessing(order,jgen,provider);
		writeShipment(order,jgen,provider);
		writeDelivery(order,jgen,provider);
		jgen.writeNumberField("version",order.getVersion());
		
		
		jgen.writeEndObject();
	}
	
	protected void writeBuyer(Order order, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
	
	}
	
	protected void writeSeller(Order order, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
	
	}
	
	protected void writeConfirmation(Order order, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
	
	}
	
	protected void writeApproval(Order order, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
	
	}
	
	protected void writeProcessing(Order order, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
	
	}
	
	protected void writeShipment(Order order, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
	
	}
	
	protected void writeDelivery(Order order, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
	
	}
	
	
}
