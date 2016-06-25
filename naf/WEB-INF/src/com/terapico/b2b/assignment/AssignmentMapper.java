
package com.terapico.b2b.assignment;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.terapico.b2b.access.Access;
import com.terapico.b2b.employee.Employee;

public class AssignmentMapper implements RowMapper<Assignment>{
	
	public Assignment mapRow(ResultSet rs, int rowNumber) throws SQLException{
		Assignment assignment = getAssignment();		
		 		
 		setId(assignment, rs, rowNumber); 		
 		setUser(assignment, rs, rowNumber); 		
 		setAccess(assignment, rs, rowNumber); 		
 		setAssignedDate(assignment, rs, rowNumber); 		
 		setVersion(assignment, rs, rowNumber);

		return assignment;
	}
	
	protected Assignment getAssignment(){
		return new Assignment();
	}		
		
	protected void setId(Assignment assignment, ResultSet rs, int rowNumber) throws SQLException{
		assignment.setId(rs.getString("id"));
	}
		 		
 	protected void setUser(Assignment assignment, ResultSet rs, int rowNumber) throws SQLException{
 		String employeeId = rs.getString("user");
 		if( employeeId == null){
 			return;
 		}
 		if( employeeId.isEmpty()){
 			return;
 		}
 		Employee employee = assignment.getUser();
 		if( employee != null ){
 			//if the root object 'assignment' already have the property, just set the id for it;
 			employee.setId(employeeId);
 			return;
 		}
 		assignment.setUser(createEmptyUser(employeeId));
 	}
 	 		
 	protected void setAccess(Assignment assignment, ResultSet rs, int rowNumber) throws SQLException{
 		String accessId = rs.getString("access");
 		if( accessId == null){
 			return;
 		}
 		if( accessId.isEmpty()){
 			return;
 		}
 		Access access = assignment.getAccess();
 		if( access != null ){
 			//if the root object 'assignment' already have the property, just set the id for it;
 			access.setId(accessId);
 			return;
 		}
 		assignment.setAccess(createEmptyAccess(accessId));
 	}
 	
	protected void setAssignedDate(Assignment assignment, ResultSet rs, int rowNumber) throws SQLException{
		assignment.setAssignedDate(rs.getDate("assigned_date"));
	}
		
	protected void setVersion(Assignment assignment, ResultSet rs, int rowNumber) throws SQLException{
		assignment.setVersion(rs.getInt("version"));
	}
		
		

 	protected Employee  createEmptyUser(String employeeId){
 		Employee employee = new Employee();
 		employee.setId(employeeId);
 		return employee;
 	}
 	
 	protected Access  createEmptyAccess(String accessId){
 		Access access = new Access();
 		access.setId(accessId);
 		return access;
 	}
 	
}


