
package com.terapico.b2b.order;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import com.terapico.b2b.CommonJDBCTemplateDAO;
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

import com.terapico.b2b.shippinggroup.ShippingGroupDAO;
import com.terapico.b2b.delivery.DeliveryDAO;
import com.terapico.b2b.lineitem.LineItemDAO;
import com.terapico.b2b.shipment.ShipmentDAO;
import com.terapico.b2b.processing.ProcessingDAO;
import com.terapico.b2b.paymentgroup.PaymentGroupDAO;
import com.terapico.b2b.action.ActionDAO;
import com.terapico.b2b.approval.ApprovalDAO;
import com.terapico.b2b.confirmation.ConfirmationDAO;
import com.terapico.b2b.sellercompany.SellerCompanyDAO;
import com.terapico.b2b.buyercompany.BuyerCompanyDAO;

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

		
	
  	private  LineItemDAO  lineItemDAO;
 	public void setLineItemDAO(LineItemDAO pLineItemDAO){
 	
 		if(pLineItemDAO == null){
 			throw new IllegalStateException("Do not trying to set lineItemDAO to null.");
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
 			throw new IllegalStateException("Do not trying to set shippingGroupDAO to null.");
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
 			throw new IllegalStateException("Do not trying to set paymentGroupDAO to null.");
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
 			throw new IllegalStateException("Do not trying to set actionDAO to null.");
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
		
		String methodName="save(Order order,Map<String,Object> options){";
		
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
		
		return new String[]{"buyer","seller","title","total_amount","type","mark_as_delete","confirmation","approval","processing","shipment","delivery"};
	}
	@Override
	protected String getName() {
		
		return "order";
	}
	
	
	static final String ALL="__all__"; //do not assign this to common users,
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
		if(options==null){
 			return false;
 		}
 		if(options.containsKey(optionToCheck)){
 			return true;
 		}
 		if(options.containsKey(ALL)){
 			return true;
 		}
 		return false;
	
	}

 
 	//private boolean extractBuyerEnabled = true;
 	private static final String BUYER = "buyer";
 	protected boolean isExtractBuyerEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, BUYER);
 	}
 	
 	
 	//private boolean saveBuyerEnabled = true;
 	protected boolean isSaveBuyerEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, BUYER);
 	}
 	

 	
  
 	//private boolean extractSellerEnabled = true;
 	private static final String SELLER = "seller";
 	protected boolean isExtractSellerEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, SELLER);
 	}
 	
 	
 	//private boolean saveSellerEnabled = true;
 	protected boolean isSaveSellerEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, SELLER);
 	}
 	

 	
  
 	//private boolean extractConfirmationEnabled = true;
 	private static final String CONFIRMATION = "confirmation";
 	protected boolean isExtractConfirmationEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, CONFIRMATION);
 	}
 	
 	
 	//private boolean saveConfirmationEnabled = true;
 	protected boolean isSaveConfirmationEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, CONFIRMATION);
 	}
 	

 	
  
 	//private boolean extractApprovalEnabled = true;
 	private static final String APPROVAL = "approval";
 	protected boolean isExtractApprovalEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, APPROVAL);
 	}
 	
 	
 	//private boolean saveApprovalEnabled = true;
 	protected boolean isSaveApprovalEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, APPROVAL);
 	}
 	

 	
  
 	//private boolean extractProcessingEnabled = true;
 	private static final String PROCESSING = "processing";
 	protected boolean isExtractProcessingEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, PROCESSING);
 	}
 	
 	
 	//private boolean saveProcessingEnabled = true;
 	protected boolean isSaveProcessingEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, PROCESSING);
 	}
 	

 	
  
 	//private boolean extractShipmentEnabled = true;
 	private static final String SHIPMENT = "shipment";
 	protected boolean isExtractShipmentEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, SHIPMENT);
 	}
 	
 	
 	//private boolean saveShipmentEnabled = true;
 	protected boolean isSaveShipmentEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, SHIPMENT);
 	}
 	

 	
  
 	//private boolean extractDeliveryEnabled = true;
 	private static final String DELIVERY = "delivery";
 	protected boolean isExtractDeliveryEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, DELIVERY);
 	}
 	
 	
 	//private boolean saveDeliveryEnabled = true;
 	protected boolean isSaveDeliveryEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, DELIVERY);
 	}
 	

 	
 
		
	protected static final String LINE_ITEM_LIST = "lineItemList";
	
	protected boolean isExtractLineItemListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,LINE_ITEM_LIST);
		
 	}

	protected boolean isSaveLineItemListEnabled(Map<String,Object> options){
		return checkOptions(options, LINE_ITEM_LIST);
		
 	}
 	
 	
			
		
	protected static final String SHIPPING_GROUP_LIST = "shippingGroupList";
	
	protected boolean isExtractShippingGroupListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,SHIPPING_GROUP_LIST);
		
 	}

	protected boolean isSaveShippingGroupListEnabled(Map<String,Object> options){
		return checkOptions(options, SHIPPING_GROUP_LIST);
		
 	}
 	
 	
			
		
	protected static final String PAYMENT_GROUP_LIST = "paymentGroupList";
	
	protected boolean isExtractPaymentGroupListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,PAYMENT_GROUP_LIST);
		
 	}

	protected boolean isSavePaymentGroupListEnabled(Map<String,Object> options){
		return checkOptions(options, PAYMENT_GROUP_LIST);
		
 	}
 	
 	
			
		
	protected static final String ACTION_LIST = "actionList";
	
	protected boolean isExtractActionListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,ACTION_LIST);
		
 	}

	protected boolean isSaveActionListEnabled(Map<String,Object> options){
		return checkOptions(options, ACTION_LIST);
		
 	}
 	
 	
			
		
	

	protected OrderMapper getMapper(){
		return new OrderMapper();
	}
	protected Order extractOrder(String orderId){
		String SQL = "select * from order_data where id=?";	
		Order order = getJdbcTemplateObject().queryForObject(SQL, new Object[]{orderId}, getMapper());
		return order;
	}

	protected Order loadInternalOrder(String orderId, Map<String,Object> loadOptions) throws Exception{
		
		Order order = extractOrder(orderId);
 	
 		if(isExtractBuyerEnabled(loadOptions)){
	 		extractBuyer(order, loadOptions);
 		}
  	
 		if(isExtractSellerEnabled(loadOptions)){
	 		extractSeller(order, loadOptions);
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
		
		BuyerCompany buyer = getBuyerCompanyDAO().load(order.getBuyer().getId(),options);
		if(buyer != null){
			order.setBuyer(buyer);
		}
		
 		
 		return order;
 	}
 		
  

 	protected Order extractSeller(Order order, Map<String,Object> options) throws Exception{

		if(order.getSeller() == null){
			return order;
		}
		
		SellerCompany seller = getSellerCompanyDAO().load(order.getSeller().getId(),options);
		if(seller != null){
			order.setSeller(seller);
		}
		
 		
 		return order;
 	}
 		
  

 	protected Order extractConfirmation(Order order, Map<String,Object> options) throws Exception{

		if(order.getConfirmation() == null){
			return order;
		}
		
		Confirmation confirmation = getConfirmationDAO().load(order.getConfirmation().getId(),options);
		if(confirmation != null){
			order.setConfirmation(confirmation);
		}
		
 		
 		return order;
 	}
 		
  

 	protected Order extractApproval(Order order, Map<String,Object> options) throws Exception{

		if(order.getApproval() == null){
			return order;
		}
		
		Approval approval = getApprovalDAO().load(order.getApproval().getId(),options);
		if(approval != null){
			order.setApproval(approval);
		}
		
 		
 		return order;
 	}
 		
  

 	protected Order extractProcessing(Order order, Map<String,Object> options) throws Exception{

		if(order.getProcessing() == null){
			return order;
		}
		
		Processing processing = getProcessingDAO().load(order.getProcessing().getId(),options);
		if(processing != null){
			order.setProcessing(processing);
		}
		
 		
 		return order;
 	}
 		
  

 	protected Order extractShipment(Order order, Map<String,Object> options) throws Exception{

		if(order.getShipment() == null){
			return order;
		}
		
		Shipment shipment = getShipmentDAO().load(order.getShipment().getId(),options);
		if(shipment != null){
			order.setShipment(shipment);
		}
		
 		
 		return order;
 	}
 		
  

 	protected Order extractDelivery(Order order, Map<String,Object> options) throws Exception{

		if(order.getDelivery() == null){
			return order;
		}
		
		Delivery delivery = getDeliveryDAO().load(order.getDelivery().getId(),options);
		if(delivery != null){
			order.setDelivery(delivery);
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
 	
		
		
		
	

	protected Order saveOrder(Order  order){
	
		String SQL=this.getSaveOrderSQL(order);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveOrderParameters(order);
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
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
 		Object[] parameters = new Object[13];
  	
 		if(order.getBuyer() != null){
 			parameters[0] = order.getBuyer().getId();
 		}
  	
 		if(order.getSeller() != null){
 			parameters[1] = order.getSeller().getId();
 		}
 
 		parameters[2] = order.getTitle();
 		parameters[3] = order.getTotalAmount();
 		parameters[4] = order.getType();
 		parameters[5] = order.getMarkAsDelete(); 	
 		if(order.getConfirmation() != null){
 			parameters[6] = order.getConfirmation().getId();
 		}
  	
 		if(order.getApproval() != null){
 			parameters[7] = order.getApproval().getId();
 		}
  	
 		if(order.getProcessing() != null){
 			parameters[8] = order.getProcessing().getId();
 		}
  	
 		if(order.getShipment() != null){
 			parameters[9] = order.getShipment().getId();
 		}
  	
 		if(order.getDelivery() != null){
 			parameters[10] = order.getDelivery().getId();
 		}
 		
 		parameters[11] = order.getId();
 		parameters[12] = order.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareCreateOrderParameters(Order order){
		Object[] parameters = new Object[12];
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
 		parameters[4] = order.getTotalAmount();
 		parameters[5] = order.getType();
 		parameters[6] = order.getMarkAsDelete(); 	
 		if(order.getConfirmation() != null){
 			parameters[7] = order.getConfirmation().getId();
 		
 		}
 		 	
 		if(order.getApproval() != null){
 			parameters[8] = order.getApproval().getId();
 		
 		}
 		 	
 		if(order.getProcessing() != null){
 			parameters[9] = order.getProcessing().getId();
 		
 		}
 		 	
 		if(order.getShipment() != null){
 			parameters[10] = order.getShipment().getId();
 		
 		}
 		 	
 		if(order.getDelivery() != null){
 			parameters[11] = order.getDelivery().getId();
 		
 		}
 				
 				
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
		
	protected void assertMethodArgumentNotNull(Object object, String method, String parameterName){
		if(object == null){
			throw new IllegalArgumentException("Method:" + method +": parameter '"+parameterName+"' shoud NOT be null");
		}
	}
	protected void assertMethodIntArgumentGreaterThan(int value, int targetValue,String method, String parameterName){
		if(value <= targetValue){
			throw new IllegalArgumentException("Method:" + method +": parameter '"+parameterName+"' shoud greater than " + targetValue +" but it is: "+ value);
		}
	}
	protected void assertMethodIntArgumentLessThan(int value, int targetValue,String method, String parameterName){
		if(value >= targetValue){
			throw new IllegalArgumentException("Method:" + method +": parameter '"+parameterName+"' shoud less than " + targetValue +" but it is: "+ value);
		}
	}
	
	protected void assertMethodIntArgumentInClosedRange(int value, int startValue, int endValue, String method, String parameterName){
		
		if(startValue>endValue){
			throw new IllegalArgumentException("When calling the check method, please note your parameter, endValue < startValue");
		}
	
		if(value < startValue){
			throw new IllegalArgumentException("Method:" + method +": parameter '"+parameterName+"' shoud be in closed range: ["+startValue+","+endValue+"] but it is: "+value);
		}
		if(value > endValue){
			throw new IllegalArgumentException("Method:" + method +": parameter '"+parameterName+"' shoud be in closed range: ["+startValue+","+endValue+"] but it is: "+value);
		}
	}
	protected void assertMethodStringArgumentLengthInClosedRange(String value, int lengthMin, int lengthMax, String method, String parameterName){
		
		if(lengthMin < 0){
			throw new IllegalArgumentException("The method assertMethodStringArgumentLengthInClosedRange lengMin should not less than 0");
		}
		
		if(lengthMin > lengthMax){
			throw new IllegalArgumentException("The method assertMethodStringArgumentLengthInClosedRange lengMin less or equal lengthMax");
		}
		
		if(value == null){		
			throw new IllegalArgumentException("Method:" + method +": parameter '"+parameterName+"' length shoud be in closed range: ["+lengthMin+","+lengthMax+"] but it is null");
		}
		if(value.length() < lengthMin){
			throw new IllegalArgumentException("Method:" + method +": parameter '"+parameterName+"' length shoud be in closed range: ["+lengthMin+","+lengthMax+"] but it is: "+value.length());
		}
		if(value.length() > lengthMax){
			throw new IllegalArgumentException("Method:" + method +": parameter '"+parameterName+"' length shoud be in closed range: ["+lengthMin+","+lengthMax+"] but it is: "+value.length());
		}
	}
	
}


