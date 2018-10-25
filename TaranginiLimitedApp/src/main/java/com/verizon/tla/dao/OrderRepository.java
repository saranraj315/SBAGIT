package com.verizon.tla.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.tla.model.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

	Order findByCustomer(String customer);
	
}
