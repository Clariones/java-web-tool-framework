
package com.terapico.b2b.role;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.terapico.b2b.access.Access;
import com.terapico.b2b.custsvcrep.CustSvcRep;

public class RoleMapper implements RowMapper<Role>{
	
	public Role mapRow(ResultSet rs, int rowNumber) throws SQLException{
		Role role =new Role();

		
		role.setId(rs.getString("id"));
		role.setRoleName(rs.getString("role_name"));
		role.setVersion(rs.getInt("version"));
		

		return role;
	}
	


		


	
}

