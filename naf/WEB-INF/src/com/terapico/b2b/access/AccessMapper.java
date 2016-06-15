
package com.terapico.b2b.access;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.terapico.b2b.role.Role;
import com.terapico.b2b.assignment.Assignment;

public class AccessMapper implements RowMapper<Access>{
	
	public Access mapRow(ResultSet rs, int rowNumber) throws SQLException{
		Access access =new Access();

		
		access.setId(rs.getString("id"));
		access.setRoleName(rs.getString("role_name"));
		 		
 		access.setRole(createEmptyRole(rs.getString("role")));
 		access.setVersion(rs.getInt("version"));
		

		return access;
	}
	


		

 	protected Role  createEmptyRole (String id){
 		Role ret=new Role ();
 		ret.setId(id);
 		return ret;
 
 
 	}

	
}

