
package com.terapico.b2b.sellercompany;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import com.terapico.b2b.order.Order;
import com.terapico.b2b.custsvcrep.CustSvcRep;

import com.terapico.b2b.custsvcrep.CustSvcRepDAO;
import com.terapico.b2b.order.OrderDAO;

import com.terapico.b2b.approval.Approval;
import com.terapico.b2b.confirmation.Confirmation;
import com.terapico.b2b.shipment.Shipment;
import com.terapico.b2b.buyercompany.BuyerCompany;
import com.terapico.b2b.processing.Processing;
import com.terapico.b2b.role.Role;
import com.terapico.b2b.delivery.Delivery;
import com.terapico.b2b.sellercompany.SellerCompany;



public class SellerCompanyManagerImpl implements SellerCompanyManager {

	private  SellerCompanyDAO  sellerCompanyDAO;
 	public void setSellerCompanyDAO(SellerCompanyDAO  sellerCompanyDAO){
 	
 		if(sellerCompanyDAO == null){
 			throw new IllegalStateException("Do not try to set sellerCompanyDAO to null.");
 		}
	 	this.sellerCompanyDAO = sellerCompanyDAO;
 	}
 	public SellerCompanyDAO getSellerCompanyDAO(){
 		if(this.sellerCompanyDAO == null){
 			throw new IllegalStateException("The SellerCompanyDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.sellerCompanyDAO;
 	}
 	
 	public SellerCompany saveSellerCompany(SellerCompany sellerCompany, Map<String,Object>options) throws Exception{	
 		return getSellerCompanyDAO().save(sellerCompany, options);
 	}
 	public SellerCompany loadSellerCompany(String sellerCompanyId, Map<String,Object>options) throws Exception{	
 		return getSellerCompanyDAO().load(sellerCompanyId, options);
 	}
 	
 	
 	
	public SellerCompany createSellerCompany(String name, String owner, String logo, String contractText, String[] optionsExpr) throws Exception
	{
		
		
		SellerCompany sellerCompany=createNewSellerCompany(optionsExpr);	

		sellerCompany.setName(name);
		sellerCompany.setOwner(owner);
		sellerCompany.setLogo(logo);
		sellerCompany.setContractText(contractText);
		//save for later setOrderValues(sellerCompany);
		Map<String, Object> options = new HashMap<String, Object>();
		
		//return sellerCompanyDAO.save(sellerCompany, options);
		return saveSellerCompany(sellerCompany, options);
		

		
	}
	protected SellerCompany createNewSellerCompany(String[] optionsExpr) throws Exception
	{
		
		return new SellerCompany();
		
	}
	public SellerCompany updateSellerCompany(String sellerCompanyId, String property, Object newValue) throws Exception 
	{
		return new SellerCompany();
	}
	protected Map<String,Object> emptyOptions(){
		return new HashMap<String,Object>();
	}
	
	protected SellerCompanyTokens tokens(){
		return SellerCompanyTokens.start();
	}
	protected Map<String,Object> allTokens(){
		return SellerCompanyTokens.all();
	}
	


	public void delete(String sellerCompanyId, int version) throws Exception
	{
	
	}
	public int deleteAll() throws Exception
	{
		return 0;
	}
	public  SellerCompany addOrder(String sellerCompanyId, String buyerId, String title, double totalAmount, String type, boolean markAsDelete) throws Exception
	{		
		Order order = createOrder(buyerId, title, totalAmount, type, markAsDelete);
		
		SellerCompany sellerCompany = loadSellerCompany(sellerCompanyId, allTokens());
		
		sellerCompany.addOrder( order );
		
		return saveSellerCompany(sellerCompany, tokens().withOrderList().done());
	}
	protected Order createOrder(String buyerId, String title, double totalAmount, String type, boolean markAsDelete){

		Order order = new Order();
		
		
		BuyerCompany  buyer = new BuyerCompany();
		buyer.setId(buyerId);		
		order.setBuyer(buyer);		
		order.setTitle(title);		
		order.setTotalAmount(totalAmount);		
		order.setType(type);		
		order.setMarkAsDelete(markAsDelete);
	
		
		return order;			
		
	}
	public  SellerCompany removeOrder(String sellerCompanyId, String orderId){
		return new SellerCompany();
	}
	public  SellerCompany updateOrder(String sellerCompanyId, String orderId, String property, Object newValue){
		return new SellerCompany();
	}

	public  SellerCompany addCustSvcRep(String sellerCompanyId, String email, String roleId) throws Exception
	{		
		CustSvcRep custSvcRep = createCustSvcRep(email, roleId);
		
		SellerCompany sellerCompany = loadSellerCompany(sellerCompanyId, allTokens());
		
		sellerCompany.addCustSvcRep( custSvcRep );
		
		return saveSellerCompany(sellerCompany, tokens().withCustSvcRepList().done());
	}
	protected CustSvcRep createCustSvcRep(String email, String roleId){

		CustSvcRep custSvcRep = new CustSvcRep();
		
		
		custSvcRep.setEmail(email);		
		Role  role = new Role();
		role.setId(roleId);		
		custSvcRep.setRole(role);
	
		
		return custSvcRep;			
		
	}
	public  SellerCompany removeCustSvcRep(String sellerCompanyId, String custSvcRepId){
		return new SellerCompany();
	}
	public  SellerCompany updateCustSvcRep(String sellerCompanyId, String custSvcRepId, String property, Object newValue){
		return new SellerCompany();
	}



}


