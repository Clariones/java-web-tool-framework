
package com.terapico.b2b.order;
import com.terapico.b2b.CommonTokens;
import java.util.Map;
public class OrderTokens extends CommonTokens{

	
	public static OrderTokens start(){
		return new OrderTokens();
	}
	public static Map <String,Object> all(){
		return new OrderTokens()
			.withBuyer()
			.withSeller()
			.withCostCenter()
			.withProfitCenter()
			.withConfirmation()
			.withApproval()
			.withProcessing()
			.withShipment()
			.withDelivery()
			.withRecurringInfo()
			.withLineItemList()
			.withShippingGroupList()
			.withPaymentGroupList()
			.withActionList()
			.done();
	}
	public static Map <String,Object> withOutLists(){
		return new OrderTokens()
			.withBuyer()
			.withSeller()
			.withCostCenter()
			.withProfitCenter()
			.withConfirmation()
			.withApproval()
			.withProcessing()
			.withShipment()
			.withDelivery()
			.withRecurringInfo()
			.done();
	}
	public static Map <String,Object> empty(){
		return new OrderTokens()
			.done();
	}

	protected static final String BUYER = "buyer";
	public String getBuyer(){
		return BUYER;
	}
	public OrderTokens withBuyer(){		
		addSimpleOptions(BUYER);
		return this;
	}
	
	
	protected static final String SELLER = "seller";
	public String getSeller(){
		return SELLER;
	}
	public OrderTokens withSeller(){		
		addSimpleOptions(SELLER);
		return this;
	}
	
	
	protected static final String COSTCENTER = "costCenter";
	public String getCostCenter(){
		return COSTCENTER;
	}
	public OrderTokens withCostCenter(){		
		addSimpleOptions(COSTCENTER);
		return this;
	}
	
	
	protected static final String PROFITCENTER = "profitCenter";
	public String getProfitCenter(){
		return PROFITCENTER;
	}
	public OrderTokens withProfitCenter(){		
		addSimpleOptions(PROFITCENTER);
		return this;
	}
	
	
	protected static final String CONFIRMATION = "confirmation";
	public String getConfirmation(){
		return CONFIRMATION;
	}
	public OrderTokens withConfirmation(){		
		addSimpleOptions(CONFIRMATION);
		return this;
	}
	
	
	protected static final String APPROVAL = "approval";
	public String getApproval(){
		return APPROVAL;
	}
	public OrderTokens withApproval(){		
		addSimpleOptions(APPROVAL);
		return this;
	}
	
	
	protected static final String PROCESSING = "processing";
	public String getProcessing(){
		return PROCESSING;
	}
	public OrderTokens withProcessing(){		
		addSimpleOptions(PROCESSING);
		return this;
	}
	
	
	protected static final String SHIPMENT = "shipment";
	public String getShipment(){
		return SHIPMENT;
	}
	public OrderTokens withShipment(){		
		addSimpleOptions(SHIPMENT);
		return this;
	}
	
	
	protected static final String DELIVERY = "delivery";
	public String getDelivery(){
		return DELIVERY;
	}
	public OrderTokens withDelivery(){		
		addSimpleOptions(DELIVERY);
		return this;
	}
	
	
	protected static final String RECURRINGINFO = "recurringInfo";
	public String getRecurringInfo(){
		return RECURRINGINFO;
	}
	public OrderTokens withRecurringInfo(){		
		addSimpleOptions(RECURRINGINFO);
		return this;
	}
	
	
	protected static final String LINE_ITEM_LIST = "lineItemList";
	public String getLineItemList(){
		return LINE_ITEM_LIST;
	}
	public OrderTokens withLineItemList(){		
		addSimpleOptions(LINE_ITEM_LIST);
		return this;
	}	
		
	protected static final String SHIPPING_GROUP_LIST = "shippingGroupList";
	public String getShippingGroupList(){
		return SHIPPING_GROUP_LIST;
	}
	public OrderTokens withShippingGroupList(){		
		addSimpleOptions(SHIPPING_GROUP_LIST);
		return this;
	}	
		
	protected static final String PAYMENT_GROUP_LIST = "paymentGroupList";
	public String getPaymentGroupList(){
		return PAYMENT_GROUP_LIST;
	}
	public OrderTokens withPaymentGroupList(){		
		addSimpleOptions(PAYMENT_GROUP_LIST);
		return this;
	}	
		
	protected static final String ACTION_LIST = "actionList";
	public String getActionList(){
		return ACTION_LIST;
	}
	public OrderTokens withActionList(){		
		addSimpleOptions(ACTION_LIST);
		return this;
	}	
		
}

