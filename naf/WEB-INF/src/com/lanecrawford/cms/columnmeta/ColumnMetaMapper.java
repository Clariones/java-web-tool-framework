
package com.lanecrawford.cms.columnmeta;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.lanecrawford.cms.actiontablemeta.ActionTableMeta;

public class ColumnMetaMapper implements RowMapper<ColumnMeta>{
	
	public ColumnMeta mapRow(ResultSet rs, int rowNumber) throws SQLException{
		ColumnMeta columnMeta =new ColumnMeta();

		
		columnMeta.setId(rs.getString("id"));
		columnMeta.setSourceColumn(rs.getString("source_column"));
		columnMeta.setDestColumn(rs.getString("dest_column"));
		 		
 		columnMeta.setActionTable(createEmptyActionTable(rs.getString("action_table")));
 		columnMeta.setType(rs.getString("type"));
		columnMeta.setLength(rs.getInt("length"));
		columnMeta.setVersion(rs.getInt("version"));
		

		return columnMeta;
	}
	


		

 	protected ActionTableMeta  createEmptyActionTable (String id){
 		ActionTableMeta ret=new ActionTableMeta ();
 		ret.setId(id);
 		return ret;
 
 
 	}

	
}










