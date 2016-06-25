
package com.terapico.b2b.order;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;



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


public class Order implements  java.io.Serializable{

	protected		String	mId;
	protected		BuyerCompany	mBuyer;
	protected		SellerCompany	mSeller;
	protected		String	mTitle;
	protected		double	mTotalAmount;
	protected		String	mType;
	protected		boolean	mMarkAsDelete;
	protected		Confirmation	mConfirmation;
	protected		Approval	mApproval;
	protected		Processing	mProcessing;
	protected		Shipment	mShipment;
	protected		Delivery	mDelivery;
	protected		int	mVersion;
	
	
	protected		List<LineItem> mLineItemList;
	protected		List<ShippingGroup> mShippingGroupList;
	protected		List<PaymentGroup> mPaymentGroupList;
	protected		List<Action> mActionList;
	
		
	public 	Order(){
		//lazy load for all the properties
	}
	
	public 	Order(BuyerCompany buyer, SellerCompany seller, String title, double totalAmount, String type, boolean markAsDelete)
	{
		setBuyer(buyer);
		setSeller(seller);
		setTitle(title);
		setTotalAmount(totalAmount);
		setType(type);
		setMarkAsDelete(markAsDelete);
		this.mLineItemList = new ArrayList<LineItem>();
		this.mShippingGroupList = new ArrayList<ShippingGroup>();
		this.mPaymentGroupList = new ArrayList<PaymentGroup>();
		this.mActionList = new ArrayList<Action>();	
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
	
	public void setTotalAmount(double totalAmount){
		this.mTotalAmount = totalAmount;
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
	
	public void setMarkAsDelete(boolean markAsDelete){
		this.mMarkAsDelete = markAsDelete;
	}
	public boolean getMarkAsDelete(){
		return this.mMarkAsDelete;
	}
	
	public void setConfirmation(Confirmation confirmation){
		this.mConfirmation = confirmation;
	}
	public Confirmation getConfirmation(){
		return this.mConfirmation;
	}
	
	public void setApproval(Approval approval){
		this.mApproval = approval;
	}
	public Approval getApproval(){
		return this.mApproval;
	}
	
	public void setProcessing(Processing processing){
		this.mProcessing = processing;
	}
	public Processing getProcessing(){
		return this.mProcessing;
	}
	
	public void setShipment(Shipment shipment){
		this.mShipment = shipment;
	}
	public Shipment getShipment(){
		return this.mShipment;
	}
	
	public void setDelivery(Delivery delivery){
		this.mDelivery = delivery;
	}
	public Delivery getDelivery(){
		return this.mDelivery;
	}
	
	public void setVersion(int version){
		this.mVersion = version;
	}
	public int getVersion(){
		return this.mVersion;
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
	
	public  void addLineItem(LineItem lineItem){
		lineItem.setBizOrder(this);
		getLineItemList().add(lineItem);
	}
	public  void addLineItems(List<LineItem> lineItemList){
		for( LineItem lineItem:lineItemList){
			lineItem.setBizOrder(this);
		}
		getLineItemList().addAll(lineItemList);
	}
	
	public  void removeLineItem(LineItem lineItem){
		getLineItemList().remove(lineItem);
	}
	public  void cleanUpLineItemList(){
		getLineItemList().clear();
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
	
	public  void addShippingGroup(ShippingGroup shippingGroup){
		shippingGroup.setBizOrder(this);
		getShippingGroupList().add(shippingGroup);
	}
	public  void addShippingGroups(List<ShippingGroup> shippingGroupList){
		for( ShippingGroup shippingGroup:shippingGroupList){
			shippingGroup.setBizOrder(this);
		}
		getShippingGroupList().addAll(shippingGroupList);
	}
	
	public  void removeShippingGroup(ShippingGroup shippingGroup){
		getShippingGroupList().remove(shippingGroup);
	}
	public  void cleanUpShippingGroupList(){
		getShippingGroupList().clear();
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
	
	public  void addPaymentGroup(PaymentGroup paymentGroup){
		paymentGroup.setBizOrder(this);
		getPaymentGroupList().add(paymentGroup);
	}
	public  void addPaymentGroups(List<PaymentGroup> paymentGroupList){
		for( PaymentGroup paymentGroup:paymentGroupList){
			paymentGroup.setBizOrder(this);
		}
		getPaymentGroupList().addAll(paymentGroupList);
	}
	
	public  void removePaymentGroup(PaymentGroup paymentGroup){
		getPaymentGroupList().remove(paymentGroup);
	}
	public  void cleanUpPaymentGroupList(){
		getPaymentGroupList().clear();
	}
	
	
	
	
	public  List<Action> getActionList(){
		if(this.mActionList == null){
			this.mActionList = new ArrayList<Action>();
		}
		return this.mActionList;	
	}
	public  void setActionList(List<Action> actionList){
		for( Action action:actionList){
			action.setBo(this);
		}
		
		
		this.mActionList = actionList;
		
	}
	
	public  void addAction(Action action){
		action.setBo(this);
		getActionList().add(action);
	}
	public  void addActions(List<Action> actionList){
		for( Action action:actionList){
			action.setBo(this);
		}
		getActionList().addAll(actionList);
	}
	
	public  void removeAction(Action action){
		getActionList().remove(action);
	}
	public  void cleanUpActionList(){
		getActionList().clear();
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
		stringBuilder.append("\tconfirmation='confirmation("+getConfirmation().getId()+")';");
		stringBuilder.append("\tapproval='approval("+getApproval().getId()+")';");
		stringBuilder.append("\tprocessing='processing("+getProcessing().getId()+")';");
		stringBuilder.append("\tshipment='shipment("+getShipment().getId()+")';");
		stringBuilder.append("\tdelivery='delivery("+getDelivery().getId()+")';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}

