package com.terapico.b2btemplate;

import java.util.List;

public class PaymentGroupDAOImpl extends CommonJDBCTemplateDAO implements PaymentGroupDAO{
	
	
	public void save(List<PaymentGroup>paymentGroups) throws PaymentGroupNotFoundException {
		
		for(PaymentGroup item:paymentGroups){

			if(item.getId()==null){
				create(item);
				continue;
			}
			update(item);	
		}
	}
	
	public void create(PaymentGroup item) throws PaymentGroupNotFoundException{
		String insertSQL=this.getCreateSQL();
		
		Object[] parameters=buildInsertParameters(item);
		int updatedCount=this.getJdbcTemplateObject().update(insertSQL, parameters);
		if(updatedCount <1 ){
			throw new PaymentGroupNotFoundException("PaymentGroup: "+item.getId()+" with version: "+ item.getVersion() +"Not found ");
		}
	}
	
	
	public void update(PaymentGroup item) throws PaymentGroupNotFoundException{
		String updateSQL=this.getUpdateSQL();
		
		Object[] parameters=buildUpdatePrameters(item);
		int updatedCount=this.getJdbcTemplateObject().update(updateSQL, parameters);
		if(updatedCount <1 ){
			throw new PaymentGroupNotFoundException("PaymentGroup: "+item.getId()+" with version: "+ item.getVersion() +"Not found ");
		}
	}
	
	public List<PaymentGroup> findByOrderId(String orderId) throws PaymentGroupNotFoundException{
		//String updateSQL=this.getUpdateSQL();
		String SQL = "select * from payment_group_data where biz_order=?";
		List<PaymentGroup> paymentGroupList =this.getJdbcTemplateObject().query(SQL, new Object[]{orderId},new PaymentGroupMapper());		
		return paymentGroupList;
	}
	public List<PaymentGroup> findByBillingAddressId(String billigAddressId) throws PaymentGroupNotFoundException{
		//String updateSQL=this.getUpdateSQL();
		String SQL = "select * from payment_group_data where billing_address=?";
		List<PaymentGroup> paymentGroupList =this.getJdbcTemplateObject().query(SQL, new Object[]{billigAddressId},new PaymentGroupMapper());		
		return paymentGroupList;
	}
	
	public List<PaymentGroup> findByBillingAddressIds(String []billigAddressIds) throws PaymentGroupNotFoundException{
		//String updateSQL=this.getUpdateSQL();
		String SQL = "select * from payment_group_data where billing_address in ("+joinPlaceHolders(billigAddressIds)+")";
		List<PaymentGroup> paymentGroupList =this.getJdbcTemplateObject().query(SQL, billigAddressIds,new PaymentGroupMapper());		
		return paymentGroupList;
	}
	


	protected Object [] buildUpdatePrameters(PaymentGroup item){
		Object[] parameters=new Object[]{item.getName(),item.getBizOrder().getId(),
				item.getCardNumber(),item.getBillingAddress().getId(),item.getId(),item.getVersion()};
		
		return parameters;
	}
	
	
	
	protected Object [] buildInsertParameters(PaymentGroup item){
		Object[] parameters=new Object[]{getNextId(),item.getName(),item.getBizOrder().getId(),
				item.getCardNumber(),item.getBillingAddress().getId(),item.getId(),1};
		return parameters;
	}

	@Override
	protected String getName() {
		
		return "payment_group";
	}

	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"name","bize_order","card_number","billing_address"};
	}

}
