
package com.terapico.b2b.costcenter;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.terapico.b2b.CommonJDBCTemplateDAO;
import com.terapico.b2b.order.Order;
import com.terapico.b2b.buyercompany.BuyerCompany;

import com.terapico.b2b.buyercompany.BuyerCompanyDAO;
import com.terapico.b2b.order.OrderDAO;


import org.springframework.dao.EmptyResultDataAccessException;

public class CostCenterJDBCTemplateDAO extends CommonJDBCTemplateDAO implements CostCenterDAO{
 
 	
 	private  BuyerCompanyDAO  buyerCompanyDAO;
 	public void setBuyerCompanyDAO(BuyerCompanyDAO buyerCompanyDAO){
	 	this.buyerCompanyDAO = buyerCompanyDAO;
 	}
 	public BuyerCompanyDAO getBuyerCompanyDAO(){
	 	return this.buyerCompanyDAO;
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
 	
			
		

	public CostCenter load(String costCenterId,Map<String,Object> options) throws Exception{
		return loadInternalCostCenter(costCenterId, options);
	}
	public CostCenter save(CostCenter costCenter,Map<String,Object> options){
		
		String methodName="save(CostCenter costCenter,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(costCenter, methodName, "costCenter");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalCostCenter(costCenter,options);
	}
	public CostCenter clone(String costCenterId,Map<String,Object> options) throws Exception{
	
		String methodName="clone(String costCenterId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(costCenterId, methodName, "costCenterId");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		CostCenter newCostCenter = load(costCenterId, options);
		newCostCenter.setVersion(0);
		
		
 		
 		if(isSaveOrderListEnabled(options)){
 			for(Order item: newCostCenter.getOrderList()){
 				item.setVersion(0);
 			}
 		}
		
		
		saveInternalCostCenter(newCostCenter,options);
		
		return newCostCenter;
	}
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = getJdbcTemplateObject().update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String costCenterId, int version) throws  CostCenterVersionChangedException,  CostCenterNotFoundException {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{costCenterId};
		int count = getJdbcTemplateObject().queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new CostCenterVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new CostCenterNotFoundException(
					"The " + this.getTableName() + "(" + costCenterId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String costCenterId, int version) throws Exception{
	
		String methodName="delete(String costCenterId, int version)";
		assertMethodArgumentNotNull(costCenterId, methodName, "costCenterId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{costCenterId,version};
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(costCenterId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"name","belongs_to"};
	}
	@Override
	protected String getName() {
		
		return "cost_center";
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

 
 	//private boolean extractBelongsToEnabled = true;
 	//private static final String BELONGSTO = "belongsTo";
 	protected boolean isExtractBelongsToEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, CostCenterTokens.BELONGSTO);
 	}
 	
 	
 	//private boolean saveBelongsToEnabled = true;
 	protected boolean isSaveBelongsToEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, CostCenterTokens.BELONGSTO);
 	}
 	

 	
 
		
	//protected static final String ORDER_LIST = "orderList";
	
	protected boolean isExtractOrderListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,CostCenterTokens.ORDER_LIST);
		
 	}

	protected boolean isSaveOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, CostCenterTokens.ORDER_LIST);
		
 	}
 	
 	
			
		
	

	protected CostCenterMapper getMapper(){
		return new CostCenterMapper();
	}
	protected CostCenter extractCostCenter(String costCenterId) throws Exception{
		String SQL = "select * from cost_center_data where id=?";	
		try{
		
			CostCenter costCenter = getJdbcTemplateObject().queryForObject(SQL, new Object[]{costCenterId}, getMapper());
			return costCenter;
		}catch(EmptyResultDataAccessException e){
			throw new CostCenterNotFoundException("CostCenter("+costCenterId+") is not found!");
		}
		
		
	}

	protected CostCenter loadInternalCostCenter(String costCenterId, Map<String,Object> loadOptions) throws Exception{
		
		CostCenter costCenter = extractCostCenter(costCenterId);
 	
 		if(isExtractBelongsToEnabled(loadOptions)){
	 		extractBelongsTo(costCenter, loadOptions);
 		}
 
		
		if(isExtractOrderListEnabled(loadOptions)){
	 		extractOrderList(costCenter, loadOptions);
 		}		
		
		return costCenter;
		
	}
	
	
	 

 	protected CostCenter extractBelongsTo(CostCenter costCenter, Map<String,Object> options) throws Exception{

		if(costCenter.getBelongsTo() == null){
			return costCenter;
		}
		String belongsToId = costCenter.getBelongsTo().getId();
		if( belongsToId == null){
			return costCenter;
		}
		BuyerCompany belongsTo = getBuyerCompanyDAO().load(belongsToId,options);
		if(belongsTo != null){
			costCenter.setBelongsTo(belongsTo);
		}
		
 		
 		return costCenter;
 	}
 		
 
		
	protected CostCenter extractOrderList(CostCenter costCenter, Map<String,Object> options){
		
		List<Order> orderList = getOrderDAO().findOrderByCostCenter(costCenter.getId());
		if(orderList != null){
			costCenter.setOrderList(orderList);
		}
		
		return costCenter;
	
	}	
		
		
  	
 	public List<CostCenter> findCostCenterByBelongsTo(String buyerCompanyId){
 	
 		String SQL = "select * from "+this.getTableName()+" where belongs_to = ?";
		List<CostCenter> costCenterList = getJdbcTemplateObject().query(SQL, new Object[]{buyerCompanyId}, getMapper());
		
 	
 		return costCenterList;
 	}
 	
		
		
		
	

	protected CostCenter saveCostCenter(CostCenter  costCenter){
	
		String SQL=this.getSaveCostCenterSQL(costCenter);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveCostCenterParameters(costCenter);
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		int newVersion = costCenter.getVersion() + 1;
		costCenter.setVersion(newVersion);
		return costCenter;
	
	}
	public List<CostCenter> saveList(List<CostCenter> costCenterList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitCostCenterList(costCenterList);
		
		batchCreate((List<CostCenter>)lists[CREATE_LIST_INDEX]);
		
		batchUpdate((List<CostCenter>)lists[UPDATE_LIST_INDEX]);

		return costCenterList;
	}

	
	protected List<Object[]> prepareBatchCreateArgs(List<CostCenter> costCenterList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(CostCenter costCenter:costCenterList ){
			Object [] parameters = prepareCreateCostCenterParameters(costCenter);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareBatchUpdateArgs(List<CostCenter> costCenterList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(CostCenter costCenter:costCenterList ){
			Object [] parameters = prepareUpdateCostCenterParameters(costCenter);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchCreate(List<CostCenter> costCenterList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareBatchCreateArgs(costCenterList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
	}
	
	
	protected void batchUpdate(List<CostCenter> costCenterList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareBatchUpdateArgs(costCenterList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitCostCenterList(List<CostCenter> costCenterList){
		
		List<CostCenter> costCenterCreateList=new ArrayList<CostCenter>();
		List<CostCenter> costCenterUpdateList=new ArrayList<CostCenter>();
		
		for(CostCenter costCenter: costCenterList){
			if(isUpdateRequest(costCenter)){
				costCenterUpdateList.add( costCenter);
				continue;
			}
			costCenterCreateList.add(costCenter);
		}
		
		return new Object[]{costCenterCreateList,costCenterUpdateList};
	}
	
	protected boolean isUpdateRequest(CostCenter costCenter){
 		return costCenter.getVersion() > 0;
 	}
 	protected String getSaveCostCenterSQL(CostCenter costCenter){
 		if(isUpdateRequest(costCenter)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveCostCenterParameters(CostCenter costCenter){
 		if(isUpdateRequest(costCenter) ){
 			return prepareUpdateCostCenterParameters(costCenter);
 		}
 		return prepareCreateCostCenterParameters(costCenter);
 	}
 	protected Object[] prepareUpdateCostCenterParameters(CostCenter costCenter){
 		Object[] parameters = new Object[4];
 
 		parameters[0] = costCenter.getName(); 	
 		if(costCenter.getBelongsTo() != null){
 			parameters[1] = costCenter.getBelongsTo().getId();
 		}
 		
 		parameters[2] = costCenter.getId();
 		parameters[3] = costCenter.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareCreateCostCenterParameters(CostCenter costCenter){
		Object[] parameters = new Object[3];
		String newCostCenterId=getNextId();
		costCenter.setId(newCostCenterId);
		parameters[0] =  costCenter.getId();
 
 		parameters[1] = costCenter.getName(); 	
 		if(costCenter.getBelongsTo() != null){
 			parameters[2] = costCenter.getBelongsTo().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected CostCenter saveInternalCostCenter(CostCenter costCenter, Map<String,Object> options){
		
		saveCostCenter(costCenter);
 	
 		if(isSaveBelongsToEnabled(options)){
	 		saveBelongsTo(costCenter, options);
 		}
 
		
		if(isSaveOrderListEnabled(options)){
	 		saveOrderList(costCenter, options);
 		}		
		
		return costCenter;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected CostCenter saveBelongsTo(CostCenter costCenter, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		getBuyerCompanyDAO().save(costCenter.getBelongsTo(),options);
 		return costCenter;
 		
 	}
	
 
		
	protected CostCenter saveOrderList(CostCenter costCenter, Map<String,Object> options){
		List<Order> orderList = costCenter.getOrderList();
		if(orderList == null){
			return costCenter;
		}
		if(orderList.isEmpty()){
			return costCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getOrderDAO().saveList(costCenter.getOrderList(),options);
		
		return costCenter;
	
	}
		

	
}


