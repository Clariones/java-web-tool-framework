
package com.lanecrawford.cms.columnmeta;

import java.util.List;
import java.util.Set;
public interface ColumnMetaDAO{

	
	public ColumnMeta load(String columnMetaId,Set<String> options) throws Exception;
	public ColumnMeta clone(String columnMetaId,Set<String> options) throws Exception;
	
	public ColumnMeta save(ColumnMeta columnMeta,Set<String> options);
	public List<ColumnMeta> saveList(List<ColumnMeta> columnMetaList,Set<String> options);
	
	public void delete(String columnMetaId, int version) throws Exception;
 	public List<ColumnMeta> findColumnMetaByActionTable(String actionTableMetaId);
 }











