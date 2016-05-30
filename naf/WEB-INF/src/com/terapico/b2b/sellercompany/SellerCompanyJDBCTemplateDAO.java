
package com.terapico.b2b.sellercompany;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import com.terapico.b2b.CommonJDBCTemplateDAO;
import com.terapico.b2b.order.Order;
import com.terapico.b2b.custsvcrep.CustSvcRep;

import com.terapico.b2b.custsvcrep.CustSvcRepMapper;
import com.terapico.b2b.order.OrderMapper;

import com.terapico.b2b.custsvcrep.CustSvcRepDAO;
import com.terapico.b2b.order.OrderDAO;

public class SellerCompanyJDBCTemplateDAO extends CommonJDBCTemplateDAO implements SellerCompanyDAO{

		
	
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
 	
			
		
	
  	private  CustSvcRepDAO  custSvcRepDAO;
 	public void setCustSvcRepDAO(CustSvcRepDAO pCustSvcRepDAO){
 	
 		if(pCustSvcRepDAO == null){
 			throw new IllegalStateException("Do not trying to set custSvcRepDAO to null.");
 		}
	 	this.custSvcRepDAO = pCustSvcRepDAO;
 	}
 	public CustSvcRepDAO getCustSvcRepDAO(){
 		if(this.custSvcRepDAO == null){
 			throw new IllegalStateException("The custSvcRepDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.custSvcRepDAO;
 	}	
 	
			
		

	public SellerCompany load(String sellerCompanyId,Set<String> options) throws SellerCompanyNotFoundException{
		return loadInternalSellerCompany(sellerCompanyId, options);
	}
	public SellerCompany save(SellerCompany sellerCompany,Set<String> options){
		return saveInternalSellerCompany(sellerCompany,options);
	}
	public SellerCompany clone(String sellerCompanyId,Set<String> options) throws SellerCompanyNotFoundException{
		SellerCompany newSellerCompany = load(sellerCompanyId, options);
		newSellerCompany.setVersion(0);
		
		
 		
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
	public void delete(String sellerCompanyId, int version) throws Exception{
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{sellerCompanyId,version};
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			// two suitations here, this object has been deleted; or
			// the version has been changed, the client should reload it and ensure this can be deleted
			SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
			parameters=new Object[]{sellerCompanyId};
			int count = getJdbcTemplateObject().queryForObject(SQL, Integer.class, parameters);
			if(count == 1){
				throw new SellerCompanyVersionChangedException("The object version has been changed, please reload to delete");
			}
			if(count < 1){
				throw new SellerCompanyNotFoundException("The object alread has been deleted.");
			}
			if(count > 1){
				throw new IllegalStateException("The database PRIMARY KEY constraint has been damaged, please fix it.");
			}
		
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"name"};
	}
	@Override
	protected String getName() {
		
		return "seller_company";
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


		
	protected static final String ORDER_LIST = "orderList";
	
	protected boolean isExtractOrderListEnabled(Set<String> options){
		
 		return checkOptions(options,ORDER_LIST);
		
 	}

	protected boolean isSaveOrderListEnabled(Set<String> options){
		return checkOptions(options, ORDER_LIST);
		
 	}
 	
 	
			
		
	protected static final String CUST_SVC_REP_LIST = "custSvcRepList";
	
	protected boolean isExtractCustSvcRepListEnabled(Set<String> options){
		
 		return checkOptions(options,CUST_SVC_REP_LIST);
		
 	}

	protected boolean isSaveCustSvcRepListEnabled(Set<String> options){
		return checkOptions(options, CUST_SVC_REP_LIST);
		
 	}
 	
 	
			
		
	


	protected SellerCompany extractSellerCompany(String sellerCompanyId){
		String SQL = "select * from seller_company_data where id=?";	
		SellerCompany sellerCompany = getJdbcTemplateObject().queryForObject(SQL, new Object[]{sellerCompanyId},new SellerCompanyMapper());
		return sellerCompany;
	}

	protected SellerCompany loadInternalSellerCompany(String sellerCompanyId, Set<String> loadOptions){
		
		SellerCompany sellerCompany = extractSellerCompany(sellerCompanyId);

		
		if(isExtractOrderListEnabled(loadOptions)){
	 		extractOrderList(sellerCompany);
 		}		
		
		if(isExtractCustSvcRepListEnabled(loadOptions)){
	 		extractCustSvcRepList(sellerCompany);
 		}		
		
		return sellerCompany;
		
	}
	
	
	
		
	protected SellerCompany extractOrderList(SellerCompany sellerCompany){
		
		String SQL = "select * from order_data where seller = ?";
		List<Order> orderList = getJdbcTemplateObject().query(SQL, new Object[]{sellerCompany.getId()},new OrderMapper());
		if(orderList != null){
			sellerCompany.setOrderList(orderList);
		}
		
		return sellerCompany;
	
	}	
		
	protected SellerCompany extractCustSvcRepList(SellerCompany sellerCompany){
		
		String SQL = "select * from cust_svc_rep_data where company = ?";
		List<CustSvcRep> custSvcRepList = getJdbcTemplateObject().query(SQL, new Object[]{sellerCompany.getId()},new CustSvcRepMapper());
		if(custSvcRepList != null){
			sellerCompany.setCustSvcRepList(custSvcRepList);
		}
		
		return sellerCompany;
	
	}	
		
	

	protected SellerCompany saveSellerCompany(SellerCompany  sellerCompany){
	
		String SQL=this.getSaveSellerCompanySQL(sellerCompany);
		Object [] parameters = getSaveSellerCompanyParameters(sellerCompany);
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		return sellerCompany;
	
	}
	public List<SellerCompany> saveList(List<SellerCompany> sellerCompanyList,Set<String> options){
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
 		Object[] parameters = new Object[3];
 
 		parameters[0] = sellerCompany.getName();		
 		parameters[1] = sellerCompany.getId();
 		parameters[2] = sellerCompany.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareCreateSellerCompanyParameters(SellerCompany sellerCompany){
		Object[] parameters = new Object[2];
		String newSellerCompanyId=getNextId();
		sellerCompany.setId(newSellerCompanyId);
		parameters[0] =  sellerCompany.getId();
 
 		parameters[1] = sellerCompany.getName();		
 				
 		return parameters;
 	}
 	
	protected SellerCompany saveInternalSellerCompany(SellerCompany sellerCompany, Set<String> options){
		
		saveSellerCompany(sellerCompany);

		
		if(isSaveOrderListEnabled(options)){
	 		saveOrderList(sellerCompany);
 		}		
		
		if(isSaveCustSvcRepListEnabled(options)){
	 		saveCustSvcRepList(sellerCompany);
 		}		
		
		return sellerCompany;
		
	}
	
	
	
	//======================================================================================
	
		
	protected SellerCompany saveOrderList(SellerCompany sellerCompany){
		List<Order> orderList = sellerCompany.getOrderList();
		if(orderList==null){
			return sellerCompany;
		}
		if(orderList.isEmpty()){
			return sellerCompany;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		Set<String> options = new HashSet<String>();
		getOrderDAO().saveList(sellerCompany.getOrderList(),options);
		
		return sellerCompany;
	
	}
		
	protected SellerCompany saveCustSvcRepList(SellerCompany sellerCompany){
		List<CustSvcRep> custSvcRepList = sellerCompany.getCustSvcRepList();
		if(custSvcRepList==null){
			return sellerCompany;
		}
		if(custSvcRepList.isEmpty()){
			return sellerCompany;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		Set<String> options = new HashSet<String>();
		getCustSvcRepDAO().saveList(sellerCompany.getCustSvcRepList(),options);
		
		return sellerCompany;
	
	}
		

}


