
package com.terapico.b2b.approval;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.terapico.b2b.order.Order;

public class ApprovalMapper implements RowMapper<Approval>{
	
	public Approval mapRow(ResultSet rs, int rowNumber) throws SQLException{
		Approval approval =new Approval();

		
		approval.setId(rs.getString("id"));
		approval.setWho(rs.getString("who"));
		approval.setApproveTime(rs.getDate("approve_time"));
		approval.setVersion(rs.getInt("version"));
		

		return approval;
	}
	


		


	
}

