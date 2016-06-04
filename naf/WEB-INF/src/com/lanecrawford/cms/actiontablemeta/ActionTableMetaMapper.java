
package com.lanecrawford.cms.actiontablemeta;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.lanecrawford.cms.columnmeta.ColumnMeta;

public class ActionTableMetaMapper implements RowMapper<ActionTableMeta>{
	
	public ActionTableMeta mapRow(ResultSet rs, int rowNumber) throws SQLException{
		ActionTableMeta actionTableMeta =new ActionTableMeta();

		
		actionTableMeta.setId(rs.getString("id"));
		actionTableMeta.setTableName(rs.getString("table_name"));
		actionTableMeta.setEnabled(rs.getBoolean("enabled"));
		actionTableMeta.setBatchsize(rs.getInt("batchsize"));
		actionTableMeta.setDescription(rs.getString("description"));
		actionTableMeta.setVersion(rs.getInt("version"));
		

		return actionTableMeta;
	}
	


		


	
}

