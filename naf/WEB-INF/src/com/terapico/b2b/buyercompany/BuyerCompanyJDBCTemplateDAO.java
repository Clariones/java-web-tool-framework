
package com.terapico.b2b.buyercompany;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.terapico.b2b.CommonJDBCTemplateDAO;
import com.terapico.b2b.order.Order;
import com.terapico.b2b.creditaccount.CreditAccount;
import com.terapico.b2b.billingaddress.BillingAddress;
import com.terapico.b2b.costcenter.CostCenter;
import com.terapico.b2b.employee.Employee;

import com.terapico.b2b.employee.EmployeeDAO;
import com.terapico.b2b.costcenter.CostCenterDAO;
import com.terapico.b2b.creditaccount.CreditAccountDAO;
import com.terapico.b2b.billingaddress.BillingAddressDAO;
import com.terapico.b2b.order.OrderDAO;


import org.springframework.dao.EmptyResultDataAccessException;

public class BuyerCompanyJDBCTemplateDAO extends CommonJDBCTemplateDAO implements BuyerCompanyDAO{

		
	
  	private  CostCenterDAO  costCenterDAO;
 	public void setCostCenterDAO(CostCenterDAO pCostCenterDAO){
 	
 		if(pCostCenterDAO == null){
 			throw new IllegalStateException("Do not try to set costCenterDAO to null.");
 		}
	 	this.costCenterDAO = pCostCenterDAO;
 	}
 	public CostCenterDAO getCostCenterDAO(){
 		if(this.costCenterDAO == null){
 			throw new IllegalStateException("The costCenterDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.costCenterDAO;
 	}	
 	
			
		
	
  	private  CreditAccountDAO  creditAccountDAO;
 	public void setCreditAccountDAO(CreditAccountDAO pCreditAccountDAO){
 	
 		if(pCreditAccountDAO == null){
 			throw new IllegalStateException("Do not try to set creditAccountDAO to null.");
 		}
	 	this.creditAccountDAO = pCreditAccountDAO;
 	}
 	public CreditAccountDAO getCreditAccountDAO(){
 		if(this.creditAccountDAO == null){
 			throw new IllegalStateException("The creditAccountDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.creditAccountDAO;
 	}	
 	
			
		
	
  	private  BillingAddressDAO  billingAddressDAO;
 	public void setBillingAddressDAO(BillingAddressDAO pBillingAddressDAO){
 	
 		if(pBillingAddressDAO == null){
 			throw new IllegalStateException("Do not try to set billingAddressDAO to null.");
 		}
	 	this.billingAddressDAO = pBillingAddressDAO;
 	}
 	public BillingAddressDAO getBillingAddressDAO(){
 		if(this.billingAddressDAO == null){
 			throw new IllegalStateException("The billingAddressDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.billingAddressDAO;
 	}	
 	
			
		
	
  	private  EmployeeDAO  employeeDAO;
 	public void setEmployeeDAO(EmployeeDAO pEmployeeDAO){
 	
 		if(pEmployeeDAO == null){
 			throw new IllegalStateException("Do not try to set employeeDAO to null.");
 		}
	 	this.employeeDAO = pEmployeeDAO;
 	}
 	public EmployeeDAO getEmployeeDAO(){
 		if(this.employeeDAO == null){
 			throw new IllegalStateException("The employeeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.employeeDAO;
 	}	
 	
			
		
	
  	private  OrderDAO  orderDAO;
 	public void setOrderDAO(OrderDAO pOrderDAO){
 	
 		if(pOrderDAO == null){
 			throw new IllegalStateException("Do not try to set orderDAO to null.");
 		}
	 	this.orderDAO = pOrderDAO;
 	}
 	public OrderDAO getOrderDAO(){
 		if(this.orderDAO == null){
 			throw new IllegalStateException("The orderDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.orderDAO;
 	}	
 	
			
		

	public BuyerCompany load(String buyerCompanyId,Map<String,Object> options) throws Exception{
		return loadInternalBuyerCompany(buyerCompanyId, options);
	}
	public BuyerCompany save(BuyerCompany buyerCompany,Map<String,Object> options){
		
		String methodName="save(BuyerCompany buyerCompany,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(buyerCompany, methodName, "buyerCompany");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalBuyerCompany(buyerCompany,options);
	}
	public BuyerCompany clone(String buyerCompanyId,Map<String,Object> options) throws Exception{
	
		String methodName="clone(String buyerCompanyId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(buyerCompanyId, methodName, "buyerCompanyId");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		BuyerCompany newBuyerCompany = load(buyerCompanyId, options);
		newBuyerCompany.setVersion(0);
		
		
 		
 		if(isSaveCostCenterListEnabled(options)){
 			for(CostCenter item: newBuyerCompany.getCostCenterList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveCreditAccountListEnabled(options)){
 			for(CreditAccount item: newBuyerCompany.getCreditAccountList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveBillingAddressListEnabled(options)){
 			for(BillingAddress item: newBuyerCompany.getBillingAddressList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveEmployeeListEnabled(options)){
 			for(Employee item: newBuyerCompany.getEmployeeList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveOrderListEnabled(options)){
 			for(Order item: newBuyerCompany.getOrderList()){
 				item.setVersion(0);
 			}
 		}
		
		
		saveInternalBuyerCompany(newBuyerCompany,options);
		
		return newBuyerCompany;
	}
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = getJdbcTemplateObject().update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String buyerCompanyId, int version) throws  BuyerCompanyVersionChangedException,  BuyerCompanyNotFoundException {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{buyerCompanyId};
		int count = getJdbcTemplateObject().queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new BuyerCompanyVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new BuyerCompanyNotFoundException(
					"The " + this.getTableName() + "(" + buyerCompanyId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String buyerCompanyId, int version) throws Exception{
	
		String methodName="delete(String buyerCompanyId, int version)";
		assertMethodArgumentNotNull(buyerCompanyId, methodName, "buyerCompanyId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{buyerCompanyId,version};
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(buyerCompanyId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"name","price_list","rating","logo","owner"};
	}
	@Override
	protected String getName() {
		
		return "buyer_company";
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


		
	//protected static final String COST_CENTER_LIST = "costCenterList";
	
	protected boolean isExtractCostCenterListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,BuyerCompanyTokens.COST_CENTER_LIST);
		
 	}

	protected boolean isSaveCostCenterListEnabled(Map<String,Object> options){
		return checkOptions(options, BuyerCompanyTokens.COST_CENTER_LIST);
		
 	}
 	
 	
			
		
	//protected static final String CREDIT_ACCOUNT_LIST = "creditAccountList";
	
	protected boolean isExtractCreditAccountListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,BuyerCompanyTokens.CREDIT_ACCOUNT_LIST);
		
 	}

	protected boolean isSaveCreditAccountListEnabled(Map<String,Object> options){
		return checkOptions(options, BuyerCompanyTokens.CREDIT_ACCOUNT_LIST);
		
 	}
 	
 	
			
		
	//protected static final String BILLING_ADDRESS_LIST = "billingAddressList";
	
	protected boolean isExtractBillingAddressListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,BuyerCompanyTokens.BILLING_ADDRESS_LIST);
		
 	}

	protected boolean isSaveBillingAddressListEnabled(Map<String,Object> options){
		return checkOptions(options, BuyerCompanyTokens.BILLING_ADDRESS_LIST);
		
 	}
 	
 	
			
		
	//protected static final String EMPLOYEE_LIST = "employeeList";
	
	protected boolean isExtractEmployeeListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,BuyerCompanyTokens.EMPLOYEE_LIST);
		
 	}

	protected boolean isSaveEmployeeListEnabled(Map<String,Object> options){
		return checkOptions(options, BuyerCompanyTokens.EMPLOYEE_LIST);
		
 	}
 	
 	
			
		
	//protected static final String ORDER_LIST = "orderList";
	
	protected boolean isExtractOrderListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,BuyerCompanyTokens.ORDER_LIST);
		
 	}

	protected boolean isSaveOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, BuyerCompanyTokens.ORDER_LIST);
		
 	}
 	
 	
			
		
	

	protected BuyerCompanyMapper getMapper(){
		return new BuyerCompanyMapper();
	}
	protected BuyerCompany extractBuyerCompany(String buyerCompanyId) throws Exception{
		String SQL = "select * from buyer_company_data where id=?";	
		try{
		
			BuyerCompany buyerCompany = getJdbcTemplateObject().queryForObject(SQL, new Object[]{buyerCompanyId}, getMapper());
			return buyerCompany;
		}catch(EmptyResultDataAccessException e){
			throw new BuyerCompanyNotFoundException("BuyerCompany("+buyerCompanyId+") is not found!");
		}
		
		
	}

	protected BuyerCompany loadInternalBuyerCompany(String buyerCompanyId, Map<String,Object> loadOptions) throws Exception{
		
		BuyerCompany buyerCompany = extractBuyerCompany(buyerCompanyId);

		
		if(isExtractCostCenterListEnabled(loadOptions)){
	 		extractCostCenterList(buyerCompany, loadOptions);
 		}		
		
		if(isExtractCreditAccountListEnabled(loadOptions)){
	 		extractCreditAccountList(buyerCompany, loadOptions);
 		}		
		
		if(isExtractBillingAddressListEnabled(loadOptions)){
	 		extractBillingAddressList(buyerCompany, loadOptions);
 		}		
		
		if(isExtractEmployeeListEnabled(loadOptions)){
	 		extractEmployeeList(buyerCompany, loadOptions);
 		}		
		
		if(isExtractOrderListEnabled(loadOptions)){
	 		extractOrderList(buyerCompany, loadOptions);
 		}		
		
		return buyerCompany;
		
	}
	
	
	
		
	protected BuyerCompany extractCostCenterList(BuyerCompany buyerCompany, Map<String,Object> options){
		
		List<CostCenter> costCenterList = getCostCenterDAO().findCostCenterByBelongsTo(buyerCompany.getId());
		if(costCenterList != null){
			buyerCompany.setCostCenterList(costCenterList);
		}
		
		return buyerCompany;
	
	}	
		
	protected BuyerCompany extractCreditAccountList(BuyerCompany buyerCompany, Map<String,Object> options){
		
		List<CreditAccount> creditAccountList = getCreditAccountDAO().findCreditAccountByBuyer(buyerCompany.getId());
		if(creditAccountList != null){
			buyerCompany.setCreditAccountList(creditAccountList);
		}
		
		return buyerCompany;
	
	}	
		
	protected BuyerCompany extractBillingAddressList(BuyerCompany buyerCompany, Map<String,Object> options){
		
		List<BillingAddress> billingAddressList = getBillingAddressDAO().findBillingAddressByCompany(buyerCompany.getId());
		if(billingAddressList != null){
			buyerCompany.setBillingAddressList(billingAddressList);
		}
		
		return buyerCompany;
	
	}	
		
	protected BuyerCompany extractEmployeeList(BuyerCompany buyerCompany, Map<String,Object> options){
		
		List<Employee> employeeList = getEmployeeDAO().findEmployeeByCompany(buyerCompany.getId());
		if(employeeList != null){
			buyerCompany.setEmployeeList(employeeList);
		}
		
		return buyerCompany;
	
	}	
		
	protected BuyerCompany extractOrderList(BuyerCompany buyerCompany, Map<String,Object> options){
		
		List<Order> orderList = getOrderDAO().findOrderByBuyer(buyerCompany.getId());
		if(orderList != null){
			buyerCompany.setOrderList(orderList);
		}
		
		return buyerCompany;
	
	}	
		
		
 	
		
		
		
	

	protected BuyerCompany saveBuyerCompany(BuyerCompany  buyerCompany){
	
		String SQL=this.getSaveBuyerCompanySQL(buyerCompany);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveBuyerCompanyParameters(buyerCompany);
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		int newVersion = buyerCompany.getVersion() + 1;
		buyerCompany.setVersion(newVersion);
		return buyerCompany;
	
	}
	public List<BuyerCompany> saveList(List<BuyerCompany> buyerCompanyList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitBuyerCompanyList(buyerCompanyList);
		
		batchCreate((List<BuyerCompany>)lists[CREATE_LIST_INDEX]);
		
		batchUpdate((List<BuyerCompany>)lists[UPDATE_LIST_INDEX]);

		return buyerCompanyList;
	}

	
	protected List<Object[]> prepareBatchCreateArgs(List<BuyerCompany> buyerCompanyList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(BuyerCompany buyerCompany:buyerCompanyList ){
			Object [] parameters = prepareCreateBuyerCompanyParameters(buyerCompany);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareBatchUpdateArgs(List<BuyerCompany> buyerCompanyList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(BuyerCompany buyerCompany:buyerCompanyList ){
			Object [] parameters = prepareUpdateBuyerCompanyParameters(buyerCompany);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchCreate(List<BuyerCompany> buyerCompanyList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareBatchCreateArgs(buyerCompanyList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
	}
	
	
	protected void batchUpdate(List<BuyerCompany> buyerCompanyList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareBatchUpdateArgs(buyerCompanyList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitBuyerCompanyList(List<BuyerCompany> buyerCompanyList){
		
		List<BuyerCompany> buyerCompanyCreateList=new ArrayList<BuyerCompany>();
		List<BuyerCompany> buyerCompanyUpdateList=new ArrayList<BuyerCompany>();
		
		for(BuyerCompany buyerCompany: buyerCompanyList){
			if(isUpdateRequest(buyerCompany)){
				buyerCompanyUpdateList.add( buyerCompany);
				continue;
			}
			buyerCompanyCreateList.add(buyerCompany);
		}
		
		return new Object[]{buyerCompanyCreateList,buyerCompanyUpdateList};
	}
	
	protected boolean isUpdateRequest(BuyerCompany buyerCompany){
 		return buyerCompany.getVersion() > 0;
 	}
 	protected String getSaveBuyerCompanySQL(BuyerCompany buyerCompany){
 		if(isUpdateRequest(buyerCompany)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveBuyerCompanyParameters(BuyerCompany buyerCompany){
 		if(isUpdateRequest(buyerCompany) ){
 			return prepareUpdateBuyerCompanyParameters(buyerCompany);
 		}
 		return prepareCreateBuyerCompanyParameters(buyerCompany);
 	}
 	protected Object[] prepareUpdateBuyerCompanyParameters(BuyerCompany buyerCompany){
 		Object[] parameters = new Object[7];
 
 		parameters[0] = buyerCompany.getName();
 		parameters[1] = buyerCompany.getPriceList();
 		parameters[2] = buyerCompany.getRating();
 		parameters[3] = buyerCompany.getLogo();
 		parameters[4] = buyerCompany.getOwner();		
 		parameters[5] = buyerCompany.getId();
 		parameters[6] = buyerCompany.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareCreateBuyerCompanyParameters(BuyerCompany buyerCompany){
		Object[] parameters = new Object[6];
		String newBuyerCompanyId=getNextId();
		buyerCompany.setId(newBuyerCompanyId);
		parameters[0] =  buyerCompany.getId();
 
 		parameters[1] = buyerCompany.getName();
 		parameters[2] = buyerCompany.getPriceList();
 		parameters[3] = buyerCompany.getRating();
 		parameters[4] = buyerCompany.getLogo();
 		parameters[5] = buyerCompany.getOwner();		
 				
 		return parameters;
 	}
 	
	protected BuyerCompany saveInternalBuyerCompany(BuyerCompany buyerCompany, Map<String,Object> options){
		
		saveBuyerCompany(buyerCompany);

		
		if(isSaveCostCenterListEnabled(options)){
	 		saveCostCenterList(buyerCompany, options);
 		}		
		
		if(isSaveCreditAccountListEnabled(options)){
	 		saveCreditAccountList(buyerCompany, options);
 		}		
		
		if(isSaveBillingAddressListEnabled(options)){
	 		saveBillingAddressList(buyerCompany, options);
 		}		
		
		if(isSaveEmployeeListEnabled(options)){
	 		saveEmployeeList(buyerCompany, options);
 		}		
		
		if(isSaveOrderListEnabled(options)){
	 		saveOrderList(buyerCompany, options);
 		}		
		
		return buyerCompany;
		
	}
	
	
	
	//======================================================================================
	
		
	protected BuyerCompany saveCostCenterList(BuyerCompany buyerCompany, Map<String,Object> options){
		List<CostCenter> costCenterList = buyerCompany.getCostCenterList();
		if(costCenterList == null){
			return buyerCompany;
		}
		if(costCenterList.isEmpty()){
			return buyerCompany;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getCostCenterDAO().saveList(buyerCompany.getCostCenterList(),options);
		
		return buyerCompany;
	
	}
		
	protected BuyerCompany saveCreditAccountList(BuyerCompany buyerCompany, Map<String,Object> options){
		List<CreditAccount> creditAccountList = buyerCompany.getCreditAccountList();
		if(creditAccountList == null){
			return buyerCompany;
		}
		if(creditAccountList.isEmpty()){
			return buyerCompany;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getCreditAccountDAO().saveList(buyerCompany.getCreditAccountList(),options);
		
		return buyerCompany;
	
	}
		
	protected BuyerCompany saveBillingAddressList(BuyerCompany buyerCompany, Map<String,Object> options){
		List<BillingAddress> billingAddressList = buyerCompany.getBillingAddressList();
		if(billingAddressList == null){
			return buyerCompany;
		}
		if(billingAddressList.isEmpty()){
			return buyerCompany;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getBillingAddressDAO().saveList(buyerCompany.getBillingAddressList(),options);
		
		return buyerCompany;
	
	}
		
	protected BuyerCompany saveEmployeeList(BuyerCompany buyerCompany, Map<String,Object> options){
		List<Employee> employeeList = buyerCompany.getEmployeeList();
		if(employeeList == null){
			return buyerCompany;
		}
		if(employeeList.isEmpty()){
			return buyerCompany;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getEmployeeDAO().saveList(buyerCompany.getEmployeeList(),options);
		
		return buyerCompany;
	
	}
		
	protected BuyerCompany saveOrderList(BuyerCompany buyerCompany, Map<String,Object> options){
		List<Order> orderList = buyerCompany.getOrderList();
		if(orderList == null){
			return buyerCompany;
		}
		if(orderList.isEmpty()){
			return buyerCompany;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getOrderDAO().saveList(buyerCompany.getOrderList(),options);
		
		return buyerCompany;
	
	}
		

	
}


