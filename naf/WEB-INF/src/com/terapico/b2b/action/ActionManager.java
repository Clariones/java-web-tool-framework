
package com.terapico.b2b.action;

import java.util.Date;
public interface ActionManager{

	public Action createAction(String name, String internalName, String boId, String[] options) throws Exception;	
	public Action updateAction(String actionId, String property, Object newValue)  throws Exception;
	
	public Action transferToNewBo(String actionId, String newBoId)  throws Exception;
 

	public void delete(String actionId, int version) throws Exception;
	public int deleteAll() throws Exception;



}






