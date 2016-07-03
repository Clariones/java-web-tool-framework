
package com.terapico.b2b.profitcenter;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.terapico.b2b.sellercompany.SellerCompany;

public class ProfitCenterMapper implements RowMapper<ProfitCenter>{
	
	public ProfitCenter mapRow(ResultSet rs, int rowNumber) throws SQLException{
		ProfitCenter profitCenter = getProfitCenter();		
		 		
 		setId(profitCenter, rs, rowNumber); 		
 		setName(profitCenter, rs, rowNumber); 		
 		setBelongsTo(profitCenter, rs, rowNumber); 		
 		setVersion(profitCenter, rs, rowNumber);

		return profitCenter;
	}
	
	protected ProfitCenter getProfitCenter(){
		return new ProfitCenter();
	}		
		
	protected void setId(ProfitCenter profitCenter, ResultSet rs, int rowNumber) throws SQLException{
		profitCenter.setId(rs.getString("id"));
	}
		
	protected void setName(ProfitCenter profitCenter, ResultSet rs, int rowNumber) throws SQLException{
		profitCenter.setName(rs.getString("name"));
	}
		 		
 	protected void setBelongsTo(ProfitCenter profitCenter, ResultSet rs, int rowNumber) throws SQLException{
 		String sellerCompanyId = rs.getString("belongs_to");
 		if( sellerCompanyId == null){
 			return;
 		}
 		if( sellerCompanyId.isEmpty()){
 			return;
 		}
 		SellerCompany sellerCompany = profitCenter.getBelongsTo();
 		if( sellerCompany != null ){
 			//if the root object 'profitCenter' already have the property, just set the id for it;
 			sellerCompany.setId(sellerCompanyId);
 			return;
 		}
 		profitCenter.setBelongsTo(createEmptyBelongsTo(sellerCompanyId));
 	}
 	
	protected void setVersion(ProfitCenter profitCenter, ResultSet rs, int rowNumber) throws SQLException{
		profitCenter.setVersion(rs.getInt("version"));
	}
		
		

 	protected SellerCompany  createEmptyBelongsTo(String sellerCompanyId){
 		SellerCompany sellerCompany = new SellerCompany();
 		sellerCompany.setId(sellerCompanyId);
 		return sellerCompany;
 	}
 	
}


