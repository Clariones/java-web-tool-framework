package com.terapico.b2b.order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.terapico.b2b.action.Action;
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
		Order theOrder = orderDAO.load(orderId, options);
		
		theOrder.addActions(getAvailableActions());;
		//theOrder.addAction(action);
		return theOrder;
	}
	public Order loadOne() throws Exception {
		
		//theOrder.addAction(action);
		return this.load("O000004", new String[]{"__all__"});
	}
	public Order confirm(String orderId,String [] optionsArray,String who) throws Exception {
		Set<String> options=new HashSet<String>();
		options.addAll(Arrays.asList(optionsArray));
		Order theOrder = orderDAO.load(orderId, options);
		
		//action..set
		//
		return theOrder;
	}
	public List<Action> getAvailableActions()
	{
		String [] allfunctions=new String[]{"confirm","approve","transfer","move"};
		List<Action> actions=new ArrayList<Action>();
		for(String actionName:allfunctions){
			
			Action action=new Action();
			action.setName(actionName.toUpperCase());
			action.setInternalName(actionName);
			actions.add(action);
		}
		return actions;
		
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
	public Order submit(String orderId,String [] optionsArray) throws Exception {
		Set<String> options=new HashSet<String>();
		options.addAll(Arrays.asList(optionsArray));
		return orderDAO.load(orderId, options);
	}
}
