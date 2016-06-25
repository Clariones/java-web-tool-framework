
package com.terapico.b2b.action;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.terapico.b2b.order.Order;

public class ActionMapper implements RowMapper<Action>{
	
	public Action mapRow(ResultSet rs, int rowNumber) throws SQLException{
		Action action = getAction();		
		 		
 		setId(action, rs, rowNumber); 		
 		setName(action, rs, rowNumber); 		
 		setInternalName(action, rs, rowNumber); 		
 		setBo(action, rs, rowNumber); 		
 		setVersion(action, rs, rowNumber);

		return action;
	}
	
	protected Action getAction(){
		return new Action();
	}		
		
	protected void setId(Action action, ResultSet rs, int rowNumber) throws SQLException{
		action.setId(rs.getString("id"));
	}
		
	protected void setName(Action action, ResultSet rs, int rowNumber) throws SQLException{
		action.setName(rs.getString("name"));
	}
		
	protected void setInternalName(Action action, ResultSet rs, int rowNumber) throws SQLException{
		action.setInternalName(rs.getString("internal_name"));
	}
		 		
 	protected void setBo(Action action, ResultSet rs, int rowNumber) throws SQLException{
 		String orderId = rs.getString("bo");
 		if( orderId == null){
 			return;
 		}
 		if( orderId.isEmpty()){
 			return;
 		}
 		Order order = action.getBo();
 		if( order != null ){
 			//if the root object 'action' already have the property, just set the id for it;
 			order.setId(orderId);
 			return;
 		}
 		action.setBo(createEmptyBo(orderId));
 	}
 	
	protected void setVersion(Action action, ResultSet rs, int rowNumber) throws SQLException{
		action.setVersion(rs.getInt("version"));
	}
		
		

 	protected Order  createEmptyBo(String orderId){
 		Order order = new Order();
 		order.setId(orderId);
 		return order;
 	}
 	
}






