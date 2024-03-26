package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.dto.VendorDto;
import com.dto.VendorVehicleLeaseDto;
import com.model.Vendor;
import com.util.DBUtil;

public class VendorDaoImpl {

	
	public List<VendorVehicleLeaseDto> getLeaseByVendor(int id, String status) throws SQLException {
		Connection conn = DBUtil.getDBConn();
		List<VendorVehicleLeaseDto>l=new ArrayList<>();
		
		String sql="select l.id,l.vehicle_id, l.customer_id, l.start_date, l.end_date, l.type, v.id, ve.status "
				+ "from vendor v join vehicle ve on v.vehicle_id= ve.id join lease l on ve.id= l.vehicle_id "
				+ "where v.id=? " 
				+ "AND ve.status=? "
				+ "AND end_date>=CURDATE()";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.setString(2, status);
		ResultSet rst=pstmt.executeQuery();
		if(rst.next())
		{	
			int lid=rst.getInt("id");
			int vid=rst.getInt("id");
			int cid=rst.getInt("id");
			LocalDate startDate=rst.getDate("start_date").toLocalDate();
			LocalDate endDate=rst.getDate("end_date").toLocalDate();
			String type=rst.getString("type");
			int vendorId=rst.getInt("id");
			String vehicleStatus=rst.getString("status");
			
			VendorVehicleLeaseDto d=new VendorVehicleLeaseDto(lid,vid,cid,startDate, endDate, type, vendorId,vehicleStatus);
		    
			d.setId(lid);
		    d.setVehicleId(vid);
		    d.setCustomerId(cid);
		    d.setStartDate(startDate);
		    d.setEndDate(endDate);   
		    d.setType(type);
		    d.setVendorId(vendorId);
			d.setStatus(vehicleStatus);
			l.add(d);
		}
		DBUtil.dbClose();
		return l;
	}

	public List<Vendor> listAll()
	{
		Connection conn = DBUtil.getDBConn();
		List<Vendor>list=new ArrayList<>();
		String sql="select * from vendor";
		
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			ResultSet rst=pstmt.executeQuery();
			while(rst.next())
			{
				int id=rst.getInt("id");
				int vcid=rst.getInt("vehicle_id");
				String firstName=rst.getString("first_name");
				String lastName=rst.getString("last_name");
				String email=rst.getString("email");
				String phoneNumber=rst.getString("phone_number");
				String userName=rst.getString("user_name");
				String password=rst.getString("password");
				
				Vendor m=new Vendor();
				m.setId(id);
				m.setVehicleId(vcid);
				m.setFirstName(firstName);
				m.setLastName(lastName);
				m.setEmail(email);
				m.setPhoneNumber(phoneNumber);
				m.setUserName(userName);
				m.setPassword(password);
				list.add(m);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		DBUtil.dbClose();
		return list;
	}
	
	public Vendor getById(int id) throws SQLException 
	{
		 Connection conn = DBUtil.getDBConn();
		String sql="select * from vendor where id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet rst=pstmt.executeQuery();
		if(rst.next())
		{
			int vid=rst.getInt("id");
			int vcid=rst.getInt("vehicle_id");
			String firstName=rst.getString("first_name");
			String lastName=rst.getString("last_name");
			String email=rst.getString("email");
			String phoneNumber=rst.getString("phone_number");
			String userName=rst.getString("user_name");
			String password=rst.getString("password");
		
			Vendor m=new Vendor();
			m.setId(vid);
			m.setVehicleId(vcid);
			m.setFirstName(firstName);
			m.setLastName(lastName);
			m.setEmail(email);
			m.setPhoneNumber(phoneNumber);
			m.setUserName(userName);
			m.setPassword(password);
			return m;
		}
		DBUtil.dbClose();
		 throw new NullPointerException("Invalid Name given");
	}
	
	public void delete(int id)
	{
		Connection conn = DBUtil.getDBConn();
		String sql="delete from vendor where id=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		DBUtil.dbClose();
	}
	
	public List<VendorDto> getByid(int vuid) throws SQLException 
	{
		 Connection conn = DBUtil.getDBConn();
		 List<VendorDto>l=new ArrayList<>();
		 String sql="select v.id, v.first_name, v.last_name, v.email, v.phone_number,"
				+ "l.vehicle_id,l.start_date,l.end_date,l.type "
				+ "from vendor v join lease l on l.vehicle_id= v.vehicle_id "
				+ "where v.id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, vuid);
		ResultSet rst=pstmt.executeQuery();
		if(rst.next())
		{	
			String firstName=rst.getString("first_name");
			String lastName=rst.getString("last_name");
			String email=rst.getString("email");
			String phoneNumber=rst.getString("phone_number");
			int  vechicleId=rst.getInt("vehicle_id");
			LocalDate startDate=rst.getDate("start_date").toLocalDate();
			LocalDate endDate=rst.getDate("end_date").toLocalDate();
			String type=rst.getString("type");

			VendorDto d=new VendorDto();
		    
		    d.setFirstName(firstName);
		    d.setLastName(lastName);
		    d.setEmail(email);
		    d.setPhoneNumber(phoneNumber);
		    d.setVehicleId(vechicleId);   
		    d.setStartDate(startDate);
		    d.setEndDate(endDate);
			d.setType(type);
			l.add(d);
		}
		DBUtil.dbClose();
		 return l;
	}
	
	public void update(int vid,String vfastName)
	{
		Connection conn = DBUtil.getDBConn();
		String sql="update vendor SET first_name=? where id=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vfastName);
			pstmt.setInt(2, vid);
			pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		DBUtil.dbClose();
	}
}
