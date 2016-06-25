
package com.terapico.b2b.approval;

import java.util.Date;
public interface ApprovalManager{

	public Approval createApproval(String who, Date approveTime, String[] options) throws Exception;	
	public Approval updateApproval(String approvalId, String property, Object newValue)  throws Exception;
	


	public void delete(String approvalId, int version) throws Exception;
	public int deleteAll() throws Exception;
	public  Approval addOrder(String approvalId, String buyerId, String sellerId, String title, double totalAmount, String type, boolean markAsDelete)  throws Exception;
	public  Approval removeOrder(String approvalId, String orderId)  throws Exception;
	public  Approval updateOrder(String approvalId, String orderId, String property, Object newValue)  throws Exception;




}


