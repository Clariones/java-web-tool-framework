
package com.terapico.b2b.recurringinfo;

import java.util.List;
import java.util.Set;
import java.util.Map;
public interface RecurringInfoDAO{

	
	public RecurringInfo load(String recurringInfoId,Map<String,Object> options) throws Exception;
	public RecurringInfo clone(String recurringInfoId,Map<String,Object> options) throws Exception;
	
	public RecurringInfo save(RecurringInfo recurringInfo,Map<String,Object> options);
	public List<RecurringInfo> saveList(List<RecurringInfo> recurringInfoList,Map<String,Object> options);
	
	public void delete(String recurringInfoId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


