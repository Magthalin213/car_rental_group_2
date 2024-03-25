package com.dao;

import java.sql.Date;
import java.sql.SQLException;

import java.time.LocalDate;
import java.util.List;
import com.model.Lease;

public interface LeaseDao {

	public List<Lease> returnCar() throws SQLException;

	public Lease getLeaseById(int id) throws SQLException;

	public List<Lease> getActiveLease() throws SQLException;

	public void addLease(int vehicleId, int customerId, Date startDate, Date endDate, String selectedOption)
			throws SQLException;

	public List<Lease> getTotalVehicleBooking(int vId) throws SQLException;

	public void vehicleStatusUpdate(int vehicleid) throws SQLException;

}
