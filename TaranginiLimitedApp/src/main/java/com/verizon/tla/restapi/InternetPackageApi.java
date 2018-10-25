package com.verizon.tla.restapi;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.tla.model.InternetPackage;
import com.verizon.tla.service.InternetPackageService;

@RestController
@CrossOrigin
public class InternetPackageApi {

	@Autowired
	private InternetPackageService packageService;
	
	@GetMapping("/packages/{field}/{searchValue}")
	public ResponseEntity<List<InternetPackage>> getAllInternetPackages(@PathVariable("field") String field,
														@PathVariable("searchValue") double searchValue) {
		ResponseEntity<List<InternetPackage>> resp = null;
		InternetPackage pack = null;
		List<InternetPackage> results = null;
		
		switch (field) {
		case "cost":		results = packageService.getAllPackagesByCost(searchValue);
							if(results!=null && results.size()!=0) 
									resp = new ResponseEntity<>(results, HttpStatus.OK);
							else 
									resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
							break;
							
		case "maxUsage": 	results = packageService.getAllPackagesByMaxUsage(searchValue);
							if(results!=null && results.size()!=0) 
								resp = new ResponseEntity<>(results, HttpStatus.OK);
							else 
								resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
							break;
							
		case "netSpeed":	results = packageService.getAllPackagesByNetSpeed(searchValue);
							if(results!=null && results.size()!=0) 
								resp = new ResponseEntity<>(results, HttpStatus.OK);
							else 
								resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
							break;
							
		default:	resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return resp;
	}
	
	
	@GetMapping("/packages")
	public ResponseEntity<List<InternetPackage>> getAllPackages() {
		return new ResponseEntity<>(packageService.getAllPackages(), HttpStatus.OK);
	}
	
}
