package com.verizon.tla.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.tla.model.Order;
import com.verizon.tla.service.OrderService;

@RestController
@CrossOrigin
public class OrderApi {

	@Autowired
	private OrderService orderService;
	
	@GetMapping("/viewOrder/{id}")
	public ResponseEntity<Order> getOrderByOrderId(@PathVariable("id") String mobileNo) {
	
		ResponseEntity<Order> resp;
		Order order = orderService.getOrderByCustomer(mobileNo);
		
		if(order == null)
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			resp = new ResponseEntity<>(order, HttpStatus.OK);
		
		return resp;
		
	}
	
	
	@PostMapping("/addOrder")
	public ResponseEntity<Order> addOrder(@RequestBody Order order) {
		
		ResponseEntity<Order> resp = null;
		Order odr = null;
		
		if(resp==null) {
			odr = orderService.addOrder(order);
			if(order == null)
				resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			else
				resp = new ResponseEntity<>(odr, HttpStatus.OK);
		}
		
		return resp;
	}
	
	
}
