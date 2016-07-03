
package com.terapico.b2b.creditaccount;

import java.util.Date;
public interface CreditAccountManager{

	public CreditAccount createCreditAccount(String name, String buyerId, String sellerId, double authorized, double remain, String[] options) throws Exception;	
	public CreditAccount updateCreditAccount(String creditAccountId, String property, Object newValue)  throws Exception;
	
	public CreditAccount transferToNewBuyer(String creditAccountId, String newBuyerId)  throws Exception;
 	public CreditAccount transferToNewSeller(String creditAccountId, String newSellerId)  throws Exception;
 

	public void delete(String creditAccountId, int version) throws Exception;
	public int deleteAll() throws Exception;



}


