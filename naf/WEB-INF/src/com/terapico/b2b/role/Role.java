
package com.terapico.b2b.role;
import java.util.ArrayList;
import java.util.List;

import java.sql.Date;
import org.xml.sax.Attributes;


import com.terapico.b2b.access.Access;
import com.terapico.b2b.custsvcrep.CustSvcRep;


public class Role implements  java.io.Serializable{

	protected		String	mId;
	protected		String	mRoleName;
	protected		int	mxVersion;
	
	
	protected		List<Access> mAccessList;
	protected		List<CustSvcRep> mCustSvcRepList;
	
		
	public 	Role(){

	}
	
	public 	Role(String	id,String	role_name,int	version)
	{
		setId(id);
		setRoleName(role_name);
		setVersion(version);
		this.mAccessList = new ArrayList<Access>();
		this.mCustSvcRepList = new ArrayList<CustSvcRep>();	
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
	
	public  List<Access> getAccessList(){
		if(this.mAccessList == null){
			this.mAccessList = new ArrayList<Access>();
		}
		return this.mAccessList;	
	}
	public  void setAccessList(List<Access> accessList){
		for( Access access:accessList){
			access.setRole(this);
		}
		
		
		this.mAccessList = accessList;
		
	}
	
	public  void addAccess(Access access){
		access.setRole(this);
		getAccessList().add(access);
	}
	public  void addAccesses(List<Access> accessList){
		for( Access access:accessList){
			access.setRole(this);
		}
		getAccessList().addAll(accessList);
	}
	
	public  void removeAccess(Access access){
		getAccessList().remove(access);
	}
	
	
	
	
	
	public  List<CustSvcRep> getCustSvcRepList(){
		if(this.mCustSvcRepList == null){
			this.mCustSvcRepList = new ArrayList<CustSvcRep>();
		}
		return this.mCustSvcRepList;	
	}
	public  void setCustSvcRepList(List<CustSvcRep> custSvcRepList){
		for( CustSvcRep custSvcRep:custSvcRepList){
			custSvcRep.setRole(this);
		}
		
		
		this.mCustSvcRepList = custSvcRepList;
		
	}
	
	public  void addCustSvcRep(CustSvcRep cust_svc_rep){
		cust_svc_rep.setRole(this);
		getCustSvcRepList().add(cust_svc_rep);
	}
	public  void addCustSvcReps(List<CustSvcRep> custSvcRepList){
		for( CustSvcRep custSvcRep:custSvcRepList){
			custSvcRep.setRole(this);
		}
		getCustSvcRepList().addAll(custSvcRepList);
	}
	
	public  void removeCustSvcRep(CustSvcRep cust_svc_rep){
		getCustSvcRepList().remove(cust_svc_rep);
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

