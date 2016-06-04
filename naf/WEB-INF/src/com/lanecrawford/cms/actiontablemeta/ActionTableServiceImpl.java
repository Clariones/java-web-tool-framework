package com.lanecrawford.cms.actiontablemeta;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.lanecrawford.cms.columnmeta.ColumnMeta;

public class ActionTableServiceImpl  {
	
	private ActionTableMetaDAO actionTableMetaDAO;
	public ActionTableMetaDAO getActionTableMetaDAO() {
		return actionTableMetaDAO;
	}
	public void setActionTableMetaDAO(
			ActionTableMetaDAO actionTableMetaServiceDAO) {
		this.actionTableMetaDAO = actionTableMetaServiceDAO;
	}
	public String generateSQL(String tableId) throws Exception
	{
		Set<String> options=new HashSet<String>();
		options.addAll(Arrays.asList(new String[]{"__all__"}));
		ActionTableMeta tmeta=actionTableMetaDAO.load(tableId, options);
		
		List<ColumnMeta> colMetaList=tmeta.getColumnMetaList();
		StringBuilder stringBuilder=new StringBuilder();
		for(ColumnMeta colMeta:colMetaList){
			
			stringBuilder.append(colMeta.getSourceColumn()+", ");
			
		}
		return stringBuilder.toString();

		
	}
	protected String generatePlaceHolder(List<ColumnMeta> colMetaList){
		
		int size=colMetaList.size();
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append("(");
		for(int i=0;i<size;i++){
			if(i>0){
				stringBuilder.append(",");
			}
			stringBuilder.append("?");

		}
		stringBuilder.append(")");
		return stringBuilder.toString();
		
	}
	
	
}
