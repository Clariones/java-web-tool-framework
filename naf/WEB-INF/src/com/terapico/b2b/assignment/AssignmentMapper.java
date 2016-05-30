
package com.terapico.b2b.assignment;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.terapico.b2b.access.Access;
import com.terapico.b2b.employee.Employee;

public class AssignmentMapper implements RowMapper<Assignment>{



	
	public Assignment mapRow(ResultSet rs, int rowNumber) throws SQLException{
		Assignment assignment =new Assignment();

		
		assignment.setId(rs.getString("id"));
		 		
 		assignment.setUser(createEmptyUser(rs.getString("user"))); 		
 		assignment.setAccess(createEmptyAccess(rs.getString("access")));assignment.setAssignedDate(rs.getDate("assigned_date"));
		assignment.setVersion(rs.getInt("version"));
		

		return assignment;
	}
	


		

 	protected Employee  createEmptyUser (String id){
 		Employee ret=new Employee ();
 		ret.setId(id);
 		return ret;
 
 
 	}
 	protected Access  createEmptyAccess (String id){
 		Access ret=new Access ();
 		ret.setId(id);
 		return ret;
 
 
 	}

	
}

