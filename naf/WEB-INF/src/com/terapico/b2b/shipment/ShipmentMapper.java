
package com.terapico.b2b.shipment;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.terapico.b2b.order.Order;

public class ShipmentMapper implements RowMapper<Shipment>{
	
	public Shipment mapRow(ResultSet rs, int rowNumber) throws SQLException{
		Shipment shipment = getShipment();		
		 		
 		setId(shipment, rs, rowNumber); 		
 		setWho(shipment, rs, rowNumber); 		
 		setShipTime(shipment, rs, rowNumber); 		
 		setVersion(shipment, rs, rowNumber);

		return shipment;
	}
	
	protected Shipment getShipment(){
		return new Shipment();
	}		
		
	protected void setId(Shipment shipment, ResultSet rs, int rowNumber) throws SQLException{
		shipment.setId(rs.getString("id"));
	}
		
	protected void setWho(Shipment shipment, ResultSet rs, int rowNumber) throws SQLException{
		shipment.setWho(rs.getString("who"));
	}
		
	protected void setShipTime(Shipment shipment, ResultSet rs, int rowNumber) throws SQLException{
		shipment.setShipTime(rs.getDate("ship_time"));
	}
		
	protected void setVersion(Shipment shipment, ResultSet rs, int rowNumber) throws SQLException{
		shipment.setVersion(rs.getInt("version"));
	}
		
		

}


