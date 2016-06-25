
package com.terapico.b2b.employee;

import java.util.Date;
public class EmployeeManagerMock implements EmployeeManager {

	public Employee createEmployee(String name, String companyId, String email, String[] options) throws Exception
	{
		return new Employee();
	}
	public Employee updateEmployee(String employeeId, String property, Object newValue) throws Exception 
	{
		return new Employee();
	}
	
	public Employee transferToNewCompany(String employeeId, String newCompanyId) throws Exception
 	{
 		return new Employee();
 
 	}
 

	public void delete(String employeeId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}
	public  Employee addAssignment(String employeeId, String accessId, Date assignedDate)
	{
		return new Employee();
	}
	public  Employee removeAssignment(String employeeId, String assignmentId){
		return new Employee();
	}
	public  Employee updateAssignment(String employeeId, String assignmentId, String property, Object newValue){
		return new Employee();
	}




}


