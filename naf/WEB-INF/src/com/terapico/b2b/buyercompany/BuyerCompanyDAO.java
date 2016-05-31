
package com.terapico.b2b.buyercompany;

import java.util.List;
import java.util.Set;
public interface BuyerCompanyDAO{

	
	public BuyerCompany load(String buyerCompanyId,Set<String> options) throws Exception;
	public BuyerCompany clone(String buyerCompanyId,Set<String> options) throws Exception;
	
	public BuyerCompany save(BuyerCompany buyerCompany,Set<String> options);
	public List<BuyerCompany> saveList(List<BuyerCompany> buyerCompanyList,Set<String> options);
	
	public void delete(String buyerCompanyId, int version) throws Exception;
}


