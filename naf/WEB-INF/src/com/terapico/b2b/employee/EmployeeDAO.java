
package com.terapico.b2b.employee;

import java.util.List;
import java.util.Set;
import java.util.Map;
public interface EmployeeDAO{

	
	public Employee load(String employeeId,Map<String,Object> options) throws Exception;
	public Employee clone(String employeeId,Map<String,Object> options) throws Exception;
	
	public Employee save(Employee employee,Map<String,Object> options);
	public List<Employee> saveList(List<Employee> employeeList,Map<String,Object> options);
	
	public void delete(String employeeId, int version) throws Exception;
	public int deleteAll() throws Exception;
 	public List<Employee> findEmployeeByCompany(String buyerCompanyId);
 }


