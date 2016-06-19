
package com.terapico.b2b.action;

import java.util.List;
import java.util.Set;
public interface ActionService{

	
	public Action createAction(String actionId,String[] options) throws Exception;
	public Action clone(String actionId, String[] options) throws Exception;
	
	public Action save(Action action,String[] options);
	public List<Action> saveList(List<Action> actionList,String[] options);
	
	public void delete(String actionId, int version) throws Exception;
	public int deleteAll() throws Exception;
 	public List<Action> findActionByBo(String orderId);
 }






