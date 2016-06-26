
package com.terapico.b2b.employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.terapico.b2b.buyercompany.BuyerCompany;
import com.terapico.b2b.assignment.Assignment;

public class EmployeeMapper implements RowMapper<Employee>{
	
	public Employee mapRow(ResultSet rs, int rowNumber) throws SQLException{
		Employee employee = getEmployee();		
		 		
 		setId(employee, rs, rowNumber); 		
 		setName(employee, rs, rowNumber); 		
 		setCompany(employee, rs, rowNumber); 		
 		setEmail(employee, rs, rowNumber); 		
 		setPasswd(employee, rs, rowNumber); 		
 		setCellPhone(employee, rs, rowNumber); 		
 		setVersion(employee, rs, rowNumber);

		return employee;
	}
	
	protected Employee getEmployee(){
		return new Employee();
	}		
		
	protected void setId(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
		employee.setId(rs.getString("id"));
	}
		
	protected void setName(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
		employee.setName(rs.getString("name"));
	}
		 		
 	protected void setCompany(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
 		String buyerCompanyId = rs.getString("company");
 		if( buyerCompanyId == null){
 			return;
 		}
 		if( buyerCompanyId.isEmpty()){
 			return;
 		}
 		BuyerCompany buyerCompany = employee.getCompany();
 		if( buyerCompany != null ){
 			//if the root object 'employee' already have the property, just set the id for it;
 			buyerCompany.setId(buyerCompanyId);
 			return;
 		}
 		employee.setCompany(createEmptyCompany(buyerCompanyId));
 	}
 	
	protected void setEmail(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
		employee.setEmail(rs.getString("email"));
	}
		
	protected void setPasswd(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
		employee.setPasswd(rs.getString("passwd"));
	}
		
	protected void setCellPhone(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
		employee.setCellPhone(rs.getString("cell_phone"));
	}
		
	protected void setVersion(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
		employee.setVersion(rs.getInt("version"));
	}
		
		

 	protected BuyerCompany  createEmptyCompany(String buyerCompanyId){
 		BuyerCompany buyerCompany = new BuyerCompany();
 		buyerCompany.setId(buyerCompanyId);
 		return buyerCompany;
 	}
 	
}


