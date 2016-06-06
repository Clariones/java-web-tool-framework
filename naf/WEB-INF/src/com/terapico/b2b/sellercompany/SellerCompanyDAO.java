
package com.terapico.b2b.sellercompany;

import java.util.List;
import java.util.Set;
public interface SellerCompanyDAO{

	
	public SellerCompany load(String sellerCompanyId,Set<String> options) throws Exception;
	public SellerCompany clone(String sellerCompanyId,Set<String> options) throws Exception;
	
	public SellerCompany save(SellerCompany sellerCompany,Set<String> options);
	public List<SellerCompany> saveList(List<SellerCompany> sellerCompanyList,Set<String> options);
	
	public void delete(String sellerCompanyId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


