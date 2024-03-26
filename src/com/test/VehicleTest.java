package com.test;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import com.exception.VehicleNotFoundException;
import com.service.VehicleService;

public class VehicleTest {
	VehicleService vehicleService =new VehicleService();
	
	@Test
	public void getVehiclesByStatus() {
		String str="available";
		try {
			vehicleService.getVehiclesByStatus(str);
		} catch (SQLException e) {
			Assert.assertEquals("Status not found".toLowerCase(), e.getMessage());
		}
		
		String str1="Unavailable";
		try {
			vehicleService.getVehiclesByStatus(str1);
		} catch (SQLException e) {
			Assert.assertEquals("Status not found".toLowerCase(), e.getMessage());
		}
	}
	
	@Test
	public void getVehicles() {
		
		try {
			vehicleService.getVehicles();
		} catch (SQLException e) {
			Assert.assertEquals("ID not found".toLowerCase(), e.getMessage());
		}
	}
	
	@Test
	public void getByNumPlate() {
		String str2="TN08MN7890";
		try {
			vehicleService.getByNumPlate(str2);
		} catch (SQLException | VehicleNotFoundException e) {
			Assert.assertEquals("Number plate format doesn't match...".toLowerCase(), e.getMessage());
		}
		
		String s="tn-08-mn-8907";
		try {
			vehicleService.getByNumPlate(s);
		} catch (SQLException | VehicleNotFoundException e) {
			Assert.assertEquals("Number plate format doesn't match...".toLowerCase(), e.getMessage());
		}
	}
	
	@Test
	public void insert() {
		int id=1;
		String s1="Audi";
		String s2="Q8";
		int dr=65;
		String s3="available";
		int pa=8;
		int ec=1900;
		String s4="TN-09-PM-6789";
		try {
			vehicleService.insert(id, s1, s2, dr, s3, pa, ec, s4);
		} catch (SQLException e) {
			Assert.assertEquals("Order should be correct.....".toLowerCase(), e.getMessage());
		}
		
	}
	
	

}
