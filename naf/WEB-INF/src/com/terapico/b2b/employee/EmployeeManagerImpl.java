
package com.terapico.b2b.employee;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import com.terapico.b2b.buyercompany.BuyerCompany;
import com.terapico.b2b.assignment.Assignment;

import com.terapico.b2b.buyercompany.BuyerCompanyDAO;

import com.terapico.b2b.access.Access;
import com.terapico.b2b.employee.Employee;



public class EmployeeManagerImpl implements EmployeeManager {

	private  EmployeeDAO  employeeDAO;
 	public void setEmployeeDAO(EmployeeDAO  employeeDAO){
 	
 		if(employeeDAO == null){
 			throw new IllegalStateException("Do not try to set employeeDAO to null.");
 		}
	 	this.employeeDAO = employeeDAO;
 	}
 	public EmployeeDAO getEmployeeDAO(){
 		if(this.employeeDAO == null){
 			throw new IllegalStateException("The EmployeeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.employeeDAO;
 	}
 	
 	public Employee saveEmployee(Employee employee, Map<String,Object>options) throws Exception{	
 		return getEmployeeDAO().save(employee, options);
 	}
 	public Employee loadEmployee(String employeeId, Map<String,Object>options) throws Exception{	
 		return getEmployeeDAO().load(employeeId, options);
 	}
 	 
 	
 	private  BuyerCompanyDAO  buyerCompanyDAO;
 	public void setBuyerCompanyDAO(BuyerCompanyDAO buyerCompanyDAO){
	 	this.buyerCompanyDAO = buyerCompanyDAO;
 	}
 	public BuyerCompanyDAO getBuyerCompanyDAO(){
	 	return this.buyerCompanyDAO;
 	}

 	
 	
	public Employee createEmployee(String name, String companyId, String email, String passwd, String cellPhone, String[] optionsExpr) throws Exception
	{
		
		
		Employee employee=createNewEmployee(optionsExpr);	

		employee.setName(name);
		BuyerCompany company = loadCompany(companyId,emptyOptions());
		employee.setCompany(company);
		employee.setEmail(email);
		employee.setPasswd(passwd);
		employee.setCellPhone(cellPhone);

		return saveEmployee(employee, emptyOptions());
		

		
	}
	protected Employee createNewEmployee(String[] optionsExpr) throws Exception
	{
		
		return new Employee();
		
	}
	public Employee updateEmployee(String employeeId, String property, Object newValue) throws Exception 
	{
		return new Employee();
	}
	protected Map<String,Object> emptyOptions(){
		return new HashMap<String,Object>();
	}
	
	protected EmployeeTokens tokens(){
		return EmployeeTokens.start();
	}
	protected Map<String,Object> allTokens(){
		return EmployeeTokens.all();
	}
	
	public Employee transferToNewCompany(String employeeId, String newCompanyId) throws Exception
 	{
 
		Employee employee = loadEmployee(employeeId, allTokens());	
		synchronized(employee){
			//will be good when the employee loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			BuyerCompany company = loadCompany(newCompanyId, emptyOptions());		
			employee.setCompany(company);		
			return saveEmployee(employee, emptyOptions());
		}
 	}
 	
 	protected BuyerCompany loadCompany(String newCompanyId, Map<String,Object> options) throws Exception
 	{
 		return getBuyerCompanyDAO().load(newCompanyId, options);
 	}
 	
 

	public void delete(String employeeId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}
	public  Employee addAssignment(String employeeId, String accessId, Date assignedDate) throws Exception
	{		
		Assignment assignment = createAssignment(accessId, assignedDate);
		
		Employee employee = loadEmployee(employeeId, allTokens());
		synchronized(employee){ 
			//will be good when the employee loaded from this jvm process cache.
			//also good when there is a ram based DAO implementation
			employee.addAssignment( assignment );		
			return saveEmployee(employee, tokens().withAssignmentList().done());
		}
	}
	protected Assignment createAssignment(String accessId, Date assignedDate){

		Assignment assignment = new Assignment();
		
		
		Access  access = new Access();
		access.setId(accessId);		
		assignment.setAccess(access);		
		assignment.setAssignedDate(assignedDate);
	
		
		return assignment;			
		
	}
	public  Employee removeAssignment(String employeeId, String assignmentId){
		return new Employee();
	}
	public  Employee updateAssignment(String employeeId, String assignmentId, String property, Object newValue){
		return new Employee();
	}



}


