
package com.terapico.b2b.confirmation;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class ConfirmationMapper implements RowMapper<Confirmation>{
	
	public Confirmation mapRow(ResultSet rs, int rowNumber) throws SQLException{
		Confirmation confirmation = getConfirmation();		
		 		
 		setId(confirmation, rs, rowNumber); 		
 		setWho(confirmation, rs, rowNumber); 		
 		setConfirmTime(confirmation, rs, rowNumber); 		
 		setVersion(confirmation, rs, rowNumber);

		return confirmation;
	}
	
	protected Confirmation getConfirmation(){
		return new Confirmation();
	}		
		
	protected void setId(Confirmation confirmation, ResultSet rs, int rowNumber) throws SQLException{
		confirmation.setId(rs.getString("id"));
	}
		
	protected void setWho(Confirmation confirmation, ResultSet rs, int rowNumber) throws SQLException{
		confirmation.setWho(rs.getString("who"));
	}
		
	protected void setConfirmTime(Confirmation confirmation, ResultSet rs, int rowNumber) throws SQLException{
		confirmation.setConfirmTime(rs.getDate("confirm_time"));
	}
		
	protected void setVersion(Confirmation confirmation, ResultSet rs, int rowNumber) throws SQLException{
		confirmation.setVersion(rs.getInt("version"));
	}
		
		

}


