
package com.terapico.b2b.order;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import com.terapico.b2b.approval.Approval;
import com.terapico.b2b.confirmation.Confirmation;
import com.terapico.b2b.recurringinfo.RecurringInfo;
import com.terapico.b2b.shipment.Shipment;
import com.terapico.b2b.buyercompany.BuyerCompany;
import com.terapico.b2b.processing.Processing;
import com.terapico.b2b.lineitem.LineItem;
import com.terapico.b2b.paymentgroup.PaymentGroup;
import com.terapico.b2b.costcenter.CostCenter;
import com.terapico.b2b.profitcenter.ProfitCenter;
import com.terapico.b2b.action.Action;
import com.terapico.b2b.delivery.Delivery;
import com.terapico.b2b.sellercompany.SellerCompany;
import com.terapico.b2b.shippinggroup.ShippingGroup;

import com.terapico.b2b.profitcenter.ProfitCenterDAO;
import com.terapico.b2b.delivery.DeliveryDAO;
import com.terapico.b2b.shipment.ShipmentDAO;
import com.terapico.b2b.processing.ProcessingDAO;
import com.terapico.b2b.approval.ApprovalDAO;
import com.terapico.b2b.costcenter.CostCenterDAO;
import com.terapico.b2b.recurringinfo.RecurringInfoDAO;
import com.terapico.b2b.confirmation.ConfirmationDAO;
import com.terapico.b2b.sellercompany.SellerCompanyDAO;
import com.terapico.b2b.buyercompany.BuyerCompanyDAO;

import com.terapico.b2b.order.Order;
import com.terapico.b2b.shippingaddress.ShippingAddress;
import com.terapico.b2b.billingaddress.BillingAddress;



public class OrderManagerImpl implements OrderManager {

