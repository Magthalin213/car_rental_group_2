package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.VendorDaoImpl;
import com.dto.VendorDto;
import com.dto.VendorVehicleLeaseDto;
import com.model.Vendor;


public class VendorService {
	
	VendorDaoImpl vendorDaoImpl=new VendorDaoImpl();
	
	public List<VendorVehicleLeaseDto> getLeaseByVendor(int id, String status) throws SQLException {
		return vendorDaoImpl.getLeaseByVendor(id, status);
	}	
	
	public List<Vendor> listAll(){
		List<Vendor>list=vendorDaoImpl.listAll();
		return list;
	}
	
	
	public Vendor getById(int id) throws SQLException
	{
		return vendorDaoImpl.getById(id);
	}
	
	
	public void delete(int id)
	{
		vendorDaoImpl.delete(id);
	}
	
	
	public List<VendorDto> getByid(int vuid) throws SQLException {
		List<VendorDto>l=vendorDaoImpl.getByid(vuid);
		return l;
	}
	
	
	public void update(int vid,String vlastName)
	{
		vendorDaoImpl.update(vid,vlastName);
	}
}
