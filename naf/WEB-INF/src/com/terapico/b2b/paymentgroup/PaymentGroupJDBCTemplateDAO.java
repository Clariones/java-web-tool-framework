
package com.terapico.b2b.paymentgroup;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import com.terapico.b2b.CommonJDBCTemplateDAO;
import com.terapico.b2b.order.Order;
import com.terapico.b2b.billingaddress.BillingAddress;

import com.terapico.b2b.order.OrderMapper;
import com.terapico.b2b.billingaddress.BillingAddressMapper;

import com.terapico.b2b.billingaddress.BillingAddressDAO;
import com.terapico.b2b.order.OrderDAO;

public class PaymentGroupJDBCTemplateDAO extends CommonJDBCTemplateDAO implements PaymentGroupDAO{
 
 	
 	private  OrderDAO  orderDAO;
 	public void setOrderDAO(OrderDAO orderDAO){
	 	this.orderDAO = orderDAO;
 	}
 	public OrderDAO getOrderDAO(){
	 	return this.orderDAO;
 	}
 
 	
 	private  BillingAddressDAO  billingAddressDAO;
 	public void setBillingAddressDAO(BillingAddressDAO billingAddressDAO){
	 	this.billingAddressDAO = billingAddressDAO;
 	}
 	public BillingAddressDAO getBillingAddressDAO(){
	 	return this.billingAddressDAO;
 	}

		

