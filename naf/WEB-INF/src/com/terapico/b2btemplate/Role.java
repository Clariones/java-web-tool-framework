
package com.terapico.b2btemplate;
import java.util.ArrayList;
import java.util.List;

import java.sql.Date;
import org.xml.sax.Attributes;
public class Role implements  java.io.Serializable{

	protected		String	mId;
	protected		String	mRoleName;
	protected		int	mxVersion;
	
	
	protected		List<Csr> mCsrList;
	protected		List<Access> mAccessList;
	
		
	public 	Role(){

	}
	
	public 	Role(String	id,String	role_name,int	version)
	{
		setId(id);
		setRoleName(role_name);
		setVersion(version);
		this.mCsrList = new ArrayList<Csr>();
		this.mAccessList = new ArrayList<Access>();	
	}
	

	
	public void setId(String id){
		this.mId = id;
	}
	public String getId(){
		return this.mId;
	}
	
	public void setRoleName(String role_name){
		this.mRoleName = role_name;
	}
	public String getRoleName(){
		return this.mRoleName;
	}
	
	public void setVersion(int version){
		this.mxVersion = version;
	}
	public int getVersion(){
		return this.mxVersion;
	}
	
	public  List<Csr> getCsrList(){
		if(this.mCsrList == null){
			this.mCsrList = new ArrayList<Csr>();
		}
		return this.mCsrList;	
	}
	public  void setCsrList(List<Csr> Csrs){
		this.mCsrList=Csrs;
		
	}
	
	public  void addCsr(Csr csr){
		getCsrList().add(csr);
	}
	public  void addCsrs(List<Csr> csrs){
		getCsrList().addAll(csrs);
	}
	
	public  void removeCsr(Csr csr){
		getCsrList().remove(csr);
	}
	
	
	
	
	
	public  List<Access> getAccessList(){
		if(this.mAccessList == null){
			this.mAccessList = new ArrayList<Access>();
		}
		return this.mAccessList;	
	}
	public  void setAccessList(List<Access> Accesses){
		this.mAccessList=Accesses;
		
	}
	
	public  void addAccess(Access access){
		getAccessList().add(access);
	}
	public  void addAccesses(List<Access> accesss){
		getAccessList().addAll(accesss);
	}
	
	public  void removeAccess(Access access){
		getAccessList().remove(access);
	}
	
	
	
	
	
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("role{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\trole_name='"+getRoleName()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}

