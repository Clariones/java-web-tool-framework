
package com.terapico.b2b.sellercompany;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.terapico.b2b.CommonJDBCTemplateDAO;
import com.terapico.b2b.order.Order;
import com.terapico.b2b.creditaccount.CreditAccount;
import com.terapico.b2b.custsvcrep.CustSvcRep;
import com.terapico.b2b.profitcenter.ProfitCenter;

import com.terapico.b2b.profitcenter.ProfitCenterDAO;
import com.terapico.b2b.creditaccount.CreditAccountDAO;
import com.terapico.b2b.custsvcrep.CustSvcRepDAO;
import com.terapico.b2b.order.OrderDAO;


import org.springframework.dao.EmptyResultDataAccessException;

public class SellerCompanyJDBCTemplateDAO extends CommonJDBCTemplateDAO implements SellerCompanyDAO{

		
	
  	private  ProfitCenterDAO  profitCenterDAO;
 	public void setProfitCenterDAO(ProfitCenterDAO pProfitCenterDAO){
 	
 		if(pProfitCenterDAO == null){
 			throw new IllegalStateException("Do not try to set profitCenterDAO to null.");
 		}
	 	this.profitCenterDAO = pProfitCenterDAO;
 	}
 	public ProfitCenterDAO getProfitCenterDAO(){
 		if(this.profitCenterDAO == null){
 			throw new IllegalStateException("The profitCenterDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.profitCenterDAO;
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
 	
			
		
	
  	private  CustSvcRepDAO  custSvcRepDAO;
 	public void setCustSvcRepDAO(CustSvcRepDAO pCustSvcRepDAO){
 	
 		if(pCustSvcRepDAO == null){
 			throw new IllegalStateException("Do not try to set custSvcRepDAO to null.");
 		}
	 	this.custSvcRepDAO = pCustSvcRepDAO;
 	}
 	public CustSvcRepDAO getCustSvcRepDAO(){
 		if(this.custSvcRepDAO == null){
 			throw new IllegalStateException("The custSvcRepDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.custSvcRepDAO;
 	}	
 	
			
		

	public SellerCompany load(String sellerCompanyId,Map<String,Object> options) throws Exception{
		return loadInternalSellerCompany(sellerCompanyId, options);
	}
	public SellerCompany save(SellerCompany sellerCompany,Map<String,Object> options){
		
		String methodName="save(SellerCompany sellerCompany,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(sellerCompany, methodName, "sellerCompany");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalSellerCompany(sellerCompany,options);
	}
	public SellerCompany clone(String sellerCompanyId,Map<String,Object> options) throws Exception{
	
		String methodName="clone(String sellerCompanyId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(sellerCompanyId, methodName, "sellerCompanyId");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		SellerCompany newSellerCompany = load(sellerCompanyId, options);
		newSellerCompany.setVersion(0);
		
		
 		
 		if(isSaveProfitCenterListEnabled(options)){
 			for(ProfitCenter item: newSellerCompany.getProfitCenterList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveCreditAccountListEnabled(options)){
 			for(CreditAccount item: newSellerCompany.getCreditAccountList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveOrderListEnabled(options)){
 			for(Order item: newSellerCompany.getOrderList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveCustSvcRepListEnabled(options)){
 			for(CustSvcRep item: newSellerCompany.getCustSvcRepList()){
 				item.setVersion(0);
 			}
 		}
		
		
		saveInternalSellerCompany(newSellerCompany,options);
		
		return newSellerCompany;
	}
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = getJdbcTemplateObject().update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String sellerCompanyId, int version) throws  SellerCompanyVersionChangedException,  SellerCompanyNotFoundException {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{sellerCompanyId};
		int count = getJdbcTemplateObject().queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new SellerCompanyVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new SellerCompanyNotFoundException(
					"The " + this.getTableName() + "(" + sellerCompanyId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String sellerCompanyId, int version) throws Exception{
	
		String methodName="delete(String sellerCompanyId, int version)";
		assertMethodArgumentNotNull(sellerCompanyId, methodName, "sellerCompanyId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{sellerCompanyId,version};
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(sellerCompanyId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"name","owner","logo","contract_text"};
	}
	@Override
	protected String getName() {
		
		return "seller_company";
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


		
	//protected static final String PROFIT_CENTER_LIST = "profitCenterList";
	
	protected boolean isExtractProfitCenterListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,SellerCompanyTokens.PROFIT_CENTER_LIST);
		
 	}

	protected boolean isSaveProfitCenterListEnabled(Map<String,Object> options){
		return checkOptions(options, SellerCompanyTokens.PROFIT_CENTER_LIST);
		
 	}
 	
 	
			
		
	//protected static final String CREDIT_ACCOUNT_LIST = "creditAccountList";
	
	protected boolean isExtractCreditAccountListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,SellerCompanyTokens.CREDIT_ACCOUNT_LIST);
		
 	}

	protected boolean isSaveCreditAccountListEnabled(Map<String,Object> options){
		return checkOptions(options, SellerCompanyTokens.CREDIT_ACCOUNT_LIST);
		
 	}
 	
 	
			
		
	//protected static final String ORDER_LIST = "orderList";
	
	protected boolean isExtractOrderListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,SellerCompanyTokens.ORDER_LIST);
		
 	}

	protected boolean isSaveOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, SellerCompanyTokens.ORDER_LIST);
		
 	}
 	
 	
			
		
	//protected static final String CUST_SVC_REP_LIST = "custSvcRepList";
	
	protected boolean isExtractCustSvcRepListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,SellerCompanyTokens.CUST_SVC_REP_LIST);
		
 	}

