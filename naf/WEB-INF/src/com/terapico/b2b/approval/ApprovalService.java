
package com.terapico.b2b.approval;

import java.util.List;
import java.util.Set;
public interface ApprovalService{

	
	public Approval createApproval(String approvalId,String[] options) throws Exception;
	public Approval clone(String approvalId, String[] options) throws Exception;
	
	public Approval save(Approval approval,String[] options);
	public List<Approval> saveList(List<Approval> approvalList,String[] options);
	
	public void delete(String approvalId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


