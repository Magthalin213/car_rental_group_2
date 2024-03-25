package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import com.model.Lease;
import com.util.DBUtil;

public class LeaseDaoImpl implements LeaseDao {
	@Override
	public List<Lease> returnCar() throws SQLException {
		List<Lease> list = new ArrayList<>();
		Connection conn = DBUtil.getDBConn();
		String sql = "select * from lease";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		while (rst.next()) {
			int id = rst.getInt("id");
			int vid = rst.getInt("vehicle_id");
			int cid = rst.getInt("customer_id");
			LocalDate start = rst.getDate("start_date").toLocalDate();
			LocalDate end = rst.getDate("end_date").toLocalDate();
			String type = rst.getString("type");
			Lease lease = new Lease(id, vid, cid, start, end, type);
			list.add(lease);
		}
		DBUtil.dbClose();
		return list;
	}

	@Override
	public Lease getLeaseById(int id) throws SQLException {
		Connection conn = DBUtil.getDBConn();
		String sql = "select * from lease where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		// Attach the value of parameter ?
		pstmt.setInt(1, id);
		// execute the statement
		ResultSet rst = pstmt.executeQuery();
		// iterate over the result set and read the DB column
		if (rst.next()) { // if id is present in the DB
			int lid = rst.getInt("id");
			int vid = rst.getInt("vehicle_id");
			int cid = rst.getInt("customer_id");
			LocalDate start = rst.getDate("start_date").toLocalDate();
			LocalDate end = rst.getDate("end_date").toLocalDate();
			String type = rst.getString("type");
			Lease lease = new Lease(lid, vid, cid, start, end, type);
			// save it in object
			return lease;
		}
		DBUtil.dbClose();
		throw new NullPointerException("Invalid ID Given");
	}

	public List<Lease> getActiveLease() throws SQLException {
		Connection conn = DBUtil.getDBConn();
		List<Lease> list = new ArrayList<>();
		String sql = "SELECT * " + "FROM lease " + "WHERE start_date <= CURDATE() " + "AND end_date >= CURDATE()";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();

		while (rst.next()) {
			int id = rst.getInt("id");
			int vid = rst.getInt("vehicle_id");
			int cid = rst.getInt("customer_id");
			LocalDate start = rst.getDate("start_date").toLocalDate();
			LocalDate end = rst.getDate("end_date").toLocalDate();
			String type = rst.getString("type");
			Lease lease = new Lease(id, vid, cid, start, end, type);
			list.add(lease);
		}
		DBUtil.dbClose();
		return list;
	}

	public void addLease(int vehicleId, int customerId, Date startDate, Date endDate, String selectedOption)
			throws SQLException {
		Connection conn = DBUtil.getDBConn();
		String sql = "INSERT INTO lease(vehicle_id, customer_id, start_date, end_date, type) VALUES(?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, vehicleId);
		pstmt.setInt(2, customerId);
		pstmt.setDate(3, startDate);
		pstmt.setDate(4, endDate);
		pstmt.setString(5, selectedOption);
		int changes = pstmt.executeUpdate();
		if (changes == 0)
			System.out.println("Error....No updates have been done");
		else
			System.out.println("New Lease has been Updated succesfully...");
		DBUtil.dbClose();

	}

	@Override
	public void vehicleStatusUpdate(int vehicleid) throws SQLException {
		Connection conn = DBUtil.getDBConn();
		String sql = "update vehicle v " + "join lease l on l.vehicle_id = v.id " + "set v.status=\"notAvailable\" "
				+ "where vehicle_id=? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, vehicleid);
		int changes = pstmt.executeUpdate();
		if (changes == 0)
			System.out.println("Error....No updates have been done");
		else
			System.out.println("Vehicle status has been Updated succesfully...");
		DBUtil.dbClose();
	}

	@Override
	public List<Lease> getTotalVehicleBooking(int vId) throws SQLException {
		Connection conn = DBUtil.getDBConn();
		List<Lease> list = new ArrayList<>();
		String sql = "SELECT * " + "FROM lease l " + "WHERE vehicle_id=? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, vId);
		ResultSet rst = pstmt.executeQuery();
		while (rst.next()) {
			int id = rst.getInt("id");
			int vid = rst.getInt("vehicle_id");
			int cid = rst.getInt("customer_id");
			LocalDate start = rst.getDate("start_date").toLocalDate();
			LocalDate end = rst.getDate("end_date").toLocalDate();
			String type = rst.getString("type");
			Lease lease = new Lease(id, vid, cid, start, end, type);
			list.add(lease);
		}
		DBUtil.dbClose();
		return list;

	}
}
