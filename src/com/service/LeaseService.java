package com.service;

import com.model.Lease;

import java.sql.SQLException;
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

}
