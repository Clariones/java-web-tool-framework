package com.terapico.b2b;

import com.terapico.b2b.order.Order;

public class BeanFactory {
	public Order createOrder(){
		return new Order();
	}
}
