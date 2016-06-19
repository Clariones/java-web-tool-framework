
package com.terapico.b2b.shipment;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.terapico.b2b.order.Order;

public class ShipmentMapper implements RowMapper<Shipment>{
	
	public Shipment mapRow(ResultSet rs, int rowNumber) throws SQLException{
		Shipment shipment =new Shipment();

		
		shipment.setId(rs.getString("id"));
		shipment.setWho(rs.getString("who"));
		shipment.setShupTime(rs.getDate("shup_time"));
		shipment.setVersion(rs.getInt("version"));
		

		return shipment;
	}
	


		


	
}

