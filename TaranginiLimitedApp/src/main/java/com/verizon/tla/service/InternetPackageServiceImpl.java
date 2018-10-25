package com.verizon.tla.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.tla.dao.InternetRepository;
import com.verizon.tla.model.InternetPackage;

@Service
public class InternetPackageServiceImpl implements InternetPackageService {

	@Autowired
	private InternetRepository packageRepo;
	
	@Override
	public List<InternetPackage> getAllPackagesByCost(double cost) {
		return packageRepo.findAllByCost(cost);
	}

	@Override
	public List<InternetPackage> getAllPackagesByMaxUsage(double maxUsage) {
		return packageRepo.findAllByMaxUsage(maxUsage);
	}

	@Override
	public List<InternetPackage> getAllPackagesByNetSpeed(double netSpeed) {
		return packageRepo.findAllByNetSpeed(netSpeed);
	}

	@Override
	public List<InternetPackage> getAllPackages() {
		return packageRepo.findAll();
	}

}
