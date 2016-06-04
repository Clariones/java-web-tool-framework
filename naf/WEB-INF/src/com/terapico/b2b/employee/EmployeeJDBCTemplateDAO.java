
package com.terapico.b2b.employee;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import com.terapico.b2b.CommonJDBCTemplateDAO;
import com.terapico.b2b.buyercompany.BuyerCompany;
import com.terapico.b2b.assignment.Assignment;

import com.terapico.b2b.assignment.AssignmentDAO;
import com.terapico.b2b.buyercompany.BuyerCompanyDAO;

public class EmployeeJDBCTemplateDAO extends CommonJDBCTemplateDAO implements EmployeeDAO{
 
 	
 	private  BuyerCompanyDAO  buyerCompanyDAO;
 	public void setBuyerCompanyDAO(BuyerCompanyDAO buyerCompanyDAO){
	 	this.buyerCompanyDAO = buyerCompanyDAO;
 	}
 	public BuyerCompanyDAO getBuyerCompanyDAO(){
	 	return this.buyerCompanyDAO;
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
 	
			
		

	public Employee load(String employeeId,Set<String> options) throws Exception{
		return loadInternalEmployee(employeeId, options);
	}
	public Employee save(Employee employee,Set<String> options){
		
		String methodName="save(Employee employee,Set<String> options){";
		
		assertMethodArgumentNotNull(employee, methodName, "employee");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalEmployee(employee,options);
	}
	public Employee clone(String employeeId,Set<String> options) throws Exception{
	
		String methodName="clone(String employeeId,Set<String> options)";
		
		assertMethodArgumentNotNull(employeeId, methodName, "employeeId");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Employee newEmployee = load(employeeId, options);
		newEmployee.setVersion(0);
		
		
 		
 		if(isSaveAssignmentListEnabled(options)){
 			for(Assignment item: newEmployee.getAssignmentList()){
 				item.setVersion(0);
 			}
 		}
		
		
		saveInternalEmployee(newEmployee,options);
		
		return newEmployee;
	}
	public void delete(String employeeId, int version) throws Exception{
	
		String methodName="delete(String employeeId, int version)";
		assertMethodArgumentNotNull(employeeId, methodName, "employeeId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{employeeId,version};
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			// two suitations here, this object has been deleted; or
			// the version has been changed, the client should reload it and ensure this can be deleted
			SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
			parameters=new Object[]{employeeId};
			int count = getJdbcTemplateObject().queryForObject(SQL, Integer.class, parameters);
			if(count == 1){
				throw new EmployeeVersionChangedException("The object version has been changed, please reload to delete");
			}
			if(count < 1){
				throw new EmployeeNotFoundException("The "+this.getTableName()+"("+employeeId+") has already been deleted.");
			}
			if(count > 1){
				throw new IllegalStateException("The table '"+this.getTableName()+"' PRIMARY KEY constraint has been damaged, please fix it.");
			}
		
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"name","company"};
	}
	@Override
	protected String getName() {
		
		return "employee";
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

 
 	//private boolean extractCompanyEnabled = true;
 	private static final String COMPANY = "company";
 	protected boolean isExtractCompanyEnabled(Set<String> options){
 		
	 	return checkOptions(options, COMPANY);
 	}
 	
 	
 	//private boolean saveCompanyEnabled = true;
 	protected boolean isSaveCompanyEnabled(Set<String> options){
	 	
 		return checkOptions(options, COMPANY);
 	}
 	

 	
 
		
	protected static final String ASSIGNMENT_LIST = "assignmentList";
	
	protected boolean isExtractAssignmentListEnabled(Set<String> options){
		
 		return checkOptions(options,ASSIGNMENT_LIST);
		
 	}

	protected boolean isSaveAssignmentListEnabled(Set<String> options){
		return checkOptions(options, ASSIGNMENT_LIST);
		
 	}
 	
 	
			
		
	

	protected EmployeeMapper getMapper(){
		return new EmployeeMapper();
	}
	protected Employee extractEmployee(String employeeId){
		String SQL = "select * from employee_data where id=?";	
		Employee employee = getJdbcTemplateObject().queryForObject(SQL, new Object[]{employeeId}, getMapper());
		return employee;
	}

	protected Employee loadInternalEmployee(String employeeId, Set<String> loadOptions) throws Exception{
		
		Employee employee = extractEmployee(employeeId);
 	
 		if(isExtractCompanyEnabled(loadOptions)){
	 		extractCompany(employee);
 		}
 
		
		if(isExtractAssignmentListEnabled(loadOptions)){
	 		extractAssignmentList(employee);
 		}		
		
		return employee;
		
	}
	
	
	 

 	protected Employee extractCompany(Employee employee) throws Exception{

		Set<String> options = new HashSet<String>();
		BuyerCompany company = getBuyerCompanyDAO().load(employee.getCompany().getId(),options);
		if(company != null){
			employee.setCompany(company);
		}
		
 		
 		return employee;
 	}
 		
 
		
	protected Employee extractAssignmentList(Employee employee){
		
		List<Assignment> assignmentList = getAssignmentDAO().findAssignmentByUser(employee.getId());
		if(assignmentList != null){
			employee.setAssignmentList(assignmentList);
		}
		
		return employee;
	
	}	
		
		
  	
 	public List<Employee> findEmployeeByCompany(String buyerCompanyId){
 	
 		String SQL = "select * from "+this.getTableName()+" where company = ?";
		List<Employee> employeeList = getJdbcTemplateObject().query(SQL, new Object[]{buyerCompanyId}, getMapper());
		
 	
 		return employeeList;
 	}
 	
		
		
		
	

	protected Employee saveEmployee(Employee  employee){
	
		String SQL=this.getSaveEmployeeSQL(employee);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveEmployeeParameters(employee);
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		return employee;
	
	}
	public List<Employee> saveList(List<Employee> employeeList,Set<String> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitEmployeeList(employeeList);
		
		batchCreate((List<Employee>)lists[CREATE_LIST_INDEX]);
		
		batchUpdate((List<Employee>)lists[UPDATE_LIST_INDEX]);

		return employeeList;
	}

	
	protected List<Object[]> prepareBatchCreateArgs(List<Employee> employeeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Employee employee:employeeList ){
			Object [] parameters = prepareCreateEmployeeParameters(employee);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareBatchUpdateArgs(List<Employee> employeeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Employee employee:employeeList ){
			Object [] parameters = prepareUpdateEmployeeParameters(employee);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchCreate(List<Employee> employeeList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareBatchCreateArgs(employeeList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
	}
	
	
	protected void batchUpdate(List<Employee> employeeList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareBatchUpdateArgs(employeeList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitEmployeeList(List<Employee> employeeList){
		
		List<Employee> employeeCreateList=new ArrayList<Employee>();
		List<Employee> employeeUpdateList=new ArrayList<Employee>();
		
		for(Employee employee: employeeList){
			if(isUpdateRequest(employee)){
				employeeUpdateList.add( employee);
				continue;
			}
			employeeCreateList.add(employee);
		}
		
		return new Object[]{employeeCreateList,employeeUpdateList};
	}
	
	protected boolean isUpdateRequest(Employee employee){
 		return employee.getVersion() > 0;
 	}
 	protected String getSaveEmployeeSQL(Employee employee){
 		if(isUpdateRequest(employee)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveEmployeeParameters(Employee employee){
 		if(isUpdateRequest(employee) ){
 			return prepareUpdateEmployeeParameters(employee);
 		}
 		return prepareCreateEmployeeParameters(employee);
 	}
 	protected Object[] prepareUpdateEmployeeParameters(Employee employee){
 		Object[] parameters = new Object[4];
 
 		parameters[0] = employee.getName(); 	
 		if(employee.getCompany() != null){
 			parameters[1] = employee.getCompany().getId();
 		}
 		
 		parameters[2] = employee.getId();
 		parameters[3] = employee.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareCreateEmployeeParameters(Employee employee){
		Object[] parameters = new Object[3];
		String newEmployeeId=getNextId();
		employee.setId(newEmployeeId);
		parameters[0] =  employee.getId();
 
 		parameters[1] = employee.getName(); 	
 		if(employee.getCompany() != null){
 			parameters[2] = employee.getCompany().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected Employee saveInternalEmployee(Employee employee, Set<String> options){
		
		saveEmployee(employee);
 	
 		if(isSaveCompanyEnabled(options)){
	 		saveCompany(employee);
 		}
 
		
		if(isSaveAssignmentListEnabled(options)){
	 		saveAssignmentList(employee);
 		}		
		
		return employee;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Employee saveCompany(Employee employee){
 		//Call inject DAO to execute this method
 		Set<String> options = new HashSet<String>();
 		
 		getBuyerCompanyDAO().save(employee.getCompany(),options);
 		return employee;
 		
 	}
	
 
		
	protected Employee saveAssignmentList(Employee employee){
		List<Assignment> assignmentList = employee.getAssignmentList();
		if(assignmentList==null){
			return employee;
		}
		if(assignmentList.isEmpty()){
			return employee;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		Set<String> options = new HashSet<String>();
		getAssignmentDAO().saveList(employee.getAssignmentList(),options);
		
		return employee;
	
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


