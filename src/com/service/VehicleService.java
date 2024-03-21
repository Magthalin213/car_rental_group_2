package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.VehicleDaoImpl;
import com.model.Vehicle;

public class VehicleService {

private VehicleDaoImpl vehicleDaoImpl = new VehicleDaoImpl();
	
	public List<Vehicle> getVehicleById(String str) throws SQLException {	 
		return vehicleDaoImpl.getVehicleById(str);
	}
	public static void delete(int id1) {
		VehicleDaoImpl.delete(id1);
		
	}
	public List<Vehicle> getVehicles() throws SQLException {
		 
		return vehicleDaoImpl.getVehicles();
	}
	public static void insert(int id, String brandName, String model, int dr, String status, int pa, int ec,String np) throws SQLException {
		VehicleDaoImpl.insert(id,brandName,model,dr,status,pa,ec,np);
		
	}

}
