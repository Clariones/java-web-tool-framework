
package com.terapico.b2b.creditaccount;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.b2b.buyercompany.BuyerCompany;
import com.terapico.b2b.sellercompany.SellerCompany;

@JsonSerialize(using = CreditAccountSerializer.class)
public class CreditAccount implements  java.io.Serializable{

	protected		String	mId;
	protected		String	mName;
	protected		BuyerCompany	mBuyer;
	protected		SellerCompany	mSeller;
	protected		double	mAuthorized;
	protected		double	mRemain;
	protected		int	mVersion;
	
	
	
		
	public 	CreditAccount(){
		//lazy load for all the properties
	}
	
	public 	CreditAccount(String name, BuyerCompany buyer, SellerCompany seller, double authorized, double remain)
	{
		setName(name);
		setBuyer(buyer);
		setSeller(seller);
		setAuthorized(authorized);
		setRemain(remain);	
	}
	

	
	public void setId(String id){
		this.mId = id;
	}
	public String getId(){
		return this.mId;
	}
	
	public void setName(String name){
		this.mName = name;
	}
	public String getName(){
		return this.mName;
	}
	
	public void setBuyer(BuyerCompany buyer){
		this.mBuyer = buyer;
	}
	public BuyerCompany getBuyer(){
		return this.mBuyer;
	}
	
	public void setSeller(SellerCompany seller){
		this.mSeller = seller;
	}
	public SellerCompany getSeller(){
		return this.mSeller;
	}
	
	public void setAuthorized(double authorized){
		this.mAuthorized = authorized;
	}
	public double getAuthorized(){
		return this.mAuthorized;
	}
	
	public void setRemain(double remain){
		this.mRemain = remain;
	}
	public double getRemain(){
		return this.mRemain;
	}
	
	public void setVersion(int version){
		this.mVersion = version;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("credit_account{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tbuyer='buyer_company("+getBuyer().getId()+")';");
		stringBuilder.append("\tseller='seller_company("+getSeller().getId()+")';");
		stringBuilder.append("\tauthorized='"+getAuthorized()+"';");
		stringBuilder.append("\tremain='"+getRemain()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}

