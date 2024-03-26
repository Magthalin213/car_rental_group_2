
package com.test;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import com.exception.InvalidNameException;
import com.model.Customer;
import com.service.CustomerService;

public class CustomerTest {
	CustomerService customerService = new CustomerService();

	@Test
	public void deleteTest() {
		int eid = 104;
		try // use case 1:
		{
			customerService.delete(eid);
		} catch (SQLException e) {
			Assert.assertEquals("Customer not found".toLowerCase(), e.getMessage());
		}

		eid = 504;
		try // use case 1:
		{
			customerService.delete(eid);
		} catch (SQLException e) {
			Assert.assertEquals("Customer not found".toLowerCase(), e.getMessage());
		}

	}
	@Test
	public void getByNameTest() throws InvalidNameException
	{
		//use case 1
		String firstName="Aadhya";
		try {
			customerService.getByName(firstName);
		}
		catch(SQLException e)
		{
			Assert.assertEquals("Invalid name".toLowerCase(), e.getMessage());
		}
		
		
	}
	@Test 
	public void getById()
	{
		int cuid=101;
		try {
			customerService.getById(cuid);
		}
		catch(SQLException e)
		{
			Assert.assertEquals("Invalid id".toLowerCase(), e.getMessage());
		}
		cuid=141;
		try {
			customerService.getById(cuid);
		}
		catch(SQLException e)
		{
			Assert.assertEquals("Invalid id".toLowerCase(), e.getMessage());
		}
		
	}
	@Test
	public void fetchDet()throws SQLException
	{//use case 1
		int id1=104;
		customerService.fetchDet(id1);
		//use case 2
		id1=141;
		customerService.fetchDet(id1);
	}
}
