package com.verizon.tla.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OrderTable")
public class Order {

	@Id
	private long odrId;
	
	private String customer;
	
	private LocalDate dateOfInstallation;
	
	private LocalDate dateOfRequest;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(long odrId, String customer, LocalDate dateOfInstallation, LocalDate dateOfRequest) {
		super();
		this.odrId = odrId;
		this.customer = customer;
		this.dateOfInstallation = dateOfInstallation;
		this.dateOfRequest = dateOfRequest;
	}

	public long getOrderId() {
		return odrId;
	}

	public void setOrderId(long odrId) {
		this.odrId = odrId;
	}

	public String getMobileNo() {
		return customer;
	}

	public void setMobileNo(String customer) {
		this.customer = customer;
	}

	public LocalDate getDateOfInstallation() {
		return dateOfInstallation;
	}

	public void setDateOfInstallation(LocalDate dateOfInstallation) {
		this.dateOfInstallation = dateOfInstallation;
	}

	public LocalDate getDateOfRequest() {
		return dateOfRequest;
	}

	public void setDateOfRequest(LocalDate dateOfRequest) {
		this.dateOfRequest = dateOfRequest;
	}
	
	
	
}
