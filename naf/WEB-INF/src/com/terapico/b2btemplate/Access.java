
package com.terapico.b2btemplate;
import java.util.ArrayList;
import java.util.List;

import java.sql.Date;
import org.xml.sax.Attributes;
public class Access implements  java.io.Serializable{

	protected		String	mId;
	protected		Role	mRoleName;
	protected		int	mxVersion;
	
	
	protected		List<Assignment> mAssignmentList;
	
		
	public 	Access(){

	}
	
	public 	Access(String	id,Role	role_name,int	version)
	{
		setId(id);
		setRoleName(role_name);
		setVersion(version);
		this.mAssignmentList = new ArrayList<Assignment>();	
	}
	

	
	public void setId(String id){
		this.mId = id;
	}
	public String getId(){
		return this.mId;
	}
	
	public void setRoleName(Role role_name){
		this.mRoleName = role_name;
	}
	public Role getRoleName(){
		return this.mRoleName;
	}
	
	public void setVersion(int version){
		this.mxVersion = version;
	}
	public int getVersion(){
		return this.mxVersion;
	}
	
	public  List<Assignment> getAssignmentList(){
		if(this.mAssignmentList == null){
			this.mAssignmentList = new ArrayList<Assignment>();
		}
		return this.mAssignmentList;	
	}
	public  void setAssignmentList(List<Assignment> Assignments){
		this.mAssignmentList=Assignments;
		
	}
	
	public  void addAssignment(Assignment assignment){
		getAssignmentList().add(assignment);
	}
	public  void addAssignments(List<Assignment> assignments){
		getAssignmentList().addAll(assignments);
	}
	
	public  void removeAssignment(Assignment assignment){
		getAssignmentList().remove(assignment);
	}
	
	
	
	
	
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("access{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\trole_name='role("+getRoleName().getId()+")';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}
