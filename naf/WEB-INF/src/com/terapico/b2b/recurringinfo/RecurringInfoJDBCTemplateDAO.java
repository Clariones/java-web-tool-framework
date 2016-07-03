
package com.terapico.b2b.recurringinfo;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.terapico.b2b.CommonJDBCTemplateDAO;
import com.terapico.b2b.order.Order;

import com.terapico.b2b.order.OrderDAO;


import org.springframework.dao.EmptyResultDataAccessException;

public class RecurringInfoJDBCTemplateDAO extends CommonJDBCTemplateDAO implements RecurringInfoDAO{

		
	
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
 	
			
		

	public RecurringInfo load(String recurringInfoId,Map<String,Object> options) throws Exception{
		return loadInternalRecurringInfo(recurringInfoId, options);
	}
	public RecurringInfo save(RecurringInfo recurringInfo,Map<String,Object> options){
		
		String methodName="save(RecurringInfo recurringInfo,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(recurringInfo, methodName, "recurringInfo");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRecurringInfo(recurringInfo,options);
	}
	public RecurringInfo clone(String recurringInfoId,Map<String,Object> options) throws Exception{
	
		String methodName="clone(String recurringInfoId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(recurringInfoId, methodName, "recurringInfoId");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		RecurringInfo newRecurringInfo = load(recurringInfoId, options);
		newRecurringInfo.setVersion(0);
		
		
 		
 		if(isSaveOrderListEnabled(options)){
 			for(Order item: newRecurringInfo.getOrderList()){
 				item.setVersion(0);
 			}
 		}
		
		
		saveInternalRecurringInfo(newRecurringInfo,options);
		
		return newRecurringInfo;
	}
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = getJdbcTemplateObject().update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String recurringInfoId, int version) throws  RecurringInfoVersionChangedException,  RecurringInfoNotFoundException {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{recurringInfoId};
		int count = getJdbcTemplateObject().queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new RecurringInfoVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RecurringInfoNotFoundException(
					"The " + this.getTableName() + "(" + recurringInfoId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String recurringInfoId, int version) throws Exception{
	
		String methodName="delete(String recurringInfoId, int version)";
		assertMethodArgumentNotNull(recurringInfoId, methodName, "recurringInfoId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{recurringInfoId,version};
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(recurringInfoId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"name","next_time","cron_expr"};
	}
	@Override
	protected String getName() {
		
		return "recurring_info";
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


		
	//protected static final String ORDER_LIST = "orderList";
	
	protected boolean isExtractOrderListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RecurringInfoTokens.ORDER_LIST);
		
 	}

	protected boolean isSaveOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, RecurringInfoTokens.ORDER_LIST);
		
 	}
 	
 	
			
		
	

	protected RecurringInfoMapper getMapper(){
		return new RecurringInfoMapper();
	}
	protected RecurringInfo extractRecurringInfo(String recurringInfoId) throws Exception{
		String SQL = "select * from recurring_info_data where id=?";	
		try{
		
			RecurringInfo recurringInfo = getJdbcTemplateObject().queryForObject(SQL, new Object[]{recurringInfoId}, getMapper());
			return recurringInfo;
		}catch(EmptyResultDataAccessException e){
			throw new RecurringInfoNotFoundException("RecurringInfo("+recurringInfoId+") is not found!");
		}
		
		
	}

	protected RecurringInfo loadInternalRecurringInfo(String recurringInfoId, Map<String,Object> loadOptions) throws Exception{
		
		RecurringInfo recurringInfo = extractRecurringInfo(recurringInfoId);

		
		if(isExtractOrderListEnabled(loadOptions)){
	 		extractOrderList(recurringInfo, loadOptions);
 		}		
		
		return recurringInfo;
		
	}
	
	
	
		
	protected RecurringInfo extractOrderList(RecurringInfo recurringInfo, Map<String,Object> options){
		
		List<Order> orderList = getOrderDAO().findOrderByRecurringInfo(recurringInfo.getId());
		if(orderList != null){
			recurringInfo.setOrderList(orderList);
		}
		
		return recurringInfo;
	
	}	
		
		
 	
		
		
		
	

	protected RecurringInfo saveRecurringInfo(RecurringInfo  recurringInfo){
	
		String SQL=this.getSaveRecurringInfoSQL(recurringInfo);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRecurringInfoParameters(recurringInfo);
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		int newVersion = recurringInfo.getVersion() + 1;
		recurringInfo.setVersion(newVersion);
		return recurringInfo;
	
	}
	public List<RecurringInfo> saveList(List<RecurringInfo> recurringInfoList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRecurringInfoList(recurringInfoList);
		
		batchCreate((List<RecurringInfo>)lists[CREATE_LIST_INDEX]);
		
		batchUpdate((List<RecurringInfo>)lists[UPDATE_LIST_INDEX]);

		return recurringInfoList;
	}

	
	protected List<Object[]> prepareBatchCreateArgs(List<RecurringInfo> recurringInfoList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RecurringInfo recurringInfo:recurringInfoList ){
			Object [] parameters = prepareCreateRecurringInfoParameters(recurringInfo);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareBatchUpdateArgs(List<RecurringInfo> recurringInfoList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RecurringInfo recurringInfo:recurringInfoList ){
			Object [] parameters = prepareUpdateRecurringInfoParameters(recurringInfo);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchCreate(List<RecurringInfo> recurringInfoList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareBatchCreateArgs(recurringInfoList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
	}
	
	
	protected void batchUpdate(List<RecurringInfo> recurringInfoList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareBatchUpdateArgs(recurringInfoList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRecurringInfoList(List<RecurringInfo> recurringInfoList){
		
		List<RecurringInfo> recurringInfoCreateList=new ArrayList<RecurringInfo>();
		List<RecurringInfo> recurringInfoUpdateList=new ArrayList<RecurringInfo>();
		
		for(RecurringInfo recurringInfo: recurringInfoList){
			if(isUpdateRequest(recurringInfo)){
				recurringInfoUpdateList.add( recurringInfo);
				continue;
			}
			recurringInfoCreateList.add(recurringInfo);
		}
		
		return new Object[]{recurringInfoCreateList,recurringInfoUpdateList};
	}
	
	protected boolean isUpdateRequest(RecurringInfo recurringInfo){
 		return recurringInfo.getVersion() > 0;
 	}
 	protected String getSaveRecurringInfoSQL(RecurringInfo recurringInfo){
 		if(isUpdateRequest(recurringInfo)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRecurringInfoParameters(RecurringInfo recurringInfo){
 		if(isUpdateRequest(recurringInfo) ){
 			return prepareUpdateRecurringInfoParameters(recurringInfo);
 		}
 		return prepareCreateRecurringInfoParameters(recurringInfo);
 	}
 	protected Object[] prepareUpdateRecurringInfoParameters(RecurringInfo recurringInfo){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = recurringInfo.getName();
 		parameters[1] = recurringInfo.getNextTime();
 		parameters[2] = recurringInfo.getCronExpr();		
 		parameters[3] = recurringInfo.getId();
 		parameters[4] = recurringInfo.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareCreateRecurringInfoParameters(RecurringInfo recurringInfo){
		Object[] parameters = new Object[4];
		String newRecurringInfoId=getNextId();
		recurringInfo.setId(newRecurringInfoId);
		parameters[0] =  recurringInfo.getId();
 
 		parameters[1] = recurringInfo.getName();
 		parameters[2] = recurringInfo.getNextTime();
 		parameters[3] = recurringInfo.getCronExpr();		
 				
 		return parameters;
 	}
 	
	protected RecurringInfo saveInternalRecurringInfo(RecurringInfo recurringInfo, Map<String,Object> options){
		
		saveRecurringInfo(recurringInfo);

		
		if(isSaveOrderListEnabled(options)){
	 		saveOrderList(recurringInfo, options);
 		}		
		
		return recurringInfo;
		
	}
	
	
	
	//======================================================================================
	
		
	protected RecurringInfo saveOrderList(RecurringInfo recurringInfo, Map<String,Object> options){
		List<Order> orderList = recurringInfo.getOrderList();
		if(orderList == null){
			return recurringInfo;
		}
		if(orderList.isEmpty()){
			return recurringInfo;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getOrderDAO().saveList(recurringInfo.getOrderList(),options);
		
		return recurringInfo;
	
	}
		

	
}


