
package com.terapico.privilege;
import java.util.Vector;
import java.util.LinkedList;
import java.util.Collection;
import java.util.Map;
import java.util.Hashtable;
import java.sql.Date;
import org.xml.sax.Attributes;
public class UserGroup implements  java.io.Serializable{

	protected		String	mId;
	protected		String	mUserGroupName;
	protected		int	mxVersion;
	protected		Collection mUserList;
	
		
	public 	UserGroup(){

	}
	
	public 	UserGroup(String	id,String	user_group_name,int	version)
	{
		setId(id);
		setUserGroupName(user_group_name);
		setVersion(version);
		this.mUserList = new LinkedList();	
	}
	

	
	public void setId(String id){
		this.mId = id;
	}
	public String getId(){
		return this.mId;
	}
	
	public void setUserGroupName(String user_group_name){
		this.mUserGroupName = user_group_name;
	}
	public String getUserGroupName(){
		return this.mUserGroupName;
	}
	
	public void setVersion(int version){
		this.mxVersion = version;
	}
	public int getVersion(){
		return this.mxVersion;
	}
	
	public  Collection getUserList(){
		return this.mUserList;	
	}
	public  void addUser(User user){
		getUserList().add(user);
	}
	public  void addUsers(Collection users){
		getUserList().addAll(users);
	}
	
	public  void removeUser(User user){
		getUserList().remove(user);
	}
	
	
	
	
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("user_group{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tuser_group_name='"+getUserGroupName()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}









