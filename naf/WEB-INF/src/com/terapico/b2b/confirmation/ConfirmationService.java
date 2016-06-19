
package com.terapico.b2b.confirmation;

import java.util.List;
import java.util.Set;
public interface ConfirmationService{

	
	public Confirmation createConfirmation(String confirmationId,String[] options) throws Exception;
	public Confirmation clone(String confirmationId, String[] options) throws Exception;
	
	public Confirmation save(Confirmation confirmation,String[] options);
	public List<Confirmation> saveList(List<Confirmation> confirmationList,String[] options);
	
	public void delete(String confirmationId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


