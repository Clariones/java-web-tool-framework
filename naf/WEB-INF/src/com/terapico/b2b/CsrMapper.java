
package com.terapico.b2b;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class CsrMapper implements RowMapper<Csr>{



	
	public Csr mapRow(ResultSet rs, int rowNumber) throws SQLException{
		Csr csr =new Csr();

		
		csr.setId(rs.getString("id"));
		csr.setEmail(rs.getString("email"));
		 		
 		csr.setRole(createEmptyRole(rs.getString("role"))); 		
 		csr.setCompany(createEmptyCompany(rs.getString("company")));csr.setVersion(rs.getInt("version"));
		

		return csr;
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










