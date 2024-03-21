package com.model;

public class Vehicle {
	private int id;
	private String brandName;
	private String model;
	//private Year year;
	private int dailyRate;
	private String status;
	private int passengerCapacity;
	private int engineCapacity;
	private String numberPlate;
	
	
	public Vehicle(){
		super();
	}
	
public Vehicle(int id, String brandName, String model, int dailyRate, String status,
			int passengerCapacity, int engineCapacity, String numberPlate) {
		super();
		this.id = id;
		this.brandName = brandName;
		this.model = model;
		//this.year = year;
		this.dailyRate = dailyRate;
		this.status = status;
		this.passengerCapacity = passengerCapacity;
		this.engineCapacity = engineCapacity;
		this.numberPlate = numberPlate;
	}


public Vehicle(String brandName, String model, int dailyRate, String status, int passengerCapacity,
		int engineCapacity, String numberPlate) {
	super();
	this.brandName = brandName;
	this.model = model;
	//this.year = year;
	this.dailyRate = dailyRate;
	this.status = status;
	this.passengerCapacity = passengerCapacity;
	this.engineCapacity = engineCapacity;
	this.numberPlate = numberPlate;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getBrandName() {
	return brandName;
}

public void setBrandName(String brandName) {
	this.brandName = brandName;
}

public String getModel() {
	return model;
}

public void setModel(String model) {
	this.model = model;
}

public int getDailyRate() {
	return dailyRate;
}

public void setDailyRate(int dailyRate) {
	this.dailyRate = dailyRate;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public int getPassengerCapacity() {
	return passengerCapacity;
}

public void setPassengerCapacity(int passengerCapacity) {
	this.passengerCapacity = passengerCapacity;
}

public int getEngineCapacity() {
	return engineCapacity;
}

public void setEngineCapacity(int engineCapacity) {
	this.engineCapacity = engineCapacity;
}

public String getNumberPlate() {
	return numberPlate;
}

public void setNumberPlate(String numberPlate) {
	this.numberPlate = numberPlate;
}

@Override
public String toString() {
	return "Vehicle [id=" + id + ", brandName=" + brandName + ", model=" + model + ", dailyRate=" + dailyRate
			+ ", status=" + status + ", passengerCapacity=" + passengerCapacity + ", engineCapacity=" + engineCapacity
			+ ", numberPlate=" + numberPlate + "]";



}

}
