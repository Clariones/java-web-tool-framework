
package com.terapico.b2b.buyercompany;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import com.terapico.b2b.CommonJDBCTemplateDAO;
import com.terapico.b2b.order.Order;
import com.terapico.b2b.billingaddress.BillingAddress;
import com.terapico.b2b.employee.Employee;

import com.terapico.b2b.employee.EmployeeDAO;
import com.terapico.b2b.billingaddress.BillingAddressDAO;
import com.terapico.b2b.order.OrderDAO;

public class BuyerCompanyJDBCTemplateDAO extends CommonJDBCTemplateDAO implements BuyerCompanyDAO{

		
	
  	private  BillingAddressDAO  billingAddressDAO;
 	public void setBillingAddressDAO(BillingAddressDAO pBillingAddressDAO){
 	
 		if(pBillingAddressDAO == null){
 			throw new IllegalStateException("Do not trying to set billingAddressDAO to null.");
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
 			throw new IllegalStateException("Do not trying to set employeeDAO to null.");
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
 			throw new IllegalStateException("Do not trying to set orderDAO to null.");
 		}
	 	this.orderDAO = pOrderDAO;
 	}
 	public OrderDAO getOrderDAO(){
 		if(this.orderDAO == null){
 			throw new IllegalStateException("The orderDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.orderDAO;
 	}	
 	
			
		

	public BuyerCompany load(String buyerCompanyId,Set<String> options) throws Exception{
		return loadInternalBuyerCompany(buyerCompanyId, options);
	}
	public BuyerCompany save(BuyerCompany buyerCompany,Set<String> options){
		return saveInternalBuyerCompany(buyerCompany,options);
	}
	public BuyerCompany clone(String buyerCompanyId,Set<String> options) throws Exception{
		BuyerCompany newBuyerCompany = load(buyerCompanyId, options);
		newBuyerCompany.setVersion(0);
		
		
 		
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
	public void delete(String buyerCompanyId, int version) throws Exception{
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{buyerCompanyId,version};
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			// two suitations here, this object has been deleted; or
			// the version has been changed, the client should reload it and ensure this can be deleted
			SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
			parameters=new Object[]{buyerCompanyId};
			int count = getJdbcTemplateObject().queryForObject(SQL, Integer.class, parameters);
			if(count == 1){
				throw new BuyerCompanyVersionChangedException("The object version has been changed, please reload to delete");
			}
			if(count < 1){
				throw new BuyerCompanyNotFoundException("The object alread has been deleted.");
			}
			if(count > 1){
				throw new IllegalStateException("The database PRIMARY KEY constraint has been damaged, please fix it.");
			}
		
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"name","price_list"};
	}
	@Override
	protected String getName() {
		
		return "buyer_company";
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


		
	protected static final String BILLING_ADDRESS_LIST = "billingAddressList";
	
	protected boolean isExtractBillingAddressListEnabled(Set<String> options){
		
 		return checkOptions(options,BILLING_ADDRESS_LIST);
		
 	}

	protected boolean isSaveBillingAddressListEnabled(Set<String> options){
		return checkOptions(options, BILLING_ADDRESS_LIST);
		
 	}
 	
 	
			
		
	protected static final String EMPLOYEE_LIST = "employeeList";
	
	protected boolean isExtractEmployeeListEnabled(Set<String> options){
		
 		return checkOptions(options,EMPLOYEE_LIST);
		
 	}

	protected boolean isSaveEmployeeListEnabled(Set<String> options){
		return checkOptions(options, EMPLOYEE_LIST);
		
 	}
 	
 	
			
		
	protected static final String ORDER_LIST = "orderList";
	
	protected boolean isExtractOrderListEnabled(Set<String> options){
		
 		return checkOptions(options,ORDER_LIST);
		
 	}

	protected boolean isSaveOrderListEnabled(Set<String> options){
		return checkOptions(options, ORDER_LIST);
		
 	}
 	
 	
			
		
	

	protected BuyerCompanyMapper getMapper(){
		return new BuyerCompanyMapper();
	}
	protected BuyerCompany extractBuyerCompany(String buyerCompanyId){
		String SQL = "select * from buyer_company_data where id=?";	
		BuyerCompany buyerCompany = getJdbcTemplateObject().queryForObject(SQL, new Object[]{buyerCompanyId}, getMapper());
		return buyerCompany;
	}

	protected BuyerCompany loadInternalBuyerCompany(String buyerCompanyId, Set<String> loadOptions) throws Exception{
		
		BuyerCompany buyerCompany = extractBuyerCompany(buyerCompanyId);

		
		if(isExtractBillingAddressListEnabled(loadOptions)){
	 		extractBillingAddressList(buyerCompany);
 		}		
		
		if(isExtractEmployeeListEnabled(loadOptions)){
	 		extractEmployeeList(buyerCompany);
 		}		
		
		if(isExtractOrderListEnabled(loadOptions)){
	 		extractOrderList(buyerCompany);
 		}		
		
		return buyerCompany;
		
	}
	
	
	
		
	protected BuyerCompany extractBillingAddressList(BuyerCompany buyerCompany){
		
		List<BillingAddress> billingAddressList = getBillingAddressDAO().findBillingAddressByCompany(buyerCompany.getId());
		if(billingAddressList != null){
			buyerCompany.setBillingAddressList(billingAddressList);
		}
		
		return buyerCompany;
	
	}	
		
	protected BuyerCompany extractEmployeeList(BuyerCompany buyerCompany){
		
		List<Employee> employeeList = getEmployeeDAO().findEmployeeByCompany(buyerCompany.getId());
		if(employeeList != null){
			buyerCompany.setEmployeeList(employeeList);
		}
		
		return buyerCompany;
	
	}	
		
	protected BuyerCompany extractOrderList(BuyerCompany buyerCompany){
		
		List<Order> orderList = getOrderDAO().findOrderByBuyer(buyerCompany.getId());
		if(orderList != null){
			buyerCompany.setOrderList(orderList);
		}
		
		return buyerCompany;
	
	}	
		
		
 	
		
		
		
	

	protected BuyerCompany saveBuyerCompany(BuyerCompany  buyerCompany){
	
		String SQL=this.getSaveBuyerCompanySQL(buyerCompany);
		Object [] parameters = getSaveBuyerCompanyParameters(buyerCompany);
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		return buyerCompany;
	
	}
	public List<BuyerCompany> saveList(List<BuyerCompany> buyerCompanyList,Set<String> options){
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
 		Object[] parameters = new Object[4];
 
 		parameters[0] = buyerCompany.getName();
 		parameters[1] = buyerCompany.getPriceList();		
 		parameters[2] = buyerCompany.getId();
 		parameters[3] = buyerCompany.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareCreateBuyerCompanyParameters(BuyerCompany buyerCompany){
		Object[] parameters = new Object[3];
		String newBuyerCompanyId=getNextId();
		buyerCompany.setId(newBuyerCompanyId);
		parameters[0] =  buyerCompany.getId();
 
 		parameters[1] = buyerCompany.getName();
 		parameters[2] = buyerCompany.getPriceList();		
 				
 		return parameters;
 	}
 	
	protected BuyerCompany saveInternalBuyerCompany(BuyerCompany buyerCompany, Set<String> options){
		
		saveBuyerCompany(buyerCompany);

		
		if(isSaveBillingAddressListEnabled(options)){
	 		saveBillingAddressList(buyerCompany);
 		}		
		
		if(isSaveEmployeeListEnabled(options)){
	 		saveEmployeeList(buyerCompany);
 		}		
		
		if(isSaveOrderListEnabled(options)){
	 		saveOrderList(buyerCompany);
 		}		
		
		return buyerCompany;
		
	}
	
	
	
	//======================================================================================
	
		
	protected BuyerCompany saveBillingAddressList(BuyerCompany buyerCompany){
		List<BillingAddress> billingAddressList = buyerCompany.getBillingAddressList();
		if(billingAddressList==null){
			return buyerCompany;
		}
		if(billingAddressList.isEmpty()){
			return buyerCompany;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		Set<String> options = new HashSet<String>();
		getBillingAddressDAO().saveList(buyerCompany.getBillingAddressList(),options);
		
		return buyerCompany;
	
	}
		
	protected BuyerCompany saveEmployeeList(BuyerCompany buyerCompany){
		List<Employee> employeeList = buyerCompany.getEmployeeList();
		if(employeeList==null){
			return buyerCompany;
		}
		if(employeeList.isEmpty()){
			return buyerCompany;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		Set<String> options = new HashSet<String>();
		getEmployeeDAO().saveList(buyerCompany.getEmployeeList(),options);
		
		return buyerCompany;
	
	}
		
	protected BuyerCompany saveOrderList(BuyerCompany buyerCompany){
		List<Order> orderList = buyerCompany.getOrderList();
		if(orderList==null){
			return buyerCompany;
		}
		if(orderList.isEmpty()){
			return buyerCompany;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		Set<String> options = new HashSet<String>();
		getOrderDAO().saveList(buyerCompany.getOrderList(),options);
		
		return buyerCompany;
	
	}
		

}


