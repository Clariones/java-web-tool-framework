
package com.terapico.b2b;
import java.util.ArrayList;
import java.util.List;

import java.sql.Date;
import org.xml.sax.Attributes;
public class Order implements  java.io.Serializable{

	protected		String	mId;
	protected		BuyerCompany	mBuyer;
	protected		SellerCompany	mSeller;
	protected		String	mTitle;
	protected		double	mTotalAmount;
	protected		String	mType;
	protected		int	mxVersion;
	
	
	protected		List<PaymentGroup> mPaymentGroupList;
	protected		List<ShippingGroup> mShippingGroupList;
	protected		List<LineItem> mLineItemList;
	
		
	public 	Order(){

	}
	
	public 	Order(String	id,BuyerCompany	buyer,SellerCompany	seller,String	title,double	total_amount,String	type,int	version)
	{
		setId(id);
		setBuyer(buyer);
		setSeller(seller);
		setTitle(title);
		setTotalAmount(total_amount);
		setType(type);
		setVersion(version);
		this.mPaymentGroupList = new ArrayList<PaymentGroup>();
		this.mShippingGroupList = new ArrayList<ShippingGroup>();
		this.mLineItemList = new ArrayList<LineItem>();	
	}
	

	
	public void setId(String id){
		this.mId = id;
	}
	public String getId(){
		return this.mId;
	}
	
	public void setBuyer(BuyerCompany buyer){
		this.mBuyer = buyer;
	}
	public BuyerCompany getBuyer(){
		return this.mBuyer;
	}
	
	public void setSeller(SellerCompany seller){
		this.mSeller = seller;
	}
	public SellerCompany getSeller(){
		return this.mSeller;
	}
	
	public void setTitle(String title){
		this.mTitle = title;
	}
	public String getTitle(){
		return this.mTitle;
	}
	
	public void setTotalAmount(double total_amount){
		this.mTotalAmount = total_amount;
	}
	public double getTotalAmount(){
		return this.mTotalAmount;
	}
	
	public void setType(String type){
		this.mType = type;
	}
	public String getType(){
		return this.mType;
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
	
	
	
	
	
	public  List<ShippingGroup> getShippingGroupList(){
		if(this.mShippingGroupList == null){
			this.mShippingGroupList = new ArrayList<ShippingGroup>();
		}
		return this.mShippingGroupList;	
	}
	public  void setShippingGroupList(List<ShippingGroup> ShippingGroups){
		this.mShippingGroupList=ShippingGroups;
		
	}
	
	public  void addShippingGroup(ShippingGroup shipping_group){
		getShippingGroupList().add(shipping_group);
	}
	public  void addShippingGroups(List<ShippingGroup> shipping_groups){
		getShippingGroupList().addAll(shipping_groups);
	}
	
	public  void removeShippingGroup(ShippingGroup shipping_group){
		getShippingGroupList().remove(shipping_group);
	}
	
	
	
	
	
	public  List<LineItem> getLineItemList(){
		if(this.mLineItemList == null){
			this.mLineItemList = new ArrayList<LineItem>();
		}
		return this.mLineItemList;	
	}
	public  void setLineItemList(List<LineItem> LineItems){
		this.mLineItemList=LineItems;
		
	}
	
	public  void addLineItem(LineItem line_item){
		getLineItemList().add(line_item);
	}
	public  void addLineItems(List<LineItem> line_items){
		getLineItemList().addAll(line_items);
	}
	
	public  void removeLineItem(LineItem line_item){
		getLineItemList().remove(line_item);
	}
	
	
	
	
	
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("order{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tbuyer='buyer_company("+getBuyer().getId()+")';");
		stringBuilder.append("\tseller='seller_company("+getSeller().getId()+")';");
		stringBuilder.append("\ttitle='"+getTitle()+"';");
		stringBuilder.append("\ttotal_amount='"+getTotalAmount()+"';");
		stringBuilder.append("\ttype='"+getType()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}

