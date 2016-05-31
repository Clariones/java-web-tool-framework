
package com.terapico.b2b.billingaddress;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import com.terapico.b2b.CommonJDBCTemplateDAO;
import com.terapico.b2b.buyercompany.BuyerCompany;
import com.terapico.b2b.paymentgroup.PaymentGroup;

import com.terapico.b2b.paymentgroup.PaymentGroupDAO;
import com.terapico.b2b.buyercompany.BuyerCompanyDAO;

public class BillingAddressJDBCTemplateDAO extends CommonJDBCTemplateDAO implements BillingAddressDAO{
 
 	
 	private  BuyerCompanyDAO  buyerCompanyDAO;
 	public void setBuyerCompanyDAO(BuyerCompanyDAO buyerCompanyDAO){
	 	this.buyerCompanyDAO = buyerCompanyDAO;
 	}
 	public BuyerCompanyDAO getBuyerCompanyDAO(){
	 	return this.buyerCompanyDAO;
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
 	
			
		

	public BillingAddress load(String billingAddressId,Set<String> options) throws Exception{
		return loadInternalBillingAddress(billingAddressId, options);
	}
	public BillingAddress save(BillingAddress billingAddress,Set<String> options){
		return saveInternalBillingAddress(billingAddress,options);
	}
	public BillingAddress clone(String billingAddressId,Set<String> options) throws Exception{
		BillingAddress newBillingAddress = load(billingAddressId, options);
		newBillingAddress.setVersion(0);
		
		
 		
 		if(isSavePaymentGroupListEnabled(options)){
 			for(PaymentGroup item: newBillingAddress.getPaymentGroupList()){
 				item.setVersion(0);
 			}
 		}
		
		
		saveInternalBillingAddress(newBillingAddress,options);
		
		return newBillingAddress;
	}
	public void delete(String billingAddressId, int version) throws Exception{
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{billingAddressId,version};
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			// two suitations here, this object has been deleted; or
			// the version has been changed, the client should reload it and ensure this can be deleted
			SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
			parameters=new Object[]{billingAddressId};
			int count = getJdbcTemplateObject().queryForObject(SQL, Integer.class, parameters);
			if(count == 1){
				throw new BillingAddressVersionChangedException("The object version has been changed, please reload to delete");
			}
			if(count < 1){
				throw new BillingAddressNotFoundException("The object alread has been deleted.");
			}
			if(count > 1){
				throw new IllegalStateException("The database PRIMARY KEY constraint has been damaged, please fix it.");
			}
		
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"company","line1","line2","city","state","country"};
	}
	@Override
	protected String getName() {
		
		return "billing_address";
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

 
 	//private boolean extractCompanyEnabled = true;
 	private static final String COMPANY = "company";
 	protected boolean isExtractCompanyEnabled(Set<String> options){
 		
	 	return checkOptions(options, COMPANY);
 	}
 	
 	
 	//private boolean saveCompanyEnabled = true;
 	protected boolean isSaveCompanyEnabled(Set<String> options){
	 	
 		return checkOptions(options, COMPANY);
 	}
 	

 	
 
		
	protected static final String PAYMENT_GROUP_LIST = "paymentGroupList";
	
	protected boolean isExtractPaymentGroupListEnabled(Set<String> options){
		
 		return checkOptions(options,PAYMENT_GROUP_LIST);
		
 	}

	protected boolean isSavePaymentGroupListEnabled(Set<String> options){
		return checkOptions(options, PAYMENT_GROUP_LIST);
		
 	}
 	
 	
			
		
	

	protected BillingAddressMapper getMapper(){
		return new BillingAddressMapper();
	}
	protected BillingAddress extractBillingAddress(String billingAddressId){
		String SQL = "select * from billing_address_data where id=?";	
		BillingAddress billingAddress = getJdbcTemplateObject().queryForObject(SQL, new Object[]{billingAddressId}, getMapper());
		return billingAddress;
	}

	protected BillingAddress loadInternalBillingAddress(String billingAddressId, Set<String> loadOptions) throws Exception{
		
		BillingAddress billingAddress = extractBillingAddress(billingAddressId);
 	
 		if(isExtractCompanyEnabled(loadOptions)){
	 		extractCompany(billingAddress);
 		}
 
		
		if(isExtractPaymentGroupListEnabled(loadOptions)){
	 		extractPaymentGroupList(billingAddress);
 		}		
		
		return billingAddress;
		
	}
	
	
	 

 	protected BillingAddress extractCompany(BillingAddress billingAddress) throws Exception{

		Set<String> options = new HashSet<String>();
		BuyerCompany company = getBuyerCompanyDAO().load(billingAddress.getCompany().getId(),options);
		if(company != null){
			billingAddress.setCompany(company);
		}
		
 		
 		return billingAddress;
 	}
 		
 
		
	protected BillingAddress extractPaymentGroupList(BillingAddress billingAddress){
		
		List<PaymentGroup> paymentGroupList = getPaymentGroupDAO().findPaymentGroupByBillingAddress(billingAddress.getId());
		if(paymentGroupList != null){
			billingAddress.setPaymentGroupList(paymentGroupList);
		}
		
		return billingAddress;
	
	}	
		
		
  	
 	public List<BillingAddress> findBillingAddressByCompany(String buyerCompanyId){
 	
 		String SQL = "select * from "+this.getTableName()+" where company = ?";
		List<BillingAddress> billingAddressList = getJdbcTemplateObject().query(SQL, new Object[]{buyerCompanyId}, getMapper());
		
 	
 		return billingAddressList;
 	}
 	
		
		
		
	

	protected BillingAddress saveBillingAddress(BillingAddress  billingAddress){
	
		String SQL=this.getSaveBillingAddressSQL(billingAddress);
		Object [] parameters = getSaveBillingAddressParameters(billingAddress);
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		return billingAddress;
	
	}
	public List<BillingAddress> saveList(List<BillingAddress> billingAddressList,Set<String> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitBillingAddressList(billingAddressList);
		
		batchCreate((List<BillingAddress>)lists[CREATE_LIST_INDEX]);
		
		batchUpdate((List<BillingAddress>)lists[UPDATE_LIST_INDEX]);

		return billingAddressList;
	}

	
	protected List<Object[]> prepareBatchCreateArgs(List<BillingAddress> billingAddressList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(BillingAddress billingAddress:billingAddressList ){
			Object [] parameters = prepareCreateBillingAddressParameters(billingAddress);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareBatchUpdateArgs(List<BillingAddress> billingAddressList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(BillingAddress billingAddress:billingAddressList ){
			Object [] parameters = prepareUpdateBillingAddressParameters(billingAddress);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchCreate(List<BillingAddress> billingAddressList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareBatchCreateArgs(billingAddressList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
	}
	
	
	protected void batchUpdate(List<BillingAddress> billingAddressList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareBatchUpdateArgs(billingAddressList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitBillingAddressList(List<BillingAddress> billingAddressList){
		
		List<BillingAddress> billingAddressCreateList=new ArrayList<BillingAddress>();
		List<BillingAddress> billingAddressUpdateList=new ArrayList<BillingAddress>();
		
		for(BillingAddress billingAddress: billingAddressList){
			if(isUpdateRequest(billingAddress)){
				billingAddressUpdateList.add( billingAddress);
				continue;
			}
			billingAddressCreateList.add(billingAddress);
		}
		
		return new Object[]{billingAddressCreateList,billingAddressUpdateList};
	}
	
	protected boolean isUpdateRequest(BillingAddress billingAddress){
 		return billingAddress.getVersion() > 0;
 	}
 	protected String getSaveBillingAddressSQL(BillingAddress billingAddress){
 		if(isUpdateRequest(billingAddress)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveBillingAddressParameters(BillingAddress billingAddress){
 		if(isUpdateRequest(billingAddress) ){
 			return prepareUpdateBillingAddressParameters(billingAddress);
 		}
 		return prepareCreateBillingAddressParameters(billingAddress);
 	}
 	protected Object[] prepareUpdateBillingAddressParameters(BillingAddress billingAddress){
 		Object[] parameters = new Object[8];
  	
 		if(billingAddress.getCompany() != null){
 			parameters[0] = billingAddress.getCompany().getId();
 		}
 
 		parameters[1] = billingAddress.getLine1();
 		parameters[2] = billingAddress.getLine2();
 		parameters[3] = billingAddress.getCity();
 		parameters[4] = billingAddress.getState();
 		parameters[5] = billingAddress.getCountry();		
 		parameters[6] = billingAddress.getId();
 		parameters[7] = billingAddress.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareCreateBillingAddressParameters(BillingAddress billingAddress){
		Object[] parameters = new Object[7];
		String newBillingAddressId=getNextId();
		billingAddress.setId(newBillingAddressId);
		parameters[0] =  billingAddress.getId();
  	
 		if(billingAddress.getCompany() != null){
 			parameters[1] = billingAddress.getCompany().getId();
 		
 		}
 		
 		parameters[2] = billingAddress.getLine1();
 		parameters[3] = billingAddress.getLine2();
 		parameters[4] = billingAddress.getCity();
 		parameters[5] = billingAddress.getState();
 		parameters[6] = billingAddress.getCountry();		
 				
 		return parameters;
 	}
 	
	protected BillingAddress saveInternalBillingAddress(BillingAddress billingAddress, Set<String> options){
		
		saveBillingAddress(billingAddress);
 	
 		if(isSaveCompanyEnabled(options)){
	 		saveCompany(billingAddress);
 		}
 
		
		if(isSavePaymentGroupListEnabled(options)){
	 		savePaymentGroupList(billingAddress);
 		}		
		
		return billingAddress;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected BillingAddress saveCompany(BillingAddress billingAddress){
 		//Call inject DAO to execute this method
 		Set<String> options = new HashSet<String>();
 		
 		getBuyerCompanyDAO().save(billingAddress.getCompany(),options);
 		return billingAddress;
 		
 	}
	
 
		
	protected BillingAddress savePaymentGroupList(BillingAddress billingAddress){
		List<PaymentGroup> paymentGroupList = billingAddress.getPaymentGroupList();
		if(paymentGroupList==null){
			return billingAddress;
		}
		if(paymentGroupList.isEmpty()){
			return billingAddress;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		Set<String> options = new HashSet<String>();
		getPaymentGroupDAO().saveList(billingAddress.getPaymentGroupList(),options);
		
		return billingAddress;
	
	}
		

}


