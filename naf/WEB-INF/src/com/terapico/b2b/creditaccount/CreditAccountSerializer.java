
package com.terapico.b2b.creditaccount;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.terapico.b2b.creditaccount.CreditAccount;

import com.terapico.b2b.buyercompany.BuyerCompany;
import com.terapico.b2b.sellercompany.SellerCompany;


public class CreditAccountSerializer extends JsonSerializer<CreditAccount>{



	@Override
	public void serialize(CreditAccount creditAccount, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		jgen.writeStartObject();
		
		jgen.writeStringField("id",creditAccount.getId());
		jgen.writeStringField("name",creditAccount.getName());
		writeBuyer("buyer",creditAccount,jgen,provider);
		writeSeller("seller",creditAccount,jgen,provider);
		jgen.writeNumberField("authorized",creditAccount.getAuthorized());
		jgen.writeNumberField("remain",creditAccount.getRemain());
		jgen.writeNumberField("version",creditAccount.getVersion());
		
		jgen.writeEndObject();
	}
	
	protected void writeBuyer(String fieldName, CreditAccount creditAccount, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		BuyerCompany buyer = creditAccount.getBuyer();
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
	
	protected void writeSeller(String fieldName, CreditAccount creditAccount, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		SellerCompany seller = creditAccount.getSeller();
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
	
	
}


