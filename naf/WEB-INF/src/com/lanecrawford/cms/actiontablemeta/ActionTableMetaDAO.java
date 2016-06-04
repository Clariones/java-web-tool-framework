
package com.lanecrawford.cms.actiontablemeta;

import java.util.List;
import java.util.Set;
public interface ActionTableMetaDAO{

	
	public ActionTableMeta load(String actionTableMetaId,Set<String> options) throws Exception;
	public ActionTableMeta clone(String actionTableMetaId,Set<String> options) throws Exception;
	
	public ActionTableMeta save(ActionTableMeta actionTableMeta,Set<String> options);
	public List<ActionTableMeta> saveList(List<ActionTableMeta> actionTableMetaList,Set<String> options);
	
	public void delete(String actionTableMetaId, int version) throws Exception;
}


