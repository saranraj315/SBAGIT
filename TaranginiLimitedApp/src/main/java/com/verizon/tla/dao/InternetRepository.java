package com.verizon.tla.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.tla.model.InternetPackage;
	
@Repository
public interface InternetRepository extends JpaRepository<InternetPackage, String> {

	List<InternetPackage> findAllByCost(double cost);
	
	List<InternetPackage> findAllByMaxUsage(double maxUsage);
	
	List<InternetPackage> findAllByNetSpeed(double netSpeed);
	
}
