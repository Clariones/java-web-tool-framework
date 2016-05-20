
package com.terapico.b2b;

import java.util.List;

public interface BuyerCompanyDAO{

	
	public BuyerCompany load(String buyerCompanyId) throws BuyerCompanyNotFoundException;
	public BuyerCompany save(BuyerCompany buyerCompany);
	public void delete(String buyerCompanyId) throws BuyerCompanyNotFoundException;
}


