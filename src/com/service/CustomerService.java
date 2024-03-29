package com.service;

import java.sql.SQLException;

import java.util.List;

import com.dao.CustomerDaoImpl;
import com.dto.CustomerDto;
import com.dto.CustomerVehicleDto;
import com.exception.CustomerNotAvailableException;
import com.exception.InvalidNameException;
import com.model.Customer;
import com.model.Lease;


public class CustomerService {
	CustomerDaoImpl customerDaoImpl=new CustomerDaoImpl();
	

	public List<CustomerVehicleDto> fetchRecord() throws SQLException {
		List<CustomerVehicleDto>lists=customerDaoImpl.fetchRecord();
		return lists;
	}
	
	public List<Customer> fetchAll(){
		List<Customer>list=customerDaoImpl.fetchAll();
		return list;
	}
	
	public Customer getByName(String firstName) throws SQLException,InvalidNameException{
		return customerDaoImpl.getByName(firstName);
	}
	
	public void delete(int id)throws SQLException
	{
		customerDaoImpl.delete(id);
	}
	public List<CustomerDto> getById(int cuid) throws SQLException {
		List<CustomerDto>l=customerDaoImpl.getById(cuid);
		return l;
	}
	public void update(int cid,String clastName)throws SQLException,CustomerNotAvailableException
	{
		customerDaoImpl.update(cid,clastName);
	}
	public List<CustomerVehicleDto> fetchDet(int id1){
		List<CustomerVehicleDto>list1=customerDaoImpl.fetchDet(id1);
		return list1;
	}

}
