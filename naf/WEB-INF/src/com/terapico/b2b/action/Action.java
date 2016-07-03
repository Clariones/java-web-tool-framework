
package com.terapico.b2b.action;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.b2b.order.Order;

@JsonSerialize(using = ActionSerializer.class)
public class Action implements  java.io.Serializable{

	protected		String	mId;
	protected		String	mName;
	protected		String	mInternalName;
	protected		Order	mBo;
	protected		int	mVersion;
	
	
	
		
	public 	Action(){
		//lazy load for all the properties
	}
	
	public 	Action(String name, String internalName, Order bo)
	{
		setName(name);
		setInternalName(internalName);
		setBo(bo);	
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
	
	public void setInternalName(String internalName){
		this.mInternalName = internalName;
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





