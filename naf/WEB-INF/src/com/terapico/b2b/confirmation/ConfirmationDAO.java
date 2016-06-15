
package com.terapico.b2b.confirmation;

import java.util.List;
import java.util.Set;
import java.util.Map;
public interface ConfirmationDAO{

	
	public Confirmation load(String confirmationId,Map<String,Object> options) throws Exception;
	public Confirmation clone(String confirmationId,Map<String,Object> options) throws Exception;
	
	public Confirmation save(Confirmation confirmation,Map<String,Object> options);
	public List<Confirmation> saveList(List<Confirmation> confirmationList,Map<String,Object> options);
	
	public void delete(String confirmationId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


