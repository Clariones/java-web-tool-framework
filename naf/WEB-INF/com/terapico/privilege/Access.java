
package com.terapico.privilege;
import java.util.Vector;
import java.util.LinkedList;
import java.util.Collection;
import java.util.Map;
import java.util.Hashtable;
import java.sql.Date;
import org.xml.sax.Attributes;
public class Access implements  java.io.Serializable{

	protected		String	mId;
	protected		String	mAccessName;
	protected		String	mDescription;
	protected		int	mxVersion;
	protected		Collection mAssignmentList;
	
		
	public 	Access(){

	}
	
	public 	Access(String	id,String	access_name,String	description,int	version)
	{
		setId(id);
		setAccessName(access_name);
		setDescription(description);
		setVersion(version);
		this.mAssignmentList = new LinkedList();	
	}
	

	
	public void setId(String id){
		this.mId = id;
	}
	public String getId(){
		return this.mId;
	}
	
	public void setAccessName(String access_name){
		this.mAccessName = access_name;
	}
	public String getAccessName(){
		return this.mAccessName;
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
	
	public  Collection getAssignmentList(){
		return this.mAssignmentList;	
	}
	public  void addAssignment(Assignment assignment){
		getAssignmentList().add(assignment);
	}
	public  void addAssignments(Collection assignments){
		getAssignmentList().addAll(assignments);
	}
	
	public  void removeAssignment(Assignment assignment){
		getAssignmentList().remove(assignment);
	}
	
	
	
	
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("access{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\taccess_name='"+getAccessName()+"';");
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}

