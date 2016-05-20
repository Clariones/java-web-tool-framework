
package com.terapico.b2b;

import java.util.List;
import java.util.ArrayList;
public class EmployeeJDBCTemplateDAO extends CommonJDBCTemplateDAO implements EmployeeDAO{

	public Employee load(String employeeId) throws EmployeeNotFoundException{
		return loadInternalEmployee(employeeId);
	}
	public Employee save(Employee employee){
		return employee;
	}
	public void delete(String employeeId) throws EmployeeNotFoundException{
	
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"name","company"};
	}
	@Override
	protected String getName() {
		
		return "employee";
	}
	
	 
 	private boolean extractCompanyEnabled = true;
 	public boolean isExtractCompanyEnabled(){
	 	return extractCompanyEnabled;
 	}
 	
 	public void setExtractCompanyEnabled(boolean extractCompanyEnabled){
	 	this.extractCompanyEnabled = extractCompanyEnabled;
 	}
 	
 	private boolean saveCompanyEnabled = true;
 	public boolean isSaveCompanyEnabled(){
	 	return saveCompanyEnabled;
 	}
 	
 	public void setSaveCompanyEnabled(boolean saveCompanyEnabled){
	 	this.saveCompanyEnabled = saveCompanyEnabled;
 	}
 	
 
		
	private boolean extractAssignmentListEnabled = false;
	public boolean isExtractAssignmentListEnabled(){
		return extractAssignmentListEnabled;
		
 	}
 	public void setExtractAssignmentListEnabled(boolean extractAssignmentListEnabled){
		this.extractAssignmentListEnabled = extractAssignmentListEnabled;
		
 	}
 	
 	private boolean saveAssignmentListEnabled = false;
	public boolean isSaveAssignmentListEnabled(){
		return saveAssignmentListEnabled;
		
 	}
 	public void setSaveAssignmentListEnabled(boolean saveAssignmentListEnabled){
		this.saveAssignmentListEnabled = saveAssignmentListEnabled;
		
 	}			
		
	

	protected Employee extractEmployee(String employeeId){
		return null;
	}

	protected Employee loadInternalEmployee(String employeeId){
		
		Employee employee = extractEmployee(employeeId);
 	
 		if(isExtractCompanyEnabled()){
	 		extractCompany(employee);
 		}
 
		
		if(isExtractAssignmentListEnabled()){
	 		extractAssignmentList(employee);
 		}		
		
		return employee;
		
	}//method end loadInternalEmployee(String employeeId)
	
	//======================================================================================
	 
 	protected Employee extractCompany(Employee employee){
 		
 		return employee;
 	}
 		
 
		
	protected Employee extractAssignmentList(Employee employee){
		
		return employee;
	
	}	
		
	

	protected Employee saveEmployee(Employee  employee){
	
		return employee;
	
	}
	protected Employee saveInternalEmployee(Employee employee){
		
		saveEmployee(employee);
 	
 		if(isSaveCompanyEnabled()){
	 		saveCompany(employee);
 		}
 
		
		if(isSaveAssignmentListEnabled()){
	 		saveAssignmentList(employee);
 		}		
		
		return employee;
		
	}//method end loadInternalEmployee(String employeeId)
	
	
	
	//======================================================================================
	 
 	protected Employee saveCompany(Employee employee){
 	
 		return employee;
 	}
 		
 
		
	protected Employee saveAssignmentList(Employee employee){
		
		return employee;
	
	}
		
 	
 	public List<Employee> findEmployeeByCompany(String buyerCompanyId){
 		return new ArrayList<Employee>();
 	}//find end
 
}


