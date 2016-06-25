
package com.terapico.b2b.action;

import java.util.Date;
public class ActionManagerMock implements ActionManager {

	public Action createAction(String name, String internalName, String boId, String[] options) throws Exception
	{
		return new Action();
	}
	public Action updateAction(String actionId, String property, Object newValue) throws Exception 
	{
		return new Action();
	}
	
	public Action transferToNewBo(String actionId, String newBoId) throws Exception
 	{
 		return new Action();
 
 	}
 

	public void delete(String actionId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}



}







