
package com.terapico.b2b;

import java.util.List;

public interface EmployeeDAO{

	
	public Employee load(String employeeId) throws EmployeeNotFoundException;
	public Employee save(Employee employee);
	public void delete(String employeeId) throws EmployeeNotFoundException;
 	public List<Employee> findEmployeeByCompany(String buyerCompanyId);
 }


