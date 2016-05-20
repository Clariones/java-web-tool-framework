
package com.terapico.b2b;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class BuyerCompanyMapper implements RowMapper<BuyerCompany>{



	
	public BuyerCompany mapRow(ResultSet rs, int rowNumber) throws SQLException{
		BuyerCompany buyerCompany =new BuyerCompany();

		
		buyerCompany.setId(rs.getString("id"));
		buyerCompany.setName(rs.getString("name"));
		buyerCompany.setPriceList(rs.getString("price_list"));
		buyerCompany.setVersion(rs.getInt("version"));
		

		return buyerCompany;
	}
	


		


	
}

