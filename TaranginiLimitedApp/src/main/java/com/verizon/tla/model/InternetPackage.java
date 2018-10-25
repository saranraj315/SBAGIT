package com.verizon.tla.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="InternetPackage")
public class InternetPackage {

	@Id
	private String title;
	
	@NotNull(message="Net speed cannot be null")
	private double netSpeed;
	
	@NotNull(message="Maximum usage cannot be null")
	private double maxUsage;
	
	@NotNull(message="Charge per month cannot be null")
	private double cost;
	
	public InternetPackage() {
		
	}

	public InternetPackage(String title, @NotNull(message = "Net speed cannot be null") double netSpeed,
			@NotNull(message = "Maximum usage cannot be null") double maxUsage,
			@NotNull(message = "Charge per month cannot be null") double cost) {
		super();
		this.title = title;
		this.netSpeed = netSpeed;
		this.maxUsage = maxUsage;
		this.cost = cost;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getNetSpeed() {
		return netSpeed;
	}

	public void setNetSpeed(double netSpeed) {
		this.netSpeed = netSpeed;
	}

	public double getMaxUsage() {
		return maxUsage;
	}

	public void setMaxUsage(double maxUsage) {
		this.maxUsage = maxUsage;
	}

	public double getcost() {
		return cost;
	}

	public void setcost(double cost) {
		this.cost = cost;
	}
	
	
	
}
