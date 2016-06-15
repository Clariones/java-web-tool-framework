
package com.terapico.b2b.processing;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.terapico.b2b.order.Order;

public class ProcessingMapper implements RowMapper<Processing>{
	
	public Processing mapRow(ResultSet rs, int rowNumber) throws SQLException{
		Processing processing =new Processing();

		
		processing.setId(rs.getString("id"));
		processing.setWho(rs.getString("who"));
		processing.setD(rs.getDate("d"));
		processing.setVersion(rs.getInt("version"));
		

		return processing;
	}
	


		


	
}

