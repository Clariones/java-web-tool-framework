
package com.terapico.b2b.paymentgroup;
import java.util.ArrayList;
import java.util.List;

import java.sql.Date;
import org.xml.sax.Attributes;


import com.terapico.b2b.order.Order;
import com.terapico.b2b.billingaddress.BillingAddress;


public class PaymentGroup implements  java.io.Serializable{

	protected		String	mId;
	protected		String	mName;
	protected		Order	mBizOrder;
	protected		String	mCardNumber;
	protected		BillingAddress	mBillingAddress;
	protected		int	mxVersion;
	
	
	
		
	public 	PaymentGroup(){

	}
	
	public 	PaymentGroup(String	id,String	name,Order	biz_order,String	card_number,BillingAddress	billing_address,int	version)
	{
		setId(id);
		setName(name);
		setBizOrder(biz_order);
		setCardNumber(card_number);
		setBillingAddress(billing_address);
		setVersion(version);	
	}
	

	
	public void setId(String id){
		this.mId = id;
	}
	public String getId(){
		return this.mId;
	}
	
	public void setName(String name){
		this.mName = name;
	}
	public String getName(){
		return this.mName;
	}
	
	public void setBizOrder(Order biz_order){
		this.mBizOrder = biz_order;
	}
	public Order getBizOrder(){
		return this.mBizOrder;
	}
	
	public void setCardNumber(String card_number){
		this.mCardNumber = card_number;
	}
	public String getCardNumber(){
		return this.mCardNumber;
	}
	
	public void setBillingAddress(BillingAddress billing_address){
		this.mBillingAddress = billing_address;
	}
	public BillingAddress getBillingAddress(){
		return this.mBillingAddress;
	}
	
	public void setVersion(int version){
		this.mxVersion = version;
	}
	public int getVersion(){
		return this.mxVersion;
	}
	
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("payment_group{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tbiz_order='order("+getBizOrder().getId()+")';");
		stringBuilder.append("\tcard_number='"+getCardNumber()+"';");
		stringBuilder.append("\tbilling_address='billing_address("+getBillingAddress().getId()+")';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}

