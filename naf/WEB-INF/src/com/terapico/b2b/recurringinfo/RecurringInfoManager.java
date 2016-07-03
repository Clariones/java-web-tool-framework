
package com.terapico.b2b.recurringinfo;

import java.util.Date;
public interface RecurringInfoManager{

	public RecurringInfo createRecurringInfo(String name, Date nextTime, String cronExpr, String[] options) throws Exception;	
	public RecurringInfo updateRecurringInfo(String recurringInfoId, String property, Object newValue)  throws Exception;
	


	public void delete(String recurringInfoId, int version) throws Exception;
	public int deleteAll() throws Exception;
	public  RecurringInfo addOrder(String recurringInfoId, String buyerId, String sellerId, String title, String costCenterId, String profitCenterId, double totalAmount, String type, boolean markAsDelete, String status)  throws Exception;
	public  RecurringInfo removeOrder(String recurringInfoId, String orderId)  throws Exception;
	public  RecurringInfo updateOrder(String recurringInfoId, String orderId, String property, Object newValue)  throws Exception;




}


