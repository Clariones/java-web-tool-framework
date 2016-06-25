
package com.terapico.b2b.custsvcrep;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.terapico.b2b.role.Role;
import com.terapico.b2b.sellercompany.SellerCompany;

public class CustSvcRepMapper implements RowMapper<CustSvcRep>{
	
	public CustSvcRep mapRow(ResultSet rs, int rowNumber) throws SQLException{
		CustSvcRep custSvcRep = getCustSvcRep();		
		 		
 		setId(custSvcRep, rs, rowNumber); 		
 		setEmail(custSvcRep, rs, rowNumber); 		
 		setRole(custSvcRep, rs, rowNumber); 		
 		setCompany(custSvcRep, rs, rowNumber); 		
 		setVersion(custSvcRep, rs, rowNumber);

		return custSvcRep;
	}
	
	protected CustSvcRep getCustSvcRep(){
		return new CustSvcRep();
	}		
		
	protected void setId(CustSvcRep custSvcRep, ResultSet rs, int rowNumber) throws SQLException{
		custSvcRep.setId(rs.getString("id"));
	}
		
	protected void setEmail(CustSvcRep custSvcRep, ResultSet rs, int rowNumber) throws SQLException{
		custSvcRep.setEmail(rs.getString("email"));
	}
		 		
 	protected void setRole(CustSvcRep custSvcRep, ResultSet rs, int rowNumber) throws SQLException{
 		String roleId = rs.getString("role");
 		if( roleId == null){
 			return;
 		}
 		if( roleId.isEmpty()){
 			return;
 		}
 		Role role = custSvcRep.getRole();
 		if( role != null ){
 			//if the root object 'custSvcRep' already have the property, just set the id for it;
 			role.setId(roleId);
 			return;
 		}
 		custSvcRep.setRole(createEmptyRole(roleId));
 	}
 	 		
 	protected void setCompany(CustSvcRep custSvcRep, ResultSet rs, int rowNumber) throws SQLException{
 		String sellerCompanyId = rs.getString("company");
 		if( sellerCompanyId == null){
 			return;
 		}
 		if( sellerCompanyId.isEmpty()){
 			return;
 		}
 		SellerCompany sellerCompany = custSvcRep.getCompany();
 		if( sellerCompany != null ){
 			//if the root object 'custSvcRep' already have the property, just set the id for it;
 			sellerCompany.setId(sellerCompanyId);
 			return;
 		}
 		custSvcRep.setCompany(createEmptyCompany(sellerCompanyId));
 	}
 	
	protected void setVersion(CustSvcRep custSvcRep, ResultSet rs, int rowNumber) throws SQLException{
		custSvcRep.setVersion(rs.getInt("version"));
	}
		
		

 	protected Role  createEmptyRole(String roleId){
 		Role role = new Role();
 		role.setId(roleId);
 		return role;
 	}
 	
 	protected SellerCompany  createEmptyCompany(String sellerCompanyId){
 		SellerCompany sellerCompany = new SellerCompany();
 		sellerCompany.setId(sellerCompanyId);
 		return sellerCompany;
 	}
 	
}


