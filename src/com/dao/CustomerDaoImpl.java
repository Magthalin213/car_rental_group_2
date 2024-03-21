
	package com.dao;

	import java.sql.Connection;

	import java.time.LocalDate;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dto.CustomerDto;
import com.model.Customer;
import com.model.Lease;
import com.util.DBUtil;

	public class CustomerDaoImpl {
		DBUtil db=new DBUtil();
		Connection conn;
		public void signUp(int id,String firstName,String lastName,String email,
				String phoneNumber,String userName,String password)throws SQLException
		{
			conn=db.getDBConn();
		String sql="insert into customer values(?,?,?,?,?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.setString(2,firstName);
		pstmt.setString(3,lastName);
		pstmt.setString(4,email);
		pstmt.setString(5,phoneNumber);
		pstmt.setString(6,userName);
		pstmt.setString(7,password);
		
		pstmt.executeUpdate();
		db.dbClose();
		}
		public List<Customer> fetchAll()
		{
			conn=db.getDBConn();
			List<Customer>list=new ArrayList<>();
			String sql="select * from customer";
			try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			ResultSet rst=pstmt.executeQuery();
			while(rst.next())
			{
				int id=rst.getInt("id");
				String firstName=rst.getString("first_name");
				String lastName=rst.getString("last_name");
				String email=rst.getString("email");
				String phoneNumber=rst.getString("phone_number");
				String userName=rst.getString("user_name");
				String password=rst.getString("password");
				Customer m=new Customer();
				m.setId(id);
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
			db.dbClose();
			return list;
		}
		
		public Customer getByName(String firstName) throws SQLException {
			 conn=db.getDBConn();
			String sql="select * from customer where first_name=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, firstName);
			ResultSet rst=pstmt.executeQuery();
			if(rst.next())
			{
				int id=rst.getInt("id");
				String mfirstName=rst.getString("first_name");
				String lastName=rst.getString("last_name");
				String email=rst.getString("email");
				String phoneNumber=rst.getString("phone_number");
				String userName=rst.getString("user_name");
				String password=rst.getString("password");
				//save to obj
				Customer m=new Customer();
				m.setId(id);
				m.setFirstName(firstName);
				m.setLastName(lastName);
				m.setEmail(email);
				m.setPhoneNumber(phoneNumber);
				m.setUserName(userName);
				m.setPassword(password);
				return m;
			}
			db.dbClose();
			 throw new NullPointerException("Invalid Name given");
		
		}
		public void delete(int id)
		{
			conn=db.getDBConn();
			String sql="delete from customer where id=?";
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				pstmt.executeUpdate();
			}
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
			db.dbClose();
		}
		public List<CustomerDto> getById(int cuid) throws SQLException {
			 conn=db.getDBConn();
			 List<CustomerDto>l=new ArrayList<>();
			String sql="select c.id,c.first_name,c.last_name,c.email,c.phone_number,"
					+ "l.vehicle_id,l.start_date,l.end_date,l.type "
					+ "from customer c join lease l on l.customer_id=c.id "
					+ "where c.id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, cuid);
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
				//save to obj
				CustomerDto d=new CustomerDto();
			    
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
			db.dbClose();
			 return l;
		
		}
		public void update(int cid,String clastName)
		{
			conn=db.getDBConn();
		String sql="update customer SET last_name=? where id=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, clastName);
			pstmt.setInt(2, cid);
			pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		db.dbClose();
	}
	}


