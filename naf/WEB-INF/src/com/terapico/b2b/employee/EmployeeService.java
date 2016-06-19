
package com.terapico.b2b.employee;

import java.util.List;
import java.util.Set;
public interface EmployeeService{

	
	public Employee createEmployee(String employeeId,String[] options) throws Exception;
	public Employee clone(String employeeId, String[] options) throws Exception;
	
	public Employee save(Employee employee,String[] options);
	public List<Employee> saveList(List<Employee> employeeList,String[] options);
	
	public void delete(String employeeId, int version) throws Exception;
	public int deleteAll() throws Exception;
 	public List<Employee> findEmployeeByCompany(String buyerCompanyId);
 }


