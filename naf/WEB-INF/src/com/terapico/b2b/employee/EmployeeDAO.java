
package com.terapico.b2b.employee;

import java.util.List;
import java.util.Set;
public interface EmployeeDAO{

	
	public Employee load(String employeeId,Set<String> options) throws Exception;
	public Employee clone(String employeeId,Set<String> options) throws Exception;
	
	public Employee save(Employee employee,Set<String> options);
	public List<Employee> saveList(List<Employee> employeeList,Set<String> options);
	
	public void delete(String employeeId, int version) throws Exception;
 	public List<Employee> findEmployeeByCompany(String buyerCompanyId);
 }


