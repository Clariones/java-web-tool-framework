package organization;

import java.util.ArrayList;
import java.util.List;

public class Organization {
	private Organization parentOrganization;
	private List<Organization>subOrganizations;
	private String name;
	public String getName() {
		return name;
	}
	
	public boolean isRoot() {
		return parentOrganization==null;
	}
	
	public boolean isLeaf() {
		if(subOrganizations==null){
			return true;
		}
		return subOrganizations.size()==0;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Organization getParentOrganization() {
		return parentOrganization;
	}
	public String toString() {
		return "org("+this.getName()+")";
	}
	public Organization jumpOut() {
		if(parentOrganization==null){
			throw new IllegalStateException("Not able to jump out form the node: "+this.getName());
		}
		return parentOrganization;
	}
	public void setParentOrganization(Organization parentOrganization) {
		this.parentOrganization = parentOrganization;
	}
	public List<Organization> getSubOrganizations() {
		if(subOrganizations==null){
			subOrganizations = new ArrayList<Organization>();
		}
		return subOrganizations;
	}
	public Organization addSubOrganization(Organization org)
	{
		org.setParentOrganization(this);
		getSubOrganizations().add(org);
		return this;
	}
	public Organization enterSubOrganization(Organization org)
	{
		org.setParentOrganization(this);
		getSubOrganizations().add(org);
		return org;
		
	}
	public void setSubOrganzations(List<Organization> subOrganzations) {
		this.subOrganizations = subOrganzations;
	}

}