	private  OrderDAO  orderDAO;
 	public void setOrderDAO(OrderDAO  orderDAO){
 	
 		if(orderDAO == null){
 			throw new IllegalStateException("Do not try to set orderDAO to null.");
 		}
	 	this.orderDAO = orderDAO;
 	}
 	public OrderDAO getOrderDAO(){
 		if(this.orderDAO == null){
 			throw new IllegalStateException("The OrderDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.orderDAO;
 	}
 	
 	public Order saveOrder(Order order, Map<String,Object>options) throws Exception{	
 		return getOrderDAO().save(order, options);
 	}
 	public Order loadOrder(String orderId, Map<String,Object>options) throws Exception{	
 		return getOrderDAO().load(orderId, options);
 	}
 	 
 	
 	private  BuyerCompanyDAO  buyerCompanyDAO;
 	public void setBuyerCompanyDAO(BuyerCompanyDAO buyerCompanyDAO){
	 	this.buyerCompanyDAO = buyerCompanyDAO;
 	}
 	public BuyerCompanyDAO getBuyerCompanyDAO(){
	 	return this.buyerCompanyDAO;
 	}
 
 	
 	private  SellerCompanyDAO  sellerCompanyDAO;
 	public void setSellerCompanyDAO(SellerCompanyDAO sellerCompanyDAO){
	 	this.sellerCompanyDAO = sellerCompanyDAO;
 	}
 	public SellerCompanyDAO getSellerCompanyDAO(){
	 	return this.sellerCompanyDAO;
 	}
 
 	
 	private  CostCenterDAO  costCenterDAO;
 	public void setCostCenterDAO(CostCenterDAO costCenterDAO){
	 	this.costCenterDAO = costCenterDAO;
 	}
 	public CostCenterDAO getCostCenterDAO(){
	 	return this.costCenterDAO;
 	}
 
 	
 	private  ProfitCenterDAO  profitCenterDAO;
 	public void setProfitCenterDAO(ProfitCenterDAO profitCenterDAO){
	 	this.profitCenterDAO = profitCenterDAO;
 	}
 	public ProfitCenterDAO getProfitCenterDAO(){
	 	return this.profitCenterDAO;
 	}
 
 	
 	private  ConfirmationDAO  confirmationDAO;
 	public void setConfirmationDAO(ConfirmationDAO confirmationDAO){
	 	this.confirmationDAO = confirmationDAO;
 	}
 	public ConfirmationDAO getConfirmationDAO(){
	 	return this.confirmationDAO;
 	}
 
 	
 	private  ApprovalDAO  approvalDAO;
 	public void setApprovalDAO(ApprovalDAO approvalDAO){
	 	this.approvalDAO = approvalDAO;
 	}
 	public ApprovalDAO getApprovalDAO(){
	 	return this.approvalDAO;
 	}
 
 	
 	private  ProcessingDAO  processingDAO;
 	public void setProcessingDAO(ProcessingDAO processingDAO){
	 	this.processingDAO = processingDAO;
 	}
 	public ProcessingDAO getProcessingDAO(){
	 	return this.processingDAO;
 	}
 
 	
 	private  ShipmentDAO  shipmentDAO;
 	public void setShipmentDAO(ShipmentDAO shipmentDAO){
	 	this.shipmentDAO = shipmentDAO;
 	}
 	public ShipmentDAO getShipmentDAO(){
	 	return this.shipmentDAO;
 	}
 
 	
 	private  DeliveryDAO  deliveryDAO;
 	public void setDeliveryDAO(DeliveryDAO deliveryDAO){
	 	this.deliveryDAO = deliveryDAO;
 	}
 	public DeliveryDAO getDeliveryDAO(){
	 	return this.deliveryDAO;
 	}
 
 	
 	private  RecurringInfoDAO  recurringInfoDAO;
 	public void setRecurringInfoDAO(RecurringInfoDAO recurringInfoDAO){
	 	this.recurringInfoDAO = recurringInfoDAO;
 	}
 	public RecurringInfoDAO getRecurringInfoDAO(){
	 	return this.recurringInfoDAO;
 	}

 	
 	
	public Order createOrder(String buyerId, String sellerId, String title, String costCenterId, String profitCenterId, double totalAmount, String type, boolean markAsDelete, String recurringInfoId, String status, String[] optionsExpr) throws Exception
	{
		
		
		Order order=createNewOrder(optionsExpr);	

		BuyerCompany buyer = loadBuyer(buyerId,emptyOptions());
		order.setBuyer(buyer);
		SellerCompany seller = loadSeller(sellerId,emptyOptions());
		order.setSeller(seller);
		order.setTitle(title);
		CostCenter costCenter = loadCostCenter(costCenterId,emptyOptions());
		order.setCostCenter(costCenter);
		ProfitCenter profitCenter = loadProfitCenter(profitCenterId,emptyOptions());
		order.setProfitCenter(profitCenter);
		order.setTotalAmount(totalAmount);
		order.setType(type);
		order.setMarkAsDelete(markAsDelete);
		RecurringInfo recurringInfo = loadRecurringInfo(recurringInfoId,emptyOptions());
		order.setRecurringInfo(recurringInfo);
		order.setStatus(status);

		return saveOrder(order, emptyOptions());
		

		
	}
	protected Order createNewOrder(String[] optionsExpr) throws Exception
	{
		
		return new Order();
		
	}
	public Order updateOrder(String orderId, String property, Object newValue) throws Exception 
	{
		return new Order();
	}
	protected Map<String,Object> emptyOptions(){
		return new HashMap<String,Object>();
	}
	
	protected OrderTokens tokens(){
		return OrderTokens.start();
	}
	protected Map<String,Object> allTokens(){
		return OrderTokens.all();
	}
	
	public Order transferToNewBuyer(String orderId, String newBuyerId) throws Exception
 	{
 
		Order order = loadOrder(orderId, allTokens());	
		synchronized(order){
			//will be good when the order loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			BuyerCompany buyer = loadBuyer(newBuyerId, emptyOptions());		
			order.setBuyer(buyer);		
			return saveOrder(order, emptyOptions());
		}
 	}
 	
 	protected BuyerCompany loadBuyer(String newBuyerId, Map<String,Object> options) throws Exception
 	{
 		return getBuyerCompanyDAO().load(newBuyerId, options);
 	}
 	
 	public Order transferToNewSeller(String orderId, String newSellerId) throws Exception
 	{
 
		Order order = loadOrder(orderId, allTokens());	
		synchronized(order){
			//will be good when the order loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			SellerCompany seller = loadSeller(newSellerId, emptyOptions());		
			order.setSeller(seller);		
			return saveOrder(order, emptyOptions());
		}
 	}
 	
 	protected SellerCompany loadSeller(String newSellerId, Map<String,Object> options) throws Exception
 	{
 		return getSellerCompanyDAO().load(newSellerId, options);
 	}
 	
 	public Order transferToNewCostCenter(String orderId, String newCostCenterId) throws Exception
 	{
 
		Order order = loadOrder(orderId, allTokens());	
		synchronized(order){
			//will be good when the order loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			CostCenter costCenter = loadCostCenter(newCostCenterId, emptyOptions());		
			order.setCostCenter(costCenter);		
			return saveOrder(order, emptyOptions());
		}
 	}
 	
 	protected CostCenter loadCostCenter(String newCostCenterId, Map<String,Object> options) throws Exception
 	{
 		return getCostCenterDAO().load(newCostCenterId, options);
 	}
 	
 	public Order transferToNewProfitCenter(String orderId, String newProfitCenterId) throws Exception
 	{
 
		Order order = loadOrder(orderId, allTokens());	
		synchronized(order){
			//will be good when the order loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			ProfitCenter profitCenter = loadProfitCenter(newProfitCenterId, emptyOptions());		
			order.setProfitCenter(profitCenter);		
			return saveOrder(order, emptyOptions());
		}
 	}
 	
 	protected ProfitCenter loadProfitCenter(String newProfitCenterId, Map<String,Object> options) throws Exception
 	{
 		return getProfitCenterDAO().load(newProfitCenterId, options);
 	}
 	
 	public Order confirm(String orderId, String who, Date confirmTime) throws Exception
 	{
		Order order = loadOrder(orderId, allTokens());	
		synchronized(order){
			//will be good when the order loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			if(order.getConfirmation() != null){
				throw new OrderManagerException("The Order("+orderId+") has already confirmed");
			}
		
			Confirmation confirmation = createConfirmation(who, confirmTime);		
			order.setConfirmation(confirmation);		
			return saveOrder(order, tokens().withConfirmation().done());
		}
 	}
 	protected Confirmation createConfirmation(String who, Date confirmTime){
 		Confirmation confirmation = new Confirmation(who, confirmTime);
 		return getConfirmationDAO().save(confirmation,emptyOptions());
 	}
	public Order approve(String orderId, String who, Date approveTime) throws Exception
 	{
		Order order = loadOrder(orderId, allTokens());	
		synchronized(order){
			//will be good when the order loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			if(order.getApproval() != null){
				throw new OrderManagerException("The Order("+orderId+") has already approved");
			}
		
			Approval approval = createApproval(who, approveTime);		
			order.setApproval(approval);		
			return saveOrder(order, tokens().withApproval().done());
		}
 	}
 	protected Approval createApproval(String who, Date approveTime){
 		Approval approval = new Approval(who, approveTime);
 		return getApprovalDAO().save(approval,emptyOptions());
 	}
	public Order process(String orderId, String who, Date processTime) throws Exception
 	{
		Order order = loadOrder(orderId, allTokens());	
		synchronized(order){
			//will be good when the order loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			if(order.getProcessing() != null){
				throw new OrderManagerException("The Order("+orderId+") has already processed");
			}
		
			Processing processing = createProcessing(who, processTime);		
			order.setProcessing(processing);		
			return saveOrder(order, tokens().withProcessing().done());
		}
 	}
 	protected Processing createProcessing(String who, Date processTime){
 		Processing processing = new Processing(who, processTime);
 		return getProcessingDAO().save(processing,emptyOptions());
 	}
	public Order ship(String orderId, String who, Date shipTime) throws Exception
 	{
		Order order = loadOrder(orderId, allTokens());	
		synchronized(order){
			//will be good when the order loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			if(order.getShipment() != null){
				throw new OrderManagerException("The Order("+orderId+") has already shipped");
			}
		
			Shipment shipment = createShipment(who, shipTime);		
			order.setShipment(shipment);		
			return saveOrder(order, tokens().withShipment().done());
		}
 	}
 	protected Shipment createShipment(String who, Date shipTime){
 		Shipment shipment = new Shipment(who, shipTime);
 		return getShipmentDAO().save(shipment,emptyOptions());
 	}
	public Order deliver(String orderId, String who, Date deliveryTime) throws Exception
 	{
		Order order = loadOrder(orderId, allTokens());	
		synchronized(order){
			//will be good when the order loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			if(order.getDelivery() != null){
				throw new OrderManagerException("The Order("+orderId+") has already delivered");
			}
		
			Delivery delivery = createDelivery(who, deliveryTime);		
			order.setDelivery(delivery);		
			return saveOrder(order, tokens().withDelivery().done());
		}
 	}
 	protected Delivery createDelivery(String who, Date deliveryTime){
 		Delivery delivery = new Delivery(who, deliveryTime);
 		return getDeliveryDAO().save(delivery,emptyOptions());
 	}
	public Order transferToNewRecurringInfo(String orderId, String newRecurringInfoId) throws Exception
 	{
 
		Order order = loadOrder(orderId, allTokens());	
		synchronized(order){
			//will be good when the order loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			RecurringInfo recurringInfo = loadRecurringInfo(newRecurringInfoId, emptyOptions());		
			order.setRecurringInfo(recurringInfo);		
			return saveOrder(order, emptyOptions());
		}
 	}
 	
 	protected RecurringInfo loadRecurringInfo(String newRecurringInfoId, Map<String,Object> options) throws Exception
 	{
 		return getRecurringInfoDAO().load(newRecurringInfoId, options);
 	}
 	
 

	public void delete(String orderId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}
	public  Order addLineItem(String orderId, String skuId, String skuName, double amount, int quantity, boolean active) throws Exception
	{		
		LineItem lineItem = createLineItem(skuId, skuName, amount, quantity, active);
		
		Order order = loadOrder(orderId, allTokens());
		synchronized(order){ 
			//will be good when the order loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			order.addLineItem( lineItem );		
			return saveOrder(order, tokens().withLineItemList().done());
		}
	}
	protected LineItem createLineItem(String skuId, String skuName, double amount, int quantity, boolean active){

		LineItem lineItem = new LineItem();
		
		
		lineItem.setSkuId(skuId);		
		lineItem.setSkuName(skuName);		
		lineItem.setAmount(amount);		
		lineItem.setQuantity(quantity);		
		lineItem.setActive(active);
	
		
		return lineItem;			
		
	}
	public  Order removeLineItem(String orderId, String lineItemId){
		return new Order();
	}
	public  Order updateLineItem(String orderId, String lineItemId, String property, Object newValue){
		return new Order();
	}

	public  Order addShippingGroup(String orderId, String name, String addressId, double amount) throws Exception
	{		
		ShippingGroup shippingGroup = createShippingGroup(name, addressId, amount);
		
		Order order = loadOrder(orderId, allTokens());
		synchronized(order){ 
			//will be good when the order loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			order.addShippingGroup( shippingGroup );		
			return saveOrder(order, tokens().withShippingGroupList().done());
		}
	}
	protected ShippingGroup createShippingGroup(String name, String addressId, double amount){

		ShippingGroup shippingGroup = new ShippingGroup();
		
		
		shippingGroup.setName(name);		
		ShippingAddress  address = new ShippingAddress();
		address.setId(addressId);		
		shippingGroup.setAddress(address);		
		shippingGroup.setAmount(amount);
	
		
		return shippingGroup;			
		
	}
	public  Order removeShippingGroup(String orderId, String shippingGroupId){
		return new Order();
	}
	public  Order updateShippingGroup(String orderId, String shippingGroupId, String property, Object newValue){
		return new Order();
	}

	public  Order addPaymentGroup(String orderId, String name, String cardNumber, String billingAddressId) throws Exception
	{		
		PaymentGroup paymentGroup = createPaymentGroup(name, cardNumber, billingAddressId);
		
		Order order = loadOrder(orderId, allTokens());
		synchronized(order){ 
			//will be good when the order loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			order.addPaymentGroup( paymentGroup );		
			return saveOrder(order, tokens().withPaymentGroupList().done());
		}
	}
	protected PaymentGroup createPaymentGroup(String name, String cardNumber, String billingAddressId){

		PaymentGroup paymentGroup = new PaymentGroup();
		
		
		paymentGroup.setName(name);		
		paymentGroup.setCardNumber(cardNumber);		
		BillingAddress  billingAddress = new BillingAddress();
		billingAddress.setId(billingAddressId);		
		paymentGroup.setBillingAddress(billingAddress);
	
		
		return paymentGroup;			
		
	}
	public  Order removePaymentGroup(String orderId, String paymentGroupId){
		return new Order();
	}
	public  Order updatePaymentGroup(String orderId, String paymentGroupId, String property, Object newValue){
		return new Order();
	}

	public  Order addAction(String orderId, String name, String internalName) throws Exception
	{		
		Action action = createAction(name, internalName);
		
		Order order = loadOrder(orderId, allTokens());
		synchronized(order){ 
			//will be good when the order loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			order.addAction( action );		
			return saveOrder(order, tokens().withActionList().done());
		}
	}
	protected Action createAction(String name, String internalName){

		Action action = new Action();
		
		
		action.setName(name);		
		action.setInternalName(internalName);
	
		
		return action;			
		
	}
	public  Order removeAction(String orderId, String actionId){
		return new Order();
	}
	public  Order updateAction(String orderId, String actionId, String property, Object newValue){
		return new Order();
	}



}


