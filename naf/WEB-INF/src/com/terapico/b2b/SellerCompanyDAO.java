
package com.terapico.b2b;

import java.util.List;

public interface SellerCompanyDAO{

	
	public SellerCompany load(String sellerCompanyId) throws SellerCompanyNotFoundException;
	public SellerCompany save(SellerCompany sellerCompany);
	public void delete(String sellerCompanyId) throws SellerCompanyNotFoundException;
}


