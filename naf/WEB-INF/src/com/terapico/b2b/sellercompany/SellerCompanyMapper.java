
package com.terapico.b2b.sellercompany;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class SellerCompanyMapper implements RowMapper<SellerCompany>{
	
	public SellerCompany mapRow(ResultSet rs, int rowNumber) throws SQLException{
		SellerCompany sellerCompany = getSellerCompany();		
		 		
 		setId(sellerCompany, rs, rowNumber); 		
 		setName(sellerCompany, rs, rowNumber); 		
 		setOwner(sellerCompany, rs, rowNumber); 		
 		setLogo(sellerCompany, rs, rowNumber); 		
 		setContractText(sellerCompany, rs, rowNumber); 		
 		setVersion(sellerCompany, rs, rowNumber);

		return sellerCompany;
	}
	
	protected SellerCompany getSellerCompany(){
		return new SellerCompany();
	}		
		
	protected void setId(SellerCompany sellerCompany, ResultSet rs, int rowNumber) throws SQLException{
		sellerCompany.setId(rs.getString("id"));
	}
		
	protected void setName(SellerCompany sellerCompany, ResultSet rs, int rowNumber) throws SQLException{
		sellerCompany.setName(rs.getString("name"));
	}
		
	protected void setOwner(SellerCompany sellerCompany, ResultSet rs, int rowNumber) throws SQLException{
		sellerCompany.setOwner(rs.getString("owner"));
	}
		
	protected void setLogo(SellerCompany sellerCompany, ResultSet rs, int rowNumber) throws SQLException{
		sellerCompany.setLogo(rs.getString("logo"));
	}
		
	protected void setContractText(SellerCompany sellerCompany, ResultSet rs, int rowNumber) throws SQLException{
		sellerCompany.setContractText(rs.getString("contract_text"));
	}
		
	protected void setVersion(SellerCompany sellerCompany, ResultSet rs, int rowNumber) throws SQLException{
		sellerCompany.setVersion(rs.getInt("version"));
	}
		
		

}


