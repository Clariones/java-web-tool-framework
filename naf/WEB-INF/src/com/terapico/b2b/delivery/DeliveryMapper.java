
package com.terapico.b2b.delivery;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.terapico.b2b.order.Order;

public class DeliveryMapper implements RowMapper<Delivery>{
	
	public Delivery mapRow(ResultSet rs, int rowNumber) throws SQLException{
		Delivery delivery =new Delivery();

		
		delivery.setId(rs.getString("id"));
		delivery.setWho(rs.getString("who"));
		delivery.setDeliveryTime(rs.getDate("delivery_time"));
		delivery.setVersion(rs.getInt("version"));
		

		return delivery;
	}
	


		


	
}

