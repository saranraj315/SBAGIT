package com.verizon.tla.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.tla.dao.OrderRepository;
import com.verizon.tla.model.Order;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepo;

	@Override
	public Order getOrderByCustomer(String mobileNo) {
		Order order = orderRepo.findByCustomer(mobileNo);
	
		return order;
		
	}

	@Override
	public Order addOrder(Order order) {
		LocalDate dor = LocalDate.now();
		LocalDate doi = dor.plusDays(4);
		
		order.setDateOfRequest(dor);
		order.setDateOfInstallation(doi);
		
		return orderRepo.save(order);
	}
	
	
	
}
