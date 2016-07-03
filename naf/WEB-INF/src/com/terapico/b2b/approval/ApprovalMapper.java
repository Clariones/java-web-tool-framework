
package com.terapico.b2b.approval;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class ApprovalMapper implements RowMapper<Approval>{
	
	public Approval mapRow(ResultSet rs, int rowNumber) throws SQLException{
		Approval approval = getApproval();		
		 		
 		setId(approval, rs, rowNumber); 		
 		setWho(approval, rs, rowNumber); 		
 		setApproveTime(approval, rs, rowNumber); 		
 		setVersion(approval, rs, rowNumber);

		return approval;
	}
	
	protected Approval getApproval(){
		return new Approval();
	}		
		
	protected void setId(Approval approval, ResultSet rs, int rowNumber) throws SQLException{
		approval.setId(rs.getString("id"));
	}
		
	protected void setWho(Approval approval, ResultSet rs, int rowNumber) throws SQLException{
		approval.setWho(rs.getString("who"));
	}
		
	protected void setApproveTime(Approval approval, ResultSet rs, int rowNumber) throws SQLException{
		approval.setApproveTime(rs.getDate("approve_time"));
	}
		
	protected void setVersion(Approval approval, ResultSet rs, int rowNumber) throws SQLException{
		approval.setVersion(rs.getInt("version"));
	}
		
		

}


