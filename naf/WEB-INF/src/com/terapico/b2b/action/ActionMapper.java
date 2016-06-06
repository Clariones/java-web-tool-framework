
package com.terapico.b2b.action;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.terapico.b2b.order.Order;

public class ActionMapper implements RowMapper<Action>{
	
	public Action mapRow(ResultSet rs, int rowNumber) throws SQLException{
		Action action =new Action();

		
		action.setId(rs.getString("id"));
		action.setName(rs.getString("name"));
		action.setInternalName(rs.getString("internal_name"));
		 		
 		action.setBo(createEmptyBo(rs.getString("bo")));
 		action.setVersion(rs.getInt("version"));
		

		return action;
	}
	


		

 	protected Order  createEmptyBo (String id){
 		Order ret=new Order ();
 		ret.setId(id);
 		return ret;
 
 
 	}

	
}










