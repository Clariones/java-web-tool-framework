package com.terapico.b2b.order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.terapico.b2b.action.Action;
import com.terapico.b2b.billingaddress.BillingAddress;
import com.terapico.b2b.buyercompany.BuyerCompany;
import com.terapico.b2b.lineitem.LineItem;
import com.terapico.b2b.lineitem.LineItemDAO;
import com.terapico.b2b.paymentgroup.PaymentGroup;
import com.terapico.b2b.sellercompany.SellerCompany;
import com.terapico.b2b.shippingaddress.ShippingAddress;
import com.terapico.b2b.shippinggroup.ShippingGroup;

public class OrderServiceImpl {
	OrderDAO orderDAO;
	LineItemDAO lineItemDAO;

	public OrderDAO getOrderDAO() {
		return orderDAO;
	}

	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	public Order load(String orderId, String[] optionsArray) throws Exception {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("__all__", "__all__");
		// options.addAll(Arrays.asList(optionsArray));
		Order theOrder = orderDAO.load(orderId, options);

		theOrder.addActions(getAvailableActions());
		;
		// theOrder.addAction(action);
		return theOrder;
	}

	public Order loadOne() throws Exception {

		// theOrder.addAction(action);
		return this.load("O000004", new String[] { "__all__" });
	}

	public String echo(String message) throws Exception {

		// theOrder.addAction(action);
		return message+"@"+new Date();
	}
	public Order createOrder(String buyerCompanyId, String sellerCompanyId, String title, 
			double totalAmount, String type, boolean markAsDelete) throws Exception {
		/*
		
		<order buyer="$(buyer_company)" seller="$(seller_company)" title="House Buiding - " 
				total_amount="300.88"  type="ORDER|QUOTE|INVOICE" mark_as_delete="true"
			
				confirmation="$(confirmation)" 
				approval="$(approval)" 
				processing="$(processing)" 
				shipment="$(shipment)" 
				delivery="$(delivery)"
			
			/>*/
		
		BuyerCompany buyer=new BuyerCompany();
		buyer.setId(buyerCompanyId);
		
		SellerCompany seller=new SellerCompany();
		seller.setId(sellerCompanyId);
		
		Order order=new Order();
		order.setBuyer(buyer);
		
		order.setTitle(title);
		order.setTotalAmount(totalAmount);
		order.setType(type);
		order.setMarkAsDelete(markAsDelete);
		Map<String, Object> options = new HashMap<String, Object>();
		//options.put("__all__", "__all__");
		orderDAO.save(order, options);
		
		// theOrder.addAction(action);
		return order;
	}
	
	public Order addLineItem(String orderId, String skuId, String skuName, double amount, int quantity) throws Exception {
		/*
		<line_item biz_order="$(order)" sku_id="SKU" sku_name="iPhone - " amount="$23.97" quantity="10" />
	
		<order buyer="$(buyer_company)" seller="$(seller_company)" title="House Buiding - " 
				total_amount="300.88"  type="ORDER|QUOTE|INVOICE" mark_as_delete="true"
			
				confirmation="$(confirmation)" 
				approval="$(approval)" 
				processing="$(processing)" 
				shipment="$(shipment)" 
				delivery="$(delivery)"
			
			/>*/
		
		
		
		
		LineItem lineItem=new LineItem();
		lineItem.setSkuId(skuId);
		lineItem.setSkuName(skuName);
		lineItem.setAmount(amount);
		lineItem.setQuantity(quantity);
		Map<String, Object> options =OrderOptionsTemplate.start().withLineItemList().done();
		Order order = orderDAO.load(orderId, options);
		order.addLineItem(lineItem);
		options =OrderOptionsTemplate.start().withLineItemList().done();
		
		// theOrder.addAction(action);
		return orderDAO.save(order, options);
	}
	
	
	public Order addPaymentGroup(String orderId, String name, String cardNumber, String billingAddressId) throws Exception {
		/*
		<line_item biz_order="$(order)" sku_id="SKU" sku_name="iPhone - " amount="$23.97" quantity="10" />
	<payment_group name="visa card ending - " biz_order="$(order)" card_number="4111 1111 1111 - " billing_address="$(billing_address)"/>
	
		<order buyer="$(buyer_company)" seller="$(seller_company)" title="House Buiding - " 
				total_amount="300.88"  type="ORDER|QUOTE|INVOICE" mark_as_delete="true"
			
				confirmation="$(confirmation)" 
				approval="$(approval)" 
				processing="$(processing)" 
				shipment="$(shipment)" 
				delivery="$(delivery)"
			
			/>*/
		
		Map<String, Object> options =OrderOptionsTemplate.start().withLineItemList().withShippingGroupList().withPaymentGroupList().done();
		
		
		PaymentGroup paymengGroup=new PaymentGroup();
		paymengGroup.setName(name);
		paymengGroup.setCardNumber(cardNumber);
		BillingAddress billingAddress = new BillingAddress();
		billingAddress.setId(billingAddressId);
		paymengGroup.setBillingAddress(billingAddress);
		Order order = orderDAO.load(orderId, options);
		order.addPaymentGroup(paymengGroup);
		options =OrderOptionsTemplate.start().withPaymentGroupList().done();
		
		// theOrder.addAction(action);
		return orderDAO.save(order, options);
	}
	
