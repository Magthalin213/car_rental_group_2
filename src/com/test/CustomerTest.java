package com.test;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import com.service.CustomerService;

public class CustomerTest {
	CustomerService customerService = new CustomerService();

	@Test
	public void deleteTest() {
		int eid = 504;
		try // use case 1:
		{
			customerService.delete(eid);
		} catch (SQLException e) {
			Assert.assertEquals("Customer not found".toLowerCase(), e.getMessage());
		}

	}

}