	protected boolean isSaveCustSvcRepListEnabled(Map<String,Object> options){
		return checkOptions(options, SellerCompanyTokens.CUST_SVC_REP_LIST);
		
 	}
 	
 	
			
		
	

	protected SellerCompanyMapper getMapper(){
		return new SellerCompanyMapper();
	}
	protected SellerCompany extractSellerCompany(String sellerCompanyId) throws Exception{
		String SQL = "select * from seller_company_data where id=?";	
		try{
		
			SellerCompany sellerCompany = getJdbcTemplateObject().queryForObject(SQL, new Object[]{sellerCompanyId}, getMapper());
			return sellerCompany;
		}catch(EmptyResultDataAccessException e){
			throw new SellerCompanyNotFoundException("SellerCompany("+sellerCompanyId+") is not found!");
		}
		
		
	}

	protected SellerCompany loadInternalSellerCompany(String sellerCompanyId, Map<String,Object> loadOptions) throws Exception{
		
		SellerCompany sellerCompany = extractSellerCompany(sellerCompanyId);

		
		if(isExtractProfitCenterListEnabled(loadOptions)){
	 		extractProfitCenterList(sellerCompany, loadOptions);
 		}		
		
		if(isExtractCreditAccountListEnabled(loadOptions)){
	 		extractCreditAccountList(sellerCompany, loadOptions);
 		}		
		
		if(isExtractOrderListEnabled(loadOptions)){
	 		extractOrderList(sellerCompany, loadOptions);
 		}		
		
		if(isExtractCustSvcRepListEnabled(loadOptions)){
	 		extractCustSvcRepList(sellerCompany, loadOptions);
 		}		
		
		return sellerCompany;
		
	}
	
	
	
		
	protected SellerCompany extractProfitCenterList(SellerCompany sellerCompany, Map<String,Object> options){
		
		List<ProfitCenter> profitCenterList = getProfitCenterDAO().findProfitCenterByBelongsTo(sellerCompany.getId());
		if(profitCenterList != null){
			sellerCompany.setProfitCenterList(profitCenterList);
		}
		
		return sellerCompany;
	
	}	
		
	protected SellerCompany extractCreditAccountList(SellerCompany sellerCompany, Map<String,Object> options){
		
		List<CreditAccount> creditAccountList = getCreditAccountDAO().findCreditAccountBySeller(sellerCompany.getId());
		if(creditAccountList != null){
			sellerCompany.setCreditAccountList(creditAccountList);
		}
		
		return sellerCompany;
	
	}	
		
	protected SellerCompany extractOrderList(SellerCompany sellerCompany, Map<String,Object> options){
		
		List<Order> orderList = getOrderDAO().findOrderBySeller(sellerCompany.getId());
		if(orderList != null){
			sellerCompany.setOrderList(orderList);
		}
		
		return sellerCompany;
	
	}	
		
	protected SellerCompany extractCustSvcRepList(SellerCompany sellerCompany, Map<String,Object> options){
		
		List<CustSvcRep> custSvcRepList = getCustSvcRepDAO().findCustSvcRepByCompany(sellerCompany.getId());
		if(custSvcRepList != null){
			sellerCompany.setCustSvcRepList(custSvcRepList);
		}
		
		return sellerCompany;
	
	}	
		
		
 	
		
		
		
	

