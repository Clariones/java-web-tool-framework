
package com.terapico.b2b.shippingaddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;



import com.terapico.b2b.shippinggroup.ShippingGroup;


public class ShippingAddress implements  java.io.Serializable{

	protected		String	mId;
	protected		String	mLine1;
	protected		String	mLine2;
	protected		String	mCity;
	protected		String	mState;
	protected		String	mCountry;
	protected		int	mVersion;
	
	
	protected		List<ShippingGroup> mShippingGroupList;
	
		
	public 	ShippingAddress(){

	}
	
	public 	ShippingAddress(String	id,String	line1,String	line2,String	city,String	state,String	country,int	version)
	{
		setId(id);
		setLine1(line1);
		setLine2(line2);
		setCity(city);
		setState(state);
		setCountry(country);
		setVersion(version);
		this.mShippingGroupList = new ArrayList<ShippingGroup>();	
	}
	

	
	public void setId(String id){
		this.mId = id;
	}
	public String getId(){
		return this.mId;
	}
	
	public void setLine1(String line1){
		this.mLine1 = line1;
	}
	public String getLine1(){
		return this.mLine1;
	}
	
	public void setLine2(String line2){
		this.mLine2 = line2;
	}
	public String getLine2(){
		return this.mLine2;
	}
	
	public void setCity(String city){
		this.mCity = city;
	}
	public String getCity(){
		return this.mCity;
	}
	
	public void setState(String state){
		this.mState = state;
	}
	public String getState(){
		return this.mState;
	}
	
	public void setCountry(String country){
		this.mCountry = country;
	}
	public String getCountry(){
		return this.mCountry;
	}
	
	public void setVersion(int version){
		this.mVersion = version;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	public  List<ShippingGroup> getShippingGroupList(){
		if(this.mShippingGroupList == null){
			this.mShippingGroupList = new ArrayList<ShippingGroup>();
		}
		return this.mShippingGroupList;	
	}
	public  void setShippingGroupList(List<ShippingGroup> shippingGroupList){
		for( ShippingGroup shippingGroup:shippingGroupList){
			shippingGroup.setAddress(this);
		}
		
		
		this.mShippingGroupList = shippingGroupList;
		
	}
	
	public  void addShippingGroup(ShippingGroup shipping_group){
		shipping_group.setAddress(this);
		getShippingGroupList().add(shipping_group);
	}
	public  void addShippingGroups(List<ShippingGroup> shippingGroupList){
		for( ShippingGroup shippingGroup:shippingGroupList){
			shippingGroup.setAddress(this);
		}
		getShippingGroupList().addAll(shippingGroupList);
	}
	
	public  void removeShippingGroup(ShippingGroup shipping_group){
		getShippingGroupList().remove(shipping_group);
	}
	public  void cleanUpShippingGroupList(){
		getShippingGroupList().clear();
	}
	
	
	
	
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("shipping_address{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tline1='"+getLine1()+"';");
		stringBuilder.append("\tline2='"+getLine2()+"';");
		stringBuilder.append("\tcity='"+getCity()+"';");
		stringBuilder.append("\tstate='"+getState()+"';");
		stringBuilder.append("\tcountry='"+getCountry()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}