	public PaymentGroup load(String paymentGroupId,Set<String> options) throws PaymentGroupNotFoundException{
		return loadInternalPaymentGroup(paymentGroupId, options);
	}
	public PaymentGroup save(PaymentGroup paymentGroup,Set<String> options){
		return saveInternalPaymentGroup(paymentGroup,options);
	}
	public PaymentGroup clone(String paymentGroupId,Set<String> options) throws PaymentGroupNotFoundException{
		PaymentGroup newPaymentGroup = load(paymentGroupId, options);
		newPaymentGroup.setVersion(0);
		
		
		
		saveInternalPaymentGroup(newPaymentGroup,options);
		
		return newPaymentGroup;
	}
	public void delete(String paymentGroupId, int version) throws Exception{
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{paymentGroupId,version};
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			// two suitations here, this object has been deleted; or
			// the version has been changed, the client should reload it and ensure this can be deleted
			SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
			parameters=new Object[]{paymentGroupId};
			int count = getJdbcTemplateObject().queryForObject(SQL, Integer.class, parameters);
			if(count == 1){
				throw new PaymentGroupVersionChangedException("The object version has been changed, please reload to delete");
			}
			if(count < 1){
				throw new PaymentGroupNotFoundException("The object alread has been deleted.");
			}
			if(count > 1){
				throw new IllegalStateException("The database PRIMARY KEY constraint has been damaged, please fix it.");
			}
		
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"name","biz_order","card_number","billing_address"};
	}
	@Override
	protected String getName() {
		
		return "payment_group";
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

 
 	//private boolean extractBizOrderEnabled = true;
 	private static final String BIZORDER = "bizOrder";
 	protected boolean isExtractBizOrderEnabled(Set<String> options){
 		
	 	return checkOptions(options, BIZORDER);
 	}
 	
 	
 	//private boolean saveBizOrderEnabled = true;
 	protected boolean isSaveBizOrderEnabled(Set<String> options){
	 	
 		return checkOptions(options, BIZORDER);
 	}
 	

 	
  
 	//private boolean extractBillingAddressEnabled = true;
 	private static final String BILLINGADDRESS = "billingAddress";
 	protected boolean isExtractBillingAddressEnabled(Set<String> options){
 		
	 	return checkOptions(options, BILLINGADDRESS);
 	}
 	
 	
 	//private boolean saveBillingAddressEnabled = true;
 	protected boolean isSaveBillingAddressEnabled(Set<String> options){
	 	
 		return checkOptions(options, BILLINGADDRESS);
 	}
 	

 	
 
		
	


	protected PaymentGroup extractPaymentGroup(String paymentGroupId){
		String SQL = "select * from payment_group_data where id=?";	
		PaymentGroup paymentGroup = getJdbcTemplateObject().queryForObject(SQL, new Object[]{paymentGroupId},new PaymentGroupMapper());
		return paymentGroup;
	}

	protected PaymentGroup loadInternalPaymentGroup(String paymentGroupId, Set<String> loadOptions){
		
		PaymentGroup paymentGroup = extractPaymentGroup(paymentGroupId);
 	
 		if(isExtractBizOrderEnabled(loadOptions)){
	 		extractBizOrder(paymentGroup);
 		}
  	
 		if(isExtractBillingAddressEnabled(loadOptions)){
	 		extractBillingAddress(paymentGroup);
 		}
 
		
		return paymentGroup;
		
	}
	
	
	 

 	protected PaymentGroup extractBizOrder(PaymentGroup paymentGroup){
 		
 		String SQL = "select * from order_data where id=?";
		Order bizOrder = getJdbcTemplateObject().queryForObject(SQL, new Object[]{paymentGroup.getBizOrder().getId()},new OrderMapper());
		if(bizOrder != null){
			paymentGroup.setBizOrder(bizOrder);
		}
		
		
 		
 		return paymentGroup;
 	}
 		
  

 	protected PaymentGroup extractBillingAddress(PaymentGroup paymentGroup){
 		
 		String SQL = "select * from billing_address_data where id=?";
		BillingAddress billingAddress = getJdbcTemplateObject().queryForObject(SQL, new Object[]{paymentGroup.getBillingAddress().getId()},new BillingAddressMapper());
		if(billingAddress != null){
			paymentGroup.setBillingAddress(billingAddress);
		}
		
		
 		
 		return paymentGroup;
 	}
 		
 
		
	

	protected PaymentGroup savePaymentGroup(PaymentGroup  paymentGroup){
	
		String SQL=this.getSavePaymentGroupSQL(paymentGroup);
		Object [] parameters = getSavePaymentGroupParameters(paymentGroup);
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		return paymentGroup;
	
	}
	public List<PaymentGroup> saveList(List<PaymentGroup> paymentGroupList,Set<String> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitPaymentGroupList(paymentGroupList);
		
		batchCreate((List<PaymentGroup>)lists[CREATE_LIST_INDEX]);
		
		batchUpdate((List<PaymentGroup>)lists[UPDATE_LIST_INDEX]);

		return paymentGroupList;
	}

	
	protected List<Object[]> prepareBatchCreateArgs(List<PaymentGroup> paymentGroupList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(PaymentGroup paymentGroup:paymentGroupList ){
			Object [] parameters = prepareCreatePaymentGroupParameters(paymentGroup);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareBatchUpdateArgs(List<PaymentGroup> paymentGroupList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(PaymentGroup paymentGroup:paymentGroupList ){
			Object [] parameters = prepareUpdatePaymentGroupParameters(paymentGroup);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchCreate(List<PaymentGroup> paymentGroupList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareBatchCreateArgs(paymentGroupList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
	}
	
	
	protected void batchUpdate(List<PaymentGroup> paymentGroupList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareBatchUpdateArgs(paymentGroupList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitPaymentGroupList(List<PaymentGroup> paymentGroupList){
		
		List<PaymentGroup> paymentGroupCreateList=new ArrayList<PaymentGroup>();
		List<PaymentGroup> paymentGroupUpdateList=new ArrayList<PaymentGroup>();
		
		for(PaymentGroup paymentGroup: paymentGroupList){
			if(isUpdateRequest(paymentGroup)){
				paymentGroupUpdateList.add( paymentGroup);
				continue;
			}
			paymentGroupCreateList.add(paymentGroup);
		}
		
		return new Object[]{paymentGroupCreateList,paymentGroupUpdateList};
	}
	
	protected boolean isUpdateRequest(PaymentGroup paymentGroup){
 		return paymentGroup.getVersion() > 0;
 	}
 	protected String getSavePaymentGroupSQL(PaymentGroup paymentGroup){
 		if(isUpdateRequest(paymentGroup)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSavePaymentGroupParameters(PaymentGroup paymentGroup){
 		if(isUpdateRequest(paymentGroup) ){
 			return prepareUpdatePaymentGroupParameters(paymentGroup);
 		}
 		return prepareCreatePaymentGroupParameters(paymentGroup);
 	}
 	protected Object[] prepareUpdatePaymentGroupParameters(PaymentGroup paymentGroup){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = paymentGroup.getName(); 	
 		if(paymentGroup.getBizOrder() != null){
 			parameters[1] = paymentGroup.getBizOrder().getId();
 		}
 
 		parameters[2] = paymentGroup.getCardNumber(); 	
 		if(paymentGroup.getBillingAddress() != null){
 			parameters[3] = paymentGroup.getBillingAddress().getId();
 		}
 		
 		parameters[4] = paymentGroup.getId();
 		parameters[5] = paymentGroup.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareCreatePaymentGroupParameters(PaymentGroup paymentGroup){
		Object[] parameters = new Object[5];
		String newPaymentGroupId=getNextId();
		paymentGroup.setId(newPaymentGroupId);
		parameters[0] =  paymentGroup.getId();
 
 		parameters[1] = paymentGroup.getName(); 	
 		if(paymentGroup.getBizOrder() != null){
 			parameters[2] = paymentGroup.getBizOrder().getId();
 		
 		}
 		
 		parameters[3] = paymentGroup.getCardNumber(); 	
 		if(paymentGroup.getBillingAddress() != null){
 			parameters[4] = paymentGroup.getBillingAddress().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected PaymentGroup saveInternalPaymentGroup(PaymentGroup paymentGroup, Set<String> options){
		
		savePaymentGroup(paymentGroup);
 	
 		if(isSaveBizOrderEnabled(options)){
	 		saveBizOrder(paymentGroup);
 		}
  	
 		if(isSaveBillingAddressEnabled(options)){
	 		saveBillingAddress(paymentGroup);
 		}
 
		
		return paymentGroup;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected PaymentGroup saveBizOrder(PaymentGroup paymentGroup){
 		//Call inject DAO to execute this method
 		Set<String> options = new HashSet<String>();
 		
 		getOrderDAO().save(paymentGroup.getBizOrder(),options);
 		return paymentGroup;
 		
 	}
	
  
 
 	protected PaymentGroup saveBillingAddress(PaymentGroup paymentGroup){
 		//Call inject DAO to execute this method
 		Set<String> options = new HashSet<String>();
 		
 		getBillingAddressDAO().save(paymentGroup.getBillingAddress(),options);
 		return paymentGroup;
 		
 	}
	
 
		
 	
 	public List<PaymentGroup> findPaymentGroupByBizOrder(String orderId){
 		return new ArrayList<PaymentGroup>();
 	}//find end
  	
 	public List<PaymentGroup> findPaymentGroupByBillingAddress(String billingAddressId){
 		return new ArrayList<PaymentGroup>();
 	}//find end
 
}


