package com.dto;

import java.time.LocalDate;

public class CustomerVehicleDto {
	private int customerId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private int vehicleId;
	private String make;
	private String model;
	private LocalDate startDate;
	private LocalDate endDate;
	public CustomerVehicleDto() {}
	public CustomerVehicleDto(int customerId, String firstName, String lastName, String phoneNumber, int vehicleId,
			String make, String model, LocalDate startDate, LocalDate endDate) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.vehicleId = vehicleId;
		this.make = make;
		this.model = model;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "CustomerVehicleDto [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phoneNumber=" + phoneNumber + ", vehicleId=" + vehicleId + ", make=" + make + ", model=" + model
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
	
}
