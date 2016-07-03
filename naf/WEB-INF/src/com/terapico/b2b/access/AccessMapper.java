
package com.terapico.b2b.access;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.terapico.b2b.role.Role;

public class AccessMapper implements RowMapper<Access>{
	
	public Access mapRow(ResultSet rs, int rowNumber) throws SQLException{
		Access access = getAccess();		
		 		
 		setId(access, rs, rowNumber); 		
 		setRoleName(access, rs, rowNumber); 		
 		setRole(access, rs, rowNumber); 		
 		setVersion(access, rs, rowNumber);

		return access;
	}
	
	protected Access getAccess(){
		return new Access();
	}		
		
	protected void setId(Access access, ResultSet rs, int rowNumber) throws SQLException{
		access.setId(rs.getString("id"));
	}
		
	protected void setRoleName(Access access, ResultSet rs, int rowNumber) throws SQLException{
		access.setRoleName(rs.getString("role_name"));
	}
		 		
 	protected void setRole(Access access, ResultSet rs, int rowNumber) throws SQLException{
 		String roleId = rs.getString("role");
 		if( roleId == null){
 			return;
 		}
 		if( roleId.isEmpty()){
 			return;
 		}
 		Role role = access.getRole();
 		if( role != null ){
 			//if the root object 'access' already have the property, just set the id for it;
 			role.setId(roleId);
 			return;
 		}
 		access.setRole(createEmptyRole(roleId));
 	}
 	
	protected void setVersion(Access access, ResultSet rs, int rowNumber) throws SQLException{
		access.setVersion(rs.getInt("version"));
	}
		
		

 	protected Role  createEmptyRole(String roleId){
 		Role role = new Role();
 		role.setId(roleId);
 		return role;
 	}
 	
}


