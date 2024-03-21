package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Vehicle;
import com.util.DBUtil;


public class VehicleDaoImpl {
	public List<Vehicle> getVehicles() throws SQLException {
		List<Vehicle> list = new ArrayList<>();
		Connection conn = DBUtil.getDBConn();
		/* Step 1: Prepare the statement */
		String sql="select * from vehicle";
		PreparedStatement pstmt = conn.prepareStatement(sql);	
		/* execute the statement */
		ResultSet rst= pstmt.executeQuery();
		/* iterate over the result set and read DB column*/
		while(rst.next()) {
			int id = rst.getInt("id");
			String brandName = rst.getString("make");
			String model = rst.getString("model");
			int dailyRate = rst.getInt("daily_rate");
			String status = rst.getString("status");
			int passengerCapacity = rst.getInt("passenger_capacity");
			int engineCapacity = rst.getInt("engine_capacity");
			String numberPlate=rst.getString("number_plate");
			
			Vehicle vehicle = new Vehicle (id,brandName,model,dailyRate,status,passengerCapacity,engineCapacity,numberPlate);
			 
			list.add(vehicle);
		}
		DBUtil.dbClose();
		return list;
	}

	public List<Vehicle> getVehicleById(String str) throws SQLException {
		List<Vehicle> list = new ArrayList<>();
		Connection conn = DBUtil.getDBConn();
		/* Step 1: Prepare the statement */
		String sql="select * from vehicle where status=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		/* Attach the value of param ? */
		pstmt.setString(1, str);
		/* execute the statement */
		ResultSet rst= pstmt.executeQuery();
		/* iterate over the result set and read DB column*/
		if(rst.next()) { //if id is present in the DB, I vl give venue obj else will throw NPE
			int vid = rst.getInt("id");
			String brandName = rst.getString("make");
			String model = rst.getString("model");
			//Year year = rst.getYear("year");
			int dailyRate = rst.getInt("daily_rate");
			String status = rst.getString("status");
			int passengerCapacity = rst.getInt("passenger_capacity");
			int engineCapacity = rst.getInt("engine_Capacity");
			String numberPlate=rst.getString("number_plate");
			//save it in an object
			Vehicle vehicle = new Vehicle (vid, brandName,model, dailyRate, status, passengerCapacity, engineCapacity,numberPlate);
			list.add(vehicle);
			return list;
		}
		DBUtil.dbClose();
		throw new NullPointerException("Invalid Status...");
	}

	public static void delete(int id1) {
		Connection conn = DBUtil.getDBConn();
		String sql="delete from vehicle where id=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id1);
			pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		DBUtil.dbClose();
		// TODO Auto-generated method stub
		
	}

	public static void insert(int id, String brandName, String model, int dr, String status, int pa, int ec,String np) throws SQLException {
		Connection conn = DBUtil.getDBConn();
		String sql="INSERT INTO vehicle (id, make, model, daily_rate, status, passenger_capacity, engine_capacity,number_plate) VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.setString(2, brandName);
		pstmt.setString(3,model);
		pstmt.setInt(4,dr);
		pstmt.setString(5, status);
		pstmt.setInt(6, pa);
		pstmt.setInt(7,ec);
		pstmt.setString(8, np);
		
		pstmt.executeUpdate();
		DBUtil.dbClose();
		
		System.out.println("*****RECORD ADDED*****");
		
	
		
	}

	

}
