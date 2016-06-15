
package com.terapico.b2b.approval;

import java.util.List;
import java.util.Set;
import java.util.Map;
public interface ApprovalDAO{

	
	public Approval load(String approvalId,Map<String,Object> options) throws Exception;
	public Approval clone(String approvalId,Map<String,Object> options) throws Exception;
	
	public Approval save(Approval approval,Map<String,Object> options);
	public List<Approval> saveList(List<Approval> approvalList,Map<String,Object> options);
	
	public void delete(String approvalId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


