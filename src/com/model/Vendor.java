package com.model;

public class Vendor 
{
	private int id;
	private int vehicleId;
	private String firstName; 
	private String lastName;
	private String email;
	private String phoneNumber;
	private String userName;
	private String password;

	public Vendor() {}
	
	public Vendor(int id, int vehicleId, String firstName, String lastName, String email, String phoneNumber,
			String userName, String password) 
	{
		super();
		this.id = id;
		this.vehicleId = vehicleId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.password = password;
	}
	
	public Vendor(int vehicleId, String firstName, String lastName, String email, String phoneNumber, String userName,
			String password) 
	{
		super();
		this.vehicleId = vehicleId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.password = password;
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
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() 
	{
		return "Vendor [id=" + id + ", vehicleId=" + vehicleId + ", firstName=" + firstName + ", lastName=" + lastName + 
				", email=" + email + ", phoneNumber=" + phoneNumber + ", userName=" + userName + ", password=" + password + "]";
	}

}


