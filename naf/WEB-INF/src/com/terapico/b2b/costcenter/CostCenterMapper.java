
package com.terapico.b2b.costcenter;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.terapico.b2b.buyercompany.BuyerCompany;

public class CostCenterMapper implements RowMapper<CostCenter>{
	
	public CostCenter mapRow(ResultSet rs, int rowNumber) throws SQLException{
		CostCenter costCenter = getCostCenter();		
		 		
 		setId(costCenter, rs, rowNumber); 		
 		setName(costCenter, rs, rowNumber); 		
 		setBelongsTo(costCenter, rs, rowNumber); 		
 		setVersion(costCenter, rs, rowNumber);

		return costCenter;
	}
	
	protected CostCenter getCostCenter(){
		return new CostCenter();
	}		
		
	protected void setId(CostCenter costCenter, ResultSet rs, int rowNumber) throws SQLException{
		costCenter.setId(rs.getString("id"));
	}
		
	protected void setName(CostCenter costCenter, ResultSet rs, int rowNumber) throws SQLException{
		costCenter.setName(rs.getString("name"));
	}
		 		
 	protected void setBelongsTo(CostCenter costCenter, ResultSet rs, int rowNumber) throws SQLException{
 		String buyerCompanyId = rs.getString("belongs_to");
 		if( buyerCompanyId == null){
 			return;
 		}
 		if( buyerCompanyId.isEmpty()){
 			return;
 		}
 		BuyerCompany buyerCompany = costCenter.getBelongsTo();
 		if( buyerCompany != null ){
 			//if the root object 'costCenter' already have the property, just set the id for it;
 			buyerCompany.setId(buyerCompanyId);
 			return;
 		}
 		costCenter.setBelongsTo(createEmptyBelongsTo(buyerCompanyId));
 	}
 	
	protected void setVersion(CostCenter costCenter, ResultSet rs, int rowNumber) throws SQLException{
		costCenter.setVersion(rs.getInt("version"));
	}
		
		

 	protected BuyerCompany  createEmptyBelongsTo(String buyerCompanyId){
 		BuyerCompany buyerCompany = new BuyerCompany();
 		buyerCompany.setId(buyerCompanyId);
 		return buyerCompany;
 	}
 	
}


