
package com.terapico.b2b.role;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;



import com.terapico.b2b.access.Access;
import com.terapico.b2b.custsvcrep.CustSvcRep;


public class Role implements  java.io.Serializable{

	protected		String	mId;
	protected		String	mRoleName;
	protected		int	mVersion;
	
	
	protected		List<Access> mAccessList;
	protected		List<CustSvcRep> mCustSvcRepList;
	
		
	public 	Role(){
		//lazy load for all the properties
	}
	
	public 	Role(String roleName)
	{
		setRoleName(roleName);
		this.mAccessList = new ArrayList<Access>();
		this.mCustSvcRepList = new ArrayList<CustSvcRep>();	
	}
	

	
	public void setId(String id){
		this.mId = id;
	}
	public String getId(){
		return this.mId;
	}
	
	public void setRoleName(String roleName){
		this.mRoleName = roleName;
	}
	public String getRoleName(){
		return this.mRoleName;
	}
	
	public void setVersion(int version){
		this.mVersion = version;
	}
	public int getVersion(){
		return this.mVersion;
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
	public  void cleanUpAccessList(){
		getAccessList().clear();
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
	
	public  void addCustSvcRep(CustSvcRep custSvcRep){
		custSvcRep.setRole(this);
		getCustSvcRepList().add(custSvcRep);
	}
	public  void addCustSvcReps(List<CustSvcRep> custSvcRepList){
		for( CustSvcRep custSvcRep:custSvcRepList){
			custSvcRep.setRole(this);
		}
		getCustSvcRepList().addAll(custSvcRepList);
	}
	
	public  void removeCustSvcRep(CustSvcRep custSvcRep){
		getCustSvcRepList().remove(custSvcRep);
	}
	public  void cleanUpCustSvcRepList(){
		getCustSvcRepList().clear();
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

