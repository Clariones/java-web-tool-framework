
package com.terapico.b2b;
import java.util.Map;

import com.terapico.b2b.buyercompany.BuyerCompany;
import com.terapico.b2b.sellercompany.SellerCompany;
import com.terapico.b2b.costcenter.CostCenter;
import com.terapico.b2b.profitcenter.ProfitCenter;
import com.terapico.b2b.creditaccount.CreditAccount;
import com.terapico.b2b.shippingaddress.ShippingAddress;
import com.terapico.b2b.billingaddress.BillingAddress;
import com.terapico.b2b.employee.Employee;
import com.terapico.b2b.role.Role;
import com.terapico.b2b.assignment.Assignment;
import com.terapico.b2b.access.Access;
import com.terapico.b2b.order.Order;
import com.terapico.b2b.recurringinfo.RecurringInfo;
import com.terapico.b2b.confirmation.Confirmation;
import com.terapico.b2b.shipment.Shipment;
import com.terapico.b2b.delivery.Delivery;
import com.terapico.b2b.processing.Processing;
import com.terapico.b2b.approval.Approval;
import com.terapico.b2b.lineitem.LineItem;
import com.terapico.b2b.shippinggroup.ShippingGroup;
import com.terapico.b2b.paymentgroup.PaymentGroup;
import com.terapico.b2b.custsvcrep.CustSvcRep;
import com.terapico.b2b.action.Action;

public class BeanFactoryImpl{


	public BuyerCompany createBuyerCompany(Map<String,Object> options){
		return new BuyerCompany();
	}


	public SellerCompany createSellerCompany(Map<String,Object> options){
		return new SellerCompany();
	}


	public CostCenter createCostCenter(Map<String,Object> options){
		return new CostCenter();
	}


	public ProfitCenter createProfitCenter(Map<String,Object> options){
		return new ProfitCenter();
	}


	public CreditAccount createCreditAccount(Map<String,Object> options){
		return new CreditAccount();
	}


	public ShippingAddress createShippingAddress(Map<String,Object> options){
		return new ShippingAddress();
	}


	public BillingAddress createBillingAddress(Map<String,Object> options){
		return new BillingAddress();
	}


	public Employee createEmployee(Map<String,Object> options){
		return new Employee();
	}


	public Role createRole(Map<String,Object> options){
		return new Role();
	}


	public Assignment createAssignment(Map<String,Object> options){
		return new Assignment();
	}


	public Access createAccess(Map<String,Object> options){
		return new Access();
	}


	public Order createOrder(Map<String,Object> options){
		return new Order();
	}


	public RecurringInfo createRecurringInfo(Map<String,Object> options){
		return new RecurringInfo();
	}


	public Confirmation createConfirmation(Map<String,Object> options){
		return new Confirmation();
	}


	public Shipment createShipment(Map<String,Object> options){
		return new Shipment();
	}


	public Delivery createDelivery(Map<String,Object> options){
		return new Delivery();
	}


	public Processing createProcessing(Map<String,Object> options){
		return new Processing();
	}


	public Approval createApproval(Map<String,Object> options){
		return new Approval();
	}


	public LineItem createLineItem(Map<String,Object> options){
		return new LineItem();
	}


	public ShippingGroup createShippingGroup(Map<String,Object> options){
		return new ShippingGroup();
	}


	public PaymentGroup createPaymentGroup(Map<String,Object> options){
		return new PaymentGroup();
	}


	public CustSvcRep createCustSvcRep(Map<String,Object> options){
		return new CustSvcRep();
	}


	public Action createAction(Map<String,Object> options){
		return new Action();
	}





}





