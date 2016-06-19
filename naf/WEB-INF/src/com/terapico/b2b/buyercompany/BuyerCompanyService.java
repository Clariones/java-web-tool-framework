
package com.terapico.b2b.buyercompany;

import java.util.List;
import java.util.Set;
public interface BuyerCompanyService{

	
	public BuyerCompany createBuyerCompany(String buyerCompanyId,String[] options) throws Exception;
	public BuyerCompany clone(String buyerCompanyId, String[] options) throws Exception;
	
	public BuyerCompany save(BuyerCompany buyerCompany,String[] options);
	public List<BuyerCompany> saveList(List<BuyerCompany> buyerCompanyList,String[] options);
	
	public void delete(String buyerCompanyId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


