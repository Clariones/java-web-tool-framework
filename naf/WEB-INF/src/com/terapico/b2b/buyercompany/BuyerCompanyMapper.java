
package com.terapico.b2b.buyercompany;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.terapico.b2b.order.Order;
import com.terapico.b2b.billingaddress.BillingAddress;
import com.terapico.b2b.employee.Employee;

public class BuyerCompanyMapper implements RowMapper<BuyerCompany>{
	
	public BuyerCompany mapRow(ResultSet rs, int rowNumber) throws SQLException{
		BuyerCompany buyerCompany = getBuyerCompany();		
		 		
 		setId(buyerCompany, rs, rowNumber); 		
 		setName(buyerCompany, rs, rowNumber); 		
 		setPriceList(buyerCompany, rs, rowNumber); 		
 		setRating(buyerCompany, rs, rowNumber); 		
 		setLogo(buyerCompany, rs, rowNumber); 		
 		setOwner(buyerCompany, rs, rowNumber); 		
 		setVersion(buyerCompany, rs, rowNumber);

		return buyerCompany;
	}
	
	protected BuyerCompany getBuyerCompany(){
		return new BuyerCompany();
	}		
		
	protected void setId(BuyerCompany buyerCompany, ResultSet rs, int rowNumber) throws SQLException{
		buyerCompany.setId(rs.getString("id"));
	}
		
	protected void setName(BuyerCompany buyerCompany, ResultSet rs, int rowNumber) throws SQLException{
		buyerCompany.setName(rs.getString("name"));
	}
		
	protected void setPriceList(BuyerCompany buyerCompany, ResultSet rs, int rowNumber) throws SQLException{
		buyerCompany.setPriceList(rs.getString("price_list"));
	}
		
	protected void setRating(BuyerCompany buyerCompany, ResultSet rs, int rowNumber) throws SQLException{
		buyerCompany.setRating(rs.getInt("rating"));
	}
		
	protected void setLogo(BuyerCompany buyerCompany, ResultSet rs, int rowNumber) throws SQLException{
		buyerCompany.setLogo(rs.getString("logo"));
	}
		
	protected void setOwner(BuyerCompany buyerCompany, ResultSet rs, int rowNumber) throws SQLException{
		buyerCompany.setOwner(rs.getString("owner"));
	}
		
	protected void setVersion(BuyerCompany buyerCompany, ResultSet rs, int rowNumber) throws SQLException{
		buyerCompany.setVersion(rs.getInt("version"));
	}
		
		

}


