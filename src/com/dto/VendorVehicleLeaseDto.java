package com.dto;

import java.time.LocalDate;

public class VendorVehicleLeaseDto {

	private int id;
	private int vehicleId;
	private int customerId;
	private LocalDate startDate;
	private LocalDate endDate;
	private String type;
	private int vendorId;
	private String status;
	
	public VendorVehicleLeaseDto() {}

	public VendorVehicleLeaseDto(int id, int vehicleId, int customerId, LocalDate startDate, LocalDate endDate,
			String type, int vendorId, String status) {
		super();
		this.id = id;
		this.vehicleId = vehicleId;
		this.customerId = customerId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.type = type;
		this.vendorId = vendorId;
		this.status = status;
	}

	public VendorVehicleLeaseDto(int vehicleId, int customerId, LocalDate startDate, LocalDate endDate, String type,
			int vendorId, String status) {
		super();
		this.vehicleId = vehicleId;
		this.customerId = customerId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.type = type;
		this.vendorId = vendorId;
		this.status = status;
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

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "VendorVehicleLeaseDto [id=" + id + ", vehicleId=" + vehicleId + ", customerId=" + customerId
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", type=" + type + ", vendorId=" + vendorId
				+ ", status=" + status + "]";
	}

	
}
