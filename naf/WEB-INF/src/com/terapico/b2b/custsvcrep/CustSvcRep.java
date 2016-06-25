
package com.terapico.b2b.custsvcrep;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;



import com.terapico.b2b.role.Role;
import com.terapico.b2b.sellercompany.SellerCompany;


public class CustSvcRep implements  java.io.Serializable{

	protected		String	mId;
	protected		String	mEmail;
	protected		Role	mRole;
	protected		SellerCompany	mCompany;
	protected		int	mVersion;
	
	
	
		
	public 	CustSvcRep(){
		//lazy load for all the properties
	}
	
	public 	CustSvcRep(String email, Role role, SellerCompany company)
	{
		setEmail(email);
		setRole(role);
		setCompany(company);	
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
		this.mVersion = version;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("cust_svc_rep{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\temail='"+getEmail()+"';");
		stringBuilder.append("\trole='role("+getRole().getId()+")';");
		stringBuilder.append("\tcompany='seller_company("+getCompany().getId()+")';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}

