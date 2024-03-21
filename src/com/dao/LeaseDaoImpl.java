package com.dao;

import java.sql.Connection;

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
		List<Lease> list = new ArrayList<>();
		Connection conn = DBUtil.getDBConn();
		String sql = "SELECT l.* "
				+ "FROM lease l "
				+ "JOIN vehicle v ON l.vehicle_id = v.id "
				+ "WHERE v.status = 'notAvailable'";
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

}
