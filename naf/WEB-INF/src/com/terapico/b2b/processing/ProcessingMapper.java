
package com.terapico.b2b.processing;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class ProcessingMapper implements RowMapper<Processing>{
	
	public Processing mapRow(ResultSet rs, int rowNumber) throws SQLException{
		Processing processing = getProcessing();		
		 		
 		setId(processing, rs, rowNumber); 		
 		setWho(processing, rs, rowNumber); 		
 		setProcessTime(processing, rs, rowNumber); 		
 		setVersion(processing, rs, rowNumber);

		return processing;
	}
	
	protected Processing getProcessing(){
		return new Processing();
	}		
		
	protected void setId(Processing processing, ResultSet rs, int rowNumber) throws SQLException{
		processing.setId(rs.getString("id"));
	}
		
	protected void setWho(Processing processing, ResultSet rs, int rowNumber) throws SQLException{
		processing.setWho(rs.getString("who"));
	}
		
	protected void setProcessTime(Processing processing, ResultSet rs, int rowNumber) throws SQLException{
		processing.setProcessTime(rs.getDate("process_time"));
	}
		
	protected void setVersion(Processing processing, ResultSet rs, int rowNumber) throws SQLException{
		processing.setVersion(rs.getInt("version"));
	}
		
		

}


