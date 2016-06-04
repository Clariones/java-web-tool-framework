
package com.lanecrawford.cms.actiontablemeta;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import com.lanecrawford.cms.CommonJDBCTemplateDAO;
import com.lanecrawford.cms.columnmeta.ColumnMeta;

import com.lanecrawford.cms.columnmeta.ColumnMetaDAO;

public class ActionTableMetaJDBCTemplateDAO extends CommonJDBCTemplateDAO implements ActionTableMetaDAO{

		
	
  	private  ColumnMetaDAO  columnMetaDAO;
 	public void setColumnMetaDAO(ColumnMetaDAO pColumnMetaDAO){
 	
 		if(pColumnMetaDAO == null){
 			throw new IllegalStateException("Do not trying to set columnMetaDAO to null.");
 		}
	 	this.columnMetaDAO = pColumnMetaDAO;
 	}
 	public ColumnMetaDAO getColumnMetaDAO(){
 		if(this.columnMetaDAO == null){
 			throw new IllegalStateException("The columnMetaDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.columnMetaDAO;
 	}	
 	
			
		

	public ActionTableMeta load(String actionTableMetaId,Set<String> options) throws Exception{
		return loadInternalActionTableMeta(actionTableMetaId, options);
	}
	public ActionTableMeta save(ActionTableMeta actionTableMeta,Set<String> options){
		
		String methodName="save(ActionTableMeta actionTableMeta,Set<String> options){";
		
		assertMethodArgumentNotNull(actionTableMeta, methodName, "actionTableMeta");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalActionTableMeta(actionTableMeta,options);
	}
	public ActionTableMeta clone(String actionTableMetaId,Set<String> options) throws Exception{
	
		String methodName="clone(String actionTableMetaId,Set<String> options)";
		
		assertMethodArgumentNotNull(actionTableMetaId, methodName, "actionTableMetaId");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		ActionTableMeta newActionTableMeta = load(actionTableMetaId, options);
		newActionTableMeta.setVersion(0);
		
		
 		
 		if(isSaveColumnMetaListEnabled(options)){
 			for(ColumnMeta item: newActionTableMeta.getColumnMetaList()){
 				item.setVersion(0);
 			}
 		}
		
		
		saveInternalActionTableMeta(newActionTableMeta,options);
		
		return newActionTableMeta;
	}
	public void delete(String actionTableMetaId, int version) throws Exception{
	
		String methodName="delete(String actionTableMetaId, int version)";
		assertMethodArgumentNotNull(actionTableMetaId, methodName, "actionTableMetaId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{actionTableMetaId,version};
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			// two suitations here, this object has been deleted; or
			// the version has been changed, the client should reload it and ensure this can be deleted
			SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
			parameters=new Object[]{actionTableMetaId};
			int count = getJdbcTemplateObject().queryForObject(SQL, Integer.class, parameters);
			if(count == 1){
				throw new ActionTableMetaVersionChangedException("The object version has been changed, please reload to delete");
			}
			if(count < 1){
				throw new ActionTableMetaNotFoundException("The "+this.getTableName()+"("+actionTableMetaId+") has already been deleted.");
			}
			if(count > 1){
				throw new IllegalStateException("The table '"+this.getTableName()+"' PRIMARY KEY constraint has been damaged, please fix it.");
			}
		
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"table_name","enabled","batchsize","description"};
	}
	@Override
	protected String getName() {
		
		return "action_table_meta";
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


		
	protected static final String COLUMN_META_LIST = "columnMetaList";
	
	protected boolean isExtractColumnMetaListEnabled(Set<String> options){
		
 		return checkOptions(options,COLUMN_META_LIST);
		
 	}

	protected boolean isSaveColumnMetaListEnabled(Set<String> options){
		return checkOptions(options, COLUMN_META_LIST);
		
 	}
 	
 	
			
		
	

	protected ActionTableMetaMapper getMapper(){
		return new ActionTableMetaMapper();
	}
	protected ActionTableMeta extractActionTableMeta(String actionTableMetaId){
		String SQL = "select * from action_table_meta_data where id=?";	
		ActionTableMeta actionTableMeta = getJdbcTemplateObject().queryForObject(SQL, new Object[]{actionTableMetaId}, getMapper());
		return actionTableMeta;
	}

	protected ActionTableMeta loadInternalActionTableMeta(String actionTableMetaId, Set<String> loadOptions) throws Exception{
		
		ActionTableMeta actionTableMeta = extractActionTableMeta(actionTableMetaId);

		
		if(isExtractColumnMetaListEnabled(loadOptions)){
	 		extractColumnMetaList(actionTableMeta);
 		}		
		
		return actionTableMeta;
		
	}
	
	
	
		
	protected ActionTableMeta extractColumnMetaList(ActionTableMeta actionTableMeta){
		
		List<ColumnMeta> columnMetaList = getColumnMetaDAO().findColumnMetaByActionTable(actionTableMeta.getId());
		if(columnMetaList != null){
			actionTableMeta.setColumnMetaList(columnMetaList);
		}
		
		return actionTableMeta;
	
	}	
		
		
 	
		
		
		
	

	protected ActionTableMeta saveActionTableMeta(ActionTableMeta  actionTableMeta){
	
		String SQL=this.getSaveActionTableMetaSQL(actionTableMeta);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveActionTableMetaParameters(actionTableMeta);
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		return actionTableMeta;
	
	}
	public List<ActionTableMeta> saveList(List<ActionTableMeta> actionTableMetaList,Set<String> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitActionTableMetaList(actionTableMetaList);
		
		batchCreate((List<ActionTableMeta>)lists[CREATE_LIST_INDEX]);
		
		batchUpdate((List<ActionTableMeta>)lists[UPDATE_LIST_INDEX]);

		return actionTableMetaList;
	}

	
	protected List<Object[]> prepareBatchCreateArgs(List<ActionTableMeta> actionTableMetaList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ActionTableMeta actionTableMeta:actionTableMetaList ){
			Object [] parameters = prepareCreateActionTableMetaParameters(actionTableMeta);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareBatchUpdateArgs(List<ActionTableMeta> actionTableMetaList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ActionTableMeta actionTableMeta:actionTableMetaList ){
			Object [] parameters = prepareUpdateActionTableMetaParameters(actionTableMeta);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchCreate(List<ActionTableMeta> actionTableMetaList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareBatchCreateArgs(actionTableMetaList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
	}
	
	
	protected void batchUpdate(List<ActionTableMeta> actionTableMetaList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareBatchUpdateArgs(actionTableMetaList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitActionTableMetaList(List<ActionTableMeta> actionTableMetaList){
		
		List<ActionTableMeta> actionTableMetaCreateList=new ArrayList<ActionTableMeta>();
		List<ActionTableMeta> actionTableMetaUpdateList=new ArrayList<ActionTableMeta>();
		
		for(ActionTableMeta actionTableMeta: actionTableMetaList){
			if(isUpdateRequest(actionTableMeta)){
				actionTableMetaUpdateList.add( actionTableMeta);
				continue;
			}
			actionTableMetaCreateList.add(actionTableMeta);
		}
		
		return new Object[]{actionTableMetaCreateList,actionTableMetaUpdateList};
	}
	
	protected boolean isUpdateRequest(ActionTableMeta actionTableMeta){
 		return actionTableMeta.getVersion() > 0;
 	}
 	protected String getSaveActionTableMetaSQL(ActionTableMeta actionTableMeta){
 		if(isUpdateRequest(actionTableMeta)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveActionTableMetaParameters(ActionTableMeta actionTableMeta){
 		if(isUpdateRequest(actionTableMeta) ){
 			return prepareUpdateActionTableMetaParameters(actionTableMeta);
 		}
 		return prepareCreateActionTableMetaParameters(actionTableMeta);
 	}
 	protected Object[] prepareUpdateActionTableMetaParameters(ActionTableMeta actionTableMeta){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = actionTableMeta.getTableName();
 		parameters[1] = actionTableMeta.getEnabled();
 		parameters[2] = actionTableMeta.getBatchsize();
 		parameters[3] = actionTableMeta.getDescription();		
 		parameters[4] = actionTableMeta.getId();
 		parameters[5] = actionTableMeta.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareCreateActionTableMetaParameters(ActionTableMeta actionTableMeta){
		Object[] parameters = new Object[5];
		String newActionTableMetaId=getNextId();
		actionTableMeta.setId(newActionTableMetaId);
		parameters[0] =  actionTableMeta.getId();
 
 		parameters[1] = actionTableMeta.getTableName();
 		parameters[2] = actionTableMeta.getEnabled();
 		parameters[3] = actionTableMeta.getBatchsize();
 		parameters[4] = actionTableMeta.getDescription();		
 				
 		return parameters;
 	}
 	
	protected ActionTableMeta saveInternalActionTableMeta(ActionTableMeta actionTableMeta, Set<String> options){
		
		saveActionTableMeta(actionTableMeta);

		
		if(isSaveColumnMetaListEnabled(options)){
	 		saveColumnMetaList(actionTableMeta);
 		}		
		
		return actionTableMeta;
		
	}
	
	
	
	//======================================================================================
	
		
	protected ActionTableMeta saveColumnMetaList(ActionTableMeta actionTableMeta){
		List<ColumnMeta> columnMetaList = actionTableMeta.getColumnMetaList();
		if(columnMetaList==null){
			return actionTableMeta;
		}
		if(columnMetaList.isEmpty()){
			return actionTableMeta;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		Set<String> options = new HashSet<String>();
		getColumnMetaDAO().saveList(actionTableMeta.getColumnMetaList(),options);
		
		return actionTableMeta;
	
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


