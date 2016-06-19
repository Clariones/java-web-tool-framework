
package com.terapico.b2b.sellercompany;

import java.util.List;
import java.util.Set;
public interface SellerCompanyService{

	
	public SellerCompany createSellerCompany(String sellerCompanyId,String[] options) throws Exception;
	public SellerCompany clone(String sellerCompanyId, String[] options) throws Exception;
	
	public SellerCompany save(SellerCompany sellerCompany,String[] options);
	public List<SellerCompany> saveList(List<SellerCompany> sellerCompanyList,String[] options);
	
	public void delete(String sellerCompanyId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


