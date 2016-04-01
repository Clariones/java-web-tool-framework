package privilege;

public class User implements  java.io.Serializable{

	protected		long	mId;
	protected		String	mUsername;
	protected		String	mPassword;

	public 	User(){
			
	}
	

	

	
	public void setId(long id){
		this.mId = id;
	}
	public long getId(){
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
	

	
	
	
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("user{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tusername='"+getUsername()+"';");
		stringBuilder.append("\tpassword='"+getPassword()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}
