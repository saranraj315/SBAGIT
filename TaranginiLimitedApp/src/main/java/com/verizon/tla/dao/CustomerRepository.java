package com.verizon.tla.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.tla.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	boolean existsByMobileNo( String mobileNo);
	
}
