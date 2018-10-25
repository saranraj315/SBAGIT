package com.verizon.tla.service;

import com.verizon.tla.model.Order;

public interface OrderService {

	Order getOrderByCustomer(String mobileNo);
	
	Order addOrder(Order order);
	
}
