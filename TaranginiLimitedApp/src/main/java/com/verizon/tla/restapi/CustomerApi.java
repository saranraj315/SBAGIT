package com.verizon.tla.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.tla.model.Customer;
import com.verizon.tla.service.CustomerService;

@RestController
@CrossOrigin
public class CustomerApi {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		
		ResponseEntity<Customer> resp = null;
		Customer cust = null;
		
		if(customerService.existsByMobileNo(customer.getMobileNo())) {
			resp = new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
		}
		
		if(resp==null) {
			cust = customerService.addCustomer(customer);
			if(customer == null)
				resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			else
				resp = new ResponseEntity<>(cust, HttpStatus.OK);
		}
		
		return resp;
	}
	
}
