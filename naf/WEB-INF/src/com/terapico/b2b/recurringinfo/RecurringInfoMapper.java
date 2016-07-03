
package com.terapico.b2b.recurringinfo;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class RecurringInfoMapper implements RowMapper<RecurringInfo>{
	
	public RecurringInfo mapRow(ResultSet rs, int rowNumber) throws SQLException{
		RecurringInfo recurringInfo = getRecurringInfo();		
		 		
 		setId(recurringInfo, rs, rowNumber); 		
 		setName(recurringInfo, rs, rowNumber); 		
 		setNextTime(recurringInfo, rs, rowNumber); 		
 		setCronExpr(recurringInfo, rs, rowNumber); 		
 		setVersion(recurringInfo, rs, rowNumber);

		return recurringInfo;
	}
	
	protected RecurringInfo getRecurringInfo(){
		return new RecurringInfo();
	}		
		
	protected void setId(RecurringInfo recurringInfo, ResultSet rs, int rowNumber) throws SQLException{
		recurringInfo.setId(rs.getString("id"));
	}
		
	protected void setName(RecurringInfo recurringInfo, ResultSet rs, int rowNumber) throws SQLException{
		recurringInfo.setName(rs.getString("name"));
	}
		
	protected void setNextTime(RecurringInfo recurringInfo, ResultSet rs, int rowNumber) throws SQLException{
		recurringInfo.setNextTime(rs.getDate("next_time"));
	}
		
	protected void setCronExpr(RecurringInfo recurringInfo, ResultSet rs, int rowNumber) throws SQLException{
		recurringInfo.setCronExpr(rs.getString("cron_expr"));
	}
		
	protected void setVersion(RecurringInfo recurringInfo, ResultSet rs, int rowNumber) throws SQLException{
		recurringInfo.setVersion(rs.getInt("version"));
	}
		
		

}


