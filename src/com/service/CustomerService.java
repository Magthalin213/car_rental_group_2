package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.CustomerDaoImpl;
import com.dto.CustomerDto;
import com.model.Customer;
import com.model.Lease;


public class CustomerService {
	CustomerDaoImpl customerDaoImpl=new CustomerDaoImpl();
	public void signUp(int id,String firstName,String lastName,String email,
			String phoneNumber,String userName,String password)throws SQLException
	{
		customerDaoImpl.signUp(id,firstName,lastName,email,
				phoneNumber,userName, password);
	}
	public List<Customer> fetchAll(){
		List<Customer>list=customerDaoImpl.fetchAll();
		return list;
	}
	
	public Customer getByName(String firstName) throws SQLException {
		return customerDaoImpl.getByName(firstName);
	}
	
	public void delete(int id)
	{
		customerDaoImpl.delete(id);
	}
	public List<CustomerDto> getById(int cuid) throws SQLException {
		List<CustomerDto>l=customerDaoImpl.getById(cuid);
		return l;
	}
	public void update(int cid,String clastName)
	{
		customerDaoImpl.update(cid,clastName);
	}
}
