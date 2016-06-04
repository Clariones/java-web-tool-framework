
package com.lanecrawford.cms.columnmeta;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import com.lanecrawford.cms.CommonJDBCTemplateDAO;
import com.lanecrawford.cms.actiontablemeta.ActionTableMeta;

import com.lanecrawford.cms.actiontablemeta.ActionTableMetaDAO;

public class ColumnMetaJDBCTemplateDAO extends CommonJDBCTemplateDAO implements ColumnMetaDAO{
 
 	
 	private  ActionTableMetaDAO  actionTableMetaDAO;
 	public void setActionTableMetaDAO(ActionTableMetaDAO actionTableMetaDAO){
	 	this.actionTableMetaDAO = actionTableMetaDAO;
 	}
 	public ActionTableMetaDAO getActionTableMetaDAO(){
	 	return this.actionTableMetaDAO;
 	}

		

	public ColumnMeta load(String columnMetaId,Set<String> options) throws Exception{
		return loadInternalColumnMeta(columnMetaId, options);
	}
	public ColumnMeta save(ColumnMeta columnMeta,Set<String> options){
		
		String methodName="save(ColumnMeta columnMeta,Set<String> options){";
		
		assertMethodArgumentNotNull(columnMeta, methodName, "columnMeta");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalColumnMeta(columnMeta,options);
	}
	public ColumnMeta clone(String columnMetaId,Set<String> options) throws Exception{
	
		String methodName="clone(String columnMetaId,Set<String> options)";
		
		assertMethodArgumentNotNull(columnMetaId, methodName, "columnMetaId");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		ColumnMeta newColumnMeta = load(columnMetaId, options);
		newColumnMeta.setVersion(0);
		
		
		
		saveInternalColumnMeta(newColumnMeta,options);
		
		return newColumnMeta;
	}
	public void delete(String columnMetaId, int version) throws Exception{
	
		String methodName="delete(String columnMetaId, int version)";
		assertMethodArgumentNotNull(columnMetaId, methodName, "columnMetaId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{columnMetaId,version};
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			// two suitations here, this object has been deleted; or
			// the version has been changed, the client should reload it and ensure this can be deleted
			SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
			parameters=new Object[]{columnMetaId};
			int count = getJdbcTemplateObject().queryForObject(SQL, Integer.class, parameters);
			if(count == 1){
				throw new ColumnMetaVersionChangedException("The object version has been changed, please reload to delete");
			}
			if(count < 1){
				throw new ColumnMetaNotFoundException("The "+this.getTableName()+"("+columnMetaId+") has already been deleted.");
			}
			if(count > 1){
				throw new IllegalStateException("The table '"+this.getTableName()+"' PRIMARY KEY constraint has been damaged, please fix it.");
			}
		
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"source_column","dest_column","action_table","type","length"};
	}
	@Override
	protected String getName() {
		
		return "column_meta";
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

 
 	//private boolean extractActionTableEnabled = true;
 	private static final String ACTIONTABLE = "actionTable";
 	protected boolean isExtractActionTableEnabled(Set<String> options){
 		
	 	return checkOptions(options, ACTIONTABLE);
 	}
 	
 	
 	//private boolean saveActionTableEnabled = true;
 	protected boolean isSaveActionTableEnabled(Set<String> options){
	 	
 		return checkOptions(options, ACTIONTABLE);
 	}
 	

 	
 
		
	

	protected ColumnMetaMapper getMapper(){
		return new ColumnMetaMapper();
	}
	protected ColumnMeta extractColumnMeta(String columnMetaId){
		String SQL = "select * from column_meta_data where id=?";	
		ColumnMeta columnMeta = getJdbcTemplateObject().queryForObject(SQL, new Object[]{columnMetaId}, getMapper());
		return columnMeta;
	}

	protected ColumnMeta loadInternalColumnMeta(String columnMetaId, Set<String> loadOptions) throws Exception{
		
		ColumnMeta columnMeta = extractColumnMeta(columnMetaId);
 	
 		if(isExtractActionTableEnabled(loadOptions)){
	 		extractActionTable(columnMeta);
 		}
 
		
		return columnMeta;
		
	}
	
	
	 

 	protected ColumnMeta extractActionTable(ColumnMeta columnMeta) throws Exception{

		Set<String> options = new HashSet<String>();
		ActionTableMeta actionTable = getActionTableMetaDAO().load(columnMeta.getActionTable().getId(),options);
		if(actionTable != null){
			columnMeta.setActionTable(actionTable);
		}
		
 		
 		return columnMeta;
 	}
 		
 
		
		
  	
 	public List<ColumnMeta> findColumnMetaByActionTable(String actionTableMetaId){
 	
 		String SQL = "select * from "+this.getTableName()+" where action_table = ?";
		List<ColumnMeta> columnMetaList = getJdbcTemplateObject().query(SQL, new Object[]{actionTableMetaId}, getMapper());
		
 	
 		return columnMetaList;
 	}
 	
		
		
		
	

	protected ColumnMeta saveColumnMeta(ColumnMeta  columnMeta){
	
		String SQL=this.getSaveColumnMetaSQL(columnMeta);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveColumnMetaParameters(columnMeta);
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		return columnMeta;
	
	}
	public List<ColumnMeta> saveList(List<ColumnMeta> columnMetaList,Set<String> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitColumnMetaList(columnMetaList);
		
		batchCreate((List<ColumnMeta>)lists[CREATE_LIST_INDEX]);
		
		batchUpdate((List<ColumnMeta>)lists[UPDATE_LIST_INDEX]);

		return columnMetaList;
	}

	
	protected List<Object[]> prepareBatchCreateArgs(List<ColumnMeta> columnMetaList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ColumnMeta columnMeta:columnMetaList ){
			Object [] parameters = prepareCreateColumnMetaParameters(columnMeta);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareBatchUpdateArgs(List<ColumnMeta> columnMetaList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ColumnMeta columnMeta:columnMetaList ){
			Object [] parameters = prepareUpdateColumnMetaParameters(columnMeta);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchCreate(List<ColumnMeta> columnMetaList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareBatchCreateArgs(columnMetaList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
	}
	
	
	protected void batchUpdate(List<ColumnMeta> columnMetaList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareBatchUpdateArgs(columnMetaList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitColumnMetaList(List<ColumnMeta> columnMetaList){
		
		List<ColumnMeta> columnMetaCreateList=new ArrayList<ColumnMeta>();
		List<ColumnMeta> columnMetaUpdateList=new ArrayList<ColumnMeta>();
		
		for(ColumnMeta columnMeta: columnMetaList){
			if(isUpdateRequest(columnMeta)){
				columnMetaUpdateList.add( columnMeta);
				continue;
			}
			columnMetaCreateList.add(columnMeta);
		}
		
		return new Object[]{columnMetaCreateList,columnMetaUpdateList};
	}
	
	protected boolean isUpdateRequest(ColumnMeta columnMeta){
 		return columnMeta.getVersion() > 0;
 	}
 	protected String getSaveColumnMetaSQL(ColumnMeta columnMeta){
 		if(isUpdateRequest(columnMeta)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveColumnMetaParameters(ColumnMeta columnMeta){
 		if(isUpdateRequest(columnMeta) ){
 			return prepareUpdateColumnMetaParameters(columnMeta);
 		}
 		return prepareCreateColumnMetaParameters(columnMeta);
 	}
 	protected Object[] prepareUpdateColumnMetaParameters(ColumnMeta columnMeta){
 		Object[] parameters = new Object[7];
 
 		parameters[0] = columnMeta.getSourceColumn();
 		parameters[1] = columnMeta.getDestColumn(); 	
 		if(columnMeta.getActionTable() != null){
 			parameters[2] = columnMeta.getActionTable().getId();
 		}
 
 		parameters[3] = columnMeta.getType();
 		parameters[4] = columnMeta.getLength();		
 		parameters[5] = columnMeta.getId();
 		parameters[6] = columnMeta.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareCreateColumnMetaParameters(ColumnMeta columnMeta){
		Object[] parameters = new Object[6];
		String newColumnMetaId=getNextId();
		columnMeta.setId(newColumnMetaId);
		parameters[0] =  columnMeta.getId();
 
 		parameters[1] = columnMeta.getSourceColumn();
 		parameters[2] = columnMeta.getDestColumn(); 	
 		if(columnMeta.getActionTable() != null){
 			parameters[3] = columnMeta.getActionTable().getId();
 		
 		}
 		
 		parameters[4] = columnMeta.getType();
 		parameters[5] = columnMeta.getLength();		
 				
 		return parameters;
 	}
 	
	protected ColumnMeta saveInternalColumnMeta(ColumnMeta columnMeta, Set<String> options){
		
		saveColumnMeta(columnMeta);
 	
 		if(isSaveActionTableEnabled(options)){
	 		saveActionTable(columnMeta);
 		}
 
		
		return columnMeta;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected ColumnMeta saveActionTable(ColumnMeta columnMeta){
 		//Call inject DAO to execute this method
 		Set<String> options = new HashSet<String>();
 		
 		getActionTableMetaDAO().save(columnMeta.getActionTable(),options);
 		return columnMeta;
 		
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






