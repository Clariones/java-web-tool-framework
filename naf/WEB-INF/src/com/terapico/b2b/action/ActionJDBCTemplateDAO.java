
package com.terapico.b2b.action;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
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

		

	public Action load(String actionId,Set<String> options) throws Exception{
		return loadInternalAction(actionId, options);
	}
	public Action save(Action action,Set<String> options){
		
		String methodName="save(Action action,Set<String> options){";
		
		assertMethodArgumentNotNull(action, methodName, "action");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalAction(action,options);
	}
	public Action clone(String actionId,Set<String> options) throws Exception{
	
		String methodName="clone(String actionId,Set<String> options)";
		
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
			// two suitations here, this object has been deleted; or
			// the version has been changed, the client should reload it and ensure this can be deleted
			SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
			parameters=new Object[]{actionId};
			int count = getJdbcTemplateObject().queryForObject(SQL, Integer.class, parameters);
			if(count == 1){
				throw new ActionVersionChangedException("The object version has been changed, please reload to delete");
			}
			if(count < 1){
				throw new ActionNotFoundException("The "+this.getTableName()+"("+actionId+") has already been deleted.");
			}
			if(count > 1){
				throw new IllegalStateException("The table '"+this.getTableName()+"' PRIMARY KEY constraint has been damaged, please fix it.");
			}
		
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

 
 	//private boolean extractBoEnabled = true;
 	private static final String BO = "bo";
 	protected boolean isExtractBoEnabled(Set<String> options){
 		
	 	return checkOptions(options, BO);
 	}
 	
 	
 	//private boolean saveBoEnabled = true;
 	protected boolean isSaveBoEnabled(Set<String> options){
	 	
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

	protected Action loadInternalAction(String actionId, Set<String> loadOptions) throws Exception{
		
		Action action = extractAction(actionId);
 	
 		if(isExtractBoEnabled(loadOptions)){
	 		extractBo(action);
 		}
 
		
		return action;
		
	}
	
	
	 

 	protected Action extractBo(Action action) throws Exception{

		Set<String> options = new HashSet<String>();
		Order bo = getOrderDAO().load(action.getBo().getId(),options);
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
		return action;
	
	}
	public List<Action> saveList(List<Action> actionList,Set<String> options){
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
 	
	protected Action saveInternalAction(Action action, Set<String> options){
		
		saveAction(action);
 	
 		if(isSaveBoEnabled(options)){
	 		saveBo(action);
 		}
 
		
		return action;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Action saveBo(Action action){
 		//Call inject DAO to execute this method
 		Set<String> options = new HashSet<String>();
 		
 		getOrderDAO().save(action.getBo(),options);
 		return action;
 		
 	}
	
 
		
	protected void assertMethodArgumentNotNull(Object object, String method, String parameterName){
		if(object == null){
			throw new IllegalArgumentException("Method:" + method +": parameter '"+parameterName+"' shoud NOT be null");
		}
	}
	protected void assertMethodIntArgumentGreaterThan(int value, int targetValue,String method, String parameterName){
		if(value <= targetValue){
			throw new IllegalArgumentException("Method:" + method +": parameter '"+parameterName+"' shoud greater than " + targetValue +" but it is: "+ value);
		}
	}
	protected void assertMethodIntArgumentLessThan(int value, int targetValue,String method, String parameterName){
		if(value >= targetValue){
			throw new IllegalArgumentException("Method:" + method +": parameter '"+parameterName+"' shoud less than " + targetValue +" but it is: "+ value);
		}
	}
	
	protected void assertMethodIntArgumentInClosedRange(int value, int startValue, int endValue, String method, String parameterName){
		
		if(startValue>endValue){
			throw new IllegalArgumentException("When calling the check method, please note your parameter, endValue < startValue");
		}
	
		if(value < startValue){
			throw new IllegalArgumentException("Method:" + method +": parameter '"+parameterName+"' shoud be in closed range: ["+startValue+","+endValue+"] but it is: "+value);
		}
		if(value > endValue){
			throw new IllegalArgumentException("Method:" + method +": parameter '"+parameterName+"' shoud be in closed range: ["+startValue+","+endValue+"] but it is: "+value);
		}
	}
	protected void assertMethodStringArgumentLengthInClosedRange(String value, int lengthMin, int lengthMax, String method, String parameterName){
		
		if(lengthMin < 0){
			throw new IllegalArgumentException("The method assertMethodStringArgumentLengthInClosedRange lengMin should not less than 0");
		}
		
		if(lengthMin > lengthMax){
			throw new IllegalArgumentException("The method assertMethodStringArgumentLengthInClosedRange lengMin less or equal lengthMax");
		}
		
		if(value == null){		
			throw new IllegalArgumentException("Method:" + method +": parameter '"+parameterName+"' length shoud be in closed range: ["+lengthMin+","+lengthMax+"] but it is null");
		}
		if(value.length() < lengthMin){
			throw new IllegalArgumentException("Method:" + method +": parameter '"+parameterName+"' length shoud be in closed range: ["+lengthMin+","+lengthMax+"] but it is: "+value.length());
		}
		if(value.length() > lengthMax){
			throw new IllegalArgumentException("Method:" + method +": parameter '"+parameterName+"' length shoud be in closed range: ["+lengthMin+","+lengthMax+"] but it is: "+value.length());
		}
	}
	
}






