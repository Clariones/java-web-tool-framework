
package com.terapico.b2b.paymentgroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;



import com.terapico.b2b.order.Order;
import com.terapico.b2b.billingaddress.BillingAddress;


public class PaymentGroup implements  java.io.Serializable{

	protected		String	mId;
	protected		String	mName;
	protected		Order	mBizOrder;
	protected		String	mCardNumber;
	protected		BillingAddress	mBillingAddress;
	protected		int	mVersion;
	
	
	
		
	public 	PaymentGroup(){
		//lazy load for all the properties
	}
	
	public 	PaymentGroup(String name, Order bizOrder, String cardNumber, BillingAddress billingAddress)
	{
		setName(name);
		setBizOrder(bizOrder);
		setCardNumber(cardNumber);
		setBillingAddress(billingAddress);	
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
	
	public void setBizOrder(Order bizOrder){
		this.mBizOrder = bizOrder;
	}
	public Order getBizOrder(){
		return this.mBizOrder;
	}
	
	public void setCardNumber(String cardNumber){
		this.mCardNumber = cardNumber;
	}
	public String getCardNumber(){
		return this.mCardNumber;
	}
	
	public void setBillingAddress(BillingAddress billingAddress){
		this.mBillingAddress = billingAddress;
	}
	public BillingAddress getBillingAddress(){
		return this.mBillingAddress;
	}
	
	public void setVersion(int version){
		this.mVersion = version;
	}
	public int getVersion(){
		return this.mVersion;
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

