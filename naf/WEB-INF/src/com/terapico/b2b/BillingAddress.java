
package com.terapico.b2b;
import java.util.ArrayList;
import java.util.List;

import java.sql.Date;
import org.xml.sax.Attributes;
public class BillingAddress implements  java.io.Serializable{

	protected		String	mId;
	protected		BuyerCompany	mCompany;
	protected		String	mLine1;
	protected		String	mLine2;
	protected		String	mCity;
	protected		String	mState;
	protected		String	mCountry;
	protected		int	mxVersion;
	
	
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
		this.mxVersion = version;
	}
	public int getVersion(){
		return this.mxVersion;
	}
	
	public  List<PaymentGroup> getPaymentGroupList(){
		if(this.mPaymentGroupList == null){
			this.mPaymentGroupList = new ArrayList<PaymentGroup>();
		}
		return this.mPaymentGroupList;	
	}
	public  void setPaymentGroupList(List<PaymentGroup> PaymentGroups){
		this.mPaymentGroupList=PaymentGroups;
		
	}
	
	public  void addPaymentGroup(PaymentGroup payment_group){
		getPaymentGroupList().add(payment_group);
	}
	public  void addPaymentGroups(List<PaymentGroup> payment_groups){
		getPaymentGroupList().addAll(payment_groups);
	}
	
	public  void removePaymentGroup(PaymentGroup payment_group){
		getPaymentGroupList().remove(payment_group);
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

