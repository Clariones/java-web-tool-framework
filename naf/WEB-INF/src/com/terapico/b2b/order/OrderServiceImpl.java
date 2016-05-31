package com.terapico.b2b.order;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.terapico.b2b.lineitem.LineItemDAO;

public class OrderServiceImpl {
	OrderDAO orderDAO;
	LineItemDAO lineItemDAO;

	public OrderDAO getOrderDAO() {
		return orderDAO;
	}

	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}
	public Order load(String orderId,String [] optionsArray) throws Exception {
		Set<String> options=new HashSet<String>();
		options.addAll(Arrays.asList(optionsArray));
		return orderDAO.load(orderId, options);
	}
	public void delete(String orderId, int version) throws Exception {
		//Set<String> options=new HashSet<String>();
		//options.addAll(Arrays.asList(optionsArray));
		 orderDAO.delete(orderId, version);
	}
	public void deleteLineItem(String orderId, String lineItemId, int version) throws Exception {
		//Set<String> options=new HashSet<String>();
		//options.addAll(Arrays.asList(optionsArray));
		 //orderDAO.delete(orderId, version);
		 lineItemDAO.delete(lineItemId, version);
		 
	}
	public Order submit(String orderId,String [] optionsArray) throws OrderNotFoundException {
		Set<String> options=new HashSet<String>();
		options.addAll(Arrays.asList(optionsArray));
		return orderDAO.load(orderId, options);
	}
}
