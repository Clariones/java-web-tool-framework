package com.terapico.b2btemplate;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import privilege.User;
import privilege.UserMapper;
import privilege.UserNotFoundException;

public class OrderDAOImpl extends CommonJDBCTemplateDAO implements OrderDAO{
	
	
	
	public Order loadOrder(String orderId){

		return loadInternalOrder(orderId);
	}
	
	public Order saveOrder(Order order) throws EntityNotFoundException{
		
		saveOrderObject(order);
		saveBuyer(order);
		saveSeller(order);
		saveLineItems(order);
		saveShippingGroups(order);
		savePaymentGroups(order);
		
		return order;
	}
	

	protected void savePaymentGroups(Order order) throws PaymentGroupNotFoundException {
		
		
	}
	
	private void saveSeller(Order order) {
		// TODO Auto-generated method stub
		
	}

	protected void saveBuyer(Order order) {
		// TODO Auto-generated method stub
		
	}
/*
 * create table payment_group_data (
	id	  	varchar(48) not null,
	name	  	varchar(40),
	biz_order	  	varchar(64),
	card_number	  	varchar(40),
	billing_address	  	varchar(64),
	version	  	int,
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
	

	protected Order saveShippingGroups(Order order) {
		
		return order;
	}

	protected Order saveLineItems(Order order) {
		
		return order;
	}

	protected Order saveOrderObject(Order order) {
		
		return order;
	}

	protected Order loadInternalOrder(String orderId){
		
		Order order = extractOrder(orderId);
		extractBuyer(order);
		extractSeller(order);
		
		extractCommerceItems(order);
		extractShippingGroup(order);
		extractPaymentGroup(order);
		
		summaryUpOrder(order);
		
		return order;
	}
	protected Order summaryUpOrder(Order order) {
		
		double summary=0;
		for(LineItem item:order.getCommerceItemList()){
			summary +=item.getAmount()*item.getQuantity();
		}
		for(ShippingGroup item:order.getShippingGroupList()){
			summary +=item.getAmount();
		}
		order.setTotalAmount(summary);
		return order;
		
	}

	protected Order extractOrder(String orderId) {
		
		String SQL = "select * from order_data where id=?";
		Order orderInternal = getJdbcTemplateObject().queryForObject(SQL, new Object[]{orderId},new OrderMapper());
		return orderInternal;
	}
	protected Order extractSeller(Order order) {
		
		String SQL = "select * from seller_company_data where id=?";
		SellerCompany seller = getJdbcTemplateObject().queryForObject(SQL, new Object[]{order.getSeller().getId()},new SellerCompanyMapper());
		if(seller!=null){
			order.setSeller(seller);
		}
		
		return order;
		
	}

	protected Order extractBuyer(Order order) {
		String SQL = "select * from buyer_company_data where id=?";
		if(getJdbcTemplateObject()==null){
			throw new IllegalStateException("getJdbcTemplateObject() = null");
		}
		BuyerCompany buyer = getJdbcTemplateObject().queryForObject(SQL, new Object[]{order.getBuyer().getId()},new BuyerCompanyMapper());
		
		if(buyer!=null){
			order.setBuyer(buyer);
		}
		return order;
		
	}
	

	
	protected Order extractPaymentGroup(Order order) {
		
		String SQL = "select * from payment_group_data where biz_order=?";
		List<PaymentGroup> paymentGroupList = getJdbcTemplateObject().query(SQL, new Object[]{order.getId()},new PaymentGroupMapper());
		if(paymentGroupList!=null){
			order.setPaymentGroupList(paymentGroupList);
		}
		return order;
	}

	protected Order extractShippingGroup(Order order) {
		
		String SQL = "select * from shipping_group_data where biz_order=?";
		List<ShippingGroup> items = getJdbcTemplateObject().query(SQL, new Object[]{order.getId()},new ShippingGroupMapper());
		if(items!=null){
			order.setShippingGroupList(items);
		}
		return order;

	}

	protected Order extractCommerceItems(Order order) {
		
		String SQL = "select * from line_item_data where biz_order=?";
		List<LineItem> items = getJdbcTemplateObject().query(SQL, new Object[]{order.getId()},new LineItemMapper());
		if(items!=null){
			order.setCommerceItemList(items);
		}
		return order;
	}

	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return "order";
	}

	@Override
	protected String[] getNormalColumnNames() {
		// TODO Auto-generated method stub
		return new String[]{"buyer","seller","title","totalAmount","type"};
	}


	

}
	