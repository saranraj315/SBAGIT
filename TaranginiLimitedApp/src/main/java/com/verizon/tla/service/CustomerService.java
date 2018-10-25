package com.verizon.tla.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.verizon.tla.model.Customer;

@Service
public interface CustomerService {

	Customer getCustomerByMobileNo(long mobileNo);
	
	List<Customer> getAllCustomers();
	
	Customer addCustomer(Customer customer);
	
	boolean existsByMobileNo( String mobileNo);
	
}
