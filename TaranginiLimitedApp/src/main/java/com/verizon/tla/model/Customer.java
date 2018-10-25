package com.verizon.tla.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Customer")
public class Customer {

	@NotEmpty(message="Package Id cannot be empty")
	private String packageId;
	
	@NotEmpty(message="Name cannot be empty")
	private String name;
	
	@Id
	@NotEmpty(message="Mobile No cannot be empty")
	private String mobileNo;
	
	@NotEmpty(message="timeSlot cannot be empty")
	private String timeSlot;
	
	@NotEmpty(message="Address cannot be empty")
	private String addr;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(@NotEmpty(message = "Package Id cannot be empty") String packageId,
			@NotEmpty(message = "Name cannot be empty") String name,
			@NotNull(message = "Mobile No cannot be empty") String mobileNo,
			@NotEmpty(message = "timeSlot cannot be empty") String timeSlot,
			@NotEmpty(message = "Address cannot be empty") String addr) {
		super();
		this.packageId = packageId;
		this.name = name;
		this.mobileNo = mobileNo;
		this.timeSlot = timeSlot;
		this.addr = addr;
	}

	public String getPackageId() {
		return packageId;
	}

	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
	
}
