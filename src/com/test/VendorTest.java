package com.test;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import com.exception.InvalidNameException;
import com.service.VendorService;

public class VendorTest {
	
	VendorService vendorService = new VendorService();

	@Test 
	public void getById()
	{
		int vid=2;
		try {
			vendorService.getById(vid);
		}
		catch(SQLException e)
		{
			Assert.assertEquals("Invalid id".toLowerCase(), e.getMessage());
		}
		
		vid=6;
		try {
			vendorService.getById(vid);
		}
		catch(SQLException e)
		{
			Assert.assertEquals("Invalid id".toLowerCase(), e.getMessage());
		}
		
	}
	
	@Test
	public void fetchAllLeaseTest()throws SQLException
	{
		//use case 1
		int id=8;
		vendorService.getByid(id);
		
		//use case 2
		id=13;
		vendorService.getByid(id);
	}
	
	@Test
	public void deleteTest() {
		int eid = 104;
		vendorService.delete(eid);

		eid = 504;
		vendorService.delete(eid);

	}
	
}
