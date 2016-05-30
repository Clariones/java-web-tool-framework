
package com.terapico.b2b.access;
import java.util.ArrayList;
import java.util.List;

import java.sql.Date;
import org.xml.sax.Attributes;


import com.terapico.b2b.role.Role;
import com.terapico.b2b.assignment.Assignment;


public class Access implements  java.io.Serializable{

	protected		String	mId;
	protected		Role	mRole;
	protected		int	mxVersion;
	
	
	protected		List<Assignment> mAssignmentList;
	
		
	public 	Access(){

	}
	
	public 	Access(String	id,Role	role,int	version)
	{
		setId(id);
		setRole(role);
		setVersion(version);
		this.mAssignmentList = new ArrayList<Assignment>();	
	}
	

	
	public void setId(String id){
		this.mId = id;
	}
	public String getId(){
		return this.mId;
	}
	
	public void setRole(Role role){
		this.mRole = role;
	}
	public Role getRole(){
		return this.mRole;
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
	public  void setAssignmentList(List<Assignment> assignmentList){
		for( Assignment assignment:assignmentList){
			assignment.setAccess(this);
		}
		
		
		this.mAssignmentList = assignmentList;
		
	}
	
	public  void addAssignment(Assignment assignment){
		assignment.setAccess(this);
		getAssignmentList().add(assignment);
	}
	public  void addAssignments(List<Assignment> assignmentList){
		for( Assignment assignment:assignmentList){
			assignment.setAccess(this);
		}
		getAssignmentList().addAll(assignmentList);
	}
	
	public  void removeAssignment(Assignment assignment){
		getAssignmentList().remove(assignment);
	}
	
	
	
	
	
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("access{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\trole='role("+getRole().getId()+")';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}

