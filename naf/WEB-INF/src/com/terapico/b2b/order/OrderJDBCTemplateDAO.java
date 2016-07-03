
package com.terapico.b2b.order;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.terapico.b2b.CommonJDBCTemplateDAO;
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

import com.terapico.b2b.shippinggroup.ShippingGroupDAO;
import com.terapico.b2b.profitcenter.ProfitCenterDAO;
import com.terapico.b2b.delivery.DeliveryDAO;
import com.terapico.b2b.shipment.ShipmentDAO;
import com.terapico.b2b.processing.ProcessingDAO;
import com.terapico.b2b.approval.ApprovalDAO;
import com.terapico.b2b.costcenter.CostCenterDAO;
import com.terapico.b2b.recurringinfo.RecurringInfoDAO;
import com.terapico.b2b.sellercompany.SellerCompanyDAO;
import com.terapico.b2b.confirmation.ConfirmationDAO;
import com.terapico.b2b.lineitem.LineItemDAO;
import com.terapico.b2b.paymentgroup.PaymentGroupDAO;
import com.terapico.b2b.action.ActionDAO;
import com.terapico.b2b.buyercompany.BuyerCompanyDAO;


import org.springframework.dao.EmptyResultDataAccessException;

public class OrderJDBCTemplateDAO extends CommonJDBCTemplateDAO implements OrderDAO{
 
 	
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

		
	
