package com.model;

import java.time.LocalDate;

public class Lease {
	private int id;
	private int vehicleId;
	private int customerId;
	private LocalDate startDate;
	private LocalDate endDate;
	private String type;
	
	public Lease() {
		super();
	}
	
	public Lease(int id, int vehicleId, int customerId, LocalDate startDate, LocalDate endDate, String type) {
		super();
		this.id = id;
		this.vehicleId = vehicleId;
		this.customerId = customerId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.type = type;
	}

	public Lease(int vehicleId, int customerId, LocalDate startDate, LocalDate endDate, String type) {
		super();
		this.vehicleId = vehicleId;
		this.customerId = customerId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Lease [id=" + id + ", vehicleId=" + vehicleId + ", customerId=" + customerId + ", startDate="
				+ startDate + ", endDate=" + endDate + ", type=" + type + "]";
	}
	
	
}
