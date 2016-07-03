
package com.terapico.b2b.processing;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.terapico.b2b.CommonJDBCTemplateDAO;
import com.terapico.b2b.order.Order;

import com.terapico.b2b.order.OrderDAO;


import org.springframework.dao.EmptyResultDataAccessException;

public class ProcessingJDBCTemplateDAO extends CommonJDBCTemplateDAO implements ProcessingDAO{

		
	
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
 	
			
		

	public Processing load(String processingId,Map<String,Object> options) throws Exception{
		return loadInternalProcessing(processingId, options);
	}
	public Processing save(Processing processing,Map<String,Object> options){
		
		String methodName="save(Processing processing,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(processing, methodName, "processing");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalProcessing(processing,options);
	}
	public Processing clone(String processingId,Map<String,Object> options) throws Exception{
	
		String methodName="clone(String processingId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(processingId, methodName, "processingId");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Processing newProcessing = load(processingId, options);
		newProcessing.setVersion(0);
		
		
 		
 		if(isSaveOrderListEnabled(options)){
 			for(Order item: newProcessing.getOrderList()){
 				item.setVersion(0);
 			}
 		}
		
		
		saveInternalProcessing(newProcessing,options);
		
		return newProcessing;
	}
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = getJdbcTemplateObject().update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String processingId, int version) throws  ProcessingVersionChangedException,  ProcessingNotFoundException {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{processingId};
		int count = getJdbcTemplateObject().queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new ProcessingVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ProcessingNotFoundException(
					"The " + this.getTableName() + "(" + processingId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String processingId, int version) throws Exception{
	
		String methodName="delete(String processingId, int version)";
		assertMethodArgumentNotNull(processingId, methodName, "processingId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{processingId,version};
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(processingId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"who","process_time"};
	}
	@Override
	protected String getName() {
		
		return "processing";
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
		
 		return checkOptions(options,ProcessingTokens.ORDER_LIST);
		
 	}

	protected boolean isSaveOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, ProcessingTokens.ORDER_LIST);
		
 	}
 	
 	
			
		
	

	protected ProcessingMapper getMapper(){
		return new ProcessingMapper();
	}
	protected Processing extractProcessing(String processingId) throws Exception{
		String SQL = "select * from processing_data where id=?";	
		try{
		
			Processing processing = getJdbcTemplateObject().queryForObject(SQL, new Object[]{processingId}, getMapper());
			return processing;
		}catch(EmptyResultDataAccessException e){
			throw new ProcessingNotFoundException("Processing("+processingId+") is not found!");
		}
		
		
	}

	protected Processing loadInternalProcessing(String processingId, Map<String,Object> loadOptions) throws Exception{
		
		Processing processing = extractProcessing(processingId);

		
		if(isExtractOrderListEnabled(loadOptions)){
	 		extractOrderList(processing, loadOptions);
 		}		
		
		return processing;
		
	}
	
	
	
		
	protected Processing extractOrderList(Processing processing, Map<String,Object> options){
		
		List<Order> orderList = getOrderDAO().findOrderByProcessing(processing.getId());
		if(orderList != null){
			processing.setOrderList(orderList);
		}
		
		return processing;
	
	}	
		
		
 	
		
		
		
	

	protected Processing saveProcessing(Processing  processing){
	
		String SQL=this.getSaveProcessingSQL(processing);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveProcessingParameters(processing);
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		int newVersion = processing.getVersion() + 1;
		processing.setVersion(newVersion);
		return processing;
	
	}
	public List<Processing> saveList(List<Processing> processingList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitProcessingList(processingList);
		
		batchCreate((List<Processing>)lists[CREATE_LIST_INDEX]);
		
		batchUpdate((List<Processing>)lists[UPDATE_LIST_INDEX]);

		return processingList;
	}

	
	protected List<Object[]> prepareBatchCreateArgs(List<Processing> processingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Processing processing:processingList ){
			Object [] parameters = prepareCreateProcessingParameters(processing);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareBatchUpdateArgs(List<Processing> processingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Processing processing:processingList ){
			Object [] parameters = prepareUpdateProcessingParameters(processing);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchCreate(List<Processing> processingList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareBatchCreateArgs(processingList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
	}
	
	
	protected void batchUpdate(List<Processing> processingList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareBatchUpdateArgs(processingList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitProcessingList(List<Processing> processingList){
		
		List<Processing> processingCreateList=new ArrayList<Processing>();
		List<Processing> processingUpdateList=new ArrayList<Processing>();
		
		for(Processing processing: processingList){
			if(isUpdateRequest(processing)){
				processingUpdateList.add( processing);
				continue;
			}
			processingCreateList.add(processing);
		}
		
		return new Object[]{processingCreateList,processingUpdateList};
	}
	
	protected boolean isUpdateRequest(Processing processing){
 		return processing.getVersion() > 0;
 	}
 	protected String getSaveProcessingSQL(Processing processing){
 		if(isUpdateRequest(processing)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveProcessingParameters(Processing processing){
 		if(isUpdateRequest(processing) ){
 			return prepareUpdateProcessingParameters(processing);
 		}
 		return prepareCreateProcessingParameters(processing);
 	}
 	protected Object[] prepareUpdateProcessingParameters(Processing processing){
 		Object[] parameters = new Object[4];
 
 		parameters[0] = processing.getWho();
 		parameters[1] = processing.getProcessTime();		
 		parameters[2] = processing.getId();
 		parameters[3] = processing.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareCreateProcessingParameters(Processing processing){
		Object[] parameters = new Object[3];
		String newProcessingId=getNextId();
		processing.setId(newProcessingId);
		parameters[0] =  processing.getId();
 
 		parameters[1] = processing.getWho();
 		parameters[2] = processing.getProcessTime();		
 				
 		return parameters;
 	}
 	
	protected Processing saveInternalProcessing(Processing processing, Map<String,Object> options){
		
		saveProcessing(processing);

		
		if(isSaveOrderListEnabled(options)){
	 		saveOrderList(processing, options);
 		}		
		
		return processing;
		
	}
	
	
	
	//======================================================================================
	
		
	protected Processing saveOrderList(Processing processing, Map<String,Object> options){
		List<Order> orderList = processing.getOrderList();
		if(orderList == null){
			return processing;
		}
		if(orderList.isEmpty()){
			return processing;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getOrderDAO().saveList(processing.getOrderList(),options);
		
		return processing;
	
	}
		

	
}


