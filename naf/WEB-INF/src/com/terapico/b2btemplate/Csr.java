
package com.terapico.b2btemplate;
import java.util.ArrayList;
import java.util.List;

import java.sql.Date;
import org.xml.sax.Attributes;
public class Csr implements  java.io.Serializable{

	protected		String	mId;
	protected		String	mEmail;
	protected		Role	mRole;
	protected		SellerCompany	mCompany;
	protected		int	mxVersion;
	
	
	
		
	public 	Csr(){

	}
	
	public 	Csr(String	id,String	email,Role	role,SellerCompany	company,int	version)
	{
		setId(id);
		setEmail(email);
		setRole(role);
		setCompany(company);
		setVersion(version);	
	}
	

	
	public void setId(String id){
		this.mId = id;
	}
	public String getId(){
		return this.mId;
	}
	
	public void setEmail(String email){
		this.mEmail = email;
	}
	public String getEmail(){
		return this.mEmail;
	}
	
	public void setRole(Role role){
		this.mRole = role;
	}
	public Role getRole(){
		return this.mRole;
	}
	
	public void setCompany(SellerCompany company){
		this.mCompany = company;
	}
	public SellerCompany getCompany(){
		return this.mCompany;
	}
	
	public void setVersion(int version){
		this.mxVersion = version;
	}
	public int getVersion(){
		return this.mxVersion;
	}
	
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("csr{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\temail='"+getEmail()+"';");
		stringBuilder.append("\trole='role("+getRole().getId()+")';");
		stringBuilder.append("\tcompany='seller_company("+getCompany().getId()+")';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}













