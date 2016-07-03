
package com.terapico.b2b.approval;

import java.util.Date;
public class ApprovalManagerMock implements ApprovalManager {

	public Approval createApproval(String who, Date approveTime, String[] options) throws Exception
	{
		return new Approval();
	}
	public Approval updateApproval(String approvalId, String property, Object newValue) throws Exception 
	{
		return new Approval();
	}
	


	public void delete(String approvalId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}
	public  Approval addOrder(String approvalId, String buyerId, String sellerId, String title, String costCenterId, String profitCenterId, double totalAmount, String type, boolean markAsDelete, String recurringInfoId, String status)
	{
		return new Approval();
	}
	public  Approval removeOrder(String approvalId, String orderId){
		return new Approval();
	}
	public  Approval updateOrder(String approvalId, String orderId, String property, Object newValue){
		return new Approval();
	}




}