	protected SellerCompany saveSellerCompany(SellerCompany  sellerCompany){
	
		String SQL=this.getSaveSellerCompanySQL(sellerCompany);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveSellerCompanyParameters(sellerCompany);
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		int newVersion = sellerCompany.getVersion() + 1;
		sellerCompany.setVersion(newVersion);
		return sellerCompany;
	
	}
	public List<SellerCompany> saveList(List<SellerCompany> sellerCompanyList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitSellerCompanyList(sellerCompanyList);
		
		batchCreate((List<SellerCompany>)lists[CREATE_LIST_INDEX]);
		
		batchUpdate((List<SellerCompany>)lists[UPDATE_LIST_INDEX]);

		return sellerCompanyList;
	}

	
	protected List<Object[]> prepareBatchCreateArgs(List<SellerCompany> sellerCompanyList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SellerCompany sellerCompany:sellerCompanyList ){
			Object [] parameters = prepareCreateSellerCompanyParameters(sellerCompany);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareBatchUpdateArgs(List<SellerCompany> sellerCompanyList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SellerCompany sellerCompany:sellerCompanyList ){
			Object [] parameters = prepareUpdateSellerCompanyParameters(sellerCompany);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchCreate(List<SellerCompany> sellerCompanyList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareBatchCreateArgs(sellerCompanyList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
	}
	
	
	protected void batchUpdate(List<SellerCompany> sellerCompanyList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareBatchUpdateArgs(sellerCompanyList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitSellerCompanyList(List<SellerCompany> sellerCompanyList){
		
		List<SellerCompany> sellerCompanyCreateList=new ArrayList<SellerCompany>();
		List<SellerCompany> sellerCompanyUpdateList=new ArrayList<SellerCompany>();
		
		for(SellerCompany sellerCompany: sellerCompanyList){
			if(isUpdateRequest(sellerCompany)){
				sellerCompanyUpdateList.add( sellerCompany);
				continue;
			}
			sellerCompanyCreateList.add(sellerCompany);
		}
		
		return new Object[]{sellerCompanyCreateList,sellerCompanyUpdateList};
	}
	
	protected boolean isUpdateRequest(SellerCompany sellerCompany){
 		return sellerCompany.getVersion() > 0;
 	}
 	protected String getSaveSellerCompanySQL(SellerCompany sellerCompany){
 		if(isUpdateRequest(sellerCompany)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveSellerCompanyParameters(SellerCompany sellerCompany){
 		if(isUpdateRequest(sellerCompany) ){
 			return prepareUpdateSellerCompanyParameters(sellerCompany);
 		}
 		return prepareCreateSellerCompanyParameters(sellerCompany);
 	}
 	protected Object[] prepareUpdateSellerCompanyParameters(SellerCompany sellerCompany){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = sellerCompany.getName();
 		parameters[1] = sellerCompany.getOwner();
 		parameters[2] = sellerCompany.getLogo();
 		parameters[3] = sellerCompany.getContractText();		
 		parameters[4] = sellerCompany.getId();
 		parameters[5] = sellerCompany.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareCreateSellerCompanyParameters(SellerCompany sellerCompany){
		Object[] parameters = new Object[5];
		String newSellerCompanyId=getNextId();
		sellerCompany.setId(newSellerCompanyId);
		parameters[0] =  sellerCompany.getId();
 
 		parameters[1] = sellerCompany.getName();
 		parameters[2] = sellerCompany.getOwner();
 		parameters[3] = sellerCompany.getLogo();
 		parameters[4] = sellerCompany.getContractText();		
 				
 		return parameters;
 	}
 	
	protected SellerCompany saveInternalSellerCompany(SellerCompany sellerCompany, Map<String,Object> options){
		
		saveSellerCompany(sellerCompany);

		
		if(isSaveProfitCenterListEnabled(options)){
	 		saveProfitCenterList(sellerCompany, options);
 		}		
		
		if(isSaveCreditAccountListEnabled(options)){
	 		saveCreditAccountList(sellerCompany, options);
 		}		
		
		if(isSaveOrderListEnabled(options)){
	 		saveOrderList(sellerCompany, options);
 		}		
		
		if(isSaveCustSvcRepListEnabled(options)){
	 		saveCustSvcRepList(sellerCompany, options);
 		}		
		
		return sellerCompany;
		
	}
	
	
	
	//======================================================================================
	
		
	protected SellerCompany saveProfitCenterList(SellerCompany sellerCompany, Map<String,Object> options){
		List<ProfitCenter> profitCenterList = sellerCompany.getProfitCenterList();
		if(profitCenterList == null){
			return sellerCompany;
		}
		if(profitCenterList.isEmpty()){
			return sellerCompany;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getProfitCenterDAO().saveList(sellerCompany.getProfitCenterList(),options);
		
		return sellerCompany;
	
	}
		
	protected SellerCompany saveCreditAccountList(SellerCompany sellerCompany, Map<String,Object> options){
		List<CreditAccount> creditAccountList = sellerCompany.getCreditAccountList();
		if(creditAccountList == null){
			return sellerCompany;
		}
		if(creditAccountList.isEmpty()){
			return sellerCompany;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getCreditAccountDAO().saveList(sellerCompany.getCreditAccountList(),options);
		
		return sellerCompany;
	
	}
		
	protected SellerCompany saveOrderList(SellerCompany sellerCompany, Map<String,Object> options){
		List<Order> orderList = sellerCompany.getOrderList();
		if(orderList == null){
			return sellerCompany;
		}
		if(orderList.isEmpty()){
			return sellerCompany;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getOrderDAO().saveList(sellerCompany.getOrderList(),options);
		
		return sellerCompany;
	
	}
		
	protected SellerCompany saveCustSvcRepList(SellerCompany sellerCompany, Map<String,Object> options){
		List<CustSvcRep> custSvcRepList = sellerCompany.getCustSvcRepList();
		if(custSvcRepList == null){
			return sellerCompany;
		}
		if(custSvcRepList.isEmpty()){
			return sellerCompany;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getCustSvcRepDAO().saveList(sellerCompany.getCustSvcRepList(),options);
		
		return sellerCompany;
	
	}
		

	
}


