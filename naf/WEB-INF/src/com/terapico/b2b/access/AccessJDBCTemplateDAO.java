
package com.terapico.b2b.access;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import com.terapico.b2b.CommonJDBCTemplateDAO;
import com.terapico.b2b.role.Role;
import com.terapico.b2b.assignment.Assignment;

import com.terapico.b2b.role.RoleDAO;
import com.terapico.b2b.assignment.AssignmentDAO;

public class AccessJDBCTemplateDAO extends CommonJDBCTemplateDAO implements AccessDAO{
 
 	
 	private  RoleDAO  roleDAO;
 	public void setRoleDAO(RoleDAO roleDAO){
	 	this.roleDAO = roleDAO;
 	}
 	public RoleDAO getRoleDAO(){
	 	return this.roleDAO;
 	}

		
	
  	private  AssignmentDAO  assignmentDAO;
 	public void setAssignmentDAO(AssignmentDAO pAssignmentDAO){
 	
 		if(pAssignmentDAO == null){
 			throw new IllegalStateException("Do not trying to set assignmentDAO to null.");
 		}
	 	this.assignmentDAO = pAssignmentDAO;
 	}
 	public AssignmentDAO getAssignmentDAO(){
 		if(this.assignmentDAO == null){
 			throw new IllegalStateException("The assignmentDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.assignmentDAO;
 	}	
 	
			
		

	public Access load(String accessId,Map<String,Object> options) throws Exception{
		return loadInternalAccess(accessId, options);
	}
	public Access save(Access access,Map<String,Object> options){
		
		String methodName="save(Access access,Map<String,Object> options){";
		
		assertMethodArgumentNotNull(access, methodName, "access");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalAccess(access,options);
	}
	public Access clone(String accessId,Map<String,Object> options) throws Exception{
	
		String methodName="clone(String accessId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessId, methodName, "accessId");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Access newAccess = load(accessId, options);
		newAccess.setVersion(0);
		
		
 		
 		if(isSaveAssignmentListEnabled(options)){
 			for(Assignment item: newAccess.getAssignmentList()){
 				item.setVersion(0);
 			}
 		}
		
		
		saveInternalAccess(newAccess,options);
		
		return newAccess;
	}
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = getJdbcTemplateObject().update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String accessId, int version) throws  AccessVersionChangedException,  AccessNotFoundException {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{accessId};
		int count = getJdbcTemplateObject().queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new AccessVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new AccessNotFoundException(
					"The " + this.getTableName() + "(" + accessId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String accessId, int version) throws Exception{
	
		String methodName="delete(String accessId, int version)";
		assertMethodArgumentNotNull(accessId, methodName, "accessId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{accessId,version};
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(accessId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"role_name","role"};
	}
	@Override
	protected String getName() {
		
		return "access";
	}
	
	
	static final String ALL="__all__"; //do not assign this to common users,
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

 
 	//private boolean extractRoleEnabled = true;
 	private static final String ROLE = "role";
 	protected boolean isExtractRoleEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ROLE);
 	}
 	
 	
 	//private boolean saveRoleEnabled = true;
 	protected boolean isSaveRoleEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ROLE);
 	}
 	

 	
 
		
	protected static final String ASSIGNMENT_LIST = "assignmentList";
	
	protected boolean isExtractAssignmentListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,ASSIGNMENT_LIST);
		
 	}

	protected boolean isSaveAssignmentListEnabled(Map<String,Object> options){
		return checkOptions(options, ASSIGNMENT_LIST);
		
 	}
 	
 	
			
		
	

	protected AccessMapper getMapper(){
		return new AccessMapper();
	}
	protected Access extractAccess(String accessId){
		String SQL = "select * from access_data where id=?";	
		Access access = getJdbcTemplateObject().queryForObject(SQL, new Object[]{accessId}, getMapper());
		return access;
	}

	protected Access loadInternalAccess(String accessId, Map<String,Object> loadOptions) throws Exception{
		
		Access access = extractAccess(accessId);
 	
 		if(isExtractRoleEnabled(loadOptions)){
	 		extractRole(access, loadOptions);
 		}
 
		
		if(isExtractAssignmentListEnabled(loadOptions)){
	 		extractAssignmentList(access, loadOptions);
 		}		
		
		return access;
		
	}
	
	
	 

 	protected Access extractRole(Access access, Map<String,Object> options) throws Exception{

		if(access.getRole() == null){
			return access;
		}
		
		Role role = getRoleDAO().load(access.getRole().getId(),options);
		if(role != null){
			access.setRole(role);
		}
		
 		
 		return access;
 	}
 		
 
		
	protected Access extractAssignmentList(Access access, Map<String,Object> options){
		
		List<Assignment> assignmentList = getAssignmentDAO().findAssignmentByAccess(access.getId());
		if(assignmentList != null){
			access.setAssignmentList(assignmentList);
		}
		
		return access;
	
	}	
		
		
  	
 	public List<Access> findAccessByRole(String roleId){
 	
 		String SQL = "select * from "+this.getTableName()+" where role = ?";
		List<Access> accessList = getJdbcTemplateObject().query(SQL, new Object[]{roleId}, getMapper());
		
 	
 		return accessList;
 	}
 	
		
		
		
	

	protected Access saveAccess(Access  access){
	
		String SQL=this.getSaveAccessSQL(access);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveAccessParameters(access);
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		return access;
	
	}
	public List<Access> saveList(List<Access> accessList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitAccessList(accessList);
		
		batchCreate((List<Access>)lists[CREATE_LIST_INDEX]);
		
		batchUpdate((List<Access>)lists[UPDATE_LIST_INDEX]);

		return accessList;
	}

	
	protected List<Object[]> prepareBatchCreateArgs(List<Access> accessList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Access access:accessList ){
			Object [] parameters = prepareCreateAccessParameters(access);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareBatchUpdateArgs(List<Access> accessList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Access access:accessList ){
			Object [] parameters = prepareUpdateAccessParameters(access);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchCreate(List<Access> accessList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareBatchCreateArgs(accessList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
	}
	
	
	protected void batchUpdate(List<Access> accessList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareBatchUpdateArgs(accessList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitAccessList(List<Access> accessList){
		
		List<Access> accessCreateList=new ArrayList<Access>();
		List<Access> accessUpdateList=new ArrayList<Access>();
		
		for(Access access: accessList){
			if(isUpdateRequest(access)){
				accessUpdateList.add( access);
				continue;
			}
			accessCreateList.add(access);
		}
		
		return new Object[]{accessCreateList,accessUpdateList};
	}
	
	protected boolean isUpdateRequest(Access access){
 		return access.getVersion() > 0;
 	}
 	protected String getSaveAccessSQL(Access access){
 		if(isUpdateRequest(access)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveAccessParameters(Access access){
 		if(isUpdateRequest(access) ){
 			return prepareUpdateAccessParameters(access);
 		}
 		return prepareCreateAccessParameters(access);
 	}
 	protected Object[] prepareUpdateAccessParameters(Access access){
 		Object[] parameters = new Object[4];
 
 		parameters[0] = access.getRoleName(); 	
 		if(access.getRole() != null){
 			parameters[1] = access.getRole().getId();
 		}
 		
 		parameters[2] = access.getId();
 		parameters[3] = access.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareCreateAccessParameters(Access access){
		Object[] parameters = new Object[3];
		String newAccessId=getNextId();
		access.setId(newAccessId);
		parameters[0] =  access.getId();
 
 		parameters[1] = access.getRoleName(); 	
 		if(access.getRole() != null){
 			parameters[2] = access.getRole().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected Access saveInternalAccess(Access access, Map<String,Object> options){
		
		saveAccess(access);
 	
 		if(isSaveRoleEnabled(options)){
	 		saveRole(access, options);
 		}
 
		
		if(isSaveAssignmentListEnabled(options)){
	 		saveAssignmentList(access, options);
 		}		
		
		return access;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Access saveRole(Access access, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		getRoleDAO().save(access.getRole(),options);
 		return access;
 		
 	}
	
 
		
	protected Access saveAssignmentList(Access access, Map<String,Object> options){
		List<Assignment> assignmentList = access.getAssignmentList();
		if(assignmentList == null){
			return access;
		}
		if(assignmentList.isEmpty()){
			return access;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getAssignmentDAO().saveList(access.getAssignmentList(),options);
		
		return access;
	
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


