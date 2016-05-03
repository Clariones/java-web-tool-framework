package privilege;

public class User implements  java.io.Serializable{

	private static final long serialVersionUID = 1L;
	protected		String	mId;
	protected		String	mUsername;
	protected		String	mPassword;

	public 	User(){
			
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
