
package com.terapico.b2b.confirmation;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.terapico.b2b.CommonJDBCTemplateDAO;
import com.terapico.b2b.order.Order;

import com.terapico.b2b.order.OrderDAO;


import org.springframework.dao.EmptyResultDataAccessException;

public class ConfirmationJDBCTemplateDAO extends CommonJDBCTemplateDAO implements ConfirmationDAO{

		
	
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
 	
			
		

	public Confirmation load(String confirmationId,Map<String,Object> options) throws Exception{
		return loadInternalConfirmation(confirmationId, options);
	}
	public Confirmation save(Confirmation confirmation,Map<String,Object> options){
		
		String methodName="save(Confirmation confirmation,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(confirmation, methodName, "confirmation");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalConfirmation(confirmation,options);
	}
	public Confirmation clone(String confirmationId,Map<String,Object> options) throws Exception{
	
		String methodName="clone(String confirmationId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(confirmationId, methodName, "confirmationId");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Confirmation newConfirmation = load(confirmationId, options);
		newConfirmation.setVersion(0);
		
		
 		
 		if(isSaveOrderListEnabled(options)){
 			for(Order item: newConfirmation.getOrderList()){
 				item.setVersion(0);
 			}
 		}
		
		
		saveInternalConfirmation(newConfirmation,options);
		
		return newConfirmation;
	}
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = getJdbcTemplateObject().update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String confirmationId, int version) throws  ConfirmationVersionChangedException,  ConfirmationNotFoundException {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{confirmationId};
		int count = getJdbcTemplateObject().queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new ConfirmationVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ConfirmationNotFoundException(
					"The " + this.getTableName() + "(" + confirmationId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String confirmationId, int version) throws Exception{
	
		String methodName="delete(String confirmationId, int version)";
		assertMethodArgumentNotNull(confirmationId, methodName, "confirmationId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{confirmationId,version};
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(confirmationId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"who","confirm_time"};
	}
	@Override
	protected String getName() {
		
		return "confirmation";
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
		
 		return checkOptions(options,ConfirmationTokens.ORDER_LIST);
		
 	}

	protected boolean isSaveOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, ConfirmationTokens.ORDER_LIST);
		
 	}
 	
 	
			
		
	

	protected ConfirmationMapper getMapper(){
		return new ConfirmationMapper();
	}
	protected Confirmation extractConfirmation(String confirmationId) throws Exception{
		String SQL = "select * from confirmation_data where id=?";	
		try{
		
			Confirmation confirmation = getJdbcTemplateObject().queryForObject(SQL, new Object[]{confirmationId}, getMapper());
			return confirmation;
		}catch(EmptyResultDataAccessException e){
			throw new ConfirmationNotFoundException("Confirmation("+confirmationId+") is not found!");
		}
		
		
	}

	protected Confirmation loadInternalConfirmation(String confirmationId, Map<String,Object> loadOptions) throws Exception{
		
		Confirmation confirmation = extractConfirmation(confirmationId);

		
		if(isExtractOrderListEnabled(loadOptions)){
	 		extractOrderList(confirmation, loadOptions);
 		}		
		
		return confirmation;
		
	}
	
	
	
		
	protected Confirmation extractOrderList(Confirmation confirmation, Map<String,Object> options){
		
		List<Order> orderList = getOrderDAO().findOrderByConfirmation(confirmation.getId());
		if(orderList != null){
			confirmation.setOrderList(orderList);
		}
		
		return confirmation;
	
	}	
		
		
 	
		
		
		
	

	protected Confirmation saveConfirmation(Confirmation  confirmation){
	
		String SQL=this.getSaveConfirmationSQL(confirmation);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveConfirmationParameters(confirmation);
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		int newVersion = confirmation.getVersion() + 1;
		confirmation.setVersion(newVersion);
		return confirmation;
	
	}
	public List<Confirmation> saveList(List<Confirmation> confirmationList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitConfirmationList(confirmationList);
		
		batchCreate((List<Confirmation>)lists[CREATE_LIST_INDEX]);
		
		batchUpdate((List<Confirmation>)lists[UPDATE_LIST_INDEX]);

		return confirmationList;
	}

	
	protected List<Object[]> prepareBatchCreateArgs(List<Confirmation> confirmationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Confirmation confirmation:confirmationList ){
			Object [] parameters = prepareCreateConfirmationParameters(confirmation);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareBatchUpdateArgs(List<Confirmation> confirmationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Confirmation confirmation:confirmationList ){
			Object [] parameters = prepareUpdateConfirmationParameters(confirmation);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchCreate(List<Confirmation> confirmationList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareBatchCreateArgs(confirmationList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
	}
	
	
	protected void batchUpdate(List<Confirmation> confirmationList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareBatchUpdateArgs(confirmationList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitConfirmationList(List<Confirmation> confirmationList){
		
		List<Confirmation> confirmationCreateList=new ArrayList<Confirmation>();
		List<Confirmation> confirmationUpdateList=new ArrayList<Confirmation>();
		
		for(Confirmation confirmation: confirmationList){
			if(isUpdateRequest(confirmation)){
				confirmationUpdateList.add( confirmation);
				continue;
			}
			confirmationCreateList.add(confirmation);
		}
		
		return new Object[]{confirmationCreateList,confirmationUpdateList};
	}
	
	protected boolean isUpdateRequest(Confirmation confirmation){
 		return confirmation.getVersion() > 0;
 	}
 	protected String getSaveConfirmationSQL(Confirmation confirmation){
 		if(isUpdateRequest(confirmation)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveConfirmationParameters(Confirmation confirmation){
 		if(isUpdateRequest(confirmation) ){
 			return prepareUpdateConfirmationParameters(confirmation);
 		}
 		return prepareCreateConfirmationParameters(confirmation);
 	}
 	protected Object[] prepareUpdateConfirmationParameters(Confirmation confirmation){
 		Object[] parameters = new Object[4];
 
 		parameters[0] = confirmation.getWho();
 		parameters[1] = confirmation.getConfirmTime();		
 		parameters[2] = confirmation.getId();
 		parameters[3] = confirmation.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareCreateConfirmationParameters(Confirmation confirmation){
		Object[] parameters = new Object[3];
		String newConfirmationId=getNextId();
		confirmation.setId(newConfirmationId);
		parameters[0] =  confirmation.getId();
 
 		parameters[1] = confirmation.getWho();
 		parameters[2] = confirmation.getConfirmTime();		
 				
 		return parameters;
 	}
 	
	protected Confirmation saveInternalConfirmation(Confirmation confirmation, Map<String,Object> options){
		
		saveConfirmation(confirmation);

		
		if(isSaveOrderListEnabled(options)){
	 		saveOrderList(confirmation, options);
 		}		
		
		return confirmation;
		
	}
	
	
	
	//======================================================================================
	
		
	protected Confirmation saveOrderList(Confirmation confirmation, Map<String,Object> options){
		List<Order> orderList = confirmation.getOrderList();
		if(orderList == null){
			return confirmation;
		}
		if(orderList.isEmpty()){
			return confirmation;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getOrderDAO().saveList(confirmation.getOrderList(),options);
		
		return confirmation;
	
	}
		

	
}


