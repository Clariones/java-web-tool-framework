
package com.terapico.b2b;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class AccessMapper implements RowMapper<Access>{



	
	public Access mapRow(ResultSet rs, int rowNumber) throws SQLException{
		Access access =new Access();

		
		access.setId(rs.getString("id"));
		 		
 		access.setRole(createEmptyRole(rs.getString("role")));access.setVersion(rs.getInt("version"));
		

		return access;
	}
	


		

 	protected Role  createEmptyRole (String id){
 		Role ret=new Role ();
 		ret.setId(id);
 		return ret;
 
 
 	}

	
}

