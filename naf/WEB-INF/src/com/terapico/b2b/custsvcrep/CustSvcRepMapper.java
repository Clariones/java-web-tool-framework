
package com.terapico.b2b.custsvcrep;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.terapico.b2b.role.Role;
import com.terapico.b2b.sellercompany.SellerCompany;

public class CustSvcRepMapper implements RowMapper<CustSvcRep>{
	
	public CustSvcRep mapRow(ResultSet rs, int rowNumber) throws SQLException{
		CustSvcRep custSvcRep =new CustSvcRep();

		
		custSvcRep.setId(rs.getString("id"));
		custSvcRep.setEmail(rs.getString("email"));
		 		
 		custSvcRep.setRole(createEmptyRole(rs.getString("role")));
 		 		
 		custSvcRep.setCompany(createEmptyCompany(rs.getString("company")));
 		custSvcRep.setVersion(rs.getInt("version"));
		

		return custSvcRep;
	}
	


		

 	protected Role  createEmptyRole (String id){
 		Role ret=new Role ();
 		ret.setId(id);
 		return ret;
 
 
 	}
 	protected SellerCompany  createEmptyCompany (String id){
 		SellerCompany ret=new SellerCompany ();
 		ret.setId(id);
 		return ret;
 
 
 	}

	
}

