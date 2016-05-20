
package com.terapico.b2b;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class SellerCompanyMapper implements RowMapper<SellerCompany>{



	
	public SellerCompany mapRow(ResultSet rs, int rowNumber) throws SQLException{
		SellerCompany sellerCompany =new SellerCompany();

		
		sellerCompany.setId(rs.getString("id"));
		sellerCompany.setName(rs.getString("name"));
		sellerCompany.setVersion(rs.getInt("version"));
		

		return sellerCompany;
	}
	


		


	
}

