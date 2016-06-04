
package com.terapico.b2b.order;
import java.util.ArrayList;
import java.util.List;

import java.sql.Date;
import org.xml.sax.Attributes;


import com.terapico.b2b.buyercompany.BuyerCompany;
import com.terapico.b2b.lineitem.LineItem;
import com.terapico.b2b.paymentgroup.PaymentGroup;
import com.terapico.b2b.sellercompany.SellerCompany;
import com.terapico.b2b.shippinggroup.ShippingGroup;


public class Order implements  java.io.Serializable{

	protected		String	mId;
	protected		BuyerCompany	mBuyer;
	protected		SellerCompany	mSeller;
	protected		String	mTitle;
	protected		double	mTotalAmount;
	protected		String	mType;
	protected		boolean	mMarkAsDelete;
	protected		int	mxVersion;
	
	
	protected		List<LineItem> mLineItemList;
	protected		List<ShippingGroup> mShippingGroupList;
	protected		List<PaymentGroup> mPaymentGroupList;
	
		
	public 	Order(){

	}
	
	public 	Order(String	id,BuyerCompany	buyer,SellerCompany	seller,String	title,double	total_amount,String	type,boolean	mark_as_delete,int	version)
	{
		setId(id);
		setBuyer(buyer);
		setSeller(seller);
		setTitle(title);
		setTotalAmount(total_amount);
		setType(type);
		setMarkAsDelete(mark_as_delete);
		setVersion(version);
		this.mLineItemList = new ArrayList<LineItem>();
		this.mShippingGroupList = new ArrayList<ShippingGroup>();
		this.mPaymentGroupList = new ArrayList<PaymentGroup>();	
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
	
	public void setMarkAsDelete(boolean mark_as_delete){
		this.mMarkAsDelete = mark_as_delete;
	}
	public boolean getMarkAsDelete(){
		return this.mMarkAsDelete;
	}
	
	public void setVersion(int version){
		this.mxVersion = version;
	}
	public int getVersion(){
		return this.mxVersion;
	}
	
	public  List<LineItem> getLineItemList(){
		if(this.mLineItemList == null){
			this.mLineItemList = new ArrayList<LineItem>();
		}
		return this.mLineItemList;	
	}
	public  void setLineItemList(List<LineItem> lineItemList){
		for( LineItem lineItem:lineItemList){
			lineItem.setBizOrder(this);
		}
		
		
		this.mLineItemList = lineItemList;
		
	}
	
	public  void addLineItem(LineItem line_item){
		line_item.setBizOrder(this);
		getLineItemList().add(line_item);
	}
	public  void addLineItems(List<LineItem> lineItemList){
		for( LineItem lineItem:lineItemList){
			lineItem.setBizOrder(this);
		}
		getLineItemList().addAll(lineItemList);
	}
	
	public  void removeLineItem(LineItem line_item){
		getLineItemList().remove(line_item);
	}
	
	
	
	
	
	public  List<ShippingGroup> getShippingGroupList(){
		if(this.mShippingGroupList == null){
			this.mShippingGroupList = new ArrayList<ShippingGroup>();
		}
		return this.mShippingGroupList;	
	}
	public  void setShippingGroupList(List<ShippingGroup> shippingGroupList){
		for( ShippingGroup shippingGroup:shippingGroupList){
			shippingGroup.setBizOrder(this);
		}
		
		
		this.mShippingGroupList = shippingGroupList;
		
	}
	
	public  void addShippingGroup(ShippingGroup shipping_group){
		shipping_group.setBizOrder(this);
		getShippingGroupList().add(shipping_group);
	}
	public  void addShippingGroups(List<ShippingGroup> shippingGroupList){
		for( ShippingGroup shippingGroup:shippingGroupList){
			shippingGroup.setBizOrder(this);
		}
		getShippingGroupList().addAll(shippingGroupList);
	}
	
	public  void removeShippingGroup(ShippingGroup shipping_group){
		getShippingGroupList().remove(shipping_group);
	}
	
	
	
	
	
	public  List<PaymentGroup> getPaymentGroupList(){
		if(this.mPaymentGroupList == null){
			this.mPaymentGroupList = new ArrayList<PaymentGroup>();
		}
		return this.mPaymentGroupList;	
	}
	public  void setPaymentGroupList(List<PaymentGroup> paymentGroupList){
		for( PaymentGroup paymentGroup:paymentGroupList){
			paymentGroup.setBizOrder(this);
		}
		
		
		this.mPaymentGroupList = paymentGroupList;
		
	}
	
	public  void addPaymentGroup(PaymentGroup payment_group){
		payment_group.setBizOrder(this);
		getPaymentGroupList().add(payment_group);
	}
	public  void addPaymentGroups(List<PaymentGroup> paymentGroupList){
		for( PaymentGroup paymentGroup:paymentGroupList){
			paymentGroup.setBizOrder(this);
		}
		getPaymentGroupList().addAll(paymentGroupList);
	}
	
	public  void removePaymentGroup(PaymentGroup payment_group){
		getPaymentGroupList().remove(payment_group);
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
		stringBuilder.append("\tmark_as_delete='"+getMarkAsDelete()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}

