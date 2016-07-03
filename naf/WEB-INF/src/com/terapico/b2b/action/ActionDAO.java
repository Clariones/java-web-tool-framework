
package com.terapico.b2b.action;

import java.util.List;
import java.util.Set;
import java.util.Map;
public interface ActionDAO{

	
	public Action load(String actionId,Map<String,Object> options) throws Exception;
	public Action clone(String actionId,Map<String,Object> options) throws Exception;
	
	public Action save(Action action,Map<String,Object> options);
	public List<Action> saveList(List<Action> actionList,Map<String,Object> options);
	
	public void delete(String actionId, int version) throws Exception;
	public int deleteAll() throws Exception;
 	public List<Action> findActionByBo(String orderId);
 }






