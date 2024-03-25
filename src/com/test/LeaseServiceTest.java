package com.test;

import java.sql.SQLException;
import org.junit.Assert;
import org.junit.Test;

import com.service.LeaseService;

public class LeaseServiceTest {
	LeaseService leaseService = new LeaseService();
	
	@Test
	public void LeaseById()
	{
		int id=1002;
		try {
			leaseService.getLeaseById(id);
		} catch (SQLException e) {
			Assert.assertEquals("ID not found".toLowerCase(), e.getMessage());
		}
		
		id=1012;
		try {
			leaseService.getLeaseById(id);
		} catch (SQLException e) {
			Assert.assertEquals("ID not found".toLowerCase(), e.getMessage());
		}
	}
	
	@Test
	public void carReturn()
	{
		try {
			leaseService.returnCar();
		} catch (SQLException e) {
			Assert.assertEquals("ID not found".toLowerCase(), e.getMessage());
		}
	}
	
	@Test
	public void showActiveLeases()
	{
		try {
			leaseService.getActiveLease();
		} catch (SQLException e) {
			Assert.assertEquals("Error...Active Leases Cannot be found".toLowerCase(), e.getMessage());
		}
	}
	
	@Test
	public void VehicleBookingCount()
	{
		int vId=1;
		try
		{
			leaseService.getTotalVehicleBooking(vId);
		}catch (SQLException e) {
			Assert.assertEquals("ID not found".toLowerCase(), e.getMessage());
		}
	}
	 
}
