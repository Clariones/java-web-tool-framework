
package com.terapico.b2b.delivery;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.terapico.b2b.order.Order;

public class DeliveryMapper implements RowMapper<Delivery>{
	
	public Delivery mapRow(ResultSet rs, int rowNumber) throws SQLException{
		Delivery delivery = getDelivery();		
		 		
 		setId(delivery, rs, rowNumber); 		
 		setWho(delivery, rs, rowNumber); 		
 		setDeliveryTime(delivery, rs, rowNumber); 		
 		setVersion(delivery, rs, rowNumber);

		return delivery;
	}
	
	protected Delivery getDelivery(){
		return new Delivery();
	}		
		
	protected void setId(Delivery delivery, ResultSet rs, int rowNumber) throws SQLException{
		delivery.setId(rs.getString("id"));
	}
		
	protected void setWho(Delivery delivery, ResultSet rs, int rowNumber) throws SQLException{
		delivery.setWho(rs.getString("who"));
	}
		
	protected void setDeliveryTime(Delivery delivery, ResultSet rs, int rowNumber) throws SQLException{
		delivery.setDeliveryTime(rs.getDate("delivery_time"));
	}
		
	protected void setVersion(Delivery delivery, ResultSet rs, int rowNumber) throws SQLException{
		delivery.setVersion(rs.getInt("version"));
	}
		
		

}


