
package com.terapico.b2b.processing;

import java.util.List;
import java.util.Set;
import java.util.Map;
public interface ProcessingDAO{

	
	public Processing load(String processingId,Map<String,Object> options) throws Exception;
	public Processing clone(String processingId,Map<String,Object> options) throws Exception;
	
	public Processing save(Processing processing,Map<String,Object> options);
	public List<Processing> saveList(List<Processing> processingList,Map<String,Object> options);
	
	public void delete(String processingId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


