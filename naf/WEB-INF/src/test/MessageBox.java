package test;

public class MessageBox {
	private String message;
	
	public MessageBox()
	{
		
	}
	public MessageBox(String message)
	{
		setMessage(message); 
		
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
