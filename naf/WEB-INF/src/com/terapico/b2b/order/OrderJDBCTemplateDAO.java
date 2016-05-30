
package com.terapico.b2b.order;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import com.terapico.b2b.CommonJDBCTemplateDAO;
import com.terapico.b2b.buyercompany.BuyerCompany;
import com.terapico.b2b.lineitem.LineItem;
import com.terapico.b2b.paymentgroup.PaymentGroup;
import com.terapico.b2b.sellercompany.SellerCompany;
import com.terapico.b2b.shippinggroup.ShippingGroup;

import com.terapico.b2b.sellercompany.SellerCompanyMapper;
import com.terapico.b2b.shippinggroup.ShippingGroupMapper;
import com.terapico.b2b.lineitem.LineItemMapper;
import com.terapico.b2b.buyercompany.BuyerCompanyMapper;
import com.terapico.b2b.paymentgroup.PaymentGroupMapper;

import com.terapico.b2b.shippinggroup.ShippingGroupDAO;
import com.terapico.b2b.lineitem.LineItemDAO;
import com.terapico.b2b.paymentgroup.PaymentGroupDAO;
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
 	
			
		

	public Order load(String orderId,Set<String> options) throws OrderNotFoundException{
		return loadInternalOrder(orderId, options);
	}
	public Order save(Order order,Set<String> options){
		return saveInternalOrder(order,options);
	}
	public Order clone(String orderId,Set<String> options) throws OrderNotFoundException{
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
		
		
		saveInternalOrder(newOrder,options);
		
		return newOrder;
	}
	public void delete(String orderId, int version) throws Exception{
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{orderId,version};
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			// two suitations here, this object has been deleted; or
			// the version has been changed, the client should reload it and ensure this can be deleted
			SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
			parameters=new Object[]{orderId};
			int count = getJdbcTemplateObject().queryForObject(SQL, Integer.class, parameters);
			if(count == 1){
				throw new OrderVersionChangedException("The object version has been changed, please reload to delete");
			}
			if(count < 1){
				throw new OrderNotFoundException("The object alread has been deleted.");
			}
			if(count > 1){
				throw new IllegalStateException("The database PRIMARY KEY constraint has been damaged, please fix it.");
			}
		
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"buyer","seller","title","total_amount","type"};
	}
	@Override
	protected String getName() {
		
		return "order";
	}
	
	
	static final String ALL="__all__"; //do not assign this to common users,
	protected boolean checkOptions(Set<String> options, String optionToCheck){
	
		if(options==null){
 			return false;
 		}
 		if(options.contains(optionToCheck)){
 			return true;
 		}
 		if(options.contains(ALL)){
 			return true;
 		}
 		return false;
	
	}

 
 	//private boolean extractBuyerEnabled = true;
 	private static final String BUYER = "buyer";
 	protected boolean isExtractBuyerEnabled(Set<String> options){
 		
	 	return checkOptions(options, BUYER);
 	}
 	
 	
 	//private boolean saveBuyerEnabled = true;
 	protected boolean isSaveBuyerEnabled(Set<String> options){
	 	
 		return checkOptions(options, BUYER);
 	}
 	

 	
  
 	//private boolean extractSellerEnabled = true;
 	private static final String SELLER = "seller";
 	protected boolean isExtractSellerEnabled(Set<String> options){
 		
	 	return checkOptions(options, SELLER);
 	}
 	
 	
 	//private boolean saveSellerEnabled = true;
 	protected boolean isSaveSellerEnabled(Set<String> options){
	 	
 		return checkOptions(options, SELLER);
 	}
 	

 	
 
		
	protected static final String LINE_ITEM_LIST = "lineItemList";
	
	protected boolean isExtractLineItemListEnabled(Set<String> options){
		
 		return checkOptions(options,LINE_ITEM_LIST);
		
 	}

	protected boolean isSaveLineItemListEnabled(Set<String> options){
		return checkOptions(options, LINE_ITEM_LIST);
		
 	}
 	
 	
			
		
	protected static final String SHIPPING_GROUP_LIST = "shippingGroupList";
	
	protected boolean isExtractShippingGroupListEnabled(Set<String> options){
		
 		return checkOptions(options,SHIPPING_GROUP_LIST);
		
 	}

	protected boolean isSaveShippingGroupListEnabled(Set<String> options){
		return checkOptions(options, SHIPPING_GROUP_LIST);
		
 	}
 	
 	
			
		
	protected static final String PAYMENT_GROUP_LIST = "paymentGroupList";
	
	protected boolean isExtractPaymentGroupListEnabled(Set<String> options){
		
 		return checkOptions(options,PAYMENT_GROUP_LIST);
		
 	}

	protected boolean isSavePaymentGroupListEnabled(Set<String> options){
		return checkOptions(options, PAYMENT_GROUP_LIST);
		
 	}
 	
 	
			
		
	


	protected Order extractOrder(String orderId){
		String SQL = "select * from order_data where id=?";	
		Order order = getJdbcTemplateObject().queryForObject(SQL, new Object[]{orderId},new OrderMapper());
		return order;
	}

	protected Order loadInternalOrder(String orderId, Set<String> loadOptions){
		
		Order order = extractOrder(orderId);
 	
 		if(isExtractBuyerEnabled(loadOptions)){
	 		extractBuyer(order);
 		}
  	
 		if(isExtractSellerEnabled(loadOptions)){
	 		extractSeller(order);
 		}
 
		
		if(isExtractLineItemListEnabled(loadOptions)){
	 		extractLineItemList(order);
 		}		
		
		if(isExtractShippingGroupListEnabled(loadOptions)){
	 		extractShippingGroupList(order);
 		}		
		
		if(isExtractPaymentGroupListEnabled(loadOptions)){
	 		extractPaymentGroupList(order);
 		}		
		
		return order;
		
	}
	
	
	 

 	protected Order extractBuyer(Order order){
 		
 		String SQL = "select * from buyer_company_data where id=?";
		BuyerCompany buyer = getJdbcTemplateObject().queryForObject(SQL, new Object[]{order.getBuyer().getId()},new BuyerCompanyMapper());
		if(buyer != null){
			order.setBuyer(buyer);
		}
		
		
 		
 		return order;
 	}
 		
  

 	protected Order extractSeller(Order order){
 		
 		String SQL = "select * from seller_company_data where id=?";
		SellerCompany seller = getJdbcTemplateObject().queryForObject(SQL, new Object[]{order.getSeller().getId()},new SellerCompanyMapper());
		if(seller != null){
			order.setSeller(seller);
		}
		
		
 		
 		return order;
 	}
 		
 
		
	protected Order extractLineItemList(Order order){
		
		String SQL = "select * from line_item_data where biz_order = ?";
		List<LineItem> lineItemList = getJdbcTemplateObject().query(SQL, new Object[]{order.getId()},new LineItemMapper());
		if(lineItemList != null){
			order.setLineItemList(lineItemList);
		}
		
		return order;
	
	}	
		
	protected Order extractShippingGroupList(Order order){
		
		String SQL = "select * from shipping_group_data where biz_order = ?";
		List<ShippingGroup> shippingGroupList = getJdbcTemplateObject().query(SQL, new Object[]{order.getId()},new ShippingGroupMapper());
		if(shippingGroupList != null){
			order.setShippingGroupList(shippingGroupList);
		}
		
		return order;
	
	}	
		
	protected Order extractPaymentGroupList(Order order){
		
		String SQL = "select * from payment_group_data where biz_order = ?";
		List<PaymentGroup> paymentGroupList = getJdbcTemplateObject().query(SQL, new Object[]{order.getId()},new PaymentGroupMapper());
		if(paymentGroupList != null){
			order.setPaymentGroupList(paymentGroupList);
		}
		
		return order;
	
	}	
		
	

	protected Order saveOrder(Order  order){
	
		String SQL=this.getSaveOrderSQL(order);
		Object [] parameters = getSaveOrderParameters(order);
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		return order;
	
	}
	public List<Order> saveList(List<Order> orderList,Set<String> options){
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
 		Object[] parameters = new Object[7];
  	
 		if(order.getBuyer() != null){
 			parameters[0] = order.getBuyer().getId();
 		}
  	
 		if(order.getSeller() != null){
 			parameters[1] = order.getSeller().getId();
 		}
 
 		parameters[2] = order.getTitle();
 		parameters[3] = order.getTotalAmount();
 		parameters[4] = order.getType();		
 		parameters[5] = order.getId();
 		parameters[6] = order.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareCreateOrderParameters(Order order){
		Object[] parameters = new Object[6];
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
 				
 		return parameters;
 	}
 	
	protected Order saveInternalOrder(Order order, Set<String> options){
		
		saveOrder(order);
 	
 		if(isSaveBuyerEnabled(options)){
	 		saveBuyer(order);
 		}
  	
 		if(isSaveSellerEnabled(options)){
	 		saveSeller(order);
 		}
 
		
		if(isSaveLineItemListEnabled(options)){
	 		saveLineItemList(order);
 		}		
		
		if(isSaveShippingGroupListEnabled(options)){
	 		saveShippingGroupList(order);
 		}		
		
		if(isSavePaymentGroupListEnabled(options)){
	 		savePaymentGroupList(order);
 		}		
		
		return order;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Order saveBuyer(Order order){
 		//Call inject DAO to execute this method
 		Set<String> options = new HashSet<String>();
 		
 		getBuyerCompanyDAO().save(order.getBuyer(),options);
 		return order;
 		
 	}
	
  
 
 	protected Order saveSeller(Order order){
 		//Call inject DAO to execute this method
 		Set<String> options = new HashSet<String>();
 		
 		getSellerCompanyDAO().save(order.getSeller(),options);
 		return order;
 		
 	}
	
 
		
	protected Order saveLineItemList(Order order){
		List<LineItem> lineItemList = order.getLineItemList();
		if(lineItemList==null){
			return order;
		}
		if(lineItemList.isEmpty()){
			return order;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		Set<String> options = new HashSet<String>();
		getLineItemDAO().saveList(order.getLineItemList(),options);
		
		return order;
	
	}
		
	protected Order saveShippingGroupList(Order order){
		List<ShippingGroup> shippingGroupList = order.getShippingGroupList();
		if(shippingGroupList==null){
			return order;
		}
		if(shippingGroupList.isEmpty()){
			return order;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		Set<String> options = new HashSet<String>();
		getShippingGroupDAO().saveList(order.getShippingGroupList(),options);
		
		return order;
	
	}
		
	protected Order savePaymentGroupList(Order order){
		List<PaymentGroup> paymentGroupList = order.getPaymentGroupList();
		if(paymentGroupList==null){
			return order;
		}
		if(paymentGroupList.isEmpty()){
			return order;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		Set<String> options = new HashSet<String>();
		getPaymentGroupDAO().saveList(order.getPaymentGroupList(),options);
		
		return order;
	
	}
		
 	
 	public List<Order> findOrderByBuyer(String buyerCompanyId){
 		return new ArrayList<Order>();
 	}//find end
  	
 	public List<Order> findOrderBySeller(String sellerCompanyId){
 		return new ArrayList<Order>();
 	}//find end
 
}


