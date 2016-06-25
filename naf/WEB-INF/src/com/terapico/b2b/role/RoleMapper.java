
package com.terapico.b2b.role;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.terapico.b2b.access.Access;
import com.terapico.b2b.custsvcrep.CustSvcRep;

public class RoleMapper implements RowMapper<Role>{
	
	public Role mapRow(ResultSet rs, int rowNumber) throws SQLException{
		Role role = getRole();		
		 		
 		setId(role, rs, rowNumber); 		
 		setRoleName(role, rs, rowNumber); 		
 		setVersion(role, rs, rowNumber);

		return role;
	}
	
	protected Role getRole(){
		return new Role();
	}		
		
	protected void setId(Role role, ResultSet rs, int rowNumber) throws SQLException{
		role.setId(rs.getString("id"));
	}
		
	protected void setRoleName(Role role, ResultSet rs, int rowNumber) throws SQLException{
		role.setRoleName(rs.getString("role_name"));
	}
		
	protected void setVersion(Role role, ResultSet rs, int rowNumber) throws SQLException{
		role.setVersion(rs.getInt("version"));
	}
		
		

}


