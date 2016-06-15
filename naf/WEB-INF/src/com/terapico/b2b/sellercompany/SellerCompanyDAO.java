
package com.terapico.b2b.sellercompany;

import java.util.List;
import java.util.Set;
import java.util.Map;
public interface SellerCompanyDAO{

	
	public SellerCompany load(String sellerCompanyId,Map<String,Object> options) throws Exception;
	public SellerCompany clone(String sellerCompanyId,Map<String,Object> options) throws Exception;
	
	public SellerCompany save(SellerCompany sellerCompany,Map<String,Object> options);
	public List<SellerCompany> saveList(List<SellerCompany> sellerCompanyList,Map<String,Object> options);
	
	public void delete(String sellerCompanyId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


