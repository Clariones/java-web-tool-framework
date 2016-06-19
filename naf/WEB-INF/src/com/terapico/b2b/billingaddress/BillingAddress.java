
package com.terapico.b2b.billingaddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;



import com.terapico.b2b.buyercompany.BuyerCompany;
import com.terapico.b2b.paymentgroup.PaymentGroup;


public class BillingAddress implements  java.io.Serializable{

	protected		String	mId;
	protected		BuyerCompany	mCompany;
	protected		String	mLine1;
	protected		String	mLine2;
	protected		String	mCity;
	protected		String	mState;
	protected		String	mCountry;
	protected		int	mVersion;
	
	
	protected		List<PaymentGroup> mPaymentGroupList;
	
		
	public 	BillingAddress(){

	}
	
	public 	BillingAddress(String	id,BuyerCompany	company,String	line1,String	line2,String	city,String	state,String	country,int	version)
	{
		setId(id);
		setCompany(company);
		setLine1(line1);
		setLine2(line2);
		setCity(city);
		setState(state);
		setCountry(country);
		setVersion(version);
		this.mPaymentGroupList = new ArrayList<PaymentGroup>();	
	}
	

	
	public void setId(String id){
		this.mId = id;
	}
	public String getId(){
		return this.mId;
	}
	
	public void setCompany(BuyerCompany company){
		this.mCompany = company;
	}
	public BuyerCompany getCompany(){
		return this.mCompany;
	}
	
	public void setLine1(String line1){
		this.mLine1 = line1;
	}
	public String getLine1(){
		return this.mLine1;
	}
	
	public void setLine2(String line2){
		this.mLine2 = line2;
	}
	public String getLine2(){
		return this.mLine2;
	}
	
	public void setCity(String city){
		this.mCity = city;
	}
	public String getCity(){
		return this.mCity;
	}
	
	public void setState(String state){
		this.mState = state;
	}
	public String getState(){
		return this.mState;
	}
	
	public void setCountry(String country){
		this.mCountry = country;
	}
	public String getCountry(){
		return this.mCountry;
	}
	
	public void setVersion(int version){
		this.mVersion = version;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	public  List<PaymentGroup> getPaymentGroupList(){
		if(this.mPaymentGroupList == null){
			this.mPaymentGroupList = new ArrayList<PaymentGroup>();
		}
		return this.mPaymentGroupList;	
	}
	public  void setPaymentGroupList(List<PaymentGroup> paymentGroupList){
		for( PaymentGroup paymentGroup:paymentGroupList){
			paymentGroup.setBillingAddress(this);
		}
		
		
		this.mPaymentGroupList = paymentGroupList;
		
	}
	
	public  void addPaymentGroup(PaymentGroup payment_group){
		payment_group.setBillingAddress(this);
		getPaymentGroupList().add(payment_group);
	}
	public  void addPaymentGroups(List<PaymentGroup> paymentGroupList){
		for( PaymentGroup paymentGroup:paymentGroupList){
			paymentGroup.setBillingAddress(this);
		}
		getPaymentGroupList().addAll(paymentGroupList);
	}
	
	public  void removePaymentGroup(PaymentGroup payment_group){
		getPaymentGroupList().remove(payment_group);
	}
	public  void cleanUpPaymentGroupList(){
		getPaymentGroupList().clear();
	}
	
	
	
	
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("billing_address{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tcompany='buyer_company("+getCompany().getId()+")';");
		stringBuilder.append("\tline1='"+getLine1()+"';");
		stringBuilder.append("\tline2='"+getLine2()+"';");
		stringBuilder.append("\tcity='"+getCity()+"';");
		stringBuilder.append("\tstate='"+getState()+"';");
		stringBuilder.append("\tcountry='"+getCountry()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}

