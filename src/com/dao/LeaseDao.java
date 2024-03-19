package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Lease;

public interface LeaseDao {
	
	public List<Lease> returnCar() throws SQLException;

	public Lease getLeaseById(int id) throws SQLException;


}
