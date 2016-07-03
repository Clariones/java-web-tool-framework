
package com.terapico.b2b.creditaccount;

import java.util.Date;
public class CreditAccountManagerMock implements CreditAccountManager {

	public CreditAccount createCreditAccount(String name, String buyerId, String sellerId, double authorized, double remain, String[] options) throws Exception
	{
		return new CreditAccount();
	}
	public CreditAccount updateCreditAccount(String creditAccountId, String property, Object newValue) throws Exception 
	{
		return new CreditAccount();
	}
	
	public CreditAccount transferToNewBuyer(String creditAccountId, String newBuyerId) throws Exception
 	{
 		return new CreditAccount();
 
 	}
 	public CreditAccount transferToNewSeller(String creditAccountId, String newSellerId) throws Exception
 	{
 		return new CreditAccount();
 
 	}
 

	public void delete(String creditAccountId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}



}


