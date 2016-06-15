
package com.terapico.b2b.buyercompany;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.terapico.b2b.order.Order;
import com.terapico.b2b.billingaddress.BillingAddress;
import com.terapico.b2b.employee.Employee;

public class BuyerCompanyMapper implements RowMapper<BuyerCompany>{
	
	public BuyerCompany mapRow(ResultSet rs, int rowNumber) throws SQLException{
		BuyerCompany buyerCompany =new BuyerCompany();

		
		buyerCompany.setId(rs.getString("id"));
		buyerCompany.setName(rs.getString("name"));
		buyerCompany.setPriceList(rs.getString("price_list"));
		buyerCompany.setRating(rs.getInt("rating"));
		buyerCompany.setVersion(rs.getInt("version"));
		

		return buyerCompany;
	}
	


		


	
}

