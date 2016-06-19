
package com.terapico.b2b.action;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;



import com.terapico.b2b.order.Order;


public class Action implements  java.io.Serializable{

	protected		String	mId;
	protected		String	mName;
	protected		String	mInternalName;
	protected		Order	mBo;
	protected		int	mVersion;
	
	
	
		
	public 	Action(){

	}
	
	public 	Action(String	id,String	name,String	internal_name,Order	bo,int	version)
	{
		setId(id);
		setName(name);
		setInternalName(internal_name);
		setBo(bo);
		setVersion(version);	
	}
	

	
	public void setId(String id){
		this.mId = id;
	}
	public String getId(){
		return this.mId;
	}
	
	public void setName(String name){
		this.mName = name;
	}
	public String getName(){
		return this.mName;
	}
	
	public void setInternalName(String internal_name){
		this.mInternalName = internal_name;
	}
	public String getInternalName(){
		return this.mInternalName;
	}
	
	public void setBo(Order bo){
		this.mBo = bo;
	}
	public Order getBo(){
		return this.mBo;
	}
	
	public void setVersion(int version){
		this.mVersion = version;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("action{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tinternal_name='"+getInternalName()+"';");
		stringBuilder.append("\tbo='order("+getBo().getId()+")';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}





