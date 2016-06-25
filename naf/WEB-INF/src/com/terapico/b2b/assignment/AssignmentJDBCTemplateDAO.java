
package com.terapico.b2b.assignment;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import com.terapico.b2b.CommonJDBCTemplateDAO;
import com.terapico.b2b.access.Access;
import com.terapico.b2b.employee.Employee;

import com.terapico.b2b.employee.EmployeeDAO;
import com.terapico.b2b.access.AccessDAO;

public class AssignmentJDBCTemplateDAO extends CommonJDBCTemplateDAO implements AssignmentDAO{
 
 	
 	private  EmployeeDAO  employeeDAO;
 	public void setEmployeeDAO(EmployeeDAO employeeDAO){
	 	this.employeeDAO = employeeDAO;
 	}
 	public EmployeeDAO getEmployeeDAO(){
	 	return this.employeeDAO;
 	}
 
 	
 	private  AccessDAO  accessDAO;
 	public void setAccessDAO(AccessDAO accessDAO){
	 	this.accessDAO = accessDAO;
 	}
 	public AccessDAO getAccessDAO(){
	 	return this.accessDAO;
 	}

		

	public Assignment load(String assignmentId,Map<String,Object> options) throws Exception{
		return loadInternalAssignment(assignmentId, options);
	}
	public Assignment save(Assignment assignment,Map<String,Object> options){
		
		String methodName="save(Assignment assignment,Map<String,Object> options){";
		
		assertMethodArgumentNotNull(assignment, methodName, "assignment");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalAssignment(assignment,options);
	}
	public Assignment clone(String assignmentId,Map<String,Object> options) throws Exception{
	
		String methodName="clone(String assignmentId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(assignmentId, methodName, "assignmentId");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Assignment newAssignment = load(assignmentId, options);
		newAssignment.setVersion(0);
		
		
		
		saveInternalAssignment(newAssignment,options);
		
		return newAssignment;
	}
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = getJdbcTemplateObject().update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String assignmentId, int version) throws  AssignmentVersionChangedException,  AssignmentNotFoundException {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{assignmentId};
		int count = getJdbcTemplateObject().queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new AssignmentVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new AssignmentNotFoundException(
					"The " + this.getTableName() + "(" + assignmentId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String assignmentId, int version) throws Exception{
	
		String methodName="delete(String assignmentId, int version)";
		assertMethodArgumentNotNull(assignmentId, methodName, "assignmentId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{assignmentId,version};
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(assignmentId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"user","access","assigned_date"};
	}
	@Override
	protected String getName() {
		
		return "assignment";
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

 
 	//private boolean extractUserEnabled = true;
 	private static final String USER = "user";
 	protected boolean isExtractUserEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, USER);
 	}
 	
 	
 	//private boolean saveUserEnabled = true;
 	protected boolean isSaveUserEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, USER);
 	}
 	

 	
  
 	//private boolean extractAccessEnabled = true;
 	private static final String ACCESS = "access";
 	protected boolean isExtractAccessEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ACCESS);
 	}
 	
 	
 	//private boolean saveAccessEnabled = true;
 	protected boolean isSaveAccessEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ACCESS);
 	}
 	

 	
 
		
	

	protected AssignmentMapper getMapper(){
		return new AssignmentMapper();
	}
	protected Assignment extractAssignment(String assignmentId){
		String SQL = "select * from assignment_data where id=?";	
		Assignment assignment = getJdbcTemplateObject().queryForObject(SQL, new Object[]{assignmentId}, getMapper());
		return assignment;
	}

	protected Assignment loadInternalAssignment(String assignmentId, Map<String,Object> loadOptions) throws Exception{
		
		Assignment assignment = extractAssignment(assignmentId);
 	
 		if(isExtractUserEnabled(loadOptions)){
	 		extractUser(assignment, loadOptions);
 		}
  	
 		if(isExtractAccessEnabled(loadOptions)){
	 		extractAccess(assignment, loadOptions);
 		}
 
		
		return assignment;
		
	}
	
	
	 

 	protected Assignment extractUser(Assignment assignment, Map<String,Object> options) throws Exception{

		if(assignment.getUser() == null){
			return assignment;
		}
		String userId = assignment.getUser().getId();
		if( userId == null){
			return assignment;
		}
		Employee user = getEmployeeDAO().load(userId,options);
		if(user != null){
			assignment.setUser(user);
		}
		
 		
 		return assignment;
 	}
 		
  

 	protected Assignment extractAccess(Assignment assignment, Map<String,Object> options) throws Exception{

		if(assignment.getAccess() == null){
			return assignment;
		}
		String accessId = assignment.getAccess().getId();
		if( accessId == null){
			return assignment;
		}
		Access access = getAccessDAO().load(accessId,options);
		if(access != null){
			assignment.setAccess(access);
		}
		
 		
 		return assignment;
 	}
 		
 
		
		
  	
 	public List<Assignment> findAssignmentByUser(String employeeId){
 	
 		String SQL = "select * from "+this.getTableName()+" where user = ?";
		List<Assignment> assignmentList = getJdbcTemplateObject().query(SQL, new Object[]{employeeId}, getMapper());
		
 	
 		return assignmentList;
 	}
  	
 	public List<Assignment> findAssignmentByAccess(String accessId){
 	
 		String SQL = "select * from "+this.getTableName()+" where access = ?";
		List<Assignment> assignmentList = getJdbcTemplateObject().query(SQL, new Object[]{accessId}, getMapper());
		
 	
 		return assignmentList;
 	}
 	
		
		
		
	

	protected Assignment saveAssignment(Assignment  assignment){
	
		String SQL=this.getSaveAssignmentSQL(assignment);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveAssignmentParameters(assignment);
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		int newVersion = assignment.getVersion() + 1;
		assignment.setVersion(newVersion);
		return assignment;
	
	}
	public List<Assignment> saveList(List<Assignment> assignmentList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitAssignmentList(assignmentList);
		
		batchCreate((List<Assignment>)lists[CREATE_LIST_INDEX]);
		
		batchUpdate((List<Assignment>)lists[UPDATE_LIST_INDEX]);

		return assignmentList;
	}

	
	protected List<Object[]> prepareBatchCreateArgs(List<Assignment> assignmentList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Assignment assignment:assignmentList ){
			Object [] parameters = prepareCreateAssignmentParameters(assignment);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareBatchUpdateArgs(List<Assignment> assignmentList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Assignment assignment:assignmentList ){
			Object [] parameters = prepareUpdateAssignmentParameters(assignment);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchCreate(List<Assignment> assignmentList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareBatchCreateArgs(assignmentList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
	}
	
	
	protected void batchUpdate(List<Assignment> assignmentList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareBatchUpdateArgs(assignmentList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitAssignmentList(List<Assignment> assignmentList){
		
		List<Assignment> assignmentCreateList=new ArrayList<Assignment>();
		List<Assignment> assignmentUpdateList=new ArrayList<Assignment>();
		
		for(Assignment assignment: assignmentList){
			if(isUpdateRequest(assignment)){
				assignmentUpdateList.add( assignment);
				continue;
			}
			assignmentCreateList.add(assignment);
		}
		
		return new Object[]{assignmentCreateList,assignmentUpdateList};
	}
	
	protected boolean isUpdateRequest(Assignment assignment){
 		return assignment.getVersion() > 0;
 	}
 	protected String getSaveAssignmentSQL(Assignment assignment){
 		if(isUpdateRequest(assignment)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveAssignmentParameters(Assignment assignment){
 		if(isUpdateRequest(assignment) ){
 			return prepareUpdateAssignmentParameters(assignment);
 		}
 		return prepareCreateAssignmentParameters(assignment);
 	}
 	protected Object[] prepareUpdateAssignmentParameters(Assignment assignment){
 		Object[] parameters = new Object[5];
  	
 		if(assignment.getUser() != null){
 			parameters[0] = assignment.getUser().getId();
 		}
  	
 		if(assignment.getAccess() != null){
 			parameters[1] = assignment.getAccess().getId();
 		}
 
 		parameters[2] = assignment.getAssignedDate();		
 		parameters[3] = assignment.getId();
 		parameters[4] = assignment.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareCreateAssignmentParameters(Assignment assignment){
		Object[] parameters = new Object[4];
		String newAssignmentId=getNextId();
		assignment.setId(newAssignmentId);
		parameters[0] =  assignment.getId();
  	
 		if(assignment.getUser() != null){
 			parameters[1] = assignment.getUser().getId();
 		
 		}
 		 	
 		if(assignment.getAccess() != null){
 			parameters[2] = assignment.getAccess().getId();
 		
 		}
 		
 		parameters[3] = assignment.getAssignedDate();		
 				
 		return parameters;
 	}
 	
	protected Assignment saveInternalAssignment(Assignment assignment, Map<String,Object> options){
		
		saveAssignment(assignment);
 	
 		if(isSaveUserEnabled(options)){
	 		saveUser(assignment, options);
 		}
  	
 		if(isSaveAccessEnabled(options)){
	 		saveAccess(assignment, options);
 		}
 
		
		return assignment;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Assignment saveUser(Assignment assignment, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		getEmployeeDAO().save(assignment.getUser(),options);
 		return assignment;
 		
 	}
	
  
 
 	protected Assignment saveAccess(Assignment assignment, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		getAccessDAO().save(assignment.getAccess(),options);
 		return assignment;
 		
 	}
	
 
		

	
}


