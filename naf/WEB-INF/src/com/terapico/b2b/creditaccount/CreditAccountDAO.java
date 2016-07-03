
package com.terapico.b2b.creditaccount;

import java.util.List;
import java.util.Set;
import java.util.Map;
public interface CreditAccountDAO{

	
	public CreditAccount load(String creditAccountId,Map<String,Object> options) throws Exception;
	public CreditAccount clone(String creditAccountId,Map<String,Object> options) throws Exception;
	
	public CreditAccount save(CreditAccount creditAccount,Map<String,Object> options);
	public List<CreditAccount> saveList(List<CreditAccount> creditAccountList,Map<String,Object> options);
	
	public void delete(String creditAccountId, int version) throws Exception;
	public int deleteAll() throws Exception;
 	public List<CreditAccount> findCreditAccountByBuyer(String buyerCompanyId);
  	public List<CreditAccount> findCreditAccountBySeller(String sellerCompanyId);
 }


