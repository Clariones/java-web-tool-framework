
package com.terapico.b2b.action;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import com.terapico.b2b.CommonJDBCTemplateDAO;
import com.terapico.b2b.order.Order;

import com.terapico.b2b.order.OrderDAO;

public class ActionJDBCTemplateDAO extends CommonJDBCTemplateDAO implements ActionDAO{
 
 	
 	private  OrderDAO  orderDAO;
 	public void setOrderDAO(OrderDAO orderDAO){
	 	this.orderDAO = orderDAO;
 	}
 	public OrderDAO getOrderDAO(){
	 	return this.orderDAO;
 	}

		

	public Action load(String actionId,Map<String,Object> options) throws Exception{
		return loadInternalAction(actionId, options);
	}
	public Action save(Action action,Map<String,Object> options){
		
		String methodName="save(Action action,Map<String,Object> options){";
		
		assertMethodArgumentNotNull(action, methodName, "action");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalAction(action,options);
	}
	public Action clone(String actionId,Map<String,Object> options) throws Exception{
	
		String methodName="clone(String actionId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(actionId, methodName, "actionId");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Action newAction = load(actionId, options);
		newAction.setVersion(0);
		
		
		
		saveInternalAction(newAction,options);
		
		return newAction;
	}
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = getJdbcTemplateObject().update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String actionId, int version) throws  ActionVersionChangedException,  ActionNotFoundException {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{actionId};
		int count = getJdbcTemplateObject().queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new ActionVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ActionNotFoundException(
					"The " + this.getTableName() + "(" + actionId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String actionId, int version) throws Exception{
	
		String methodName="delete(String actionId, int version)";
		assertMethodArgumentNotNull(actionId, methodName, "actionId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{actionId,version};
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(actionId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"name","internal_name","bo"};
	}
	@Override
	protected String getName() {
		
		return "action";
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

 
 	//private boolean extractBoEnabled = true;
 	private static final String BO = "bo";
 	protected boolean isExtractBoEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, BO);
 	}
 	
 	
 	//private boolean saveBoEnabled = true;
 	protected boolean isSaveBoEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, BO);
 	}
 	

 	
 
		
	

	protected ActionMapper getMapper(){
		return new ActionMapper();
	}
	protected Action extractAction(String actionId){
		String SQL = "select * from action_data where id=?";	
		Action action = getJdbcTemplateObject().queryForObject(SQL, new Object[]{actionId}, getMapper());
		return action;
	}

	protected Action loadInternalAction(String actionId, Map<String,Object> loadOptions) throws Exception{
		
		Action action = extractAction(actionId);
 	
 		if(isExtractBoEnabled(loadOptions)){
	 		extractBo(action, loadOptions);
 		}
 
		
		return action;
		
	}
	
	
	 

 	protected Action extractBo(Action action, Map<String,Object> options) throws Exception{

		if(action.getBo() == null){
			return action;
		}
		String boId = action.getBo().getId();
		if( boId == null){
			return action;
		}
		Order bo = getOrderDAO().load(boId,options);
		if(bo != null){
			action.setBo(bo);
		}
		
 		
 		return action;
 	}
 		
 
		
		
  	
 	public List<Action> findActionByBo(String orderId){
 	
 		String SQL = "select * from "+this.getTableName()+" where bo = ?";
		List<Action> actionList = getJdbcTemplateObject().query(SQL, new Object[]{orderId}, getMapper());
		
 	
 		return actionList;
 	}
 	
		
		
		
	

	protected Action saveAction(Action  action){
	
		String SQL=this.getSaveActionSQL(action);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveActionParameters(action);
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		int newVersion = action.getVersion() + 1;
		action.setVersion(newVersion);
		return action;
	
	}
	public List<Action> saveList(List<Action> actionList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitActionList(actionList);
		
		batchCreate((List<Action>)lists[CREATE_LIST_INDEX]);
		
		batchUpdate((List<Action>)lists[UPDATE_LIST_INDEX]);

		return actionList;
	}

	
	protected List<Object[]> prepareBatchCreateArgs(List<Action> actionList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Action action:actionList ){
			Object [] parameters = prepareCreateActionParameters(action);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareBatchUpdateArgs(List<Action> actionList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Action action:actionList ){
			Object [] parameters = prepareUpdateActionParameters(action);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchCreate(List<Action> actionList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareBatchCreateArgs(actionList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
	}
	
	
	protected void batchUpdate(List<Action> actionList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareBatchUpdateArgs(actionList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitActionList(List<Action> actionList){
		
		List<Action> actionCreateList=new ArrayList<Action>();
		List<Action> actionUpdateList=new ArrayList<Action>();
		
		for(Action action: actionList){
			if(isUpdateRequest(action)){
				actionUpdateList.add( action);
				continue;
			}
			actionCreateList.add(action);
		}
		
		return new Object[]{actionCreateList,actionUpdateList};
	}
	
	protected boolean isUpdateRequest(Action action){
 		return action.getVersion() > 0;
 	}
 	protected String getSaveActionSQL(Action action){
 		if(isUpdateRequest(action)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveActionParameters(Action action){
 		if(isUpdateRequest(action) ){
 			return prepareUpdateActionParameters(action);
 		}
 		return prepareCreateActionParameters(action);
 	}
 	protected Object[] prepareUpdateActionParameters(Action action){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = action.getName();
 		parameters[1] = action.getInternalName(); 	
 		if(action.getBo() != null){
 			parameters[2] = action.getBo().getId();
 		}
 		
 		parameters[3] = action.getId();
 		parameters[4] = action.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareCreateActionParameters(Action action){
		Object[] parameters = new Object[4];
		String newActionId=getNextId();
		action.setId(newActionId);
		parameters[0] =  action.getId();
 
 		parameters[1] = action.getName();
 		parameters[2] = action.getInternalName(); 	
 		if(action.getBo() != null){
 			parameters[3] = action.getBo().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected Action saveInternalAction(Action action, Map<String,Object> options){
		
		saveAction(action);
 	
 		if(isSaveBoEnabled(options)){
	 		saveBo(action, options);
 		}
 
		
		return action;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Action saveBo(Action action, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		getOrderDAO().save(action.getBo(),options);
 		return action;
 		
 	}
	
 
		

	
}