	public Order addShippingGroup(String orderId, String name, String addressId, double amount) throws Exception {
		/*
		<line_item biz_order="$(order)" sku_id="SKU" sku_name="iPhone - " amount="$23.97" quantity="10" />
	
		<order buyer="$(buyer_company)" seller="$(seller_company)" title="House Buiding - " 
				total_amount="300.88"  type="ORDER|QUOTE|INVOICE" mark_as_delete="true"
			
				confirmation="$(confirmation)" 
				approval="$(approval)" 
				processing="$(processing)" 
				shipment="$(shipment)" 
				delivery="$(delivery)"
			
			/>
			<shipping_group name="shipping to this address" biz_order="$(order)" address="$(shipping_address)" amount="$5.99"/>
	 
			 */
		
		ShippingAddress shippingAddress=new ShippingAddress();
		shippingAddress.setId(addressId);
		Map<String, Object> options =OrderOptionsTemplate.start().withShippingGroupList().withLineItemList().done();
		
		Order order = orderDAO.load(orderId, options);
		ShippingGroup shippingGroup=new ShippingGroup();
		shippingGroup.setName(name);
		shippingGroup.setAddress(shippingAddress);
		shippingGroup.setAmount(amount);
		//shippingGroup.setQuantity(quantity);
		order.addShippingGroup(shippingGroup);
		options =OrderOptionsTemplate.start().withShippingGroupList().withLineItemList().done();
		
		
		//lineItem.setBizOrder(biz_order);
		
		// theOrder.addAction(action);
		return orderDAO.save(order, options);
	}
	
	public Order confirm(String orderId, String[] optionsArray, String who)
			throws Exception {
		Map<String, Object> options = new HashMap<String, Object>();
		// options.addAll(Arrays.asList(optionsArray));
		Order theOrder = orderDAO.load(orderId, options);

		// action..set
		//
		return theOrder;
	}

	public List<Action> getAvailableActions() {
		String[] allfunctions = new String[] { "confirm", "approve",
				"transfer", "move" };
		List<Action> actions = new ArrayList<Action>();
		for (String actionName : allfunctions) {

			Action action = new Action();
			action.setName(actionName.toUpperCase());
			action.setInternalName(actionName);
			actions.add(action);
		}
		return actions;

	}

	public void delete(String orderId, int version) throws Exception {
		// Set<String> options=new HashSet<String>();
		// options.addAll(Arrays.asList(optionsArray));
		orderDAO.delete(orderId, version);
	}

	public void deleteLineItem(String orderId, String lineItemId, int version)
			throws Exception {
		// Set<String> options=new HashSet<String>();
		// options.addAll(Arrays.asList(optionsArray));
		// orderDAO.delete(orderId, version);
		lineItemDAO.delete(lineItemId, version);

	}

	public Order submit(String orderId, String[] optionsArray) throws Exception {
		Map<String, Object> options = new HashMap<String, Object>();
		// options.addAll(Arrays.asList(optionsArray));
		return orderDAO.load(orderId, options);
	}

	/*
	 * 
	 * protected String mId; protected BuyerCompany mBuyer; protected
	 * SellerCompany mSeller; protected String mTitle; protected double
	 * mTotalAmount; protected String mType; protected boolean mMarkAsDelete;
	 * protected int mxVersion;
	 */
	

	public String[] getCandidateTitlesForCreatingOrder() throws Exception {

		return new String[] { "order title" };
	}

	public String[] getCandidateBuyerList() throws Exception {

		return new String[] { "buyid" };
	}

	public String[] getCandidateSellerList() throws Exception {

		return new String[] { "sellerid" };
	}

	public String[] getCandidateTypeList() throws Exception {

		return new String[] { "S001", "S002" };
	}

	public Order updateOrder(String orderId, String title, String buyerId,
			String sellerId, String type) throws Exception {

		return this.load("O000004", new String[] { "__all__" });
	}

	public Order updateOrder(String orderId, OrderField field, String value)
			throws Exception {

		return this.load("O000004", new String[] { "__all__" });
	}

}
