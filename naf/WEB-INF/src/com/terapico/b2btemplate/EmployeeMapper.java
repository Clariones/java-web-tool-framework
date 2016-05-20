
package com.terapico.b2btemplate;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeMapper implements RowMapper<Employee>{



	
	public Employee mapRow(ResultSet rs, int rowNumber) throws SQLException{
		Employee employee =new Employee();

		
		employee.setId(rs.getString("id"));
		employee.setName(rs.getString("name"));
		 		
 		employee.setCompany(createEmptyCompany(rs.getString("company")));employee.setVersion(rs.getInt("version"));
		

		return employee;
	}
	


		

 	protected BuyerCompany  createEmptyCompany (String id){
 		BuyerCompany ret=new BuyerCompany ();
 		ret.setId(id);
 		return ret;
 
 
 	}

	
}

