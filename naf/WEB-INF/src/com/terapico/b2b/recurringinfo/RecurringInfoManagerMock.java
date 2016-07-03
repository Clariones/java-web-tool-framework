
package com.terapico.b2b.recurringinfo;

import java.util.Date;
public class RecurringInfoManagerMock implements RecurringInfoManager {

	public RecurringInfo createRecurringInfo(String name, Date nextTime, String cronExpr, String[] options) throws Exception
	{
		return new RecurringInfo();
	}
	public RecurringInfo updateRecurringInfo(String recurringInfoId, String property, Object newValue) throws Exception 
	{
		return new RecurringInfo();
	}
	


	public void delete(String recurringInfoId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}
	public  RecurringInfo addOrder(String recurringInfoId, String buyerId, String sellerId, String title, String costCenterId, String profitCenterId, double totalAmount, String type, boolean markAsDelete, String status)
	{
		return new RecurringInfo();
	}
	public  RecurringInfo removeOrder(String recurringInfoId, String orderId){
		return new RecurringInfo();
	}
	public  RecurringInfo updateOrder(String recurringInfoId, String orderId, String property, Object newValue){
		return new RecurringInfo();
	}




}


