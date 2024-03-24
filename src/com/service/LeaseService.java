package com.service;

import com.model.Lease;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.dao.LeaseDao;
import com.dao.LeaseDaoImpl;
public class LeaseService {
	LeaseDao ld=new LeaseDaoImpl();
	public List<Lease> returnCar() throws SQLException {
		return ld.returnCar();
	}
	public Lease getLeaseById(int id) throws SQLException {
		return ld.getLeaseById(id);
	}
	public List<Lease> getActiveLease() throws SQLException {
		return ld.getActiveLease();
	}
	public void addLease(int vehicleId, int customerId, Date startDate, Date endDate,
			String selectedOption) throws SQLException {
		ld.addLease(vehicleId,customerId,startDate,endDate,selectedOption);
	}
	

}
