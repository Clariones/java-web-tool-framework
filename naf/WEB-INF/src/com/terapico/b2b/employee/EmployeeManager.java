
package com.terapico.b2b.employee;

import java.util.Date;
public interface EmployeeManager{

	public Employee createEmployee(String name, String companyId, String email, String passwd, String cellPhone, String[] options) throws Exception;	
	public Employee updateEmployee(String employeeId, String property, Object newValue)  throws Exception;
	
	public Employee transferToNewCompany(String employeeId, String newCompanyId)  throws Exception;
 

	public void delete(String employeeId, int version) throws Exception;
	public int deleteAll() throws Exception;
	public  Employee addAssignment(String employeeId, String accessId, Date assignedDate)  throws Exception;
	public  Employee removeAssignment(String employeeId, String assignmentId)  throws Exception;
	public  Employee updateAssignment(String employeeId, String assignmentId, String property, Object newValue)  throws Exception;




}


