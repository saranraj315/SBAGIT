package com.verizon.tla.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.tla.dao.CustomerRepository;
import com.verizon.tla.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepo;
	
	@Override
	public Customer getCustomerByMobileNo(long mobileNo) {
		Customer customer = null;
		
		Optional<Customer> optCustomer = customerRepo.findById(mobileNo);
		if(optCustomer.isPresent()) {
			customer = optCustomer.get();
		}
		
		return customer;
		
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepo.findAll();
	}

	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

	@Override
	public boolean existsByMobileNo(String mobileNo) {
		return customerRepo.existsByMobileNo(mobileNo);
	}

}
