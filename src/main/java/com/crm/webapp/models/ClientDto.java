package com.crm.webapp.models;

import jakarta.validation.constraints.*;

public class ClientDto {
	@NotEmpty(message = "First Name is required")
	private String firstName;
	@NotEmpty(message = "Last Name is required")
	private String lastName;
	@NotEmpty(message = "Email is required")
	@Email(message = "Email should be valid")
	private String email;
	@NotEmpty(message = "Phone is required")
	private String phone;
	
	@NotEmpty(message = "Address is required")
	private String address;
	
	@NotEmpty(message = "Status is required")
	private String status;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
