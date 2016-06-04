
package com.lanecrawford.cms.columnmeta;
import java.util.ArrayList;
import java.util.List;

import java.sql.Date;
import org.xml.sax.Attributes;


import com.lanecrawford.cms.actiontablemeta.ActionTableMeta;


public class ColumnMeta implements  java.io.Serializable{

	protected		String	mId;
	protected		String	mSourceColumn;
	protected		String	mDestColumn;
	protected		ActionTableMeta	mActionTable;
	protected		String	mType;
	protected		int	mxLength;
	protected		int	mxVersion;
	
	
	
		
	public 	ColumnMeta(){

	}
	
	public 	ColumnMeta(String	id,String	source_column,String	dest_column,ActionTableMeta	action_table,String	type,int	length,int	version)
	{
		setId(id);
		setSourceColumn(source_column);
		setDestColumn(dest_column);
		setActionTable(action_table);
		setType(type);
		setLength(length);
		setVersion(version);	
	}
	

	
	public void setId(String id){
		this.mId = id;
	}
	public String getId(){
		return this.mId;
	}
	
	public void setSourceColumn(String source_column){
		this.mSourceColumn = source_column;
	}
	public String getSourceColumn(){
		return this.mSourceColumn;
	}
	
	public void setDestColumn(String dest_column){
		this.mDestColumn = dest_column;
	}
	public String getDestColumn(){
		return this.mDestColumn;
	}
	
	public void setActionTable(ActionTableMeta action_table){
		this.mActionTable = action_table;
	}
	public ActionTableMeta getActionTable(){
		return this.mActionTable;
	}
	
	public void setType(String type){
		this.mType = type;
	}
	public String getType(){
		return this.mType;
	}
	
	public void setLength(int length){
		this.mxLength = length;
	}
	public int getLength(){
		return this.mxLength;
	}
	
	public void setVersion(int version){
		this.mxVersion = version;
	}
	public int getVersion(){
		return this.mxVersion;
	}
	
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("column_meta{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tsource_column='"+getSourceColumn()+"';");
		stringBuilder.append("\tdest_column='"+getDestColumn()+"';");
		stringBuilder.append("\taction_table='action_table_meta("+getActionTable().getId()+")';");
		stringBuilder.append("\ttype='"+getType()+"';");
		stringBuilder.append("\tlength='"+getLength()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}





