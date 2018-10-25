package com.verizon.tla.service;

import java.util.List;

import com.verizon.tla.model.InternetPackage;

public interface InternetPackageService {

	List<InternetPackage> getAllPackagesByCost(double cost);
	
	List<InternetPackage> getAllPackagesByMaxUsage(double maxUsage);
	
	List<InternetPackage> getAllPackagesByNetSpeed(double netSpeed);
	
	List<InternetPackage> getAllPackages();
}
