
package com.terapico.b2b.buyercompany;

import java.util.List;
import java.util.Set;
import java.util.Map;
public interface BuyerCompanyDAO{

	
	public BuyerCompany load(String buyerCompanyId,Map<String,Object> options) throws Exception;
	public BuyerCompany clone(String buyerCompanyId,Map<String,Object> options) throws Exception;
	
	public BuyerCompany save(BuyerCompany buyerCompany,Map<String,Object> options);
	public List<BuyerCompany> saveList(List<BuyerCompany> buyerCompanyList,Map<String,Object> options);
	
	public void delete(String buyerCompanyId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


