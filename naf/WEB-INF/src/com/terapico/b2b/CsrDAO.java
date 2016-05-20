
package com.terapico.b2b;

import java.util.List;

public interface CsrDAO{

	
	public Csr load(String csrId) throws CsrNotFoundException;
	public Csr save(Csr csr);
	public void delete(String csrId) throws CsrNotFoundException;
 	public List<Csr> findCsrByRole(String roleId);
  	public List<Csr> findCsrByCompany(String sellerCompanyId);
 }