  	private  LineItemDAO  lineItemDAO;
 	public void setLineItemDAO(LineItemDAO pLineItemDAO){
 	
 		if(pLineItemDAO == null){
 			throw new IllegalStateException("Do not try to set lineItemDAO to null.");
 		}
	 	this.lineItemDAO = pLineItemDAO;
 	}
 	public LineItemDAO getLineItemDAO(){
 		if(this.lineItemDAO == null){
 			throw new IllegalStateException("The lineItemDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.lineItemDAO;
 	}	
 	
			
		
	
  	private  ShippingGroupDAO  shippingGroupDAO;
 	public void setShippingGroupDAO(ShippingGroupDAO pShippingGroupDAO){
 	
 		if(pShippingGroupDAO == null){
 			throw new IllegalStateException("Do not try to set shippingGroupDAO to null.");
 		}
	 	this.shippingGroupDAO = pShippingGroupDAO;
 	}
 	public ShippingGroupDAO getShippingGroupDAO(){
 		if(this.shippingGroupDAO == null){
 			throw new IllegalStateException("The shippingGroupDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.shippingGroupDAO;
 	}	
 	
			
		
	
  	private  PaymentGroupDAO  paymentGroupDAO;
 	public void setPaymentGroupDAO(PaymentGroupDAO pPaymentGroupDAO){
 	
 		if(pPaymentGroupDAO == null){
 			throw new IllegalStateException("Do not try to set paymentGroupDAO to null.");
 		}
	 	this.paymentGroupDAO = pPaymentGroupDAO;
 	}
 	public PaymentGroupDAO getPaymentGroupDAO(){
 		if(this.paymentGroupDAO == null){
 			throw new IllegalStateException("The paymentGroupDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.paymentGroupDAO;
 	}	
 	
			
		
	
  	private  ActionDAO  actionDAO;
 	public void setActionDAO(ActionDAO pActionDAO){
 	
 		if(pActionDAO == null){
 			throw new IllegalStateException("Do not try to set actionDAO to null.");
 		}
	 	this.actionDAO = pActionDAO;
 	}
 	public ActionDAO getActionDAO(){
 		if(this.actionDAO == null){
 			throw new IllegalStateException("The actionDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.actionDAO;
 	}	
 	
			
		

	public Order load(String orderId,Map<String,Object> options) throws Exception{
		return loadInternalOrder(orderId, options);
	}
	public Order save(Order order,Map<String,Object> options){
		
		String methodName="save(Order order,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(order, methodName, "order");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalOrder(order,options);
	}
	public Order clone(String orderId,Map<String,Object> options) throws Exception{
	
		String methodName="clone(String orderId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(orderId, methodName, "orderId");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Order newOrder = load(orderId, options);
		newOrder.setVersion(0);
		
		
 		
 		if(isSaveLineItemListEnabled(options)){
 			for(LineItem item: newOrder.getLineItemList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveShippingGroupListEnabled(options)){
 			for(ShippingGroup item: newOrder.getShippingGroupList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSavePaymentGroupListEnabled(options)){
 			for(PaymentGroup item: newOrder.getPaymentGroupList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveActionListEnabled(options)){
 			for(Action item: newOrder.getActionList()){
 				item.setVersion(0);
 			}
 		}
		
		
		saveInternalOrder(newOrder,options);
		
		return newOrder;
	}
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = getJdbcTemplateObject().update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String orderId, int version) throws  OrderVersionChangedException,  OrderNotFoundException {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{orderId};
		int count = getJdbcTemplateObject().queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new OrderVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new OrderNotFoundException(
					"The " + this.getTableName() + "(" + orderId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String orderId, int version) throws Exception{
	
		String methodName="delete(String orderId, int version)";
		assertMethodArgumentNotNull(orderId, methodName, "orderId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{orderId,version};
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(orderId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"buyer","seller","title","cost_center","profit_center","total_amount","type","mark_as_delete","confirmation","approval","processing","shipment","delivery","recurring_info","status"};
	}
	@Override
	protected String getName() {
		
		return "order";
	}
	
	
	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
		if(options==null){
 			return false;
 		}
 		if(options.containsKey(optionToCheck)){
 			options.remove(optionToCheck);//consume the key, can not use any more to exactract the data.
 			return true;
 		}
 		if(options.containsKey(ALL)){
 			return true;
 		}
 		return false;
	
	}

 
 	//private boolean extractBuyerEnabled = true;
 	//private static final String BUYER = "buyer";
 	protected boolean isExtractBuyerEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, OrderTokens.BUYER);
 	}
 	
 	
 	//private boolean saveBuyerEnabled = true;
 	protected boolean isSaveBuyerEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, OrderTokens.BUYER);
 	}
 	

 	
  
 	//private boolean extractSellerEnabled = true;
 	//private static final String SELLER = "seller";
 	protected boolean isExtractSellerEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, OrderTokens.SELLER);
 	}
 	
 	
 	//private boolean saveSellerEnabled = true;
 	protected boolean isSaveSellerEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, OrderTokens.SELLER);
 	}
 	

 	
  
 	//private boolean extractCostCenterEnabled = true;
 	//private static final String COSTCENTER = "costCenter";
 	protected boolean isExtractCostCenterEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, OrderTokens.COSTCENTER);
 	}
 	
 	
 	//private boolean saveCostCenterEnabled = true;
 	protected boolean isSaveCostCenterEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, OrderTokens.COSTCENTER);
 	}
 	

 	
  
 	//private boolean extractProfitCenterEnabled = true;
 	//private static final String PROFITCENTER = "profitCenter";
 	protected boolean isExtractProfitCenterEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, OrderTokens.PROFITCENTER);
 	}
 	
 	
 	//private boolean saveProfitCenterEnabled = true;
 	protected boolean isSaveProfitCenterEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, OrderTokens.PROFITCENTER);
 	}
 	

 	
  
 	//private boolean extractConfirmationEnabled = true;
 	//private static final String CONFIRMATION = "confirmation";
 	protected boolean isExtractConfirmationEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, OrderTokens.CONFIRMATION);
 	}
 	
 	
 	//private boolean saveConfirmationEnabled = true;
 	protected boolean isSaveConfirmationEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, OrderTokens.CONFIRMATION);
 	}
 	

 	
  
 	//private boolean extractApprovalEnabled = true;
 	//private static final String APPROVAL = "approval";
 	protected boolean isExtractApprovalEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, OrderTokens.APPROVAL);
 	}
 	
 	
 	//private boolean saveApprovalEnabled = true;
 	protected boolean isSaveApprovalEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, OrderTokens.APPROVAL);
 	}
 	

 	
  
 	//private boolean extractProcessingEnabled = true;
 	//private static final String PROCESSING = "processing";
 	protected boolean isExtractProcessingEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, OrderTokens.PROCESSING);
 	}
 	
 	
 	//private boolean saveProcessingEnabled = true;
 	protected boolean isSaveProcessingEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, OrderTokens.PROCESSING);
 	}
 	

 	
  
 	//private boolean extractShipmentEnabled = true;
 	//private static final String SHIPMENT = "shipment";
 	protected boolean isExtractShipmentEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, OrderTokens.SHIPMENT);
 	}
 	
 	
 	//private boolean saveShipmentEnabled = true;
 	protected boolean isSaveShipmentEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, OrderTokens.SHIPMENT);
 	}
 	

 	
  
 	//private boolean extractDeliveryEnabled = true;
 	//private static final String DELIVERY = "delivery";
 	protected boolean isExtractDeliveryEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, OrderTokens.DELIVERY);
 	}
 	
 	
 	//private boolean saveDeliveryEnabled = true;
 	protected boolean isSaveDeliveryEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, OrderTokens.DELIVERY);
 	}
 	

 	
  
 	//private boolean extractRecurringInfoEnabled = true;
 	//private static final String RECURRINGINFO = "recurringInfo";
 	protected boolean isExtractRecurringInfoEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, OrderTokens.RECURRINGINFO);
 	}
 	
 	
 	//private boolean saveRecurringInfoEnabled = true;
 	protected boolean isSaveRecurringInfoEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, OrderTokens.RECURRINGINFO);
 	}
 	

 	
 
		
	//protected static final String LINE_ITEM_LIST = "lineItemList";
	
	protected boolean isExtractLineItemListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,OrderTokens.LINE_ITEM_LIST);
		
 	}

	protected boolean isSaveLineItemListEnabled(Map<String,Object> options){
		return checkOptions(options, OrderTokens.LINE_ITEM_LIST);
		
 	}
 	
 	
			
		
	//protected static final String SHIPPING_GROUP_LIST = "shippingGroupList";
	
	protected boolean isExtractShippingGroupListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,OrderTokens.SHIPPING_GROUP_LIST);
		
 	}

	protected boolean isSaveShippingGroupListEnabled(Map<String,Object> options){
		return checkOptions(options, OrderTokens.SHIPPING_GROUP_LIST);
		
 	}
 	
 	
			
		
	//protected static final String PAYMENT_GROUP_LIST = "paymentGroupList";
	
	protected boolean isExtractPaymentGroupListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,OrderTokens.PAYMENT_GROUP_LIST);
		
 	}

	protected boolean isSavePaymentGroupListEnabled(Map<String,Object> options){
		return checkOptions(options, OrderTokens.PAYMENT_GROUP_LIST);
		
 	}
 	
 	
			
		
	//protected static final String ACTION_LIST = "actionList";
	
	protected boolean isExtractActionListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,OrderTokens.ACTION_LIST);
		
 	}

	protected boolean isSaveActionListEnabled(Map<String,Object> options){
		return checkOptions(options, OrderTokens.ACTION_LIST);
		
 	}
 	
 	
			
		
	

	protected OrderMapper getMapper(){
		return new OrderMapper();
	}
	protected Order extractOrder(String orderId) throws Exception{
		String SQL = "select * from order_data where id=?";	
		try{
		
			Order order = getJdbcTemplateObject().queryForObject(SQL, new Object[]{orderId}, getMapper());
			return order;
		}catch(EmptyResultDataAccessException e){
			throw new OrderNotFoundException("Order("+orderId+") is not found!");
		}
		
		
	}

	protected Order loadInternalOrder(String orderId, Map<String,Object> loadOptions) throws Exception{
		
		Order order = extractOrder(orderId);
 	
 		if(isExtractBuyerEnabled(loadOptions)){
	 		extractBuyer(order, loadOptions);
 		}
  	
 		if(isExtractSellerEnabled(loadOptions)){
	 		extractSeller(order, loadOptions);
 		}
  	
 		if(isExtractCostCenterEnabled(loadOptions)){
	 		extractCostCenter(order, loadOptions);
 		}
  	
 		if(isExtractProfitCenterEnabled(loadOptions)){
	 		extractProfitCenter(order, loadOptions);
 		}
  	
 		if(isExtractConfirmationEnabled(loadOptions)){
	 		extractConfirmation(order, loadOptions);
 		}
  	
 		if(isExtractApprovalEnabled(loadOptions)){
	 		extractApproval(order, loadOptions);
 		}
  	
 		if(isExtractProcessingEnabled(loadOptions)){
	 		extractProcessing(order, loadOptions);
 		}
  	
 		if(isExtractShipmentEnabled(loadOptions)){
	 		extractShipment(order, loadOptions);
 		}
  	
 		if(isExtractDeliveryEnabled(loadOptions)){
	 		extractDelivery(order, loadOptions);
 		}
  	
 		if(isExtractRecurringInfoEnabled(loadOptions)){
	 		extractRecurringInfo(order, loadOptions);
 		}
 
		
		if(isExtractLineItemListEnabled(loadOptions)){
	 		extractLineItemList(order, loadOptions);
 		}		
		
		if(isExtractShippingGroupListEnabled(loadOptions)){
	 		extractShippingGroupList(order, loadOptions);
 		}		
		
		if(isExtractPaymentGroupListEnabled(loadOptions)){
	 		extractPaymentGroupList(order, loadOptions);
 		}		
		
		if(isExtractActionListEnabled(loadOptions)){
	 		extractActionList(order, loadOptions);
 		}		
		
		return order;
		
	}
	
	
	 

 	protected Order extractBuyer(Order order, Map<String,Object> options) throws Exception{

		if(order.getBuyer() == null){
			return order;
		}
		String buyerId = order.getBuyer().getId();
		if( buyerId == null){
			return order;
		}
		BuyerCompany buyer = getBuyerCompanyDAO().load(buyerId,options);
		if(buyer != null){
			order.setBuyer(buyer);
		}
		
 		
 		return order;
 	}
 		
  

 	protected Order extractSeller(Order order, Map<String,Object> options) throws Exception{

		if(order.getSeller() == null){
			return order;
		}
		String sellerId = order.getSeller().getId();
		if( sellerId == null){
			return order;
		}
		SellerCompany seller = getSellerCompanyDAO().load(sellerId,options);
		if(seller != null){
			order.setSeller(seller);
		}
		
 		
 		return order;
 	}
 		
  

 	protected Order extractCostCenter(Order order, Map<String,Object> options) throws Exception{

		if(order.getCostCenter() == null){
			return order;
		}
		String costCenterId = order.getCostCenter().getId();
		if( costCenterId == null){
			return order;
		}
		CostCenter costCenter = getCostCenterDAO().load(costCenterId,options);
		if(costCenter != null){
			order.setCostCenter(costCenter);
		}
		
 		
 		return order;
 	}
 		
  

 	protected Order extractProfitCenter(Order order, Map<String,Object> options) throws Exception{

		if(order.getProfitCenter() == null){
			return order;
		}
		String profitCenterId = order.getProfitCenter().getId();
		if( profitCenterId == null){
			return order;
		}
		ProfitCenter profitCenter = getProfitCenterDAO().load(profitCenterId,options);
		if(profitCenter != null){
			order.setProfitCenter(profitCenter);
		}
		
 		
 		return order;
 	}
 		
  

 	protected Order extractConfirmation(Order order, Map<String,Object> options) throws Exception{

		if(order.getConfirmation() == null){
			return order;
		}
		String confirmationId = order.getConfirmation().getId();
		if( confirmationId == null){
			return order;
		}
		Confirmation confirmation = getConfirmationDAO().load(confirmationId,options);
		if(confirmation != null){
			order.setConfirmation(confirmation);
		}
		
 		
 		return order;
 	}
 		
  

 	protected Order extractApproval(Order order, Map<String,Object> options) throws Exception{

		if(order.getApproval() == null){
			return order;
		}
		String approvalId = order.getApproval().getId();
		if( approvalId == null){
			return order;
		}
		Approval approval = getApprovalDAO().load(approvalId,options);
		if(approval != null){
			order.setApproval(approval);
		}
		
 		
 		return order;
 	}
 		
  

 	protected Order extractProcessing(Order order, Map<String,Object> options) throws Exception{

		if(order.getProcessing() == null){
			return order;
		}
		String processingId = order.getProcessing().getId();
		if( processingId == null){
			return order;
		}
		Processing processing = getProcessingDAO().load(processingId,options);
		if(processing != null){
			order.setProcessing(processing);
		}
		
 		
 		return order;
 	}
 		
  

 	protected Order extractShipment(Order order, Map<String,Object> options) throws Exception{

		if(order.getShipment() == null){
			return order;
		}
		String shipmentId = order.getShipment().getId();
		if( shipmentId == null){
			return order;
		}
		Shipment shipment = getShipmentDAO().load(shipmentId,options);
		if(shipment != null){
			order.setShipment(shipment);
		}
		
 		
 		return order;
 	}
 		
  

 	protected Order extractDelivery(Order order, Map<String,Object> options) throws Exception{

		if(order.getDelivery() == null){
			return order;
		}
		String deliveryId = order.getDelivery().getId();
		if( deliveryId == null){
			return order;
		}
		Delivery delivery = getDeliveryDAO().load(deliveryId,options);
		if(delivery != null){
			order.setDelivery(delivery);
		}
		
 		
 		return order;
 	}
 		
  

 	protected Order extractRecurringInfo(Order order, Map<String,Object> options) throws Exception{

		if(order.getRecurringInfo() == null){
			return order;
		}
		String recurringInfoId = order.getRecurringInfo().getId();
		if( recurringInfoId == null){
			return order;
		}
		RecurringInfo recurringInfo = getRecurringInfoDAO().load(recurringInfoId,options);
		if(recurringInfo != null){
			order.setRecurringInfo(recurringInfo);
		}
		
 		
 		return order;
 	}
 		
 
		
	protected Order extractLineItemList(Order order, Map<String,Object> options){
		
		List<LineItem> lineItemList = getLineItemDAO().findLineItemByBizOrder(order.getId());
		if(lineItemList != null){
			order.setLineItemList(lineItemList);
		}
		
		return order;
	
	}	
		
	protected Order extractShippingGroupList(Order order, Map<String,Object> options){
		
		List<ShippingGroup> shippingGroupList = getShippingGroupDAO().findShippingGroupByBizOrder(order.getId());
		if(shippingGroupList != null){
			order.setShippingGroupList(shippingGroupList);
		}
		
		return order;
	
	}	
		
	protected Order extractPaymentGroupList(Order order, Map<String,Object> options){
		
		List<PaymentGroup> paymentGroupList = getPaymentGroupDAO().findPaymentGroupByBizOrder(order.getId());
		if(paymentGroupList != null){
			order.setPaymentGroupList(paymentGroupList);
		}
		
		return order;
	
	}	
		
	protected Order extractActionList(Order order, Map<String,Object> options){
		
		List<Action> actionList = getActionDAO().findActionByBo(order.getId());
		if(actionList != null){
			order.setActionList(actionList);
		}
		
		return order;
	
	}	
		
		
  	
 	public List<Order> findOrderByBuyer(String buyerCompanyId){
 	
 		String SQL = "select * from "+this.getTableName()+" where buyer = ?";
		List<Order> orderList = getJdbcTemplateObject().query(SQL, new Object[]{buyerCompanyId}, getMapper());
		
 	
 		return orderList;
 	}
  	
 	public List<Order> findOrderBySeller(String sellerCompanyId){
 	
 		String SQL = "select * from "+this.getTableName()+" where seller = ?";
		List<Order> orderList = getJdbcTemplateObject().query(SQL, new Object[]{sellerCompanyId}, getMapper());
		
 	
 		return orderList;
 	}
  	
 	public List<Order> findOrderByCostCenter(String costCenterId){
 	
 		String SQL = "select * from "+this.getTableName()+" where cost_center = ?";
		List<Order> orderList = getJdbcTemplateObject().query(SQL, new Object[]{costCenterId}, getMapper());
		
 	
 		return orderList;
 	}
  	
 	public List<Order> findOrderByProfitCenter(String profitCenterId){
 	
 		String SQL = "select * from "+this.getTableName()+" where profit_center = ?";
		List<Order> orderList = getJdbcTemplateObject().query(SQL, new Object[]{profitCenterId}, getMapper());
		
 	
 		return orderList;
 	}
  	
 	public List<Order> findOrderByConfirmation(String confirmationId){
 	
 		String SQL = "select * from "+this.getTableName()+" where confirmation = ?";
		List<Order> orderList = getJdbcTemplateObject().query(SQL, new Object[]{confirmationId}, getMapper());
		
 	
 		return orderList;
 	}
  	
 	public List<Order> findOrderByApproval(String approvalId){
 	
 		String SQL = "select * from "+this.getTableName()+" where approval = ?";
		List<Order> orderList = getJdbcTemplateObject().query(SQL, new Object[]{approvalId}, getMapper());
		
 	
 		return orderList;
 	}
  	
 	public List<Order> findOrderByProcessing(String processingId){
 	
 		String SQL = "select * from "+this.getTableName()+" where processing = ?";
		List<Order> orderList = getJdbcTemplateObject().query(SQL, new Object[]{processingId}, getMapper());
		
 	
 		return orderList;
 	}
  	
 	public List<Order> findOrderByShipment(String shipmentId){
 	
 		String SQL = "select * from "+this.getTableName()+" where shipment = ?";
		List<Order> orderList = getJdbcTemplateObject().query(SQL, new Object[]{shipmentId}, getMapper());
		
 	
 		return orderList;
 	}
  	
 	public List<Order> findOrderByDelivery(String deliveryId){
 	
 		String SQL = "select * from "+this.getTableName()+" where delivery = ?";
		List<Order> orderList = getJdbcTemplateObject().query(SQL, new Object[]{deliveryId}, getMapper());
		
 	
 		return orderList;
 	}
  	
 	public List<Order> findOrderByRecurringInfo(String recurringInfoId){
 	
 		String SQL = "select * from "+this.getTableName()+" where recurring_info = ?";
		List<Order> orderList = getJdbcTemplateObject().query(SQL, new Object[]{recurringInfoId}, getMapper());
		
 	
 		return orderList;
 	}
 	
		
		
		
	

	protected Order saveOrder(Order  order){
	
		String SQL=this.getSaveOrderSQL(order);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveOrderParameters(order);
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		int newVersion = order.getVersion() + 1;
		order.setVersion(newVersion);
		return order;
	
	}
	public List<Order> saveList(List<Order> orderList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitOrderList(orderList);
		
		batchCreate((List<Order>)lists[CREATE_LIST_INDEX]);
		
		batchUpdate((List<Order>)lists[UPDATE_LIST_INDEX]);

		return orderList;
	}

	
	protected List<Object[]> prepareBatchCreateArgs(List<Order> orderList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Order order:orderList ){
			Object [] parameters = prepareCreateOrderParameters(order);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareBatchUpdateArgs(List<Order> orderList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Order order:orderList ){
			Object [] parameters = prepareUpdateOrderParameters(order);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchCreate(List<Order> orderList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareBatchCreateArgs(orderList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
	}
	
	
	protected void batchUpdate(List<Order> orderList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareBatchUpdateArgs(orderList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitOrderList(List<Order> orderList){
		
		List<Order> orderCreateList=new ArrayList<Order>();
		List<Order> orderUpdateList=new ArrayList<Order>();
		
		for(Order order: orderList){
			if(isUpdateRequest(order)){
				orderUpdateList.add( order);
				continue;
			}
			orderCreateList.add(order);
		}
		
		return new Object[]{orderCreateList,orderUpdateList};
	}
	
	protected boolean isUpdateRequest(Order order){
 		return order.getVersion() > 0;
 	}
 	protected String getSaveOrderSQL(Order order){
 		if(isUpdateRequest(order)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveOrderParameters(Order order){
 		if(isUpdateRequest(order) ){
 			return prepareUpdateOrderParameters(order);
 		}
 		return prepareCreateOrderParameters(order);
 	}
 	protected Object[] prepareUpdateOrderParameters(Order order){
 		Object[] parameters = new Object[17];
  	
 		if(order.getBuyer() != null){
 			parameters[0] = order.getBuyer().getId();
 		}
  	
 		if(order.getSeller() != null){
 			parameters[1] = order.getSeller().getId();
 		}
 
 		parameters[2] = order.getTitle(); 	
 		if(order.getCostCenter() != null){
 			parameters[3] = order.getCostCenter().getId();
 		}
  	
 		if(order.getProfitCenter() != null){
 			parameters[4] = order.getProfitCenter().getId();
 		}
 
 		parameters[5] = order.getTotalAmount();
 		parameters[6] = order.getType();
 		parameters[7] = order.getMarkAsDelete(); 	
 		if(order.getConfirmation() != null){
 			parameters[8] = order.getConfirmation().getId();
 		}
  	
 		if(order.getApproval() != null){
 			parameters[9] = order.getApproval().getId();
 		}
  	
 		if(order.getProcessing() != null){
 			parameters[10] = order.getProcessing().getId();
 		}
  	
 		if(order.getShipment() != null){
 			parameters[11] = order.getShipment().getId();
 		}
  	
 		if(order.getDelivery() != null){
 			parameters[12] = order.getDelivery().getId();
 		}
  	
 		if(order.getRecurringInfo() != null){
 			parameters[13] = order.getRecurringInfo().getId();
 		}
 
 		parameters[14] = order.getStatus();		
 		parameters[15] = order.getId();
 		parameters[16] = order.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareCreateOrderParameters(Order order){
		Object[] parameters = new Object[16];
		String newOrderId=getNextId();
		order.setId(newOrderId);
		parameters[0] =  order.getId();
  	
 		if(order.getBuyer() != null){
 			parameters[1] = order.getBuyer().getId();
 		
 		}
 		 	
 		if(order.getSeller() != null){
 			parameters[2] = order.getSeller().getId();
 		
 		}
 		
 		parameters[3] = order.getTitle(); 	
 		if(order.getCostCenter() != null){
 			parameters[4] = order.getCostCenter().getId();
 		
 		}
 		 	
 		if(order.getProfitCenter() != null){
 			parameters[5] = order.getProfitCenter().getId();
 		
 		}
 		
 		parameters[6] = order.getTotalAmount();
 		parameters[7] = order.getType();
 		parameters[8] = order.getMarkAsDelete(); 	
 		if(order.getConfirmation() != null){
 			parameters[9] = order.getConfirmation().getId();
 		
 		}
 		 	
 		if(order.getApproval() != null){
 			parameters[10] = order.getApproval().getId();
 		
 		}
 		 	
 		if(order.getProcessing() != null){
 			parameters[11] = order.getProcessing().getId();
 		
 		}
 		 	
 		if(order.getShipment() != null){
 			parameters[12] = order.getShipment().getId();
 		
 		}
 		 	
 		if(order.getDelivery() != null){
 			parameters[13] = order.getDelivery().getId();
 		
 		}
 		 	
 		if(order.getRecurringInfo() != null){
 			parameters[14] = order.getRecurringInfo().getId();
 		
 		}
 		
 		parameters[15] = order.getStatus();		
 				
 		return parameters;
 	}
 	
	protected Order saveInternalOrder(Order order, Map<String,Object> options){
		
		saveOrder(order);
 	
 		if(isSaveBuyerEnabled(options)){
	 		saveBuyer(order, options);
 		}
  	
 		if(isSaveSellerEnabled(options)){
	 		saveSeller(order, options);
 		}
  	
 		if(isSaveCostCenterEnabled(options)){
	 		saveCostCenter(order, options);
 		}
  	
 		if(isSaveProfitCenterEnabled(options)){
	 		saveProfitCenter(order, options);
 		}
  	
 		if(isSaveConfirmationEnabled(options)){
	 		saveConfirmation(order, options);
 		}
  	
 		if(isSaveApprovalEnabled(options)){
	 		saveApproval(order, options);
 		}
  	
 		if(isSaveProcessingEnabled(options)){
	 		saveProcessing(order, options);
 		}
  	
 		if(isSaveShipmentEnabled(options)){
	 		saveShipment(order, options);
 		}
  	
 		if(isSaveDeliveryEnabled(options)){
	 		saveDelivery(order, options);
 		}
  	
 		if(isSaveRecurringInfoEnabled(options)){
	 		saveRecurringInfo(order, options);
 		}
 
		
		if(isSaveLineItemListEnabled(options)){
	 		saveLineItemList(order, options);
 		}		
		
		if(isSaveShippingGroupListEnabled(options)){
	 		saveShippingGroupList(order, options);
 		}		
		
		if(isSavePaymentGroupListEnabled(options)){
	 		savePaymentGroupList(order, options);
 		}		
		
		if(isSaveActionListEnabled(options)){
	 		saveActionList(order, options);
 		}		
		
		return order;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Order saveBuyer(Order order, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		getBuyerCompanyDAO().save(order.getBuyer(),options);
 		return order;
 		
 	}
	
  
 
 	protected Order saveSeller(Order order, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		getSellerCompanyDAO().save(order.getSeller(),options);
 		return order;
 		
 	}
	
  
 
 	protected Order saveCostCenter(Order order, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		getCostCenterDAO().save(order.getCostCenter(),options);
 		return order;
 		
 	}
	
  
 
 	protected Order saveProfitCenter(Order order, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		getProfitCenterDAO().save(order.getProfitCenter(),options);
 		return order;
 		
 	}
	
  
 
 	protected Order saveConfirmation(Order order, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		getConfirmationDAO().save(order.getConfirmation(),options);
 		return order;
 		
 	}
	
  
 
 	protected Order saveApproval(Order order, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		getApprovalDAO().save(order.getApproval(),options);
 		return order;
 		
 	}
	
  
 
 	protected Order saveProcessing(Order order, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		getProcessingDAO().save(order.getProcessing(),options);
 		return order;
 		
 	}
	
  
 
 	protected Order saveShipment(Order order, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		getShipmentDAO().save(order.getShipment(),options);
 		return order;
 		
 	}
	
  
 
 	protected Order saveDelivery(Order order, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		getDeliveryDAO().save(order.getDelivery(),options);
 		return order;
 		
 	}
	
  
 
 	protected Order saveRecurringInfo(Order order, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		getRecurringInfoDAO().save(order.getRecurringInfo(),options);
 		return order;
 		
 	}
	
 
		
	protected Order saveLineItemList(Order order, Map<String,Object> options){
		List<LineItem> lineItemList = order.getLineItemList();
		if(lineItemList == null){
			return order;
		}
		if(lineItemList.isEmpty()){
			return order;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getLineItemDAO().saveList(order.getLineItemList(),options);
		
		return order;
	
	}
		
	protected Order saveShippingGroupList(Order order, Map<String,Object> options){
		List<ShippingGroup> shippingGroupList = order.getShippingGroupList();
		if(shippingGroupList == null){
			return order;
		}
		if(shippingGroupList.isEmpty()){
			return order;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getShippingGroupDAO().saveList(order.getShippingGroupList(),options);
		
		return order;
	
	}
		
	protected Order savePaymentGroupList(Order order, Map<String,Object> options){
		List<PaymentGroup> paymentGroupList = order.getPaymentGroupList();
		if(paymentGroupList == null){
			return order;
		}
		if(paymentGroupList.isEmpty()){
			return order;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getPaymentGroupDAO().saveList(order.getPaymentGroupList(),options);
		
		return order;
	
	}
		
	protected Order saveActionList(Order order, Map<String,Object> options){
		List<Action> actionList = order.getActionList();
		if(actionList == null){
			return order;
		}
		if(actionList.isEmpty()){
			return order;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getActionDAO().saveList(order.getActionList(),options);
		
		return order;
	
	}
		

	
}


