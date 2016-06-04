
package com.lanecrawford.cms.actiontablemeta;
import java.util.ArrayList;
import java.util.List;



import com.lanecrawford.cms.columnmeta.ColumnMeta;


public class ActionTableMeta implements  java.io.Serializable{

	protected		String	mId;
	protected		String	mTableName;
	protected		boolean	mEnabled;
	protected		int	mxBatchsize;
	protected		String	mDescription;
	protected		int	mxVersion;
	
	
	protected		List<ColumnMeta> mColumnMetaList;
	
		
	public 	ActionTableMeta(){

	}
	
	public 	ActionTableMeta(String	id,String	table_name,boolean	enabled,int	batchsize,String	description,int	version)
	{
		setId(id);
		setTableName(table_name);
		setEnabled(enabled);
		setBatchsize(batchsize);
		setDescription(description);
		setVersion(version);
		this.mColumnMetaList = new ArrayList<ColumnMeta>();	
	}
	

	
	public void setId(String id){
		this.mId = id;
	}
	public String getId(){
		return this.mId;
	}
	
	public void setTableName(String table_name){
		this.mTableName = table_name;
	}
	public String getTableName(){
		return this.mTableName;
	}
	
	public void setEnabled(boolean enabled){
		this.mEnabled = enabled;
	}
	public boolean getEnabled(){
		return this.mEnabled;
	}
	
	public void setBatchsize(int batchsize){
		this.mxBatchsize = batchsize;
	}
	public int getBatchsize(){
		return this.mxBatchsize;
	}
	
	public void setDescription(String description){
		this.mDescription = description;
	}
	public String getDescription(){
		return this.mDescription;
	}
	
	public void setVersion(int version){
		this.mxVersion = version;
	}
	public int getVersion(){
		return this.mxVersion;
	}
	
	public  List<ColumnMeta> getColumnMetaList(){
		if(this.mColumnMetaList == null){
			this.mColumnMetaList = new ArrayList<ColumnMeta>();
		}
		return this.mColumnMetaList;	
	}
	public  void setColumnMetaList(List<ColumnMeta> columnMetaList){
		for( ColumnMeta columnMeta:columnMetaList){
			columnMeta.setActionTable(this);
		}
		
		
		this.mColumnMetaList = columnMetaList;
		
	}
	
	public  void addColumnMeta(ColumnMeta column_meta){
		column_meta.setActionTable(this);
		getColumnMetaList().add(column_meta);
	}
	public  void addColumnMetaes(List<ColumnMeta> columnMetaList){
		for( ColumnMeta columnMeta:columnMetaList){
			columnMeta.setActionTable(this);
		}
		getColumnMetaList().addAll(columnMetaList);
	}
	
	public  void removeColumnMeta(ColumnMeta column_meta){
		getColumnMetaList().remove(column_meta);
	}
	
	
	
	
	
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("action_table_meta{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\ttable_name='"+getTableName()+"';");
		stringBuilder.append("\tenabled='"+getEnabled()+"';");
		stringBuilder.append("\tbatchsize='"+getBatchsize()+"';");
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}

