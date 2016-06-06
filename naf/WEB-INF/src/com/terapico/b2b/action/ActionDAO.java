
package com.terapico.b2b.action;

import java.util.List;
import java.util.Set;
public interface ActionDAO{

	
	public Action load(String actionId,Set<String> options) throws Exception;
	public Action clone(String actionId,Set<String> options) throws Exception;
	
	public Action save(Action action,Set<String> options);
	public List<Action> saveList(List<Action> actionList,Set<String> options);
	
	public void delete(String actionId, int version) throws Exception;
	public int deleteAll() throws Exception;
 	public List<Action> findActionByBo(String orderId);
 }











