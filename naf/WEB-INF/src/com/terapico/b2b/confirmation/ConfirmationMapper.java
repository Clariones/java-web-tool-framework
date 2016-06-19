
package com.terapico.b2b.confirmation;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.terapico.b2b.order.Order;

public class ConfirmationMapper implements RowMapper<Confirmation>{
	
	public Confirmation mapRow(ResultSet rs, int rowNumber) throws SQLException{
		Confirmation confirmation =new Confirmation();

		
		confirmation.setId(rs.getString("id"));
		confirmation.setWho(rs.getString("who"));
		confirmation.setConfirmTime(rs.getDate("confirm_time"));
		confirmation.setVersion(rs.getInt("version"));
		

		return confirmation;
	}
	


		


	
}

