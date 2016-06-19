
package com.terapico.b2b.processing;

import java.util.List;
import java.util.Set;
public interface ProcessingService{

	
	public Processing createProcessing(String processingId,String[] options) throws Exception;
	public Processing clone(String processingId, String[] options) throws Exception;
	
	public Processing save(Processing processing,String[] options);
	public List<Processing> saveList(List<Processing> processingList,String[] options);
	
	public void delete(String processingId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


