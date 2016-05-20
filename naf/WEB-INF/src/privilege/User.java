package privilege;

import java.util.Collection;
import java.util.LinkedList;



public class User implements  java.io.Serializable{

	protected		String	mId;
	protected		String	mUsername;
	protected		String	mPassword;
	protected		UserGroup	mUserGroup;
	protected		int	mxVersion;
	protected		Collection mAssignmentList;
	
		
	public 	User(){

	}
	
	public 	User(String	id,String	username,String	password,UserGroup	user_group,int	version)
	{
		setId(id);
		setUsername(username);
		setPassword(password);
		setUserGroup(user_group);
		setVersion(version);
		this.mAssignmentList = new LinkedList();	
	}
	

	
	public void setId(String id){
		this.mId = id;
	}
	public String getId(){
		return this.mId;
	}
	
	public void setUsername(String username){
		this.mUsername = username;
	}
	public String getUsername(){
		return this.mUsername;
	}
	
	public void setPassword(String password){
		this.mPassword = password;
	}
	public String getPassword(){
		return this.mPassword;
	}
	
	public void setUserGroup(UserGroup user_group){
		this.mUserGroup = user_group;
	}
	public UserGroup getUserGroup(){
		return this.mUserGroup;
	}
	
	public void setVersion(int version){
		this.mxVersion = version;
	}
	public int getVersion(){
		return this.mxVersion;
	}
	
	
	
	
	
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("user{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tusername='"+getUsername()+"';");
		stringBuilder.append("\tpassword='"+getPassword()+"';");
		stringBuilder.append("\tuser_group='user_group("+getUserGroup().getId()+")';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}

